package com.example.java101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.java101.BarCode.BarcodeActivity;
import com.example.java101.Chips.ChipsActivity;
import com.example.java101.ConstraintLayout.ConstraintLayoutExampleActivity;
import com.example.java101.ConstraintLayout.DefaultLayoutExampleActivity;
import com.example.java101.CustomObjectsBetweenActivites.ShareObjectsOneActivity;
import com.example.java101.CustomTextView.CustomTextViewActivity;
import com.example.java101.DateTimeFormats.DateTimeExampleActivity;
import com.example.java101.Dialogs.AlertDialogExampleActivity;
import com.example.java101.MapLocation.MapLocationExampleActivity;
import com.example.java101.Menus.MenuExampleActivity;
import com.example.java101.MultiLanguage.CustomMultiLanguageActivity;
import com.example.java101.MultiLanguage.MultiLanguageActivity;
import com.example.java101.SQLite.SQLiteGroceryExample.GroceryExampleMainActivity;
import com.example.java101.SplashScreen.SplashScreenActivity;
import com.example.java101.SplashScreen.SplashScreenMainActivity;
import com.example.java101.Threads.PostDelayedRunnableActivity;
import com.example.java101.Views.RV.RVActivity;

public class MainActivity extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1;

    Button testBtn;
    CheckBox checkBox;
    Drawable drawable;

    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = findViewById(R.id.testBtn);
        checkBox = findViewById(R.id.checkBox);


        drawable = checkBox.getButtonDrawable();

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarcodeActivity.class);
                startActivity(intent);

//                checkBox.setButtonDrawable(getDrawable(R.drawable.ic_brightness_1_black_24dp));
//                checkBox.setButtonTintList(ColorStateList.valueOf(getColor(R.color.colorPrimaryDark)));
//                checkBox.setPadding(17,0,17,0);
                //checkBox.setButtonTintList(myList);


            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setButtonDrawable(drawable);
                checkBox.setButtonTintList(ColorStateList.valueOf(getColor(R.color.coolColor)));
                checkBox.setPadding(0,0,0,0);
            }
        });









    }


}
