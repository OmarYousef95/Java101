package com.example.java101.DateTimeFormats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.java101.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_example);


        DateFormat df = new SimpleDateFormat("h:mm a");
        String time = df.format(Calendar.getInstance().getTime());

        Log.v("ZXC", time);


        DateFormat df1 = new SimpleDateFormat("d/M/yyyy");
        String date = df1.format(Calendar.getInstance().getTime());

        Log.v("ZXC", date);

        // formats for date and time
        //"yyyy.MM.dd G 'at' HH:mm:ss z" ---- 2001.07.04 AD at 12:08:56 PDT
        //"hh 'o''clock' a, zzzz" ----------- 12 o'clock PM, Pacific Daylight Time
        //"EEE, d MMM yyyy HH:mm:ss Z"------- Wed, 4 Jul 2001 12:08:56 -0700
        //"yyyy-MM-dd'T'HH:mm:ss.SSSZ"------- 2001-07-04T12:08:56.235-0700
        //"yyMMddHHmmssZ"-------------------- 010704120856-0700
        //"K:mm a, z" ----------------------- 0:08 PM, PDT
        //"h:mm a" -------------------------- 12:08 PM
        //"EEE, MMM d, ''yy" ---------------- Wed, Jul 4, '01
    }
}
