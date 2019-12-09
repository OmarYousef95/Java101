package com.example.java101.Views.RV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.java101.R;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVAdapter adapter;

    List<RvModel> rvModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);



        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RvModel model1 = new RvModel("Omar","1",R.drawable.ic_launcher_background);
        RvModel model2 = new RvModel("Omar","2",R.drawable.ic_launcher_background);
        RvModel model3 = new RvModel("Omar","3",R.drawable.ic_launcher_background);
        RvModel model4 = new RvModel("Omar","4",R.drawable.ic_launcher_background);

        rvModelList = new ArrayList<>();
        rvModelList.add(model1);
        rvModelList.add(model2);
        rvModelList.add(model3);
        rvModelList.add(model4);


        adapter = new RVAdapter(this,rvModelList);
        recyclerView.setAdapter(adapter);



        adapter.setOnItemClickListener(new RVAdapter.onItemClickListener() {
            @Override
            public void onItemClick(RvModel model) {
                Toast.makeText(RVActivity.this, "Number is " + model.info, Toast.LENGTH_SHORT).show();
            }
        });




    }
}
