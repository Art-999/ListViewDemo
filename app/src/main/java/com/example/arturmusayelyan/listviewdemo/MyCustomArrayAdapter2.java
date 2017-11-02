package com.example.arturmusayelyan.listviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by artur.musayelyan on 02/11/2017.
 */

public class MyCustomArrayAdapter2 extends ArrayAdapter<String> {
    Context context;
    String[] titlesArray;
    String[] descriptionsArray;
    int[] imagesArray;

    public MyCustomArrayAdapter2(Context context, String[] titles, String[] description, int[] images) {
        super(context, R.layout.single_row_for_customadapter2, R.id.textView_ForCustomAdapter1, titles);
        this.context = context;
        this.titlesArray = titles;
        this.descriptionsArray = description;
        this.imagesArray = images;
    }

    class MyViewHolder {
        TextView myTitle;
        TextView myDescription;
        ImageView myImage;

        public MyViewHolder(View view) {
            myTitle = view.findViewById(R.id.textView_ForCustomAdapter1);
            myDescription = view.findViewById(R.id.textView_ForCustomAdapter2);
            myImage = view.findViewById(R.id.imageView_ForCustomAdapter2);
        }

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;//150% optimization
        MyViewHolder viewHolder;//175% optimization
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_customadapter2, parent, false);
            //175%optimization
            viewHolder = new MyViewHolder(row);
            row.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) row.getTag();
        }
//        TextView myTitle = row.findViewById(R.id.textView_ForCustomAdapter1);
//        TextView myDescription = row.findViewById(R.id.textView_ForCustomAdapter2);
//        ImageView myImage = row.findViewById(R.id.imageView_ForCustomAdapter2);
//
//        myTitle.setText(titlesArray[position]);
//        myDescription.setText(descriptionsArray[position]);
//        myImage.setImageResource(imagesArray[position]);

        viewHolder.myTitle.setText(titlesArray[position]);
        viewHolder.myDescription.setText(descriptionsArray[position]);
        viewHolder.myImage.setImageResource(imagesArray[position]);

        return row;
    }

    @Override
    public int getCount() {
        int count = super.getCount();
        Log.d("Art_Log", count + "");
        return count;
    }
}
