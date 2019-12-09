package com.example.java101.CustomTextView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.java101.R;

public class CustomTextViewActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_text_view);

        textView = findViewById(R.id.textView);
        Typeface typeface  = getResources().getFont(R.font.echo);
        textView.setTypeface(typeface);

    }
}
