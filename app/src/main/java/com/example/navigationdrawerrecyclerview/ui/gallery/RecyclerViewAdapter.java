package com.example.navigationdrawerrecyclerview.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawerrecyclerview.ListLiveData;
import com.example.navigationdrawerrecyclerview.Movie;
import com.example.navigationdrawerrecyclerview.R;
import com.example.navigationdrawerrecyclerview.databinding.RecyclerviewAdapterLayoutBinding;

import java.util.List;

//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
public class RecyclerViewAdapter extends RecyclerView.Adapter<BindingViewHolder<RecyclerviewAdapterLayoutBinding>> {

    private ListLiveData<Movie> list;
    private ClickListener<Movie> clickListener;

    public RecyclerViewAdapter(ListLiveData<Movie> movieList) {
        this.list = movieList;
    }

    @Override
    public BindingViewHolder<RecyclerviewAdapterLayoutBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BindingViewHolder<>(inflater.inflate(R.layout.recyclerview_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder<RecyclerviewAdapterLayoutBinding> holder, int position) {
        holder.binding().setViewModel(list.get(position));
    }

    /*
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {

        final Movie movie = list.get(position);

        holder.title.setText(movie.getTitle());
        holder.image.setBackgroundResource(movie.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(movie);
            }
        });
    }
    */

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(ClickListener<Movie> movieClickListener) {
        this.clickListener = movieClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.carView);
        }
    }
}

interface ClickListener<T> {
    void onItemClick(T data);
}
