package com.example.arturmusayelyan.listviewdemo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewWithCustomAdapter extends AppCompatActivity {
    ListView listView;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_custom_adapter);
        listView = (ListView) findViewById(R.id.listViewForCustomArrayAdapter);

        Resources resources = getResources();
        memeTitles = resources.getStringArray(R.array.titles);
        memeDescriptions = resources.getStringArray(R.array.descriptions);


        MyCustomAdapter adapter = new MyCustomAdapter(this, memeTitles, images, memeDescriptions);
        listView.setAdapter(adapter);
    }
}

class MyCustomAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;

    public MyCustomAdapter(Context context, String[] titles, int[] images, String[] descriptions) {
        super(context, R.layout.single_row_for_customadapter, R.id.textViewForCustomAdapter1, titles);
        //  super(context, android.R.layout.simple_list_item_1,titles);  //kara senc el ashxati
        this.context = context;
        this.images = images;
        this.titleArray = titles;
        this.descriptionArray = descriptions;
    }

    //175% optimization
    class MyViewHolder {
        ImageView myImage;
        TextView myTitle;
        TextView myDescription;

        MyViewHolder(View view) {
            myImage = view.findViewById(R.id.imageViewForCustomAdapter);
            myTitle = view.findViewById(R.id.textViewForCustomAdapter1);
            myDescription = view.findViewById(R.id.textViewForCustomAdapter2);
        }
    }
    //

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_customadapter, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
            Log.d("Art_Log", "Creating a new row");
        } else {
            holder = (MyViewHolder) row.getTag();
            Log.d("Art_Log", "Recycling stuff");
        }
        holder.myImage.setImageResource(images[position]);
        holder.myTitle.setText(titleArray[position]);
        holder.myDescription.setText(descriptionArray[position]);
        return row;
    }
    //    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        //150% optimization
//        View row = convertView;
//        if (row == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(R.layout.single_row_for_customadapter, parent, false);
//        }
//        //
//
//        ImageView myImage = row.findViewById(R.id.imageViewForCustomAdapter);
//        TextView myTitle = row.findViewById(R.id.textViewForCustomAdapter1);
//        TextView myDescription = row.findViewById(R.id.textViewForCustomAdapter2);
//
//        myImage.setImageResource(imagesArray[position]);
//        myTitle.setText(titleArray[position]);
//        myDescription.setText(descriptionArray[position]);
//
//        return row;
//    }
}
