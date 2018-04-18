package com.acadview.intentexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 09/04/18.
 */

public class InstructorActivity extends AppCompatActivity {

    Button pPBtn;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_screen);
        Intent i = getIntent();
        String userName = i.getStringExtra("userName");
        Toast.makeText(this, "Welcome Instructor :"+userName, Toast.LENGTH_SHORT).show();


        pPBtn = (Button)findViewById(R.id.uploadPictureBtn);
        imgView = (ImageView) findViewById(R.id.imageView);

        pPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implict Intent :
                // Beacuse i will ask the OS to capture
                // ACTION_IMAGE_CAPTURE  => Default intent in ANdroid to capture an Image
                //In cases when my system returns an output with a result

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent,101);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            if(resultCode == RESULT_OK){

                Bundle extraBundle = data.getExtras();
                Bitmap imageBitmap = (Bitmap)extraBundle.get("data");
                imgView.setImageBitmap(imageBitmap);

            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "User Cancelled the Operation !", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
