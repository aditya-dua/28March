package com.adityadua.smsdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText phone,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.button);
        phone = (EditText)findViewById(R.id.editText);
        msg =(EditText)findViewById(R.id.editText2);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phone.getText().toString(),null,msg.getText().toString(),null,null);


            }
        });



    }
}
