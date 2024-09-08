package com.example.internship_jaival.photoeditor;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class photo_editor1 extends AppCompatActivity {

    ImageView edit;


    String result;
    Uri fileuri;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editor1);
        
        readIntent();

        String dest_uri = new StringBuilder(UUID.randomUUID().toString()).append(".jpg").toString();

        UCrop.Options options = new UCrop.Options();



        UCrop.of(fileuri,Uri.fromFile(new File(getCacheDir(),dest_uri)))
                .withOptions(options)
                .withAspectRatio(0,0)
                .useSourceImageAspectRatio()
                .withMaxResultSize(2000,2000)
                .start(photo_editor1.this);

       edit = findViewById(R.id.editimg);

    }

    private void readIntent() {
        Intent intent = getIntent();
        if (intent.getExtras()!=null){
            result = intent.getStringExtra("Data");
            fileuri = Uri.parse(result);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP){
            final Uri resulturi = UCrop.getOutput(data);
            edit.setImageURI(resulturi);
        } else if (resultCode == UCrop.RESULT_ERROR) {
            final Throwable croperror = UCrop.getError(data);
        }
    }
}