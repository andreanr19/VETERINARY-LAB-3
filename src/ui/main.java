package ui;

import java.util.Scanner;

import model.*;

public class main {

	public static void main(String[] args) {
		Veterinary myVeterinary = new Veterinary("Mi Pequeña Mascota", "kra_4 #15-77", "2670039", "1010138801");
		InitializeAll(myVeterinary);
		Scanner input = new Scanner(System.in);
		System.out.println("would you like to start? say yes");
		while (input.nextLine().equalsIgnoreCase("yes")) {

			System.out.println("WELCOME TO THE VETERINARY. WHAT WOULD YOU LIKE TO DO?");
			String options = "1.To know the veterinary's information " 
					+ "\n2.To register a client and a pet "
					+ "\n3.To show the rooms actually availables"
					+ "\n4.To look for the current pets in the rooms"
					+ "\n5.To look for the historial clinical of a pet "
					+ "\n6.To discharge from the veterinary a pet "
					+ "\n7.To calculate the cost of hospitalization of a pet "
					+ "\n8.To know the income based on hospitalizations";
					
			System.out.println(options);
			int option = Integer.parseInt(input.nextLine());
			if (option == 1) {
				System.out.println(myVeterinary.toString());
			} else if (option == 2) {
				System.out.println("Enter your ID");
				int idNewClient = Integer.parseInt(input.nextLine());
				if (myVeterinary.verifyClientExistance(idNewClient) == false) {

					System.out.println(
							"This client isn't registered yet. To register, enter the following information");

					System.out.println("Enter the client's name");
					String nameNewClient = input.nextLine();
					System.out.println("Enter the client's ID");
					idNewClient = Integer.parseInt(input.nextLine());
					System.out.println("Enter the client's address");
					String addressNewClient = input.nextLine();
					System.out.println("Enter the client's phone");
					int phoneNewClient = Integer.parseInt(input.nextLine());

					Client newClient = new Client(nameNewClient, idNewClient, addressNewClient, phoneNewClient);
					myVeterinary.getClientVeterinary().add(newClient);

					System.out.println("The client has been registered");

					System.out.println("Now register the information's of the pet's client");
					System.out.println("Enter the name of the client's pet");
					String nameNewPet = input.nextLine();
					System.out.println("Enter the age of the client's pet");
					int ageNewPet = Integer.parseInt(input.nextLine());
					System.out.println("Enter the weigth of the client's pet");
					int weigthNewPet = Integer.parseInt(input.nextLine());
					System.out.println(
							"Enter D if the pet is a dog, C if the pet is a cat, B if the pet is a Bird, enter O if is other");
					char typeNewPet = input.nextLine().charAt(0);

					Pet newPet = new Pet(nameNewPet, ageNewPet, weigthNewPet, typeNewPet);
					newClient.getPetClient().add(newPet);

					System.out.println("Is the pet gonna be hospitalize? \n1.Yes \n2.No");
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
							msj += "There's no rooms available";
							System.out.println(msj);
						} else {
							msj += "The pet has been added to the room " + (contador + 1);
							System.out.println(msj);

							System.out.println("Enter the symptom the pets presents");
							String newPetSymptom = input.nextLine();
							
							
							
							System.out.println("Enter a brief description of what affects the pet");
							String newPetDiagnosis = input.nextLine();
							System.out.println("Enter the current day");
							int newDay = Integer.parseInt(input.nextLine());
							System.out.println("Enter the current month");
							int newMonth = Integer.parseInt(input.nextLine());
							System.out.println("Enter the current year");
							int newYear = Integer.parseInt(input.nextLine());
							System.out.println("Enter the day the pet is gonna be discharged");
							int newDayOut = Integer.parseInt(input.nextLine());
							System.out.println("Enter the month the pet is gonna be discharged");
							int newMonthOut = Integer.parseInt(input.nextLine());
							System.out.println("Enter the year the pet is gonna be discharged");
							int newYearOut = Integer.parseInt(input.nextLine());

							MedicalRecord newMrPet = new MedicalRecord(newPetSymptom, newPetDiagnosis, newDay, newMonth,
									newYear, newDayOut, newMonthOut, newYearOut);
							
							
							
							newMrPet.setThePetRecord(newPet);

							MedicalHistory newMdPet = new MedicalHistory();
							newMdPet.getMedicalRecordV().add(newMrPet);
							newMdPet.setTheClient(newClient);
							newMdPet.setThePet(newPet);

							newPet.setHistory(newMdPet);
							
							System.out.println("Enter the medicine for the pet");
							String nameNewMedicinePet= input.nextLine();
							System.out.println("Enter the dose of medicine for the pet");
							String doseNewMedicinePet= input.nextLine();
							System.out.println("Enter the medicine price");
							double priceNewMedicinePet= Double.parseDouble(input.nextLine());
							
							Medicine newMedicineNewPet = new Medicine(nameNewMedicinePet, doseNewMedicinePet, priceNewMedicinePet);
							newMrPet.getMedicinePet().add(newMedicineNewPet);
							

							
							
							
							System.out.println("The pet's medical history has been successfully created");
						}

					}else if(answer ==2) {
						String msj= "The pet has been registered in the veterinary system";
						System.out.println(msj);
					}

				} else {
					System.out.println("The client is already registered in the Veterinary's System");
				}
			} else if (option ==3) {
				System.out.println(myVeterinary.ShowRoomsAvaliables());
			} else if (option == 4) {
				System.out.println(myVeterinary.showInformation());
			} else if (option == 5) {
				System.out.println(myVeterinary.showInformationHistorial());
			} else if (option == 6) {
				System.out.println("Input the pet's owner's name you want to discharge from the veterinary");
				String ownerPetDischarge = input.nextLine();
				System.out.println("Input the pet's name you want to discharge from veterinary");
				String namePetDischarge = input.nextLine();
				for (int i = 0; i < myVeterinary.getMinirooms().length; i++) {
					
					//System.out.println(myVeterinary.getMinirooms()[i].getPetRoom().getName());
					
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
								break; 	// termina el ciclo automaticamente apenas encuentre la mascota
							}
						}
						break;	//se sale del todo
					}
				}
				System.out.println("The pet has been discharged");

			}else if(option==7) {
				System.out.println(myVeterinary.calculateCostOfHospitalization());
			}else if(option==8) {
				System.out.println(myVeterinary.calculateEarnings());
			}
			System.out.println("WOULD YOU LIKE TO CONTINUE THE APP? SAY YES");
		}
	}

	public static void InitializeAll(Veterinary myVeterinary) {
		// info1
		Client client1 = new Client("Larry", 66885666, "Diag 4 #16", 31555);
		Pet pet1 = new Pet("Marie", 5, 7.0, 'D');
		MedicalHistory md1 = new MedicalHistory();
		md1.setTheClient(client1);
		md1.setThePet(pet1);
		MedicalRecord mr1 = new MedicalRecord("GripaFlu", "The pet has flu", 20, 3, 2019, 6, 4, 2019);
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
		Pet pet2 = new Pet("Pablo", 2, 3.0, 'C');
		MedicalHistory md2 = new MedicalHistory();
		md2.setTheClient(client2);
		md2.setThePet(pet2);
		MedicalRecord mr2 = new MedicalRecord("Headache", "The pet has headache", 19, 2, 2019, 20, 4, 2019);
		Medicine medicinePet2 = new Medicine("Acetaminofen", "5 ml", 4000);
		mr2.getMedicinePet().add(medicinePet2);
		mr2.setThePetRecord(pet2);
		md2.getMedicalRecordV().add(mr2);
		myVeterinary.getClientVeterinary().add(client2);
		client2.getPetClient().add(pet2);
		pet2.setHistory(md2);
		myVeterinary.getMinirooms()[1].setPetRoom(pet2);

	}
}
