package model;

public class Room {
	
	//ATRIBUTOS
	
	private boolean pet;
	
	//RELACION
	private Pet petRoom;
	
	//CONSTRUCTOR
	
	public Room(boolean pet, Pet petRoom) {
		this.pet=pet;
		this.petRoom=petRoom;
	}
	
	//MÉTODOS GET Y SET
	
	public boolean getPet() {
		return pet;
	}
	
	public void setPet(boolean pet) {
		this.pet=pet;
	}
	
	public Pet getPetRoom() {
		return petRoom;
	}
	public void setPetRoom(Pet petRoom) {
		this.petRoom=petRoom;
	}

}
