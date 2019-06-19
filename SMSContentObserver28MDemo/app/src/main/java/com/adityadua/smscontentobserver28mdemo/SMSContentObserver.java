package com.adityadua.smscontentobserver28mdemo;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by AdityaDua on 12/05/18.
 */

public class SMSContentObserver extends ContentObserver {

    Context context;
    Handler handler;

    public SMSContentObserver(Context context,Handler handler) {
        super(handler);

        this.context = context;
        this.handler = handler;
    }

    // This method will be called when there is any change in the
    // Content..
    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Toast.makeText(context, "In OnChange", Toast.LENGTH_SHORT).show();
        // Theres a URI for SMS
        // content://sms/inbox

        Uri uri= Uri.parse("content://sms/inbox");

        // Observer identified there's a change in the DB.
        // based on this change , we actually we query the DB
        // for the SMS

        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");

        cursor.moveToLast();


        StringBuilder builder = new StringBuilder();
        builder.append("From : "+cursor.getString(cursor.getColumnIndex("address")));
        builder.append("Message : "+cursor.getString(cursor.getColumnIndex("body")));

        cursor.close();
        String message = builder.toString();
        // Ignore the handler right now...
        handler.obtainMessage(1,message).sendToTarget();


    }
}
