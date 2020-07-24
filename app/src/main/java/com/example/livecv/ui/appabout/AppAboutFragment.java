package com.example.livecv.ui.appabout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.livecv.R;

public class AppAboutFragment extends Fragment {

    private AppAboutViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of ( this ).get ( AppAboutViewModel.class );
        View root = inflater.inflate ( R.layout.fragment_aboutapp, container, false );
        final TextView textView = root.findViewById ( R.id.text_slideshow );
        slideshowViewModel.getText ().observe ( this, new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText ( s );
            }
        } );
        return root;
    }
}