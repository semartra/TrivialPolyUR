package com.proyecto.trivialpolyur;
import java.util.ArrayList;
import java.util.HashMap;


public class Partida {

	private static Partida partida = null;
	
	public static Partida Instancia(){
		if(partida==null){
			partida=new Partida();
			crearTarjetas();
		}
		return partida;
	}
	
	private static void crearTarjetas() {
		Tarjetas_Titulaciones t1=new Tarjetas_Titulaciones(1, "Magisterio infantil", "magisterio infantil", 600, R.drawable.casilla02, 500, 20, 100, 300, 900, 1600, 2500);
		Tarjetas_Titulaciones t2=new Tarjetas_Titulaciones(1, "Magisterio primaria", "magisterio primaria", 600, R.drawable.casilla04, 500, 40, 200, 600, 1800, 3200, 4500);
		Tarjetas_Titulaciones t3=new Tarjetas_Titulaciones(1, "Estudios ingleses", "magisterio infantil", 1000, R.drawable.casilla07, 500, 60, 300, 900, 2700, 4000, 5500);
		Tarjetas_Titulaciones t4=new Tarjetas_Titulaciones(1, "Greografia e historia", "magisterio infantil", 1000, R.drawable.casilla09, 500, 60, 300, 900, 2700, 4000, 5500);
		Tarjetas_Titulaciones t5=new Tarjetas_Titulaciones(1, "Lengua y literatura", "magisterio infantil", 1200, R.drawable.casilla10, 500, 80, 400, 1000, 3000, 4500, 6000);
		Tarjetas_Titulaciones t6=new Tarjetas_Titulaciones(1, "Derecho", "magisterio infantil", 1400, R.drawable.casilla12, 1000, 100, 500, 1500, 4500, 6250, 7500);
		Tarjetas_Titulaciones t7=new Tarjetas_Titulaciones(1, "Trabajo social", "magisterio infantil", 1400, R.drawable.casilla14, 1000, 100, 500, 1500, 4500, 6250, 7500);
		Tarjetas_Titulaciones t8=new Tarjetas_Titulaciones(1, "Relaciones laborales", "magisterio infantil", 1600, R.drawable.casilla15, 1000, 120, 600, 1800, 5000, 7000, 9000);
		Tarjetas_Titulaciones t9=new Tarjetas_Titulaciones(1, "Administracion y direccion de empresas", "magisterio infantil", 1800, R.drawable.casilla17, 1000, 140, 700, 2000, 5500, 7500, 9500);
		Tarjetas_Titulaciones t10=new Tarjetas_Titulaciones(1, "Turismo", "magisterio infantil", 1800, R.drawable.casilla19, 1000, 140, 700, 2000, 5500, 7500, 9500);
		Tarjetas_Titulaciones t11=new Tarjetas_Titulaciones(1, "Enfermaría", "magisterio infantil", 2000, R.drawable.casilla20, 1000, 160, 800, 2200, 6000, 8000, 10000);
		Tarjetas_Titulaciones t12=new Tarjetas_Titulaciones(1, "Electrica", "magisterio infantil", 2200, R.drawable.casilla22, 1500, 180, 900, 2500, 7000, 8750, 10500);
		Tarjetas_Titulaciones t13=new Tarjetas_Titulaciones(1, "Electronica", "magisterio infantil", 2200, R.drawable.casilla24, 1500, 180, 900, 2500, 7000, 8750, 10500);
		Tarjetas_Titulaciones t14=new Tarjetas_Titulaciones(1, "Mecanica", "magisterio infantil", 2400, R.drawable.casilla25, 1500, 200, 1000, 3000, 7500, 9250, 11000);
		Tarjetas_Titulaciones t15=new Tarjetas_Titulaciones(1, "Agricola", "magisterio infantil", 2600, R.drawable.casilla27, 1500, 220, 1100, 3300, 8000, 9750, 11500);
		Tarjetas_Titulaciones t16=new Tarjetas_Titulaciones(1, "Enoligia", "magisterio infantil", 2600, R.drawable.casilla28, 1500, 220, 1100, 3300, 8000, 9750, 11500);
		Tarjetas_Titulaciones t17=new Tarjetas_Titulaciones(1, "Quimica", "magisterio infantil", 2800, R.drawable.casilla30, 1500, 240, 1200, 3600, 8500, 10250, 12000);
		Tarjetas_Titulaciones t18=new Tarjetas_Titulaciones(1, "Matematicas", "magisterio infantil", 3000, R.drawable.casilla32, 2000, 260, 1300, 3900, 9000, 11000, 12750);
		Tarjetas_Titulaciones t19=new Tarjetas_Titulaciones(1, "Informatica", "magisterio infantil", 3000, R.drawable.casilla33, 2000, 260, 1300, 3900, 9000, 11000, 12750);
		Tarjetas_Titulaciones t20=new Tarjetas_Titulaciones(1, "Mate-Info", "magisterio infantil", 3200, R.drawable.casilla35, 2000, 280, 1500, 4500, 10000, 12000, 14000);
		Tarjetas_Titulaciones t21=new Tarjetas_Titulaciones(1, "Formacion continua", "magisterio infantil", 3500, R.drawable.casilla38, 2000, 350, 1750, 5000, 11000, 13000, 15000);
		Tarjetas_Titulaciones t22=new Tarjetas_Titulaciones(1, "Experiencia", "magisterio infantil", 4000, R.drawable.casilla40, 2000, 500, 2000, 6000, 14000, 17000, 20000);
		tarjetas.add(t1);
		tarjetas.add(t2);
		tarjetas.add(t3);
		tarjetas.add(t4);
		tarjetas.add(t5);
		tarjetas.add(t6);
		tarjetas.add(t7);
		tarjetas.add(t8);
		tarjetas.add(t9);
		tarjetas.add(t10);
		tarjetas.add(t11);
		tarjetas.add(t12);
		tarjetas.add(t13);
		tarjetas.add(t14);
		tarjetas.add(t15);
		tarjetas.add(t16);
		tarjetas.add(t17);
		tarjetas.add(t18);
		tarjetas.add(t19);
		tarjetas.add(t20);
		tarjetas.add(t21);
		tarjetas.add(t22);
	}

	public HashMap<Integer,Jugador> jugadores=new HashMap<Integer,Jugador>();
	
	static ArrayList<Tarjetas_Tablero> tarjetas=new ArrayList<Tarjetas_Tablero>();
	//private ArrayList<Jugador> jugadores;//Guarda un array con todos los jugadores de la partida
	private Tablero tablero;//Guarda el tablero de la partida
	
	//private Jugador jugador_actual;
	
	private int res_dado;//Guarda el resultado de la ultima tirada
	
	private int turno_jugador;//Guarda el jugador actual
	private int turno_partida;
	

	public void setJugadores(HashMap<Integer,Jugador> jugadores){
		this.jugadores=jugadores;
	}
	
	public HashMap<Integer, Jugador> getJugadores(){
		return this.jugadores;
	}
	
	//-------------- CONSTRUCTORES ---------------------------------------
	private Partida(){
		this.tablero=new Tablero();
		
		this.res_dado=0;
		
		this.turno_partida=0;
		this.turno_jugador=1;
	}
	/*
	public Partida(HashMap<Integer,Jugador> jugadores){
		this.tablero=new Tablero();		
		this.jugadores=jugadores;	
		
		this.res_dado=0;
		
		this.turno_partida=0;
		this.turno_jugador=1;		
	}
	
	public Partida(HashMap<Integer,Jugador> jugadores, Tablero tablero){
		this.tablero=tablero;		
		this.jugadores=jugadores;	
		
		this.res_dado=0;
		
		this.turno_partida=0;
		this.turno_jugador=1;
	}*/
	//---------------------------------------------------------------------
	
	// ------------------ METODOS JUGADOR ACTUAL --------------------------
	public Jugador JugadorActual(){
		return jugadores.get(this.turno_jugador);
	}
	
	public int Num_JugadorActual(){
		return this.turno_jugador;
	}
	//---------------------------------------------------------------------	
		
	
	public void Jugador_Siguiente(){
		
		//Guardo el JugadorActual en 'jugadores'
		//this.jugadores.put(this.turno_jugador, this.jugador_actual);
		
		if(this.jugadores.size()==this.turno_jugador){
			this.turno_jugador=0;
		}
		this.turno_jugador++;
		//return this.jugadores.get(this.turno_jugador);
		
	}
	
	//-------- METODOS PARA LOS TURNOS -----------

	////------ METODOS PARA AVANZAR EN TURNO -----
	public void Turno_Siguiente_Jugador(){
		this.turno_jugador++;
	}
	
	public void Turno_Siguiente_Partida(){
		this.turno_partida++;
	}
	
	////----- METODOS GET PARA TURNOS ------------
}
