package edu.westga.jetnoisereporter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.westga.jetnoisereporter.Model.User;

public class JetNoiseAppDB extends SQLiteOpenHelper implements JetNoiseDbInterface {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "JetNoiseDB.db";

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_ZIP = "zipcode";

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
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_CITY + " TEXT,"
                + COLUMN_ZIP + " TEXT,"
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

    @Override
    public long updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        SQLiteDatabase db = this.getWritableDatabase();

        // This app is only for a single user so delete all rows and re-create the single user
        this.clearUsers();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PHONE, user.getPhone());
        values.put(COLUMN_ADDRESS, user.getAddress());
        values.put(COLUMN_CITY, user.getCity());
        values.put(COLUMN_ZIP, user.getZipcode());
        values.put(COLUMN_EMAIL, user.getEmail());
        //values.put(COLUMN_REPORT_DATE,"2013-10-07 08:23:19.120");
        // Insert the new row, returning the primary key value of the new row
        long newRowId = -1;
       newRowId = db.insert(TABLE_USERS, null, values);
        db.close();
        return  newRowId;
    }

    @Override
    public User lookupUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " +
                COLUMN_NAME + "," +
                COLUMN_EMAIL + "," +
                COLUMN_PHONE + "," +
                COLUMN_ADDRESS + "," +
                COLUMN_CITY + "," +
                COLUMN_ZIP +
                " FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);
        User result = null;
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            String  name = cursor.getString(0);
            String email = cursor.getString(1);
            String phone = cursor.getString(2);
            String address = cursor.getString(3);
            String city = cursor.getString(4);
            String zipcode = cursor.getString(5);
            cursor.close();
            result = new User(name, address, city, zipcode, phone, email);
        }
        db.close();
        return result;
    }

    @Override
    public void clearUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + TABLE_USERS;
        db.execSQL(deleteQuery);
    }

}
