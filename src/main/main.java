package ui;

import java.util.Scanner;
import model.*;

public class main {

	public static void main(String[] args) {
		Veterinary myVeterinary = new Veterinary("Mi Pequeña Mascota", "kra_4 #15-77", "2670039", "1010138801");
		InitializeAll(myVeterinary);
		Scanner input = new Scanner(System.in);
		System.out.println("WELCOME TO THE VETERINARY! WHAT WOULD YOU LIKE TO DO?");
		String options = "1.To know Veterinary's information " + "\n2.To register "
				+ "\n3.To register a pet and his owner " + "\n4.To discharge from the veterinary a pet "
				+ "\n5.To look for the open Medical History " + "\n6.To create a report of the open medical history "
				+ "\n7.To calculate the cost of a hospitalization "
				+ "\n8.To know the income based on hospitalizations " + "\n9.To know a Pet's Room";
		System.out.println(options);
		int option = input.nextInt();
		if (option == 1)
			System.out.println(myVeterinary.toString());
		else if (option == 2)
			System.out.println("Ingrese su Id");
		int idNewClient = input.nextInt();
		if (myVeterinary.verifyClientExistance(idNewClient) == false) {

			System.out.println("Hemos encontrado que usted no está registrado, por lo tanto te vamos a registrar");

			System.out.println("Ingrese su nombre");
			String nameNewClient = input.nextLine();
			System.out.println("Ingrese su Id");
			idNewClient = input.nextInt();
			System.out.println("Ingrese su direccion");
			String addressNewClient = input.nextLine();
			System.out.println("Ingrese su telefono");
			int phoneNewClient = input.nextInt();
			input.nextLine();

			Client newClient = new Client(nameNewClient, idNewClient, addressNewClient, phoneNewClient);
			myVeterinary.getClientVeterinary().add(newClient);
			System.out.println("El cliente ha sido registrado");

		} else {
			System.out.println("El cliente ya se encuentra registrado");
		}
	}

	public static void InitializeAll(Veterinary myVeterinary) {

		Client client1 = new Client("Larry", 66885666, "Diag 4 #16", 31555);
		Pet pet1 = new Pet("Marie", 5, 7.0, 'D');
		MedicalHistory md1 = new MedicalHistory();
		md1.setTheClient(client1);
		md1.setThePet(pet1);
		MedicalRecord mr1 = new MedicalRecord("Open", "GripaFlu", "Tiene gripa");
		mr1.setThePetRecord(pet1);
		//mr1 meterlo en el medical history
		myVeterinary.getClientVeterinary().add(client1);

		Client client2 = new Client("Jesse", 970220, "Kra 3 #2_20", 267554);
		myVeterinary.getClientVeterinary().add(client2);

	}
}
