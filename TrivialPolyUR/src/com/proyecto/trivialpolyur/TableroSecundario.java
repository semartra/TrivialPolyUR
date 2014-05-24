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

        
        //((LinearLayout)findViewById(R.id.tab1)).setBackgroundColor(Color.BLACK);
        //((LinearLayout)findViewById(R.id.tab2)).setBackgroundColor(Color.BLACK);
        //((LinearLayout)findViewById(R.id.tab3)).setBackgroundColor(Color.BLACK);
        //((LinearLayout)findViewById(R.id.tab4)).setBackgroundColor(Color.BLACK);
        //((LinearLayout)findViewById(R.id.tab5)).setBackgroundColor(Color.BLACK);
        
        
        
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
            //ArrayList<Tarjetas_Tablero> tarjetas=Partida.Instancia().tarjetas;
            for(Tarjetas_Tablero t:tarjetas){
            	if(t!=null){
                	adapter.add(t.get_Categoria());
            	}
            	//t.get_Categoria();
            	//adapter.add(tarjetas.size()+"");
            }

        	spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new SpinnerListener());
            

            ((TextView) findViewById(R.id.textView18a)).setText("Creditos disponibles");
            ((TextView) findViewById(R.id.textView18b)).setText(Partida.Instancia().jugadores.get(1).get_Creditos()+"");
            ((TextView) findViewById(R.id.textView191a)).setText("Nº Edificios");
            ((TextView) findViewById(R.id.textView191b)).setText(Partida.Instancia().jugadores.get(1).getTarjetasEdificio().size()+"");
            ((TextView) findViewById(R.id.textView192a)).setText("Nº Servicios");
            ((TextView) findViewById(R.id.textView192b)).setText(Partida.Instancia().jugadores.get(1).getTarjetasServicio().size()+"");
            
            /*Spinner spinner = (Spinner) findViewById(R.id.spinner5);
            ArrayAdapter <CharSequence> adapter;
            adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
            //ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(1).getTarjetas();
            for(Tarjetas_Tablero t:tarjetas){
            	adapter.add(t.get_Categoria());
            }
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new SpinnerListener5());
        	*/
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
            spinner.setOnItemSelectedListener(new SpinnerListener1());


            ((TextView) findViewById(R.id.textView28a)).setText("Creditos disponibles");
            ((TextView) findViewById(R.id.textView28b)).setText(Partida.Instancia().jugadores.get(2).get_Creditos()+"");
            ((TextView) findViewById(R.id.textView291a)).setText("Nº Edificios");
            ((TextView) findViewById(R.id.textView291b)).setText(Partida.Instancia().jugadores.get(2).getTarjetasEdificio().size()+"");
            ((TextView) findViewById(R.id.textView292a)).setText("Nº Servicios");
            ((TextView) findViewById(R.id.textView292b)).setText(Partida.Instancia().jugadores.get(2).getTarjetasServicio().size()+"");
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
        	spinner.setOnItemSelectedListener(new SpinnerListener2());


            ((TextView) findViewById(R.id.textView38a)).setText("Creditos disponibles");
            ((TextView) findViewById(R.id.textView38b)).setText(Partida.Instancia().jugadores.get(3).get_Creditos()+"");
            ((TextView) findViewById(R.id.textView391a)).setText("Nº Edificios");
            ((TextView) findViewById(R.id.textView391b)).setText(Partida.Instancia().jugadores.get(3).getTarjetasEdificio().size()+"");
            ((TextView) findViewById(R.id.textView392a)).setText("Nº Servicios");
            ((TextView) findViewById(R.id.textView392b)).setText(Partida.Instancia().jugadores.get(3).getTarjetasServicio().size()+"");
        }
        
        if(numJug>3){
        	tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(jugadores.get(4).get_Nombre(), null).setContent(R.id.tab4));
        
        	Spinner spinner = (Spinner) findViewById(R.id.spinner4);
            ArrayAdapter <CharSequence> adapter;
            adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(4).getTarjetas();
            //ArrayList<Tarjetas_Tablero> tarjetas=Partida.Instancia().tarjetas;
            for(Tarjetas_Tablero t:tarjetas){
            	adapter.add(t.get_Categoria());
            }
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new SpinnerListener3());
            

            ((TextView) findViewById(R.id.textView48a)).setText("Creditos disponibles");
            ((TextView) findViewById(R.id.textView48b)).setText(Partida.Instancia().jugadores.get(4).get_Creditos()+"");
            ((TextView) findViewById(R.id.textView491a)).setText("Nº Edificios");
            ((TextView) findViewById(R.id.textView491b)).setText(Partida.Instancia().jugadores.get(4).getTarjetasEdificio().size()+"");
            ((TextView) findViewById(R.id.textView492a)).setText("Nº Servicios");
            ((TextView) findViewById(R.id.textView492b)).setText(Partida.Instancia().jugadores.get(4).getTarjetasServicio().size()+"");

        }
        
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("Secretaria", null).setContent(R.id.tab5));
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter <CharSequence> adapter;
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
        //ArrayList<Tarjetas_Tablero> tarjetas=jugadores.get(1).getTarjetas();
        for(Tarjetas_Tablero t:tarjetas){
        	adapter.add(t.get_Categoria());
        }
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener5());
        
        
        //TextView x = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        //x.setTextSize(25);
        

        ((TextView) findViewById(R.id.textView591a)).setText("Nº Edificios");
        ((TextView) findViewById(R.id.textView591b)).setText(Partida.Instancia().tarjetasEdificio.size()+"");
        ((TextView) findViewById(R.id.textView592a)).setText("Nº Servicios");
        ((TextView) findViewById(R.id.textView592b)).setText(Partida.Instancia().tarjetasServicio.size()+"");
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
                  ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().jugadores.get(1).getTarjetas();
                  //ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
                  Tarjetas_Tablero tarjeta=BuscarTarjeta(tarjetas, eleccion);                  
                  ((ImageView) findViewById(R.id.imageView1)).setImageResource(tarjeta.get_Imagen());
                  
                  Tarjetas_Titulaciones tarTit=(Tarjetas_Titulaciones)tarjeta;
                  
                  ((TextView) findViewById(R.id.textView11a)).setText("Precio");
                  ((TextView) findViewById(R.id.textView11b)).setText(tarjeta.get_Creditos()+"");
                  ((TextView) findViewById(R.id.textView12a)).setText("Estrella");
                  ((TextView) findViewById(R.id.textView12b)).setText(tarTit.get_Mat0()+"");
                  ((TextView) findViewById(R.id.textView13a)).setText("Matricula 1");
                  ((TextView) findViewById(R.id.textView13b)).setText(tarTit.get_Mat1()+"");
                  ((TextView) findViewById(R.id.textView14a)).setText("Matricula 2");
                  ((TextView) findViewById(R.id.textView14b)).setText(tarTit.get_Mat2()+"");
                  ((TextView) findViewById(R.id.textView15a)).setText("Matricula 3");
                  ((TextView) findViewById(R.id.textView15b)).setText(tarTit.get_Mat3()+"");
                  ((TextView) findViewById(R.id.textView16a)).setText("Matricula 4");
                  ((TextView) findViewById(R.id.textView16b)).setText(tarTit.get_Mat4()+"");
                  ((TextView) findViewById(R.id.textView17a)).setText("Matricula 5");
                  ((TextView) findViewById(R.id.textView17b)).setText(tarTit.get_Licenciado()+"");
                  ((TextView) findViewById(R.id.textView18a)).setText("Creditos disponibles");
                  ((TextView) findViewById(R.id.textView18b)).setText(Partida.Instancia().jugadores.get(1).get_Creditos()+"");
                  
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

    public class SpinnerListener1 implements OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
          public void onItemSelected(AdapterView<?> parent,
              View view, int pos, long id) {
                  //TextView resultado = (TextView) findViewById (R.id.resultado);
                  //resultado.setText("Ha seleccionado: "+
                  //                  parent.getItemAtPosition(pos).toString());
                  String eleccion=parent.getItemAtPosition(pos).toString();
                  ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().jugadores.get(2).getTarjetas();
                  //ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
                  Tarjetas_Tablero tarjeta=BuscarTarjeta(tarjetas, eleccion);                  
                  ((ImageView) findViewById(R.id.imageView2)).setImageResource(tarjeta.get_Imagen());
                  
                  Tarjetas_Titulaciones tarTit=(Tarjetas_Titulaciones)tarjeta;
                  
                  ((TextView) findViewById(R.id.textView21a)).setText("Precio");
                  ((TextView) findViewById(R.id.textView21b)).setText(tarjeta.get_Creditos()+"");
                  ((TextView) findViewById(R.id.textView22a)).setText("Estrella");
                  ((TextView) findViewById(R.id.textView22b)).setText(tarTit.get_Mat0()+"");
                  ((TextView) findViewById(R.id.textView23a)).setText("Matricula 1");
                  ((TextView) findViewById(R.id.textView23b)).setText(tarTit.get_Mat1()+"");
                  ((TextView) findViewById(R.id.textView24a)).setText("Matricula 2");
                  ((TextView) findViewById(R.id.textView24b)).setText(tarTit.get_Mat2()+"");
                  ((TextView) findViewById(R.id.textView25a)).setText("Matricula 3");
                  ((TextView) findViewById(R.id.textView25b)).setText(tarTit.get_Mat3()+"");
                  ((TextView) findViewById(R.id.textView26a)).setText("Matricula 4");
                  ((TextView) findViewById(R.id.textView26b)).setText(tarTit.get_Mat4()+"");
                  ((TextView) findViewById(R.id.textView27a)).setText("Matricula 5");
                  ((TextView) findViewById(R.id.textView27b)).setText(tarTit.get_Licenciado()+"");
                  ((TextView) findViewById(R.id.textView28a)).setText("Creditos disponibles");
                  ((TextView) findViewById(R.id.textView28b)).setText(Partida.Instancia().jugadores.get(2).get_Creditos()+"");
                  
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
    
    public class SpinnerListener2 implements OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
          public void onItemSelected(AdapterView<?> parent,
              View view, int pos, long id) {
                  //TextView resultado = (TextView) findViewById (R.id.resultado);
                  //resultado.setText("Ha seleccionado: "+
                  //                  parent.getItemAtPosition(pos).toString());
                  String eleccion=parent.getItemAtPosition(pos).toString();
                  ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().jugadores.get(3).getTarjetas();
                  //ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
                  Tarjetas_Tablero tarjeta=BuscarTarjeta(tarjetas, eleccion);                  
                  ((ImageView) findViewById(R.id.imageView3)).setImageResource(tarjeta.get_Imagen());
                  
                  Tarjetas_Titulaciones tarTit=(Tarjetas_Titulaciones)tarjeta;
                  
                  ((TextView) findViewById(R.id.textView31a)).setText("Precio");
                  ((TextView) findViewById(R.id.textView31b)).setText(tarjeta.get_Creditos()+"");
                  ((TextView) findViewById(R.id.textView32a)).setText("Estrella");
                  ((TextView) findViewById(R.id.textView32b)).setText(tarTit.get_Mat0()+"");
                  ((TextView) findViewById(R.id.textView33a)).setText("Matricula 1");
                  ((TextView) findViewById(R.id.textView33b)).setText(tarTit.get_Mat1()+"");
                  ((TextView) findViewById(R.id.textView34a)).setText("Matricula 2");
                  ((TextView) findViewById(R.id.textView34b)).setText(tarTit.get_Mat2()+"");
                  ((TextView) findViewById(R.id.textView35a)).setText("Matricula 3");
                  ((TextView) findViewById(R.id.textView35b)).setText(tarTit.get_Mat3()+"");
                  ((TextView) findViewById(R.id.textView36a)).setText("Matricula 4");
                  ((TextView) findViewById(R.id.textView36b)).setText(tarTit.get_Mat4()+"");
                  ((TextView) findViewById(R.id.textView37a)).setText("Matricula 5");
                  ((TextView) findViewById(R.id.textView37b)).setText(tarTit.get_Licenciado()+"");
                  ((TextView) findViewById(R.id.textView38a)).setText("Creditos disponibles");
                  ((TextView) findViewById(R.id.textView38b)).setText(Partida.Instancia().jugadores.get(3).get_Creditos()+"");
                  
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
    
    public class SpinnerListener3 implements OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
          public void onItemSelected(AdapterView<?> parent,
              View view, int pos, long id) {
                  //TextView resultado = (TextView) findViewById (R.id.resultado);
                  //resultado.setText("Ha seleccionado: "+
                  //                  parent.getItemAtPosition(pos).toString());
                  String eleccion=parent.getItemAtPosition(pos).toString();
                  ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().jugadores.get(4).getTarjetas();
                  //ArrayList<Tarjetas_Tablero> tarjetas = Partida.Instancia().tarjetas;
                  Tarjetas_Tablero tarjeta=BuscarTarjeta(tarjetas, eleccion);                  
                  ((ImageView) findViewById(R.id.imageView4)).setImageResource(tarjeta.get_Imagen());
                  
                  Tarjetas_Titulaciones tarTit=(Tarjetas_Titulaciones)tarjeta;
                  
                  ((TextView) findViewById(R.id.textView41a)).setText("Precio");
                  ((TextView) findViewById(R.id.textView41b)).setText(tarjeta.get_Creditos()+"");
                  ((TextView) findViewById(R.id.textView42a)).setText("Estrella");
                  ((TextView) findViewById(R.id.textView42b)).setText(tarTit.get_Mat0()+"");
                  ((TextView) findViewById(R.id.textView43a)).setText("Matricula 1");
                  ((TextView) findViewById(R.id.textView43b)).setText(tarTit.get_Mat1()+"");
                  ((TextView) findViewById(R.id.textView44a)).setText("Matricula 2");
                  ((TextView) findViewById(R.id.textView44b)).setText(tarTit.get_Mat2()+"");
                  ((TextView) findViewById(R.id.textView45a)).setText("Matricula 3");
                  ((TextView) findViewById(R.id.textView45b)).setText(tarTit.get_Mat3()+"");
                  ((TextView) findViewById(R.id.textView46a)).setText("Matricula 4");
                  ((TextView) findViewById(R.id.textView46b)).setText(tarTit.get_Mat4()+"");
                  ((TextView) findViewById(R.id.textView47a)).setText("Matricula 5");
                  ((TextView) findViewById(R.id.textView47b)).setText(tarTit.get_Licenciado()+"");
                  
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

