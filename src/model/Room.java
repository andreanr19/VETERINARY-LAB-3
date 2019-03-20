package model;

public class Room {

	// ATRIBUTOS

	private String numRoom;
	private boolean pet;

	// RELACION
	private Pet petRoom;

	// CONSTRUCTOR

	public Room(String numRoom, boolean pet) {
		this.pet = pet;
		this.numRoom = numRoom;
		petRoom=null;

	}

	// MÉTODOS GET Y SET

	public boolean getPet() {
		return pet;
	}

	public void setPet(boolean pet) {
		this.pet = pet;
	}

	public String getnumRoom() {
		return numRoom;
	}

	public void setnumRoom(String numRoom) {
		this.numRoom = numRoom;
	}

	public Pet getPetRoom() {
		return petRoom;
	}

	public void setPetRoom(Pet petRoom) {
		if (petRoom != null) {
			this.petRoom = petRoom;
			pet = false;
		}
	}

}
