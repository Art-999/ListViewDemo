package com.example.arturmusayelyan.listviewdemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewWithCustomadapter2 extends AppCompatActivity {
    ListView listView;
    String[] titles;
    String[] descriptions;
    int[] images = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_customadapter2);
        listView = (ListView) findViewById(R.id.listView_ForCustomAdapter2);

        Resources resources = getResources();
        titles = resources.getStringArray(R.array.titles);
        descriptions = resources.getStringArray(R.array.descriptions);

        MyCustomArrayAdapter2 adapter=new MyCustomArrayAdapter2(this,titles,descriptions,images);
        listView.setAdapter(adapter);
    }
}
