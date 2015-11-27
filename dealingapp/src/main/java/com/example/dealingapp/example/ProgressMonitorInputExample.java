package com.example.dealingapp.example;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ProgressMonitorInputStream;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProgressMonitorInputExample extends JPanel {
	
	public ProgressMonitorInputExample() {
		//
		JFileChooser dialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("",".*");
		dialog.setFileFilter(filter);
		File selectFile = null;
		int rValue = dialog.showOpenDialog(this);
		if(rValue == JFileChooser.APPROVE_OPTION){
			selectFile = dialog.getSelectedFile();
		}else{
			return;
		}
		
		//
		ProgressMonitorInputStream monitor;
		try {
			monitor = new ProgressMonitorInputStream(this, "Loading " + selectFile.getName(), new FileInputStream(selectFile));
			InputStream in = new BufferedInputStream(monitor);
			while (in.available() > 0) {
				byte[] data = new byte[38];
				in.read(data);
				System.out.write(data);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to find file: " + selectFile.getName(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
		}
	}

	public static void main(String args[]) {
		new ProgressMonitorInputExample();
	}
}
