package com.proyecto.trivialpolyur;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.array;
import android.R.bool;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class Tablero extends Activity {

	//Button pruebas;
	
    private String res="";
    private boolean sol=false;
    
	private int resultado;
	private boolean dobles;
	FrameLayout tableroCeldas[][];
	int posicion=0;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	   
	  if (keyCode == KeyEvent.KEYCODE_BACK) {
	   
	    new AlertDialog.Builder(this)
	      .setIcon(android.R.drawable.ic_dialog_alert)
	      //.setIcon(R.drawable.exitgame)
	      .setTitle("Abandonar Partida")
	      .setMessage("¿Estas seguro de Abandonar la partida?")
	      .setNegativeButton(android.R.string.cancel, null)//sin listener
	      .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
	        @Override
	        public void onClick(DialogInterface dialog, int which){
	          //Salir
	          //finish();
	       Intent intent = new Intent(Tablero.this, MenuPrincipal.class);
	       finish();
	       startActivity(intent);

	        }
	      })
	      .show();

	    // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
	    return true;
	  }
	//para las demas cosas, se reenvia el evento al listener habitual
	  return super.onKeyDown(keyCode, event);
	} 
	
	//final Button botonComprar=new Button(this);
	//final Button boton=new Button(this);//tirar los dados
    //final Button botonPagar=new Button(this);
    
	/*Button botonComprar=new Button(this);
	Button boton=new Button(this);//tirar los dados
    Button botonPagar=new Button(this);
    Button boton2=new Button(this);//pasar turno
    Button boton1=new Button(this);//cambiar Pantalla
	*/
	Button botonComprar;
	Button boton;//tirar los dados
    Button botonPagar;
    Button boton2;//pasar turno
    Button boton1;//cambiar Pantalla
    Button botonSubir;//subir nivel casilla
    boolean doble=false;
	
    Tarjetas_Sorpresa ts=new Tarjetas_Sorpresa();
    
    public void finPartida(){
    	if(Partida.Instancia().JugadorActual().getTarjetas().size()==22){
    		AlertDialog.Builder ad = new AlertDialog.Builder(this);
			ad.setTitle("HAS GANADO");
			ad.setCancelable(false);
			ad.setMessage("Enhorabuena el jugador "+Partida.Instancia().JugadorActual().get_Nombre()+" ha ganado el juego");
			ad.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	               Intent intent = new Intent(Tablero.this, MenuPrincipal.class);
	     	       finish();
	     	       startActivity(intent);
	            }  
	        });
			ad.show();
    	}
    }
    
    public void eliminarjugador(){
    	Jugador j=Partida.Instancia().JugadorActual();
    	if(0>j.get_Creditos()){
    		///Jugador elimando por falta de creditos.
    		//Partida.Instancia().
    		Partida.Instancia().tarjetas.addAll(j.getTarjetas());
    		ArrayList<Tarjetas_Tablero> t=new ArrayList<Tarjetas_Tablero>();
    		j.setTarjetas(t);
    		j.setActivo(false);
    		Partida.Instancia().setJugadorActual(j);
    		
    		if(!todosEliminados()){
    			AlertDialog ad = new AlertDialog.Builder(this).create();
    			ad.setTitle("JUGADOR ELIMINADO");
    			ad.setMessage("Este jugador ha sido eliminado y no participara más en la partida");
    			ad.show();
    		}else{
    			AlertDialog.Builder ad = new AlertDialog.Builder(this);
    			ad.setTitle("PARTIDA TERMINADA");
    			ad.setCancelable(false);
    			ad.setMessage("La partida ha teminado porque todos los jugadores están eliminados");
    			ad.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
    	            public void onClick(DialogInterface dialogo1, int id) {  
    	               Intent intent = new Intent(Tablero.this, MenuPrincipal.class);
    	     	       finish();
    	     	       startActivity(intent);
    	            }  
    	        });
    			ad.show();
    		}
    		
	    	int[] n=Tablero.posicionTablero(j.getPosicionTablero());
			((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[n[1]][n[0]].getChildAt(0)).getChildAt(j.getPosicion()[0])).getChildAt(j.getPosicion()[1])).setBackgroundColor(Color.TRANSPARENT);
    	}
    }
	
	private boolean todosEliminados() {
		HashMap<Integer, Jugador> jugadores = Partida.Instancia().jugadores;
		int j=0;
		for(int i=1;i<=jugadores.size();i++){
			if(!jugadores.get(i).isActivo()){
				j++;
			}
		}
		
		if(j==jugadores.size()){
			return true;
		}else{
			return false;
		}
	}

	public void preguntar(){
        final Dialog ventana = new Dialog(this);
		if(sol){
			ventana.setTitle("acierto");
			buscarTarjeta(Partida.Instancia().JugadorActual().getPosicion());
			int iden=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
			
			if(estaTajeta(iden)){
				int iden1=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				//Tarjetas_Titulaciones tar=(Tarjetas_Titulaciones) tarjetaCategoria(cat);
				Tarjetas_Titulaciones tar=(Tarjetas_Titulaciones) tarjetaIden(iden1);
				boton2.setEnabled(true);
				if(Partida.Instancia().JugadorActual().get_Creditos()>tar.get_Creditos())
					botonComprar.setEnabled(true);	
				
			}else{
				//LA TARJETA YA ESTA COMPRADA
				if(mePertenece(iden)){
					//LA TARJETA LE PERTENECE AL JUGADOR ACTUAL
					boton2.setEnabled(true);
					
					int iden1=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
					Tarjetas_Titulaciones tar=(Tarjetas_Titulaciones) tarjetaIdenJug(iden1);
					//tar.get_Creditos();
					if(tar.getNivel()<4&&(tar.getCosteEstrella()<=Partida.Instancia().JugadorActual().get_Creditos())){
						botonSubir.setEnabled(true);
					}
				}else{
					//LATARJETA LE PERTENECE A OTRO JUGADOR
					botonPagar.setEnabled(true);
					boton2.setEnabled(false);
				}
			}
			//boton2.setEnabled(true);
		}else{
			ventana.setTitle("fallo");
			boton2.setEnabled(true);
			/////////

			//buscarTarjeta(Partida.Instancia().JugadorActual().getPosicion());
			int iden=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
			
			if(estaTajeta(iden)){
				boton2.setEnabled(true);
				
			}else{
				//LA TARJETA YA ESTA COMPRADA
				if(mePertenece(iden)){
					//LA TARJETA LE PERTENECE AL JUGADOR ACTUAL
					boton2.setEnabled(true);
				}else{
					//LA TARJETA LE PERTENECE A OTRO JUGADOR
					botonPagar.setEnabled(true);
					boton2.setEnabled(false);
					doble=true;
				}
			}
			/////////
		}
		ventana.show();		
	}

    public void aceptar(){
    	if(Partida.Instancia().JugadorActual().getTurnos()==0){
    		int d1=Dado.lanzarDado();
			int d2=Dado.lanzarDado();
    		Toast t=Toast.makeText(this, d1+" ~~ "+d2, Toast.LENGTH_LONG);
    		resultado=d1+d2;
    		dobles=(d1==d2);
    		t.show();
    		//cambiendo resultado vas a la casillas que quieras
    		/*
    		resultado=13;
    		dobles=false;
    		*/
    	}else{
    		Jugador j=Partida.Instancia().JugadorActual();
    		j.setTurnos(j.getTurnos()-1);
    		Partida.Instancia().setJugadorActual(j);
    		resultado=0;
    		dobles=false;
    	}
    	moverFicha();
    }
	
    private void mover1() {
		// TODO Auto-generated method stub
    	Jugador JActual=Partida.Instancia().JugadorActual();
    	int[] n=Tablero.posicionTablero(JActual.getPosicionTablero());
    	
    	if(tableroCeldas[n[1]][n[0]].getChildAt(0)!=null){
    		((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(JActual.getPosicion()[0])).getChildAt(JActual.getPosicion()[1])).setBackgroundColor(Color.TRANSPARENT);
         	((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[n[1]][n[0]].getChildAt(0)).getChildAt(JActual.getPosicion()[0])).getChildAt(JActual.getPosicion()[1])).setBackgroundColor(Color.TRANSPARENT);
        }


    	int pos=JActual.getPosicionTablero();
    	pos=pos+1;
    	if(pos>41){

			
			Jugador j=Partida.Instancia().JugadorActual();
			j.set_Creditos(j.get_Creditos()+2000);
			Partida.Instancia().setJugadorActual(j);
				
			AlertDialog ad = new AlertDialog.Builder(this).create();
			ad.setTitle("!!SÁLIDA¡¡");
			ad.setMessage("enhorabuena acabas de pasar por la salida cobras 2000");
			ad.show();
			
    		pos=pos-40;
    	}
        
    	n=Tablero.posicionTablero(pos);
    	JActual.setPosicionTablero(pos);
    	
        ((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[n[1]][n[0]].getChildAt(0)).getChildAt(JActual.getPosicion()[0])).getChildAt(JActual.getPosicion()[1])).setBackgroundResource(JActual.getFicha());
    	HashMap<Integer, Jugador> jugadores = Partida.Instancia().getJugadores();
    	jugadores.remove(Partida.Instancia().Num_JugadorActual());
    	jugadores.put(Partida.Instancia().Num_JugadorActual(), JActual);
    	Partida.Instancia().setJugadores(jugadores);
	}

    
    public void moverFicha(){
    	
    	new Thread(new Runnable() {
    	    @Override
    	    public void run() {

    	    	for(int i=0;i<resultado;i++){
    	    	try {
    	            Thread.sleep(500);
    	        } catch (InterruptedException e) {
    	            e.printStackTrace();
    	        }
    	        runOnUiThread(new Runnable() {
    	            @Override
    	            public void run() {
    	            	mover1();    	    	    	
    	            }
    	        });
    	    	}
    	    	try {
    	            Thread.sleep(500);
    	        } catch (InterruptedException e) {
    	            e.printStackTrace();
    	        }
    	    	runOnUiThread(new Runnable() {
    	            @Override
    	            public void run() {
 	    	    	
    	    	    	pregunta();
    	    	    	//pruebas.setEnabled(false);  	    	    	
    	            }
    	        });
    	    	
    	    }
    	}).start();
    }
    
    public void pregunta(){
    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        final Preguntas p=new Preguntas();
		//final HashMap<Integer, String[]> pr = p.pregunta();
		String cat=buscarCategoria(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));


        boolean pag=true;
		
		if(!cat.equals("")){
			pag=false;
        final String[] preg = p.getPregunta(cat);
        //final String[] preg={"","","","","","","",""};
        final String[] items = {preg[1],preg[2],preg[3],preg[4]};
        
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
  			
  			public void onClick(DialogInterface dialog, int which) {
  				// TODO Auto-generated method stub
	              if(res==preg[5]){
	            	  sol=true;
	              }else{
	            	  sol=false;
	              }
  				preguntar();
  			}
  		});
        
        int selected = -1; // or whatever you want
        builder.setSingleChoiceItems(items, selected, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                      //onclick
            	res=items[item];
            }});
        
        builder.setTitle(preg[0]);

        res="";
        builder.show();
		}else{
			String cas=Casilla(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
			if(cas.equals("sorpresa")){
				String[] s=ts.recompensa();
				String valor=s[1];
				String texto=s[0];
				String[] mm={"",""};
				
				Jugador j=Partida.Instancia().JugadorActual();
				j.set_Creditos(j.get_Creditos()+Integer.parseInt(valor));
				Partida.Instancia().setJugadorActual(j);
				
				AlertDialog ad = new AlertDialog.Builder(this).create();
				ad.setTitle("!!SUERTE¡¡");
				ad.setMessage(texto);
				ad.show();
				eliminarjugador();
			}else if(cas.equals("gMatricula")){
							
				Jugador j=Partida.Instancia().JugadorActual();
				j.set_Creditos(j.get_Creditos()+(-2000));
				Partida.Instancia().setJugadorActual(j);
				
				AlertDialog ad = new AlertDialog.Builder(this).create();
				ad.setTitle("GASTOS DE MATRÍCULA");
				ad.setMessage("Tienes que pagar los gastos de mátricula -2000");
				ad.show();

				eliminarjugador();
			}else if(cas.equals("gDeportivos")){
								
				Jugador j=Partida.Instancia().JugadorActual();
				j.set_Creditos(j.get_Creditos()+(-1000));
				Partida.Instancia().setJugadorActual(j);
				
				AlertDialog ad = new AlertDialog.Builder(this).create();
				ad.setTitle("GASTOS DEPORTIVOS");
				ad.setMessage("Tienes que pagar los gastos deportivos -1000");
				ad.show();

				eliminarjugador();
			}else if(cas.equals("estudiar")){
				
				//Jugador j=Partida.Instancia().JugadorActual();
				//j.setTurnos(3);
				
				/////////////7

				// TODO Auto-generated method stub
		    	Jugador JActual=Partida.Instancia().JugadorActual();
		    	JActual.setTurnos(3);
		    	int[] n=Tablero.posicionTablero(JActual.getPosicionTablero());
		    	
		    	if(tableroCeldas[n[1]][n[0]].getChildAt(0)!=null){
		         	((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[n[1]][n[0]].getChildAt(0)).getChildAt(JActual.getPosicion()[0])).getChildAt(JActual.getPosicion()[1])).setBackgroundColor(Color.TRANSPARENT);
		        }


		    	int pos=11;
		    			        
		    	n=Tablero.posicionTablero(pos);
		    	JActual.setPosicionTablero(pos);
		    	
		        ((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[n[1]][n[0]].getChildAt(0)).getChildAt(JActual.getPosicion()[0])).getChildAt(JActual.getPosicion()[1])).setBackgroundResource(JActual.getFicha());
		    	HashMap<Integer, Jugador> jugadores = Partida.Instancia().getJugadores();
		    	jugadores.remove(Partida.Instancia().Num_JugadorActual());
		    	jugadores.put(Partida.Instancia().Num_JugadorActual(), JActual);
		    	Partida.Instancia().setJugadores(jugadores);
			
				/////////////7
				
				//j.setPosicionTablero(11);
				//Partida.Instancia().setJugadorActual(j);

				AlertDialog ad = new AlertDialog.Builder(this).create();
				ad.setTitle("Vas a la biblioteca a estudiar");
				ad.setMessage("Tres turnos sin tirar");
				ad.show();
			}else if(cas.equals("edificio")){
		    	Jugador JActual=Partida.Instancia().JugadorActual();
		    	
				String nombre=buscarEdificio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				ArrayList<Tarjetas_Tablero> edificios = Partida.Instancia().tarjetasEdificio;
				boolean b=false;
				Tarjetas_Edificios edif=null;
				for(Tarjetas_Tablero edifi : edificios){
					if(((Tarjetas_Edificios)edifi).get_Categoria().equals(nombre)){
						b=true;
						edif=((Tarjetas_Edificios)edifi);
					}
				}
				if(b){
					if(edif.get_Creditos()<JActual.get_Creditos())
						botonComprar.setEnabled(true);
				}else{
					///Ya esta comprada
					if(mePerteneceEdificio(nombre)){
						//LA TENGO YO
					}else{
						botonPagar.setEnabled(true);
						pag=false;
					}
				}
			}else if(cas.equals("servicio")){
				Jugador JActual=Partida.Instancia().JugadorActual();
				String nombre=buscarServicio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				ArrayList<Tarjetas_Tablero> servicios = Partida.Instancia().tarjetasServicio;
				boolean b=false;
				Tarjetas_Servicios serv=null;
				for(Tarjetas_Tablero servi : servicios){
					if(((Tarjetas_Servicios)servi).get_Categoria().equals(nombre)){
						{
							b=true;	
							serv=((Tarjetas_Servicios)servi);
						}
					}
				}
				if(b){
					if(serv.get_Creditos()<JActual.get_Creditos())
						botonComprar.setEnabled(true);
				}else{
					///Ya esta comprada
					if(mePerteneceServicio(nombre)){
						//LA TENGO YO
					}else{
						botonPagar.setEnabled(true);
						pag=false;
					}
				}
			}
		}
		if(pag)
			this.boton2.setEnabled(true);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        final Button botonComprar=new Button(this);
    	final Button boton=new Button(this);//tirar los dados
        final Button botonPagar=new Button(this);
        Button boton2=new Button(this);//pasar turno
        Button boton1=new Button(this);//cambiar Pantalla
        Button botonSubir=new Button(this);//SubirNivel
    	
        
        this.botonComprar=botonComprar;
    	this.boton=boton;
    	this.boton2=boton2;
    	this.boton1=boton1;
    	this.botonPagar=botonPagar;
    	this.botonSubir=botonSubir;
    	
    	botonComprar.setEnabled(false);
    	boton2.setEnabled(false);
    	botonPagar.setEnabled(false);
    	botonSubir.setEnabled(false);
    	
        final AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        
        /*if(Partida.Instancia().JugadorActual().getTurnos()==0){
        	dialog.setTitle("TIRAR LOS DADOS");
        	dialog.setIcon(R.drawable.dados);
        	dialog.setMessage("¡SUERTE!");
        }else{
        	dialog.setTitle("ESTAS ESTUDIANDO");
        	dialog.setMessage("Te quedan "+Partida.Instancia().JugadorActual().getTurnos()+" turnos");
        }*/
        
        dialog.setCancelable(false);
        
        /*
        dialog.setPositiveButton("Tirar", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				aceptar();
			}
		});
        */
        //dialog.show();


        
        Display d =getWindowManager().getDefaultDisplay();
        int width=d.getWidth();
        int height=d.getHeight();
        float f=(float)1.25;
        
        TableRow.LayoutParams params = new TableRow.LayoutParams(width/10, (int) (width/10*f));
        TableLayout table = new TableLayout(this);
        tableroCeldas = new FrameLayout[10][4];
        int k=0;
        for (int i = 0; i < 4; i++) {
         if((i+1)%2==0){
          k=0;
         }else{
          k=1;
         }
            TableRow row = new TableRow(this);
            for (int j = 0; j < 10; j++) {
            	
            	//LayoutParams params1=new LayoutParams(width/25,width/25);
                //params1.setMargins(width/50, width/50, width/50, width/50);
            	//TableRow.LayoutParams params2 = new TableRow.LayoutParams(width/10, (int) (width/10*f));
            	LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(width/35,width/35);
            	params1.setMargins(width/100, width/50, width/100, width/100);
            	
            	LinearLayout l1=new LinearLayout(this);
                LinearLayout l2=new LinearLayout(this);
                
            	FrameLayout tableroFichas[][] = new FrameLayout[2][2];

            	//if(i==0 && j==0){
            	//HashMap<Integer,Jugador> jugadores=Partida.Instancia().getJugadores();
            	
            	//Dialog aa=new Dialog(this);
            	//if(jugadores!=null)aa.setTitle(jugadores.size());
            	//aa.show();
            	//jugadores.size();
            	//Jugador j1=jugadores.get(1);
           	 	tableroFichas[0][0] = new FrameLayout(this);
                tableroFichas[0][0].setLayoutParams(params1);
                
                //tableroFichas[j1.getPosicion()[0]][j1.getPosicion()[1]].setBackgroundColor(j1.getColor());
                
                //tableroFichas[0][0].setBackgroundColor(j1.getColor());
                
                
                tableroFichas[0][1] = new FrameLayout(this);
                tableroFichas[0][1].setLayoutParams(params1);
                /*if(jugadores.size()>1){
                	Jugador j2=jugadores.get(2);
                	tableroFichas[j2.getPosicion()[0]][j2.getPosicion()[1]].setBackgroundColor(j2.getColor());
                }*/
                
                tableroFichas[1][0] = new FrameLayout(this);
                tableroFichas[1][0].setLayoutParams(params1);
                /*if(jugadores.size()>2){
                	Jugador j3=jugadores.get(3);
                	tableroFichas[j3.getPosicion()[0]][j3.getPosicion()[1]].setBackgroundColor(j3.getColor());
                }*/
                //tableroFichas[1][0].setBackgroundColor(Color.YELLOW);
                
                tableroFichas[1][1] = new FrameLayout(this);
                tableroFichas[1][1].setLayoutParams(params1);
                /*if(jugadores.size()>3){
                	Jugador j4=jugadores.get(4);
                	tableroFichas[j4.getPosicion()[0]][j4.getPosicion()[1]].setBackgroundColor(j4.getColor());
                }*/
                
                //tableroFichas[1][1].setBackgroundColor(Color.BLUE);
            	//}
            	/*
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
            	*/
            	 tableroCeldas[j][i] = new FrameLayout(this);
                 tableroCeldas[j][i].setLayoutParams(params);
                
                 /*if(k==0 ){
                    tableroCeldas[j][i].setBackgroundResource(R.drawable.infantil);
                }else{
                	tableroCeldas[j][i].setBackgroundResource(R.drawable.infantil);
                }*/


                l1.addView(tableroFichas[0][0]);
                l1.addView(tableroFichas[0][1]);
                l2.addView(tableroFichas[1][0]);
                l2.addView(tableroFichas[1][1]);
                TableLayout tl=new TableLayout(this);
                tl.addView(l1);
                tl.addView(l2);

                //layoutParams.SetMargins(myMarginPx, myMarginPx, myMarginPx, myMarginPx);
                
                tableroCeldas[j][i].addView(tl);
                
                
                row.addView(tableroCeldas[j][i]);
                if(k==0){
                 k++;
                }else{
                 if(k==1) k = 0;
                }
            }
            table.addView(row);
            
        }
        asignarImagenes();
        
        HashMap<Integer,Jugador> jugadores=Partida.Instancia().getJugadores();    	
        
        Jugador j1=jugadores.get(1);
    	//tableroFichas[j2.getPosicion()[0]][j2.getPosicion()[1]].setBackgroundColor(j2.getColor());
        //((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(j1.getPosicion()[0])).getChildAt(j1.getPosicion()[1])).setBackgroundColor(j1.getColor());
        //((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(j1.getPosicion()[0])).getChildAt(j1.getPosicion()[1])).setBackground(j1.getFicha());
        ((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(j1.getPosicion()[0])).getChildAt(j1.getPosicion()[1])).setBackgroundResource(j1.getFicha());
        
        if(jugadores.size()>1){
        	Jugador j2=jugadores.get(2);
        	((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(j2.getPosicion()[0])).getChildAt(j2.getPosicion()[1])).setBackgroundResource(j2.getFicha());            
        }
        //((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[n[1]][n[0]].getChildAt(0)).getChildAt(JActual.getPosicion()[1])).getChildAt(JActual.getPosicion()[0])).setBackgroundResource(JActual.getColor());
        
        if(jugadores.size()>2){
        	Jugador j3=jugadores.get(3);
        	((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(j3.getPosicion()[0])).getChildAt(j3.getPosicion()[1])).setBackgroundResource(j3.getFicha());            
        }
        
        if(jugadores.size()>3){
        	Jugador j4=jugadores.get(4);
        	((FrameLayout)((LinearLayout) ((TableLayout) tableroCeldas[0][0].getChildAt(0)).getChildAt(j4.getPosicion()[0])).getChildAt(j4.getPosicion()[1])).setBackgroundResource(j4.getFicha());            
        }
        
        //final Button boton=new Button(this);
        boton.setText("Tirar los dados");
        boton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	              Button b=(Button) v;
	              //b.setText("pulsado");
	              b.setEnabled(false);
	        	  //Intent intent = new Intent(Tablero.this, TableroSecundario.class);
	              //startActivity(intent);
	              
	              if(Partida.Instancia().JugadorActual().getTurnos()==0){
	              	dialog.setTitle("TIRAR LOS DADOS");
	              	dialog.setIcon(R.drawable.dados);
	              	dialog.setMessage("¡SUERTE!");
	              	dialog.setPositiveButton("Tirar", new DialogInterface.OnClickListener() {
	        			
	        			public void onClick(DialogInterface dialog, int which) {
	        				// TODO Auto-generated method stub
	        				
	        				aceptar();
	        			}
	        		});
	              }else{
	              	dialog.setTitle("ESTAS ESTUDIANDO");
	              	dialog.setIcon(R.drawable.libro);
	              	dialog.setMessage("Te quedan "+Partida.Instancia().JugadorActual().getTurnos()+" turnos");
	              	dialog.setPositiveButton("Pasar turno", new DialogInterface.OnClickListener() {
	        			
	        			public void onClick(DialogInterface dialog, int which) {
	        				// TODO Auto-generated method stub
	        				
	        				aceptar();
	        			}
	        		});
	              }
	              
	              
	              
	              dialog.show();
	            //setContentView(R.layout.activity_dado);
	             

			}
		});
        
        
        //Button boton1=new Button(this);
        boton1.setText("Cambiar de pantalla");
        boton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	              //Button b=(Button) v;
	              //b.setText("pulsado");
    			/////
	        	  Intent intent = new Intent(Tablero.this, TableroSecundario.class);
	        	  startActivity(intent);   
			}
		});
        
        botonSubir.setText("Poner estrella");
        botonSubir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	              Button b=(Button) v;
	              b.setEnabled(false);
	        	  
	              int iden=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
	  			  
	              Jugador jugadorActual=Partida.Instancia().JugadorActual();
	              ArrayList<Tarjetas_Tablero> tarjetas = jugadorActual.getTarjetas();
	              int i=0;
	              while(tarjetas.get(i).get_Id()!=iden){
	            	  i++;
	              }
	              Tarjetas_Tablero tar=tarjetas.get(i);
	              ((Tarjetas_Titulaciones)tar).subirNivel();
	              jugadorActual.set_Creditos(jugadorActual.get_Creditos()-((Tarjetas_Titulaciones)tar).getCosteEstrella());
	              tarjetas.set(i, tar);
	              jugadorActual.setTarjetas(tarjetas);
	              Partida.Instancia().setJugadorActual(jugadorActual);
	              
	              int[] n = posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero());

	              int nivel=((Tarjetas_Titulaciones)tar).getNivel();
	              int[] imagenes=((Tarjetas_Titulaciones)tar).getImagenNiveles();
	              tableroCeldas[n[1]][n[0]].setBackgroundResource(imagenes[nivel-1]);              
	              
	              AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
					ad.setTitle("!!PONER ESTRELLA¡¡");
					ad.setMessage("enhorabuena de has puesto una estrella -"+((Tarjetas_Titulaciones)tar).getCosteEstrella());
					ad.show();
	              /*
	              for(Tarjetas_Tablero tar:jugadorActual.getTarjetas()){
	            	  if(tar.get_Id()==iden){
	            		  ((Tarjetas_Titulaciones)tar).subirNivel();
	            		  jugadorActual.
	            	  }
	              }*/
	  			  
			}
		});
        
        /*final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        final Preguntas p=new Preguntas();
		final HashMap<Integer, String[]> pr = p.pregunta();
        final String[] items = {pr.get(3)[1],pr.get(3)[2],pr.get(3)[3],pr.get(3)[4]};
        
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
  			
  			public void onClick(DialogInterface dialog, int which) {
  				// TODO Auto-generated method stub
  				preguntar();
  			}
  		});
        
        int selected = 0; // or whatever you want
        builder.setSingleChoiceItems(items, selected, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                      //onclick
            	res=items[item];

	              if(res==pr.get(3)[3]){
	            	  sol=true;
	              }else{
	            	  sol=false;
	              }
            }});
        
        builder.setTitle(pr.get(3)[0]);
        */
        
        //final Button botonComprar=new Button(this);
        botonComprar.setText("Comprar");
        botonComprar.setOnClickListener(new OnClickListener() {
        		
			@Override
			public void onClick(View v) {
				Button b=(Button)v;
				b.setEnabled(false);
				String cat=buscarCategoria(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				String cas=Casilla(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				
					if(!cat.equals("")){
				int iden=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				//Tarjetas_Titulaciones tar=(Tarjetas_Titulaciones) tarjetaCategoria(cat);
				Tarjetas_Titulaciones tar=(Tarjetas_Titulaciones) tarjetaIden(iden);
				
				Jugador j=Partida.Instancia().JugadorActual();
				j.ComprarTarjetas(tar);
				j.set_Creditos(j.get_Creditos()-tar.get_Creditos());
				Partida.Instancia().setJugadorActual(j);
				//j.getTarjetas().get(0);
				//Partida.Instancia().JugadorActual().getTarjetas().get(0);
				tar.get_Creditos();
				ArrayList<Tarjetas_Tablero> tt = Partida.Instancia().tarjetas;
				tt.remove(tarjetaPosicion(iden));
				//tt.remove(3);
				Partida.Instancia().tarjetas=tt;


				AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
				ad.setTitle("!!COMPRADA¡¡");
				ad.setMessage("enhorabuena de comprar una tarjeta de titulación -"+tar.get_Creditos());
				ad.show();
				finPartida();
					}else if(cas.equals("edificio")){
						/*
						Jugador JActual=Partida.Instancia().JugadorActual();
				String nombre=buscarEdificio(JActual.getPosicion());
				ArrayList<Tarjetas_Tablero> edificios = Partida.Instancia().tarjetasEdificio;
				boolean b=false;
				for(Tarjetas_Tablero edifi : edificios){
					if(((Tarjetas_Edificios)edifi).get_Categoria().equals(nombre)){
						b=true;
					}
				}
				if(b){
					botonComprar.setEnabled(true);
				}else{
					///Ya esta comprada
				}
						 */
						Jugador JActual=Partida.Instancia().JugadorActual();
						String nombre=buscarEdificio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
						ArrayList<Tarjetas_Tablero> edificios = Partida.Instancia().tarjetasEdificio;
						Tarjetas_Edificios edificio = null;
						int i=0,j=0;
						for(Tarjetas_Tablero edifi: edificios){
							
							if(((Tarjetas_Edificios)edifi).get_Categoria().equals(nombre)){
								edificio=(Tarjetas_Edificios)edifi;
								j=i;
							}
							i++;
						}
						
						
						ArrayList<Tarjetas_Edificios> JEdificio = JActual.getTarjetasEdificio();
						JEdificio.add(edificio);
						JActual.setTarjetasEdificio(JEdificio);
						JActual.set_Creditos(JActual.get_Creditos()-edificio.get_Creditos());
						Partida.Instancia().setJugadorActual(JActual);
						
						ArrayList<Tarjetas_Tablero> tt = Partida.Instancia().tarjetasEdificio;
						tt.remove(j);
						//tt.remove(3);
						Partida.Instancia().tarjetasEdificio=tt;
						
						
						AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
						ad.setTitle("!!COMPRADA¡¡");
						ad.setMessage("enhorabuena de comprar una tarjeta de edificio -"+edificio.get_Creditos());
						ad.show();
					}else if(cas.equals("servicio")){

						Jugador JActual=Partida.Instancia().JugadorActual();
						String nombre=buscarServicio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
						ArrayList<Tarjetas_Tablero> servicios = Partida.Instancia().tarjetasServicio;
						Tarjetas_Servicios servicio = null;
						int i=0,j=0;
						for(Tarjetas_Tablero servi: servicios){
							
							if(((Tarjetas_Servicios)servi).get_Categoria().equals(nombre)){
								servicio=(Tarjetas_Servicios)servi;
								j=i;
							}
							i++;
						}
						
						ArrayList<Tarjetas_Servicios> JServicio= JActual.getTarjetasServicio();
						JServicio.add(servicio);
						JActual.setTarjetasServicio(JServicio);
						JActual.set_Creditos(JActual.get_Creditos()-servicio.get_Creditos());
						Partida.Instancia().setJugadorActual(JActual);

						ArrayList<Tarjetas_Tablero> tt = Partida.Instancia().tarjetasServicio;
						tt.remove(j);
						//tt.remove(3);
						//Partida.Instancia().tarjetasServicio.clear();
						Partida.Instancia().tarjetasServicio=tt;
						
						
						AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
						ad.setTitle("!!COMPRADA¡¡");
						ad.setMessage("enhorabuena de comprar una tarjeta de servicio -"+servicio.get_Creditos());
						ad.show();

					}
			}
		});
        
        
        //final Button botonPagar=new Button(this);
        botonPagar.setText("Pagar");
        botonPagar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button b=(Button) v;
	            b.setEnabled(false);
	            String cat=buscarCategoria(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
	    		if(!cat.equals("")){
	    			Jugador jugadorActual=Partida.Instancia().JugadorActual(), jugadorTarjeta = null;
	    			Tarjetas_Titulaciones tarjetaTitulacion = null;
	    			int nPosJug;
	    			int iden1=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
	    				
	    			HashMap<Integer, Jugador> jugadoresPartida = Partida.Instancia().jugadores;
	            
	    			for(nPosJug=1;nPosJug<jugadoresPartida.size()+1;nPosJug++){
	    				for(int j=0;j<jugadoresPartida.get(nPosJug).getTarjetas().size();j++){
	    					if(jugadoresPartida.get(nPosJug).getTarjetas().get(j).get_Id()==iden1){
	    						jugadorTarjeta=jugadoresPartida.get(nPosJug);
	    						tarjetaTitulacion=(Tarjetas_Titulaciones) jugadoresPartida.get(nPosJug).getTarjetas().get(j);
	    					}
	    				}
	    			}
	    			///////
	    			AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
					
	    			switch (tarjetaTitulacion.getNivel()) {
					case 0:
						if(doble){
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-(tarjetaTitulacion.get_Mat0()*2));
		    				jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+(tarjetaTitulacion.get_Mat0()*2));
		    				ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+(tarjetaTitulacion.get_Mat0()*2));
		    			}else{
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaTitulacion.get_Mat0());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaTitulacion.get_Mat0());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaTitulacion.get_Mat0());
			    		}
						break;
					case 1:
						if(doble){
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-(tarjetaTitulacion.get_Mat1()*2));
		    				jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+(tarjetaTitulacion.get_Mat1()*2));
		    				ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+(tarjetaTitulacion.get_Mat1()*2));
		    			}else{
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaTitulacion.get_Mat1());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaTitulacion.get_Mat1());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaTitulacion.get_Mat1());
			    		}
						break;
					case 2:
						if(doble){
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-(tarjetaTitulacion.get_Mat2()*2));
		    				jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+(tarjetaTitulacion.get_Mat2()*2));
		    				ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+(tarjetaTitulacion.get_Mat2()*2));
		    			}else{
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaTitulacion.get_Mat2());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaTitulacion.get_Mat2());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaTitulacion.get_Mat2());
			    		}
						break;
					case 3:
						if(doble){
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-(tarjetaTitulacion.get_Mat3()*2));
		    				jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+(tarjetaTitulacion.get_Mat3()*2));
		    				ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+(tarjetaTitulacion.get_Mat3()*2));
		    			}else{
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaTitulacion.get_Mat3());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaTitulacion.get_Mat3());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaTitulacion.get_Mat3());
			    		}
						break;
					case 4:
						if(doble){
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-(tarjetaTitulacion.get_Mat4()*2));
		    				jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+(tarjetaTitulacion.get_Mat4()*2));
		    				ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+(tarjetaTitulacion.get_Mat4()*2));
		    			}else{
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaTitulacion.get_Mat4());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaTitulacion.get_Mat4());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaTitulacion.get_Mat4());
			    		}
						break;

					default:
						if(doble){
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-(tarjetaTitulacion.get_Licenciado()*2));
		    				jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+(tarjetaTitulacion.get_Licenciado()*2));
		    				ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+(tarjetaTitulacion.get_Licenciado()*2));
		    			}else{
		    				jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaTitulacion.get_Licenciado());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaTitulacion.get_Licenciado());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaTitulacion.get_Licenciado());
			    		}
						break;
					}
	    			
	    			/////////
	    			//Partida.Instancia().jugadores.put(nPosJug, jugadorTarjeta);
	            	Partida.Instancia().setJugadorActual(jugadorActual);
	            
	            	ad.setTitle("!!PAGADO¡¡");
					ad.show();
	            	
	            	Tablero.this.boton2.setEnabled(true);
	            	doble=false;
	    		}else{
	    			String cas=Casilla(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
	    			if(cas.equals("edificio")){
	    				
	    				Jugador jugadorActual=Partida.Instancia().JugadorActual(), jugadorTarjeta = null;
		    			Tarjetas_Edificios tarjetaEdificio = null;
		    			int nPosJug;
		    			String nombre=buscarEdificio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
		    			//int iden1=buscarTarjeta(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
		    				/*
		    	String nombre=buscarEdificio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
				ArrayList<Tarjetas_Tablero> edificios = Partida.Instancia().tarjetasEdificio;
				boolean b=false;
				for(Tarjetas_Tablero edifi : edificios){
					if(((Tarjetas_Edificios)edifi).get_Categoria().equals(nombre)){
						b=true;
					}
				}
		    				 */
		    			HashMap<Integer, Jugador> jugadoresPartida = Partida.Instancia().jugadores;
		            
		    			for(nPosJug=1;nPosJug<jugadoresPartida.size()+1;nPosJug++){
		    				for(int j=0;j<jugadoresPartida.get(nPosJug).getTarjetasEdificio().size();j++){
		    					if(jugadoresPartida.get(nPosJug).getTarjetasEdificio().get(j).get_Categoria()==nombre){
		    						jugadorTarjeta=jugadoresPartida.get(nPosJug);
		    						tarjetaEdificio=jugadoresPartida.get(nPosJug).getTarjetasEdificio().get(j);
		    					}
		    				}
		    			}
		    			int nTar=jugadorTarjeta.getTarjetasEdificio().size();
		    			AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
						
		    			switch (nTar) {
						case 1:
							jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaEdificio.get_Coste1());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaEdificio.get_Coste1());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaEdificio.get_Coste1());
							
							break;
						case 2:
							jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaEdificio.get_Coste2());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaEdificio.get_Coste2());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaEdificio.get_Coste2());
							
							break;
						case 3:
							jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaEdificio.get_Coste3());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaEdificio.get_Coste3());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaEdificio.get_Coste3());
							
							break;

						default:
							jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaEdificio.get_Coste4());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaEdificio.get_Coste4());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaEdificio.get_Coste4());
							
							break;
						}
		    			
		    			//Partida.Instancia().jugadores.put(nPosJug, jugadorTarjeta);
		            	Partida.Instancia().setJugadorActual(jugadorActual);
		            
		            	Tablero.this.boton2.setEnabled(true);
	    			
		            	ad.setTitle("!!PAGADO¡¡");
						ad.show();
		            	
	    			}else if(cas.equals("servicio")){
	    				
	    				Jugador jugadorActual=Partida.Instancia().JugadorActual(), jugadorTarjeta = null;
		    			Tarjetas_Servicios tarjetaServicio = null;
		    			int nPosJug;
		    			String nombre=buscarServicio(posicionTablero(Partida.Instancia().JugadorActual().getPosicionTablero()));
		    			
		    			HashMap<Integer, Jugador> jugadoresPartida = Partida.Instancia().jugadores;
		            
		    			for(nPosJug=1;nPosJug<jugadoresPartida.size()+1;nPosJug++){
		    				for(int j=0;j<jugadoresPartida.get(nPosJug).getTarjetasServicio().size();j++){
		    					if(jugadoresPartida.get(nPosJug).getTarjetasServicio().get(j).get_Categoria()==nombre){
		    						jugadorTarjeta=jugadoresPartida.get(nPosJug);
		    						tarjetaServicio=jugadoresPartida.get(nPosJug).getTarjetasServicio().get(j);
		    					}
		    				}
		    			}
		            
		    			AlertDialog ad = new AlertDialog.Builder(Tablero.this).create();
						
		    			int nTar=jugadorTarjeta.getTarjetasServicio().size();
		    			switch (nTar) {
						case 1:
							jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaServicio.get_Coste1());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaServicio.get_Coste1());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaServicio.get_Coste1());
							
							break;
							
						default:
							jugadorActual.set_Creditos(jugadorActual.get_Creditos()-tarjetaServicio.get_Coste2());
			    			jugadorTarjeta.set_Creditos(jugadorTarjeta.get_Creditos()+tarjetaServicio.get_Coste2());
			    			ad.setMessage("has tenido que pagar a "+jugadorTarjeta.get_Nombre()+" -"+tarjetaServicio.get_Coste2());
							
			    			break;
						}

		    			//Partida.Instancia().jugadores.put(nPosJug, jugadorTarjeta);
		            	Partida.Instancia().setJugadorActual(jugadorActual);
		            
		    			
		            	Tablero.this.boton2.setEnabled(true);
	    				
		            	ad.setTitle("!!PAGADO¡¡");
						ad.show();
	    			}
	    		}
    			eliminarjugador();
			}
		});
        
        
        
        //Button boton2=new Button(this);
        boton2.setText("Pasar turno");
        boton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button b=(Button)v;
				b.setEnabled(false);
    	    	if(!dobles)
	    	    	Partida.Instancia().Jugador_Siguiente(); 
    	    	botonComprar.setEnabled(false);
    	    	botonPagar.setEnabled(false);
    	    	boton.setEnabled(true);
	              //pregunta();
	              //builder.show();
	              
	              
			}
		});
                //pruebas=boton2;
        
        TableRow tr = new TableRow(this);
        LinearLayout ll1 = new LinearLayout(this);
        ll1.addView(boton);
        ll1.addView(boton1);
        ll1.addView(boton2);
        ll1.addView(botonComprar);
        ll1.addView(botonPagar);
        ll1.addView(botonSubir);
        tr.addView(ll1);
        
        LinearLayout ll = new LinearLayout(this);

        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(table);
        ll.addView(tr);
        setContentView(ll);
    }
    
    /*protected Tarjetas_Tablero tarjetaCategoria(String cat) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().tarjetas){
    		if(tarjeta.get_Categoria().equals(cat)){
    			return tarjeta;
    		}
    	}
		return Partida.Instancia().tarjetas.get(1);
	}*/

    protected Tarjetas_Tablero tarjetaIden(int iden) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().tarjetas){
    		if(tarjeta.get_Id()==iden){
    			return tarjeta;
    		}
    	}
		return null;
	}
    
    protected Tarjetas_Tablero tarjetaIdenJug(int iden) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().JugadorActual().getTarjetas()){
    		if(tarjeta.get_Id()==iden){
    			return tarjeta;
    		}
    	}
		return null;
	}
    
    protected int tarjetaPosicion(int iden) {
    	int i=0;
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().tarjetas){
    		if(tarjeta.get_Id()==iden){
    			return i;
    		}
    		i++;
    	}
		return 0;
	}
    
    
    protected boolean estaTajeta(int iden) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().tarjetas){
    		if(tarjeta.get_Id()==iden){
    			return true;
    		}
    	}
		return false;
	}
    
    protected boolean mePertenece(int iden) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().JugadorActual().getTarjetas()){
    		if(tarjeta.get_Id()==iden){
    			return true;
    		}
    	}
		return false;
	}
    
    protected boolean mePerteneceEdificio(String cat) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().JugadorActual().getTarjetasEdificio()){
    		if(tarjeta.get_Categoria()==cat){
    			return true;
    		}
    	}
		return false;
	}
    
    protected boolean mePerteneceServicio(String cat) {
    	for(Tarjetas_Tablero tarjeta:Partida.Instancia().JugadorActual().getTarjetasServicio()){
    		if(tarjeta.get_Categoria()==cat){
    			return true;
    		}
    	}
		return false;
	}
    
	public void asignarImagenes(){
    	int[] posicion;
    	int cas;
    	for(cas=1;cas<=40;cas++)
    	{
    		posicion=posicionTablero(cas);
    		switch (cas) 
    		{
			case 1:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla01);break;		
			case 2:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla02);break;
			case 3:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla03);break;
			case 4:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla04);break;
			case 5:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla05);break;
			case 6:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla06);break;
			case 7:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla07);break;
			case 8:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla08);break;
			case 9:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla09);break;
			case 10:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla10);break;
			case 11:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla11);break;
			case 12:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla12);break;
			case 13:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla13);break;
			case 14:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla14);break;
			case 15:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla15);break;
			case 16:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla16);break;
			case 17:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla17);break;
			case 18:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla18);break;
			case 19:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla19);break;
			case 20:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla20);break;
			case 21:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla21);break;
			case 22:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla22);break;
			case 23:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla23);break;
			case 24:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla24);break;
			case 25:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla25);break;
			case 26:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla26);break;
			case 27:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla27);break;
			case 28:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla28);break;
			case 29:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla29);break;
			case 30:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla30);break;
			case 31:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla31);break;
			case 32:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla32);break;
			case 33:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla33);break;
			case 34:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla34);break;
			case 35:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla35);break;
			case 36:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla36);break;
			case 37:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla37);break;
			case 38:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla38);break;
			case 39:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla39);break;
			case 40:tableroCeldas[posicion[1]][posicion[0]].setBackgroundResource(R.drawable.casilla40);break;
			} 
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
public static int buscarTarjeta(int[] posicion){
		
    	if(posicion[0]==0&&posicion[1]==1){
    		return 1;
    	}else if(posicion[0]==0&&posicion[1]==3){
    		return 2;
    	}else if(posicion[0]==0&&posicion[1]==6){
    		return 3;
    	}else if(posicion[0]==0&&posicion[1]==8){
    		return 4;
    	}else if(posicion[0]==0&&posicion[1]==9){
    		return 5;
    	}else if(posicion[0]==1&&posicion[1]==8){
    		return 6;
    	}else if(posicion[0]==1&&posicion[1]==6){
    		return 7;
    	}else if(posicion[0]==1&&posicion[1]==5){
    		return 8;
    	}else if(posicion[0]==1&&posicion[1]==3){
    		return 9;
    	}else if(posicion[0]==1&&posicion[1]==1){
    		return 10;
    	}else if(posicion[0]==2&&posicion[1]==1){
    		return 11;
    	}else if(posicion[0]==2&&posicion[1]==3){
    		return 12;
    	}else if(posicion[0]==2&&posicion[1]==5){
    		return 13;
    	}else if(posicion[0]==2&&posicion[1]==6){
    		return 14;
    	}else if(posicion[0]==2&&posicion[1]==8){
    		return 15;
    	}else if(posicion[0]==2&&posicion[1]==9){
    		return 16;
    	}else if(posicion[0]==3&&posicion[1]==8){
    		return 17;
    	}else if(posicion[0]==3&&posicion[1]==6){
    		return 18;
    	}else if(posicion[0]==3&&posicion[1]==5){
    		return 19;
    	}else if(posicion[0]==3&&posicion[1]==3){
    		return 20;
    	}else if(posicion[0]==3&&posicion[1]==0){
    		return 21;
    	}else if(posicion[0]==1&&posicion[1]==0){
    		return 22;
    	}else{
    		return 1;
    	}
   	
    }
    
public static String Casilla(int[] posicion){
	if(posicion[0]==0&&posicion[1]==2){
		return "sorpresa";
	}else if(posicion[0]==0&&posicion[1]==7){
		return "sorpresa";
	}else if(posicion[0]==1&&posicion[1]==2){
		return "sorpresa";
	}else if(posicion[0]==2&&posicion[1]==4){
		return "sorpresa";
	}else if(posicion[0]==3&&posicion[1]==1){
		return "sorpresa";
	}else if(posicion[0]==3&&posicion[1]==4){
		return "sorpresa";
	}else if(posicion[0]==0&&posicion[1]==4){
		return "gMatricula";
	}else if(posicion[0]==2&&posicion[1]==0){
		return "gDeportivos";
	}else if(posicion[0]==3&&posicion[1]==7){
		return "estudiar";
	}else if(posicion[0]==0&&posicion[1]==5){
		return "edificio";
	}else if(posicion[0]==1&&posicion[1]==4){
		return "edificio";
	}else if(posicion[0]==2&&posicion[1]==7){
		return "edificio";
	}else if(posicion[0]==3&&posicion[1]==2){
		return "edificio";
	}else if(posicion[0]==1&&posicion[1]==7){
		return "servicio";
	}else if(posicion[0]==3&&posicion[1]==9){
		return "servicio";
	}else{
		return "";
	}
}
    public static String buscarEdificio(int[] posicion){
    	if(posicion[0]==0&&posicion[1]==5){
    		return "vives";
    	}else if(posicion[0]==1&&posicion[1]==4){
    		return "quintiliano";
    	}else if(posicion[0]==2&&posicion[1]==7){
    		return "politecnico";
    	}else if(posicion[0]==3&&posicion[1]==2){
    		return "cct";
    	}else{
    		return "";
    	}
    }
    
    public static String buscarServicio(int[] posicion){
    	if(posicion[0]==1&&posicion[1]==7){
    		return "fotocopiadora";
    	}else if(posicion[0]==3&&posicion[1]==9){
    		return "expendedora";
    	}else{
    		return "";
    	}
    }
    
    public static String buscarCategoria(int[] posicion){
		
    	if(posicion[0]==0&&posicion[1]==1){
    		return "magisterio";
    	}else if(posicion[0]==0&&posicion[1]==3){
    		return "magisterio";
    	}else if(posicion[0]==0&&posicion[1]==6){
    		return "ingles";
    	}else if(posicion[0]==0&&posicion[1]==8){
    		return "geografia";
    	}else if(posicion[0]==0&&posicion[1]==9){
    		return "lenguaje";
    	}else if(posicion[0]==1&&posicion[1]==8){
    		return "juridico";
    	}else if(posicion[0]==1&&posicion[1]==6){
    		return "juridico";
    	}else if(posicion[0]==1&&posicion[1]==5){
    		return "juridico";
    	}else if(posicion[0]==1&&posicion[1]==3){
    		return "empresa";
    	}else if(posicion[0]==1&&posicion[1]==1){
    		return "turismo";
    	}else if(posicion[0]==2&&posicion[1]==1){
    		return "enfermeria";
    	}else if(posicion[0]==2&&posicion[1]==3){
    		return "industrial";
    	}else if(posicion[0]==2&&posicion[1]==5){
    		return "industrial";
    	}else if(posicion[0]==2&&posicion[1]==6){
    		return "industrial";
    	}else if(posicion[0]==2&&posicion[1]==8){
    		return "agricola";
    	}else if(posicion[0]==2&&posicion[1]==9){
    		return "enologia";
    	}else if(posicion[0]==3&&posicion[1]==8){
    		return "quimica";
    	}else if(posicion[0]==3&&posicion[1]==6){
    		return "mates";
    	}else if(posicion[0]==3&&posicion[1]==3){
    		return "informatica";
    	}else if(posicion[0]==3&&posicion[1]==5){
    		return "informatica";
    	}else if(posicion[0]==1&&posicion[1]==0){
    		return "experiencia";
    	}else if(posicion[0]==3&&posicion[1]==0){
    		return "experiencia";
    	}else{
    		return "";
    	}
   	
    }
    
    public static int[] posicionTablero(int x){
    	int[] posicion=new int[2];
    	switch (x) {
    	case 1:
			posicion[0]=0;
			posicion[1]=0;	
			break;

		case 2:
			posicion[0]=0;
			posicion[1]=1;	
			break;
			
		case 3:
			posicion[0]=0;
			posicion[1]=2;	
			break;
			
		case 4:
			posicion[0]=0;
			posicion[1]=3;	
			break;
			
		case 5:
			posicion[0]=0;
			posicion[1]=4;	
			break;
			
		case 6:
			posicion[0]=0;
			posicion[1]=5;	
			break;
			
		case 7:
			posicion[0]=0;
			posicion[1]=6;	
			break;
		
		case 8:
			posicion[0]=0;
			posicion[1]=7;	
			break;
			
		case 9:
			posicion[0]=0;
			posicion[1]=8;	
			break;
			
		case 10:
			posicion[0]=0;
			posicion[1]=9;	
			break;

//    	Fila 2
		case 19:
			posicion[0]=1;
			posicion[1]=1;	
			break;
			
		case 18:
			posicion[0]=1;
			posicion[1]=2;	
			break;
			
		case 17:
			posicion[0]=1;
			posicion[1]=3;	
			break;
			
		case 16:
			posicion[0]=1;
			posicion[1]=4;	
			break;
			
		case 15:
			posicion[0]=1;
			posicion[1]=5;	
			break;
			
		case 14:
			posicion[0]=1;
			posicion[1]=6;	
			break;
		
		case 13:
			posicion[0]=1;
			posicion[1]=7;	
			break;
			
		case 12:
			posicion[0]=1;
			posicion[1]=8;	
			break;
			
		case 11:
			posicion[0]=1;
			posicion[1]=9;	
			break;
			
			 //    	Fila 3
		case 20:
			posicion[0]=2;
			posicion[1]=1;	
			break;
			
		case 21:
			posicion[0]=2;
			posicion[1]=2;	
			break;
			
		case 22:
			posicion[0]=2;
			posicion[1]=3;	
			break;
			
		case 23:
			posicion[0]=2;
			posicion[1]=4;	
			break;
			
		case 24:
			posicion[0]=2;
			posicion[1]=5;	
			break;
			
		case 25:
			posicion[0]=2;
			posicion[1]=6;	
			break;
		
		case 26:
			posicion[0]=2;
			posicion[1]=7;	
			break;
			
		case 27:
			posicion[0]=2;
			posicion[1]=8;	
			break;
			
		case 28:
			posicion[0]=2;
			posicion[1]=9;	
			break;
			
			 //    	Fila 4
		case 29:
			posicion[0]=3;
			posicion[1]=9;	
			break;

		case 30:
			posicion[0]=3;
			posicion[1]=8;	
			break;
			
		case 31:
			posicion[0]=3;
			posicion[1]=7;	
			break;
			
		case 32:
			posicion[0]=3;
			posicion[1]=6;	
			break;
			
		case 33:
			posicion[0]=3;
			posicion[1]=5;	
			break;
			
		case 34:
			posicion[0]=3;
			posicion[1]=4;	
			break;
			
		case 35:
			posicion[0]=3;
			posicion[1]=3;	
			break;
		
		case 36:
			posicion[0]=3;
			posicion[1]=2;	
			break;
			
		case 37:
			posicion[0]=3;
			posicion[1]=1;	
			break;
			
		case 38:
			posicion[0]=3;
			posicion[1]=0;	
			break;
			
		case 39:
			posicion[0]=2;
			posicion[1]=0;	
			break;
			
		case 40:
			posicion[0]=1;
			posicion[1]=0;	
			break;
			
		default:
			posicion[0]=0;
			posicion[1]=0;	
			break;
		}
    	return posicion;
    }
}
