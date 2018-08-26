package com.example.rajan.cabwala;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
{
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Welcome_fragment wf=new Welcome_fragment();
        swapFragments(wf);

        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.login:
                        Login_fragment l=new Login_fragment();
                        swapFragments(l);
                        break;
                    case R.id.registration:
                        Registration_fragment r=new Registration_fragment();
                        swapFragments(r);
                        break;
                }

                return true;
            }
        });
    }
    /*----------------------------------Swap between Fragments-------------------------------------------------------*/
    protected void swapFragments(Fragment f)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        ft.replace(R.id.frame_main,f);
        ft.commit();
    }

    /*-------------------------------------------------Action on back button pressed------------------------------------*/
    boolean doubleBackToExitPressedOnce=false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
    /*----------------------------------------------sets it back to the welcome screen----------------------------------*/
        this.doubleBackToExitPressedOnce = true;
        Welcome_fragment wf=new Welcome_fragment();
        swapFragments(wf);
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

    /*----------------------------------------Resets the time to back pressed-------------------------------------*/

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
