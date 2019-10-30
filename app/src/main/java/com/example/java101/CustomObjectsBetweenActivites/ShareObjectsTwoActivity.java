package com.example.java101.CustomObjectsBetweenActivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.java101.R;

public class ShareObjectsTwoActivity extends AppCompatActivity {

    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_objects_two);

        button = findViewById(R.id. share_objects_two_to_btn);
        textView = findViewById(R.id.share_objects_two_text_view);

        Intent intent = getIntent();
        CustomObject customObject = intent.getParcelableExtra("objectParcelable");




        textView.setText(customObject.getName() + " \n" + customObject.getAge() + "\n" + customObject.isCondition());

    }
}
