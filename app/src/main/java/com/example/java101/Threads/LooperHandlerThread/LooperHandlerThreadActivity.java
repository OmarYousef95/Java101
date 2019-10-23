package com.example.java101.Threads.LooperHandlerThread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.java101.R;

public class LooperHandlerThreadActivity extends AppCompatActivity {

    Button startThreadBtn, stopThreadBtn, taskABtn, taskBBtn;

    ExampleLooperThread looperThread = new ExampleLooperThread();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_handler_thread);


        startThreadBtn = findViewById(R.id.looper_handler_start_btn);
        stopThreadBtn = findViewById(R.id.looper_handler_stop_btn);
        taskABtn = findViewById(R.id.looper_handler_taskA_btn);
        taskBBtn = findViewById(R.id.looper_handler_taskB_btn);

        startThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startThread();
            }
        });

        stopThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopThread();
            }
        });

        taskABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskA();
            }
        });

        taskBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskB();

            }
        });

    }

    private void startThread() {
        looperThread.start();
    }

    private void stopThread() {

        looperThread.looper.quit();

    }

    private void taskA() {

        Handler threadHandler = new Handler(looperThread.looper);
        threadHandler.post(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    Log.v("ZXC","Run: " + i);
                    SystemClock.sleep(1000);
                }

            }
        });

    }

    private void taskB() {


    }
}
