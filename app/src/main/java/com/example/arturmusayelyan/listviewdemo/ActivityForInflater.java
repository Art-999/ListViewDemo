package com.example.arturmusayelyan.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityForInflater extends AppCompatActivity {
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_inflater);
        relativeLayout = (RelativeLayout) findViewById(R.id.my_relativeLayout);
        linearLayout = (LinearLayout) findViewById(R.id.my_LinerLayout);

        LayoutInflater inflater = getLayoutInflater();
        // 1-in tarberak
//        View view = inflater.inflate(R.layout.sublayout, null);
//        linearLayout.addView(view);

        //2-rd tarberak
//        View view = inflater.inflate(R.layout.sublayout, linearLayout, false);
//        linearLayout.addView(view);

        //3-rd tarberak
        // ete true-n chgrenq eli nuyn dzev kashxati vorovhetev inqe default true-e haskanum
        View view = inflater.inflate(R.layout.sublayout, linearLayout, true);

    }
}
