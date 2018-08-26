package com.example.rajan.cabwala;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity
{
    ImageView iv;
    Animation a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        iv=(ImageView)findViewById(R.id.location_marker);

        a= AnimationUtils.loadAnimation(getBaseContext(),R.anim.bounce);

        iv.startAnimation(a);

        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
//                iv.setVisibility(View.GONE);
                Thread timer = new Thread(){
                    public void run(){
                        try{
                            sleep(4000);
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        } finally {
                            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };
                timer.start();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
