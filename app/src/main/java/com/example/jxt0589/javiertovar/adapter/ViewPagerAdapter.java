package com.example.jxt0589.javiertovar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by JXT0589 on 2/1/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public void setContent(ArrayList<Fragment> newList)
    {
        fragmentList = newList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        return super.instantiateItem(container, position);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object obj)
    {

        super.destroyItem(container, position, obj);
        return;
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        return fragmentList.get(position).getClass().getName();
    }




}
