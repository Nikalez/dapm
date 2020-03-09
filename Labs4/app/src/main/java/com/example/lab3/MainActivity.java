package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String PASSWORD = "student";
    public static final String USERNAME = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        String username_input = username.getText().toString();
        String password_input = password.getText().toString();

        if(username_input.equals("") || password_input.equals("")){
            Toast.makeText(this, "Yee !", Toast.LENGTH_SHORT).show();
            return;
        }

        if(username_input.equalsIgnoreCase(USERNAME) && password_input.equalsIgnoreCase(PASSWORD)){
            Intent intent = new Intent(MainActivity.this, xo.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Username or password incorrect!", Toast.LENGTH_SHORT).show();
        }
    }
}


