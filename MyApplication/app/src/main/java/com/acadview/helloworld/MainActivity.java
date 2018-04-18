package com.acadview.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

/*
* Android Project Structure
* UI / XML file : activity_main.xml -> res/layout
*
* */

// how does android comes to know that MainActivity is an Activity ony ?

public class MainActivity extends AppCompatActivity {

    /**
     * Parent it has some methods to we can use them in the child class ?
     *
     * class A{void display(){....}}
     *
     * class B extends A{
     * @Override
     * void display(){
     * super.display();
     * ......}
     * }
     *
     * main(....){
     *   B b = new B();
     *   b.display();
     *
     *   A a = new B();
     *   a.display();
     *
     * }
     * **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_main);

        /**
         * The first param is the : Context
         * Second Param : String Message for user
         * Duration Of the Toast
         *
         * Show method
         *
         * Question : Can I change the position of the Toast ?
         *
         * **/

        Toast t = Toast.makeText(getApplicationContext(),
                "Hello World Toast",Toast.LENGTH_LONG);
        t.setGravity(Gravity.TOP,0,0);
        t.show();

        /*Toast t = Toast.makeText(getApplicationContext(),
                "Hello World Gravity Toast !", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,0);
        t.show();*/

        /*Toast.makeText(getApplicationContext(),
                "Hello World!",Toast.LENGTH_LONG).show();*/
    }
}
