package com.example.arturmusayelyan.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewWithImage extends AppCompatActivity {
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_image);
        listView=(ListView)findViewById(R.id.listView2);
        adapter=new ArrayAdapter<String>(this,R.layout.single_row,R.id.textView,days);
        listView.setAdapter(adapter);
    }
}
