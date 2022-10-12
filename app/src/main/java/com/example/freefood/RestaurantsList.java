package com.example.freefood;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freefood.databinding.ActivityRestoDetailBinding;
import com.example.freefood.databinding.FragmentRestaurantsBinding;

import java.util.ArrayList;

public class RestaurantsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentRestaurantsBinding binding;

        binding = FragmentRestaurantsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();

        // Inflate the layout for this fragment
        int[] imageId = {R.drawable.no_waste, R.drawable.zero_waste, R.drawable.food_and_hunger};
        int[] id = {1, 2, 3};
        String[] localisation = {"Tunis", "Bizerte", "Mednine"};
        String[] nom = {"resto 1", "resto 2", "resto 3"};
        String[] description = {"aff resto1", "aff resto2", "aff resto3"};
        String[] mail = {"resto1@gmail.com", "resto2@gmail.com"};
        int[] contact = {12345678, 98765432, 54283964};
        Boolean[] livraison = {Boolean.TRUE, Boolean.FALSE, Boolean.TRUE};

        ArrayList<Restaurant> restoArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {

            Restaurant resto = new Restaurant(id[i], imageId[i], nom[i], localisation[i], mail[i], contact[i], description[i], livraison[i]);
            restoArrayList.add(resto);
        }
        ListAdapter listAdapter = new ListAdapter(RestaurantsList.this, restoArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(RestaurantsList.this, RestoDetail.class);
                i.putExtra("name", nom[position]);
                i.putExtra("description", description[position]);
                i.putExtra("contact", contact[position]);
                i.putExtra("localisation", localisation[position]);
                i.putExtra("email", mail[position]);
                i.putExtra("imageid", imageId[position]);
                startActivity(i);
            }
        });

    }
}
