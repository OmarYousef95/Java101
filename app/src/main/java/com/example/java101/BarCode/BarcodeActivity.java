package com.example.java101.BarCode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.java101.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class BarcodeActivity extends AppCompatActivity {


    Button button;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);


        button = findViewById(R.id.button4);
        textView = findViewById(R.id.textView3);
        imageView = findViewById(R.id.imageView3);

//        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.a_untitled);
//        imageView.setImageBitmap(bitmap);









        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 ){
            BarcodeDetector detector = new BarcodeDetector.Builder(getApplicationContext())
                    .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                    .build();

            if (!detector.isOperational()) {
                textView.setText("Could not set up the detector!");
                return;

            }


            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
            Frame frame = new Frame.Builder().setBitmap(image).build();
            SparseArray<Barcode> barcodes = detector.detect(frame);

            Barcode thisCode = barcodes.valueAt(0);
            textView.setText(thisCode.rawValue);
            Linkify.addLinks(textView,Linkify.WEB_URLS);

        }
    }
}

