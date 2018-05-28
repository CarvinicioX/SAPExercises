package hello;

public class Country {

	private long ID;
	private String name;

	public Country(long ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public long getID() {
		return this.ID;
	}

	public String getString() {
		return this.name;
	}
}
