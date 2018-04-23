package com.acadview.storage28mdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by AdityaDua on 20/04/18.
 */

public class ExternalActivity extends AppCompatActivity implements View.OnClickListener{

    Button readBtn,writeBtn;
    EditText text;
    TextView textTo;
    String fileName="mySampleFile.txt";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_storage_main);

        readBtn = (Button) findViewById(R.id.button11);
        writeBtn = (Button)findViewById(R.id.button21);

        text = (EditText)findViewById(R.id.msgET1);
        textTo = (TextView)findViewById(R.id.fileReadText11);

        readBtn.setOnClickListener(this);
        writeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button21){
            try {
                File file = new File(Environment.getExternalStorageDirectory()+"/"+fileName);

                file.createNewFile();

                FileOutputStream fOut = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOut);

                outputStreamWriter.append(text.getText().toString());
                outputStreamWriter.close();
                fOut.close();
                Toast.makeText(this, "File Saved Successfully!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }else if(view.getId() == R.id.button11){

            File file = new File(Environment.getExternalStorageDirectory()+"/"+fileName);
            String aRow="";
            String textToBeWritten="";
            try {
                FileInputStream fIn = new FileInputStream(file);
                BufferedReader bReader = new BufferedReader(new InputStreamReader(fIn));

                while((aRow=bReader.readLine())!=null){
                    textToBeWritten=textToBeWritten+aRow;
                }

                textTo.setText(textToBeWritten);
                bReader.close();
                Toast.makeText(this, "File Read", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
