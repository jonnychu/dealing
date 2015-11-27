package com.example.dealingapp.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ProgressMonitorExample extends JPanel implements ActionListener {
	static ProgressMonitor pbar;
	static int counter = 0;

	public ProgressMonitorExample() {
		super(true);
		pbar = new ProgressMonitor(this, "Monitoring Progress", "Initializing . . .", 0, 100);
		// Fire a timer every once in a while to update the progress
		Timer timer = new Timer(500, this);
		timer.start();
	}

	public static void main(String args[]) {
		new ProgressMonitorExample();
	}

	public void actionPerformed(ActionEvent e) {
		// Invoked by the timer every half second. Simply place
		// the progress monitor update on the event queue.
		SwingUtilities.invokeLater(new Update());
	}

	class Update implements Runnable {
		public void run() {
			if (pbar.isCanceled()) {
				pbar.close();
				System.exit(1);
			}
			pbar.setProgress(counter);
			pbar.setNote("Operation is " + counter + "% complete");
			counter += 2;
		}
	}
}