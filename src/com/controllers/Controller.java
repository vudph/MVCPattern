package com.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.models.Model;
import com.views.View;

public class Controller implements ActionListener {
	protected Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		if (command.equals(View.INCREASE))
			model.increaseVolume();
		else if (command.equals(View.DECREASE))
			model.decreaseVolume();
		else if (command.equals(View.SET_STATION)) {
			model.setStation(view.getStation());
		}
	}

}
