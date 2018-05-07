package com.adityadua.broadcastreceiver28mdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by AdityaDua on 07/05/18.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        Toast.makeText(context, "BroadCast Receiver called for ACTION"+action, Toast.LENGTH_SHORT).show();
    }
}
