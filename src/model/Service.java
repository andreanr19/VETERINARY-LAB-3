package model;

public class Service {

	public final static double SHOWER = 20000.0;
	public final static double SHOWERDOMICILE = 30000.0;
	public final static double NAILSCUT = 8000.0;
	public final static double PROPHYLAXIS = 12000.0;
	public final static double VACCINATION = 45000.0;

	public final static String SHOWERSERVICE = "Shower Service";
	public final static String SHOWERDOMICILESERVICE = "Shower Service Domicile";
	public final static String NAILSCUTSERVICE = "Nails Cut Service";
	public final static String PROPHYLAXISSERVICE = "Prophilaxis Service";
	public final static String VACCINATIONSERVICE = "Vaccination Service";

	// attributes

	private String type;
	private double price;
	private String petName;
	private String petOwner;
	private int idOwner;
	private int day;
	private int month;
	private int year;

	// relationship

	private Pet petService;
	private Client theClientService;

	public Service(String type, double price, int day, int month, int year) {
		this.type = type;
		this.price = price;
		petName = null;
		petOwner = null;
		this.day = day;
		this.month = month;
		this.year = year;
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

	/**
	 * Description The method allows to obtain the type of service. pre:Existence of
	 * an attribute called type
	 * 
	 * @return A String representing the type of the service
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Description The method allows to obtain the price of service. pre:Existence
	 * of an attribute called price
	 * 
	 * @return A String representing the price of the service
	 */
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Description The method allows to obtain the name of the pet's owner that is
	 * receiving the service. pre:Existence of an attribute called nameOwner
	 * 
	 * @return A String representing the name of the pet's owner
	 */
	public String getNameOwner() {
		return theClientService.getName();
	}

//	public void setNameOwner(String nameOwner) {
//		this.nameOwner = nameOwner;
//	}

	/**
	 * Description The method allows to obtain the id of the pet's owner that is
	 * receiving the service. pre:Existence of an attribute called idOwner
	 * 
	 * @return An integer representing the id of the pet's owner
	 */
	public int getIdOwner() {
		return theClientService.getId();
	}

//	public void setIdOwner(int idOwner) {
//		this.idOwner = idOwner;
//	}

	/**
	 * Description The method allows to obtain the name of the pet that is receiving
	 * the service. pre:Existence of an attribute called namePet
	 * 
	 * @return A String representing the name of the pet
	 */
	public String getNamePet() {
		return petService.getName();
	}

//	public void setNamePet(String namePet) {
//		this.namePet = namePet;
//	}

	/**
	 * Description The method allows to obtain the client that is owner of the pet
	 * which is receiving the service. pre:Existence of relationship between client
	 * and the service. The client already has his/her pet.
	 * 
	 * 
	 * @return A String representing the name of the pet's owner
	 */
	public Client getTheClient() {
		return theClientService;
	}

	/**
	 * Description The method allows to set the client of the pet that is receiving
	 * the service pre: The pet and the client are created before post: The client
	 * has been set by parameter for an Client object.
	 * 
	 * @param theClientService list of clients
	 */
	public void setTheClient(Client theClientService) {
		this.theClientService = theClientService;
	}

	/**
	 * Description The method allows to obtain the pet pet which is receiving the
	 * service. pre:Existence of relationship between pet and the service. The pet
	 * is already created.
	 * 
	 * 
	 * @return A String representing the name of the pet's owner
	 */
	public Pet getThePet() {
		return petService;
	}

	/**
	 * Description The method allows to set the pet which is receiving the service
	 * pre: The pet was created before post: The pet that is receiving the service
	 * is set by parameter
	 * 
	 * @param petService pet of the service
	 */
	public void setThePet(Pet petService) {
		this.petService = petService;
	}

	/**
	 * Description The method allows to set the price of the service based on its
	 * type pre: the type of the service should be one of the statics Strings
	 * initialized before post: the price of the service is calculated and set.
	 * 
	 * @param typeService type of service
	 * @return the total price of the services based on its type
	 */

	public double calculatePriceOfService(String typeService) {
		double totalPrice = 0;

		if (typeService.equalsIgnoreCase(SHOWERSERVICE)) {
			totalPrice = SHOWER;
			setPrice(totalPrice);

		} else if (typeService.equalsIgnoreCase(SHOWERDOMICILESERVICE)) {
			totalPrice = SHOWERDOMICILE;
			setPrice(totalPrice);
		} else if (typeService.equalsIgnoreCase(NAILSCUTSERVICE)) {
			totalPrice = NAILSCUT;
			setPrice(totalPrice);
		} else if (typeService.equalsIgnoreCase(PROPHYLAXISSERVICE)) {
			totalPrice = PROPHYLAXIS;
			setPrice(totalPrice);
		} else if (typeService.equalsIgnoreCase(VACCINATIONSERVICE)) {
			totalPrice = VACCINATION;
			setPrice(totalPrice);
		}
		return totalPrice;

	}

	public int toDays() {

		int servicedays = ((year - 1) * 360 + (month - 1) * 30 + day);
		return servicedays;
	}
	
}
