package com.acadview.storage28mdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // The Text Of EditText should be written to a file.

    EditText textEditText;
    Button saveBtn,readBtn,nextBtn;
    TextView text;
    String FILENAME="mytextfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditText = (EditText)findViewById(R.id.msgET);
        saveBtn = (Button) findViewById(R.id.button2);
        readBtn = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.fileReadText11);
        nextBtn = (Button)findViewById(R.id.button3);
        saveBtn.setOnClickListener(this);
        readBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button){
            // Read Code
            try {
                // Since you are reading from the file, you dont need to specify the mode.

                FileInputStream fileIn = openFileInput(FILENAME);

                InputStreamReader inputReader = new InputStreamReader(fileIn);

                char [] inputText=new char[100];
                String fileText="";

                // 600 chars in file

                int charCount;

                while((charCount = inputReader.read(inputText))>0){

                    fileText = fileText+String.copyValueOf(inputText,0,charCount);
                }

                inputReader.close();
                text.setText(fileText);
                Toast.makeText(this, "File has been read!", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }else if(view.getId() == R.id.button2){
            // Write Code
            try {
                FileOutputStream fileOut = openFileOutput(FILENAME,MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOut);
                outputStreamWriter.write(textEditText.getText().toString());

                outputStreamWriter.close();
                Toast.makeText(this, "File Saved Successfully!", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }else if(view.getId() == R.id.button3){

            Intent i = new Intent(MainActivity.this,ExternalActivity.class);
            startActivity(i);
        }

    }
}
