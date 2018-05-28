package hello;

public class User {

	private long ID, country;
	private String name;

	public User(long ID, String name, long country) {
		this.ID = ID;
		this.name = name;
		this.country = country;
	}

	public long getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public long getCountry() {
		return this.country;
	}
}
