package com.example.java101.Test.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.java101.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter adapter;
    List<GridViewModel> gridViewModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.grid_view);


        GridViewModel  model1 = new GridViewModel("Omar","1",R.drawable.ic_launcher_background);
        GridViewModel  model2 = new GridViewModel("Omar","2",R.drawable.ic_launcher_background);
        GridViewModel  model3 = new GridViewModel("Omar","3",R.drawable.ic_launcher_background);
        GridViewModel  model4 = new GridViewModel("Omar","4",R.drawable.ic_launcher_background);


        gridViewModelList = new ArrayList<>();
        gridViewModelList.add(model1);
        gridViewModelList.add(model2);
        gridViewModelList.add(model3);
        gridViewModelList.add(model4);

        adapter = new GridViewAdapter(this,gridViewModelList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "Position: "+ position + "\nName: "+ gridViewModelList.get(position).getName()
                        +"\nInfo: "+ gridViewModelList.get(position).getInfo(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
