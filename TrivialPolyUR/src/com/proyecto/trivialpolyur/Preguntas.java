package com.proyecto.trivialpolyur;

import java.util.HashMap;
import java.util.List;

import android.R.array;
import android.R.string;

public class Preguntas {

	private HashMap<Integer,HashMap<Integer, String[]>> listaPreguntas=new HashMap<Integer, HashMap<Integer, String[]>>();
	
	public Preguntas(){
		HashMap<Integer, String[]>  a= new HashMap<Integer, String[]>();
		String[] strings=new String[5];
		strings[0]="Que equipo ha ganado más copas del rey";
		strings[1]="El madrid";
		strings[2]="El atlethic";
		strings[3]="El barcelona";
		strings[4]="El betis";
		a.put(3, strings);
		//a.put(0, "Que equipo ha ganado más copas del rey(Hasta 2014)");
		
		this.listaPreguntas.put(0, a);
	}
	
	public HashMap<Integer, String[]> pregunta(){
		return this.listaPreguntas.get(0);
	}
	
}
