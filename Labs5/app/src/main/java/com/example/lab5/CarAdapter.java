package com.example.lab5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Car> cars;

    public CarAdapter(Activity context){
        this.context = context;
        cars = new ArrayList<>();
    }

    public void addCar(String nameCar, int resource){
        Car car = new Car(nameCar, resource);
        cars.add(car);
        this.notifyDataSetChanged();
    }

    public int getCount(){
        return this.cars.size();
    }

    public Car getItem(int i){
        return this.cars.get(i);
    }

    public long getItemId(int i){
        return 0;
    }

    public View getView(int i, View convertView, ViewGroup viewGroup){
        View element;
        if( convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            element = layoutInflater.inflate(R.layout.list_item, null);
        } else {
            element = convertView;
        }
        TagCar car = new TagCar();
        car.name = element.findViewById(R.id.tv_name_element);
        car.image = element.findViewById(R.id.iv_image_element);
        element.setTag(car);

        TagCar tag = (TagCar) element.getTag();
        tag.name.setText(cars.get(i).name);
        tag.image.setImageResource(cars.get(i).imageResource);
        return element;
    }
}
