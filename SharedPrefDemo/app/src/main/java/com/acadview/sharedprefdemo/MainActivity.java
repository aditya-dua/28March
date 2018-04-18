package com.acadview.sharedprefdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText userName,Password;
    Button saveButton;
    SharedPreferences sharedPreferences;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);

        sharedPreferences=getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        text = (TextView)findViewById(R.id.textView3);

        if(sharedPreferences.contains("userName")){
            text.setText(sharedPreferences.getString("userName","Default"));
        }

        //sharedPreferences.
        
        saveButton = (Button)findViewById(R.id.button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Save Button Clicked", Toast.LENGTH_SHORT).show();

                String userN =userName.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("userName",userN);
                editor.commit();
                Toast.makeText(MainActivity.this, "USerName Is Saved"+userN, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
