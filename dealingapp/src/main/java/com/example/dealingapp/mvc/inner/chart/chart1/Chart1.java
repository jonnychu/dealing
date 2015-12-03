package com.example.dealingapp.mvc.inner.chart.chart1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

import com.example.dealingapp.bridge.Convert;
import com.example.dealingapp.bridge.StockEnum;
import com.example.dealingapp.bridge.StockProduct;
import com.example.dealingapp.bridge.WebStockBridge;
import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

public class Chart1 extends AbstractInnerFrame implements WebStockBridge.ResponseListener {

	private TimeSeries series;
	private TimeSeriesCollection seriesCollection;
	
	public Chart1(Context context) {
		super(context);
	}

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().debug(true).columns("$lcgap,fill:pref:grow,$lcgap,50dlu,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap").padding(Paddings.EMPTY);
	}

	@Override
	protected void initGUI(FormBuilder builder) {
		//
		series = new TimeSeries("Stock");
		seriesCollection = new TimeSeriesCollection();
		seriesCollection.addSeries(series);

		DateAxis dateaxis = new DateAxis("Time");
		dateaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
		dateaxis.setLabelFont(new Font("SansSerif", 0, 14));
		dateaxis.setAutoRange(true);
		dateaxis.setLowerMargin(0.0D);
		dateaxis.setUpperMargin(0.0D);
		dateaxis.setTickLabelsVisible(true);
		
		NumberAxis numberaxis = new NumberAxis("Price");
		numberaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
		numberaxis.setLabelFont(new Font("SansSerif", 0, 14));
		NumberFormat numFormat = NumberFormat.getNumberInstance();
		numFormat.setMinimumFractionDigits(2);
		numberaxis.setNumberFormatOverride(numFormat);

		XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);
		xylineandshaperenderer.setSeriesPaint(0, Color.RED);
		xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(1F, 0, 2));

		XYPlot xyplot = new XYPlot(seriesCollection, dateaxis, numberaxis, xylineandshaperenderer);
		xyplot.setBackgroundPaint(Color.BLACK);
		xyplot.setDomainGridlinePaint(Color.white);
		xyplot.setRangeGridlinePaint(Color.white);
		xyplot.setAxisOffset(new RectangleInsets(1D, 1D, 1D, 1D));
		
		XYTextAnnotation textpointer = new XYTextAnnotation("ddddd", 12, 15);
		textpointer.setBackgroundPaint(Color.YELLOW);
		textpointer.setPaint(Color.CYAN);
		xyplot.addAnnotation(textpointer);

		JFreeChart jfreechart = new JFreeChart(null, new Font("SansSerif", 1, 24), xyplot, true);
		jfreechart.setBackgroundPaint(Color.white);

		ChartPanel chartpanel = new ChartPanel(jfreechart, true);

		//
		JButton btnOk = ComponentFactory.XJButton.create("Add", "add", new ActionListener() {
			WebStockBridge bridge = new WebStockBridge();
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						try {
							bridge.doStart(new URI(StockEnum.DSDC.toString()), Chart1.this);
						} catch (URISyntaxException ex) {ex.printStackTrace();}
					}
				});
			}
		});
		JPanel btnPanel = FormBuilder.create().debug(true).columns("$lcgap,50dlu,$lcgap")
				.rows("$lcgap,20dlu,$lcgap,fill:pref,$lcgap").padding(Paddings.EMPTY).add(btnOk).xy(2, 2).build();

		//
		builder.add(chartpanel).xy(2, 2).add(btnPanel).xy(4, 2);
	}

	@Override
	protected void binder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receive(String resData) {
		StockProduct product = Convert.toStockProduct(resData);
		System.out.println(product);
		this.series.add(new Millisecond(), product.getPrice());
	}

}
