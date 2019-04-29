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
	
	/**
	 * Description The method allows to obtain the name of the pet's owner. 
	 * pre:Existence of an attribute called nameOwner
	 * 
	 * @return:A String representing the name of the pet's owner
	 */
	public String getNameOwner() {
		return theClient.getName();
	}

	/**
	 * Description The method allows to set the name of owner's pet. 
	 * pre:Existence of an attribute called name
	 * post: the name is set by the parameter 
	 * 
	 * @param name
	 */
	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}
	
	/**
	 * Description The method allows to obtain the id of the pet's owner. 
	 * pre:Existence of an attribute called idOwner
	 * 
	 * @return:A String representing the id of the pet's owner
	 */
	public int getIdOwner() {
		return theClient.getId();
	}

	/**
	 * Description The method allows to set the id of owner's pet. 
	 * pre:Existence of an attribute called id
	 * post: the id is set by the parameter 
	 * 
	 * @param name
	 */

	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}
	
	/**
	 * Description The method allows to obtain the name  of the pet. 
	 * pre:Existence of an attribute called namePet
	 * 
	 * @return:A String representing the name of the pet
	 */
	public String getNamePet() {
		return thePet.getName();
	}

	/**
	 * Description The method allows to set the name of the pet. 
	 * pre:Existence of an attribute called name
	 * post: the name is set by the parameter 
	 * 
	 * @param name
	 */

	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}

	/**
	 * Description The method allows to obtain the Client that is owner of the pet. 
	 * pre:Existence of a relationship between the class ant the client
	 * 
	 * 
	 * @return:A Client object that it's owner of the pet
	 */
	public Client getTheClient() {
		return theClient;
	}
	
	/**
	 * Description The method allows to set the client of the pet which the medical history belongs to.
	 * pre:Existence of a relationship between the class ant the client
	 * post: the client is set by parameter
	 * @param theClient
	 */
	public void setTheClient(Client theClient) {
		this.theClient=theClient;
	}
	
	/**
	 * Description The method allows to obtain the Pet which the medical history belongs to. 
	 * pre:Existence of a relationship between the class ant the Pet
	 * 
	 * 
	 * @return:A Pet object that which the medical history belongs to.
	 */
	public Pet getThePet() {
		return thePet;
	}

	/**
	 * Description The method allows to set the pet which the medical record belongs to
	 * pre:Existence of a relationship between the class ant the Pet
	 * post: the pet is set by parameter
	 * @param thePet
	 */
	public void setThePet(Pet thePet) {
		this.thePet=thePet;
	}
	
	/**
	 * Description The method allows to obtain the list of medical records a pet has. 
	 * pre:Existence of a list of medical record of the pet
	 * 
	 * 
	 * @return:A list of the medical records of a pet.
	 */
	public ArrayList<MedicalRecord> getMedicalRecordV() {
		return medicalRecordV;
	}

	/**
	 * Description The method allows to set the medical record to the medical history
	 * pre: the medical record is created before
	 * post: the medical record is set in the list of medical records
	 * @param medicalRecordV
	 */
	public void setMedicalRecordV(ArrayList<MedicalRecord> medicalRecordV) {
		this.medicalRecordV = medicalRecordV;
	}
	
	/**
	 * Description The method allows to add MedicalRecord objects to the list of medical record
	 * pre: the medical record is created before
	 * post: the medical record is added to the list of medical records.
	 * @param newMedicalrecord
	 */
	public void addnewMedicalRecord(MedicalRecord newMedicalrecord) {
		medicalRecordV.add(newMedicalrecord);
	}
	
	/**
	 * Description The method allows to add new medicine to the diagnosis of a pet
	 * pre: the medicine is created before, the medical record should be open for the medicine to be add.
	 * post: the medicine has been added to de medical record that is in its respective medical history.
	 * @param name
	 * @param dose
	 * @param price
	 * @param frecuency
	 */
	
	public void addNewMedicine(String name, String dose, double price, int frecuency) {
		for(int i=0; i<medicalRecordV.size(); i++) {
			if(medicalRecordV.get(i).getStatus().equals(MedicalRecord.OPEN)) {
				medicalRecordV.get(i).addNewMedicine(name, dose, price, frecuency);
			}
		}
	}
	
	/**
	 * Description The method allows to add new notes to the pet's diagnosis
	 * pre: the medical record should be open for the note to be add.
	 * post: if the medical record is open the note is added.
	 * @param noteDiagnosis
	 */
	public void addNewNotesToAMedicalRecord(String noteDiagnosis) {
		for(int i=0; i<medicalRecordV.size();i++) {
			if(medicalRecordV.get(i).getStatus().equals(MedicalRecord.OPEN)) {
				medicalRecordV.get(i).addDiagnosisNotes(noteDiagnosis);
			}
		}
	}
	
	/**
	 * Description The method allows to add new symptoms to the pet's diagnosis
	 * pre: the medical record should be open for the symptom to be add.
	 * post: if the medical record is open the symptom is added.
	 * @param symptomToAdd
	 */
	public void addNewSymptom(String symptomToAdd) {
		for(int i=0; i<medicalRecordV.size();i++) {
			if(medicalRecordV.get(i).getStatus().equals(MedicalRecord.OPEN)) {
				medicalRecordV.get(i).addSymptomtoTheDiagnosis(symptomToAdd);
			}
		}
	}
}
