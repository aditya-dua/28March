package com.adityadua.smsdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phoneEdt,msgEdt;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button)findViewById(R.id.button);
        phoneEdt = (EditText)findViewById(R.id.editText);
        msgEdt = (EditText)findViewById(R.id.editText2);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();

                smsManager.sendTextMessage(phoneEdt.getText().toString(),null,msgEdt.getText().toString(),null,null);
            }
        });

    }

}
