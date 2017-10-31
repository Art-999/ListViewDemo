package com.example.arturmusayelyan.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    ListView listView1;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.listView1);
        //adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        adapter1 = new ArrayAdapter<String>(this, R.layout.custom_textview_for_adapter, days);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView temp = (TextView) view;
//        if(position!=3){
//            Toast.makeText(this,temp.getText()+" "+position,Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(this,"Worked",Toast.LENGTH_SHORT).show();
//        }
        Toast.makeText(this, temp.getText() + " " + position, Toast.LENGTH_SHORT).show();
    }
}
