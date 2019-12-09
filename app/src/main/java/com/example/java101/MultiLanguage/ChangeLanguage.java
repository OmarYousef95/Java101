package com.example.java101.MultiLanguage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class ChangeLanguage {

     void change (Context context , String language){
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(language,language.equals("en")? "US" : "JO");
        configuration.setLayoutDirection(locale);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }
}
