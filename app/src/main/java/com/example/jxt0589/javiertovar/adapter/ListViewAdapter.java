package com.example.jxt0589.javiertovar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.jxt0589.javiertovar.R;

/**
 * Created by JXT0589 on 1/25/17.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    public ListViewAdapter(Context ctx)
    {
        mContext = ctx;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 100;
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



        View rowView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.list_view_row);

        textView.setText(String.valueOf(position));
        return rowView;
    }
}
