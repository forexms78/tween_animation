package com.example.tween_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button tran, rota, scal, alph, aset;
    View.OnClickListener cl;
    Animation ani;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.image);


        aset = (Button)findViewById(R.id.aniset);
        tran = (Button)findViewById(R.id.translate);
        rota = (Button)findViewById(R.id.rotate);
        scal = (Button)findViewById(R.id.scale);
        alph = (Button)findViewById(R.id.alpha);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.translate:
                        //ani= new TranslateAnimation(0,400,0,400);     //픽셀형태로는 요즘에 잘 안쓰인다
                        ani = new TranslateAnimation(
                                Animation.RELATIVE_TO_SELF,0f, //시작 x축 위치
                                Animation.RELATIVE_TO_PARENT,2f, //도착 x축 위치
                                Animation.RELATIVE_TO_SELF,0f, //시작 y축 위치
                                Animation.RELATIVE_TO_PARENT,2f  //도착 y축 위치
                        );
                        ani.setDuration(5000);
                        iv.startAnimation(ani);
                        break;
                    case R.id.rotate:
                        //ani = new RotateAnimation(0,-180);앱솔루트
                        ani = new RotateAnimation(0,-360,
                                Animation.RELATIVE_TO_SELF,1f,
                                Animation.RELATIVE_TO_SELF,1f);
                        ani.setRepeatCount(3);
                        ani.setRepeatMode(Animation.REVERSE);
                        ani.setDuration(3000);
                        iv.startAnimation(ani);
                        break;
                    case R.id.scale:
                        //ani = new ScaleAnimation(0f,1f,0f,1f);
                        ani = new ScaleAnimation(1f,0f,1f,0f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f);
                        ani.setDuration(1500);
                        iv.setAnimation(ani);
                        break;
                    case R.id.alpha:
                        ani = new AlphaAnimation(0f, 1f);
                        ani.setRepeatCount(3);
                        ani.setRepeatMode(Animation.REVERSE);
                        ani.setDuration(4000);
                        iv.setAnimation(ani);
                        break;
                    case R.id.aniset:
                        Animation a1, a2, a3, a4;
                        AnimationSet as;

                        a1 = new TranslateAnimation(
                                Animation.RELATIVE_TO_SELF,0f, //시작 x축 위치
                                Animation.RELATIVE_TO_SELF,1f, //도착 x축 위치
                                Animation.RELATIVE_TO_SELF,0f, //시작 y축 위치
                                Animation.RELATIVE_TO_SELF,1f ); //도착 y축 위치
                        a1.setDuration(5000);

                        a2 = new RotateAnimation(0,360,
                                Animation.RELATIVE_TO_SELF,0.5f,
                                Animation.RELATIVE_TO_SELF,0.5f);
                        a2.setDuration(5000);

                        a3 = new ScaleAnimation(1f,0f,1f,0f,
                                Animation.RELATIVE_TO_SELF, 1f,
                                Animation.RELATIVE_TO_SELF, 0.5f);
                        a3.setDuration(5000);

                        a4 = new AlphaAnimation(0f, 1f);
                        a4.setDuration(5000);

                        //iv.startAnimation(a1);
                        //iv.startAnimation(a2);
                        //iv.startAnimation(a3);
                        //iv.startAnimation(a4);

                        as = new AnimationSet(true);
                        as.addAnimation(a1);
                        as.addAnimation(a2);
                        as.addAnimation(a3);
                        as.addAnimation(a4);
                        iv.startAnimation(as);
                        break;
                }
            }
        };
        tran.setOnClickListener(cl);
        rota.setOnClickListener(cl);
        scal.setOnClickListener(cl);
        alph.setOnClickListener(cl);
        aset.setOnClickListener(cl);
    }
}
