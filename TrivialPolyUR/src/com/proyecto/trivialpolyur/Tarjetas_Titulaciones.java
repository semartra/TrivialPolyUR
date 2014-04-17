package com.proyecto.trivialpolyur;

public class Tarjetas_Titulaciones extends Tarjetas_Tablero{

	//Costes para subir de nivel
		private int matricula0;//Coste inicial
		private int matricula1;//Coste para aprobar primer año
		private int matricula2;//Coste para aprobar segundo año
		private int matricula3;//Coste para aprobar tercer año
		private int matricula4;//Coste para aprobar cuarto año
		private int licenciado;//Coste por terminar la carrera
				
		private int costeEstrella;
		public Tarjetas_Titulaciones(int id, String cat, String des, int cred, int imagen,int precioEstrella,int m0, int m1, int m2, int m3, int m4, int licen){
			super(id, cat, des, cred, imagen);
		
			this.costeEstrella=precioEstrella;
			this.matricula1=m1;
			this.matricula2=m2;
			this.matricula3=m3;
			this.matricula4=m4;
			this.matricula0=m0;
			this.licenciado=licen;
		}
	
		public void set_Mat0(int m0){
			this.matricula0=m0;
		}
		
		public void set_Mat1(int m1){
			this.matricula1=m1;
		}
		
		public void set_Mat2(int m2){
			this.matricula2=m2;
		}
		
		public void set_Mat3(int m3){
			this.matricula3=m3;
		}
		
		public void set_Mat4(int m4){
			this.matricula4=m4;
		}
		
		public void set_Licenciado(int licen){
			this.licenciado=licen;
		}				

		public int get_Mat0(){
			return this.matricula0;
		}
		
		public int get_Mat1(){
			return this.matricula1;
		}
		
		public int get_Mat2(){
			return this.matricula2;
		}
		
		public int get_Mat3(){
			return this.matricula3;
		}
		
		public int get_Mat4(){
			return this.matricula4;
		}
		
		public int get_Licenciado(){
			return this.licenciado;
		}		
		
//		public boolean get_Comprado(){
//			return this.comprado;
//		}
}
