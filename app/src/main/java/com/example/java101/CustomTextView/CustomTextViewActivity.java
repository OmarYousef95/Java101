package com.example.java101.CustomTextView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.java101.R;

public class CustomTextViewActivity extends AppCompatActivity {


    TextView textView;
    EditText editText;
    Button button;
    CustomEditText customEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_text_view);

        textView = findViewById(R.id.textView);
        Typeface typeface  = getResources().getFont(R.font.echo);
        textView.setTypeface(typeface);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        customEditText = findViewById(R.id.custom_edit_text);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                String newText = myText(text);

                String customText = customEditText.getText().toString().trim();
                Log.d("ZXC","Edit Text:\nOld text: " + text + "\nNew text: " + newText);
                Log.d("ZXC","Custom Edit Text:\nOld text: " + text + "\nNew text: " + customText);

            }
        });




    }

    public String myText(String text){
        if (text.length() > 0){
            return text .replace("٠","0")
                    .replace("١","1")
                    .replace("٢","2")
                    .replace("٣","3")
                    .replace("٤","4")
                    .replace("٥","5")
                    .replace("٦","6")
                    .replace("٧","7")
                    .replace("٨","8")
                    .replace("٩","9");
        }

        return "";
    }

    public String switchText(String text) {
        if (text.length() > 0) {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                switch ((int) chars[i]) {
                    case 1632:
                        chars[i] = '0';
                        break;
                    case 1633:
                        chars[i] = '1';
                        break;
                    case 1634:
                        chars[i] = '2';
                        break;
                    case 1635:
                        chars[i] = '3';
                        break;
                    case 1636:
                        chars[i] = '4';
                        break;
                    case 1637:
                        chars[i] = '5';
                        break;
                    case 1638:
                        chars[i] = '6';
                        break;
                    case 1639:
                        chars[i] = '7';
                        break;
                    case 1640:
                        chars[i] = '8';
                        break;
                    case 1641:
                        chars[i] = '9';
                        break;
                }
            }
            text = String.copyValueOf(chars);
            return text;
        }
        return "";
    }


}
