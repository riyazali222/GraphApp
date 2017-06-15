package com.henceforth.graphapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mCurrentPosition=5;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 1:
                 return new DemoFragment1();
            case 2:
               return new DemoFragment2();
            case 3:
                 return new DemoFragment3();
            default:
                 return new DemoFragment1();
        }
    }
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            HeightWrappingViewPager pager = (HeightWrappingViewPager) container;
            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }
    @Override
    public int getCount() {
        return 5;
    }
}