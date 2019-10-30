package com.example.java101.CustomObjectsBetweenActivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.java101.R;
import com.google.gson.Gson;

public class ShareObjectsOneActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_objects_one);


        button = findViewById(R.id.share_objects_one_to_btn);
        textView = findViewById(R.id.share_objects_one_text_view);

        final CustomObject customObject = new CustomObject("Omar",24,false);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ShareObjectsOneActivity.this,ShareObjectsTwoActivity.class);
                intent.putExtra("objectParcelable",customObject);
                startActivity(intent);

            }
        });

    }
}
