package com.proyecto.trivialpolyur;

public class Tarjetas_Edificios extends Tarjetas_Tablero {
	private int coste1;//Coste de alquiler impuesto por 1 de las 4 casillas
	private int coste2;//Coste de alquiler impuesto por 2 de las 4 casillas
	private int coste3;//Coste de alquiler impuesto por 3 de las 4 casillas
	private int coste4;//Coste de alquiler impuesto por 4 de las 4 casillas
	
	public Tarjetas_Edificios(int id, String cat, String des, int cred, int imagen, int coste1, int coste2, int coste3, int coste4){
		super(id, cat, des, cred, imagen);
	
		this.coste1=coste1;
		this.coste2=coste2;
		this.coste3=coste3;
		this.coste4=coste4;
		
	}
	
	public void set_Coste1(int coste1){
		this.coste1=coste1;
	}
	
	public void set_Coste2(int coste2){
		this.coste2=coste2;
	}
	
	public void set_Coste3(int coste3){
		this.coste1=coste3;
	}
	
	public void set_Coste4(int coste4){
		this.coste2=coste4;
	}
	
	public int get_Coste1(){
		return this.coste1;
	}
	
	public int get_Coste2(){
		return this.coste2;
	}
	
	public int get_Coste3(){
		return this.coste3;
	}
	
	public int get_Coste4(){
		return this.coste4;
	}
}
