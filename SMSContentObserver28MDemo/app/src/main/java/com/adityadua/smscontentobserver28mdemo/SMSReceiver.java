package com.adityadua.smscontentobserver28mdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AdityaDua on 12/05/18.
 */

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "In SMS BR", Toast.LENGTH_SHORT).show();
        // Theres a URI for SMS
        // content://sms/inbox

        Uri uri= Uri.parse("content://sms/inbox");

        // Observer identified there's a change in the DB.
        // based on this change , we actually we query the DB
        // for the SMS

        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");

        cursor.moveToLast();


        String message = cursor.getString(cursor.getColumnIndex("body"));

        cursor.close();

        Toast.makeText(context, "OTP is ::"+fetchOTP(message), Toast.LENGTH_SHORT).show();


    }
    public static String fetchOTP(String message){

        Pattern p = Pattern.compile("(\\d){6}");
        Matcher matcher = p.matcher(message);

        if(matcher.find()){
            return matcher.group(0);
        }else
            return "No OTP found";
    }
}
