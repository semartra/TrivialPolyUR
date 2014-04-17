package com.proyecto.trivialpolyur;

public class Tarjetas_Servicios extends Tarjetas_Tablero {
	
	private int coste1;//Coste de alquiler impuesto por tener 1 de las 2 casillas
	private int coste2;//Coste de alquiler impuesto por tener las 2 casillas
	
	public Tarjetas_Servicios(int id, String cat, String des, int cred, int imagen, int coste1, int coste2){
		super(id, cat, des, cred, imagen);
	
		this.coste1=coste1;
		this.coste2=coste2;
		
	}
	
	public void set_Coste1(int coste1){
		this.coste1=coste1;
	}
	
	public void set_Coste2(int coste2){
		this.coste2=coste2;
	}
	
	public int get_Coste1(){
		return this.coste1;
	}
	
	public int get_Coste2(){
		return this.coste2;
	}
}
