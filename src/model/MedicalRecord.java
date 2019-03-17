package model;
import java.util.ArrayList;

public class MedicalRecord {
	
	//ATRIBUTOS
	
	public final static String OPEN = "Open";
	public final static String CLOSED = "Closed";
	
	private double weigth;
	private String type;
	private String status;
	private String symptom;
	private String diagnosis;
	
	//RELACIONES
	
	private ArrayList<Medicine> medicinePet; //medicinas que ha recibido la mascota

	//CONSTRUCTOR
	public MedicalRecord(double weigth, String type, String status, String symptom, String diagnosis) {
		
		this.weigth = weigth;
		this.type = type;
		this.status = status;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		
		medicinePet= new ArrayList<Medicine>();
	}
	
	
	
	
}
