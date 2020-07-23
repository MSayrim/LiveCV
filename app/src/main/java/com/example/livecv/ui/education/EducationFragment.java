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
        educationViewModel.getText ().observe ( (LifecycleOwner) this, new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText ( s );
            }
        } );
        return root;
    }
}
