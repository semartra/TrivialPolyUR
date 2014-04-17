package com.proyecto.trivialpolyur;

public class Tarjetas_Sorpresa extends Tarjetas_Tablero {
	
	private String tipo_sorpresa;//Tipo de sorpresa('positiva' o 'negativa')
	private int valor;//valor de la recompensa o penalizacion segun sea el tipo de sorpresa
	
	public Tarjetas_Sorpresa(int id, String cat, String des, int cred, int imagen, String tipo_sorpresa, int valor){
		super(id,cat,des,cred,imagen);
		
		this.tipo_sorpresa=tipo_sorpresa;
		this.valor=valor;
	}
		
	public void set_Sorpresa(String sorpresa){
		this.tipo_sorpresa=sorpresa;
	}
	
	public void set_Valor(int valor){
		this.valor=valor;
	}
	
	public String get_Sopresa(){
		return this.tipo_sorpresa;
	}
	
	public int get_Valor(){
		return this.valor;
	}
}
