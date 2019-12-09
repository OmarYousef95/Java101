package com.example.java101.Views.RV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.java101.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private Context context;
    private List<RvModel> modelList;

    private onItemClickListener listener;

    public RVAdapter(Context context, List<RvModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final RvModel model = modelList.get(position);
        holder.textViewName.setText(model.getName());
        holder.textViewInfo.setText(model.getInfo());
        holder.imageView.setImageResource(model.getImage());

        //to make the RV clickable use this ...
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Position: " + position + "\nName: "+ model.getName()+
//                        "\nInfoe: "+ model.getInfo(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName, textViewInfo;
        public ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewInfo = itemView.findViewById(R.id.text_view_info);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int position = getAdapterPosition();
            if (listener != null && position != RecyclerView.NO_POSITION){
                listener.onItemClick(modelList.get(position));
            }
            }
        });

        }
    }

    public interface onItemClickListener{
        void onItemClick(RvModel model);
    }


    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }




}
