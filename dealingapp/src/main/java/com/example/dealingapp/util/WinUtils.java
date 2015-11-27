package com.example.dealingapp.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jgoodies.looks.FontPolicies;
import com.jgoodies.looks.FontPolicy;
import com.jgoodies.looks.FontSet;
import com.jgoodies.looks.FontSets;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBluer;
import com.jgoodies.looks.windows.WindowsLookAndFeel;

/**
 *
 */
public class WinUtils {

	public static void windowCentral(Window window) {
		window.setLocationRelativeTo(null);
	}

	public static void printInstalledLAF() {
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			System.out.println("●" + info.getName() + ":\n" + info);
		}
	}

	private static void modifyFont(Component window, Font font) {
		window.setFont(font);
		if (window instanceof Container) {
			Container container = (Container) window;
			for (Component c : container.getComponents()) {
				modifyFont(c, font);
			}
		}
	}

	public static void setLAF() {
		//
		FontSet fontSet = FontSets.createDefaultFontSet(new Font("MV Boli", Font.PLAIN, 11), // control
				// font
				new Font("MV Boli", Font.PLAIN, 12), // menu font
				new Font("MV Boli", Font.BOLD, 11) // title font
		);
		FontPolicy fixedPolicy = FontPolicies.createFixedPolicy(fontSet);
		WindowsLookAndFeel.setFontPolicy(fixedPolicy);
		
		//
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			// UIManager.setLookAndFeel(new PlasticLookAndFeel());
			// UIManager.setLookAndFeel(new Plastic3DLookAndFeel ());
			// UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
		} catch (Exception e) {
		}
	}

}
