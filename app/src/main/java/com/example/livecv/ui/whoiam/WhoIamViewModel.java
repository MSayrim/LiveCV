package com.example.livecv.ui.whoiam;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livecv.R;

public class WhoIamViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> cvText;
    private MutableLiveData<Integer> cvImage;

    public WhoIamViewModel() {
        mText = new MutableLiveData<> ();
        mText.setValue ( "Ben kimim?");
        cvText = new MutableLiveData<> ();
        cvText.setValue ( " İsmim Murat SAYRIM 2019 yılın da hayalim olan Bilgisayar mühendisliği bölümünden TEKİRDAĞ NAMIK KEMAL ÜNİVERSİTESİ' den mezun oldum.\n    Eğitimim esnasında C ve C#/JAVA gördüm." +
                "Java alanında ANDROID programlama alanında kendimi geliştirmekteyim.\n"+"     Android programlamaya ilgim bireysel veya grup olarak 9-5 bir iş haricinde uygulama geliştirip android ve ios uygulamalar üzerinden ilerlemek ve mobil yazılım haricinde bir mesleki daldan ilerlesem de bu konu da çalışmalarıma devam edeceğim.\n"+
                "İş aradığım pozisyonlar iş zekası,android yazılımcı, ios yazılımcı başta olmak üzere İT sektöründe uygun bir kariyer yapabileceğim pozisyonlarla ilgilenmekteyim.");
        cvImage = new MutableLiveData<Integer> ( );
        cvImage.setValue ( R.drawable.profilpic );

    }
    public LiveData<String> getText1() {
        return mText;
    }
    public LiveData<String> getText2() {
        return cvText;
    }
    public LiveData<Integer> getImage() {
        return cvImage;
    }

}