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
	
	/*public void reset(){
		partida.jugadores.clear();
	}*/
	
	private static void crearTarjetas() {
		int[] fondos1={R.drawable.casilla02_1,R.drawable.casilla02_2,R.drawable.casilla02_3,R.drawable.casilla02_4,R.drawable.casilla02_5};
		Tarjetas_Titulaciones t1=new Tarjetas_Titulaciones(1, "Magisterio infantil", "magisterio infantil", 600, R.drawable.casilla02, 500, 20, 100, 300, 900, 1600, 2500,fondos1);
		int[] fondos2={R.drawable.casilla04_1,R.drawable.casilla04_2,R.drawable.casilla04_3,R.drawable.casilla04_4,R.drawable.casilla04_5};
		Tarjetas_Titulaciones t2=new Tarjetas_Titulaciones(2, "Magisterio primaria", "magisterio primaria", 600, R.drawable.casilla04, 500, 40, 200, 600, 1800, 3200, 4500,fondos2);
		int[] fondos3={R.drawable.casilla07_1,R.drawable.casilla07_2,R.drawable.casilla07_3,R.drawable.casilla07_4,R.drawable.casilla07_5};
		Tarjetas_Titulaciones t3=new Tarjetas_Titulaciones(3, "Estudios ingleses", "magisterio infantil", 1000, R.drawable.casilla07, 500, 60, 300, 900, 2700, 4000, 5500,fondos3);
		int[] fondos4={R.drawable.casilla09_1,R.drawable.casilla09_2,R.drawable.casilla09_3,R.drawable.casilla09_4,R.drawable.casilla09_5};
		Tarjetas_Titulaciones t4=new Tarjetas_Titulaciones(4, "Greografia e historia", "magisterio infantil", 1000, R.drawable.casilla09, 500, 60, 300, 900, 2700, 4000, 5500,fondos4);
		int[] fondos5={R.drawable.casilla10_1,R.drawable.casilla10_2,R.drawable.casilla10_3,R.drawable.casilla10_4,R.drawable.casilla10_5};
		Tarjetas_Titulaciones t5=new Tarjetas_Titulaciones(5, "Lengua y literatura", "magisterio infantil", 1200, R.drawable.casilla10, 500, 80, 400, 1000, 3000, 4500, 6000,fondos5);
		int[] fondos6={R.drawable.casilla12_1,R.drawable.casilla12_2,R.drawable.casilla12_3,R.drawable.casilla12_4,R.drawable.casilla12_5};
		Tarjetas_Titulaciones t6=new Tarjetas_Titulaciones(6, "Derecho", "magisterio infantil", 1400, R.drawable.casilla12, 1000, 100, 500, 1500, 4500, 6250, 7500,fondos6);
		int[] fondos7={R.drawable.casilla14_1,R.drawable.casilla14_2,R.drawable.casilla14_3,R.drawable.casilla14_4,R.drawable.casilla14_5};
		Tarjetas_Titulaciones t7=new Tarjetas_Titulaciones(7, "Trabajo social", "magisterio infantil", 1400, R.drawable.casilla14, 1000, 100, 500, 1500, 4500, 6250, 7500,fondos7);
		int[] fondos8={R.drawable.casilla15_1,R.drawable.casilla15_2,R.drawable.casilla15_3,R.drawable.casilla15_4,R.drawable.casilla15_5};
		Tarjetas_Titulaciones t8=new Tarjetas_Titulaciones(8, "Relaciones laborales", "magisterio infantil", 1600, R.drawable.casilla15, 1000, 120, 600, 1800, 5000, 7000, 9000,fondos8);
		int[] fondos9={R.drawable.casilla17_1,R.drawable.casilla17_2,R.drawable.casilla17_3,R.drawable.casilla17_4,R.drawable.casilla17_5};
		Tarjetas_Titulaciones t9=new Tarjetas_Titulaciones(9, "Administracion y direccion de empresas", "magisterio infantil", 1800, R.drawable.casilla17, 1000, 140, 700, 2000, 5500, 7500, 9500,fondos9);
		int[] fondos10={R.drawable.casilla19_1,R.drawable.casilla19_2,R.drawable.casilla19_3,R.drawable.casilla19_4,R.drawable.casilla19_5};
		Tarjetas_Titulaciones t10=new Tarjetas_Titulaciones(10, "Turismo", "magisterio infantil", 1800, R.drawable.casilla19, 1000, 140, 700, 2000, 5500, 7500, 9500,fondos10);
		int[] fondos11={R.drawable.casilla20_1,R.drawable.casilla20_2,R.drawable.casilla20_3,R.drawable.casilla20_4,R.drawable.casilla20_5};
		Tarjetas_Titulaciones t11=new Tarjetas_Titulaciones(11, "Enfermaría", "magisterio infantil", 2000, R.drawable.casilla20, 1000, 160, 800, 2200, 6000, 8000, 10000,fondos11);
		int[] fondos12={R.drawable.casilla22_1,R.drawable.casilla22_2,R.drawable.casilla22_3,R.drawable.casilla22_4,R.drawable.casilla22_5};
		Tarjetas_Titulaciones t12=new Tarjetas_Titulaciones(12, "Electrica", "magisterio infantil", 2200, R.drawable.casilla22, 1500, 180, 900, 2500, 7000, 8750, 10500,fondos12);
		int[] fondos13={R.drawable.casilla24_1,R.drawable.casilla24_2,R.drawable.casilla24_3,R.drawable.casilla24_4,R.drawable.casilla24_5};
		Tarjetas_Titulaciones t13=new Tarjetas_Titulaciones(13, "Electronica", "magisterio infantil", 2200, R.drawable.casilla24, 1500, 180, 900, 2500, 7000, 8750, 10500,fondos13);
		int[] fondos14={R.drawable.casilla25_1,R.drawable.casilla25_2,R.drawable.casilla25_3,R.drawable.casilla25_4,R.drawable.casilla25_5};
		Tarjetas_Titulaciones t14=new Tarjetas_Titulaciones(14, "Mecanica", "magisterio infantil", 2400, R.drawable.casilla25, 1500, 200, 1000, 3000, 7500, 9250, 11000,fondos14);
		int[] fondos15={R.drawable.casilla27_1,R.drawable.casilla27_2,R.drawable.casilla27_3,R.drawable.casilla27_4,R.drawable.casilla27_5};
		Tarjetas_Titulaciones t15=new Tarjetas_Titulaciones(15, "Agricola", "magisterio infantil", 2600, R.drawable.casilla27, 1500, 220, 1100, 3300, 8000, 9750, 11500,fondos15);
		int[] fondos16={R.drawable.casilla28_1,R.drawable.casilla28_2,R.drawable.casilla28_3,R.drawable.casilla28_4,R.drawable.casilla28_5};
		Tarjetas_Titulaciones t16=new Tarjetas_Titulaciones(16, "Enoligia", "magisterio infantil", 2600, R.drawable.casilla28, 1500, 220, 1100, 3300, 8000, 9750, 11500,fondos16);
		int[] fondos17={R.drawable.casilla30_1,R.drawable.casilla30_2,R.drawable.casilla30_3,R.drawable.casilla30_4,R.drawable.casilla30_5};
		Tarjetas_Titulaciones t17=new Tarjetas_Titulaciones(17, "Quimica", "magisterio infantil", 2800, R.drawable.casilla30, 1500, 240, 1200, 3600, 8500, 10250, 12000,fondos17);
		int[] fondos18={R.drawable.casilla32_1,R.drawable.casilla32_2,R.drawable.casilla32_3,R.drawable.casilla32_4,R.drawable.casilla32_5};
		Tarjetas_Titulaciones t18=new Tarjetas_Titulaciones(18, "Matematicas", "magisterio infantil", 3000, R.drawable.casilla32, 2000, 260, 1300, 3900, 9000, 11000, 12750,fondos18);
		int[] fondos19={R.drawable.casilla33_1,R.drawable.casilla33_2,R.drawable.casilla33_3,R.drawable.casilla33_4,R.drawable.casilla33_5};
		Tarjetas_Titulaciones t19=new Tarjetas_Titulaciones(19, "Informatica", "magisterio infantil", 3000, R.drawable.casilla33, 2000, 260, 1300, 3900, 9000, 11000, 12750,fondos19);
		int[] fondos20={R.drawable.casilla35_1,R.drawable.casilla35_2,R.drawable.casilla35_3,R.drawable.casilla35_4,R.drawable.casilla35_5};
		Tarjetas_Titulaciones t20=new Tarjetas_Titulaciones(20, "Mate-Info", "magisterio infantil", 3200, R.drawable.casilla35, 2000, 280, 1500, 4500, 10000, 12000, 14000,fondos20);
		int[] fondos21={R.drawable.casilla38_1,R.drawable.casilla38_2,R.drawable.casilla38_3,R.drawable.casilla38_4,R.drawable.casilla38_5};
		Tarjetas_Titulaciones t21=new Tarjetas_Titulaciones(21, "Formacion continua", "magisterio infantil", 3500, R.drawable.casilla38, 2000, 350, 1750, 5000, 11000, 13000, 15000,fondos21);
		int[] fondos22={R.drawable.casilla40_1,R.drawable.casilla40_2,R.drawable.casilla40_3,R.drawable.casilla40_4,R.drawable.casilla40_5};
		Tarjetas_Titulaciones t22=new Tarjetas_Titulaciones(22, "Experiencia", "magisterio infantil", 4000, R.drawable.casilla40, 2000, 500, 2000, 6000, 14000, 17000, 20000,fondos22);
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
		
		Tarjetas_Edificios e1=new Tarjetas_Edificios(1, "vives", "", 2000, R.drawable.casilla06, 250, 500, 1000, 2000);	
		Tarjetas_Edificios e2=new Tarjetas_Edificios(2, "quintiliano", "", 2000, R.drawable.casilla16, 250, 500, 1000, 2000);	
		Tarjetas_Edificios e3=new Tarjetas_Edificios(3, "politecnico", "", 2000, R.drawable.casilla26, 250, 500, 1000, 2000);	
		Tarjetas_Edificios e4=new Tarjetas_Edificios(4, "cct", "", 2000, R.drawable.casilla36, 250, 500, 1000, 2000);
		tarjetasEdificio.add(e1);
		tarjetasEdificio.add(e2);
		tarjetasEdificio.add(e3);
		tarjetasEdificio.add(e4);
		
		Tarjetas_Servicios s1=new Tarjetas_Servicios(1, "fotocopiadora", "", 1500, R.drawable.casilla13, 250, 750);
		Tarjetas_Servicios s2=new Tarjetas_Servicios(1, "expendedora", "", 1500, R.drawable.casilla29, 250, 750);
		tarjetasServicio.add(s1);
		tarjetasServicio.add(s2);
	}

	public HashMap<Integer,Jugador> jugadores=new HashMap<Integer,Jugador>();
	
	static ArrayList<Tarjetas_Tablero> tarjetas=new ArrayList<Tarjetas_Tablero>();
	
	static ArrayList<Tarjetas_Tablero> tarjetasEdificio=new ArrayList<Tarjetas_Tablero>();
	
	static ArrayList<Tarjetas_Tablero> tarjetasServicio=new ArrayList<Tarjetas_Tablero>();
	
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
	
	public void setJugadorActual(Jugador jugador){
		jugadores.put(Num_JugadorActual(), jugador);
	}
	
	public int Num_JugadorActual(){
		return this.turno_jugador;
	}
	//---------------------------------------------------------------------	
		
	
	public void Jugador_Siguiente(){
		
		//Guardo el JugadorActual en 'jugadores'
		//this.jugadores.put(this.turno_jugador, this.jugador_actual);
		do{
		if(this.jugadores.size()==this.turno_jugador){
			this.turno_jugador=0;
		}
		this.turno_jugador++;
		}while(!JugadorActual().isActivo());
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
