//The package is defined
package ui;

//The libraries are imported
import java.util.*;
import model.*;

//The class is published
public class MainT {

	private Veterinary myVeterinary;
	private Scanner input;

	public MainT() {
		init();
		input = new Scanner(System.in);
	}

	public static void main(String[] args) {

		MainT m = new MainT();
		m.showMenu();

	}

	public void showMenu() {

		int option = 0;

		while (option != 20) {

			showOptions();
			option = input.nextInt();
			input.nextLine();
			if (option == 1) {
				System.out.println(myVeterinary.toString());
			} else if (option == 2) {
				System.out.println("Enter your ID");
				int idNewClient = Integer.parseInt(input.nextLine());
				if (myVeterinary.verifyClientExistance(idNewClient) == false) {

					System.out
							.println("This client isn't registered yet. To register, enter the following information");

					System.out.println("Enter the client's name");
					String nameNewClient = input.nextLine();
//					System.out.println("Enter the client's ID");
//					idNewClient = Integer.parseInt(input.nextLine());
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
					System.out.println("Enter the height of the client's pet");
					int heightNewPet = Integer.parseInt(input.nextLine());
					System.out.println(
							"Enter D if the pet is a dog, C if the pet is a cat, B if the pet is a Bird, enter O if is other");
					char typeNewPet = input.nextLine().charAt(0);

					Pet newPet = new Pet(nameNewPet, ageNewPet, weigthNewPet, heightNewPet, typeNewPet);
					newClient.getPetClient().add(newPet);
					newPet.setOwner(newClient);

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
							myVeterinary.addHistory(newMdPet);

							System.out.println("Enter the medicine for the pet");
							String nameNewMedicinePet = input.nextLine();
							System.out.println("Enter the dose of medicine for the pet");
							String doseNewMedicinePet = input.nextLine();
							System.out.println("Enter the medicine price");
							double priceNewMedicinePet = Double.parseDouble(input.nextLine());
							System.out.println(
									"Enter the frecuency of the application of the medicine on amount of times per day");
							int frecuencyNewMedicinePet = input.nextInt();

							Medicine newMedicineNewPet = new Medicine(nameNewMedicinePet, doseNewMedicinePet,
									priceNewMedicinePet, frecuencyNewMedicinePet);
							newMrPet.getMedicinePet().add(newMedicineNewPet);
							myVeterinary.addHistory(newMdPet);

							Service serviceNewPet = new Service("ninguno", 0);
							newPet.setService(serviceNewPet);
							serviceNewPet.setTheClient(newClient);
							serviceNewPet.setThePet(newPet);
							myVeterinary.addService(serviceNewPet);

							System.out.println("The pet's medical history has been successfully created");
						}

					} else if (answer == 2) {
						String msj = "The pet has been registered in the veterinary system";
						System.out.println(msj);
					}

				} else {
					System.out.println("The client is already registered in the Veterinary's System");
				}
			} else if (option == 3) {
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

					// System.out.println(myVeterinary.getMinirooms()[i].getPetRoom().getName());

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
								break; // termina el ciclo automaticamente apenas encuentre la mascota
							}
						}
						break; // se sale del todo
					}
				}
				System.out.println("The pet has been discharged");

			} else if (option == 7) {
				System.out.println(myVeterinary.calculateCostOfHospitalization());
			} else if (option == 8) {
				System.out.println(myVeterinary.calculateEarnings());
			} else if (option == 9) {
				System.out.println(
						"Wich one of the following clients you wish to change their information? Please enter the name");
				System.out.println(myVeterinary.showInformationOfClients());
				String clientToChange = input.nextLine();
				System.out.println("Enter the new address of the client " + clientToChange);
				String newAddress = input.nextLine();
				System.out.println("Enter the new phone of the client" + clientToChange);
				int newPhone = input.nextInt();
				System.out.println(myVeterinary.changeDataBasic(clientToChange, newAddress, newPhone));

			} else if (option == 10) {
				System.out.println(
						"Wich one of the following pets you wish to add a new medicine to its diagnostic? Please enter the pet's name");
				System.out.println(myVeterinary.showPetsInfo());
				String petNewMedicine = input.nextLine();
				System.out.println("Enter the name of the owner of the pet");
				String ownerPetMedicine = input.nextLine();
				System.out.println("Enter the name of the new medicine");
				String newMedicine = input.nextLine();
				System.out.println("Enter the dose of the medicine in ml");
				String newDoseMedicine = input.nextLine();
				System.out.println("Enter the price of the medicine");
				double newPriceMedicine = Double.parseDouble(input.nextLine());
				System.out.println("Enter the frequency with which the new medicine must be applied per day");
				int newFrecuencyMedicine = input.nextInt();

				myVeterinary.addNewMedicine2(ownerPetMedicine, petNewMedicine, newMedicine, newDoseMedicine,
						newPriceMedicine, newFrecuencyMedicine);

			} else if (option == 11) {

				System.out.println(
						"Wich one of the following pets you wish to add a new note to its diagnostic? Please enter the pet's name");
				System.out.println(myVeterinary.showPetsInfo());
				String nameP = input.nextLine();
				System.out.println("Enter the name of the owner of the pet");
				String nameO = input.nextLine();
				System.out.println("Enter a new note for the diagnostic");
				String diagnosisNote = input.nextLine();
				myVeterinary.addNewNotes(nameO, nameP, diagnosisNote);

			} else if (option == 12) {
				System.out.println(
						"Wich one of the following pets you wish to add a new symptom to its diagnostic? Please enter the pet's name");
				System.out.println(myVeterinary.showPetsInfo());
				String nameP = input.nextLine();
				System.out.println("Enter the name of the owner of the pet");
				String nameO = input.nextLine();
				System.out.println("Enter the new symptom");
				String newSymptom = input.nextLine();
				myVeterinary.addNewSymptomToAMedicalHistory(nameO, nameP, newSymptom);

			} else if (option == 13) {
				System.out.println(myVeterinary.seeTheActualServiceOfAPet());

			} else if (option == 14) {
				System.out.println(
						"Wich one of the following pets you wish to add a new service? Please enter the pet's name");
				System.out.println(myVeterinary.showPetsInfo());
				String nameP = input.nextLine();
				System.out.println("Enter the name of the owner of the pet");
				String nameO = input.nextLine();
				System.out.println("Wich one of the following services you want to add to the pet " + nameP
						+ "? Please enter the name of the service");
				System.out.println(myVeterinary.showInformationServices());

				String typeNewService = input.nextLine();

				myVeterinary.addServiceToAPet(nameO, nameP, typeNewService);

			} else if (option == 15) {
				System.out.println(myVeterinary.calculateEarningsForServices());

			} else if (option == 16) {
				System.out.println(myVeterinary.calculateTotalEarningsOfVeterinary());
			} else if (option == 17) {
				System.out.println(myVeterinary.calculateTheAverageForServices());

			}

		}
	}

	public void showOptions() {
		System.out.println("WELCOME TO THE VETERINARY. WHAT WOULD YOU LIKE TO DO?");
		System.out.println("1.To know the veterinary's information");
		System.out.println("2.To register a client and a pet");
		System.out.println("3.To show the rooms actually availables");
		System.out.println("4.To look for the current pets in the rooms");
		System.out.println("5.To look for the historial clinical of a pet");
		System.out.println("6.To discharge from the veterinary a pet");
		System.out.println("7.To calculate the cost of hospitalization of a pet");
		System.out.println("8.To know the income based on hospitalizations");
		System.out.println("9 To update the basic data of a veterinary client");
		System.out.println("10.To add new medicine on a patient's medical history");
		System.out.println("11.To add new notes to a pet's diagnosis");
		System.out.println("12.To add a new symptom");
		System.out.println("13.To see the services a pet actually has");
		System.out.println("14.To add a service to a pet");
		System.out.println("15.To see the incomes based on services");
		System.out.println("16.To see the TOTAL incomes of the veterinary");
		System.out.println("17.To see the average of income based on services of the veterinary");

	}

	public void init() {
		myVeterinary = new Veterinary("Mi Pequeña Mascota", "kra_4 #15-77", "2670039", "1010138801");
// ----------------------------------------------------------------------------------------------------------------------
		// CLIENT LARRY PET MARIE
		Client client1 = new Client("Larry", 66885666, "Diag 4 #16", 31555); // Client 1 initialized
		Pet pet1 = new Pet("Marie", 5, 7.0, 2, 'D'); // Pet 1 initialized
		MedicalHistory md1 = new MedicalHistory(); // Pet's 1 Medical History initialized
		md1.setTheClient(client1);
		md1.setThePet(pet1);
		MedicalRecord mr1 = new MedicalRecord("GripaFlu", "The pet has flu", 20, 3, 2019, 6, 4, 2019); // Pet's 1
		myVeterinary.addHistory(md1); // Medical
		// Record
		// initialized
		mr1.setThePetRecord(pet1);
		md1.getMedicalRecordV().add(mr1);
		Medicine medicinePet1 = new Medicine("Dolex", "10 ml", 2500, 5); // Pet's 1 Medicine initialized
		mr1.getMedicinePet().add(medicinePet1);
		myVeterinary.getClientVeterinary().add(client1);
		client1.getPetClient().add(pet1);
		pet1.setOwner(client1);
		pet1.setHistory(md1);
		myVeterinary.getMinirooms()[0].setPetRoom(pet1);
		Service servicePet1 = new Service(Service.SHOWERSERVICE, Service.SHOWER);
		pet1.setService(servicePet1);
		servicePet1.setTheClient(client1);
		servicePet1.setThePet(pet1);
		myVeterinary.addService(servicePet1);

//----------------------------------------------------------------------------------------------------------------------	
		// CLIENT LARRY PET RUFUS
		Pet pet11 = new Pet("Rufus", 5, 7.0, 3, 'C'); // Pet 1.1 initialized
		MedicalHistory md11 = new MedicalHistory(); // Pet's 1.1 Medical History initialized
		md11.setTheClient(client1);
		md11.setThePet(pet11);
		MedicalRecord mr11 = new MedicalRecord("Sick of love", "The pet is sick of love", 3, 3, 2019, 4, 4, 2019); // Pet's
																													// 1.1
		myVeterinary.addHistory(md11); // Medical
		// Record
		// initialized
		mr11.setThePetRecord(pet11);
		md11.getMedicalRecordV().add(mr11);
		Medicine medicinePet11 = new Medicine("Aspirina", "5 ml", 5000, 3); // Pet's 1.1 Medicine initialized
		mr11.getMedicinePet().add(medicinePet11);
		client1.getPetClient().add(pet11);
		pet11.setOwner(client1);
		pet11.setHistory(md11);
		myVeterinary.getMinirooms()[2].setPetRoom(pet11);
		Service servicePet11 = new Service(Service.VACCINATIONSERVICE, Service.VACCINATION);
		pet11.setService(servicePet11);
		servicePet11.setTheClient(client1);
		servicePet11.setThePet(pet1);
		myVeterinary.addService(servicePet11);
//----------------------------------------------------------------------------------------------------------------------
//		// CLIENT LARRY PET RUFUS
//		myVeterinary.addANewPetToAClient(client1.getName(), "Rufus", 5, 7, 3, 'C', "Sick of love",
//				"The pet is sick of love", 3, 3, 2019, 4, 4, 2019, "Aspirina", "5", 5000, 3);
//
//		myVeterinary.getMinirooms()[2].setPetRoom(client1.getPetClient().get(1));
//		myVeterinary.addHistory(client1.getPetClient().get(1).getHistory());
//----------------------------------------------------------------------------------------------------------------------		

		// CLIENT JESSE AND PET PABLO

		Client client2 = new Client("Jesse", 970220, "Kra 3 #2_20", 267554); // Client 2 initialized
		Pet pet2 = new Pet("Pablo", 2, 3.0, 1, 'C'); // Pet 2 initialized
		MedicalHistory md2 = new MedicalHistory(); // Pet's 2 Medical History initialized
		md2.setTheClient(client2);
		md2.setThePet(pet2);
		MedicalRecord mr2 = new MedicalRecord("Headache", "The pet has headache", 19, 2, 2019, 20, 4, 2019); // Pet's 2
																												// Medical
																												// Record
																												// initialized
		Medicine medicinePet2 = new Medicine("Acetaminofen", "5 ml", 4000, 3); // Pet's 1 Medicine initialized
		mr2.getMedicinePet().add(medicinePet2);
		mr2.setThePetRecord(pet2);
		md2.getMedicalRecordV().add(mr2);
		myVeterinary.getClientVeterinary().add(client2);
		client2.getPetClient().add(pet2);
		pet2.setOwner(client2);
		pet2.setHistory(md2);
		myVeterinary.getMinirooms()[1].setPetRoom(pet2);
		myVeterinary.addHistory(md2);
		Service servicePet2 = new Service(Service.NAILSCUTSERVICE, Service.NAILSCUT);
		pet2.setService(servicePet2);
		servicePet2.setTheClient(client2);
		servicePet2.setThePet(pet2);
		myVeterinary.addService(servicePet2);

		// CLIENT JESSE AND PET ARMIN
		Pet pet22 = new Pet("Armin", 5, 7.0, 3, 'C'); // Pet 1.1 initialized
		MedicalHistory md22 = new MedicalHistory(); // Pet's 1.1 Medical History initialized
		md22.setTheClient(client2);
		md22.setThePet(pet22);
		MedicalRecord mr22 = new MedicalRecord("Sick of love", "The pet is sick of love", 3, 3, 2019, 4, 4, 2019); // Pet's
																													// 1.1
		myVeterinary.addHistory(md22); // Medical
		// Record
		// initialized
		mr22.setThePetRecord(pet22);
		md22.getMedicalRecordV().add(mr22);
		Medicine medicinePet22 = new Medicine("Aspirina", "5 ml", 5000, 3); // Pet's 1.1 Medicine initialized
		mr22.getMedicinePet().add(medicinePet22);
		client2.getPetClient().add(pet22);
		pet22.setOwner(client2);
		pet22.setHistory(md22);
		myVeterinary.getMinirooms()[3].setPetRoom(pet22);
		Service servicePet22 = new Service(Service.VACCINATIONSERVICE, Service.VACCINATION);
		pet22.setService(servicePet22);
		servicePet22.setTheClient(client2);
		servicePet22.setThePet(pet22);
		myVeterinary.addService(servicePet22);

//----------------------------------------------------------------------------------------------------------------------

//		// CLIENT JESSE AND PET ARMIN
//		myVeterinary.addANewPetToAClient(client2.getName(), "Armin", 3, 3, 0.5, 'B', "Wing fracture",
//				"The pet has a fracture in one wing", 5, 5, 2019, 5, 6, 2019, "Cefalexina", "5 ml", 2500, 3);
//		myVeterinary.getMinirooms()[3].setPetRoom(client2.getPetClient().get(1));
//		//myVeterinary.addHistory(client2.getPetClient().get(2).getHistory());
	}
}
