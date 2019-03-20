package model;

public class Room {
	
	//ATRIBUTOS

	private String numRoom;
	private boolean pet;
	
	//RELACION
	private Pet petRoom;
	
	//CONSTRUCTOR
	
	public Room(String numRoom, boolean pet) {
		this.pet=pet;
		this.numRoom=numRoom;
		this.petRoom=petRoom;
	}
	
	//MÉTODOS GET Y SET
	
	public boolean getPet() {
		return pet;
	}
	
	public void setPet(boolean pet) {
		this.pet=pet;
	}

	public Pet getnumRoom(){
		return petRoom;
	}

	public void setnumRoom(String numRoom){
		this.numRoom=numRoom;
	}
	
	public Pet getPetRoom() {
		return petRoom;
	}
	public void setPetRoom(Pet petRoom) {
		this.petRoom=petRoom;
	}

}
