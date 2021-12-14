package com.example.mycountryapplication;


import static com.example.mycountryapplication.MainActivity.MY_COUNTRYANDCONTINENT_LIST_KEY;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyAlertDialogFragment extends DialogFragment {
    public static EditText mEditText;
    private Button save;
    private Button cancel;
    private String continentSelected;
    public ArrayList<CompositionPaysContinent> myCountryContinentList = new ArrayList<>();

    public MyAlertDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alert_dialog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save =view.findViewById(R.id.btn_save);
        cancel =view.findViewById(R.id.btn_cancel);
        mEditText = (EditText) view.findViewById(R.id.edit_country);
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToList();
                Intent intent = new Intent(MyAlertDialogFragment.this.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        Spinner spinner = view.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.continent, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                continentSelected = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),continentSelected,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public static MyAlertDialogFragment newInstance(String title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    private void addToList(){
        CompositionPaysContinent compositionPaysContinent =new CompositionPaysContinent();
        compositionPaysContinent.setCountry(mEditText.getText().toString());
        compositionPaysContinent.setContinent(continentSelected);
        myCountryContinentList.add(compositionPaysContinent);
        SharedPreferencesManager.getInstance(this.getContext()).addCompositionToList(compositionPaysContinent,MY_COUNTRYANDCONTINENT_LIST_KEY);
        Toast.makeText(MyAlertDialogFragment.this.getContext(),"ajouté a la liste: "+
                SharedPreferencesManager.getInstance(this.getContext()).getCompositionCountryContinent(MY_COUNTRYANDCONTINENT_LIST_KEY).size(),Toast.LENGTH_SHORT).show();


    }

}
