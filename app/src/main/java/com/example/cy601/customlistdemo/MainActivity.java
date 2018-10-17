package com.example.cy601.customlistdemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
  ArrayList<Item> flagList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.LV);
        flagList.add(new Item("Afghanistan", R.drawable.flag_afghanistan));
        flagList.add(new Item("Tiger", R.drawable.tiger));
        flagList.add(new Item("Monkey", R.drawable.monkey));
        flagList.add(new Item("Elephant", R.drawable.elephant));
        flagList.add(new Item("Dog", R.drawable.dog));
        flagList.add(new Item("Cat", R.drawable.cat));

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_view_items, flagList);
        simpleList.setAdapter(myAdapter);

    }

    private class MyAdapter extends ArrayAdapter<Item> {
        public MyAdapter(MainActivity mainActivity, int list_view_items, ArrayList<Item> flagList) {
        }
    }
}
