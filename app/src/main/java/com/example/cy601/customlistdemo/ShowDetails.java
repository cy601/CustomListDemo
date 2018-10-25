package com.example.cy601.customlistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetails extends Fragment {
    private TextView detailsText;
    private ImageView detailsImg;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_activity, container,false);
        detailsText = (TextView) view.findViewById(R.id.detailsName);
        detailsImg = (ImageView) view.findViewById(R.id.detailsImg);
        detailsText.setText(MainActivity.country[getArguments().getInt("showIndex")]);
        //detailsText.setText(MainActivity.country[2]);

        detailsImg.setBackgroundResource(MainActivity.images[getArguments().getInt("showIndex")]);
        //detailsImg.setBackgroundResource(MainActivity.images[2]);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
