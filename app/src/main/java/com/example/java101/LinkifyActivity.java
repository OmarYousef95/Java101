package com.example.java101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class LinkifyActivity extends AppCompatActivity {


    TextView textView1,textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkify);

        textView1 = findViewById(R.id.test1);
        textView2 = findViewById(R.id.test2);
        textView3 = findViewById(R.id.test3);
        textView4 = findViewById(R.id.test4);

        //Linkify
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
