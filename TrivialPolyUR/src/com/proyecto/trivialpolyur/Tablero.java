package com.proyecto.trivialpolyur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Tablero extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Display d =getWindowManager().getDefaultDisplay();
        int width=d.getWidth();
        int height=d.getHeight();
        float f=(float)1.5;
        
        TableRow.LayoutParams params = new TableRow.LayoutParams(width/10, (int) (width/10*f));
        TableLayout table = new TableLayout(this);
        FrameLayout tableroCeldas[][] = new FrameLayout[10][4];
        int k=0;
        for (int i = 0; i < 4; i++) {
         if((i+1)%2==0){
          k=0;
         }else{
          k=1;
         }
            TableRow row = new TableRow(this);
            for (int j = 0; j < 10; j++) {
            	
            	Button b=new Button(this);
            	b.setText("Pant.Sec.");
            	b.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
			              Button b=(Button) v;
			              b.setText("pulsado");
			        	   Intent intent = new Intent(Tablero.this, TableroSecundario.class);
			              startActivity(intent);
					}
				});
            	
            	 tableroCeldas[j][i] = new FrameLayout(this);
                 tableroCeldas[j][i].setLayoutParams(params);
                if(k==0 ){
                    tableroCeldas[j][i].setBackgroundResource(R.drawable.infantil);
                }else{
                	tableroCeldas[j][i].setBackgroundResource(R.drawable.infantil);
                }
                tableroCeldas[j][i].addView(b);
                
                row.addView(tableroCeldas[j][i]);
                if(k==0){
                 k++;
                }else{
                 if(k==1) k = 0;
                }
            }
            table.addView(row);
        }
        setContentView(table);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
