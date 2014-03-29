package com.proyecto.trivialpolyur;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
public class PantallaJugadores extends Activity {

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
        adapter.add("Rojo");
        adapter.add("Azul");
        adapter.add("Amarillo");
        adapter.add("Verde");
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
        			   d.setTitle("J1:"+color+nombre);
        			   d.show();
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
        			   d.show();
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
