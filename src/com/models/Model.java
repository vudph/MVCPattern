package com.models;

import java.util.Observable;

public class Model extends Observable {
	public final static int MIN_VOLUME = 0;
	public final static int MAX_VOLUME = 10;
	private int volume = 0;
	private String station = "89.3";

	public void increaseVolume() {
		volume++;
		setChanged();
		notifyObservers();
	}

	public void decreaseVolume() {
		volume--;
		setChanged();
		notifyObservers();
	}

	public int getVolume() {
		return volume;
	}

	public void setStation(String station) {
		this.station = station;
		setChanged();
		notifyObservers();
	}

	public String getStation() {
		return station;
	}
}
