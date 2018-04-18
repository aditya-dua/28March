package com.acadview.loginappsession;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText userNameEditText,passwordEditText;
    Button submitButton,resetButton;
    TextView status;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (EditText) => We are typecaste to EditText
        userNameEditText = (EditText) findViewById(R.id.usernameEdt);
        passwordEditText = (EditText) findViewById(R.id.pwdEdt);

        submitButton = (Button)findViewById(R.id.sbmBtn);
        status = (TextView)findViewById(R.id.wrongPwdText);
        submitButton.setOnClickListener(this);


        // Now comes the Event Handling!!!


        resetButton = (Button)findViewById(R.id.button5);
        resetButton.setOnClickListener(this);
        /*submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // I have to check that if userName & the password ?

                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(userName.equals("aditya") && password.equalsIgnoreCase("aditya")){
                    Toast.makeText(MainActivity.this, "Login Is Successful", Toast.LENGTH_SHORT).show();
                    counter =3;
                    status.setVisibility(TextView.INVISIBLE);
                }else{
                    status.setVisibility(TextView.VISIBLE);
                    status.setText("Attempts Remaining :"+(--counter));

                    if(counter ==0){
                        submitButton.setEnabled(false);
                    }
                }

              //  Toast.makeText(MainActivity.this, "Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

       /* resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameEditText.setText("");
                passwordEditText.setText("");
            }
        });
*/

    }

    /*public void resetButtonClicked(View view){

        userNameEditText.setText("");
      //  passwordEditText.setText("");
    }*/

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.sbmBtn){
            String userName = userNameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if(userName.equals("aditya") && password.equalsIgnoreCase("aditya")){
                Toast.makeText(MainActivity.this, "Login Is Successful", Toast.LENGTH_SHORT).show();
                counter =3;
                status.setVisibility(TextView.INVISIBLE);
            }else{
                status.setVisibility(TextView.VISIBLE);
                status.setText("Attempts Remaining :"+(--counter));

                if(counter ==0){
                    submitButton.setEnabled(false);
                }
            }
        }
        else if(view.getId() == R.id.button5){
            userNameEditText.setText("");
            passwordEditText.setText("");
        }


    }
}
