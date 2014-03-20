package com.proyecto.trivialpolyur;

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
        
        TabHost tabHost = getTabHost();
        //TabHost tabHost = (TabHost)findViewById(R.id.tab);
        //TabHost tabHost = (TabHost)this.findViewById(R.id.tab); 
        //tabHost.setup();

        
        //tabHost.getTabWidget().;
        /*Display d =getWindowManager().getDefaultDisplay();
        int width=d.getWidth();
        int height=d.getHeight();
        TabWidget.LayoutParams params = new TabWidget.LayoutParams(width, height/10);
        TabWidget tw= (TabWidget)findViewById(R.id.tabs);
        tw.setLayoutParams(params);*/
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator( 
           "Título 1", null).setContent(R.id.tab1));

        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator( 
           "Título 2", null).setContent(R.id.tab2));

        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator( 
           "Título 3", null).setContent(R.id.tab3));
        
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator( 
                "Título 4", null).setContent(R.id.tab4));
        TextView x = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        x.setTextSize(25);
        
        Button aux=new Button(this);
        aux.setText("prueba");
        ((LinearLayout)findViewById(id.tab3)).addView(aux);
        Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
        	   Intent intent = new Intent(TableroSecundario.this, Tablero.class);
              startActivity(intent);
              //startActivityForResult(intent, 11);

           }
        });
        
        Button boton1 = (Button) findViewById(R.id.button4);
        boton1.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
              ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.infantil);
              ((TabWidget)findViewById(android.R.id.tabs)).getChildAt(3).setVisibility(View.GONE);

           }
        });
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter <CharSequence> adapter;
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("list 1");
        adapter.add("list 2");
        adapter.add("list 3");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());
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
                  if(eleccion=="list 1"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.infantil);
                  }else if(eleccion=="list 2"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.logo_negro);
                  }else if(eleccion=="list 3"){
                	  ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
                  }
          }
          public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
          }
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

