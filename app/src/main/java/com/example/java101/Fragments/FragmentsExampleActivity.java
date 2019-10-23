package com.example.java101.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.java101.R;

public class FragmentsExampleActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_example);

        button = findViewById(R.id.fragment_example_test_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTheFragment("Example Text" , 123);
                button.setVisibility(View.INVISIBLE);
            }
        });

            //Original code without button.
//        ExampleFragment fragment = ExampleFragment.newInstance("Example Text ",123);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_example_container,fragment).commit();



    }

    private void startTheFragment(String text, int number) {

        ExampleFragment fragment = ExampleFragment.newInstance(text,number);


        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_example_container,fragment).commit();


        //to close the fragment only when back button pressed >>> use addToBackStack.
        getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.fragment_example_container,fragment).commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        button.setVisibility(View.VISIBLE);
    }
}
