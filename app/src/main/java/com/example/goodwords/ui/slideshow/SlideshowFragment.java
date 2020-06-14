package com.example.goodwords.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment implements TextWatcher {
    public static ArrayList<Gallery> sEGoodwords = new ArrayList<>();
    private SlideshowViewModel slideshowViewModel;
    private EditText editText;
    private MyAdapter adapter;

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
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image1), "미래", "미래가 그대를 불안하게 하지 말라. 해야만 한다면 맞게 될 것이니, 오늘 현재로부터 그대를 지키는 이성이라는 동일한 무기가 함께 할 것이다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image2), "미래", "우리는 항상 젊음을 위해 미래를 개발할 수는 없지만, 미래를 위해 우리의 젊음을 개발할 수는 있다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image3), "공부", "공부벌레들에게 잘 해주십시오. 나중에 그 사람 밑에서 일하게 될 수도 있습니다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image4), "공부", "교육이란 화를 내거나 자신감을 잃지 않고도 거의 모든 것에 귀 기울일 수 있는 능력이다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", "사람들이 대게 기회를 놓치는 이유는 기회가 작업복 차림의 일꾼 같아 일로 보이기 때문이다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image6), "목표", "뜻을 세운다는 것은 목표를 선택하고, 그 목표에 도달할 행동과정을 결정하고, 그 목표에 도달할 때까지 결정한 행동을 계속하는 것이다. 중요한 것은 행동이다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image7), "우정", "우정을 끝낼 수 있다면 그 우정은 실제로 존재하지 않은 것이다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image8), "기회", "같은 것을 좋아하고 싫어하는 것이 바로 진정한 우정이다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image9), "독서", "책들은… 바닷가재 껍질과도 같아서 우리는 자신을 책으로 감싼 후 뚫고 자라나 초기 성장단계들의 증거로 뒤에 남긴다."));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));
        sEGoodwords.add(new Gallery(getActivity().getDrawable(R.drawable.image5), "기회", ""));


        RecyclerView recyclerView = view.findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        editText = view.findViewById(R.id.et_english);
        editText.addTextChangedListener(this);

        adapter = new MyAdapter(sEGoodwords);
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


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        adapter.getFilter().filter(s);
    }
    @Override
    public void afterTextChanged(Editable s) {

    }
}
