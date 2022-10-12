package com.example.freefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.freefood.databinding.ActivityRestoDetailBinding;

public class RestoDetail extends AppCompatActivity {
    ActivityRestoDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_detail);
        binding = ActivityRestoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {

            String name = intent.getStringExtra("name");
            int phone = intent.getIntExtra("contact", 12345678);
            String email = intent.getStringExtra("email");
            String country = intent.getStringExtra("location");
            String description = intent.getStringExtra("description");
            int imageid = intent.getIntExtra("imageid", R.drawable.no_waste);

            binding.name.setText(name);
            binding.phone.setText(phone);
            binding.email.setText(email);
            binding.location.setText(country);
            binding.description.setText(description);
            binding.image.setImageResource(imageid);
        }
    }
}