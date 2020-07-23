package com.example.livecv.ui.hobbies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HobbiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HobbiesViewModel() {
        mText = new MutableLiveData<> ();
        mText.setValue ( "Hobilerim" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}