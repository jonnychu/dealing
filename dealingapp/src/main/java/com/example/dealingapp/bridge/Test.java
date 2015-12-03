package com.example.dealingapp.bridge;

import java.net.URI;
import java.net.URISyntaxException;

public class Test implements WebStockBridge.ResponseListener{

	private Convert convert = new Convert();
	public static void main(String[] args) {
		WebStockBridge bridge = new WebStockBridge();
		try {
			bridge.doStart(new URI(StockEnum.DQTL.toString()), new Test());
		} catch (URISyntaxException e) {
		}

	}

	@Override
	public void receive(String resData) {
		StockProduct product = Convert.toStockProduct(resData);
		if(product == null){
			System.out.println("product is null");
		}else{
			System.out.println(product.toString());
		}
	}

}
