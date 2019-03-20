package model;
import java.util.ArrayList;

public class MedicalRecord {
	
	//ATRIBUTOS
	
	public final static String OPEN = "Open";
	public final static String CLOSED = "Closed";
	
//	private double weigth;
//	private String type;
	
	private String status;
	private String symptom;
	private String diagnosis;
	
	//RELACIONES
	
	private ArrayList<Medicine> medicinePet; //medicinas que ha recibido la mascota
	private Pet thePetRecord;
	//CONSTRUCTOR
	public MedicalRecord(String status, String symptom, String diagnosis) {
		
		
		
		this.status = status;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		
		medicinePet= new ArrayList<Medicine>();
	}

	public double getWeigth() {
		return thePetRecord.getWeigth();
	}

//	public void setWeigth(Pet thePetRecord) {
//		this.thePetRecord=thePetRecord;
//	}

	public char getType() {
		return thePetRecord.getAnimalType();
	}

//	public void setType(Pet thePetRecord) {
//		this.th = type;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public ArrayList<Medicine> getMedicinePet() {
		return medicinePet;
	}

	public void setMedicinePet(ArrayList<Medicine> medicinePet) {
		this.medicinePet = medicinePet;
	}

	public Pet getThePetRecord() {
		return thePetRecord;
	}

	public void setThePetRecord(Pet thePetRecord) {
		this.thePetRecord = thePetRecord;
	}
	
	
	
	
	
	
}
