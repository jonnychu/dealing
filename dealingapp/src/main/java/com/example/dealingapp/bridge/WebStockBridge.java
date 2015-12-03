package com.example.dealingapp.bridge;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.ConnPoolControl;

public class WebStockBridge extends Timer{

	protected XHttpClient client;

	public WebStockBridge() {
		client = new XHttpClient();
	}

	public void doStart(URI uri,ResponseListener listener){
		
		final HttpGet request = client.createHttpGet(uri, 0);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					client.execute(request,listener);
				} catch (IOException e) {e.printStackTrace();}
			}
		}, 1000,1000);
	}
	
	protected class XHttpClient {

		protected HttpClient httpClient;
		protected int maxConnections = 16;
		protected int maxHeaderCount = 128;
		protected int maxLineLength = 2048;
		protected String chartSet = "UTF-8";
		protected boolean tcpNoDelay = true;
		protected int maxConnectionsPerRoute = 2;
		protected volatile long defaultTimeout = 5000L;
		protected ConnPoolControl<HttpRoute> connPoolControl = null;

		public XHttpClient() {
			if (this.httpClient == null)
				this.httpClient = createHttpClient();
		}

		private HttpClient createHttpClient() {
			//
			final SocketConfig sc = SocketConfig.custom().setTcpNoDelay(this.tcpNoDelay).build();

			//
			final MessageConstraints mc = MessageConstraints.custom().setMaxHeaderCount(this.maxHeaderCount)
					.setMaxLineLength(this.maxLineLength).build();

			//
			final ConnectionConfig cc = ConnectionConfig.custom().setCharset(Charset.forName(this.chartSet))
					.setMessageConstraints(mc).build();

			//
			final PoolingHttpClientConnectionManager r = new PoolingHttpClientConnectionManager();
			r.setDefaultSocketConfig(sc);
			r.setDefaultConnectionConfig(cc);
			r.setMaxTotal(this.maxConnections);
			r.setDefaultMaxPerRoute(this.maxConnectionsPerRoute);

			//
			this.connPoolControl = r;
			return HttpClients.custom().setConnectionManager(r).build();
		}

		protected HttpGet createHttpGet(URI uri, int timeout) {
			//
			final RequestConfig.Builder rc = RequestConfig.custom();
			rc.setSocketTimeout(timeout > 0 ? timeout : (int) this.defaultTimeout);
			rc.setConnectTimeout(timeout > 0 ? timeout : (int) this.defaultTimeout);
			rc.setConnectionRequestTimeout(timeout > 0 ? timeout : (int) this.defaultTimeout);

			//
			final HttpGet r = new HttpGet(uri);
			r.setConfig(rc.build());
			return r;
		}

		@SuppressWarnings("unchecked")
		public void execute(HttpUriRequest request, ResponseListener listener) throws IOException {
			this.httpClient.execute(request, new MyResponseHandler(listener));
		}
	}

	@SuppressWarnings("rawtypes")
	protected class MyResponseHandler implements ResponseHandler {

		private transient ResponseListener listener;

		public MyResponseHandler(ResponseListener listener) {
			this.listener = listener;
		}

		@Override
		public Object handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			this.listener.receive(IOUtils.toString(response.getEntity().getContent(),"gb2312"));
			return response;
		}
	}

	public interface ResponseListener {
		void receive(String resData);
	}
}
