package com.example.java101.Views.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.java101.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    List<ListViewModel> listViewModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);


        ListViewModel  model1 = new ListViewModel("Omar","1",R.drawable.ic_launcher_background);
        ListViewModel  model2 = new ListViewModel("Omar","2",R.drawable.ic_launcher_background);
        ListViewModel  model3 = new ListViewModel("Omar","3",R.drawable.ic_launcher_background);
        ListViewModel  model4 = new ListViewModel("Omar","4",R.drawable.ic_launcher_background);

        listViewModelList = new ArrayList<>();
        listViewModelList.add(model1);
        listViewModelList.add(model2);
        listViewModelList.add(model3);
        listViewModelList.add(model4);

        adapter = new ListViewAdapter(this,listViewModelList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListViewActivity.this, "Position: "+ position + "\nName: "+ listViewModelList.get(position).getName()
                        +"\nInfo: "+ listViewModelList.get(position).getInfo(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}
