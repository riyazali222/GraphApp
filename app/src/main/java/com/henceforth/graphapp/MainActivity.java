package com.henceforth.graphapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private HeightWrappingViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //Initializing viewPager
        viewPager = (HeightWrappingViewPager) findViewById(R.id.pager);
        //Creating our pager adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(R.string.space);
        tabLayout.getTabAt(1).setText(R.string.detail);
        tabLayout.getTabAt(2).setText(R.string.comments);
        tabLayout.getTabAt(3).setText(R.string.detail);
        tabLayout.getTabAt(4).setText(R.string.space);
        viewPager = (HeightWrappingViewPager) findViewById(R.id.pager);

    }


}
