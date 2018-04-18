package com.acadview.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button submitBtn;
    EditText userNameEdt,pwdEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEdt = (EditText) findViewById(R.id.userNameEdt);
        pwdEdt = (EditText)findViewById(R.id.editText2);

        submitBtn = (Button)findViewById(R.id.button);
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button){
            // perform some action...
            String userName = userNameEdt.getText().toString();
            String pwd = pwdEdt.getText().toString();

            if(userName.equalsIgnoreCase("aditya") && pwd.equals("aditya")){
                // Open the Page For Instructor
                // This is an Example Of Explict Intent
                // Intent in which which page is to be opened.
                Intent  intent = new Intent(MainActivity.this,InstructorActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);

            }else if(userName.equals("student") && pwd.equals("student")){
                // Open the Page For Student
            }




        }
    }
}
