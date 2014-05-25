package com.proyecto.trivialpolyur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        Button botonAyuda = (Button) findViewById(R.id.bt_Ayuda);
        botonAyuda.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
        	   Intent intent = new Intent(MenuPrincipal.this, PantallaAyuda.class);       	  
              startActivity(intent);
              //startActivityForResult(intent, 11);

           }
        });
        
        //Button botonConfiguracion = (Button) findViewById(R.id.bt_Configuracion);
        /*botonConfiguracion.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
        	   Intent intent = new Intent(MenuPrincipal.this, PantallaJugadores.class);
        	   finish();
              startActivity(intent);
              //startActivityForResult(intent, 11);

           }
        });
        */
        Button boton = (Button) findViewById(R.id.bt_nuevoJuego);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
              //Partida.Instancia().reset();
        	   Intent intent = new Intent(MenuPrincipal.this, PantallaJugadores.class);
        	   finish();
              startActivity(intent);
              //startActivityForResult(intent, 11);

           }
        });
        
        Button botonSalir = (Button) findViewById(R.id.bt_Salir);
        botonSalir.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
        	   //Intent intent = new Intent(Intent.ACTION_MAIN); 
        	   //Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
              //startActivity(intent);
        	   finish();

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
