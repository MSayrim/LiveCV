package com.example.livecv.ui.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;

import com.example.livecv.R;
import com.example.livecv.ui.Mydoviz.DovizActivity;
import com.example.livecv.ui.importantStuff.Project;

public class ProjectDetails extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_project_details );

        textView = (TextView) findViewById ( R.id.projectNameText );
        textView2 = (TextView) findViewById ( R.id.projectInfoText );
        button = (Button) findViewById ( R.id.projectExampleButton );

        Intent intent = getIntent ();
        Project selectedProject = (Project) intent.getSerializableExtra ( "selected project" );
        textView.setText ( selectedProject.getProjectName () );
        textView2.setText ( selectedProject.getProjectTime () );



        final Intent intent2 = new Intent (getApplicationContext (), selectedProject.getProjectAdress ());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });


    }


}
