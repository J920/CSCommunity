package com.android.team920.cscommunity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


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
                    AnswerFragment tap1 = new AnswerFragment();
                    return  tap1;

                case 1:
                    YourQuestionsFragment tap2 = new YourQuestionsFragment();
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

