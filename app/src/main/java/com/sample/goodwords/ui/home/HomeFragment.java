package com.sample.goodwords.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sample.goodwords.GoodwordsActivity;
import com.sample.goodwords.R;
import com.sample.goodwords.ui.gallery.Gallery;
import com.sample.goodwords.ui.gallery.MyAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.sample.goodwords.ApplicationClass.positionList;
import static com.sample.goodwords.SplashActivity.sGoodWords;


public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private MyAdapter adapter;
    private ArrayList<Gallery> goodwordList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("positionList", MODE_PRIVATE);
        String json = sharedPreferences.getString("positionList", "");
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();
        positionList = gson.fromJson(json, listType);
        if (positionList != null) {
            for (int i = 0; i < positionList.size(); i++) {
                goodwordList.add(sGoodWords.get(positionList.get(i)));
            }

            RecyclerView recyclerView = view.findViewById(R.id.recycler3);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new MyAdapter(goodwordList);
            adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    Intent intent = new Intent(getContext(), GoodwordsActivity.class);
                    for (int i = 0; i < positionList.size(); i++) {
                        Log.d("test", "" + positionList.get(i));
                    }
                    intent.putExtra("position", positionList.get(position));
                    intent.putExtra("home", true);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);

        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        String stringPostionList = gson.toJson(positionList, listType);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("positionList", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("positionList", stringPostionList);
        editor.commit();
    }
}


