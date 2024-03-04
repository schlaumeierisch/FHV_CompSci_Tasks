package at.fhv.mme.exercise08.task01;

abstract class Item {
	private String _name;
	private String _description;
	
	public Item(String name, String description) {
		_name = name;
		_description = description;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}
}