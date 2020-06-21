package com.sample.goodwords;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.sample.goodwords.ApplicationClass.positionList;
import static com.sample.goodwords.SplashActivity.sGoodWords;


public class GoodwordsActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodwords);
        final int position = getIntent().getIntExtra("position", 0);
        final boolean home = getIntent().getBooleanExtra("home", false);

        SharedPreferences sharedPreferences = getSharedPreferences("positionList", MODE_PRIVATE);
        if(sharedPreferences != null){
            String json = sharedPreferences.getString("positionList", "");
            Type listType = new TypeToken<ArrayList<Integer>>() {
            }.getType();
            Gson gson = new GsonBuilder().create();
            positionList = gson.fromJson(json, listType);
        }

        imageView = findViewById(R.id.iv_goodwords);
        imageView.setImageDrawable(sGoodWords.get(position).getDrawable());

        btnSave = findViewById(R.id.btn_save);
        if (home) {
            btnSave.setVisibility(View.INVISIBLE);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionList.add(position);
                Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        String stringPostionList = gson.toJson(positionList, listType);

        SharedPreferences sharedPreferences = getSharedPreferences("positionList", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("positionList", stringPostionList);
        editor.commit();
    }
}

