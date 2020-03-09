package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {
    private int number;
    private Random random = new Random();
    private List<Integer> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_number);
        this.generateNumber();
    }

    private void generateNumber(){
        this.number = this.random.nextInt(11);
        Log.d("generateNumber", "random number = " + this.number);
    }
    public void checkNumber(View v) {
        EditText input = findViewById(R.id.textInputLayout);
        Button btn = v.findViewById(R.id.button2);
        btn.setBackgroundColor(this.colors.get(this.random.nextInt(2)));
        String input_number = input.getText().toString();
        if(input_number.equals("")) {
            Toast.makeText(this, "Insert number pls", Toast.LENGTH_SHORT).show();
            return;
        }
        int number = Integer.parseInt(input.getText().toString());
        if(this.number < number) {
            Toast.makeText(this, "Too big", Toast.LENGTH_SHORT).show();
        } else if(this.number > number){
            Toast.makeText(this, "Too small", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You win! Try again", Toast.LENGTH_SHORT).show();
            this.generateNumber();
        }
    }

}