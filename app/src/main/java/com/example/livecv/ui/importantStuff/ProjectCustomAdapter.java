package com.example.livecv.ui.importantStuff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.livecv.R;

import java.util.List;

public class ProjectCustomAdapter extends RecyclerView.Adapter<ProjectCustomAdapter.MyViewHolder> {

    Context mContext;
    List<Project> projects;
    private customClickListener mcustomClickListener;

    public ProjectCustomAdapter(Context mContext, List<Project> projects, customClickListener customClickListener) {
        this.mContext = mContext;
        this.projects = projects;
        this.mcustomClickListener = customClickListener;
    }

    @NonNull
    @Override
    public ProjectCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from ( mContext ).inflate ( R.layout.custom_view,parent,false );
        MyViewHolder vHolder = new MyViewHolder (v,mcustomClickListener);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectCustomAdapter.MyViewHolder holder, int position) {

        holder.projectName.setText ( projects.get ( position ).getProjectName () );

        holder.projectTime.setText ( projects.get ( position ).getProjectTime () );

        holder.projectIcon.setImageResource ( projects.get ( position ).getImage () );


    }

    @Override
    public int getItemCount() {
        return projects.size ();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView projectName;
        private TextView projectTime;
        private ImageView projectIcon;
        customClickListener customClickListener;

        public MyViewHolder(View itemView ,customClickListener customClickListener) {
            super(itemView);
            projectName = (TextView) itemView.findViewById(R.id.textView2 );
            projectTime = (TextView) itemView.findViewById ( R.id.textView3 );
            projectIcon = (ImageView) itemView.findViewById ( R.id.imageView2 );
            this.customClickListener = customClickListener;
            itemView.setOnClickListener ( this );
        }

        @Override
        public void onClick(View v) {
            customClickListener.onClickListener ( getAdapterPosition () );
        }
    }

    public interface customClickListener {
        void onClickListener(int position);
    }
}
