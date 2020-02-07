package com.example.java101.Chips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.java101.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class ChipsActivity extends AppCompatActivity {


    List<String> list = new ArrayList<>();
    List<String> newList = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips);


        button = findViewById(R.id.button3);

        list.add("Omar Basam Mahmoud Yousef");
        list.add("Esaa Loba hoba doba");
        list.add("Mosa Koba DoBa");
        list.add("Omar  Foba Loba Hoba");



        for (int i =0 ; i<list.size() ; i++ ){
            newList.add(getFirstWord(list.get(i)));
        }
        setTag(newList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("XZCCZX",""+newList.size());
                Log.d("XZCCZX",""+newList.toString());

            }
        });

    }

    private String getFirstWord(String text) {

        int index = text.indexOf(' ');

        if (index > -1) { // Check if there is more than one word.

            return text.substring(0, index).trim(); // Extract first word.

        } else {

            return text; // Text is the first word itself.
        }
    }

    private void setTag(final List<String> tagList) {
        final ChipGroup chipGroup = findViewById(R.id.chip_group);
        for (int index = 0; index < tagList.size(); index++) {
            final String tagName = tagList.get(index);
            final Chip chip = new Chip(this);
            int paddingDp = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 10,
                    getResources().getDisplayMetrics()
            );
            chip.setPadding(paddingDp, paddingDp, paddingDp, paddingDp);
            chip.setText(tagName);
            chip.setCloseIconResource(R.drawable.ic_action_navigation_close);
            chip.setCloseIconEnabled(true);
            //Added click listener on close icon to remove tag from ChipGroup
            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tagList.remove(tagName);
                    chipGroup.removeView(chip);
                    list.remove(tagName);

                }
            });

            chipGroup.addView(chip);
        }
    }
}
