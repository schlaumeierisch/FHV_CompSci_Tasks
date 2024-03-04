package at.fhv.mme.exercise08.task01;

import java.util.ArrayList;
import java.util.LinkedList;

abstract class Cell {
	private int _id;
	private LinkedList<Item> _items;
	
	public Cell(int id) {
		_id = id;
		
		_items = new LinkedList<>();
	}
	
	public int getId() {
		return _id;
	}
	
	public abstract boolean enter(Player p, ArrayList map);
}