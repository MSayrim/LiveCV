package com.example.livecv.ui.education;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.livecv.R;

public class EducationFragment extends Fragment {

    private EducationViewModel educationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        educationViewModel =
                ViewModelProviders.of ( this ).get ( EducationViewModel.class );
        View root = inflater.inflate ( R.layout.fragment_education, container, false );
        final TextView textView = root.findViewById ( R.id.text_share );
        final TextView textView2 = root.findViewById ( R.id.text_share2 );
        final TextView textView3 = root.findViewById ( R.id.text_share3 );
        educationViewModel.getText ().observe ( (LifecycleOwner) this, new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText ( s );
            }
        } );
        educationViewModel.getText2 ().observe ( (LifecycleOwner) this, new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView2.setText ( s );
            }
        } );
        educationViewModel.getText3 ().observe ( (LifecycleOwner) this, new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView3.setText ( s );
            }
        } );
        return root;
    }
}
