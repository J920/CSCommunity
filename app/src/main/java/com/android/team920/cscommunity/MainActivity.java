package com.android.team920.cscommunity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;



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

                //
                case R.id.navigation_project:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container1,new ProjectFragment(),"ProjectFragment()")
                            .commit();
                    return true;
                case R.id.navigation_quistion:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container1,new QuestionFragment(),"QuestionFragment()")
                            .commit();
                    return true;

                case R.id.navigation_trophy:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container1,new TrophyFragment(),"TrophyFragment()")
                            .commit();
                    return true;

                case R.id.navigation_challing:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container1,new ChallengeFragment(),"ChallengeFragment()")
                            .commit();
                    return true;
            }
            return false;


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // this line to tell the navigation to start from the profile
        navigation.setSelectedItemId(R.id.navigation_profile);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
