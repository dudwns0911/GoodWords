package com.example.goodwords;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.goodwords.ui.gallery.Gallery;

import java.io.Serializable;

import static com.example.goodwords.ui.gallery.GalleryFragment.sGoodWords;

public class GoodwordsActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodwords);
        int position = getIntent().getIntExtra("position", 0);
        imageView.findViewById(R.id.iv_goodwords);
        imageView.setImageDrawable(sGoodWords.get(position).getDrawable());
    }
}
