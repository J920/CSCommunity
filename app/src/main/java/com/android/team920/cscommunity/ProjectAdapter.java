package com.android.team920.cscommunity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ProjectAdapter  extends FragmentStatePagerAdapter {





    int mNoOfTabs;
    public ProjectAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;

    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                DoneProjectFragment tap1 = new DoneProjectFragment();
                return  tap1;

            case 1:
                StillProjectFragment tap2 = new StillProjectFragment();
                return tap2;
            case 2:
                GroupProjectFragment tap3 = new GroupProjectFragment();
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

