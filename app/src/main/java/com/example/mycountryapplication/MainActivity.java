package com.example.mycountryapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private AdapterCompositionPaysContinent adapterCompositionPaysContinent;

    public static String MY_COUNTRYANDCONTINENT_LIST_KEY="myCountryAndContinentListKey";
    private ArrayList<CompositionPaysContinent>listComposition;
    private String continentSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listComposition = new ArrayList<>(SharedPreferencesManager.getInstance(this).getCompositionCountryContinent(MY_COUNTRYANDCONTINENT_LIST_KEY));
        fab = findViewById(R.id.f_a_b);
        recyclerView = findViewById(R.id.recycler_view_display);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });


        setViewItem();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
    {
        case R.id.filter_alphabetical:
            sortArrayListAtoZ();
            return  true;

        case R.id.filter_alphabetical_inverted:
            sortArrayListZtoA();
            return  true;

        case R.id.filter_oldest_first:
            return  true;

        case R.id.filter_recent_first:
            return  true;

    }
        return super.onOptionsItemSelected(item);
    }

     private void showAlertDialog() {
                FragmentManager fm = this.getSupportFragmentManager();
                MyAlertDialogFragment alertDialog = MyAlertDialogFragment.newInstance("Some title");
                alertDialog.show(fm, "fragment_alert");
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OnDeleteImageClickedAction onDeleteImageClickedAction =new OnDeleteImageClickedAction() {
            @Override
            public void delete(CompositionPaysContinent compositionPaysContinent) {
                MainActivity.this.listComposition.remove(compositionPaysContinent);
                adapterCompositionPaysContinent.setListAdapter(listComposition);
                adapterCompositionPaysContinent.notifyDataSetChanged();
                SharedPreferencesManager.getInstance(MainActivity.this).saveCompositionCountryContinent(listComposition,MY_COUNTRYANDCONTINENT_LIST_KEY);
            }
        };
        adapterCompositionPaysContinent = new AdapterCompositionPaysContinent(listComposition,onDeleteImageClickedAction);
        recyclerView.setAdapter(adapterCompositionPaysContinent);

    }

    private void sortArrayListZtoA(){
        Collections.sort(listComposition, new Comparator<CompositionPaysContinent>() {
            @Override
            public int compare(CompositionPaysContinent compositionPaysContinent, CompositionPaysContinent t1) {
                //return compositionPaysContinent.getCountry().compareTo(t1.getCountry());

                return (t1.getCountry().compareToIgnoreCase(compositionPaysContinent.getCountry()));


            }
        });
        adapterCompositionPaysContinent.notifyDataSetChanged();

    }

    private void sortArrayListAtoZ(){
        Collections.sort(listComposition, new Comparator<CompositionPaysContinent>() {
            @Override
            public int compare(CompositionPaysContinent compositionPaysContinent, CompositionPaysContinent t1) {
                return compositionPaysContinent.getCountry().compareToIgnoreCase(t1.getCountry());
            }
        });
        adapterCompositionPaysContinent.notifyDataSetChanged();
    }




}