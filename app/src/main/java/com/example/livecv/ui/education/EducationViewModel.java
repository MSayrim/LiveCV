package com.example.livecv.ui.education;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class EducationViewModel extends ViewModel {


    private MutableLiveData<String> mText;
    private MutableLiveData<String> mText2;
    private MutableLiveData<String> mText3;

    public EducationViewModel() {
        mText = new MutableLiveData<> ();
        mText2 = new MutableLiveData<> ();
        mText3 = new MutableLiveData<> ();
        mText.setValue ( "      Yedikule lisesinden fen bölümü mezunuyum." );
        mText2.setValue ( "     Makine mühendisliğinin bana uygun olmadığını fark ettikten sonra mezun olduğum Bilgisayar mühendisliği bölümü kazandığım sene ilişiğimi 2013 senesinde kestim." );
        mText3.setValue ( "     Bilgisayar mühendisliği bölümü çorlu mühendislik fakültesinde istanbula yakınlığından dolayı 2 saat kadar bir süre ile gidip gelebildiğim için çorluda kalmadan okumayı tercih ettim. Ne kadar yolda zorlansam da , ders saydıramasamda nisan 2019 yılında mezun oldum." );
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getText2() {
        return mText2;
    }
    public LiveData<String> getText3() {
        return mText3;
    }
}
