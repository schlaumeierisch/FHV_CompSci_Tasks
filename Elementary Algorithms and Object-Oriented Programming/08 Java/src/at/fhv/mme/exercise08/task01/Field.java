package at.fhv.mme.exercise08.task01;

import java.util.ArrayList;
import java.util.LinkedList;

public class Field extends Cell {
	private int[] _neighbourIds;
	private LinkedList<Item> _items;
	
	public Field(int id, int neighbourIdNorth, int neighbourIdEast, int neighbourIdSouth, int neighbourIdWest) {
		super(id);
		
		_neighbourIds = new int[4];
		_neighbourIds[0] = neighbourIdNorth;
		_neighbourIds[1] = neighbourIdEast;
		_neighbourIds[2] = neighbourIdSouth;
		_neighbourIds[3] = neighbourIdWest;
		
		_items = new LinkedList<>();
	}
	
	public int[] getNeighbourIds() {
		return _neighbourIds;
	}
	
	public LinkedList<Item> getItems() {
		return _items;
	}

	public boolean isNeighbour(Field f, Cell c) {
		for (int i = 0; i < 4; i++) {
			if (f._neighbourIds[i] == c.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean enter(Player p, ArrayList map) {
		p.setField(this);
		System.out.println("You have now entered the room with the ID '" + this.getId() + "'.");
		return true;
	}
	
	public boolean availableItems() {
		if (_items.size() > 0) {
			System.out.println("Available items on this field:");
			
			for(Item item : _items) {
				System.out.println("Name: '" + item.getName() + "'; Description: '" + item.getDescription() + "'");
			}
			
			return true;
		}
		
		System.out.println("This field doesn't contain any items.");
		return false;
	}
	
	public boolean removeItem(String itemName) {
		for (Item item : _items) {
			if (item.getName().equals(itemName)) {
				_items.remove(item);
				
				return true;
			}
		}
		
		return false;
	}
}