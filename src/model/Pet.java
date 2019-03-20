package model;

public class Pet {

	//ATRIBUTOS
	
	private String name;
	private int age;
	private double weigth;
	private char animalType;
	public final static char DOG='D';
	public final static char GATO='G';
	public final static char BIRD='B';
	public final static char OTHER='O';

	
	//RELACION
	
	private Client owner;
	private MedicalHistory history;
	
	//CONSTRUCTOR
	
	public Pet(String name, int age, double weigth, char animalType){
		this.name=name;
		this.age=age;
		this.weigth=weigth;
		this.animalType=animalType;
		
	}

	//Métodos sets and gets

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public char getAnimalType(){
		return animalType;
	}
	public void setAnimalType(char animalType){
		this.animalType=animalType;
	}
	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner=owner;
	}
	public MedicalHistory getHistory() {
		return history;
	}
	public void setHistory(MedicalHistory history) {
		this.history=history;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}
}
