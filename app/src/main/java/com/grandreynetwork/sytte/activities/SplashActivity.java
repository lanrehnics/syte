package com.grandreynetwork.sytte.activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.grandreynetwork.sytte.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.container)
    RelativeLayout container;
    AnimationDrawable anim = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(500);
        anim.setExitFadeDuration(500);

        chill();
    }

    private void chill() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(6000);
                } catch (Exception e) {
                } finally {
                    SplashActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(SplashActivity.this, OnBoarding.class));
                            finish();
                        }
                    });
                }
            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    // Stopping animation:- stop the animation on onPause.
    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
}
