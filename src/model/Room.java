package model;

public class Room {

	// ATRIBUTOS

	private String numRoom;
	private boolean isAviableRoom;

	// RELACION
	private Pet petRoom;

	// CONSTRUCTOR

	public Room(String numRoom, boolean isAviableRoom) {
		this.isAviableRoom = isAviableRoom;
		this.numRoom = numRoom;
		petRoom=null;

	}

	// MÉTODOS GET Y SET

	public boolean getIsAviableRoom() {
		return isAviableRoom;
	}

	public void setIsAviableRoom(boolean pet) {
		this.isAviableRoom = pet;
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
			isAviableRoom = false;
		}else {
			isAviableRoom=true;
		}
		this.petRoom = petRoom;
	}

}
