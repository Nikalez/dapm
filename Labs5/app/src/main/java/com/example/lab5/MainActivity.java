package com.example.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

class Car {
    String name;
    int imageResource;

    public Car(){

    }

    public Car(String name, int imageResource){
        this.name = name;
        this.imageResource = imageResource;
    }
}

class TagCar {
    TextView name;
    ImageView image;

    public TagCar(){

    }

    public TagCar(TextView name, ImageView image){
        this.name = name;
        this.image = image;
    }
}

public class MainActivity extends AppCompatActivity {

    private ListView listOfCars;
    CarAdapter carAdapter;
    private EditText addNewCar;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewCar = findViewById(R.id.ed_new_car);
        addButton = findViewById(R.id.b_add_car);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carName = addNewCar.getText().toString();
                carAdapter.addCar(carName, R.drawable.car_icon);
                addNewCar.setText("");
            }
        });

        listOfCars = findViewById(R.id.lv_list_cars);
        carAdapter = new CarAdapter(this);
        listOfCars.setAdapter(carAdapter);

        carAdapter.addCar("BMW", R.drawable.car_icon);
        carAdapter.addCar("Mercedes", R.drawable.car_icon);
        carAdapter.addCar("Audi", R.drawable.car_icon);
        carAdapter.addCar("Honda", R.drawable.car_icon);
    }
}
