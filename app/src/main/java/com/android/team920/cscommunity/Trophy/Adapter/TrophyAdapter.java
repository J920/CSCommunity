package com.android.team920.cscommunity.Trophy.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.team920.cscommunity.Trophy.TrophyMonthFragment;
import com.android.team920.cscommunity.Trophy.TrophyWeekFragment;
import com.android.team920.cscommunity.Trophy.TrophyYearFragment;

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
                TrophyWeekFragment tap1 = new TrophyWeekFragment();
                return  tap1;

            case 1:
                TrophyMonthFragment tap2 = new TrophyMonthFragment();
                return tap2;

            case 2:
                TrophyYearFragment tap3 = new TrophyYearFragment();
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


