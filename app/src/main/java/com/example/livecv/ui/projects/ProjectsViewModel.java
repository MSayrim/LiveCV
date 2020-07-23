package com.example.livecv.ui.projects;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProjectsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProjectsViewModel() {
        mText = new MutableLiveData<> ();
        mText.setValue ( "Projelerim" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}