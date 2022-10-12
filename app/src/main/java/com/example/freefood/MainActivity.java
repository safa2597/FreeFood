package com.example.freefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText idUser;
    private EditText password;
    private Button subscribe;
    private Button login;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUser = findViewById(R.id.idUser);
        password = findViewById(R.id.password);
        subscribe = findViewById(R.id.subscribeButton);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(e->{
            if (idUser.getText().toString().equals("")){
                Toast.makeText(this,"insert id", Toast.LENGTH_LONG).show();
            }else if (password.getText().toString().equals("")) {
                Toast.makeText(this, "insert password", Toast.LENGTH_LONG).show();
            }
            intent = new Intent(MainActivity.this,tabs.class);
            startActivity(intent);
        });
        subscribe.setOnClickListener(e->{
            intent = new Intent(MainActivity.this,Inscription.class);
            startActivity(intent);
        });
    }
}