package model;
import java.util.ArrayList;

public class MedicalHistory {

	//ATRIBUTOS
	
	private String nameOwner;
	private int idOwner;
	private String namePet;
	
	//RELACIONES
	
	private ArrayList<MedicalRecord> medicalRecordV; //historias clinicas de una mascota
	
	//CONSTRUCTOR
	
	public MedicalHistory(String nameOwner, int idOwner, String namePet) {
		this.nameOwner=nameOwner;
		this.idOwner=idOwner;
		this.namePet=namePet;
		
		medicalRecordV= new ArrayList<MedicalRecord>();
	}
}
