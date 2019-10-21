package com.example.java101.Test.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.java101.R;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<GridViewModel> modelList;

    public GridViewAdapter(Context context, List<GridViewModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_view_item,parent,false);

        TextView nameTextView = view.findViewById(R.id.text_view_name_grid_view);
        TextView infoTextView = view.findViewById(R.id.text_view_info_grid_view);
        ImageView imageView = view.findViewById(R.id.image_view_grid_view);

        GridViewModel model = modelList.get(position);
        nameTextView.setText(model.getName());
        infoTextView.setText(model.getInfo());
        imageView.setImageResource(model.getImage());

        return view;
    }
}
