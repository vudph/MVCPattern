package com;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.models.Model;
import com.views.CommandLineView;
import com.views.View;

public class Radios {

	public static void main(String[] args) {
		// Setup dependencies
		Model model = new Model();
		View view = new View(model);

		CommandLineView textView = new CommandLineView(model);
		
		JFrame window = new JFrame("Radio Tuner");

		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		window.getContentPane().add(view);
		window.pack();
		window.setVisible(true);
	}

}
