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
        Hobbies hobbie1 = new Hobbies ("e-sport","dota 2 / csgo / pubg / hearthstone" , R.drawable.profilpic);
        Hobbies hobbie2 = new Hobbies ("e-sport","dota 2 / csgo / pubg / hearthstone" , R.drawable.profilpic);
        Hobbies hobbie3 = new Hobbies ("e-sport","dota 2 / csgo / pubg / hearthstone" , R.drawable.profilpic);
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