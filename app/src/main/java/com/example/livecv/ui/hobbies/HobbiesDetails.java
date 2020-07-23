package com.example.livecv.ui.hobbies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.livecv.R;
import com.example.livecv.ui.importantStuff.Hobbies;

public class HobbiesDetails extends AppCompatActivity {


    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_hobbies_details );

        textView = (TextView) findViewById ( R.id.hobbiesDetailTextView );
        imageView = (ImageView) findViewById ( R.id.hobbiesDetailImageView );


        Intent intent = getIntent ();
        Hobbies selectedProject = (Hobbies) intent.getSerializableExtra ( "selected project" );
        textView.setText ( selectedProject.getHobbieName () );
        imageView.setImageResource ( selectedProject.getHobbiePic () );

    }
}
