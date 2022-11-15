package com.example.freefood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freefood.database.AppDataBase;
import com.example.freefood.entity.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    List<User> users;
    Context context;
    private AppDataBase database;
    public ListAdapter(Context ctx,List<User> users){
        this.context=ctx;
        this.users=users;
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
        Intent intent = new Intent(context,RestoDetail.class);
        holder.nom.setText(users.get(position).nom);
        holder.description.setText(users.get(position).description);
        holder.nom.setOnClickListener(e->{
            intent.putExtra("name",users.get(position).nom);
            intent.putExtra("description",users.get(position).description);
            intent.putExtra("adresse",users.get(position).adresse);
            intent.putExtra("email",users.get(position).email);
            intent.putExtra("contact",users.get(position).contact);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        TextView nom;
        FloatingActionButton annulcolab;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            annulcolab=itemView.findViewById(R.id.annulcolab);
            description = itemView.findViewById(R.id.description);
            nom = itemView.findViewById(R.id.restaurant);
        }
    }



}
