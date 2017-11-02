package com.unmsm.alejandriamaster;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;

public class LoginAlejandria extends AppCompatActivity {
    private RelativeLayout animation;
    private Animation uptodown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alejandria);

        animation = (RelativeLayout) findViewById(R.id.layout_frame);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        animation.setAnimation(uptodown);


    }
}
