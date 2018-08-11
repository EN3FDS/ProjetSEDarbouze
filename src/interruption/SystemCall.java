package interruption;

public class SystemCall {
	private final int SIZE = 32; //size chaque entree dans la table 64 bits
	private String name;
	private short address; //adresse de la routine

	public SystemCall() {
		// TODO Auto-generated constructor stub
	}
	
	public SystemCall(String name, short address) {
		this.name=name;
		this.address=address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAddress() {
		return address;
	}

	public void setAddress(short address) {
		this.address = address;
	}

	public int getSIZE() {
		return SIZE;
	}

}
