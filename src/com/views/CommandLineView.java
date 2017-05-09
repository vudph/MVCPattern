package com.views;

import java.util.Observable;
import java.util.Observer;

import com.models.Model;

public class CommandLineView implements Observer {
	private Model model;
	
	public CommandLineView(Model model) {
		this.model = model;
		model.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		int volume = model.getVolume();
		String station = model.getStation();
		System.out.println("Current volume: " + volume + "; Current station: " + station);
	}

}
