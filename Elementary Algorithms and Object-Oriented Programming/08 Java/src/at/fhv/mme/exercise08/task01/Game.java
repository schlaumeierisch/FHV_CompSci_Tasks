package at.fhv.mme.exercise08.task01;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	private ArrayList <Cell>_map;
	private Player _player;
	
	public Game() {
		_map = new ArrayList<Cell>();
		
		// create fields
		_map.add(new Field(0, 12, 1, 3, 15));
		_map.add(new Field(1, 13, 10, 4, 0));
		_map.add(new Field(2, 14, 16, 19, 10));
		_map.add(new Field(3, 0, 4, 20, 17));
		_map.add(new Field(4, 1, 18, 5, 3));
		_map.add(new Field(5, 4, 21, 6, 20));
		_map.add(new Field(6, 5, 7, 26, 24));
		_map.add(new Field(7, 21, 8, 27, 6));
		_map.add(new Field(8, 22, 11, 28, 7));
		_map.add(new Field(9, 23, 25, 29, 11));
		
		// create doors
		_map.add(new Door(10, 1, 2));
		_map.add(new Door(11, 8, 9));
		
		// create walls
		_map.add(new Wall(12, 0));
		_map.add(new Wall(13, 1));
		_map.add(new Wall(14, 2));
		_map.add(new Wall(15, 0));
		_map.add(new Wall(16, 2));
		_map.add(new Wall(17, 3));
		_map.add(new Wall(18, 4));
		_map.add(new Wall(19, 2));
		_map.add(new Wall(20, 5));
		_map.add(new Wall(21, 5));
		_map.add(new Wall(22, 8));
		_map.add(new Wall(23, 9));
		_map.add(new Wall(24, 6));
		_map.add(new Wall(25, 9));
		_map.add(new Wall(26, 6));
		_map.add(new Wall(27, 7));
		_map.add(new Wall(28, 8));
		_map.add(new Wall(29, 9));
		
		// create items for different fields
		((Field) _map.get(0)).getItems().add(new Weapon("sword", "Beware, this is a very sharp sword!"));
		((Field) _map.get(0)).getItems().add(new Food("water", "Just the thing for a long journey."));
		((Field) _map.get(1)).getItems().add(new Key("key", "That's the key for the door with the ID 10.", 10));
		((Field) _map.get(1)).getItems().add(new Food("beer", "Something that (almost) every person likes very much."));
		((Field) _map.get(2)).getItems().add(new Weapon("hammer", "I wonder what you can do with it?"));
		((Field) _map.get(2)).getItems().add(new Food("beer", "Something that (almost) every person likes very much."));
		((Field) _map.get(3)).getItems().add(new Food("water", "Just the thing for a long journey."));
		((Field) _map.get(4)).getItems().add(new Food("bread", "A delicious little meal."));
		((Field) _map.get(5)).getItems().add(new Weapon("knife", "Better be careful with it!"));
		((Field) _map.get(6)).getItems().add(new Food("beer", "Something that (almost) every person likes very much."));
		((Field) _map.get(6)).getItems().add(new Food("water", "Just the thing for a long journey."));
		((Field) _map.get(7)).getItems().add(new Key("key", "That's the key for the door with the ID 11.", 11));
		
		// create player
		_player = new Player("Hercules", (Field) _map.get(0));
	}
	
	public ArrayList<Cell> getMap() {
		return _map;
	}

	public Player getPlayer() {
		return _player;
	}

	public boolean playerMovesTo(String direction) {
		int neighbourId;

		switch (direction) {
		case "north":
			neighbourId = 0;
			break;
		case "east":
			neighbourId = 1;
			break;
		case "south":
			neighbourId = 2;
			break;
		case "west":
			neighbourId = 3;
			break;
		default:
			neighbourId = -1;
			System.out.println("You can't go in that direction.");
			
			return false;
		}		
		
		int[] playerNeighbourIds = _player.getField().getNeighbourIds();
		
		if (_map.get(playerNeighbourIds[neighbourId]) instanceof Field) {
			if ((_map.get(playerNeighbourIds[neighbourId]).enter(_player, _map)) == true) {
				
				return true;
			}
		} else if (_map.get(playerNeighbourIds[neighbourId]) instanceof Door) {
			if ((_map.get(playerNeighbourIds[neighbourId]).enter(_player, _map)) == true) {
				
				return true;
			}
		}
		
		System.out.println("You can't go in that direction.");
		return false;
	}
	
	public boolean playerTakesItem(String itemName) {
		if (((Field) _map.get(_player.getField().getId())).getItems().size() > 0) {
			LinkedList<Item> fieldItems = ((Field) _map.get(_player.getField().getId())).getItems();
			
			for (Item item : fieldItems) {
				if (item.getName().equals(itemName)) {
					_player.takeItem(item);
					_player.getField().removeItem(itemName);
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean playerConsumesItem(String itemName) {
		LinkedList<Item> playerItems = _player.getItems();
		
		for (Item item : playerItems) {
			if (item instanceof Food) {
				if (item.getName().equals(itemName)) {
					((Food) item).consume();
					_player.removeItem(itemName);
					
					return true;
				}
			}
		}
				
		return false;
	}
	
	public void showIntro() {
		String introduction =	"Welcome to the Mini-MUD Game! Here's a little map overview:";

		System.out.println(introduction);
		System.out.println("-----------------------------------------------------------------------------------------------");
		playersCurrentPosition();
		System.out.println("-----------------------------------------------------------------------------------------------");
		showCommands();
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
		
	public void showCommands() {
		String commands = 		"There are following commands in this game:\n"+
								"[move] + [dir]     ... move in a certain direction ([dir] = north | east | south | west)\n"+
								"[inspect]          ... inspect the available items in the current room\n"+
								"[take] + [item]    ... take a specific item with you ([item] = key | sword | bread | water | beer)\n"+
								"[place] + [item]   ... places a specific item on the current field ([item] = sword | bread | water | beer)\n"+
								"[consume] + [item] ... consumes a consumable item ([item] = bread | water | beer)\n"+
								"[inventory]        ... lists all items in your inventory\n"+
								"[commands]         ... displays all available commands\n"+
								"[map]              ... displays the map with your current position\n"+
								"[quit]             ... quit the current game";
		
		System.out.println(commands);
	}
	
	public void playersCurrentPosition() {
		String currentPosition = "";
		
		if (_player.getField().getId() == 0) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#|p| |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 1) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| |p|~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 2) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~|p|#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 3) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#|p| |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 4) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| |p|#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 5) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#|p|#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 6) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#|p| | |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 7) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| |p| |~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 8) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | |p|~| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		} else if (_player.getField().getId() == 9) {
			currentPosition = 	"  +-+-+ +-+\n"+
								"  |#|#| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |~| |#|\n"+
								"+-+-+-+-+-+-+\n"+
								"|#| | |#|#|\n"+
								"+-+-+-+-+-+ +-+\n"+
								"  |#| |#|#| |#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"  |#| | | |~|p|#|\n"+
								"  +-+-+-+-+-+-+-+\n"+
								"    |#|#|#| |#|\n"+
								"    +-+-+-+ +-+";
		}
		
		String mapInfo = 		"Your current position is marked with 'p'.\n"+
								"Empty fields can be walked on normally.\n"+
								"Doors are marked with '~'.\n"+
								"Walls are marked with '#'.";
		
		System.out.println(currentPosition);
		System.out.println(mapInfo);
	}
}