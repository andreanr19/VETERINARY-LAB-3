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
				msj += "\n El cuarto " + minirooms[i].getnumRoom() + " no tiene mascota";
			}
		}
		return msj;
	}

//	public String showInformationHistorial() {
//		String msj = "";
//
//		for (int i = 0; i < minirooms.length; i++) {
//			if (minirooms[i].getIsAviableRoom() == false) {
//
//
//				for (int k = 0; k < minirooms[i].getPetRoom().getHistory().getMedicalRecordV().size(); k++) {
//					
//					
//					msj += "LA MASCOTA " + minirooms[i].getPetRoom().getName() +" TIENE EL SIGUIENTE HISTORIAL CLINICO\n" 
//							+"DIAGNOSTICO: "
//							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDiagnosis() + "\n"
//							+ "SINTOMA: "
//							
//							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getSymptom()  + "\n"
//							+ "LA HISTORIA CLINICA DE LA MASCOTA FUE EL DIA: "
//							+minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDay() + 
//							" DEL MES: "
//							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMonth() + 
//							" DEL AÑO: " 
//							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getYear() + "\n";
//				}
//
//			}
//		}
//		return msj;
//	}

	public String showInformationHistorial() {
		String msj = "";

		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				msj += "LA MASCOTA " + minirooms[i].getPetRoom().getName() + " TIENE EL SIGUIENTE HISTORIAL CLINICO\n"
						+ "DIAGNOSTICO: ";

				for (int k = 0; k < minirooms[i].getPetRoom().getHistory().getMedicalRecordV().size(); k++) {
					msj += minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDiagnosis() + "\n"
							+ "SINTOMA: "
//					+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMedicinePet()
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getSymptom() + "\n"
							+ "LA FECHA DE INGRESO DE LA MASCOTA FUE EL DIA: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDay() + " DEL MES: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMonth()
							+ " DEL AÑO: " + minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getYear()
							+ "\n" + "LA FECHA DE ALTA DE LA MASCOTA ES EL DIA: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getDayOut()
							+ " DEL MES: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getMonthOut()
							+ " DEL AÑO: "
							+ minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k).getYearOut() + "\n";

					for (int j = 0; j < minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k)
							.getMedicinePet().size(); j++) {
						msj += "MEDICINA " + minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(k)
								.getMedicinePet().get(j).getName() + "\n";

					}
				}

			}
		}
		return msj;
	}

	public String ShowRoomsAvaliables() {
		String msj = "";
		int contador = 0;
		msj += "Los cuartos disponibles son: \n";

		for (int i = 0; i < minirooms.length; i++) {

			if (minirooms[i].getIsAviableRoom() == true) {

				msj += "El cuarto numero " + minirooms[i].getnumRoom() + "\n";
				contador++;
			}

		}
		if (contador == 0) {
			msj = "No hay salas disponibles";
		}

		return msj;
	}

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

	public String calculateCostOfHospitalization() {

		String msj = "";
		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				msj += "La mascota " + minirooms[i].getPetRoom().getName() + " tiene un costo de hospitalizacion de "
						+ costHospitalization(minirooms[i].getPetRoom().getWeigth(),
								minirooms[i].getPetRoom().getAnimalType(),
								minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).getTotalDays(),
								minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).priceMedicineTotal())
						+ "\n";
			}
		}
		return msj;

	}

	public String calculateEarnings() {
		String msj = "";
		double accumulateTotalCost = 0;
		for (int i = 0; i < minirooms.length; i++) {
			if (minirooms[i].getIsAviableRoom() == false) {
				accumulateTotalCost += costHospitalization(minirooms[i].getPetRoom().getWeigth(),
						minirooms[i].getPetRoom().getAnimalType(),
						minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).getTotalDays(),
						minirooms[i].getPetRoom().getHistory().getMedicalRecordV().get(0).priceMedicineTotal());
			}
		}
		msj += "Los ingresos por concepto de hospitalizaciones son " + accumulateTotalCost;
		return msj;

	}
}