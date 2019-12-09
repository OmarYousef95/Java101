package com.example.java101.MultiLanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.java101.R;
import com.example.java101.SharedPreferences.Data;

public class MultiLanguageActivity extends AppCompatActivity {

    Button button,arabicBtn,englishBtn;
    Data data;
    ChangeLanguage language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_language);

        data = new Data(this);
        language = new ChangeLanguage();

        button = findViewById(R.id.button);
        arabicBtn = findViewById(R.id.ar_button);
        englishBtn = findViewById(R.id.en_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MultiLanguageActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
            }
        });

        arabicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(data.getLanguage("lang").equals("ar"))) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }

                data.setLanguage("lang","ar");
                language.change(MultiLanguageActivity.this,"ar");

            }
        });

        englishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(data.getLanguage("lang").equals("en"))) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }

                data.setLanguage("lang","en");
                language.change(MultiLanguageActivity.this,"en");
            }
        });

    }
}
