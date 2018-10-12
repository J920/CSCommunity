package com.android.team920.cscommunity;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.EditText;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class Setting extends AppCompatActivity {
    private DayNightSwitch nightMode;
    private ConstraintLayout background;
    public static int intent=0;
    EditText userNameProfile;
    String userName;
    Intent i ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


intent++;
//if (userName!=null)


        nightMode= (DayNightSwitch) findViewById(R.id.switch1);
        background= findViewById(R.id.setting_background);


        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {

            nightMode.setIsNight(true);

            background.setBackgroundColor(Color.parseColor("#303030"));

        }



        nightMode.setDuration(800);



        nightMode.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {

                if(isNight){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    background.setBackgroundColor(Color.parseColor("#303030"));




                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    background.setBackgroundColor(Color.parseColor("#ffffff"));

                }

            }
        });

        userNameProfile = (EditText) findViewById(R.id.textUserName);
        if(savedInstanceState==null){
            i = this.getIntent();

            if (i == null) {


            } else {
                String userName = i.getStringExtra("Profile Name");
                userNameProfile.setText(userName);

            }
        }


    }
}
