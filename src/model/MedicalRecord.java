package model;
import java.util.ArrayList;

public class MedicalRecord {
	
	//CONSTANTES
	
	public final static String OPEN = "Open";
	public final static String CLOSED = "Closed";
	
//	private double weigth;
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
	
	//RELACIONES
	
	private ArrayList<Medicine> medicinePet; //medicinas que ha recibido la mascota
	private Pet thePetRecord;
	//CONSTRUCTOR
	public MedicalRecord(String symptom, String diagnosis, int day, int month, int year, int dayOut, int monthOut, int yearOut) {
		
		
		
		this.status = OPEN;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		this.day=day;
		this.month=month;
		this.year=year;
		this.dayOut=dayOut;
		this.monthOut=monthOut;
		this.yearOut=yearOut;
		
		
		medicinePet= new ArrayList<Medicine>();
	}

	public int getDayOut() {
		return dayOut;
	}

	public void setDayOut(int dayOut) {
		this.dayOut = dayOut;
	}

	public int getMonthOut() {
		return monthOut;
	}

	public void setMonthOut(int monthOut) {
		this.monthOut = monthOut;
	}

	public int getYearOut() {
		return yearOut;
	}

	public void setYearOut(int yearOut) {
		this.yearOut = yearOut;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
	
	public int toDays(int days, int months, int years) {
		return (years-1)*360 + (months-1)*30 + days;
	}
	
	public int getTotalDays() {
		int totalDays=0;
		
		totalDays= toDays(dayOut, monthOut, yearOut)- toDays(day, month, year);
		
		return totalDays;
	}
	
	public double priceMedicineTotal() {
		double totalPriceM=0;
		
		for(int i=0; i<medicinePet.size();i++) {
			totalPriceM+=medicinePet.get(i).getPrice();
		}
		return totalPriceM;
	}
	
	
	
}
