package com.example.livecv.ui.Mydoviz;


import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.livecv.R;

import java.util.ArrayList;

public class DovizCustomAdapter extends ArrayAdapter {

    private ArrayList<Currency> currencyAll;
    private Activity context;

    public DovizCustomAdapter(ArrayList<Currency> currencyAll, Activity context)
    {
        super(context, R.layout.currency_list, currencyAll );
        this.currencyAll = currencyAll;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate( R.layout.currency_list,null,true);

        TextView valueView = customView.findViewById(R.id.cuurencyView );
        ImageView currencyImage = customView.findViewById(R.id.currencyImage );
        Currency currency = currencyAll.get(position);
        valueView.setText( currency.getMoneyValue() +"");
        currencyImage.setImageBitmap( currency.getMoneyPicId());
        if (position %2 == 1){
            customView.setBackgroundColor( Color.parseColor("#c8e6c9"));
        }else
        {
            customView.setBackgroundColor( Color.parseColor("#e8f5e9"));
        }


        return customView;
    }
}
