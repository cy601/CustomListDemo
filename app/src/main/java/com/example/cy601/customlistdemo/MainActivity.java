package com.example.cy601.customlistdemo;


import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


//https://blog.csdn.net/qq_27489007/article/details/52245923
public class MainActivity extends AppCompatActivity {
    //用来记录上次选中的项
    private int mCurrentPosition;
    ListView listView;
    // ArrayList<Item> flagList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//listView.removeViewAt(index);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("currentChoice",mCurrentPosition);
    }

    private void init() {
        listView = (ListView) findViewById(R.id.LV);
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                android.app.FragmentManager fragmentManger = getFragmentManager();
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toShowDetails(position);
            }
        });
        MyBaseAdapter myAdapter = new MyBaseAdapter();
        listView.setAdapter(myAdapter);
    }


    //用来显示点击图标后的画面
    private void toShowDetails(int index) {
        mCurrentPosition = index;

    }


    class MyBaseAdapter extends BaseAdapter {
        private int[] images = {
                R.drawable.flag_afghanistan,
                R.drawable.flag_albania,
                R.drawable.flag_algeria,
                R.drawable.flag_andorra,
                R.drawable.flag_anguilla,
                R.drawable.flag_antigua_and_barbuda,
                R.drawable.flag_argentina,
                R.drawable.flag_angola,
                R.drawable.flag_armenia,
                R.drawable.flag_aruba,
                R.drawable.flag_australia,
                R.drawable.flag_bahamas,
                R.drawable.flag_bahrain,
                R.drawable.flag_belgium,
                R.drawable.flag_benin
        };
        private String[] country = {"Afghanistan",
                "Albania",
                "Algeria",
                "Andorra",
                "Anguilla",
                "Barbuda",
                "Argentina",
                "Angolan",
                "Armenia",
                "Aruba",
                "Australia",
                "Bahama",
                "Bahrain",
                "Belgium",
                "Benin"};

        @Override
        public int getCount() {
            return country.length;
        }

        @Override
        public Object getItem(int position) {
            return country[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainActivity.this, R.layout.list_view_items, null);
            TextView textView = (TextView) view.findViewById(R.id.countryText);
            textView.setText(country[position]);
            ImageView flagImgView = (ImageView) view.findViewById(R.id.flagImgView);
            flagImgView.setBackgroundResource(images[position]);
            return view;
        }

    }
}
