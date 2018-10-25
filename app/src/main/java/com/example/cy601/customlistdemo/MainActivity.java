package com.example.cy601.customlistdemo;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//https://blog.csdn.net/qq_27489007/article/details/52245923
//https://www.cnblogs.com/caobotao/p/5061627.html
public class MainActivity extends AppCompatActivity {
    //用来记录上次选中的项
    private int mCurrentPosition;
    List<Item> listItem = new ArrayList<>();
    ListView listView;

    MyBaseAdapter myAdapter;
    static int[] images = {
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
            R.drawable.flag_benin,
            R.drawable.flag_burma,
            R.drawable.flag_china,
            R.drawable.flag_cuba,
            R.drawable.flag_east_timor,
            R.drawable.flag_england,
            R.drawable.flag_eu,
            R.drawable.flag_falkland_islands,
            R.drawable.flag_hong_kong,
            R.drawable.flag_japan,
            R.drawable.flag_russia,
            R.drawable.flag_south_korea,
            R.drawable.flag_united_kingdom,
            R.drawable.flag_usa
    };
    static String[] country = {"Afghanistan",
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
            "Benin",
            "Burma",
            "China",
            "Cuba",
            "East_Timor",
            "England",
            "EU",
            "FalkLand islands",
            "Hong Kong",
            "Japan",
            "Russia",
            "South Korea",
            "United Kingdom",
            "USA"
    };

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
        outState.putInt("currentChoice", mCurrentPosition);
    }


    //初始话函数
    private void init() {
        listView = (ListView) findViewById(R.id.LV);
        //Long Click
        //长按列表项 弹出删除对话框
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // FragmentManager fragmentManger = getFragmentManager();
                // Toast.makeText(MainActivity.this,"Longclick",Toast.LENGTH_SHORT);
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                DeleteDialog deleteDialog = new DeleteDialog();
                Bundle args = new Bundle();
                mCurrentPosition = position;
                args.putInt("deleteIndex", mCurrentPosition);
                //对对话框进行传值
                deleteDialog.setArguments(args);
                deleteDialog.show(fragmentManager, "deleteDialog");
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toShowDetails(position);
                //Toast.makeText(MainActivity.this, "click1", Toast.LENGTH_SHORT);
            }
        });


        //向list数组添加数据
        for (int i = 0; i < country.length; i++) {
            listItem.add(new Item(country[i], images[i]));
        }
        //为listview添加设配器
        myAdapter = new MyBaseAdapter(this, listItem);
        listView.setAdapter(myAdapter);
    }


    //用来显示点击图标后的画面
    private void toShowDetails(int index) {

//显示点击事件
        String a = "a";
        ShowDetails showDetails = new ShowDetails();
        Bundle showArg = new Bundle();
        showArg.putInt("showIndex", index);
        showDetails.setArguments(showArg);
        Log.i(a, "showdetails");
        //默认为竖屏，重新打开一个activity 里面内嵌fragment 对其进行传值      若为横屏，即在原activity有变显示fragment
//       Intent intent =new Intent(MainActivity.this,test.class);
//       startActivity(intent);

        Intent intent = new Intent(MainActivity.this, ShowDetalisActivity.class);
        //向新开的activity传 bundle
        intent.putExtras(showArg);
        startActivity(intent);


    }


    //删除函数
    public void onUserSelect(String selectValue, int index) {
        if (selectValue.equalsIgnoreCase("yes")) {

            listItem.remove(index);
            Toast.makeText(MainActivity.this,"Delete succeed!",Toast.LENGTH_SHORT);
            //刷新列表
            myAdapter.notifyDataSetChanged();

        } else {
        }

    }


    //listview adapter
    class MyBaseAdapter extends BaseAdapter {
        List<Item> mList;
        private LayoutInflater mInflater;//布局装载器对象

        public MyBaseAdapter(Context context, List<Item> list) {
            mList = list;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mInflater.inflate(R.layout.list_view_items, null);

            TextView textView = (TextView) view.findViewById(R.id.countryText);
            ImageView flagImgView = (ImageView) view.findViewById(R.id.flagImgView);
            Item bean = mList.get(position);

            textView.setText(bean.itemCountry);
            flagImgView.setBackgroundResource(bean.itemImage);
            return view;
        }

    }
}
