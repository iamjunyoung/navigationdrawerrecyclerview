package com.example.navigationdrawerrecyclerview.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.navigationdrawerrecyclerview.ListLiveData;
import com.example.navigationdrawerrecyclerview.Movie;
import com.example.navigationdrawerrecyclerview.R;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public ListLiveData<Movie> list;
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        
        list = new ListLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void getListFromDB() { //DB로부터 get후에 MutableLiveData list 만듬.
        Movie movie = new Movie("Star Wars The Last Jedi", R.drawable.star_war);
        list.add(movie);
        movie = new Movie("Coco",R.drawable.coco);
        list.add(movie);
        movie = new Movie("Justice League ",R.drawable.justice_league);
        list.add(movie);
        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
        list.add(movie);
        movie = new Movie("Star Wars The Last Jedi",R.drawable.star_war);
        list.add(movie);
        movie = new Movie("Coco",R.drawable.coco);
        list.add(movie);
        movie = new Movie("Justice League ",R.drawable.justice_league);
        list.add(movie);
        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
        list.add(movie);
        movie = new Movie("Star Wars The Last Jedi",R.drawable.star_war);
        list.add(movie);
        movie = new Movie("Coco",R.drawable.coco);
        list.add(movie);
        movie = new Movie("Justice League ",R.drawable.justice_league);
        list.add(movie);
        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
        list.add(movie);

        movie = new Movie("heyhey",R.drawable.star_war);
        list.add(movie);
        movie = new Movie("heyhey2",R.drawable.coco);
        list.add(movie);
        movie = new Movie("heyhey3",R.drawable.justice_league);
        list.add(movie);
        movie = new Movie("heyhey4",R.drawable.thor_ragnarok);
        list.add(movie);
        //recyclerViewAdapter.notifyDataSetChanged();
    }
}