package com.example.laboratoire6;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MySharedPreference sharedPreference = new MySharedPreference(MainActivity.this);

        Button saveBtn = findViewById(R.id.button);
        Button changeActivity = findViewById(R.id.button2);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String value = editText.getText().toString();
                sharedPreference.save(value);
                editText.setText(value);
                if(value.equals("")){
                    Toast.makeText(MainActivity.this, "Input cannot be empty.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Your input was saved.", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MainActivity.this, "Your input was saved.", Toast.LENGTH_SHORT).show();
            }
        });

        changeActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String value = editText.getText().toString();
                editText.setText("");

                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                myIntent.putExtra("value", value);
                startActivity(myIntent);
                Toast.makeText(MainActivity.this, "View the last saved input.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}