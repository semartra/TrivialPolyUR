package com.proyecto.trivialpolyur;

import java.util.HashMap;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
public class PantallaJugadores extends Activity {

	private int getColor(String color){
		if(color.equals("Rojo")){
			return Color.RED;
		}else if(color.equals("Verde")){
			return Color.GREEN;
		}else if(color.equals("Azul")){
			return Color.BLUE;
		}else{
			return Color.YELLOW;
		}
	}
	
	private int getImagen(String imagen){
		if(imagen.equals("Destornillador")){
			return com.proyecto.trivialpolyur.R.drawable.destornillador1;
		}else if(imagen.equals("Uvas")){
			return com.proyecto.trivialpolyur.R.drawable.uvas1;
		}else if(imagen.equals("Tijeras")){
			return com.proyecto.trivialpolyur.R.drawable.tijeras1;
		}else{
			//return Drawable.createFromPath("@drawable/ordenador");
			return com.proyecto.trivialpolyur.R.drawable.ordenador1; 
		}
	}
	
	private int jugadores=1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);
        
		final Dialog d=new Dialog(this);
        
        final EditText edit=(EditText) findViewById(R.id.editText1);
        final EditText edit1=(EditText) findViewById(R.id.editText2);
        final EditText edit2=(EditText) findViewById(R.id.editText3);
        final EditText edit3=(EditText) findViewById(R.id.editText4);
        
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner4);
        
        ArrayAdapter <CharSequence> adapter;
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Tijeras");
        adapter.add("Uvas");
        adapter.add("Destornillador");
        adapter.add("Ordenador");
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        
        LinearLayout l2=(LinearLayout) findViewById(R.id.linear2);
        LinearLayout l3=(LinearLayout) findViewById(R.id.linear3);
        LinearLayout l4=(LinearLayout) findViewById(R.id.linear4);
        
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        
        Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
           
        	   LinearLayout l2=(LinearLayout) findViewById(R.id.linear2);
               LinearLayout l3=(LinearLayout) findViewById(R.id.linear3);
               LinearLayout l4=(LinearLayout) findViewById(R.id.linear4);
               
               if(jugadores==1){
            	   l2.setVisibility(View.VISIBLE);
            	   jugadores++;
               }
               else if(jugadores==2){
            	   l3.setVisibility(View.VISIBLE);
            	   jugadores++;
               }
               else if(jugadores==3){
            	   l4.setVisibility(View.VISIBLE);
            	   jugadores++;
               }
               
           }
        }); 
        
        Button boton1 = (Button) findViewById(R.id.button2);
        boton1.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
           
        	   LinearLayout l2=(LinearLayout) findViewById(R.id.linear2);
               LinearLayout l3=(LinearLayout) findViewById(R.id.linear3);
               LinearLayout l4=(LinearLayout) findViewById(R.id.linear4);
               
               if(jugadores==2){
            	   l2.setVisibility(View.GONE);
            	   jugadores--;
               }
               else if(jugadores==3){
            	   l3.setVisibility(View.GONE);
            	   jugadores--;
               }
               else if(jugadores==4){
            	   l4.setVisibility(View.GONE);
            	   jugadores--;
               }
               
           }
        }); 
    

        //final Dialog d1=new Dialog(this);
		   
        Button boton2 = (Button) findViewById(R.id.button3);
        boton2.setOnClickListener(new OnClickListener() {
        		
           @Override
           public void onClick(View v) {
        	   if(jugadores==1){
            	   String color = (String) spinner.getSelectedItem();
            	   String nombre = (String) edit.getText().toString();
        		   if(nombre.equals("")){
        			   d.setTitle("Algo no es correcto");
        			   d.show();
        		   }else{
        			   //d.setTitle("J1:"+color+nombre);
        			   //d.show();
        			   Jugador j1=new Jugador();
        			   j1.set_Nombre(nombre);
        			   //j1.setColor(getColor(color));
        			   j1.setFicha(getImagen(color));
        			   int[] p=new int[2];
        			   p[0]=0;
        			   p[1]=0;
        			   j1.setPosicion(p);
        			   HashMap<Integer, Jugador> jugadores=new HashMap<Integer, Jugador>();
        			   jugadores.put(1, j1);
        			   
        			   Partida.Instancia().setJugadores(jugadores);
        			   

        			   Intent intent = new Intent(PantallaJugadores.this, Tablero.class);
                	   finish();
                       startActivity(intent);
        		   }
        	   }
        	   if(jugadores==2){
            	   String color = (String) spinner.getSelectedItem();
            	   String color1 = (String) spinner1.getSelectedItem();
            	   String nombre = (String) edit.getText().toString();
            	   String nombre1 = (String) edit1.getText().toString();
            	   if(color==color1||nombre.equals("")||nombre1.equals("")){
            		   d.setTitle("Algo no es correcto");
        			   d.show();
        		   }else{
        			   d.setTitle("J1:"+color+nombre+"J2:"+color1+nombre1);
        			   d.show();
        			   Jugador j1=new Jugador();
        			   j1.set_Nombre(nombre);
        			   //j1.setColor(getColor(color));
        			   j1.setFicha(getImagen(color));
        			   Jugador j2=new Jugador();
        			   j2.set_Nombre(nombre1);
        			   j2.setFicha(getImagen(color1));
        			   //j2.setColor(getColor(color1));
        			   int[] p=new int[2];
        			   p[0]=0;
        			   p[1]=0;
        			   j1.setPosicion(p);
        			   int[] p1=new int[2];
        			   p1[0]=0;
        			   p1[1]=1;
        			   j2.setPosicion(p1);
        			   HashMap<Integer, Jugador> jugadores=new HashMap<Integer, Jugador>();
        			   jugadores.put(1, j1);
        			   Partida.Instancia().setJugadores(jugadores);
        			   jugadores.put(2, j2);
        			   Partida.Instancia().setJugadores(jugadores);
        			   Intent intent = new Intent(PantallaJugadores.this, Tablero.class);
                	   finish();
                      startActivity(intent);
        		   }
        	   }
        	   if(jugadores==3){
        		   String color = (String) spinner.getSelectedItem();
            	   String color1 = (String) spinner1.getSelectedItem();
            	   String color2 = (String) spinner2.getSelectedItem();
            	   String nombre = (String) edit.getText().toString();
            	   String nombre1 = (String) edit1.getText().toString();
            	   String nombre2 = (String) edit2.getText().toString();
            	   if(color==color1||color==color2||color2==color1||nombre.equals("")||nombre1.equals("")||nombre2.equals("")){
            		   d.setTitle("Algo no es correcto");
        			   d.show();
        		   }else{
        			   d.setTitle("J1:"+color+nombre+"J2:"+color1+nombre1+"J3:"+color2+nombre2);
        			   d.show();
        			   Jugador j1=new Jugador();
        			   j1.set_Nombre(nombre);
        			   //j1.setColor(getColor(color));
        			   j1.setFicha(getImagen(color));
        			   Jugador j2=new Jugador();
        			   j2.set_Nombre(nombre1);
        			   //j2.setColor(getColor(color1));
        			   j2.setFicha(getImagen(color1));
        			   Jugador j3=new Jugador();
        			   j3.set_Nombre(nombre2);
        			   //j3.setColor(getColor(color2));
        			   j3.setFicha(getImagen(color2));
        			   int[] p=new int[2];
        			   p[0]=0;
        			   p[1]=0;
        			   j1.setPosicion(p);
        			   int[] p1=new int[2];
        			   p1[0]=0;
        			   p1[1]=1;
        			   j2.setPosicion(p1);
        			   int[] p2=new int[2];
        			   p2[0]=1;
        			   p2[1]=0;
        			   j3.setPosicion(p2);
        			   HashMap<Integer, Jugador> jugadores=new HashMap<Integer, Jugador>();
        			   jugadores.put(1, j1);
        			   Partida.Instancia().setJugadores(jugadores);
        			   jugadores.put(2, j2);
        			   Partida.Instancia().setJugadores(jugadores);
        			   jugadores.put(3, j3);
        			   Partida.Instancia().setJugadores(jugadores);
        			   Intent intent = new Intent(PantallaJugadores.this, Tablero.class);
                	   finish();
                	   startActivity(intent);
        		   }
            	   
        	   }
        	   if(jugadores==4){
            	   String color = (String) spinner.getSelectedItem();
            	   String color1 = (String) spinner1.getSelectedItem();
            	   String color2 = (String) spinner2.getSelectedItem();
            	   String color3 = (String) spinner3.getSelectedItem();
            	   String nombre = (String) edit.getText().toString();
            	   String nombre1 = (String) edit1.getText().toString();
            	   String nombre2 = (String) edit2.getText().toString();
            	   String nombre3 = (String) edit3.getText().toString();
            	   if(color==color1||color==color2||color==color3||color1==color2||color1==color3||color2==color3||nombre.equals("")||nombre1.equals("")||nombre2.equals("")||nombre3.equals("")){
            		   d.setTitle("Algo no es correcto");
        			   d.show();
        		   }else{
        			   d.setTitle("J1:"+color+nombre+"J2:"+color1+nombre1+"J3:"+color2+nombre2+"J3:"+color3+nombre3);
        			   //d.show();
        			   Jugador j1=new Jugador();
        			   j1.set_Nombre(nombre);
        			   //j1.setColor(getColor(color));
        			   j1.setFicha(getImagen(color));
        			   Jugador j2=new Jugador();
        			   j2.set_Nombre(nombre1);
        			   //j2.setColor(getColor(color1));
        			   j2.setFicha(getImagen(color1));
        			   Jugador j3=new Jugador();
        			   j3.set_Nombre(nombre2);
        			   //j3.setColor(getColor(color2));
        			   j3.setFicha(getImagen(color2));
        			   Jugador j4=new Jugador();
        			   j4.set_Nombre(nombre3);
        			   //j4.setColor(getColor(color3));
        			   j4.setFicha(getImagen(color3));
        			   int[] p=new int[2];
        			   p[0]=0;
        			   p[1]=0;
        			   j1.setPosicion(p);
        			   int[] p1=new int[2];
        			   p1[0]=0;
        			   p1[1]=1;
        			   j2.setPosicion(p1);
        			   int[] p2=new int[2];
        			   p2[0]=1;
        			   p2[1]=0;
        			   j3.setPosicion(p2);
        			   int[] p3=new int[2];
        			   p3[0]=1;
        			   p3[1]=1;
        			   j4.setPosicion(p3);
        			   HashMap<Integer, Jugador> jugadores=new HashMap<Integer, Jugador>();
        			   jugadores.put(1, j1);
        			   //Partida.Instancia().setJugadores(jugadores);
        			   jugadores.put(2, j2);
        			   //Partida.Instancia().setJugadores(jugadores);
        			   jugadores.put(3, j3);
        			   //Partida.Instancia().setJugadores(jugadores);
        			   jugadores.put(4, j4);
        			   Partida.Instancia().setJugadores(jugadores);
        			   d.show();
        			   Intent intent = new Intent(PantallaJugadores.this, Tablero.class);
                	   finish();
                      startActivity(intent);
        		   }
        	   }
           }
        }); 
	
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
