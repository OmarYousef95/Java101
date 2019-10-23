package com.example.java101.Dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java101.R;

public class AlertDialogExampleActivity extends AppCompatActivity {

    TextView textView;
    Button openDialog, openCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_example);

        openDialog = findViewById(R.id.open_alert_dialog_example_btn);
        openCustomDialog = findViewById(R.id.open_custom_alert_dialog_example_btn);
        textView = findViewById(R.id.alert_dialog_example_text_view);

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();

            }
        });


        openCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomDialog();
            }
        });
    }


    private void openDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hello")
                .setMessage("How R U ?")
                .setPositiveButton("Good", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogExampleActivity.this, "Good", Toast.LENGTH_SHORT).show();
                        textView.setText("Good");
                    }
                })
                .setNegativeButton("Not Good", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogExampleActivity.this, "Not Good", Toast.LENGTH_SHORT).show();
                        textView.setText("Not Good");
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void openCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //here inflate the custom layout that we made in layout resources

        View view = getLayoutInflater().inflate(R.layout.custom_alert_dialog_example_layout,null);
        final EditText editText = view.findViewById(R.id.custom_alert_dialog_example_edit_view);
        Button button = view.findViewById(R.id.custom_alert_dialog_example_btn);

        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                textView.setText(text);
                Toast.makeText(AlertDialogExampleActivity.this, "Thanks", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


    }
}
