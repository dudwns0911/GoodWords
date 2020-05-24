package com.example.goodwords.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodwords.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Gallery> list = new ArrayList<>();
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawble1), "돈"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawble2), "행복"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawble3), "행복"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawable101), "사랑,행복"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawable102), "사랑"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawable103), "실수,성숙,속죄,고통,발전"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawable104), "믿음"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawable105), "논리, 좋은말,성격,자기개발,자아성찰"));
        list.add(new Gallery(getActivity().getDrawable(R.drawable.drawable106), "자기개발,자아성찰,좋은말,미래"));


        RecyclerView recyclerView = view.findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
