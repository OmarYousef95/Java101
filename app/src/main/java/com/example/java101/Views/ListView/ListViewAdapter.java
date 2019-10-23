package com.example.java101.Views.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.java101.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListViewModel> {

    private Context context;
    private List<ListViewModel> modelList;

    public ListViewAdapter(@NonNull Context context, @NonNull List<ListViewModel> modelList) {
        super(context, 0, modelList);
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_view_item,null,false);

        TextView nameTextView = view.findViewById(R.id.text_view_name_list_view);
        TextView infoTextView = view.findViewById(R.id.text_view_info_list_view);
        ImageView imageView = view.findViewById(R.id.image_view_list_view);

        ListViewModel model = modelList.get(position);
        nameTextView.setText(model.getName());
        infoTextView.setText(model.getInfo());
        imageView.setImageResource(model.getImage());


        return view;
    }
}
