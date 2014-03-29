package com.proyecto.trivialpolyur;

public class Tarjetas_Tablero {
	
	private int id;//¿?
	private String categoria;
	private String descripcion;
	private int creditos;
	private int turnos;
	private boolean comprado;
	
	//Costes para subir de nivel
	private int matricula1;
	private int matricula2;
	private int matricula3;
	private int matricula4;
	private int licenciado;
	
	public Tarjetas_Tablero(){}
	
	public Tarjetas_Tablero(String cat, String des, int cred, int t, int m1, int m2, int m3, int m4, int licen){
		this.categoria=cat;
		this.descripcion=des;
		this.creditos=cred;
		this.turnos=t;
		this.comprado=false;
		
		this.matricula1=m1;
		this.matricula2=m2;
		this.matricula3=m3;
		this.matricula4=m4;
		this.licenciado=licen;
	}
	
	//----------- METODOS GET ------------
	public String get_Categoria(){
		return this.categoria;
	}
	
	public String get_Descripcion(){
		return this.descripcion;
	}
	
	public int get_Creditos(){
		return this.creditos;
	}
	
	public int get_Turnos(){
		return this.turnos;
	}
	
	public boolean get_Comprado(){
		return this.comprado;
	}
	
	public int get_Mat1(){
		return this.matricula1;
	}
	
	public int get_Mat2(){
		return this.matricula2;
	}
	
	public int get_Mat3(){
		return this.matricula3;
	}
	
	public int get_Mat4(){
		return this.matricula4;
	}
	
	public int get_Licenciado(){
		return this.licenciado;
	}
	
	//----------- METODOS SET ------------
	public void set_Categoria(String cat){
		this.categoria=cat;		
	}
	
	public void set_Descripcion(String des){
		this.descripcion=des;
	}
	
	public void set_Creditos(int cred){
		this.creditos=cred;
	}
	
	public void set_Turnos(int t){
		this.turnos=t;
	}
	
	public void set_Comprado(boolean c){
		this.comprado=c;
	}
	
	public void set_Mat1(int m1){
		this.matricula1=m1;
	}
	
	public void set_Mat2(int m2){
		this.matricula2=m2;
	}
	
	public void set_Mat3(int m3){
		this.matricula3=m3;
	}
	
	public void set_Mat4(int m4){
		this.matricula4=m4;
	}
	
	public void set_Licenciado(int licen){
		this.licenciado=licen;
	}
	
}
