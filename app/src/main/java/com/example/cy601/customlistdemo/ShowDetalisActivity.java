package com.example.cy601.customlistdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
//竖屏时用于显示点击后的fragment
public class ShowDetalisActivity extends FragmentActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.show_details_activity);

            if(savedInstanceState == null){

                ShowDetails showDetails = new ShowDetails();
                //将Mainactivity 传过来的值传到 fragment
                showDetails.setArguments(getIntent().getExtras());
                FragmentManager fragmentManager = getFragmentManager();
               // fragmentManager.beginTransaction().add(1,showDetails,"1");
              //fragmentManager.beginTransaction() .add(R.id.show_details_act,showDetails, "ShowDetails" ).commit();
                getSupportFragmentManager().beginTransaction() .add(R.id.show_details_act,showDetails, "ShowDetails" ).commit();

               // getFragmentManager().beginTransaction().add(R.id.show_details_act,showDetails).commit();
            }
        }
    }

