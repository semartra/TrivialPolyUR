package com.proyecto.trivialpolyur;

import java.util.ArrayList;
import java.util.HashMap;

import com.proyecto.trivialpolyur.R.id;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableRow;
import android.widget.TextView;

public class TableroSecundario extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_pantallasecundaria);
        
        //TabHost tabHost = getTabHost();
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        //TabHost tabHost = (TabHost)this.findViewById(R.id.tab); 
        //tabHost.setup();

        
        ((LinearLayout)findViewById(R.id.tab1)).setBackgroundColor(Color.BLACK);
        ((LinearLayout)findViewById(R.id.tab2)).setBackgroundColor(Color.BLACK);
        ((LinearLayout)findViewById(R.id.tab3)).setBackgroundColor(Color.BLACK);
        ((LinearLayout)findViewById(R.id.tab4)).setBackgroundColor(Color.BLACK);
        ((LinearLayout)findViewById(R.id.tab5)).setBackgroundColor(Color.BLACK);
        
        
        
        
        //tabHost.getTabWidget().;
        /*Display d =getWindowManager().getDefaultDisplay();
        int width=d.getWidth();
        int height=d.getHeight();
        TabWidget.LayoutParams params = new TabWidget.LayoutParams(width, height/10);
        TabWidget tw= (TabWidget)findViewById(R.id.tabs);
        tw.setLayoutParams(params);*/
        HashMap<Integer, Jugador> jugadores=Partida.Instancia().getJugadores();
        int numJug=jugadores.size();
        
        if(numJug>0){
        	tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(jugadores.get(1).get_Nombre(), null).setContent(R.id.tab1));
        	
        	Spinner spinner = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter <CharSequence> adapter;
            adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(1).getTarjetas();
            for(Tarjetas_Tablero t:tarjetas){
            	adapter.add(t.get_Categoria());
            }
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new SpinnerListener());
        	
        }
        if(numJug>1){
        	tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(jugadores.get(2).get_Nombre(), null).setContent(R.id.tab2));
        
        	Spinner spinner = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter <CharSequence> adapter;
            adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(2).getTarjetas();
            for(Tarjetas_Tablero t:tarjetas){
            	adapter.add(t.get_Categoria());
            }
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new SpinnerListener());

        	
        }
        
        if(numJug>2){
        	tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(jugadores.get(3).get_Nombre(), null).setContent(R.id.tab3));
        
        	Spinner spinner = (Spinner) findViewById(R.id.spinner3);
        	ArrayAdapter <CharSequence> adapter;
        	adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        	
        	ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(3).getTarjetas();
        	for(Tarjetas_Tablero t:tarjetas){
        		adapter.add(t.get_Categoria());
        	}
        	spinner.setAdapter(adapter);
        	spinner.setOnItemSelectedListener(new SpinnerListener());

        }
        
        if(numJug>3){
        	tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(jugadores.get(4).get_Nombre(), null).setContent(R.id.tab4));
        
        	Spinner spinner = (Spinner) findViewById(R.id.spinner4);
            ArrayAdapter <CharSequence> adapter;
            adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(4).getTarjetas();
            for(Tarjetas_Tablero t:tarjetas){
            	adapter.add(t.get_Categoria());
            }
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new SpinnerListener());

        }
        
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("Secretaria", null).setContent(R.id.tab5));
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter <CharSequence> adapter;
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
        //ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(0).getTarjetas();
        for(Tarjetas_Tablero t:tarjetas){
        	adapter.add(t.get_Categoria());
        }
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener5());

        
        
        TextView x = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        x.setTextSize(25);
        
        //Button aux=new Button(this);
        //aux.setText("prueba");
        //((LinearLayout)findViewById(id.tab3)).addView(aux);
        /*Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
        	   //Intent intent = new Intent(TableroSecundario.this, Tablero.class);
               finish();
              //startActivity(intent);
              //startActivityForResult(intent, 11);

           }
        });*/
        
        /*Button boton1 = (Button) findViewById(R.id.button4);
        boton1.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              //b.setText("pulsado");
              ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.infantil);
              
           }
        });*/
        /*
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter <CharSequence> adapter;
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("list 1");
        adapter.add("list 2");
        adapter.add("list 3");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());*/
    }

    
    public class SpinnerListener5 implements OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
          public void onItemSelected(AdapterView<?> parent,
              View view, int pos, long id) {
                  //TextView resultado = (TextView) findViewById (R.id.resultado);
                  //resultado.setText("Ha seleccionado: "+
                  //                  parent.getItemAtPosition(pos).toString());
                  String eleccion=parent.getItemAtPosition(pos).toString();
                  ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
                  Tarjetas_Tablero tarjeta=BuscarTarjeta(tarjetas, eleccion);                  
                  ((ImageView) findViewById(R.id.imageView5)).setImageResource(tarjeta.get_Imagen());
                  
                  Tarjetas_Titulaciones tarTit=(Tarjetas_Titulaciones)tarjeta;
                  
                  ((TextView) findViewById(R.id.textView51a)).setText("Precio");
                  ((TextView) findViewById(R.id.textView51b)).setText(tarjeta.get_Creditos()+"");
                  ((TextView) findViewById(R.id.textView52a)).setText("Estrella");
                  ((TextView) findViewById(R.id.textView52b)).setText(tarTit.get_Mat0()+"");
                  ((TextView) findViewById(R.id.textView53a)).setText("Matricula 1");
                  ((TextView) findViewById(R.id.textView53b)).setText(tarTit.get_Mat1()+"");
                  ((TextView) findViewById(R.id.textView54a)).setText("Matricula 2");
                  ((TextView) findViewById(R.id.textView54b)).setText(tarTit.get_Mat2()+"");
                  ((TextView) findViewById(R.id.textView55a)).setText("Matricula 3");
                  ((TextView) findViewById(R.id.textView55b)).setText(tarTit.get_Mat3()+"");
                  ((TextView) findViewById(R.id.textView56a)).setText("Matricula 4");
                  ((TextView) findViewById(R.id.textView56b)).setText(tarTit.get_Mat4()+"");
                  ((TextView) findViewById(R.id.textView57a)).setText("Matricula 5");
                  ((TextView) findViewById(R.id.textView57b)).setText(tarTit.get_Licenciado()+"");
                  
                  /*
                  if(eleccion=="Magisterio infantil"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }else if(eleccion=="list 2"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.logo_negro);
                  }else if(eleccion=="list 3"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }*/
          }
          public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
          }
      }
    
    public Tarjetas_Tablero BuscarTarjeta(ArrayList<Tarjetas_Tablero> tarjetas, String eleccion){
    	for(Tarjetas_Tablero tarjeta:tarjetas){
    		if(tarjeta.get_Categoria().equals(eleccion)){
    			return tarjeta;
    		}
    	}
		return null;
    	 
    }
    
    
    public class SpinnerListener implements OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
          public void onItemSelected(AdapterView<?> parent,
              View view, int pos, long id) {
                  //TextView resultado = (TextView) findViewById (R.id.resultado);
                  //resultado.setText("Ha seleccionado: "+
                  //                  parent.getItemAtPosition(pos).toString());
                  String eleccion=parent.getItemAtPosition(pos).toString();
                  /*if(eleccion=="Magisterio infantil"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }else if(eleccion=="list 2"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.logo_negro);
                  }else if(eleccion=="list 3"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }*/
          }
          public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
          }
      }

    /*
    public class SpinnerListener implements OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
          public void onItemSelected(AdapterView<?> parent,
              View view, int pos, long id) {
                  //TextView resultado = (TextView) findViewById (R.id.resultado);
                  //resultado.setText("Ha seleccionado: "+
                  //                  parent.getItemAtPosition(pos).toString());
                  String eleccion=parent.getItemAtPosition(pos).toString();
                  if(eleccion=="list 1"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }else if(eleccion=="list 2"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.logo_negro);
                  }else if(eleccion=="list 3"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }
          }
          public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
          }
      }*/
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

