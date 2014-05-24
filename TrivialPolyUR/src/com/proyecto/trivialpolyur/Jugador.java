package com.proyecto.trivialpolyur;
import java.util.ArrayList;

import android.graphics.drawable.Drawable;


public class Jugador {
	private String nombre;
	private int creditos=20000;
	private int turnos=0;
	private boolean activo=true;
	private ArrayList<Tarjetas_Edificios> tarjetasEdificio=new ArrayList<Tarjetas_Edificios>();
	private ArrayList<Tarjetas_Servicios> tarjetasServicio=new ArrayList<Tarjetas_Servicios>();
	
	public ArrayList<Tarjetas_Edificios> getTarjetasEdificio() {
		return tarjetasEdificio;
	}

	public ArrayList<Tarjetas_Servicios> getTarjetasServicio() {
		return tarjetasServicio;
	}

	public void setTarjetasServicio(ArrayList<Tarjetas_Servicios> tarjetasServicio) {
		this.tarjetasServicio = tarjetasServicio;
	}

	public void setTarjetasEdificio(ArrayList<Tarjetas_Edificios> tarjetasEdificio) {
		this.tarjetasEdificio = tarjetasEdificio;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}

	//private ArrayList<Tarjetas_Tablero> baraja_tarjetas_jugador = new ArrayList<Tarjetas_Tablero>();
	private int color;
	private int[] posicion;
	private int ficha;
	private ArrayList<Tarjetas_Tablero> tarjetas=new ArrayList<Tarjetas_Tablero>();
	
	
	public ArrayList<Tarjetas_Tablero> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(ArrayList<Tarjetas_Tablero> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public int getFicha() {
		return ficha;
	}

	public void setFicha(int ficha) {
		this.ficha = ficha;
	}

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
	
	/*public ArrayList<Tarjetas_Tablero> get_ListadoTarjetas(){
		return this.baraja_tarjetas_jugador;		
	}*/
	
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
	/*
	public void set_ListadoTarjetas(ArrayList<Tarjetas_Tablero> list_t){
		this.baraja_tarjetas_jugador=list_t;
	}*/
	
	public void setPosicionTablero(int t){
		this.posicionTablero=t;
	}
	
	//---------- OTROS METODOS AUXILIARES ---------------
	public void ComprarTarjetas(Tarjetas_Titulaciones tarjetas){
		this.tarjetas.add(tarjetas);
	}
	
}

