package model;

public class Medicine {

	//ATRIBUTOS
	
	private String name;
	private String dose;
	private double price;
	
	//CONSTRUCTOR
	
	public Medicine(String name, String dose, double price) {
		this.name = name;
		this.dose = dose;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
