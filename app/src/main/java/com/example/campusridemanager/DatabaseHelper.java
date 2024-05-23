package com.example.campusridemanager;

import static android.accounts.AccountManager.KEY_PASSWORD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CampusRideManager.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private static final String TABLE_STUDENTS = "students";
    private static final String TABLE_COMPLAINTS = "complaints";
    private static final String TABLE_HISTORICAL_COMPLAINTS = "historical_complaints";
    private static final String TABLE_FACULTY = "faculty";

    // Common column names
    private static final String KEY_ID = "id";

    // STUDENTS Table - column names
    private static final String KEY_NAME = "name";
    private static final String KEY_HOSTEL = "hostel";
    private static final String KEY_VEHICLE_NUMBER = "vehicle_number";
    private static final String KEY_HOLOGRAM_NUMBER = "hologram_number";

    // COMPLAINTS Table - column names
    private static final String KEY_STUDENT_ID = "student_id";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_STATUS = "status";
    private static final String KEY_DATE = "date";

    // FACULTY Table - column names
    private static final String KEY_FACULTY_NAME = "faculty_name";
    private static final String KEY_DESIGNATION = "designation";
    private static final String KEY_DEPARTMENT = "department";
    private static final String KEY_FACULTY_USERNAME = "username";
    private static final String KEY_FACULTY_PASSWORD = "password";

    // SQL to create students table
    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT,"
            + KEY_HOSTEL + " TEXT,"
            + KEY_VEHICLE_NUMBER + " TEXT,"
            + KEY_HOLOGRAM_NUMBER + " TEXT"
            + ")";

    // SQL to create complaints table
    private static final String CREATE_TABLE_COMPLAINTS = "CREATE TABLE " + TABLE_COMPLAINTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_STUDENT_ID + " INTEGER,"
            + KEY_DESCRIPTION + " TEXT,"
            + KEY_STATUS + " TEXT,"
            + KEY_DATE + " TEXT"
            + ")";

    // SQL to create historical complaints table
    private static final String CREATE_TABLE_HISTORICAL_COMPLAINTS = "CREATE TABLE " + TABLE_HISTORICAL_COMPLAINTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_STUDENT_ID + " INTEGER,"
            + KEY_DESCRIPTION + " TEXT,"
            + KEY_STATUS + " TEXT,"
            + KEY_DATE + " TEXT"
            + ")";

    // SQL to create faculty table
    private static final String CREATE_TABLE_FACULTY = "CREATE TABLE " + TABLE_FACULTY + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_FACULTY_NAME + " TEXT,"
            + KEY_DESIGNATION + " TEXT,"
            + KEY_DEPARTMENT + " TEXT,"
            + KEY_FACULTY_USERNAME + " TEXT,"
            + KEY_FACULTY_PASSWORD + " TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_COMPLAINTS);
        db.execSQL(CREATE_TABLE_HISTORICAL_COMPLAINTS);
        db.execSQL(CREATE_TABLE_FACULTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPLAINTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORICAL_COMPLAINTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FACULTY);

        // Create tables again
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_HOSTEL, student.getHostel());
        values.put(KEY_VEHICLE_NUMBER, student.getVehicleNumber());
        values.put(KEY_HOLOGRAM_NUMBER, student.getHologramNumber());
        values.put(KEY_PASSWORD, student.getPassword()); // New field for password
        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }
    public boolean authenticateStudent(String vehicleNumber, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_STUDENTS, new String[]{KEY_ID},
                KEY_VEHICLE_NUMBER + "=? AND " + KEY_PASSWORD + "=?",
                new String[]{vehicleNumber, password}, null, null, null);
        boolean isAuthenticated = (cursor != null && cursor.moveToFirst());
        if (cursor != null) {
            cursor.close();
        }
        return isAuthenticated;
    }

    // Add other CRUD operations here (insert, update, delete, get student info, etc.)
}


