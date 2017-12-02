package com.qalex.companyprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar spinner;
    ImageView view ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);


        Thread thread = new Thread(){
            public void run(){

                try{
                    spinner.setVisibility(View.VISIBLE);

                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();

                }finally{
                    Intent intent = new Intent(SplashActivity.this, MainScreen.class);
                    startActivity(intent);
                    finish();

                }
            }

        };
        thread.start();
    }
}
