package com.adityadua.notificationdemo28m;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button simpleNotificationBtn,bigTextNotification;

    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleNotificationBtn = (Button)findViewById(R.id.simpleNotificationBtn);

        simpleNotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleNotification();
            }
        });
        bigTextNotification = (Button)findViewById(R.id.bigTextNotificationBtn);

        bigTextNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigTextNotification();
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(count ==1){
            super.onBackPressed();
            }else{
            Toast.makeText(this, "Press Back again to exit", Toast.LENGTH_SHORT).show();
            count++;
        }

    }

    private void showSimpleNotification(){
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification Title")
                .setContentText
                        ("Notification Text , will be shown in the text area");

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,nBuilder.build());

    }

    private void showBigTextNotification(){

        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Big Text Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon1);

      
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setSummaryText("Walmart CEO addresses Flipkart staff; says deal among best decisions");


        bigText.bigText("NEW DELHI: Within hours of adding Flipkart to its shopping cart at a $16 billion price tag, Walmart CEO Doug McMillon told the e-retailer's employees that the deal was among the best decisions and emphasised that India was the best place was to be in, according to sources.\n" +
                "He is also learnt to have said the company intends to \"empower\" Flipkart and its staff as well as learn from them about building full ecosystems and payments.\n" +
                "\"It is our intention to just empower you and let you run - speed matters, decisiveness matters,\" McMillon said in his address to Flipkart employees.\n" +
                "In the biggest M&A deal in the booming e-commerce sector, Walmart today announced buying 77 per cent stake in Flipkart for about $16 billion (Rs 1.05 lakh crore).\n" +
                "Walmart's investment includes $2 billion of new equity funding that would help Flipkart to accelerate its growth pace amid stiff competition from Amazon, which is also pumping in huge funds into its India operations.\n" +
                "The fast-growing e-commerce market also has a number of smaller and niche players like SoftBank and Alibaba-backed Paytm Mall, Snapdeal and ShopClues.\n" +
                "Interestingly, there were speculations that Amazon had also made a bid for Flipkart, even though neither of the companies confirmed it.\n" +
                "\"I am confident that this is one of the best decisions our company has made - we believe in India, have seen growth in India in every way. This is the best place to be anywhere in the world,\" McMillon, who is also Walmart President, said.\n" +
                "The Walmart chief stated that the values of the two companies were \"very much aligned\", according to sources.");

        bigText.setBigContentTitle("the Walmart Flipkart Deal");
        mBuilder.setStyle(bigText);

        // I will add code here later on !!!
        Intent resultIntent = new Intent(MainActivity.this,NextActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NextActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(100,mBuilder.build());



    }

}
