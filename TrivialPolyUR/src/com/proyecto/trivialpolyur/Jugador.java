package com.proyecto.trivialpolyur;
import java.util.ArrayList;


public class Jugador {
	private String nombre;
	private int creditos;
	private ArrayList<Tarjetas_Tablero> baraja_tarjetas_jugador = new ArrayList<Tarjetas_Tablero>();
	
	private int turno;
	
	public Jugador(){}
	
	public Jugador(String nom){
		this.nombre=nom;
		this.creditos=0;
	}

	//----------- METODOS GET ------------
	public String get_Nombre(){
		return this.nombre;
	}
	
	public int get_Creditos(){
		return this.creditos;
	}
	
	public ArrayList<Tarjetas_Tablero> get_ListadoTarjetas(){
		return this.baraja_tarjetas_jugador;		
	}
	
	public int get_Turno(){
		return this.turno;
	}
	
	//----------- METODOS SET ------------
	public void set_Nombre(String nom){
		this.nombre=nom;
	}
	
	public void set_Creditos(int cred){
		this.creditos=cred;
	}
	
	public void set_ListadoTarjetas(ArrayList<Tarjetas_Tablero> list_t){
		this.baraja_tarjetas_jugador=list_t;
	}
	
	public void set_Turno(int t){
		this.turno=t;
	}
	
	//---------- OTROS METODOS AUXILIARES ---------------
	public void turno_menos(){
		this.turno--;
	}
}

