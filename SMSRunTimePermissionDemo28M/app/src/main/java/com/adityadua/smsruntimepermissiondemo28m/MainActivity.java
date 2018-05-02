package com.adityadua.smsruntimepermissiondemo28m;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText phoneEdt,msgEdt;
    TextView statusTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.button);
        phoneEdt = (EditText)findViewById(R.id.editTextPhone);
        msgEdt = (EditText)findViewById(R.id.editTextMessage);


        statusTV = (TextView)findViewById(R.id.status);

        //sendBtn.setEnabled(false);
        // Permission is Not Granted
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this, "Permission is Not Granted", Toast.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},123);
            sendBtn.setEnabled(false);
        }else{
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            sendBtn.setEnabled(true);
        }

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager sms = SmsManager.getDefault();

                sms.sendTextMessage(phoneEdt.getText().toString(),null,msgEdt.getText().toString(),null,null);
                statusTV.setText("Message Sent Success !");


            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission is granted", Toast.LENGTH_SHORT).show();
                sendBtn.setEnabled(true);
            }else{
               statusTV.setText("Permission Not granted");
                sendBtn.setEnabled(false);
            }

        }

    }
}
