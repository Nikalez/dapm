package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate function");
        Log.e("MainActivity", "onCreate function");
        Log.v("MainActivity", "onCreate function");
        Log.w("MainActivity", "onCreate function");
        Log.i("MainActivity", "onCreate function");

        Button btn1 = findViewById(R.id.buton1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBigBoyMethod(v);
            }
        });
    }

    public void push(View v){
        Toast.makeText(this, "You pushed the button from push function", Toast.LENGTH_SHORT).show();
    }

    public void myBigBoyMethod(View v) {
        Toast.makeText(MainActivity.this,"You pushed the button from on create", Toast.LENGTH_LONG).show();
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("onRestart", "onRestart function");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("onDestroy", "onDestroy function");
    }

    protected void onStart(){
        super.onStart();
        Log.d("onStart", "onStart function");
    }

    protected void onPause(){
        super.onPause();
        Log.d("onPause", "onPause function");
    }

    protected void onResume(){
        super.onResume();
        Log.d("onResume", "onResume function");
    }

    protected void onStop(){
        super.onStop();
        Log.d("onStop", "onStop function");
    }
}
