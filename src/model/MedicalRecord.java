package model;

import java.util.ArrayList;

public class MedicalRecord {

	// CONSTANTES

	public final static String OPEN = "Open";
	public final static String CLOSED = "Closed";

//	private double weight;
//	private String type;

	private String status;
	private String symptom;
	private String diagnosis;
	private int day;
	private int month;
	private int year;
	private int dayOut;
	private int monthOut;
	private int yearOut;
	private int toDays;

	// RELACIONES

	private ArrayList<Medicine> medicinePet; // medicinas que ha recibido la mascota
	private Pet thePetRecord;

	// CONSTRUCTOR
	public MedicalRecord(String symptom, String diagnosis, int day, int month, int year, int dayOut, int monthOut,
			int yearOut) {

		this.status = OPEN;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		this.day = day;
		this.month = month;
		this.year = year;
		this.dayOut = dayOut;
		this.monthOut = monthOut;
		this.yearOut = yearOut;

		medicinePet = new ArrayList<Medicine>();
	}
	
	/**
	 * Description The method allows to obtain the day when the pet will be out from the veterinary. 
	 * pre:Existence of an attribute called dayOut
	 * 
	 * @return An integer representing the day of the pet when it'll be discharge from veterinary
	 */
	public int getDayOut() {
		return dayOut;
	}

	/**
	 * Description The method allows to set the day when the pet will be discharge from veterinary
	 * pre: Existence of an attribute called dayOut
	 * post: the day when the pet will be discharge from veterinary has been set
	 * @param dayOut final day of the pet in the vet.
	 */
	public void setDayOut(int dayOut) {
		this.dayOut = dayOut;
	}

	/**
	 * Description The method allows to obtain the month when the pet will be out from the veterinary. 
	 * pre:Existence of an attribute called monthOut
	 * 
	 * @return An integer representing the month of the pet when it'll be discharge from veterinary
	 */
	public int getMonthOut() {
		return monthOut;
	}

	/**
	 * Description The method allows to set the month when the pet will be discharge from veterinary
	 * pre: Existence of an attribute called monthOut
	 * post: the month when the pet will be discharge from veterinary has been set
	 * @param monthOut final month of the pet in the vet.
	 */
	public void setMonthOut(int monthOut) {
		this.monthOut = monthOut;
	}

	/**
	 * Description The method allows to obtain the year when the pet will be out from the veterinary. 
	 * pre:Existence of an attribute called yearOut
	 * 
	 * @return An integer representing the year of the pet when it'll be discharge from veterinary
	 */
	public int getYearOut() {
		return yearOut;
	}

	/**
	 * Description The method allows to set the year when the pet will be discharge from veterinary
	 * pre: Existence of an attribute called yearOut
	 * post: the year when the pet will be discharge from veterinary has been set
	 * @param yearOut final year of the pet in the vet.
	 */
	public void setYearOut(int yearOut) {
		this.yearOut = yearOut;
	}

	/**
	 * Description The method allows to obtain the day when the pet got in to the veterinary. 
	 * pre:Existence of an attribute called day
	 * 
	 * @return An integer representing the day of the pet when it'll be discharge from veterinary
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Description The method allows to set the day when the pet got in to the veterinary
	 * pre: Existence of an attribute called day
	 * post: the day when the pet got in to the veterinary has been set
	 * @param day first day of the pet in the vet.
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Description The method allows to obtain the month when the pet got in to the veterinary. 
	 * pre:Existence of an attribute called day
	 * 
	 * @return An integer representing the day of the pet when it'll be discharge from veterinary
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Description The method allows to set the month when the pet got in to the veterinary
	 * pre: Existence of an attribute called month
	 * post: the month when the pet got in to the veterinary has been set
	 * @param month first month of the pet in the vet.
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Description The method allows to obtain the year when the pet got in to the veterinary. 
	 * pre:Existence of an attribute called year
	 * 
	 * @return An integer representing the year of the pet when it'll be discharge from veterinary
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Description The method allows to set the year when the pet got in to the veterinary
	 * pre: Existence of an attribute called year
	 * post: the year when the pet got in to the veterinary has been set
	 * @param year first year of the pet in the vet.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/** Description The method allows to obtain the weight of the pet.
	* pre:Existence of the relationship between the pet and the medical record, the weight it's not null
    *@return A double representing the weight of the pet 
    */
	public double getWeight() {
		return thePetRecord.getWeight();
	}

//	public void setWeigth(Pet thePetRecord) {
//		this.thePetRecord=thePetRecord;
//	}

	/** Description The method allows to obtain the type of the pet.
	* pre:Existence of the relationship between the pet and the medical record, the type it's not null
    *@return A char representing the type of the pet 
    */
	public char getType() {
		return thePetRecord.getAnimalType();
	}



	/**
	 * Description The method allows to obtain the status of the medical record. 
	 * pre:Existence of an attribute called status
	 * 
	 * @return A String representing the status of the medical record.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Description The method allows to set the status of the medical record
	 * pre: Existance of an attribute called status
	 * post: the status has been set by parameter
	 * @param status the status of the medical record.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Description The method allows to obtain the symptom of the medical record. 
	 * pre:Existence of an attribute called symptom
	 * 
	 * @return A String representing the symptom of the respective the medical record.
	 */
	public String getSymptom() {
		return symptom;
	}

	/**
	 * Description The method allows to set the symptom of the medical record
	 * pre: Existance of an attribute called symptom
	 * post: the symptom has been set by parameter
	 * @param symptom the symptom of the medical record.
	 */
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	/**
	 * Description The method allows to obtain the diagnosis of the medical record. 
	 * pre:Existence of an attribute called diagnosis
	 * 
	 * @return A String representing the of diagnosis of the medical record.
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * Description The method allows to set the diagnosis of the medical record
	 * pre: Existance of an attribute called diagnosis
	 * post: the diagnosis has been set by parameter
	 * @param diagnosis the diagnosis of the medical record.
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	/**
	 * Description The method allows to obtain the list of medicines a medical record have.
	 * pre: Existence of the medicines that the list has.
	 * @return A list of medicines of the medical record.
	 */
	public ArrayList<Medicine> getMedicinePet() {
		return medicinePet;
	}
	
	/**
	 * Description The method allows to set the list of medicines a medical record have
	 * pre: Existence of the medicine that the list has.
	 * post: The list have been modified by parameter with a Medicine object
	 * @param medicinePet the medicine of the medical record.
	 */

	public void setMedicinePet(ArrayList<Medicine> medicinePet) {
		this.medicinePet = medicinePet;
	}

	/**
	 * Description The method allows to obtain the Pet of the medical record.
	 * pre: Existance of the pet
	 * @return The medical record of the pet
	 */
	public Pet getThePetRecord() {
		return thePetRecord;
	}

	/**
	 * Description The method allows to set the pet of the medical record
	 * pre: Existance of the pet
	 * post: the pet of the medical record has been set by parameter
	 * @param thePetRecord the pet of the medical record.
	 */
	public void setThePetRecord(Pet thePetRecord) {
		this.thePetRecord = thePetRecord;
	}

	/**
	 * Description The method allows to convert into days all the time the pet 
	 * is in the veterinary since its medical record where open to when it is closed
	 *  pre: Existance of the date of admission and the departure date
	 *  post: The days are calculated
	 * @param days firs day of the pet in the vet
	 * @param months first month of the pet in the vet
	 * @param years first year of the pet in the vet
	 * @return An integer with the days the pet has been in the veterinary
	 */
	public int toDays(int days, int months, int years) {
		return (years - 1) * 360 + (months - 1) * 30 + days;
	}

	/**
	 * Description The method allows to convert into days all the time the pet 
	 * is in the veterinary since its medical record where open to when it is closed
	 *  pre: Existance of the date of admission and the departure date
	 *  post: The days are calculated
	 * @param days last day of the pet in the vet.
	 * @param months last month of the pet in the vet.
	 * @param years last year of the pet in the vet.
	 * @return An integer with the days the pet has been in the veterinary
	 */
	public int getTotalDays() {
		int totalDays = 0;

		totalDays = toDays(dayOut, monthOut, yearOut) - toDays(day, month, year);

		return totalDays;
	}
	
	/**
	 * Description The method allows to calculate the cost of all 
	 * the list of medicines of all the medical records in the veterinary
	 * pre: The medicine is not null and it has been created before
	 * post: the cost of all the medicines has been calculated
	 * @return a double with the total price of all the medicines
	 */

	public double priceMedicineTotal() {
		double totalPriceM = 0;

		for (int i = 0; i < medicinePet.size(); i++) {
			totalPriceM += medicinePet.get(i).getPrice();
		}
		return totalPriceM;
	}

	/**
	*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New medicines were added to the patient clinic story.
	*@param The medicine name. This param must be not null.
	*@param The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
	*@param The medicine cost by each dose. This param could be empty.
	*@param The frequency of medicine application. This param could be empty.
	*@return A message that indiques if medicine was added to the patient clinic story
	*/

	public void addNewMedicine(String name, String dose, double price, int frecuency) {
		Medicine newMedicineToAdd = new Medicine(name, dose, price, frecuency);
		medicinePet.add(newMedicineToAdd);

	}
	
	/**
	*Description This method allows to add new notes that were prescription during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New notes were added to the patient clinic story.
	*@param The notes. This param must be not null.

	*/
	public void addDiagnosisNotes(String noteDiagnosis) {
		String diagnosisNote = getDiagnosis();
		diagnosisNote = getDiagnosis() + "\n" + noteDiagnosis;
		setDiagnosis(diagnosisNote);
	}
	
	/**
	*Description This method allows to add new symptoms that were prescription during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New symptoms were added to the patient clinic story.
	*@param The symptom. This param must be not null.

	*/
	public void addSymptomtoTheDiagnosis(String symptomToAdd) {
		String symptomAdd = getSymptom();
		symptomAdd = getSymptom() + "\n"+ symptomToAdd;
		setSymptom(symptomAdd);
		
	}
	public int daysHsinceHumanity() {
		int totalDays= ((yearOut-1)*360 + (monthOut-1)*30 + dayOut);
		return totalDays;
		
	}
	
	public int dayss() {
		int totaldayss=((yearOut-1)*360 + (monthOut-1)*30 + dayOut);
		return totaldayss;
	}
	//PARA VER CUANTOS DIAS LLEVA EN LA VETERINARIA
	public int daysH() {
		int totalDaysH= (((yearOut-1)*360 + (monthOut-1)*30 + dayOut) -((year-1)*360 + (month-1)*30 + day));
		return totalDaysH;
	}
}
