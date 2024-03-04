package at.fhv.mme.exercise07.task03;

import java.util.LinkedList;
import java.util.List;

/**
 * Cheese class for exercise 07, task 03
 * 
 * @author 	Matthias Meier
 * @date	2021-06-09
 */

public class Cheese {
	private int _structureWidth = 17;
	private int _structureHeight = 7;
	private char[][] _structure;
	private int _holeCounter;
	
	public Cheese() {
		_structure = new char[_structureHeight][_structureWidth];
		
		// create an "empty" cheese (cheese without holes)
		for (int i = 0; i < _structureHeight; i++) {
			for (int j = 0; j < _structureWidth; j++) {
				_structure[i][j] = ' ';
			}
		}
		
		// (manually) insert holes into cheese (from the task)
		_structure[1][5] 	= '*';
		_structure[1][6] 	= '*';
		_structure[2][4] 	= '*';
		_structure[2][7] 	= '*';
		_structure[2][13] 	= '*';
		_structure[3][4] 	= '*';
		_structure[3][5] 	= '*';
		_structure[3][6] 	= '*';
		_structure[3][12] 	= '*';
		_structure[3][14] 	= '*';
		_structure[4][9] 	= '*';
		_structure[4][10] 	= '*';
		_structure[4][13] 	= '*';
		_structure[5][3] 	= '*';
		_structure[5][9] 	= '*';
		_structure[5][10] 	= '*';
	}
	
	public int getStructureWidth() {
		return _structureWidth;
	}
	
	public int getStructureHeight() {
		return _structureHeight;
	}
	
	public char[][] getStructure() {
		return _structure;
	}
	
	public boolean isHole(int i, int j) {
		if (_structure[i][j] == '*') {
			return true;
		}
		
		return false;
	}
	
	public boolean holeAlreadyChecked(int i, int j) {
		if (_structure[i][j] == '#') {
			return true;
		}
		
		return false;
	}
	
	public List<Integer> searchForHoles() {
		List<Integer> allHoles = new LinkedList<>();
		_holeCounter = 0;
		
		for (int i = 0; i < _structureHeight; i++) {
			for (int j = 0; j < _structureWidth; j++) {
				// reset counter
				_holeCounter = 0;
				
				if (_structure[i][j] == '*') {
					// recursive search for other neighbours
					checkNeighbours(i, j);
				}
				
				// adding count
				if (_holeCounter != 0) {
					allHoles.add(_holeCounter);
				}
			}
		}
		
		return allHoles;
	}
	
	public void checkNeighbours(int i, int j) {
		_structure[i][j] = '#';
		_holeCounter++;
		
		// check all eight neighbours
		if (_structure[i - 1][j - 1] == '*') {
			checkNeighbours(i - 1, j - 1);
		}
		
		if (_structure[i - 1][j] == '*') {
			checkNeighbours(i - 1, j);
		}
		
		if (_structure[i + 1][j] == '*') {
			checkNeighbours(i + 1, j);
		}
		
		if (_structure[i][j + 1] == '*') {
			checkNeighbours(i, j + 1);
		}
		
		if (_structure[i + 1][j + 1] == '*') {
			checkNeighbours(i + 1, j + 1);
		}
		
		if (_structure[i + 1][j] == '*') {
			checkNeighbours(i + 1, j);
		}
		
		if (_structure[i + 1][j - 1] == '*') {
			checkNeighbours(i + 1, j - 1);
		}
		
		if (_structure[i][j - 1] == '*') {
			checkNeighbours(i, j - 1);
		}
	}
	
	public void printCheeseStructure() {
		for (int i = 0; i < _structureHeight; i++) {
			for (int j = 0; j < _structureWidth; j++) {
				System.out.print(_structure[i][j]);
			}
			
			System.out.println();
		}
	}
}