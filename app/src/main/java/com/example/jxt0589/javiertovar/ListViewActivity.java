package com.example.jxt0589.javiertovar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jxt0589.javiertovar.adapter.ListViewAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private ListView listView;
    private ArrayList<String> listResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<>();
        createFakeResult();
        initialView();


    }


    private void createFakeResult()
    {
        listResult.add("A");
        listResult.add("B");
        listResult.add("C");
        listResult.add("D");
        listResult.add("E");
        listResult.add("F");
        listResult.add("G");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("j");
        listResult.add("m");
        listResult.add("n");
        listResult.add("l");
        listResult.add("o");
        listResult.add("p");
    }

    private void initialView()
    {
        listView = (ListView) findViewById(R.id.list_view);

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        View view = getLayoutInflater().inflate(R.layout.list_view_hearder, null);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("we have no more content");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);


        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this, "listView was clicked at position " + position, Toast.LENGTH_SHORT).show();
        Log.d("listViewActivity", String.valueOf(position) + " clicked" );
    }
}
