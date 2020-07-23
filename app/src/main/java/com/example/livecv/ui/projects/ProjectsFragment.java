package com.example.livecv.ui.projects;

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
import com.example.livecv.ui.Mydoviz.DovizActivity;
import com.example.livecv.ui.importantStuff.ProjectCustomAdapter;
import com.example.livecv.ui.importantStuff.Project;

import java.util.ArrayList;

public class ProjectsFragment extends Fragment implements ProjectCustomAdapter.customClickListener {

    private ProjectsViewModel projectsViewModel;
    private RecyclerView myRecycler;
    private ArrayList<Project> projectList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        Project project1 = new Project ( "Doviz Uygulaması","05.05.2020~07.05.2020", R.drawable.ic_menu_gallery ,getString ( R.string.doviz_proje ), DovizActivity.class );
        Project project2 = new Project ( " dasd","05.05.2020~07.05.2020",R.drawable.ic_menu_gallery,getString ( R.string.doviz_proje ),DovizActivity.class );
        Project project3 = new Project ( " döv2323iz","05.05.2020~07.05.2020",R.drawable.ic_menu_gallery,getString ( R.string.doviz_proje ),DovizActivity.class );
        projectList = new ArrayList<> (  );
        projectList.add ( project1 );
        projectList.add ( project2 );
        projectList.add ( project3 );
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        projectsViewModel =
                ViewModelProviders.of ( this ).get ( ProjectsViewModel.class );
        final View root = inflater.inflate ( R.layout.fragment_gallery, container, false );
        final TextView textView = root.findViewById ( R.id.text_gallery );
        projectsViewModel.getText ().observe ( getViewLifecycleOwner(), new Observer<String> () {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText ( s );
            }
        } );

        myRecycler = (RecyclerView) root.findViewById ( R.id.projectListView );
        ProjectCustomAdapter projectCustomAdapter = new ProjectCustomAdapter ( getContext (),projectList,this );
        myRecycler.setLayoutManager ( new LinearLayoutManager ( getActivity () ) );
        myRecycler.setAdapter ( projectCustomAdapter );


        return root;
    }


    @Override
    public void onClickListener(int position) {
        Toast.makeText(getActivity(), "This is my Toast message! "+position,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ProjectDetails.class);
        intent.putExtra ("selected project",projectList.get ( position ));
        startActivity(intent);
    }
}