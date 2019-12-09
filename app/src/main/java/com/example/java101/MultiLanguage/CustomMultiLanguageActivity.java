package com.example.java101.MultiLanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.java101.R;
import com.example.java101.SharedPreferences.Data;

public class CustomMultiLanguageActivity extends AppCompatActivity {

    Data data;
    ChangeLanguage changeLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_multi_language);

        data = new Data(this);
        changeLanguage = new ChangeLanguage();

//        String changeLanguage = getLanguage(this).equals("en") ? "ar" : "en";
//        data.setString("lang",changeLanguage);
//        changeLanguage(this,changeLanguage);
//        Intent intent = new Intent(this,MultiLanguageActivity.class);
//        startActivity(intent);
//        finish();

        String language = data.getLanguage("lang");
        //changeLanguage(this,changeLanguage);
        this.changeLanguage.change(this,language);
        Intent intent = new Intent(this,MultiLanguageActivity.class);
        startActivity(intent);
        finish();

    }

/*
    public static void changeLanguage (Context context , String changeLanguage){
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(changeLanguage,changeLanguage.equals("en")? "US" : "JO");
        configuration.setLayoutDirection(locale);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }

 */

    public static String getLanguage (Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        }else {
            return  context.getResources().getConfiguration().locale.getLanguage();
        }
    }
}
