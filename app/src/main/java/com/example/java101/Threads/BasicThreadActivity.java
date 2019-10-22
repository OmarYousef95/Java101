package com.example.java101.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.java101.R;

public class BasicThreadActivity extends AppCompatActivity {

    Button startThreadBtn;

    private Handler mainHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_thread);

        startThreadBtn = findViewById(R.id.start_thread);

        startThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread();
            }
        });




    }

    private void startThread() {

        //To start a Thread from the Thread class (inner class) we created below.
//        ExampleThread thread = new ExampleThread(10);
//        thread.start();

        //To start a Runnable from the Runnable class (inner class) we created below.
//        ExampleRunnable runnable = new ExampleRunnable(10);
//        new Thread(runnable).start();

        ExampleRunnableWithHandler runnableWithHandler = new ExampleRunnableWithHandler(10);
        new Thread(runnableWithHandler).start();

        //To start anynomous thread without creat a class
       /*
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0 ; i <10 ; i++){

                    Log.v("ZXC","StartThread: "+ i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        */

    }

    class ExampleThread extends Thread {

        int seconds;

        public ExampleThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {


            //Here just example code to sleep for specific amount of seconds
            for (int i = 0 ; i <seconds ; i++){

                Log.v("ZXC","StartThread: "+ i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    class ExampleRunnable implements Runnable{


        int seconds;

        public ExampleRunnable(int seconds) {
            this.seconds = seconds;
        }


        @Override
        public void run() {

            for (int i = 0 ; i <seconds ; i++){

                Log.v("ZXC","StartThread: "+ i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    class ExampleRunnableWithHandler implements Runnable{


        int seconds;

        public ExampleRunnableWithHandler(int seconds) {
            this.seconds = seconds;
        }


        @Override
        public void run() {


            for (int i = 0 ; i <seconds ; i++){


                //To change a view there is three ways
                //1.
                if (i == 5){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            startThreadBtn.setText("50%");
                        }
                    });
                }

                //2.
                /*startThreadBtn.post(new Runnable() {
                    @Override
                    public void run() {
                        startThreadBtn.setText("50%");
                    }
                });*/

                //3.
                /*runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startThreadBtn.setText("50%");
                    }
                });*/

                Log.v("ZXC","StartThread: "+ i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
