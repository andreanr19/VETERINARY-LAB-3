package model;

import java.util.ArrayList;

public class Veterinary {

	// Cantidad total de minicuartos

	public final static int TOTAL_MINIROOMS = 8;

	// ATRIBUTOS

	private String name; // nombre de la veterinaria
	private String address; // direccion de la veterinaria
	private String phone; // telefono de la veterinaria
	private String nit; // nit de la veterinaria
	// RELACIONES

	private Room[] minirooms; // Minirooms de la veterinaria
	private ArrayList<Client> clientVeterinary; // Clientes de la veterinaria
	private ArrayList<MedicalHistory> history;
	private ArrayList<Service> theServices;

	// CONSTRUCTOR

	public Veterinary(String name, String address, String phone, String nit) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.nit = nit;

		// Crea los minirooms
		minirooms = new Room[TOTAL_MINIROOMS];

		minirooms[0] = new Room("1", true);
		minirooms[1] = new Room("2", true);
		minirooms[2] = new Room("3", true);
		minirooms[3] = new Room("4", true);
		minirooms[4] = new Room("5", true);
		minirooms[5] = new Room("6", true);
		minirooms[6] = new Room("7", true);
		minirooms[7] = new Room("8", true);

		// Crea los clientes
		clientVeterinary = new ArrayList<Client>();

		// Servicios
		theServices = new ArrayList<Service>();

		// crea las historias clinicas de las mascotas
		history = new ArrayList<MedicalHistory>();

	}

	// GET Y SET
	
	/**
	 * Description The method allows to add a medical history to the list of medical history the veterinary has.
	 * pre: The existance of the medical history. This param must not be null
	 * post: The medical history has been added to the list of medical record.
	 * @param theHistory
	 */
	public void addHistory(MedicalHistory theHistory) {
		history.add(theHistory);
	}

	/**
	 * Description The method allows to add a service to the list of Services the veterinary has.
	 * pre: The existance of the service. This param must not be null
	 * post: The service has been added to the list of Services.
	 * @param services
	 */
	public void addService(Service services) {
		theServices.add(services);
	}

	/**
	 * Description The method allows to obtain the list of services.
	 * pre: the existance  of services added to the list.
	 * 
	 * @return A list of services the veterinary has.
	 */
	public ArrayList<Service> getService() {
		return theServices;
	}
	
	/**
	 * Description the method allows to set the list of services the veterinary has.
	 * pre: The existance of the list of services
	 * post: the services of the list has been set by parameter
	 * @param theServices
	 */

	public void setService(ArrayList<Service> theServices) {
		this.theServices = theServices;
	}

	/**
	 * Description The method allows to obtain the name of the veterinary. 
	 * pre:Existence of an attribute called name
	 * 
	 * @return:A String representing the name of the veterinary
	 */
	public String getName() {
		return name;
	}

	/**
	 * Description The method allows to obtain the address of the veterinary. 
	 * pre:Existence of an attribute called address
	 * 
	 * @return:A String representing the address of the veterinary
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Description The method allows to obtain the phone of the veterinary. 
	 * pre:Existence of an attribute called phone
	 * 
	 * @return:A String representing the phone of the veterinary
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Description The method allows to obtain the NIT of the veterinary. 
	 * pre:Existence of an attribute called nit
	 * 
	 * @return:A String representing the nit of the veterinary
	 */
	public String getNIT() {
		return nit;
	}

	/**
	 * Description The method allows to set the name of the veterinary. 
	 * pre:Existence of an attribute called name
	 * post: the name is set by the parameter 
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Description The method allows to set the address of the veterinary. 
	 * pre:Existence of an attribute called address
	 * post: the address is set by the parameter 
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Description The method allows to set the phone of the veterinary. 
	 * pre:Existence of an attribute called phone
	 * post: the phone is set by the parameter 
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Description The method allows to set the NIT of the veterinary. 
	 * pre:Existence of an attribute called nit
	 * post: the nit is set by the parameter 
	 * 
	 * @param nit
	 */
	public void setNIT(String nit) {
		this.nit = nit;
	}

	
	public String toString() {
		String msj;
		msj = "Veterinary's Name: " + "''" + name + "''" + "\n" + "Address: " + address + "\n" + "Phone: " + phone
				+ "\n" + "NIT: " + nit + ".";
		return msj;
	}

	/**
	 * Description The method allows to obtain the list of clients the veterinary. 
	 * pre:Existence of a list of medical record of the pet
	 * 
	 * 
	 * @return:A list of clients of the veterinary.
	 */
	public ArrayList<Client> getClientVeterinary() {
		return clientVeterinary;
	}
	
	/**
	 * Description The method allows to set the clients to the veterinary's list of clients
	 * pre: the clients are created before
	 * post: the clients are set in the list of Clients
	 * @param clientVeterinary
	 */

	public void setClientVeterinary(ArrayList<Client> clientVeterinary) {
		this.clientVeterinary = clientVeterinary;
	}

	/**
	 * Description The method allows to get the rooms that are in the veterinary
	 * pre: the rooms were created before
	 * 
	 * @return the list of rooms that are in the veterinary
	 */
	public Room[] getMinirooms() {
		return minirooms;
	}

	/**
	 * Description The method allows to set the rooms that are in the veterinary
	 * pre: the rooms were created before
	 * post: the rooms are set by parameter. The param can't be null
	 * @param minirooms
	 */
	public void setMinirooms(Room[] minirooms) {
		this.minirooms = minirooms;
	}

	/**
	 * Description The method allows to verify if the client is already registered in the veterinary by his/her id number
	 * pre: The id param can't be null.
	 * post: The existance of the client based on the id entered by the user is checked
	 * @param idNewClient
	 * @return a boolean that says if the client already exists or doensn't exist in the veterinary
	 */
	public boolean verifyClientExistance(int idNewClient) {
		boolean verifyClient = false;

		for (int i = 0; i < clientVeterinary.size() && verifyClient == false; i++) {

			if (clientVeterinary.get(i).getId() == (idNewClient)) {
				verifyClient = true;

			} else {
				verifyClient = false;
			}

		}
		return verifyClient;
	}

	 /**
	  * Description The method allows to see the pets that are currently in the rooms
	  * pre: the pet is created before and shouldn't be null
	  * post: the information of the pets in the room is shown
	  * @return the pet that is currently in a room.
	  */
	public String showInformation() {

		String msj = "";

		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				msj += "\n The pet that is actually in the room " + minirooms[i].getnumRoom() + " is "
						+ minirooms[i].getPetRoom().getName();

			} else {
				msj += "\n The room " + minirooms[i].getnumRoom() + " doesn't have any pet";
			}
		}
		return msj;
	}

	/**
	 * Description The method allows to see the information about the medical histories of the pets that are currently hospitalized
	 * pre: some of the rooms are already with a pet each one
	 * post: the medical history of each pet that is in a room is shown.
	 * @return A String with the information of the medical history of the pet of the room
	 */
	public String showInformationHistorial() {
		String msj = "";

		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				msj += "--------------------------------------------------------------------------------------------------"
						+ "\n" + "THE PET " + minirooms[i].getPetRoom().getName()
						+ " HAS THE FOLLOWING MEDICAL HISTORY\n" + "DIAGNOSIS: ";

				for (int k = 0; k < minirooms[i].getPetRoom().getHistory().getMedicalRecordV().size(); k++) {
					msj += minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDiagnosis() + "\n"
							+ "SYMPTOM: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getSymptom() + "\n"
							+ "THE DAY OF INCOME OF THE PET WAS: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDay()
							+ " OF THE MONTH: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMonth()
							+ " OF THE YEAR: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getYear() + "\n"
							+ "THE DATE OF OUTCOME OF THE PET IS THE DAY: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDayOut()
							+ " OF THE MONTH: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMonthOut()
							+ " OF THE MONTH: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getYearOut() + "\n";

					for (int j = 0; j < minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k)
							.getMedicinePet().size(); j++) {
						msj += "THE MEDICINE THAT THE PET RECEIVED WAS " + minirooms[i].getPetRoom().getHistory()
								.getMedicalRecordV().get(k).getMedicinePet().get(j).getName() + "\n";

					}
				}

			}
		}
		return msj;
	}

	/**
	 * Description The method allows to see what rooms are currently available.
	 * pre: The existence of an attribute called isAvailableRoom
	 * post: Shows a message that says the availability of each room
	 * @return A String with the rooms available and with the rooms not available.
	 */
	public String ShowRoomsAvaliables() {
		String msj = "";
		int contador = 0;
		msj += "The available rooms are: \n";

		for (int i = 0; i < minirooms.length; i++) {

			if (minirooms[i].getIsAviableRoom() == true) {

				msj += "the room number " + minirooms[i].getnumRoom() + "\n";
				contador++;
			}

		}
		if (contador == 0) {
			msj = "There's no available rooms";
		}

		return msj;
	}

	/**
	 * Description The method allows to calculate the hospitalization of a pet based on the type of animal the pet is.
	 * pre: the params cannot be null or either of a type that doesn't exist.
	 * post: the cost of the hospitalization of a type of pet is calculated
	 * @param weigthPet
	 * @param typePet
	 * @param totalDaysPet
	 * @param priceMedicine
	 * @return a double with the cost of hospitalization of a type of pet.
	 */
	public double costHospitalization(double weigthPet, char typePet, int totalDaysPet, double priceMedicine) {
		double costTotal = priceMedicine; // se inicializa en priceMedicine que es lo minimo que va a costar la
											// hospitalizacion desde el inicio

		if (weigthPet >= 1 && weigthPet <= 3) {
			if (typePet == 'C' || typePet == 'B' || typePet == 'O') {
				costTotal += 10000 * totalDaysPet;
			} else if (typePet == 'D') {
				costTotal += 15000 * totalDaysPet;
			}

		} else if (weigthPet > 3 && weigthPet <= 10) {
			if (typePet == 'C') {
				costTotal += 12000 * totalDaysPet;
			} else if (typePet == 'D') {
				costTotal += 17000 * totalDaysPet;
			} else if (typePet == 'B') {
				costTotal += 12000 * totalDaysPet;
			} else if (typePet == 'O') {
				costTotal += 17000 * totalDaysPet;
			}
		} else if (weigthPet > 10 && weigthPet <= 20) {
			if (typePet == 'C') {
				costTotal += 15000 * totalDaysPet;
			} else if (typePet == 'D') {
				costTotal += 20000 * totalDaysPet;
			} else if (typePet == 'B') {
				costTotal += 20000 * totalDaysPet;
			} else if (typePet == 'O') {
				costTotal += 30000 * totalDaysPet;
			}
		} else if (weigthPet > 20) {
			if (typePet == 'C') {
				costTotal += 20000 * totalDaysPet;
			} else if (typePet == 'D') {
				costTotal += 25000 * totalDaysPet;
			} else if (typePet == 'B') {
				costTotal += 25000 * totalDaysPet;
			} else if (typePet == 'O') {
				costTotal += 30000 * totalDaysPet;
			}
		}
		return costTotal;
	}

	/**
	 * Description The method allows to calculate the cost of hospitalization of a pet that is currently in a room of the veterinary
	 * pre: the rooms were initialized before
	 * post: the cost of hospitalization of each pet that is in the room is calculated
	 * @return a String that says the cost of the hospitalization of each pet
	 */
	public String calculateCostOfHospitalization() {

		String msj = "";
		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				msj += "The pet " + minirooms[i].getPetRoom().getName() + " has a cost of hospitalization of "
						+ costHospitalization(minirooms[i].getPetRoom().getWeight(),
								minirooms[i].getPetRoom().getAnimalType(),
								minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).getTotalDays(),
								minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).priceMedicineTotal())
						+ "\n";
			}
		}
		return msj;

	}

//	public String calculateCostForServices() {
//		String msj="";
//		for(int i=0; i< clientVeterinary.size();i++) {
//			if(clientVeterinary.get(i).getPetClient())
//		}
//	}

	/**
	 * Description The method allows to calculate the earnings based on hospitalization of the pets
	 * pre: some rooms should have a pet inside with a medical history already created.
	 * post: the earnings bases on hospitalization are calculated
	 * 
	 * @return a message that says  the earnings from the hospitalization of the pets that are in the rooms.
	 */
	public String calculateEarnings() {
		String msj = "";
		double accumulateTotalCost = 0;
		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				accumulateTotalCost += costHospitalization(minirooms[i].getPetRoom().getWeight(),
						minirooms[i].getPetRoom().getAnimalType(),
						minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).getTotalDays(),
						minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).priceMedicineTotal());
			}
		}
		msj += "The earnings from hospitalizations are $" + accumulateTotalCost;
		return msj;

	}

	public double calculateEarnings2() {

		double accumulateTotalCost = 0;
		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				accumulateTotalCost += costHospitalization(minirooms[i].getPetRoom().getWeight(),
						minirooms[i].getPetRoom().getAnimalType(),
						minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).getTotalDays(),
						minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).priceMedicineTotal());
			}
		}

		return accumulateTotalCost;

	}

	/**
	 * Description The method allows to change the address and the phone of a client
	 * pre: the client was already created and registered in the veterinary's system
	 * post: the client's information is changed by the one passed in the parameters.
	 * @param clientToChange
	 * @param NewAdress
	 * @param newPhone
	 * @return a message that says if the client's information has been updated
	 */
	public String changeDataBasic(String clientToChange, String NewAdress, int newPhone) {

		Client clientUpdated = null;
		String msj = "";
		boolean found = false;
		for (int i = 0; i < clientVeterinary.size() && !found; i++) {
			if (clientVeterinary.get(i).getName().equals(clientToChange)) {

				clientUpdated = clientVeterinary.get(i);
				found = true;
				clientUpdated.updateTheBasicDataOfTheClient(NewAdress, newPhone);
				msj += "La información del cliente " + clientVeterinary.get(i).getName() + " ha sido cambiada";
			}
		}
		return msj;
	}

	/**
	 * Description The method allows to show a list of the clients that are currently registered
	 * pre: The clients list were created before
	 * post: the information of the clients that are registered is shown
	 * @return a message that lists the currently clients of the veterinary
	 */
	public String showInformationOfClients() {
		String msj = "";
		for (int i = 0; i < clientVeterinary.size(); i++) {
			if (clientVeterinary.get(i) != null) {
				msj += i + 1 + "." + clientVeterinary.get(i).getName() + "\n";
			}
		}
		return msj;
	}
	

	/**
	 * Description The method allows to show the information about the pets that are registered in the veterinary.
	 * pre: the pet has been created before and the have been added to the list of pets of the owner.
	 * post: The information of the pets that are currently registered is shown 
	 * @return a message that lists the pets that are registered in the veterinary.
	 */
	public String showPetsInfo() {
		String msj = "";
		for (int i = 0; i < clientVeterinary.size(); i++) {
//			msj += i + 1 + "." + clientVeterinary.get(i).showInformationOfPets();
			msj += clientVeterinary.get(i).showInformationOfPets();
		}
		return msj;
	}

	/**
	 * Description The method allows to calculate the earnings based on services
	 * pre: the services were already created
	 * post: the earnings based on services is calculated
	 * @return a message that says the earnings from the services.
	 */
	public String calculateEarningsForServices() {
		double earningService = 0;
		String msj = "";
		for (int i = 0; i < theServices.size(); i++) {
			if (theServices.get(i).getThePet() != null) {
				earningService += theServices.get(i).getThePet().getService().getPrice();
				msj = "The earnings for services are: " + earningService;
			}
		}
		return msj;
	}

	public double calculateEarningForServices2() {
		double earningService = 0;

		for (int i = 0; i < theServices.size(); i++) {
			if (theServices.get(i).getThePet() != null) {
				earningService += theServices.get(i).getThePet().getService().getPrice();

			}
		}
		return earningService;
	}

	/**
	 * Description The method allows to calculate the total earnings based on hospitalization and services
	 * pre: the earnings based on hospitalizations and services were already calculated
	 * post: the earnings based on hospitalization and services are calculated.
	 * 
	 * @return a message that says the earnings based on hospitalization and services
	 * 
	 */
	public String calculateTotalEarningsOfVeterinary() {
		double earningTotal = (calculateEarningForServices2() + calculateEarnings2());

		String msj = "The total earnings of the veterinary are: $" + earningTotal;

		return msj;

	}
	
	/**
	 * Description The method allows to calculate the average based on the earnings for services
	 * pre: the earnings based on services were calculated before
	 * post: the average is calculated bases on the times the services are realized
	 * @return a message that says the average based on the eranings for services.
	 */

	public String calculateTheAverageForServices() {
		int contador = 0;
		double average = 0;
		String msj = "";
		for (int i = 0; i < theServices.size(); i++) {
			if (theServices.get(i).getThePet() != null) {
				contador++;
				average = (calculateEarningForServices2() / contador);
				msj = "The average of income based on services are: $" + average;
			}
		}
		return msj;
	}


	public void addANewPetToAClient(String nameOwner, String namePet, int age, double weight, double height,
			char animalType, String symptom, String diagnosis, int day, int month, int year, int dayOut, int monthOut,
			int yearOut, String nameMedicament, String dose, double price, int frecuency) {
		for (int i = 0; i < clientVeterinary.size(); i++) {
			if (clientVeterinary.get(i).getName().equals(nameOwner)) {
				clientVeterinary.get(i).addANewPetToAClient(namePet, age, weight, height, animalType, symptom,
						diagnosis, day, month, year, dayOut, monthOut, yearOut, nameMedicament, dose, price, frecuency);

			}
		}
	}

	/**
	 * Description The method allows to see the services a pet has
	 * pre: the pets were created before
	 * post: a list of the services of the services of the pet is shown
	 * @return A message that says the sevices each pet has.
	 */
	public String seeTheActualServiceOfAPet() {
		String msj = "";
		for (int i = 0; i < clientVeterinary.size(); i++) {
			if (clientVeterinary.get(i).getPetClient() != null) {
				msj += clientVeterinary.get(i).seeTheActualServiceOfThePetsOfTheVeterinary();
			}
		}
		return msj;
	}

	/**
	 * Description The methods allows to show the information about the services the veterinary has-
	 * pre: the types of services were already defined
	 * post: a list of the services of the veterinary is shown
	 * @return a message with the list of services of the veterinary
	 */
	public String showInformationServices() {
		String msj = "";
		msj = "1." + Service.SHOWERSERVICE + "\n2." + Service.SHOWERDOMICILESERVICE + "\n3." + Service.NAILSCUTSERVICE
				+ "\n4." + Service.PROPHYLAXISSERVICE + "\n5." + Service.VACCINATIONSERVICE;
		return msj;
	}

	/**
	 * Description The method allows to add medicine to the medical history of a pet
	 * pre: the pet has been already created, including its medical history
	 * 
	 * @param nameOwner
	 * @param namePet
	 * @param name
	 * @param dose
	 * @param price
	 * @param frecuency
	 */
	public void addNewMedicine2(String nameOwner, String namePet, String name, String dose, double price,
			int frecuency) {
		for (int i = 0; i < history.size(); i++) {

			if (history.get(i).getNameOwner().equals(nameOwner) && history.get(i).getNamePet().equals(namePet)) {
				history.get(i).addNewMedicine(name, dose, price, frecuency);
				System.out.println("La medicina se ha agregado");
			}
		}
	}

	/**
	 * Description The method allows to add notes to the medical history of a pet
	 * pre: the pet has been already created, including its medical history
	 * 
	 * @param nameOwner
	 * @param namePet
	 * @param noteDiagnosis
	 */
	public void addNewNotes(String nameOwner, String namePet, String noteDiagnosis) {
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getNameOwner().equals(nameOwner) && history.get(i).getNamePet().equals(namePet)) {
				history.get(i).addNewNotesToAMedicalRecord(noteDiagnosis);
				System.out.println("La nueva nota se ha agregado");
			}
		}
	}

	/**
	 * Description The method allows to add symptoms to the medical history of a pet
	 * pre: the pet has been already created, including its medical history
	 * 
	 * @param nameOwner
	 * @param namePet
	 * @param symptomToAdd
	 */
	public void addNewSymptomToAMedicalHistory(String nameOwner, String namePet, String symptomToAdd) {
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getNameOwner().equals(nameOwner) && history.get(i).getNamePet().equals(namePet)) {
				history.get(i).addNewSymptom(symptomToAdd);
				System.out.println("El nuevo sintoma se ha agregado");
			}
		}
	}

	/**
	 * Description The method allows to add  services to the services for a pet
	 * pre: the pet has been already created, including its medical history
	 * 
	 * @param nameOwner
	 * @param namePet
	 * @param type
	 */
	public void addServiceToAPet(String nameOwner, String namePet, String type) {
		for (int i = 0; i < clientVeterinary.size(); i++) {
			if (clientVeterinary.get(i).getName().equals(nameOwner)
					&& clientVeterinary.get(i).getPetClient().get(i).getName().equals(namePet)) {
				clientVeterinary.get(i).addNewServiceToAPet(nameOwner, namePet, type);
				System.out.println("El servicio se ha agregado");
			}
		}
	}

}