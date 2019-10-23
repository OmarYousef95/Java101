package com.example.java101.Threads.LooperHandlerThread;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class ExampleLooperThread extends Thread {

    public Handler handler;
    public Looper looper;


    @Override
    public void run() {

        Looper.prepare();


        looper = Looper.myLooper();

        handler = new Handler();

        Looper.loop();

        Log.v("ZXC","End of run()");


    }
}
