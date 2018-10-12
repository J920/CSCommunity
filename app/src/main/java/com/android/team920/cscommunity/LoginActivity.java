package com.android.team920.cscommunity;

import android.app.ActivityManager;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
private Button doLogin;
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        doLogin=findViewById(R.id.sign_in_button);

//        doLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!(email.getText().toString().isEmpty())&&!(password.getText().toString().isEmpty())){
//                    final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
//                            "جاري تسجيل الدخول....", true);
//                    mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
//                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Sign in success, update UI with the signed-in user's information
//                                        final FirebaseUser user = mAuth.getCurrentUser();
//                                        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//
//
//                                            @Override
//                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                                if (dataSnapshot.child("buyer").child(user.getUid()).exists()) {
//
//                                                    Intent i = new Intent(getContext(),MainBuyerActivity.class);
//                                                    dialog.dismiss();
//                                                    startActivity(i);
//                                                    getActivity().finish();
//
//                                                } else {
//                                                    Intent i = new Intent(getContext(),MainSellerActivity.class);
//                                                    MainBuyerActivity.cartList.clear();
//                                                    dialog.dismiss();
//                                                    startActivity(i);
//                                                    getActivity().finish();
//                                                }
//                                            }
//
//                                            @Override
//                                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                            }
//                                        });
//
//
//                                    } else {
//                                        // If sign in fails, display a message to the user.
//                                        dialog.dismiss();
//                                        Toast.makeText(getContext(), "كلمة السر او/و الايميل غير صحيح",
//                                                Toast.LENGTH_SHORT).show();
//
//                                    }
//
//                                    // ...
//                                }
//                            });
//
//
//
//                }else {
//                    Toast.makeText(v.getContext(), "جميع الحقول مطلوبة",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }});

        doLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = ProgressDialog.show(v.getContext(), "",
                        "جاري تسجيل الدخول....", true);




                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        /* Create an Intent that will start the Menu-Activity. */
                        Intent i = new Intent(getBaseContext(),MainActivity.class);
                        dialog.dismiss();
                        startActivity(i);
                        finish();

                    }
                }, SPLASH_DISPLAY_LENGTH);






                                    // ...
                                }
                            });






    }
}
