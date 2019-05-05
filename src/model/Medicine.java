package model;

public class Medicine {

	//ATRIBUTOS
	
	private String name;
	private String dose;
	private double price;
	private int frecuency;
	
	//CONSTRUCTOR
	
	public Medicine(String name, String dose, double price, int frecuency) {
		this.name = name;
		this.dose = dose;
		this.price = price;
		this.frecuency=frecuency;
	}

	/**
	 * Description The method allows to obtain the name of the medicine. 
	 * pre:Existence of an attribute called medicine
	 * 
	 * @return A String representing the name of medicine of the medical record
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Description The method allows to set the name of medicine. 
	 * pre:Existence of an attribute called name
	 * post: the name is set by the parameter 
	 * 
	 * @param name the name of medicine
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Description The method allows to obtain the dose of the medicine. 
	 * pre:Existence of an attribute called dose
	 * 
	 * @return A double representing the dose of medicine of the medical record
	 */
	public String getDose() {
		return dose;
	}
	
	/**
	 * Description The method allows to set the dose of the medicine. 
	 * pre:Existence of an attribute called dose
	 * post: the dose is set by the parameter 
	 * 
	 * @param dose the dose of medicine
	 */

	public void setDose(String dose) {
		this.dose = dose;
	}

	/**
	 * Description The method allows to obtain the price of the medicine. 
	 * pre:Existence of an attribute called price
	 * 
	 * @return A double representing the price of medicine of the medical record
	 */
	public double getPrice() {
		return price;
	}

	
	/**
	 * Description The method allows to set the name of price of the medicine. 
	 * pre:Existence of an attribute called price
	 * post: the price is set by the parameter 
	 * 
	 * @param price the price of medicine
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Description The method allows to obtain the frecuency of the medicine. 
	 * pre:Existence of an attribute called frecuency
	 * 
	 * @return A double representing the frecuency of medicine of the medical record
	 */
	public int getFrecuency() {
		return frecuency;
	}
	
	
	/**
	 * Description The method allows to set the frecuency. 
	 * pre:Existence of an attribute called frecuency
	 * post: the frecuency is set by the parameter 
	 * 
	 * @param frecuency the frecuency of medicine
	 */
	public void setFrecuency(int frecuency) {
		this.frecuency=frecuency;
	}
	
	
}
