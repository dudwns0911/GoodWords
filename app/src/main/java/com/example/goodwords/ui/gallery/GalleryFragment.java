package com.example.goodwords.ui.gallery;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public class GalleryFragment extends Fragment implements TextWatcher {
    public static ArrayList<Gallery> sGoodWords = new ArrayList<>();
    private EditText editText;
    private MyAdapter adapter;
    private GalleryViewModel galleryViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
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
        //  sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable107), "고난"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable108), "인간"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable109), "사랑, 부족"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable110), "꿈, 목표, 계획, 실행"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable111), "천재,영감,땀"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable112), "일, 놀이"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable113), "성공, 사람"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable114), "자기반성, 지혜"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable115), "돈, 삶, 도구"));
//        sGoodWords.add(new Gallery(getActivity().getDrawable(R.drawable.drawable116), "사람"));
        RecyclerView recyclerView = view.findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        editText = view.findViewById(R.id.et_home);
//        editText.addTextChangedListener(this);
       adapter = new MyAdapter(sGoodWords);
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
