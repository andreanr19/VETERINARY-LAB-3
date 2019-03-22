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

		// crea las historias clinicas de las mascotas
		history = new ArrayList<MedicalHistory>();

	}

	// GET Y SET
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getNIT() {
		return nit;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setNIT(String nit) {
		this.nit = nit;
	}

	public String toString() {
		String msj;
		msj = "Veterinary's Name: " + " '' " + name + "'' " + ", Address: " + address + ", Phone: " + phone + ", NIT: "
				+ nit + ".";
		return msj;
	}

	public ArrayList<Client> getClientVeterinary() {
		return clientVeterinary;
	}

	public void setClientVeterinary(ArrayList<Client> clientVeterinary) {
		this.clientVeterinary = clientVeterinary;
	}

	public Room[] getMinirooms() {
		return minirooms;
	}

	public void setMinirooms(Room[] minirooms) {
		this.minirooms = minirooms;
	}

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

	public String showInformation() {

		String msj = "";

		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				msj += "\n La mascota que está actualmente en el cuarto " + minirooms[i].getnumRoom() + " es "
						+ minirooms[i].getPetRoom().getName();

			} else {
				msj += "\n El cuarto " + minirooms[i].getnumRoom() + "no tiene mascota";
			}
		}
		return msj;
	}

	public String showInformationHistorial() {
		String msj = "";

		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				//System.out.println("indice i: "+i);
				for (int k = 0; k < minirooms[i].getPetRoom().
						getHistory().getMedicalRecordV().size(); k++) {
					msj += "Diagnostico: " + "The pet " + minirooms[i].getPetRoom().getName() +" tiene el siguiente historial clinico"
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDiagnosis()
							+ ", Síntoma: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getSymptom() 
							+ "En el día: "
							+minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDay() + 
							" del mes: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMonth() + 
							" del año: " 
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getYear() + "\n";
				}

			}
		}
		return msj;
	}

}
