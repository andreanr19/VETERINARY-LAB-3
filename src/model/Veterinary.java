package model;
import java.util.ArrayList;
public class Veterinary {
	
	//Cantidad total de minicuartos
	
	public final static int TOTAL_MINIROOMS = 8;
	
	//ATRIBUTOS
	
	private String name; //nombre de la veterinaria
	
	//RELACIONES
	
	private Room[] minirooms; // Minirooms de la veterinaria
	private ArrayList<Client> clientVeterinary; //Clientes de la veterinaria
	private ArrayList<MedicalHistory> history;
	
	
	//CONSTRUCTOR
	
	public Veterinary(String name) {
		this.name=name;
		
		//Crea los minirooms
		
		//Crea los clientes
		clientVeterinary = new ArrayList<Client>();
		
		//crea las historias clinicas de las mascotas
		history = new ArrayList<MedicalHistory>();
		
	}
	
	//GET Y SET
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	

}
