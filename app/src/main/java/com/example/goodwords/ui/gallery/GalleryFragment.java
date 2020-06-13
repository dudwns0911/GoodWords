package com.example.goodwords.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodwords.GoodwordsActivity;
import com.example.goodwords.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    public static ArrayList<Gallery> sGoodWords = new ArrayList<>();

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
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawble1), "돈"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawble2), "행복"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawble3), "행복"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable101), "사랑,행복"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable102), "사랑"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable103), "실수,성숙,속죄,고통,발전"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable104), "믿음"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable105), "논리, 좋은말,성격,자기개발,자아성찰"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable106), "자기개발,자아성찰,좋은말,미래"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable107), "고난"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable108), "인간"));
        //108부터 S6용량 부족 사진 모두 다 픽셀 400
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable109), "사랑, 부족"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable110), "꿈, 목표, 계획, 실행"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable111), "천재,영감,땀"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable112), "일, 놀이"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable113), "성공, 사람"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable114), "자기반성, 지혜"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable115), "돈, 삶, 도구"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable116), "사람"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable117), "천재"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable118), "규칙"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable119), "기회"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable120), "인간"));
        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable121), "계획"));








        RecyclerView recyclerView = view.findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MyAdapter adapter = new MyAdapter(sGoodWords);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), GoodwordsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
