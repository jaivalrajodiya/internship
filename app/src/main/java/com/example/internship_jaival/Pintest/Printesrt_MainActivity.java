package com.example.internship_jaival.Pintest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internship_jaival.R;

import java.util.Calendar;

public class Printesrt_MainActivity extends AppCompatActivity {

    DatePickerDialog dialog;

    TextView bdate;
    Button next;

    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printesrt_main);

        bdate = findViewById(R.id.printerst_birthdate);
        next = findViewById(R.id.printerst_next);
        back = findViewById(R.id.brithdate_back);
        bdate.setText(getTodyDate());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Printesrt_MainActivity.this, Choose_GenderActivity.class);
                startActivity(intent);
            }
        });

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month+1;
                String date = makeDateString(dayOfMonth,month,year);
                bdate.setText(date);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        dialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);

        dialog.show();
    }

    public  String getTodyDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return makeDateString(day,month,year);
    }
    private String makeDateString(int dayOfMonth, int month, int year) {

        return dayOfMonth+" "+getMonthForment(month)+" "+year;
    }

    private String getMonthForment(int month) {

        if (month == 1)
            return "JAN";

        if (month == 2)
            return "FAB";

        if (month == 3)
            return "MAR";

        if (month == 4)
            return "APR";

        if (month == 5)
            return "MAY";

        if (month == 6)
            return "JUN";

        if (month == 7)
            return "JUL";

        if (month == 8)
            return "AUG";

        if (month == 9)
            return "SEP";

        if (month == 10)
            return "OCT";

        if (month == 11)
            return "NOV";

        if (month == 12)
            return "DEC";


        return "JAN";

    }

}