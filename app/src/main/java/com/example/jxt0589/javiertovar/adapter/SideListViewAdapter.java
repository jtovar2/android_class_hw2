package com.example.jxt0589.javiertovar.adapter;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by JXT0589 on 3/31/17.
 */

public class SideListViewAdapter extends BaseAdapter {

    Map<String, Class> activityNameToActivityClassMap;
    List<String> activitiesList;


    public SideListViewAdapter(List<String> newActivitiesList, Map<String, Class> newActivityNameToActivityClassMap)
    {
        activitiesList = newActivitiesList;
        activityNameToActivityClassMap = newActivityNameToActivityClassMap;
    }

    @Override
    public int getCount() {
        return activitiesList.size();
    }

    @Override
    public Object getItem(int position) {
        String activityName = activitiesList.get(position);
        return activityNameToActivityClassMap.get(activityName);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if(convertView != null)
        {
            textView = (TextView) convertView;
        }
        else
        {
            textView = new TextView(parent.getContext());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            textView.setTextColor(Color.WHITE);
        }
        textView.setText(activitiesList.get(position));
        return textView;
    }
}
