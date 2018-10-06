package com.android.team920.cscommunity;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class Setting extends AppCompatActivity {
    private DayNightSwitch nightMode;
    private ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);




        nightMode= (DayNightSwitch) findViewById(R.id.switch1);
        background= findViewById(R.id.setting_background);


        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {

            background.setBackgroundColor(Color.parseColor("#303030"));
        }



        nightMode.setDuration(800);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            nightMode.setIsNight(true);
        }

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


    }
}
