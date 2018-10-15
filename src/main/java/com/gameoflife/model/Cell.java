package com.gameoflife.model;

public class Cell {

	private boolean state;
	private boolean newState;
	
	public Cell(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public void setNewState(boolean newState) {
		this.newState = newState;
	}
	
	public void updateState() {
		this.state = this.newState;
	}
	
	
}
