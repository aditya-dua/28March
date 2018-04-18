package com.acadview.spinneracdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] country={"India","USA","UAE","KSA","UK"};
    String [] indiaState={"Delhi","Punjab","Haryana","Uttar Pradesh","Uttrakhand"};
    String [] usState={"New York","Florida","Texas"};
    String [] uaeState={"Dubai","Abu Dhabi","Shar Jah","Ajman"};

    Spinner spinner;
    ArrayAdapter<String> arrayAdapter;

    AutoCompleteTextView stateTextView;
    ArrayAdapter<String> stateArrayAdapter;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.countryDropDown);

        stateTextView = (AutoCompleteTextView) findViewById(R.id.stateACTV);

        // How we took

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item,country);

        spinner.setAdapter(arrayAdapter);

        // View : On Clicked
        // List View : Item Click
        // Spinner : Item Select
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Country Selected is :"+country[i]+",Please select a state to continue", Toast.LENGTH_SHORT).show();

                if(i==0){
                   stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                           android.R.layout.simple_list_item_1,indiaState);
                   stateTextView.setAdapter(stateArrayAdapter);
                }else if(i==1){
                    stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1,usState);
                    stateTextView.setAdapter(stateArrayAdapter);
                }else if(i==2){
                    stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1,uaeState);
                    stateTextView.setAdapter(stateArrayAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
