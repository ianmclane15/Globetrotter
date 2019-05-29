package com.hfad.globetrotter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class FlightListActivity extends AppCompatActivity {

    private ListView flights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);

        wireWidgets();

        populateListView();

        registerForContextMenu(flights);

    }

    private void populateListView() {
Carrier[] carrierArray = (Carrier[])getIntent().getParcelableArrayExtra("carriers");
List<Carrier> carriers = Arrays.asList(carrierArray);

    }






    private void wireWidgets() {
        flights = findViewById(R.id.listView_flightListActivity_list);
    }
}