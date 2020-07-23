package com.example.livecv.ui.importantStuff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.livecv.R;

import java.util.List;


public class HobbiesCustomAdapter extends RecyclerView.Adapter<HobbiesCustomAdapter.MyViewHolder> {

    Context mContext;
    List<Hobbies> hobbies;
    private customClickListener mcustomClickListener;

    public HobbiesCustomAdapter(Context mContext, List<Hobbies> hobbies, customClickListener customClickListener) {
        this.mContext = mContext;
        this.hobbies = hobbies;
        this.mcustomClickListener = customClickListener;
    }

    @NonNull
    @Override
    public HobbiesCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from ( mContext ).inflate ( R.layout.hobbies_list,parent,false );
        MyViewHolder vHolder = new MyViewHolder (v,mcustomClickListener);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HobbiesCustomAdapter.MyViewHolder holder, int position) {

        holder.hobbiesName.setText ( hobbies.get ( position ).getHobbieName () );


    }

    @Override
    public int getItemCount() {
        return hobbies.size ();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView hobbiesName;
        customClickListener customClickListener;

        public MyViewHolder(View itemView ,customClickListener customClickListener) {
            super(itemView);
            hobbiesName = (TextView) itemView.findViewById(R.id.textView5 );
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
