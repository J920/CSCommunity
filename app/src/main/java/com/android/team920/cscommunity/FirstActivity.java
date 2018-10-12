package com.android.team920.cscommunity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class FirstActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(FirstActivity.this,LoginActivity.class);
                FirstActivity.this.startActivity(mainIntent);
                FirstActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

//        if(isOnline()){
//            Intent i = new Intent(FirstActivity.this, MainActivity.class);
//            startActivity(i);
//            finish();
//        }
//        else {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//            builder.setTitle("لا يوجد اتصال")
//                    .setMessage("هذا التطبيق يحتاج لإتصال دائم بالانترنت")
//                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            // continue with delete
//
//                        }
//                    })
//
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    .show();
//        }}

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }
}

