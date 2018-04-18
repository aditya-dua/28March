package com.acadview.spinneracdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by AdityaDua on 15/04/18.
 */

public class SecondActivity extends AppCompatActivity {

    String [] stateArr={"Delhi","Haryana","Punjab","Uttar Pradesh","Uttrakhand"};
    String [] delhiArr={"Delhi","New Delhi"};
    String [] harArr={"Faridabad","Gurgoan","Ambala","Sonipat","Panipat","Murthal"};
    String [] punArr={"Jalandhar","Ludhiana","Amritsar","Patiala"};
    String [] upArr={"Noida","Greater Noida","Ghazibad","Merrut","Mathura"};
    String [] utrArr={"Dehradun","Roorkee","Haridwar","Rishikesh"};

    Spinner stateSpinner,citySpinner;

    ArrayAdapter<String> stateAdapter,cityAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_city_example);

        stateSpinner = (Spinner)findViewById(R.id.stateDropDown);
        citySpinner = (Spinner)findViewById(R.id.cityDropDown);

        stateAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,stateArr);

        stateSpinner.setAdapter(stateAdapter);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // I will get the position of item selected : "I".
                if(i==0){
                    // Clear hain :::
                    cityAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,delhiArr);
                    citySpinner.setAdapter(cityAdapter);
                }else if(i==1){
                    // Clear hain :::
                    cityAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,harArr);
                    citySpinner.setAdapter(cityAdapter);
                }else if(i==2){
                    // Clear hain :::
                    cityAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,punArr);
                    citySpinner.setAdapter(cityAdapter);
                }else if(i==3){
                    // Clear hain :::
                    cityAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,upArr);
                    citySpinner.setAdapter(cityAdapter);
                }else if(i==4){
                    // Clear hain :::
                    cityAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,utrArr);
                    citySpinner.setAdapter(cityAdapter);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
