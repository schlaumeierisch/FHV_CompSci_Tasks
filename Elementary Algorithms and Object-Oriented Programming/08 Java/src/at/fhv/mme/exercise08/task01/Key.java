package at.fhv.mme.exercise08.task01;

public class Key extends Tool {
	private int _doorId;
	
	public Key(String name, String description, int doorId) {
		super(name, description);
		
		_doorId = doorId;
	}

	public int getDoorId() {
		return _doorId;
	}
}