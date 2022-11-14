package com.example.freefood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freefood.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    ArrayList<Integer> u1;
    ArrayList<String> u2,u3;
    Context context;
    public ListAdapter(Context ctx,ArrayList<Integer> u1, ArrayList<String> u2,ArrayList<String> u3){
        this.context=ctx;
        this.u1=u1;
        this.u2=u2;
        this.u3=u3;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {

        holder.image.setImageResource(u1.get(position));
        holder.nom.setText(u2.get(position));
        holder.description.setText(u3.get(position));
    }

    @Override
    public int getItemCount() {
        return u1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView description;
        TextView nom;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
            nom = itemView.findViewById(R.id.name);
        }
    }



}
