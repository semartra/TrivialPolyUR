package com.proyecto.trivialpolyur;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class Tablero extends Activity {

    public void aceptar(){
		
    	Toast t=Toast.makeText(this, "Ya has tirado", Toast.LENGTH_SHORT);
    	t.show();
    	
    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        
        final AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        dialog.setTitle("ya era hora");
        dialog.setMessage("Por fin");
        dialog.setCancelable(false);
        
        
        dialog.setPositiveButton("Tirar", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				aceptar();
			}
		});
        
        //dialog.show();


        
        Display d =getWindowManager().getDefaultDisplay();
        int width=d.getWidth();
        int height=d.getHeight();
        float f=(float)1.3;
        
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
			        	  //Intent intent = new Intent(Tablero.this, Dado.class);
			            //startActivity(intent);

			              
			            //setContentView(R.layout.activity_dado);
			             

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
        
        Button boton=new Button(this);
        boton.setText("Tirar los dados");
        boton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	              Button b=(Button) v;
	              b.setText("pulsado");
	        	  //Intent intent = new Intent(Tablero.this, TableroSecundario.class);
	              //startActivity(intent);

	              dialog.show();
	            //setContentView(R.layout.activity_dado);
	             

			}
		});
        
        
        Button boton1=new Button(this);
        boton1.setText("Cambiar de pantalla");
        boton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	              Button b=(Button) v;
	              b.setText("pulsado");
	        	  Intent intent = new Intent(Tablero.this, TableroSecundario.class);
	              startActivity(intent);
	            //setContentView(R.layout.activity_dado);
	             

			}
		});
        
        //TableLayout botonera=new TableLayout(this);

        /*float f1=(float)(width*f);
        TableRow.LayoutParams param1 = new TableRow.LayoutParams(width, (int) (width - f1));
        TableRow.LayoutParams param2 = new TableRow.LayoutParams(width/2, (int) (width - f1));*/
        //botonera.setLayoutParams(param1);
        
        /*FrameLayout fl=new FrameLayout(this);
        fl.setLayoutParams(param1);


        FrameLayout fl1=new FrameLayout(this);
        FrameLayout fl2=new FrameLayout(this);
        fl1.setLayoutParams(param2);
        fl2.setLayoutParams(param2);
        //fl1.addView(boton1);
        //fl2.addView(boton);
        
        fl.addView(fl1);
        fl.addView(fl2);*/
        
        
        TableRow tr = new TableRow(this);
        LinearLayout ll1 = new LinearLayout(this);
        //tr.addView(ll1);
        //TableLayout tl1=new TableLayout(this);
        ll1.addView(boton);
        ll1.addView(boton1);
        tr.addView(ll1);;
        
        //TableRow row1=new TableRow(this);
        //FrameLayout tablerobotonera[][] = new FrameLayout[2][1];
        //tablerobotonera[0][0] = new FrameLayout(this);
        //tablerobotonera[1][0] = new FrameLayout(this);
        //tablerobotonera[0][0].addView(boton);
        //tablerobotonera[1][0].addView(boton1);
        //tablerobotonera[0][0].setLayoutParams(param1);
        //tablerobotonera[1][0].setLayoutParams(param1);
        //row1.addView(tablerobotonera[0][0]);
        //row1.addView(tablerobotonera[1][0]);
       
        //table.addView(tr);
        
        LinearLayout ll = new LinearLayout(this);

        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(table);
        ll.addView(tr);
        setContentView(ll);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
