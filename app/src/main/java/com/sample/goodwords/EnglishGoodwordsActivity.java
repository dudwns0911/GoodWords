package com.sample.goodwords;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.sample.goodwords.ui.slideshow.SlideshowFragment.sEGoodwords;

public class EnglishGoodwordsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodwords_english);
        int position = getIntent().getIntExtra("position", 0);
        imageView=findViewById(R.id.iv_goodwords);
        imageView.setImageDrawable(sEGoodwords.get(position).getDrawable());
        textView = findViewById(R.id.tv_goodwords_english);
        textView.setText(sEGoodwords.get(position).getTranslate());
    }
}
