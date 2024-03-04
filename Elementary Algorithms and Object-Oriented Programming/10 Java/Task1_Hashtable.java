package at.fhv.mme.exercise10.task01;

public class Hashtable {
	private Node[] _nodes;
	private int _maxSize;
	private int _currSize;
	
	public Hashtable(int size) {
		_nodes = new Node[size];
		_maxSize = size;
		_currSize = 0;
	}
	
	public boolean isEmpty() {
		if (_currSize == 0) {
			return true;
		}
		
		return false;
	}
	
	public int getCurrSize() {
		System.out.println("Currently " + _currSize + "/" + _maxSize + " nodes are occupied. (" + (_currSize * 100 /_maxSize) + " %)");
		
		return _currSize;
	}
	
	public boolean insert(int value) {
		if (_currSize < _maxSize) {
			int i = hashH(value);
			
			if (_nodes[i] == null) {
				_nodes[i] = new Node(value);
				_currSize++;
				System.out.println("Inserting the value '" + value + "' was successful!");
				return true;
			} else {
				System.out.println("Which collision strategy do you want to use? (Insert: value '" + value + "')");
				System.out.println("Available strategies: [linear] | [quadratic] | [doublehashing]");
				String command = Main.scanner.nextLine();
				
				if (command.equals("linear")) {
					if (linearProbing(i, value) == true) {
						return true;
					}
				} else if (command.equals("quadratic")) {
					if (quadraticProbing(i, value) == true) {
						return true;
					}
				} else if (command.equals("doublehashing")) {
					if (doubleHashing(i, value) == true) {
						return true;
					}
				}
				
				System.out.println("Inserting the value '" + value + "' failed!");
				return false;
			}
		}
		
		System.out.println("Insertion failed! The hashtable is already full!");
		return false;
	}
	
	public boolean linearProbing(int i, int value) {
		int count = 0;
		
		while (_nodes[i] != null) {
			i = (i + 1) % _maxSize;
			count++;
			
			// return false, if it takes too long to insert value
			if (count > _maxSize) {
				return false;
			}
		}
		
		_nodes[i] = new Node(value);
		_currSize++;
		System.out.println("Inserting the value '" + value + "' was successful!");
		return true;
	}
	
	public boolean quadraticProbing(int i, int value) {
		int count = 0;
		
		while (_nodes[i] != null) {
			// (h(key, 0) + i^2) % m
			i = (i + (i^2)) % _maxSize;
			count++;
			
			// return false, if it takes too long to insert value
			if (count > _maxSize) {
				System.out.println("Trying to insert the value took too long!");
				return false;
			}
		}
		
		_nodes[i] = new Node(value);
		System.out.println("Inserting the value '" + value + "' was successful!");
		_currSize++;
		return true;
	}
	
	public boolean doubleHashing(int i, int value) {
		int count = 0;
		
		while (_nodes[i] != null) {
			// (h(key) + i * p(key)) % m
			i = (i + i * hashP(i, value)) % _maxSize;
			count++;
			
			if (count > _maxSize) {
				System.out.println("Trying to insert the value took too long!");
				return false;
			}
		}
		
		System.out.println("Inserting the value '" + value + "' was successful!");
		_currSize++;
		return true;
	}
	
	private int hashH(int value) {
		return value % _maxSize;
	}
	
	private int hashP(int i, int value) {
		return 1 + value % (_maxSize - 1);
	}
	
	public boolean remove(int value) {
		if (_currSize > 0) {
			int i = hashH(value);
			
			if (_nodes[i].getValue() == value) {
				_nodes[i] = null;
				_currSize--;
				System.out.println("Removing the value '" + value + "' was successful!");
				return true;
			} else {
				int count = 0;
				
				while (true) {
					i = (i + 1) % _maxSize;
					
					if (_nodes[i].getValue() == value) {
						_nodes[i] = null;
						_currSize--;
						System.out.println("Removing the value '" + value + "' was successful!");
						return true;
					}
					
					count++;
					if (count > _maxSize) {
						System.out.println("The value could not be found and removed!");
						return false;
					}
				}
			}
		}
		
		System.out.println("Removing failed! The hashtable is empty!");
		return false;
	}
	
	public void clear() {
		_nodes = new Node[_maxSize];
		_currSize = 0;
		System.out.println("Hashtable cleared!");
	}
	
	public boolean print() {
		if (_currSize > 0) {
			for (int i = 0; i < _maxSize; i++) {
				if (_nodes[i] != null) {
					System.out.println("[" + i + "]: " + _nodes[i].getValue());
				} else {
					System.out.println("[" + i + "]: null");
				}
			}
			
			return true;
		}
		
		System.out.println("Printing failed! The hashtable is empty!");
		return false;
	}
}