package com.example.livecv.ui.hobbies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livecv.R;
import com.example.livecv.ui.importantStuff.Hobbies;
import com.example.livecv.ui.importantStuff.HobbiesCustomAdapter;


import java.util.ArrayList;

public class HobbiesFragment extends Fragment implements HobbiesCustomAdapter.customClickListener{

    private HobbiesViewModel hobbiesViewModel;
    private ArrayList<Hobbies> hobbieList;
    private RecyclerView myRecycler;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        Hobbies hobbie1 = new Hobbies ("e-spor","      E-sporlar artık neredeyse alışık olduğumuz spor türleriyle yanyana anılır konuma geldiler. Birçok spor kulübü bünyelerinde bu sporlarda ki iyi oyuncular toplamaya başladı bile. Bir izleyici olarakta başta Dota 2,Hearthstone,Cs:go ve pubg olmak üzere birçok e-spor katagorisinde ki oyun ve oyuncuların kullandığı platform item alışverişi yaptığı sistemler hakkında bilgi sahibiyim. " , R.drawable.esports);
        Hobbies hobbie2 = new Hobbies ("Cryptocurrency","       Cryptocurrencyler geleceğin kaçınılmaz sonu olarak sürekli gündeme gelmekte. Benim sanal paralarla olan ilişkim üniversite zamanlarında kısmı mining ve ticareti üzerine. Blockchain teknolojisine ayrıcada bir merak sahibiyim yapay zeka ve blockchain üzerine ileride kodlama kısmında çalışma planlarım mevcut." , R.drawable.crypto);
        Hobbies hobbie3 = new Hobbies ("3 boyutlu baskı","      3D teknolijisine üniversitemin son yıllarında tanıştım. Şahsıma ait ilk yazıcım üniversitemin son yıllarında edindim. 3D teknolojisi ile şuan da ilgilenmekteyim genel olarak baskı hizmeti ve teknik destek veriyorum facebook gruplarında." , R.drawable.dddprint);
        hobbieList = new ArrayList<> (  );
        hobbieList.add ( hobbie1 );
        hobbieList.add ( hobbie2 );
        hobbieList.add ( hobbie3 );

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        hobbiesViewModel =
                ViewModelProviders.of ( this ).get ( HobbiesViewModel.class );
        final View root = inflater.inflate ( R.layout.fragment_hobbies, container, false );
        final TextView textView = root.findViewById ( R.id.text_tools );
        hobbiesViewModel.getText ().observe ( getViewLifecycleOwner(), new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText ( s );
            }
        } );


        myRecycler = (RecyclerView) root.findViewById ( R.id.hobbiesListView );
        HobbiesCustomAdapter hobbiesCustomAdapter = new HobbiesCustomAdapter ( getContext (),hobbieList,this );
        myRecycler.setLayoutManager ( new LinearLayoutManager ( getActivity () ) );
        myRecycler.setAdapter ( hobbiesCustomAdapter );
        return root;
    }



    public void onClickListener(int position) {
        Toast.makeText(getActivity(), "This is my Toast message! "+position,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), HobbiesDetails.class);
        intent.putExtra ("selected project",hobbieList.get ( position ));
        startActivity(intent);
    }

}