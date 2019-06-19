package com.adityadua.smscontentobserver28mdemo;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SMSContentObserver smsContentObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.readSMSTV);
        smsContentObserver = new SMSContentObserver(this,handler);
        getContentResolver().registerContentObserver(Uri.parse("content://sms/inbox"),true,smsContentObserver);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            textView.setText(str);
        }
    };
}
