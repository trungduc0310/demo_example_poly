package com.humin.demotest1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;

public class StaffDAO {
    private SQLiteDatabase sqLiteDatabase;

    public StaffDAO(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void insertStaff(Staff staff) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name_staff", staff.getNameStaff());
            contentValues.put("birthday", staff.getBirthdayStaff());
            contentValues.put("id_department", staff.getIdDepartment());
            sqLiteDatabase.insert("Staff", null, contentValues);
        } catch (Exception ex) {
            Log.d("StaffDAO", ex.getMessage());
        }
    }

    public ArrayList<Staff> getListAllStaff(){
        try{
            String scripGetAll = "select * from Staff";
            ArrayList<Staff> listStaff = new ArrayList<>();
            Cursor cursor = sqLiteDatabase.rawQuery(scripGetAll,null);
            if (cursor.moveToFirst()){
                do {
                    String name = cursor.getString(1);
                    String birthday = cursor.getString(2);
                    int idDepartment = cursor.getInt(4);
                    Staff staff = new Staff(name, birthday , idDepartment);
                    listStaff.add(staff);
                }
                while (cursor.moveToNext());
            }
            return listStaff;
        }catch (Exception ex) {
            Log.d("StaffDAO", ex.getMessage());
            return new ArrayList();
        }
    }
}
