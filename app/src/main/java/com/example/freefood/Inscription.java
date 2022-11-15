package com.example.freefood;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.freefood.database.AppDataBase;
import com.example.freefood.entity.Type;
import com.example.freefood.entity.User;

public class Inscription extends AppCompatActivity {
    private Button subscribe;
    private Intent intent;
    private EditText nom, pwd,confirmpwd,tel,email,adresse,description;
    private AppDataBase database;
    private RadioButton resto,assoc;
    private SharedPreferences sp;
    public static final String spFile="Mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        subscribe = findViewById(R.id.subscribeButton);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        nom = findViewById(R.id.idUser);
        pwd = findViewById(R.id.Password);
        confirmpwd = findViewById(R.id.ConfPass);
        tel = findViewById(R.id.num);
        email = findViewById(R.id.mail);
        adresse = findViewById(R.id.adresse);
        description = findViewById(R.id.description);
        resto=findViewById(R.id.radioRes);
        assoc=findViewById(R.id.radioAss);

        subscribe.setOnClickListener(e->{
           /* SharedPreferences.Editor preferencesEditor = sp.edit();
            preferencesEditor.putString("name", nom.getText().toString());
            preferencesEditor.putString("password", pwd.getText().toString());
            preferencesEditor.apply();*/
            if(resto.isChecked()) {
                User user = new User(nom.getText().toString(), pwd.getText().toString(), tel.getText().toString(), email.getText().toString(), description.getText().toString(), adresse.getText().toString(), Type.RESTAURANT);
                database.userDao().insertOne(user);
            } else if (assoc.isChecked()) {
                User user = new User(nom.getText().toString(), pwd.getText().toString(), tel.getText().toString(), email.getText().toString(), description.getText().toString(), adresse.getText().toString(), Type.ASSOCIATION);
                database.userDao().insertOne(user);
            }
            intent = new Intent(Inscription.this,MainActivity.class);
            startActivity(intent);
        });
    }

}