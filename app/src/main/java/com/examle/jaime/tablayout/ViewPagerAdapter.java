package com.examle.jaime.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by usuario on 13/12/17.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {
    private int pageCount;
    private ArrayList<String> titulo;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public ViewPagerAdapter(FragmentManager fm, int pageCount,ArrayList<String> titulo) {
        super(fm);
        this.pageCount = pageCount;
        this.titulo = titulo;
    }


    @Override
    public Fragment getItem(int position) {
        CustomFragment fragment = null;
        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 1");
                fragment = CustomFragment.newInstance(bundle);
                break;

            case 1:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 2");
                fragment = CustomFragment.newInstance(bundle);
                break;

            case 2:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 3");
                fragment = CustomFragment.newInstance(bundle);
                break;

            case 3:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 4");
                fragment = CustomFragment.newInstance(bundle);
                break;

            case 4:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 5");
                fragment = CustomFragment.newInstance(bundle);
                break;
        }

        return fragment;
    }


    @Override
    public int getCount() {
        return pageCount;
    }

    //opcion 2


    @Override
    public CharSequence getPageTitle(int position) {
        return titulo.get(position);
    }
}
