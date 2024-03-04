package at.fhv.mme.exercise08.task01;

import java.util.ArrayList;

public class Wall extends Cell {
	private int _neighbourId;	// only neighbourId of the cell type "Field" nearby
	
	public Wall(int id, int neighbourId) {
		super(id);
		_neighbourId = neighbourId;
	}

	public int getNeighbourId() {
		return _neighbourId;
	}

	@Override
	public boolean enter(Player p, ArrayList map) {
		return false;
	}
}