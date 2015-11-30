package com.example.dealingapp.mvc.plugin.picker;

import java.text.SimpleDateFormat;

import javax.swing.*;

import com.jgoodies.common.base.Preconditions;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author jonny
 */
@SuppressWarnings("serial")
public class DateTimePicker extends JPanel {

	private JFormattedTextField dateField;
	private JFormattedTextField TimeField;

	private SimpleDateFormat date;
	private SimpleDateFormat time;
	
	private final String defaultDateFormater="yyyy/MM/dd";
	private final String defaultTimeFormater="HH:mm:ss";

	public DateTimePicker() {
		initComponents(defaultDateFormater,defaultTimeFormater);
	}

	public DateTimePicker(String dateFormater, String timeFormater) {
		initComponents(dateFormater,timeFormater);
	}
	
	private void initComponents(String dateFormater, String timeFormater){
		Preconditions.checkNotBlank(dateFormater, "dateformater cannot be null");
		Preconditions.checkNotBlank(timeFormater, "timeFormater cannot be null");
		date = new SimpleDateFormat(dateFormater);
		time = new SimpleDateFormat(timeFormater);

		dateField = new JFormattedTextField(date);
		TimeField = new JFormattedTextField(time);

		setLayout(new FormLayout("pref:grow(0.6), pref:grow(0.4)", "pref:grow"));
		add(dateField, CC.xy(1, 1));
		add(TimeField, CC.xy(2, 1));
	}

	public void setDatetime(String date,String time){
		dateField.setText(date);
		if(!dateField.isEditValid()){
			dateField.setText(null);
		}
		TimeField.setText(time);
		if(!TimeField.isEditValid()){
			TimeField.setText(null);
		}
	}
	
	public String getDate(){
		return dateField.getText();
	}
	
	public String getTime(){
		return TimeField.getText();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Picker test");
		f.setSize(600, 400);
		DateTimePicker picker = new DateTimePicker();
		picker.setDatetime("2013-01/03", "08:01:01");
		f.setContentPane(picker);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
