package edu.westga.jetnoisereporter.database;

import android.content.Context;
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

    public JetNoiseAppDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
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

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_REPORTS + "("
                + COLUMN_REPORT_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_REPORT_DATE + " DATETIME,"
                + COLUMN_USER_ID + " INTEGER REFERENCES " + TABLE_USERS
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

}
