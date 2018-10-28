package com.android.team920.cscommunity.Profile.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.team920.cscommunity.Profile.YourFavoriteFragment;
import com.android.team920.cscommunity.Profile.YourPostFragment;
import com.android.team920.cscommunity.Profile.YourQAFragment;


public class ProfileAdapter extends FragmentStatePagerAdapter{





        int mNoOfTabs;
        public ProfileAdapter(FragmentManager fm, int NumberOfTabs) {
            super(fm);
            this.mNoOfTabs = NumberOfTabs;

        }


        @Override
        public Fragment getItem(int position) {
            switch(position)
            {

                case 0:
                    YourPostFragment tap1 = new YourPostFragment();
                    return  tap1;

                case 1:
                    YourQAFragment tap2 = new YourQAFragment();
                    return tap2;

                case 2:
                    YourFavoriteFragment tap3 = new YourFavoriteFragment();
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

