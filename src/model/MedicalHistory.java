package model;
import java.util.ArrayList;

public class MedicalHistory {

	//ATRIBUTOS
	
	private String nameOwner;
	private int idOwner;
	private String namePet;
	
	
	//RELACIONES
	
	private ArrayList<MedicalRecord> medicalRecordV; //historias clinicas de una mascota
	private Client theClient;
	private Pet thePet;
	
	//CONSTRUCTOR
	
	public MedicalHistory() {
		theClient=null;
		thePet=null;
		
		medicalRecordV= new ArrayList<MedicalRecord>();
	}

	public String getNameOwner() {
		return theClient.getName();
	}

//	public void setNameOwner(String nameOwner) {
//		this.nameOwner = nameOwner;
//	}

	public int getIdOwner() {
		return theClient.getId();
	}

//	public void setIdOwner(int idOwner) {
//		this.idOwner = idOwner;
//	}

	public String getNamePet() {
		return thePet.getName();
	}

//	public void setNamePet(String namePet) {
//		this.namePet = namePet;
//	}

	public Client getTheClient() {
		return theClient;
	}
	public void setTheClient(Client theClient) {
		this.theClient=theClient;
	}
	public Pet getThePet() {
		return thePet;
	}
	public void setThePet(Pet thePet) {
		this.thePet=thePet;
	}
	public ArrayList<MedicalRecord> getMedicalRecordV() {
		return medicalRecordV;
	}

	public void setMedicalRecordV(ArrayList<MedicalRecord> medicalRecordV) {
		this.medicalRecordV = medicalRecordV;
	}
}
