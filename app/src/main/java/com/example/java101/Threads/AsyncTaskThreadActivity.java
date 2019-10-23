package com.example.java101.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java101.R;

import java.util.ArrayList;

public class AsyncTaskThreadActivity extends AppCompatActivity {

    ProgressBar progressBarHorizontal , progressBarDefault;
    Button startBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_thread);


        progressBarHorizontal = findViewById(R.id.async_task_progress_bar_horizontal);
        startBtn = findViewById(R.id.async_task_start_btn);
        progressBarDefault = findViewById(R.id.async_task_progress_bar_default);
        textView = findViewById(R.id.async_task_text_view);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncTask();
            }
        });

    }

    private void startAsyncTask() {

          //AsyncTask with vertical progressbar
//        ExampleAsyncTask task = new ExampleAsyncTask();
//        task.execute(10);

        //AsyncTask with default progressbar
        ExampleAsyncTask2 task2 = new ExampleAsyncTask2();
        task2.execute();

    }


    //the arguments in the AsyncTask
    // <what you want to send (Parameters) , PROGRESS, Result you want to retrieve on onPostExecute method.>
    private class ExampleAsyncTask extends AsyncTask<Integer,Integer,String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBarHorizontal.setVisibility(View.VISIBLE);

        }


        @Override
        protected String doInBackground(Integer... integers) {

            for (int i=0 ; i<integers[0];i++){

                //just for the progress bar , not important
                publishProgress((i * 100) / integers[0]);
                Log.v("ZXC","time: " + i);

                //the work we want to do in the background
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

            return "Finished!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBarHorizontal.setProgress(values[0]);
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(AsyncTaskThreadActivity.this, "Result: "  + s, Toast.LENGTH_SHORT).show();
            progressBarHorizontal.setProgress(0);
            progressBarHorizontal.setVisibility(View.INVISIBLE);
        }


    }

    private class ExampleAsyncTask2 extends AsyncTask<Void, Void, ArrayList<Integer>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBarDefault.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Integer> doInBackground(Void... voids) {

            ArrayList<Integer> arrayList = new ArrayList<>();


            //sleep for 3 seconds
            for (int i = 0 ; i <3 ; i++){

                Log.v("ZXC","StartThread: "+ i);
                arrayList.add(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return arrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<Integer> s) {
            super.onPostExecute(s);
            progressBarDefault.setVisibility(View.INVISIBLE);
            Toast.makeText(AsyncTaskThreadActivity.this, "Time is: " + s.size(), Toast.LENGTH_SHORT).show();
            textView.setText(s.get(0) + "\n" + s.get(1) + "\n" + s.get(2));

        }

    }

}
