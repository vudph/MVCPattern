package com.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.controllers.Controller;
import com.models.Model;

public class View extends JPanel implements Observer {
	public final static String DECREASE = "<";
	public final static String INCREASE = ">";
	public final static String SET_STATION = "Set";

	private Model model;
	
	private JProgressBar progressBar;
	private JButton decreaseVolumeButton;
	private JButton increaseVolumeButton;
	private JTextField stationTextField;
	private JButton setStationButton;

	public View(Model model) {
		this.model = model;

		Font commonFontForUILabels = new Font("Serif", Font.BOLD, 18);
		JLabel titleLabel = new JLabel("Radio Tuner", JLabel.CENTER);
		titleLabel.setFont(commonFontForUILabels);
		JLabel stationLabel = new JLabel("Station:");
		stationLabel.setFont(commonFontForUILabels);
		progressBar = new JProgressBar(model.MIN_VOLUME,model.MAX_VOLUME);
		progressBar.setStringPainted(true);
		decreaseVolumeButton = new JButton(DECREASE);
		increaseVolumeButton = new JButton(INCREASE);
		stationTextField = new JTextField(5);
		setStationButton = new JButton(SET_STATION);

		// Set up UI
		setLayout(new BorderLayout());
		JPanel southSide = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		southSide.add(stationLabel);
		southSide.add(stationTextField);
		southSide.add(setStationButton);
		add(decreaseVolumeButton,BorderLayout.WEST);
		add(increaseVolumeButton,BorderLayout.EAST);
		add(titleLabel,BorderLayout.NORTH);
		add(progressBar,BorderLayout.CENTER);
		add(southSide,BorderLayout.SOUTH);

		// Connect the components.
		// View is an observer of model.
		// If the state of the model changes, the view will likely need updating.
		model.addObserver(this);

		Controller controller = new Controller(model, this);
		addController(controller);

		// update the view based on the current state of the model
		refreshView(); 
	}

	public void addController(ActionListener controller){
		decreaseVolumeButton.removeActionListener(controller);
		increaseVolumeButton.removeActionListener(controller);
		setStationButton.removeActionListener(controller);
		
		decreaseVolumeButton.addActionListener(controller);
		increaseVolumeButton.addActionListener(controller);		
		setStationButton.addActionListener(controller);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		refreshView();
	}

	private void refreshView() {
		progressBar.setValue(model.getVolume());
		stationTextField.setText(model.getStation());
	}

	public String getStation() {
		return stationTextField.getText();
	}
}
