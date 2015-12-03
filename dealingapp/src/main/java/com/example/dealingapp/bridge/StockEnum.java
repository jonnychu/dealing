package com.example.dealingapp.bridge;

public enum StockEnum {
	
	DQTL("sh601006","dqtl"),
	DSDC("sz000049","dsdc");
	
	private final static String preUrl="http://hq.sinajs.cn/list=";
	private String code;
	private String name;
	private StockEnum(String code,String name){
		this.code = code;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return preUrl+this.code;
	}
}
