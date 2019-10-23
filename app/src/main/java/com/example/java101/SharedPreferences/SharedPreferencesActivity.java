package com.example.java101.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java101.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    EditText editText,editTextFirstCustomObject,editTextLastCustomObject;
    Button saveBtn,loadBtn , saveBtnCustomObject, loadBtnCustomObject ;
    TextView textView, textViewCustomObject;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        editText = findViewById(R.id.shared_pref_edit_text);
        saveBtn = findViewById(R.id.shared_pref_save_btn);
        loadBtn = findViewById(R.id.shared_pref_load_btn);
        textView = findViewById(R.id.shared_pref_text_view);

        editTextFirstCustomObject = findViewById(R.id.shared_pref_custom_first_name_edit_text);
        editTextLastCustomObject  = findViewById(R.id.shared_pref_custom_last_name_edit_text);
        saveBtnCustomObject = findViewById(R.id.shared_pref_save_custom_object_btn);
        loadBtnCustomObject = findViewById(R.id.shared_pref_load_custom_object_btn);
        textViewCustomObject = findViewById(R.id.shared_pref_custom_object_text_view);


        data = new Data(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadData();

            }
        });

        saveBtnCustomObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataCustomObject();
            }
        });

        loadBtnCustomObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDataCustomObject();
            }
        });



    }



    private void saveData() {
        String inputText = editText.getText().toString().trim();
        data.setString("string",inputText);
        //textView.setText(inputText);      //to get rid of loadBtn
        Toast.makeText(this, "Data Saved :)", Toast.LENGTH_SHORT).show();


    }

    private void loadData() {
        String loadText = data.getString("string");
        textView.setText(loadText);

    }




    private void saveDataCustomObject() {

        String firstName = editTextFirstCustomObject.getText().toString().trim();
        String lastName  = editTextLastCustomObject.getText().toString().trim();
        CustomObject object = new CustomObject(firstName,lastName);

        data.setCustomObject("object",object);
        Toast.makeText(this, "Data Saved :)", Toast.LENGTH_SHORT).show();

    }

    private void loadDataCustomObject() {

        CustomObject object = data.getCustomObject("object");
        String firstName = object.getFirstName();
        String lastName = object.getLastName();

        textViewCustomObject.setText("First Name: "+ firstName + "\nLast Name: "+ lastName);
    }




    @Override
    protected void onStart() {
        super.onStart();
        String loadText = data.getString("string");
        textView.setText(loadText);

    }
}
