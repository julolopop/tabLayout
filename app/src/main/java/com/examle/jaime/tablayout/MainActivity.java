package com.examle.jaime.tablayout;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.examle.jaime.tablayout.pojo.DepthPageTransformer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

/**
 * OPCION 1 : en este ejercicio de ja visto como crear in tablayout de forma independiente
 *
 * OPCION 2 : es vincular el tablayout al viewPager con el metodo setupWithViewPage().
 *
 */
public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        mTabLayout = findViewById(R.id.tabLayout);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (String title:getResources().getStringArray(R.array.tans)){
            //mTabLayout.addTab(mTabLayout.newTab().setText(title));
            mTabLayout.addTab(mTabLayout.newTab());
        }


        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount(), new
                ArrayList<String>(asList(getResources().getStringArray(R.array.tans)))));

        mViewPager.setPageTransformer(true,new DepthPageTransformer());






       /*
        //Opcion 1


        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTabLayout.setScrollPosition(position,positionOffset,true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
*/

       //opcion 2

        mTabLayout.setupWithViewPager(mViewPager);

        setupTabIcons();

    }



    private void setupTabIcons(){
        TypedArray imagenes = getResources().obtainTypedArray(R.array.img);
        for(int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(imagenes.getDrawable(i));
        }
    }

    @Override
    public void onBackPressed() {
        if(mViewPager.getCurrentItem() == 0)
        super.onBackPressed();
        else
            mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


}
