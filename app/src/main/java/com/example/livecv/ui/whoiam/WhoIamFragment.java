package com.example.livecv.ui.whoiam;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.livecv.R;

public class WhoIamFragment extends Fragment {

    private WhoIamViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of ( this ).get ( WhoIamViewModel.class );
        View root = inflater.inflate ( R.layout.fragment_home, container, false );
        final TextView textView1 = root.findViewById ( R.id.whoIamText );
        final ImageView imageView = root.findViewById ( R.id.cvPic );
        homeViewModel.getText2 ().observe ( getViewLifecycleOwner (), new Observer<String> () {
            @Override
            public void onChanged(String s2) {
                textView1.setText ( s2 );
            }
        } );

        homeViewModel.getImage ().observe ( getViewLifecycleOwner (), new Observer<Integer> () {
            @Override
            public void onChanged(Integer s3) {
                imageView.setImageResource(s3);
            }
        } );

        return root;
    }
}