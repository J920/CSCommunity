package com.android.team920.cscommunity;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.team920.cscommunity.Home.HomeFragment;
import com.android.team920.cscommunity.Profile.ProfileFragment;
import com.android.team920.cscommunity.Question.QuestionFragment;
import com.android.team920.cscommunity.Trophy.TrophyFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ConstraintLayout background;
    private FrameLayout viewPager;
    SharedPreferences settings;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                //frofile
                case R.id.navigation_profile:
                    getSupportFragmentManager()
                           .beginTransaction()
                           .replace(R.id.container1,new ProfileFragment(),"profileFragment()")
                            .commit();
                    return true;

                case R.id.navigation_trophy:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container1,new TrophyFragment(),"TrophyFragment()")
                            .commit();
                    return true;

                //
                case R.id.navigation_quistion:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container1,new QuestionFragment(),"QuestionFragment()")
                            .commit();
                    return true;

                case R.id.navigation_home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container1,new HomeFragment(),"HomeFragment()")
                            .commit();
                    return true;




//                case R.id.navigation_challing:
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .add(R.id.container1,new ChallengeFragment(),"ChallengeFragment()")
//                            .commit();
//                    return true;
            }
            return false;


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences("NightMode", 0);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setItemIconTintList(null);
        background= findViewById(R.id.container);
        viewPager= findViewById(R.id.container1);


        if(settings.getBoolean("NightOn", false)){

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }






        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            //navigation.setBackgroundColor(R.attr.cardbackground);
            navigation.setBackgroundColor(Color.parseColor("#424242"));
            navigation.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#F6F6F6")));
            background.setBackgroundColor(Color.parseColor("#303030"));
            viewPager.setBackgroundColor(Color.parseColor("#303030"));


            //navigation.setAlpha(1f);
        }else{

            navigation.setBackgroundColor(Color.parseColor("#F6F6F6"));
            navigation.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));
            background.setBackgroundColor(Color.parseColor("#ffffff"));
            viewPager.setBackgroundColor(Color.parseColor("#ffffff"));



        }


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // this line to tell the navigation to start from the profile

    }

    @Override
    protected void onStart() {
        super.onStart();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(Setting.intent==0)
        navigation.setSelectedItemId(R.id.navigation_home);



    }
}
