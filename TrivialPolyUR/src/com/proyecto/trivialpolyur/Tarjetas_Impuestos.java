package com.proyecto.trivialpolyur;

public class Tarjetas_Impuestos extends Tarjetas_Tablero {
	
	private int coste;//coste de penalizacion de la casilla
	
	public Tarjetas_Impuestos(int id, String cat, String des, int cred, int imagen, int coste){
		super(id, cat, des, cred, imagen);
		
		this.coste=coste;
	}
	
	public void set_Coste(int coste){
		this.coste=coste;
	}
	
	public int get_Coste(){
		return this.coste;
	}
}
