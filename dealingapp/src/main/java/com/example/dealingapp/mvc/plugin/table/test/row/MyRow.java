package com.example.dealingapp.mvc.plugin.table.test.row;

import java.math.BigDecimal;
import java.util.Date;

public class MyRow {

	private Boolean checkBox;
	private Integer image;
	private String jButton;
	private String jComboBox;
	private String mark;
	private BigDecimal money;
	private Integer progress;
	private Integer rowNum;
	private Integer spinner;
	private Date updateTime;
	
	public MyRow() {
		checkBox = new Boolean(false);
		jButton = "OK";
	}

	public Boolean getCheckBox() {
		return checkBox;
	}

	public Integer getImage() {
		return image;
	}

	public String getjButton() {
		return jButton;
	}

	public String getjComboBox() {
		return jComboBox;
	}

	public String getMark() {
		return mark;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public Integer getProgress() {
		return progress;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public Integer getSpinner() {
		return spinner;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setCheckBox(Boolean checkBox) {
		this.checkBox = checkBox;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	public void setjButton(String jButton) {
		this.jButton = jButton;
	}

	public void setjComboBox(String jComboBox) {
		this.jComboBox = jComboBox;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
	
	public void setSpinner(Integer spinner) {
		this.spinner = spinner;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
