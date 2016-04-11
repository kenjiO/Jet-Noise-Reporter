package edu.westga.jetnoisereporter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JetNoiseAppDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "JetNoiseDB.db";

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_ZIP = "zipcode";
    public static final String COLUMN_CALLER_CODE = "callerCode";

    public static final String TABLE_REPORTS = "reports";
    public static final String COLUMN_REPORT_ID = "reportID";
    public static final String COLUMN_REPORT_DATE = "reportDate";

    public JetNoiseAppDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_CITY + " TEXT,"
                + COLUMN_ZIP + " TEXT,"
                + COLUMN_CALLER_CODE + " TEXT,"
                + COLUMN_PHONE + " TEXT"
                + ");";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public long updateUser(String name, String address, String city, String zipcode,
                           String phone, String callerCode) {
        SQLiteDatabase db = this.getWritableDatabase();

        // This app is only for a single user so delete all rows and re-create the single user
        String deleteQuery = "DELETE FROM " + TABLE_USERS;
        db.execSQL(deleteQuery);

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_CITY, city);
        values.put(COLUMN_ZIP, zipcode);
        values.put(COLUMN_CALLER_CODE, callerCode);
        //values.put(COLUMN_REPORT_DATE,"2013-10-07 08:23:19.120");
        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(TABLE_USERS, null, values);
        db.close();
        return  newRowId;
    }

    public String lookupUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_NAME + " FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);
        String result = "Not Found";
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            result = cursor.getString(0);
            cursor.close();
        }
        db.close();
        return result;
    }

}
