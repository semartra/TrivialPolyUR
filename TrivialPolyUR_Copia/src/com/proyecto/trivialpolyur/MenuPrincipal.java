package com.proyecto.trivialpolyur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        
        Button boton = (Button) findViewById(R.id.bt_nuevoJuego);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
        	   Intent intent = new Intent(MenuPrincipal.this, Tablero.class);
              startActivity(intent);
              //startActivityForResult(intent, 11);

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
