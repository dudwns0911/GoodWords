package com.example.goodwords.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodwords.EnglishGoodwordsActivity;
import com.example.goodwords.GoodwordsActivity;
import com.example.goodwords.R;
import com.example.goodwords.ui.gallery.Gallery;
import com.example.goodwords.ui.gallery.MyAdapter;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {
    public static ArrayList<Gallery> sEGoodwords = new ArrayList<>();
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image1),"미래"));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image2),"미래"));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image3),"공부"));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image4),"공부"));

        RecyclerView recyclerView = view.findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MyAdapter adapter = new MyAdapter(sEGoodwords);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), EnglishGoodwordsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);



    }
}
