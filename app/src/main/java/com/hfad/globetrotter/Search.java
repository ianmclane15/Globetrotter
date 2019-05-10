package com.hfad.globetrotter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Search extends AppCompatActivity {

    private EditText mTextMessage;
    EditText editTextDateDepart;
    Button buttonTimePicker;
    EditText editTextDateReturn;
    SeekBar searchbar;
    TextView eco;
    TextView pe;
    TextView business;
    TextView fc;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Spinner adults;
    Spinner children;
    Spinner infants;

    private RadioGroup radioClassGroup;
    private RadioButton radioEcoButton;
    private RadioButton radioBizButton;
    private RadioButton radioFirstButton;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent toHome = new Intent(Search.this, MainActivity.class);
                    startActivity(toHome);
                    return true;
                case R.id.navigation_flights:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        editTextDateDepart = findViewById(R.id.editText_search_departdate);
        editTextDateReturn = findViewById(R.id.editText_search_returndate);
        searchbar = findViewById(R.id.seekBar_search);
        eco = findViewById(R.id.textView_search_eco);
        pe = findViewById(R.id.textView_search_pe);
        business = findViewById(R.id.textView_search_business);
        fc = findViewById(R.id.textView_search_fc);
        setUpCalendar();
        setOnSeekBarListener();

        adults = findViewById(R.id.spinner_search_adults);
        children = findViewById(R.id.spinner_search_children);
        infants = findViewById(R.id.spinner_search_infants);

        ArrayAdapter<CharSequence> adapterAdults = ArrayAdapter.createFromResource(this, R.array.numbers_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterChildren = ArrayAdapter.createFromResource(this, R.array.numbers_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterInfants = ArrayAdapter.createFromResource(this, R.array.numbers_array, android.R.layout.simple_spinner_dropdown_item);

        adapterAdults.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterChildren.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterInfants.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adults.setAdapter(adapterAdults);
        children.setAdapter(adapterChildren);
        infants.setAdapter(adapterInfants);

        radioClassGroup = findViewById(R.id.radioClass);
        radioEcoButton = findViewById(R.id.radioEco);
        radioBizButton = findViewById(R.id.radioBiz);
        radioFirstButton = findViewById(R.id.radioFirst);






    }

    private void setOnSeekBarListener() {
        searchbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    pe.setVisibility(View.INVISIBLE);
                    business.setVisibility(View.INVISIBLE);
                    fc.setVisibility(View.INVISIBLE);
                    eco.setVisibility(View.VISIBLE);

                }

                if (progress == 1) {
                    eco.setVisibility(View.INVISIBLE);
                    business.setVisibility(View.INVISIBLE);
                    fc.setVisibility(View.INVISIBLE);
                    pe.setVisibility(View.VISIBLE);
                }

                if (progress == 2) {
                    eco.setVisibility(View.INVISIBLE);
                    pe.setVisibility(View.INVISIBLE);
                    fc.setVisibility(View.INVISIBLE);
                    business.setVisibility(View.VISIBLE);
                }

                if (progress == 3) {
                    eco.setVisibility(View.INVISIBLE);
                    pe.setVisibility(View.INVISIBLE);
                    business.setVisibility(View.INVISIBLE);
                    fc.setVisibility(View.VISIBLE);
                }

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


        private void setUpCalendar () {
            //sets up calender for departure
            final Calendar myCalendar = Calendar.getInstance();
            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, month);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "MM/dd/yy";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.US);

                    editTextDateDepart.setText(simpleDateFormat.format(myCalendar.getTime()));

                }
            };
            editTextDateDepart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(Search.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });

            //sets up calendar for return date
            final Calendar myCalendar2 = Calendar.getInstance();
            final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    myCalendar2.set(Calendar.YEAR, year);
                    myCalendar2.set(Calendar.MONTH, month);
                    myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "MM/dd/yy";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.US);

                    editTextDateReturn.setText(simpleDateFormat.format(myCalendar2.getTime()));

                }
            };
            editTextDateReturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(Search.this, date2, myCalendar2.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
           });


    }
}




