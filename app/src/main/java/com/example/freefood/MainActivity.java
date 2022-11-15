package com.example.freefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.freefood.database.AppDataBase;

public class MainActivity extends AppCompatActivity {
    private EditText idUser;
    private EditText password;
    private Button subscribe;
    private Button login;
    private Intent intent;
    private SharedPreferences sp;
    public static final String spFile="Mypref";
    private AppDataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUser = findViewById(R.id.idUser);
        password = findViewById(R.id.password);
        subscribe = findViewById(R.id.subscribeButton);
        login = findViewById(R.id.loginButton);
        sp= getSharedPreferences(spFile,MODE_PRIVATE);
        database = AppDataBase.getAppDatabase(getApplicationContext());

        login.setOnClickListener(e->{
            if (idUser.getText().toString().equals("")){
                Toast.makeText(this,"insert id", Toast.LENGTH_LONG).show();
            }else if (password.getText().toString().equals("")) {
                Toast.makeText(this, "insert password", Toast.LENGTH_LONG).show();
            }else {
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name", login.getText().toString());
                ed.putString("password", password.getText().toString());
                ed.apply();
                intent = new Intent(MainActivity.this,tabs.class);
                startActivity(intent);
            }
        });
        subscribe.setOnClickListener(e->{
            intent = new Intent(MainActivity.this,Inscription.class);
            startActivity(intent);
        });
    }
}