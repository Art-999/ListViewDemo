package com.example.arturmusayelyan.listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityList extends ListActivity {
    ListView listView1;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView1 = getListView();
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        listView1.setAdapter(adapter1);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView temp = (TextView) v;
        Toast.makeText(this, temp.getText() + " " + position, Toast.LENGTH_SHORT).show();
    }
}
