package com.example.squashapp_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LikedFragmentAdapter extends BaseAdapter {
    Context mContext;
    String[] thumbNailStringArray;
    int[] thumbNailIntArray;

    public LikedFragmentAdapter(Context context,String[] thumb_nail_titles,int[] thumb_nail_icons) {
        this.mContext=context;
        this.thumbNailStringArray=thumb_nail_titles;
        this.thumbNailIntArray=thumb_nail_icons;
    }

    @Override
    public int getCount() {
        return thumbNailStringArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid_View;
        LayoutInflater layoutInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null)
        {
            grid_View=new View(mContext);
            grid_View=layoutInflater.inflate(R.layout.grid_view_layout,null);
            TextView titleTextView=grid_View.findViewById(R.id.textView_GridLayout);
            ImageView thumNailImageView=grid_View.findViewById(R.id.imageView_GridLayout);
            titleTextView.setText(thumbNailStringArray[position]);
            thumNailImageView.setImageResource(thumbNailIntArray[position]);
        }
        else {
            grid_View=(View)convertView;
        }


        return grid_View;
    }
}
