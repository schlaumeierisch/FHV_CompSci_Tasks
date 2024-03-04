package at.fhv.mme.exercise08.task01;

import java.util.ArrayList;
import java.util.LinkedList;

public class Door extends Cell {
	private int[] _neighbourIds;
	
	public Door(int id, int neighbourIdEast, int neighbourIdWest) {
		super(id);
		
		_neighbourIds = new int[2];
		_neighbourIds[0] = neighbourIdEast;
		_neighbourIds[1] = neighbourIdWest;
	}

	public int[] getNeighbourIds() {
		return _neighbourIds;
	}

	public boolean isNeighbour(Door d, Cell c) {
		for (int i = 0; i < 2; i++) {
			if (_neighbourIds[i] == c.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	
	@Override
	public boolean enter(Player p, ArrayList map) {
		LinkedList<Item> playerItems = p.getItems(); 
		
		for (Item item : playerItems) {
			if (item instanceof Key) {
				// check if the key is valid for this door
				if (((Key) item).getDoorId() == getId()) {
					if (p.getField().getId() == _neighbourIds[0]) {
						((Field) map.get(_neighbourIds[1])).enter(p, map);
					} else if (p.getField().getId() == _neighbourIds[1]) {
						((Field) map.get(_neighbourIds[0])).enter(p, map);
					}
					
					return true;
				}
			}
		}
		
		System.out.println("You don't have the key for this door.");
		return false;		
	}
}