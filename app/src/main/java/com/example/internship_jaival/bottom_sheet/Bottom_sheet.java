package com.example.internship_jaival.bottom_sheet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.internship_jaival.R;
import com.example.internship_jaival.instragram.Post_Adapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Bottom_sheet extends AppCompatActivity {

    Button bottomsheet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        bottomsheet = findViewById(R.id.bottom_sheet);

        bottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showdialog();
            }
        });

    }

    private void showdialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet_layout);

        LinearLayout editlayout = dialog.findViewById(R.id.layout_edit);
        LinearLayout sharelayout = dialog.findViewById(R.id.layout_share);
        LinearLayout printlayout = dialog.findViewById(R.id.layout_print);
        LinearLayout uploadlayout = dialog.findViewById(R.id.layout_upload);
        ImageView cancle = dialog.findViewById(R.id.cancle);


        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        editlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Bottom_sheet.this, "Edit is cilcked", Toast.LENGTH_SHORT).show();
            }
        });

        sharelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Bottom_sheet.this, "share is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        
        printlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Bottom_sheet.this, "print is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        
        uploadlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Bottom_sheet.this, "upload is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


}