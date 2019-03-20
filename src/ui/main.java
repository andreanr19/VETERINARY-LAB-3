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
			String options = "1.To know Veterinary's information " + "\n2.To register "
					+ "\n3.To register a pet and his owner " + "\n4.To discharge from the veterinary a pet "
					+ "\n5.To look for the open Medical History "
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
						for (int i = 0; i < myVeterinary.getMinirooms().length; i++) {
							if (myVeterinary.getMinirooms()[i].getPet() == false) {
								contador++;
							} else {
								myVeterinary.getMinirooms()[i].setPetRoom(newPet);
							}
							
						}
						String msj = "";
						if (contador == myVeterinary.getMinirooms().length) {
							msj += "No hay cuartos disponibles";
							System.out.println(msj);
						} else {
							msj += "La mascota ha sido añadida al cuarto " + (contador + 1);
							System.out.println(msj);
							
							System.out.println("Deme el sintoma que presenta la mascota");
							String newPetSymptom= input.nextLine();
							System.out.println("Deme una breve descripcion de lo que afecta a su mascota");
							String newPetDiagnosis= input.nextLine();
							System.out.println("Ingrese la fecha actual dd/mm/aa");
							int newDay=Integer.parseInt(input.nextLine());
							int newMonth=Integer.parseInt(input.nextLine());
							int newYear=Integer.parseInt(input.nextLine());
							
							MedicalRecord newMrPet = new MedicalRecord(newPetSymptom, newPetDiagnosis, newDay, newMonth, newYear);
							newMrPet.setThePetRecord(newPet);
							
							MedicalHistory newMdPet = new MedicalHistory();
							newMdPet.getMedicalRecordV().add(newMrPet);
							newMdPet.setTheClient(newClient);
							newMdPet.setThePet(newPet);
							System.out.println("Se ha creado exitosamente la historia clinica de la mascota");
						}
						
						

					}

				} else {
					System.out.println("El cliente ya se encuentra registrado");
				}
			} else if (option == 3) {
				System.out.println(myVeterinary.showInformation());
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
		md1.getMedicalRecordV().add(mr2);
		myVeterinary.getClientVeterinary().add(client2);
		client1.getPetClient().add(pet2);
		pet1.setHistory(md2);
		myVeterinary.getMinirooms()[1].setPetRoom(pet2);

	}
}
