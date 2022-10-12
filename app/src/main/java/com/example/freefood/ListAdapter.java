package com.example.freefood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Restaurant> {

    public ListAdapter(Context context, ArrayList<Restaurant> restoArrayList){

        super(context,R.layout.list_item,restoArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant resto=getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageResto);
        TextView nomResto = convertView.findViewById(R.id.restaurant);
        TextView description = convertView.findViewById(R.id.description);

        imageView.setImageResource(resto.imageId);
        nomResto.setText(resto.nom);
        description.setText(resto.description);


        return super.getView(position,convertView,parent);
    }
}
