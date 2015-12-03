package com.example.dealingapp.bridge;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class Convert {
	
	public static StockProduct toStockProduct(String webData){
		
		if(webData == null || webData.equals("var hq_str_sh00049=\"\";"))
			return null;
		
		String[] data = webData.replace("\"", "").split(",");
		
		StockProduct product = new StockProduct();
		
		product.setStockCode(data[0]);// 股票代码
		product.setStockName(data[0]);// 股票名字

		product.setOpenPriceToday(toBigDecimal(data[1]));// 今日开盘价
		product.setClosePriceYestoday(toBigDecimal(data[2]));// 昨日收盘价
		product.setPrice(toBigDecimal(data[3]));// 当前价格
		product.setHighPriceToday(toBigDecimal(data[4]));// 今日最高价
		product.setLowPriceToday(toBigDecimal(data[5]));// 今日最低价

		product.setBidPrice(toBigDecimal(data[6]));//竞买价，即“买一”报价
		product.setAskPrice(toBigDecimal(data[7]));//竞卖价，即“卖一”报价
		product.setTurnVolume(toBigDecimal(data[8]));//成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百
		product.setTurnAmount(toBigDecimal(data[9]));//成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万

		product.setBidVolum1(toBigDecimal(data[10]));
		product.setBidPrice1(toBigDecimal(data[11]));
		product.setBidVolum2(toBigDecimal(data[12]));
		product.setBidPrice2(toBigDecimal(data[13]));
		product.setBidVolum3(toBigDecimal(data[14]));
		product.setBidPrice3(toBigDecimal(data[15]));
		product.setBidVolum4(toBigDecimal(data[16]));
		product.setBidPrice4(toBigDecimal(data[17]));
		product.setBidVolum5(toBigDecimal(data[18]));
		product.setBidPrice5(toBigDecimal(data[19]));

		product.setAskVolum1(toBigDecimal(data[20]));
		product.setAskPrice1(toBigDecimal(data[21]));
		product.setAskVolum2(toBigDecimal(data[22]));
		product.setAskPrice2(toBigDecimal(data[23]));
		product.setAskVolum3(toBigDecimal(data[24]));
		product.setAskPrice3(toBigDecimal(data[25]));
		product.setAskVolum4(toBigDecimal(data[26]));
		product.setAskPrice4(toBigDecimal(data[27]));
		product.setAskVolum5(toBigDecimal(data[28]));
		product.setAskPrice5(toBigDecimal(data[29]));
		
//		product.setUpdateDate(updateDate);
//		product.setUpdateTime(updateTime);
		return product;
	}
	
	private static BigDecimal toBigDecimal(String s){
		if(s == null || s.equals(""))
			return null;
		return new BigDecimal(s.trim());
	}
	
	private static Date toDate(String s) {
		if (s == null || s.equals(""))
			return null;
		return null;
	}
	
	private static Time toTime(String s){
		if(s == null || s.equals(""))
			return null;
		return Time.valueOf(s);
	}
}
