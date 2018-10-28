package com.android.team920.cscommunity.Home.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.team920.cscommunity.Home.FollowerFragment;
import com.android.team920.cscommunity.Home.PublicFragment;

public class HomeAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;
    public HomeAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;

    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                FollowerFragment tap1 = new FollowerFragment();
                return  tap1;

            case 1:
                PublicFragment tap2 = new PublicFragment();
                return tap2;

            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
