package com.example.dealingapp.bridge;

import java.math.BigDecimal;
import java.util.Date;

public class StockProduct {
	
	private String stockCode;// 股票代码
	private String stockName;// 股票名字

	private BigDecimal openPriceToday;// 今日开盘价
	private BigDecimal closePriceYestoday;// 昨日收盘价
	private BigDecimal price;// 当前价格
	private BigDecimal highPriceToday;// 今日最高价
	private BigDecimal lowPriceToday;// 今日最低价

	private BigDecimal bidPrice;//竞买价，即“买一”报价
	private BigDecimal askPrice;//竞卖价，即“卖一”报价
	private BigDecimal turnVolume;//成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百
	private BigDecimal turnAmount;//成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万
	
	//买一 ~ 买五
	private BigDecimal bidVolum1;
	private BigDecimal bidPrice1;
	private BigDecimal bidVolum2;
	private BigDecimal bidPrice2;
	private BigDecimal bidVolum3;
	private BigDecimal bidPrice3;
	private BigDecimal bidVolum4;
	private BigDecimal bidPrice4;
	private BigDecimal bidVolum5;
	private BigDecimal bidPrice5;
	
	//卖一 ~ 卖五
	private BigDecimal askVolum1;
	private BigDecimal askPrice1;
	private BigDecimal askVolum2;
	private BigDecimal askPrice2;
	private BigDecimal askVolum3;
	private BigDecimal askPrice3;
	private BigDecimal askVolum4;
	private BigDecimal askPrice4;
	private BigDecimal askVolum5;
	private BigDecimal askPrice5;
	
	private Date updateDate;
	private Date updateTime;
	
	@Override
	public String toString() {
		StringBuffer message = new StringBuffer();
		message.append(stockCode)
		.append(",当前价格:").append(price)
		
		.append(",今日开盘价:").append(openPriceToday)
		.append(",昨日收盘价:").append(closePriceYestoday)
		.append(",今日最高价:").append(highPriceToday)
		.append(",今日最低价:").append(lowPriceToday);
		
		return message.toString();
	}
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public BigDecimal getOpenPriceToday() {
		return openPriceToday;
	}
	public void setOpenPriceToday(BigDecimal openPriceToday) {
		this.openPriceToday = openPriceToday;
	}
	public BigDecimal getClosePriceYestoday() {
		return closePriceYestoday;
	}
	public void setClosePriceYestoday(BigDecimal closePriceYestoday) {
		this.closePriceYestoday = closePriceYestoday;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getHighPriceToday() {
		return highPriceToday;
	}
	public void setHighPriceToday(BigDecimal highPriceToday) {
		this.highPriceToday = highPriceToday;
	}
	public BigDecimal getLowPriceToday() {
		return lowPriceToday;
	}
	public void setLowPriceToday(BigDecimal lowPriceToday) {
		this.lowPriceToday = lowPriceToday;
	}
	public BigDecimal getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}
	public BigDecimal getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(BigDecimal askPrice) {
		this.askPrice = askPrice;
	}
	public BigDecimal getTurnVolume() {
		return turnVolume;
	}
	public void setTurnVolume(BigDecimal turnVolume) {
		this.turnVolume = turnVolume;
	}
	public BigDecimal getTurnAmount() {
		return turnAmount;
	}
	public void setTurnAmount(BigDecimal turnAmount) {
		this.turnAmount = turnAmount;
	}
	public BigDecimal getBidVolum1() {
		return bidVolum1;
	}
	public void setBidVolum1(BigDecimal bidVolum1) {
		this.bidVolum1 = bidVolum1;
	}
	public BigDecimal getBidPrice1() {
		return bidPrice1;
	}
	public void setBidPrice1(BigDecimal bidPrice1) {
		this.bidPrice1 = bidPrice1;
	}
	public BigDecimal getBidVolum2() {
		return bidVolum2;
	}
	public void setBidVolum2(BigDecimal bidVolum2) {
		this.bidVolum2 = bidVolum2;
	}
	public BigDecimal getBidPrice2() {
		return bidPrice2;
	}
	public void setBidPrice2(BigDecimal bidPrice2) {
		this.bidPrice2 = bidPrice2;
	}
	public BigDecimal getBidVolum3() {
		return bidVolum3;
	}
	public void setBidVolum3(BigDecimal bidVolum3) {
		this.bidVolum3 = bidVolum3;
	}
	public BigDecimal getBidPrice3() {
		return bidPrice3;
	}
	public void setBidPrice3(BigDecimal bidPrice3) {
		this.bidPrice3 = bidPrice3;
	}
	public BigDecimal getBidVolum4() {
		return bidVolum4;
	}
	public void setBidVolum4(BigDecimal bidVolum4) {
		this.bidVolum4 = bidVolum4;
	}
	public BigDecimal getBidPrice4() {
		return bidPrice4;
	}
	public void setBidPrice4(BigDecimal bidPrice4) {
		this.bidPrice4 = bidPrice4;
	}
	public BigDecimal getBidVolum5() {
		return bidVolum5;
	}
	public void setBidVolum5(BigDecimal bidVolum5) {
		this.bidVolum5 = bidVolum5;
	}
	public BigDecimal getBidPrice5() {
		return bidPrice5;
	}
	public void setBidPrice5(BigDecimal bidPrice5) {
		this.bidPrice5 = bidPrice5;
	}
	public BigDecimal getAskVolum1() {
		return askVolum1;
	}
	public void setAskVolum1(BigDecimal askVolum1) {
		this.askVolum1 = askVolum1;
	}
	public BigDecimal getAskPrice1() {
		return askPrice1;
	}
	public void setAskPrice1(BigDecimal askPrice1) {
		this.askPrice1 = askPrice1;
	}
	public BigDecimal getAskVolum2() {
		return askVolum2;
	}
	public void setAskVolum2(BigDecimal askVolum2) {
		this.askVolum2 = askVolum2;
	}
	public BigDecimal getAskPrice2() {
		return askPrice2;
	}
	public void setAskPrice2(BigDecimal askPrice2) {
		this.askPrice2 = askPrice2;
	}
	public BigDecimal getAskVolum3() {
		return askVolum3;
	}
	public void setAskVolum3(BigDecimal askVolum3) {
		this.askVolum3 = askVolum3;
	}
	public BigDecimal getAskPrice3() {
		return askPrice3;
	}
	public void setAskPrice3(BigDecimal askPrice3) {
		this.askPrice3 = askPrice3;
	}
	public BigDecimal getAskVolum4() {
		return askVolum4;
	}
	public void setAskVolum4(BigDecimal askVolum4) {
		this.askVolum4 = askVolum4;
	}
	public BigDecimal getAskPrice4() {
		return askPrice4;
	}
	public void setAskPrice4(BigDecimal askPrice4) {
		this.askPrice4 = askPrice4;
	}
	public BigDecimal getAskVolum5() {
		return askVolum5;
	}
	public void setAskVolum5(BigDecimal askVolum5) {
		this.askVolum5 = askVolum5;
	}
	public BigDecimal getAskPrice5() {
		return askPrice5;
	}
	public void setAskPrice5(BigDecimal askPrice5) {
		this.askPrice5 = askPrice5;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
