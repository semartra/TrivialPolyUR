package com.proyecto.trivialpolyur;

public class Dado {
	public  Dado(){}

	public static int lanzarDado(){
		int numero = 0;
		numero = (int) (Math.random()*6+1);
		return numero;
	} 
}
