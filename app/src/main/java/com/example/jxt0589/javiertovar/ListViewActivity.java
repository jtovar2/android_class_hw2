package com.example.jxt0589.javiertovar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jxt0589.javiertovar.adapter.ListViewAdapter;
import com.example.jxt0589.javiertovar.adapter.ViewPagerAdapter;
import com.example.jxt0589.javiertovar.fragment.ContentFragment;
import com.example.jxt0589.javiertovar.fragment.HistoryFragment;
import com.example.jxt0589.javiertovar.fragment.ImageFragment;
import com.example.jxt0589.javiertovar.fragment.LoginFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private ListView listView;
    private ArrayList<String> listResult;

    ViewPager viewPager;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    TabLayout tabLayout;

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
        view.setMinimumHeight(600);
        FrameLayout listViewHeader = (FrameLayout) view.findViewById(R.id.list_view_header);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager2);

        fragmentList.add(ImageFragment.newInstance("https://pbs.twimg.com/profile_images/664169149002874880/z1fmxo00_400x400.jpg", 0));
        fragmentList.add(ImageFragment.newInstance("https://pbs.twimg.com/profile_images/615925321691492352/c1PGXZjL.png", 1));
        fragmentList.add(ImageFragment.newInstance("https://pbs.twimg.com/profile_images/616772191900663808/cOzd5P8S.jpg", 2));
        fragmentList.add(ImageFragment.newInstance("https://cdn.pixabay.com/photo/2014/03/25/16/35/penguin-297473_1280.png", 3));
        fragmentList.add(ImageFragment.newInstance("https://pbs.twimg.com/profile_images/664169149002874880/z1fmxo00_400x400.jpg", 4));
        fragmentList.add(ImageFragment.newInstance("https://pbs.twimg.com/profile_images/615925321691492352/c1PGXZjL.png", 5));
        fragmentList.add(ImageFragment.newInstance("https://pbs.twimg.com/profile_images/616772191900663808/cOzd5P8S.jpg", 6));
        fragmentList.add(ImageFragment.newInstance("https://cdn.pixabay.com/photo/2014/03/25/16/35/penguin-297473_1280.png", 7));

        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getSupportFragmentManager());

        adapter.setContent(fragmentList);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout2);
        tabLayout.setupWithViewPager(viewPager);



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

    @Override
    public void onBackPressed() {
            Intent intent = new Intent();
            intent.putExtra("message", "ListViewPager");
            setResult(RESULT_OK, intent);
            super.onBackPressed();
    }
}
