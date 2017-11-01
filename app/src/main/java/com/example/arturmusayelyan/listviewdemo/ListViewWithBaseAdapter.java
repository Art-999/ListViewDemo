package com.example.arturmusayelyan.listviewdemo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewWithBaseAdapter extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_base_adapter);
        listView = (ListView) findViewById(R.id.listViewForBaseAdapter);

        listView.setAdapter(new MyBaseAdapter(this));
    }
}

class SingleRow {
    String title;
    String description;
    int image;

    public SingleRow(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

class MyBaseAdapter extends BaseAdapter {
    //    String[] titles;
//    String[] descriptions;
//    int[] images;
    ArrayList<SingleRow> list;
    Context context;

    public MyBaseAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        int images[] = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7};
        for (int i = 0; i < 7; i++) {
            list.add(new SingleRow(titles[i], descriptions[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row_for_baseadapter, parent, false);
        TextView title = row.findViewById(R.id.textViewForBaseAdapter1);
        TextView description = row.findViewById(R.id.textViewForBaseAdapter2);
        ImageView image = row.findViewById(R.id.imageView);

        SingleRow temp = list.get(position);
        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);

        return row;
    }
}
