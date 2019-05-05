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
	
	/**
	 * Description The method allows to know when the room is available(empty) or when it isn't (full).
	 * pre: The existance of an attribute called isAviableRoom
	 * @return a Boolean representing if the room is available or if it isn't.
	 */

	public boolean getIsAviableRoom() {
		return isAviableRoom;
	}

	
	/**
	 * Description The method allows to set availability of a room
	 * pre: the Pet shouldn't be null and it was created before
	 * post: the availability of the room is set by parameter
	 * @param pet To know if the pet is in the room
	 */
	public void setIsAviableRoom(boolean pet) {
		this.isAviableRoom = pet;
	}

	/**
	 * Description The method allows to obtain the number of a room. 
	 * pre:Existence of an attribute called numRoom
	 * 
	 * @return A String representing the number of the room
	 */
	public String getnumRoom() {
		return numRoom;
	}

	/**
	 * Description The method allows to set the number of a room. 
	 * pre:Existence of an attribute called numRoom
	 * post: the number of the room is set by parameter 
	 * 
	 * @param numRoom the number of the room
	 */
	public void setnumRoom(String numRoom) {
		this.numRoom = numRoom;
	}

	/**
	 * Description The methods allows to obtain the pet that is currently in the room
	 * pre: Existance of the pet that is related with the room
	 * 
	 * @return A Pet object which is the one that is in the room
	 */
	public Pet getPetRoom() {
		return petRoom;
	}

	/**
	 * Description The method allows to set a pet in the room
	 * pre: The availability of the room depends if the pet is null, so the room is empty
	 * and when it's true, the room is with a pet
	 * post: the pet that is in the room is set by parameter
	 * @param petRoom the pet of the room 
	 */
	public void setPetRoom(Pet petRoom) {
		if (petRoom != null) {
			isAviableRoom = false;
		}else {
			isAviableRoom=true;
		}
		this.petRoom = petRoom;
	}
	

}
