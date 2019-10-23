package com.example.java101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java101.Test.GridView.GridViewActivity;
import com.example.java101.Test.ListView.ListViewActivity;
import com.example.java101.Test.RV.RVActivity;
import com.example.java101.Threads.AsyncTaskThreadActivity;
import com.example.java101.Threads.BasicThreadActivity;
import com.example.java101.Threads.LooperHandlerThread.LooperHandlerThreadActivity;
import com.example.java101.Threads.PostDelayedRunnableActivity;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1;

    Button testBtn;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = findViewById(R.id.testBtn);




        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinkifyActivity.class);
                startActivity(intent);
            }
        });







    }


}
