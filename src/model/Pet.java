package model;

import java.util.ArrayList;

public class Pet {

	// ATRIBUTOS

	private String name;
	private int age;
	private double weight;
	private double height;
	private char animalType;
	public final static char DOG = 'D';
	public final static char GATO = 'G';
	public final static char BIRD = 'B';
	public final static char OTHER = 'O';

	// RELACION

	private Client owner;
	private MedicalHistory history;
	private Service services;

	// CONSTRUCTOR

	public Pet(String name, int age, double weight, double height, char animalType) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.animalType = animalType;
		this.height = height;

	}

	// Métodos sets and gets

	/**
	 * Description The method allows to obtain the name of the pet. 
	 * pre:Existence of an attribute called name
	 * 
	 * @return A String representing the name of the pet
	 */
	public String getName() {
		return name;
	}

	/**
	 * Description The method allows to set the name of the pet. pre:Existence of an
	 * attribute called name
	 * 
	 * @param name the name of the pet.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Description The method allows to obtain the age of the pet. pre:Existence of
	 * an attribute called age
	 * 
	 * @return An integer representing the age of the pet
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Description The method allows to set the age of the pet 
	 * pre: Existence of an
	 * attribute called age
	 * 
	 * @param age the age of the pet.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** Description The method allows to obtain the type of the pet.
	* pre:Existence of an attribute called type
    *@return A String representing the type of the pet 
    */
	public char getAnimalType() {
		return animalType;
	}

	/** Description the method allows to set the type of the pet.
	 * pre: Existence of an attribute called type
	 * @param animalType the type of pet.
	 */
	public void setAnimalType(char animalType) {
		this.animalType = animalType;
	}
	
	/** Description The method allows to obtain the owner of the pet.
	* pre:Existence of a relationship of the class Pet and the class Client.
    *@return A object of type Client representing the owner of the pet 
    */

	public Client getOwner() {
		return owner;
	}

	/** Description The method allows to set the owner of the pet.
	 * pre:Existence of a relationship of the class Pet and the class Client.
	 * @param owner the owner of the pet.
	 */
	public void setOwner(Client owner) {
		this.owner = owner;
	}

	/** Description The method allows to obtain the medical history of the pet.
	* pre:Existence of a relationship of the class Pet and the class MedicalHistory.
    *@return A object of type MedicalHistory representing the medical history of the pet 
    */
	public MedicalHistory getHistory() {
		return history;
	}

	/** Description The method allows to set the history of the pet.
	 * pre:Existence of a relationship of the class Pet and the class MedicalHistory.
	 * @param history the history of the pet
	 */
	public void setHistory(MedicalHistory history) {
		this.history = history;
	}
	
	/** Description The method allows to obtain the service of the pet.
	* pre:Existence of a relationship of the class Pet and the class Service.
    *@return A object of type Service representing the service of the pet 
    */
	public Service getService() {
		return services;
	}
	
	
	/** Description The method allows to set the service of the pet.
	 * pre:Existence of a relationship of the class Pet and the class Service.
	 * @param services the service of the pet
	 */
	public void setService(Service services) {
		this.services = services;
	}
	
	/** Description The method allows to obtain the weight of the pet.
	* pre:Existence of an attribute called weight.
    *@return A double representing the weight of the pet 
    */
	public double getWeight() {
		return weight;
	}

	/**
	 * Description The method allows to set the weight of the pet 
	 * pre: Existence of an attribute called weight
	 * 
	 * @param weight the weight of the pet.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/** Description The method allows to obtain the height of the pet.
	* pre:Existence of an attribute called height.
    *@return A double representing the height of the pet 
    */
	public double getHeight() {
		return height;
	}

	/**
	 * Description The method allows to set the height of the pet 
	 * pre: Existence of an attribute called height
	 * 
	 * @param height the height of the pet.
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	/**
	 * Description This method allows to calculate the body mass index for a pet.
	 * pre: The pet was created before and its attributes height and weight are not
	 * null neither height must be zero. 
	 * post: The BMI is calculated.
	 * 
	 * @return The pet body mass index.
	 * @throws If the height is zero, so an exception is thrown due to the division
	 *            on zero does not exist.
	 */
	public String calculateBmiOfAPet() {
		String msj="";
		double bmi = 0;
		if(height!=0) {
			bmi += (getWeight() / (getHeight() * getHeight()));
			msj= "The body mass index of the pet " + getName() + " is: " + bmi;
		}else {
			msj= "it's not possible to calculate the body mass index due to the division on zero does not exist";
		}
			
		return msj;
	}
	

	public void addMedicalHistoryToTheNewPet(String nameOwner, int idOwner, String namePet, String symptom,
			String diagnosis, int day, int month, int year, int dayOut, int monthOut, int yearOut, String name,
			String dose, double price, int frecuency) {

		MedicalHistory newMedicalH = new MedicalHistory();
		newMedicalH.setNameOwner(nameOwner);
		newMedicalH.setIdOwner(idOwner);
		newMedicalH.setNamePet(namePet);

		newMedicalH.setTheClient(owner);
		newMedicalH.setThePet(this);

		MedicalRecord newMedicalR = new MedicalRecord(symptom, diagnosis, day, month, year, dayOut, monthOut, yearOut);
		newMedicalH.addnewMedicalRecord(newMedicalR);
		newMedicalH.getMedicalRecordV().add(newMedicalR);
		newMedicalR.setThePetRecord(this);

		Medicine newMedicine = new Medicine(name, dose, price, frecuency);
		newMedicalR.getMedicinePet().add(newMedicine);
		setHistory(newMedicalH);
	}

	//PARA VER CUANTOS EN CUANTOS DIAS DESDE QUE ESTA EN LA VETERIANARIA SE REALIZO EL SERVICIO
	public int daysService() {
		int totalDaysService= (history.getMedicalRecordV().get(0).daysHsinceHumanity() - services.toDays());
		return totalDaysService;
	}
}




