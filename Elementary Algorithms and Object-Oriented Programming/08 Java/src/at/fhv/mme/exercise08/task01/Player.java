package at.fhv.mme.exercise08.task01;

import java.util.LinkedList;

public class Player {
	private String _name;
	private Field _field;
	private LinkedList<Item> _items;
	
	public Player(String name, Field field) {
		_name = name;
		_field = field;
		_items = new LinkedList<>();
	}
	
	public void setField(Field field) {
		_field = field;
	}
	
	public String getName() {
		return _name;
	}

	public Field getField() {
		return _field;
	}
	
	public LinkedList getItems() {
		return _items;
	}
	
	public void takeItem(Item item) {
		_items.add(item);
		System.out.println("You picked up the item '" + item.getName() + "'.");
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
	
	public boolean placeItem(String itemName) {
		for (Item item : _items) {
			if (item.getName().equals(itemName)) {
				if (!(item instanceof Key)) {
					_field.getItems().add(item);
					removeItem(itemName);
					System.out.println("You have placed the item '" + itemName + "' on this field.");
					
					return true;
				} else {
					System.out.println("You can't place a key. You should keep it, you may need it at some point.");
					
					return false;
				}
			}
		}
		
		System.out.println("You don't have item '" + itemName + "' in your inventory.");
		return false;
	}
	
	public boolean printInventory() {
		if (_items.size() > 0) {
			for (Item item : _items) {
				System.out.println("Items in your inventory:");
				System.out.println("Name: " + item.getName() + "; Description: " + item.getDescription());
			}
			
			return true;
		}
		
		System.out.println("Your inventory is currently empty.");
		return false;
	}
}