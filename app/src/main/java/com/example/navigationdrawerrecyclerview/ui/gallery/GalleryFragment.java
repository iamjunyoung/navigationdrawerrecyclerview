package com.example.navigationdrawerrecyclerview.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawerrecyclerview.ListLiveData;
import com.example.navigationdrawerrecyclerview.Movie;
import com.example.navigationdrawerrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private Context mContext;
    private GalleryViewModel galleryViewModel;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mContext = container.getContext();

        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        galleryViewModel.getListFromDB();

        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));

        recyclerViewAdapter.setOnItemClickListener(new ClickListener<Movie>(){
            @Override
            public void onItemClick(Movie data) {
                Toast.makeText(mContext, data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewAdapter = new RecyclerViewAdapter(galleryViewModel.list);
        recyclerView.setAdapter(recyclerViewAdapter);

        return root;
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, ListLiveData<Movie> listItemViewModels) {
        RecyclerViewAdapter adapter;
        if (recyclerView.getAdapter() == null) {
            //adapter = new RecyclerViewAdapter();
            //recyclerView.setAdapter(adapter);
        } else {
            //adapter = (RecyclerViewAdapter)recyclerView.getAdapter();
        }
        //adapter.updateItems(listItemViewModels);
    }
}