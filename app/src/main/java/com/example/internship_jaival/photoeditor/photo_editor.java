package com.example.internship_jaival.photoeditor;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internship_jaival.R;

public class photo_editor extends AppCompatActivity {

    Button btnselect;

//    public static Uri imguri;

    ActivityResultLauncher<String> mGetContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editor);

        btnselect = findViewById(R.id.btnselectphoto);

        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });

        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri o) {
                Intent intent = new Intent(photo_editor.this, photo_editor1.class);
                intent.putExtra("Data",o.toString());
                startActivityForResult(intent,101);

            }
        });



//        btnselect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ImagePicker.Companion.with(photo_editor.this)
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .start();
//
//            }
//        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        try {
//            imguri = data.getData();
//            if (!imguri.equals("")){
//                Intent intent = new Intent(photo_editor.this, photo_editor1.class);
//                startActivity(intent);
//            }
//
//        }catch (Exception e){
//
//        }
//
//        }

}