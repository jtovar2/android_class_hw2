package com.example.jxt0589.javiertovar;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jxt0589.javiertovar.adapter.ViewPagerAdapter;
import com.example.jxt0589.javiertovar.bean.Book;
import com.example.jxt0589.javiertovar.fragment.ContentFragment;
import com.example.jxt0589.javiertovar.fragment.HistoryFragment;
import com.example.jxt0589.javiertovar.fragment.LoginFragment;
import com.example.jxt0589.javiertovar.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
 /*       Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Book book = (Book) bundle.getSerializable("book");

        String message = intent.getStringExtra("key");
        UtilLog.logD("ViewPagerActivity", "value is " + message);
        UtilLog.logD("ViewPagerActivity", "author " + book.getAuthor() + " name " + book.getName());*/
        initital();
    }

    private void initital()
    {
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getSupportFragmentManager());

        adapter.setContent(fragmentList);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
            Intent intent = new Intent();
            intent.putExtra("message", "ViewPager");
            setResult(RESULT_OK, intent);
            super.onBackPressed();

    }
}
