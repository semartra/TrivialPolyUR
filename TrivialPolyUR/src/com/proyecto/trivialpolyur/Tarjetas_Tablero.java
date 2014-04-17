package com.proyecto.trivialpolyur;

public abstract class Tarjetas_Tablero {
	
	private int id;//¿?
	private String categoria;//Categoria a la que pertence
	private String descripcion;//Breve descripcion de la tarjeta
	private int creditos;//Coste de adquisicion de la casilla
	private int imagen;
//	

	public Tarjetas_Tablero(){}
	
	public Tarjetas_Tablero(int id, String cat, String des, int cred, int imagen){
		this.id=id;
		this.categoria=cat;
		this.descripcion=des;
		this.creditos=cred;
		this.imagen=imagen;
	}
	
	//----------- METODOS GET ------------
	
	public int get_Id(){
		return this.id;
	}
	
	public String get_Categoria(){
		return this.categoria;
	}
	
	public String get_Descripcion(){
		return this.descripcion;
	}
	
	public int get_Creditos(){
		return this.creditos;
	}
	
	public int get_Imagen(){
		return this.imagen;
	}
	
	//----------- METODOS SET ------------
	
	public void set_Id(int id){
		this.id=id;
	}
	
	public void set_Categoria(String cat){
		this.categoria=cat;
	}
	
	public void set_Descripcion(String des){
		this.descripcion=des;
	}
	
	public void set_Creditos(int cred){
		this.creditos=cred;
	}
	
	public void set_Imagen(int imagen){
		this.imagen=imagen;
	}
	
	

	
	
	
}
