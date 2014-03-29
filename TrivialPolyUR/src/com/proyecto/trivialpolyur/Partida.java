package com.proyecto.trivialpolyur;
import java.util.ArrayList;
import java.util.HashMap;


public class Partida {

	private static Partida partida = null;
	
	public static Partida Instancia(){
		if(partida==null){
			partida=new Partida();
		}
		return partida;
	}
	
	private HashMap<Integer,Jugador> jugadores=new HashMap<Integer,Jugador>();
	
	//private ArrayList<Jugador> jugadores;//Guarda un array con todos los jugadores de la partida
	private Tablero tablero;//Guarda el tablero de la partida
	
	private Jugador jugador_actual;
	
	private int res_dado;//Guarda el resultado de la ultima tirada
	
	private int turno_jugador;//Guarda el jugador actual
	private int turno_partida;
	
	//-------------- CONSTRUCTORES ---------------------------------------
	private Partida(){
		this.tablero=new Tablero();
		
		this.res_dado=0;
		
		this.turno_partida=0;
		this.turno_jugador=1;
	}
	
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
	}
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
		this.jugadores.put(this.turno_jugador, this.jugador_actual);
		
		switch(this.turno_jugador){
			case 4://Modificar el numero de jugadores es variable
				//Siguente TurnoJugador
				this.turno_jugador=1;				
				break;
			default:				
				//Siguente TurnoJugador
				this.Turno_Siguiente_Jugador();				
				break;
		}
		
		//Obtengo el siguiente Jugador
		this.jugador_actual=this.jugadores.get(jugador_actual);
		
		//Incremento el Turno de la partida
		this.Turno_Siguiente_Partida();
		
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
