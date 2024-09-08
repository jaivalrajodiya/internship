package com.example.internship_jaival.water_reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class water_reminder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int CurrentProgress = 0;

    String[]  liter = { "1 Liter", "2 Liter", "3 Liter"};


    FloatingActionButton floatingActionButton;

    ProgressBar progressBar;

    Spinner spinner;

    TextView drink_pec;

    EditText drink_water;

    int total;

    int check;

    Button clear;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder);
        progressBar = findViewById(R.id.pg);
        floatingActionButton = findViewById(R.id.water_remainder);
        spinner = findViewById(R.id.liter_spinner);
        drink_pec = findViewById(R.id.water_percentage);
        clear = findViewById(R.id.water_clear);

        spinner.setOnItemSelectedListener(this);


        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                liter);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spinner.setAdapter(ad);
        

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(water_reminder.this);
                dialog.setContentView(R.layout.water_reminder_dialog);

                Button submit = dialog.findViewById(R.id.water_submit);
                 drink_water = dialog.findViewById(R.id.water);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        
                        
                        String reminder_water = drink_water.getText().toString();
                        int ml = Integer.valueOf(reminder_water);
                        

                        if (ml<=check){
                            CurrentProgress +=ml;
                            check-=ml;
                            updateprogressbar();
                            dialog.dismiss();
                        }  else {
                            Toast.makeText(water_reminder.this, "Enter valid number", Toast.LENGTH_SHORT).show();
                        }



                            
                        }



                });

                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);


            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentProgress=0;
                check=1000;
                updateprogressbar();
                floatingActionButton.setEnabled(true);
            }
        });



    }

    private void updateprogressbar() {
        progressBar.setProgress(CurrentProgress);


        double final_perc = CurrentProgress*100/total;

        if (final_perc >= 100.0){
            drink_pec.setText("done");
            floatingActionButton.setEnabled(false);
        }else {
            drink_pec.setText(final_perc +"%");
        }



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        if (position == 0){
            progressBar.setMax(1000);
            total = 1000;
            check=1000;
            double final_perc = CurrentProgress*100/total;
            if (final_perc >= 100.0){
                drink_pec.setText("done");
                floatingActionButton.setEnabled(false);
            }else {

                drink_pec.setText(final_perc+"%");
            }

        } else if (position == 1) {
            progressBar.setMax(2000);
            total = 2000;
            check=2000;
            double final_perc = CurrentProgress*100/total;
            if (final_perc >= 100.0){
                drink_pec.setText("done");
                floatingActionButton.setEnabled(false);
            }else {

                drink_pec.setText(final_perc+"%");
            }
            floatingActionButton.setEnabled(true);
        }else {
            progressBar.setMax(3000);
            total = 3000;
            check=3000;
            double final_perc = CurrentProgress*100/total;
            if (final_perc >= 100.0){
                drink_pec.setText("done");
                floatingActionButton.setEnabled(false);
            }else {

                drink_pec.setText(final_perc+"%");
            }
            floatingActionButton.setEnabled(true);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}