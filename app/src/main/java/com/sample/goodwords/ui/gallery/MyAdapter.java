package com.sample.goodwords.ui.gallery;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sample.goodwords.R;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {
    private ArrayList<Gallery> mGalleryData = null;
    private ArrayList<Gallery> mFilteredList;
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    mFilteredList = mGalleryData;
                }else {
                    ArrayList<Gallery> filteringList = new ArrayList<>();
                    for(Gallery gallery : mGalleryData){
                        if(gallery.getInformation().toLowerCase().contains(charString.toLowerCase())){
                            filteringList.add(gallery);
                        }
                    }
                    mFilteredList = filteringList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mFilteredList = (ArrayList<Gallery>)results.values;
                notifyDataSetChanged();
            }
        };
    }
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
    private OnItemClickListener mListener = null;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
            imageView = itemView.findViewById(R.id.iv_item);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }
    public MyAdapter(ArrayList<Gallery> movieList) {
        mGalleryData = movieList;
        mFilteredList = movieList;
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(view);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(mFilteredList.get(position).getDrawable());
    }
    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

}