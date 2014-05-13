package com.proyecto.trivialpolyur;

import java.util.HashMap;

public class Tarjetas_Sorpresa extends Tarjetas_Tablero {
	
	private HashMap<Integer, String[]> recom=new HashMap<Integer, String[]>();
	
    public Tarjetas_Sorpresa() {
    	String[] p={"Has suspendido un examen -100","-100"};
    	recom.put(1, p);
    	String[] p1={"Has aprobado un examen 100","100"};
    	recom.put(2, p1);
    	String[] p2={"Has faltado a clase -50","-50"};
    	recom.put(3, p2);
    	String[] p3={"Has respondido al profesor 50","50"};
    	recom.put(4, p3);
    	String[] p4={"No dejes todo para el último día -150","-150"};
    	recom.put(5, p4);
    	String[] p5={"Hacer todos los trabajos a tiempo 150","150"};
    	recom.put(6, p5);
    	String[] p6={"Te han pillado copiando en el examen -200","200"};
    	recom.put(7, p6);
    	String[] p7={"Has sacado una matricula de honor 200","200"};
    	recom.put(8, p7);
    	
    }
	
	public String[] recompensa(){
		int total=recom.size();
		int numero_alea = (int) (Math.random()*total+1);
		return recom.get(numero_alea);
	}
}
