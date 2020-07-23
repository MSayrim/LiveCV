package com.example.livecv.ui.appabout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppAboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AppAboutViewModel() {
        mText = new MutableLiveData<> ();
        mText.setValue ("Uygulamanın amacı klasik CV bilgilerini görüntülemenin yanında öğrediklerimi uygularken ortaya çıkan uygulamaları test edebileceğiniz inter aktif bir uygulama." );
    }

    public LiveData<String> getText() {
        return mText;
    }
}