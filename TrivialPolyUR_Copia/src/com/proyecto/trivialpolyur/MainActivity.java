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

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_splashscreen);
        
        Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");
        	   Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
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
