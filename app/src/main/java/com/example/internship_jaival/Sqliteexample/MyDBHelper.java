package com.example.internship_jaival.Sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    private  static  final String DATABASE_NAME = "studentData";
    private  static  final int DATABASE_version = 1;
    private  static  final String TABLE_STUDENT = "student";
    private  static  final String KEY_ID = "id";
    private  static  final String KEY_NAME = "tittle";
    private  static  final String KEY_Roll_NO = "roll_no";
    private  static  final String KEY_PHONE_NO = "phone_no";
    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" create table " + TABLE_STUDENT +
                "( " + KEY_ID + " integer primary key autoincrement," + KEY_NAME + " TEXT "  + ")");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" drop table if exists " + TABLE_STUDENT);
        onCreate(db);

    }

    public void addstudent_data(String title){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, title);

        database.insert(TABLE_STUDENT,null,values);


    }

    public ArrayList<StudentDataModel> fetchStudentData(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TABLE_STUDENT , null);

        ArrayList<StudentDataModel> arrayList = new ArrayList<>();

        while (cursor.moveToNext()){

            StudentDataModel model = new StudentDataModel();
            model.id = cursor.getInt(0);
            model.title = cursor.getString(1);
//            model.id = cursor.getInt(0);
//            model.name = cursor.getString(1);
//            model.roll_no = cursor.getString(2);
//            model.phone_no = cursor.getString(3);

            arrayList.add(model);
        }
        return arrayList;

    }
    public void updatestudentdata(StudentDataModel studentDataModel){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,studentDataModel.title);
//        values.put(KEY_Roll_NO,studentDataModel.roll_no);
//        values.put(KEY_PHONE_NO,studentDataModel.phone_no);

        database.update(TABLE_STUDENT,values,KEY_ID + " = " + studentDataModel.id,null);
    }

    public void deleteStudentData(int id){

        SQLiteDatabase database = this.getWritableDatabase();

        database.delete(TABLE_STUDENT,KEY_ID+ " = ? " ,new String[]{String.valueOf(id)});
    }
}
