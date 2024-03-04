package at.fhv.mme.exercise07.task02;

public class Position {
	private int _posX;
	private int _posY;
	
	public Position(int posX, int posY) {
		_posX = posX;
		_posY = posY;
	}
	
	public int getPosX() {
		return _posX;
	}
	
	public int getPosY() {
		return _posY;
	}
	
	public boolean move(int stepsX, int stepsY) {
		if (((_posX + stepsX) > 0) && ((_posY + stepsY) > 0)) {
			_posX = _posX + stepsX;
			_posY = _posY + stepsY;
			
			return true;
		}
		
		return false;
	}
}