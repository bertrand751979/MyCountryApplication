package com.example.mycountryapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCompositionPaysContinent extends RecyclerView.Adapter<ViewHolderCompositionPaysContinent> {
    private ArrayList<CompositionPaysContinent> listAdapter;
    private OnDeleteImageClickedAction onDeleteImageClickedAction;

    public AdapterCompositionPaysContinent(ArrayList<CompositionPaysContinent> listAdapter, OnDeleteImageClickedAction onDeleteImageClickedAction) {
        this.listAdapter = listAdapter;
        this.onDeleteImageClickedAction = onDeleteImageClickedAction;
    }

    public void setListAdapter(ArrayList<CompositionPaysContinent> listAdapter) {
        this.listAdapter = listAdapter;
    }

    @NonNull
    @Override
    public ViewHolderCompositionPaysContinent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_display,parent,false);
        return new ViewHolderCompositionPaysContinent(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCompositionPaysContinent holder, int position) {
        holder.bind(listAdapter.get(position),onDeleteImageClickedAction);
    }

    @Override
    public int getItemCount() {
        return listAdapter.size();
    }
}
