package ui;

import java.util.Scanner;

import model.*;

public class main {

	public static void main(String[] args) {
		Veterinary myVeterinary = new Veterinary("Mi Pequeña Mascota", "kra_4 #15-77", "2670039", "1010138801");
		InitializeAll(myVeterinary);
		Scanner input = new Scanner(System.in);
		System.out.println("Desea comenzar la aplicacion");
		while (input.nextLine().equalsIgnoreCase("SI")) {

			System.out.println("WELCOME TO THE VETERINARY! WHAT WOULD YOU LIKE TO DO?");
			String options = "1.To know Veterinary's information " + "\n2.To register a new client and a new pet"
					+ "\n3.To look for the current pets in the rooms"
					+ "\n4.To look for the historial clinical of the pet "
					+ "\n5.To discharge from the veterinary a pet "
					+ "\n6.To create a report of the open medical history "
					+ "\n7.To calculate the cost of a hospitalization "
					+ "\n8.To know the income based on hospitalizations " + "\n9.To know a Pet's Room";
			System.out.println(options);
			int option = Integer.parseInt(input.nextLine());
			if (option == 1) {
				System.out.println(myVeterinary.toString());
			} else if (option == 2) {
				System.out.println("Ingrese su Id");
				int idNewClient = Integer.parseInt(input.nextLine());
				if (myVeterinary.verifyClientExistance(idNewClient) == false) {

					System.out.println(
							"Hemos encontrado que usted no está registrado, por lo tanto te vamos a registrar");

					System.out.println("Ingrese su nombre");
					String nameNewClient = input.nextLine();
					System.out.println("Ingrese su Id");
					idNewClient = Integer.parseInt(input.nextLine());
					System.out.println("Ingrese su direccion");
					String addressNewClient = input.nextLine();
					System.out.println("Ingrese su telefono");
					int phoneNewClient = Integer.parseInt(input.nextLine());

					Client newClient = new Client(nameNewClient, idNewClient, addressNewClient, phoneNewClient);
					myVeterinary.getClientVeterinary().add(newClient);

					System.out.println("El cliente ha sido registrado");

					System.out.println("Ahora danos los datos de la mascota que vas a registrar");
					System.out.println("Danos el nombre de tu mascota");
					String nameNewPet = input.nextLine();
					System.out.println("Danos la edad de tu mascota");
					int ageNewPet = Integer.parseInt(input.nextLine());
					System.out.println("Ingrese el peso de su mascota");
					int weigthNewPet = Integer.parseInt(input.nextLine());
					System.out.println(
							"Ingrese D si su mascota es un perro, G si su mascota es un gato, B si su mascota es un pajaro u O si es cualquier otro tipo");
					char typeNewPet = input.nextLine().charAt(0);

					Pet newPet = new Pet(nameNewPet, ageNewPet, weigthNewPet, typeNewPet);
					newClient.getPetClient().add(newPet);

					System.out.println("Desea hospitalizar la manscota \n1.Si \n2.No");
					int answer = Integer.parseInt(input.nextLine());
					if (answer == 1) {
						int contador = 0;
						boolean stop = false;
						for (int i = 0; i < myVeterinary.getMinirooms().length && stop == false; i++) {
							if (myVeterinary.getMinirooms()[i].getIsAviableRoom() == false) {
								contador++;
							} else {
								myVeterinary.getMinirooms()[i].setPetRoom(newPet);
								stop = true;
							}

						}
						String msj = "";
						if (contador == myVeterinary.getMinirooms().length) {
							msj += "No hay cuartos disponibles";
							System.out.println(msj);
						} else {
							msj += "La mascota ha sido añadida al cuarto " + (contador + 1);
							System.out.println(msj);

							//System.out.println("Tell us the symptom the pets presents");
							//String newPetSymptom = input.nextLine();
							System.out.println("Give us a brief description of what affects your pet");
							String newPetDiagnosis = input.nextLine();
							System.out.println("Enter the current day");
							int newDay = Integer.parseInt(input.nextLine());
							System.out.println("Enter the current month");
							int newMonth = Integer.parseInt(input.nextLine());
							System.out.println("Enter the current year");
							int newYear = Integer.parseInt(input.nextLine());

							//MedicalRecord newMrPet = new MedicalRecord(newPetSymptom, newPetDiagnosis, newDay, newMonth,
								//	newYear);
							
							System.out.println("Enter the option choosing of the following one of the symptoms of your pet");
							System.out.println("One= Fever" + "\nTwo= Headache" + "\nThree= Stomach ache" + "\nFourth= Vomit");
							String newPetSymptoms= input.nextLine();
							if(newPetSymptoms.equalsIgnoreCase("One")) {
								newPetSymptoms= "Fever";
								Medicine medicineNewPet= new Medicine("Dolex", "5 ml", 10000.0);
								MedicalRecord newMrPet = new MedicalRecord(newPetSymptoms, newPetDiagnosis, newDay, newMonth,
										newYear);
								newMrPet.getMedicinePet().add(medicineNewPet);
								
								newMrPet.setThePetRecord(newPet);

								MedicalHistory newMdPet = new MedicalHistory();
								newMdPet.getMedicalRecordV().add(newMrPet);
								newMdPet.setTheClient(newClient);
								newMdPet.setThePet(newPet);

								
							}else if(newPetSymptoms.equalsIgnoreCase("Two")) {
								newPetSymptoms="Headache";
								Medicine medicineNewPet= new Medicine("Acetaminofen", "2 ml", 2000.0);
								MedicalRecord newMrPet = new MedicalRecord(newPetSymptoms, newPetDiagnosis, newDay, newMonth,
										newYear);
								newMrPet.getMedicinePet().add(medicineNewPet);
								
								newMrPet.setThePetRecord(newPet);

								MedicalHistory newMdPet = new MedicalHistory();
								newMdPet.getMedicalRecordV().add(newMrPet);
								newMdPet.setTheClient(newClient);
								newMdPet.setThePet(newPet);
								
								
							}else if(newPetSymptoms.equalsIgnoreCase("Three")) {
								newPetSymptoms="Stomach ache";
								Medicine medicineNewPet= new Medicine("Ibuprofeno", "4 ml", 6000.0);
								MedicalRecord newMrPet = new MedicalRecord(newPetSymptoms, newPetDiagnosis, newDay, newMonth,
										newYear);
								newMrPet.getMedicinePet().add(medicineNewPet);
								
								newMrPet.setThePetRecord(newPet);

								MedicalHistory newMdPet = new MedicalHistory();
								newMdPet.getMedicalRecordV().add(newMrPet);
								newMdPet.setTheClient(newClient);
								newMdPet.setThePet(newPet);
								
							}else if(newPetSymptoms.equalsIgnoreCase("Fourth")) {
								newPetSymptoms="Vomit";
								Medicine medicineNewPet= new Medicine("Renal", "3 ml", 15000.0);
								MedicalRecord newMrPet = new MedicalRecord(newPetSymptoms, newPetDiagnosis, newDay, newMonth,
										newYear);
								newMrPet.getMedicinePet().add(medicineNewPet);

								newMrPet.setThePetRecord(newPet);

								MedicalHistory newMdPet = new MedicalHistory();
								newMdPet.getMedicalRecordV().add(newMrPet);
								newMdPet.setTheClient(newClient);
								newMdPet.setThePet(newPet);
							}
					
							
//							newMrPet.setThePetRecord(newPet);
//
//							MedicalHistory newMdPet = new MedicalHistory();
//							newMdPet.getMedicalRecordV().add(newMrPet);
//							newMdPet.setTheClient(newClient);
//							newMdPet.setThePet(newPet);
							
//							System.out.println("Enter the option choosing of the following one of the symptoms of your pet");
//							System.out.println("One= Fever" + "\nTwo= Headache" + "\nThree= Stomach ache" + "\nFourth= Vomit");
//							String newPetSymptoms= input.nextLine();
//							if(newPetSymptoms.equalsIgnoreCase("One")) {
//								newPetSymptoms= "Fever";
//								Medicine medicineNewPet= new Medicine("Dolex", "5 ml", 10000.0);
//								newMrPet.getMedicinePet().add(medicineNewPet);
//								
//							}else if(newPetSymptoms.equalsIgnoreCase("Two")) {
//								newPetSymptoms="Headache";
//								Medicine medicineNewPet= new Medicine("Acetaminofen", "2 ml", 2000.0);
//								newMrPet.getMedicinePet().add(medicineNewPet);
//								
//							}else if(newPetSymptoms.equalsIgnoreCase("Three")) {
//								newPetSymptoms="Stomach ache";
//								Medicine medicineNewPet= new Medicine("Ibuprofeno", "4 ml", 6000.0);
//								newMrPet.getMedicinePet().add(medicineNewPet);
//							}else if(newPetSymptoms.equalsIgnoreCase("Fourth")) {
//								newPetSymptoms="Vomit";
//								Medicine medicineNewPet= new Medicine("Renal", "3 ml", 15000.0);
//								newMrPet.getMedicinePet().add(medicineNewPet);
//							}
//					
							
							
							System.out.println("According to the information you gave us about the pet, we are going to give the medical prescription to follow");
							
							
							
							System.out.println("The pet's medical history has been successfully created");
						}

					}else if(answer ==2) {
						String msj= "The pet has been registered in the veterinary system";
						System.out.println(msj);
					}

				} else {
					System.out.println("The client is already registered in the Veterinary's System");
				}
			} else if (option == 3) {
				System.out.println(myVeterinary.showInformation());
			} else if (option == 4) {
				System.out.println(myVeterinary.showInformationHistorial());
			} else if (option == 5) {
				System.out.println("Input the pet's owner's name you want to discharge from the veterinary");
				String ownerPetDischarge = input.nextLine();
				System.out.println("Input the pet's name you want to discharge from veterinary");
				String namePetDischarge = input.nextLine();
				for (int i = 0; i < myVeterinary.getMinirooms().length; i++) {
					
					System.out.println(myVeterinary.getMinirooms()[i].getPetRoom().getName());
					
					if (myVeterinary.getMinirooms()[i].getPetRoom().getOwner().getName().equals(ownerPetDischarge)) {
						for (int k = 0; k < myVeterinary.getMinirooms()[i].getPetRoom().getOwner().getPetClient()
								.size(); k++) {
							if (myVeterinary.getMinirooms()[i].getPetRoom().getOwner().getPetClient().get(k).getName()
									.equals(namePetDischarge)) {

								
								
								for (int j = 0; j < myVeterinary.getMinirooms()[i].getPetRoom().getHistory()
										.getMedicalRecordV().size(); j++) {
									myVeterinary.getMinirooms()[i].getPetRoom().getHistory().getMedicalRecordV().get(j)
											.setStatus("Closed");

								}
								myVeterinary.getMinirooms()[i].setPetRoom(null);
								break;
							}
						}
						break;
					}
				}
				System.out.println("Se ha dado de alta la mascota");

			}
			System.out.println("Desea continuar la aplicación");
		}
	}

	public static void InitializeAll(Veterinary myVeterinary) {
		// info1
		Client client1 = new Client("Larry", 66885666, "Diag 4 #16", 31555);
		Pet pet1 = new Pet("Marie", 5, 7.0, 'D');
		MedicalHistory md1 = new MedicalHistory();
		md1.setTheClient(client1);
		md1.setThePet(pet1);
		MedicalRecord mr1 = new MedicalRecord("GripaFlu", "The pet has flu", 20, 3, 2019);
		mr1.setThePetRecord(pet1);
		// mr1 meterlo en el medical history
		md1.getMedicalRecordV().add(mr1);

		Medicine medicinePet1 = new Medicine("Dolex", "10 ml", 2500);
		mr1.getMedicinePet().add(medicinePet1);

		myVeterinary.getClientVeterinary().add(client1);
		client1.getPetClient().add(pet1);
		pet1.setOwner(client1);
		pet1.setHistory(md1);
		myVeterinary.getMinirooms()[0].setPetRoom(pet1);

		Client client2 = new Client("Jesse", 970220, "Kra 3 #2_20", 267554);
		Pet pet2 = new Pet("Pablo", 2, 3.0, 'G');
		MedicalHistory md2 = new MedicalHistory();
		md2.setTheClient(client2);
		md2.setThePet(pet2);
		MedicalRecord mr2 = new MedicalRecord("Headache", "The pet has headache", 19, 3, 2019);
		mr2.setThePetRecord(pet2);
		md2.getMedicalRecordV().add(mr2);
		myVeterinary.getClientVeterinary().add(client2);
		client2.getPetClient().add(pet2);
		pet2.setHistory(md2);
		myVeterinary.getMinirooms()[1].setPetRoom(pet2);

	}
}
