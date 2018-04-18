package com.acadview.intents2demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button googleBtn,numberBtn;
    EditText phoneEdt;
    String url="http://www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleBtn = (Button)findViewById(R.id.GoogleButton);

        // Set the OnClick Listener on this button
        googleBtn.setOnClickListener(this);

        numberBtn = (Button)findViewById(R.id.button2);
        numberBtn.setOnClickListener(this);

        phoneEdt = (EditText) findViewById(R.id.editText);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.GoogleButton){
            // Perform operation
            Toast.makeText(this, "Redirecting you to Google.com", Toast.LENGTH_SHORT).show();
            Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(googleIntent);
        }else if(view.getId() == R.id.button2){

            String number = "tel:"+phoneEdt.getText().toString();
            Toast.makeText(this, "Dailing Number"
                    +number, Toast.LENGTH_SHORT).show();

            Intent i = new Intent(Intent.ACTION_CALL,Uri.parse(number));
            startActivity(i);


        }


    }
}
