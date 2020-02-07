package com.example.java101.Chips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    EditText editText;
    ChipGroup chipGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips);


        button = findViewById(R.id.button3);
        editText = findViewById(R.id.editText);
        chipGroup2 = findViewById(R.id.chip_group_2);


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
                addChip(editText.getText().toString().trim());
            }
        });

    }

    private void addChip(String keyword){
        final Chip chip = new Chip(this);
        int paddingDp = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 10,
                getResources().getDisplayMetrics()
        );
        chip.setPadding(paddingDp, paddingDp, paddingDp, paddingDp);
        chip.setText(keyword);
        chip.setCloseIconResource(R.drawable.ic_action_navigation_close);
        chip.setCloseIconEnabled(true);

        //to change text color
        chip.setTextColor(getColor(R.color.colorAccent));

        //to change chip background color
        chip.setChipBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorPrimaryDark)));

        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipGroup2.removeView(chip);
            }
        });
        chipGroup2.addView(chip);
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
