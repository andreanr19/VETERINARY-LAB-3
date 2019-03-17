package model;
import java.util.ArrayList;

public class Client {
	
	//ATRIBUTOS
	private String name;
	private int id;
	private String address;
	private int phone;
	
	//RELACION MASCOTAS DEL CLIENTE
	
	private ArrayList<Pet> petClient;
	

	//CONSTRUCTOR
	public Client(String name, int id, String address, int phone){

		this.name=name;
		this.id=id;
		this.address=address;
		this.phone=phone;
		
		petClient = new ArrayList<Pet>();
	}
	
	
	//MÉTODOS GET Y SET
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public int getPhone(){
		return phone;
	}
	public void setPhone(int phone){
		this.phone=phone;
	}

}
