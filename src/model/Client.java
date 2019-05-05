package model;

import java.util.ArrayList;
import java.util.ArrayList.*;

public class Client {

	// ATRIBUTOS
	private String name;
	private int id;
	private String address;
	private int phone;

	// RELACION MASCOTAS DEL CLIENTE

	private ArrayList<Pet> petClient;

	// CONSTRUCTOR
	public Client(String name, int id, String address, int phone) {

		this.name = name;
		this.id = id;
		this.address = address;
		this.phone = phone;

		petClient = new ArrayList<Pet>();
	}

	/**
	 * Description The method allows to add a object Pet to the arraylist between
	 * client and pet. pre: the pet was created before. post: the pet is added.
	 * 
	 * @param newPet the new pet
	 */
	public void addPet(Pet newPet) {
		petClient.add(newPet);
		petClient.get(petClient.size() - 1).setOwner(this);

	}

	// MÉTODOS GET Y SET

	/**
	 * Description The method allows to obtain the name of the client. pre:Existence
	 * of an attribute called name
	 * 
	 * @return A String representing the name of the client
	 */
	public String getName() {
		return name;
	}

	/**
	 * Description The method allows to set the name of the client. pre:Existence of
	 * an attribute called name
	 * 
	 * @param name the name of the client
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Description The method allows to obtain the id of the client. pre:Existence
	 * of an attribute called id
	 * 
	 * @return An integer representing the name of the client
	 */
	public int getId() {
		return id;
	}

	/**
	 * Description The method allows to set the id of the client. pre:Existence of
	 * an attribute called id
	 * 
	 * @param id the id of the client
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Description The method allows to obtain the address of the client.
	 * pre:Existence of an attribute called address
	 * 
	 * @return A String representing the address of the client
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Description The method allows to set the address of the client. pre:Existence
	 * of an attribute called address
	 * 
	 * @param address the address of the client
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Description The method allows to obtain the phone of the client.
	 * pre:Existence of an attribute called phone
	 * 
	 * @return An integer representing the phone of the client
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * Description The method allows to set the phone of the client. pre:Existence
	 * of an attribute called phone
	 * 
	 * @param phone the phone of the client
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * Description The method allows to obtain list of pets of the client.
	 * pre:Existence of a list of pets that belong to the client
	 * 
	 * @return A list representing the pets of the client
	 */
	public ArrayList<Pet> getPetClient() {
		return petClient;
	}

	/**
	 * Description The method allows to set list of pets of the client.
	 * pre:Existence of a list of pets that belong to the client
	 * 
	 * @param petClient the list of pets of a client
	 */
	public void setPetClient(ArrayList<Pet> petClient) {
		this.petClient = petClient;
	}

	/**
	 * Description This method allows to update the basic data of a veterinary
	 * client, these data include, address and phone number. pre: The client was
	 * created before. post: The address and /or phone number of the client is
	 * updated.
	 * 
	 * @param The new address of the client. This param could be empty.
	 * @param The new phone number of the client. This param could be empty.
	 */
	public void updateTheBasicDataOfTheClient(String NewAdress, int newPhone) {
		this.address = NewAdress;
		this.phone = newPhone;
	}

	/**
	 * Description This method allows to show the pets of a client pre: The where
	 * created before post: the pets are shown
	 * 
	 * @return the name of the pet's client with the owner's name
	 */
	public String showInformationOfPets() {
		String msj = "";
		for (int i = 0; i < petClient.size(); i++) {
			if (petClient.get(i) != null) {
				msj += "Pet " + petClient.get(i).getName() + " (Owner: " + petClient.get(i).getOwner().name + ")"
						+ "\n";
			}
		}
		return msj;
	}


	/**
	 * Description The method allows to see the actual service a pet has pre: The
	 * pet must have a service different of null post: the services of the pets are
	 * shown
	 * 
	 * @return a message that says the service of the pet, and in case the pet has
	 *         no service, the message will say it.
	 */
	public String seeTheActualServiceOfThePetsOfTheVeterinary() {
		String msj = "";
		for (int i = 0; i < petClient.size(); i++) {
			if (petClient.get(i).getService() != null) {
				if (!petClient.get(i).getService().getType().equals("ninguno")) {
					msj += "The pet " + petClient.get(i).getName() + " currently has the service of "
							+ petClient.get(i).getService().getType() + " with a cost of "
							+ petClient.get(i).getService().getPrice() + "\n";
				} else if (petClient.get(i).getService().getType().equals("ninguno")) {
					msj += "The pet " + petClient.get(i).getName() + " currently has no service";
				}
			}
		}
		return msj;
	}

	public void addANewPetToAClient(String namePet, int age, double weight, double height, char animalType,
			String symptom, String diagnosis, int day, int month, int year, int dayOut, int monthOut, int yearOut,
			String nameMedicament, String dose, double price, int frecuency) {
		Pet petToAdd = new Pet(namePet, age, weight, height, animalType);
		petClient.add(petToAdd);
		petToAdd.addMedicalHistoryToTheNewPet(getName(), getId(), namePet, symptom, diagnosis, day, month, year, dayOut,
				monthOut, yearOut, nameMedicament, dose, price, frecuency);
	}
}
