package com.example.java101.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.java101.R;

public class PostDelayedRunnableActivity extends AppCompatActivity {

    Button startBtn, stopBtn;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_delayed_runnable);

        startBtn = findViewById(R.id.post_delayed_start_btn);
        stopBtn = findViewById(R.id.post_delayed_stop_btn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRepeating();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopRepeating();
            }
        });


    }

    private void startRepeating() {

       handler.postDelayed(ExampleRunnable,3000);
    }

    private void stopRepeating() {


    }

    private Runnable ExampleRunnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(PostDelayedRunnableActivity.this, "This is delayed Toast", Toast.LENGTH_SHORT).show();
        }
    };
}
