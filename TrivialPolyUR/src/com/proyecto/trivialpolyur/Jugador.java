package com.proyecto.trivialpolyur;
import java.util.ArrayList;


public class Jugador {
	private String nombre;
	private int creditos;
	private ArrayList<Tarjetas_Tablero> baraja_tarjetas_jugador = new ArrayList<Tarjetas_Tablero>();
	private int color;
	private int[] posicion;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	private int posicionTablero;
	
	public Jugador(){}
	
	public Jugador(String nom){
		this.nombre=nom;
		this.creditos=0;
	}

	public int[] getPosicion() {
		return posicion;
	}

	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
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
	
	public int getPosicionTablero(){
		return this.posicionTablero;
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
	
	public void setPosicionTablero(int t){
		this.posicionTablero=t;
	}
	
	//---------- OTROS METODOS AUXILIARES ---------------
	
}

