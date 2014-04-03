package com.proyecto.trivialpolyur;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_splashscreen);
        
        
        mProgress = (ProgressBar) findViewById(R.id.progressBar1);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus = doWork(mProgressStatus);
                    try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
         	   Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
         	   
               startActivity(intent);
               finish();
            }

			private int doWork(int x) {
				// TODO Auto-generated method stub
				return x+1;
			}
        }).start();
        
        
        /*
        Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {
              Button b=(Button) v;
              b.setText("pulsado");

              mProgress = (ProgressBar) findViewById(R.id.progressBar1);

              // Start lengthy operation in a background thread
              new Thread(new Runnable() {
                  public void run() {
                      while (mProgressStatus < 100) {
                          mProgressStatus = doWork(mProgressStatus);
                          try {
      						Thread.sleep(10);
      					} catch (InterruptedException e) {
      						// TODO Auto-generated catch block
      						e.printStackTrace();
      					}
                          // Update the progress bar
                          mHandler.post(new Runnable() {
                              public void run() {
                                  mProgress.setProgress(mProgressStatus);
                              }
                          });
                      }
               	   Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
               	   
                   startActivity(intent);
                   finish();
                  }

      			private int doWork(int x) {
      				// TODO Auto-generated method stub
      				return x+10;
      			}
              }).start();

           }
        });*/
        
        //ProgressBar progressBar =(ProgressBar)findViewById(R.id.progressBar1); 
        
        

    }


    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
