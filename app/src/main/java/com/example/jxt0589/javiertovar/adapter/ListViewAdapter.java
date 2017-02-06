package com.example.jxt0589.javiertovar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.jxt0589.javiertovar.R;

import java.util.ArrayList;

/**
 * Created by JXT0589 on 1/25/17.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    private ArrayList<String> listResult;

    public ListViewAdapter(Context ctx, ArrayList<String> newListResult)
    {
        mContext = ctx;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listResult = newListResult;
    }

    @Override
    public int getCount() {
        return listResult.size();
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

        ViewHolder holder;
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView)convertView.findViewById(R.id.list_text1);
            holder.textView2 = (TextView)convertView.findViewById(R.id.list_text2);
            holder.textView3 = (TextView)convertView.findViewById(R.id.list_text3);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(String.valueOf(position));
        holder.textView3.setText(String.valueOf(position));

        holder.textView2.setText(listResult.get(position));

        if(position%2 == 0)
        {
            holder.textView.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);
        }
        else
        {
            holder.textView.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}


class ViewHolder {
    public TextView textView;
    public TextView textView2;
    public TextView textView3;
}