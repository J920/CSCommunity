package com.android.team920.cscommunity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TrophyAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    public TrophyAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;

    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                WeekTrophyFragment tap1 = new WeekTrophyFragment();
                return  tap1;

            case 1:
                MonthTrophyFragment tap2 = new MonthTrophyFragment();
                return tap2;

            case 2:
                YearTrophyFragment tap3 = new YearTrophyFragment();
                return tap3;

            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}


