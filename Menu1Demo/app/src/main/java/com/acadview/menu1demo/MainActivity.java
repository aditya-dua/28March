package com.acadview.menu1demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // The steps to create an Option Menu
    // 1. You will create the menu file(that is to be placed in the menu folder)
    // 2. In the activity you will the method : onCreateOptionsMenu
    // 3. You will get the inflator object and associate the menu file.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return  true;
    }
    // If any of the menu item is clicked, we will simply override the method
    // onOptionsItemSelected => item as a parameter ?
    // Each menu will have multiple items


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this, "The Item Selected is :"+item.getItemId(), Toast.LENGTH_SHORT).show();

        // Check for multiple cases:
        switch(item.getItemId()){
            // cases here can be the item id:
            case R.id.settings :
                // We can navigate to the next page
                Intent i = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(i);

                break;

            case R.id.userProfile :
                Toast.makeText(this, "User Profile Selected", Toast.LENGTH_SHORT).show();
                break;
            
            case R.id.logout :
                //Toast.makeText(this, "Logging you out !!", Toast.LENGTH_SHORT).show();
                logoutAlert();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // A new Alert
    // Why do we have a private method : So that it cannot be accessed outside the class.

    private void logoutAlert(){
        // what is Builder ?
        // Builder is class which helps to create the dynamic UI for the alert
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle("Logout Alert !");
        alertDialogBuilder.setMessage("Are you sure, you want to Logout ?");

        alertDialogBuilder.setPositiveButton("Log me out!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You are logged out!", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Stay Logged In", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(MainActivity.this, "I know that happened by mistake!", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setNeutralButton("Cancel the Alert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel Button is selected", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert= alertDialogBuilder.create();
        alert.show();


    }
    // A default method,which i need to override for back


    @Override
    public void onBackPressed() {

        exitAlert();
       // super.onBackPressed();
    }

    private void exitAlert(){
        // what is Builder ?
        // Builder is class which helps to create the dynamic UI for the alert
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle("Exit Alert !");
        alertDialogBuilder.setMessage("Are you sure, you want to Exit ?");

        alertDialogBuilder.setPositiveButton("Exit The App!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this, "You are logged out!", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(MainActivity.this, "I know that happened by mistake!", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel Button is selected", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert= alertDialogBuilder.create();
        alert.show();


    }


}
