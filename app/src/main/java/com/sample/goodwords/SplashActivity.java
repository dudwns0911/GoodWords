package com.sample.goodwords;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sample.goodwords.ui.gallery.Gallery;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    public static ArrayList<Gallery> sGoodWords = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawble1), "돈"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawble2), "행복"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawble3), "행복"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable101), "사랑,행복"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable102), "사랑"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable103), "실수,성숙,속죄,고통,발전"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable104), "믿음"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable105), "논리, 좋은말,성격,자기개발,자아성찰"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable106), "자기개발,자아성찰,좋은말,미래"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable107), "고난"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable108), "인간"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable109), "사랑, 부족"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable110), "꿈, 목표, 계획, 실행"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable111), "천재,영감,땀"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable112), "일, 놀이"));
                sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable113), "성공, 사람"));
//        sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable114), "자기반성, 지혜"));
//        sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable115), "돈, 삶, 도구"));
//        sGoodWords.add(new Gallery(getDrawable(R.drawable.drawable116), "사람"));


            finish();
        }
        };
        new Timer().schedule(timerTask,3000);
    }
}
