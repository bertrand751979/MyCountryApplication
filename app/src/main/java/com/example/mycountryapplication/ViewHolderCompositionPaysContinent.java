package com.example.mycountryapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderCompositionPaysContinent extends RecyclerView.ViewHolder {
    private TextView vhCountry;
    private TextView vhContinent;
    private ImageView vhDelete;


    public ViewHolderCompositionPaysContinent(@NonNull View view) {
        super(view);
        vhCountry=view.findViewById(R.id.raw_display_country);
        vhContinent=view.findViewById(R.id.raw_display_continent);;
        vhDelete=view.findViewById(R.id.raw_display_cancel);;
    }

    public TextView getVhCountry() {
        return vhCountry;
    }

    public void setVhCountry(TextView vhCountry) {
        this.vhCountry = vhCountry;
    }

    public TextView getVhContinent() {
        return vhContinent;
    }

    public void setVhContinent(TextView vhContinent) {
        this.vhContinent = vhContinent;
    }

    public ImageView getVhDelete() {
        return vhDelete;
    }

    public void setVhDelete(ImageView vhDelete) {
        this.vhDelete = vhDelete;
    }

    public void bind(CompositionPaysContinent compositionPaysContinent,OnDeleteImageClickedAction onDeleteImageClickedAction){
        vhCountry.setText(compositionPaysContinent.getCountry());
        vhContinent.setText(compositionPaysContinent.getContinent());
        vhDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteImageClickedAction.delete(compositionPaysContinent);
            }
        });




    }
}
