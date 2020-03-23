package com.example.laboratoire6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MySharedPreference mySharedPreference = new MySharedPreference(this);

        TextView textView = findViewById(R.id.text3);
        String newString;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("value");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("value");
        }
//        textView.setText(newString);

        textView.setText(mySharedPreference.getValue());
    }
}
