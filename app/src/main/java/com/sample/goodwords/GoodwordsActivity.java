package com.sample.goodwords;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.sample.goodwords.ui.gallery.GalleryFragment.sGoodWords;

public class GoodwordsActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodwords);
        int position = getIntent().getIntExtra("position", 0);
        imageView=findViewById(R.id.iv_goodwords);
        imageView.setImageDrawable(sGoodWords.get(position).getDrawable());
    }
}
