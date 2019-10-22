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
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1;

    Button testBtn;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    TextView textView1,textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = findViewById(R.id.testBtn);

        textView1 = findViewById(R.id.test1);
        textView2 = findViewById(R.id.test2);
        textView3 = findViewById(R.id.test3);
        textView4 = findViewById(R.id.test4);


        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskThreadActivity.class);
                startActivity(intent);
            }
        });



        textView1.setText("http://www.google.com");
        Linkify.addLinks(textView1,Linkify.WEB_URLS);

        textView2.setText("5552323233");
        Linkify.addLinks(textView2  , Linkify.PHONE_NUMBERS);

        textView3.setText("436 Mayfield Ave, Stanford, CA");
        Linkify.addLinks(textView3 , Linkify.MAP_ADDRESSES);

        textView4.setText("omarm7sere95@gmail.com");
        Linkify.addLinks(textView4, Linkify.EMAIL_ADDRESSES);


    }


}
