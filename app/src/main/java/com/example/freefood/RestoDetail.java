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
            String phone = intent.getStringExtra("contact");
            String email = intent.getStringExtra("email");
            String country = intent.getStringExtra("adresse");
            String description = intent.getStringExtra("description");

            binding.nomdetail.setText(name);
            binding.contactdetail.setText(phone);
            binding.emaildetail.setText(email);
            binding.adressedetail.setText(country);
            binding.descriptiondetail.setText(description);
        }
    }
}