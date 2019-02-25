package tutorial.android.android_tutorial;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import java.util.List;

import android.content.ContentValues;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by SIAM on 4/13/2018.
 */

public class QuizHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name

    private static final String DATABASE_NAME = "mathsone";

    // tasks table name

    private static final String TABLE_QUEST = "quest";

    // tasks Table Columns names

    private static final String KEY_ID = "qid";

    private static final String KEY_QUES = "question";

    private static final String KEY_ANSWER = "answer"; // correct option

    private static final String KEY_OPTA = "opta"; // option a

    private static final String KEY_OPTB = "optb"; // option b

    private static final String KEY_OPTC = "optc"; // option c



    private SQLiteDatabase dbase;



    public QuizHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override

    public void onCreate(SQLiteDatabase db) {

        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "

                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES

                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "

                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql);

        addQuestion();

        // db.close();

    }



    private void addQuestion() {

        Question q1 = new Question("On Which Thread Services Work in android?", "Own Thread", "Main Thread", "None of the above", "Main Thread");

        this.addQuestion(q1);

        Question q2 = new Question("What is log message in android?", "Log message is used to debug a program", "same as printf()", "same as Toast()","Log message is used to debug a program");

        this.addQuestion(q2);

        Question q3 = new Question("How many levels of securitys are there in android?", "App level security and kernel level security", "android level security", "java level security", "App level security and kernel level security");

        this.addQuestion(q3);

        Question q4 = new Question("Which are the screen sizes in Android?", "small", "large", "all of the above", "all of the above");

        this.addQuestion(q4);

        Question q5 = new Question("Layouts in android?", "Frame Layout", "Linear Layout", "All of the above", "All of the above");

        this.addQuestion(q5);

        Question q6 = new Question("You can shut down an activity by calling its _______ method", "onDestory()", "finish()", "finishActivity()", "finish()");

        this.addQuestion(q6);

        Question q7 = new Question("Which component is not activated by an Intent?", "content Provider", "broadcast Receiver", "activity", "content Provider");

        this.addQuestion(q7);

        Question q8 = new Question("How many ways to start services?", "a.started", "b.bound", "a & b", "a & b");

        this.addQuestion(q8);

        Question q9 = new Question("If your service is private to your own application and runs in the same process as the client (which is common), you should create your interface by extending the ________class?", "binder", "AIDL", "none of the above", "binder");

        this.addQuestion(q9);

        Question q10 = new Question("Which one is NOT related to fragment class?", "preference Fragment", "cursor Fragment", "list Fragment", "cursor Fragment");

        this.addQuestion(q10);

        Question q11 = new Question("Is it possible to have an activity without UI to perform action/actions?", "Not possible", "Yes, it is possible", "Wrong question", "Yes, it is possible");

        this.addQuestion(q11);

        Question q12 = new Question("How to upgrade SQlite the database from a lower version to higher version in android SQlite?", "Using helper Class", " Using cursor", "Using intent", "Using helper Class");

        this.addQuestion(q12);

        Question q13 = new Question("Is it mandatory to call onCreate() and onStart() in android?", "No, we can write the program without writing onCreate() and onStart()", "Yes, we should call onCreate() and onStart() to write the program", "At least we need to call onCreate() once", "No, we can write the program without writing onCreate() and onStart()");

        this.addQuestion(q13);

        Question q14 = new Question("Android is initially developed by-", "android inc", "google inc", "open handset allience", "google inc");

        this.addQuestion(q14);

        Question q15 = new Question("What was the first phone released that ran the Android OS?", "T-Mobile G1", "Google gPhone", "motorola Droid", "T-Mobile G1");

        this.addQuestion(q15);

        Question q16 = new Question("Android is Based on Linux for the following reason?", "Security", "portability", "Networking", "Security");

        this.addQuestion(q16);

        Question q17 = new Question("What Operating system is used as the base of the Android stack?", "window", "Linux", "Sun Solaris", "Linux");

        this.addQuestion(q17);

        Question q18 = new Question("The R file is a (an) generated file-", "Manually", "Emulated", "Automatically", "Automatically");

        this.addQuestion(q18);

        Question q19 = new Question("When Developing for the Android OS,Java byte code is compiled into what?", "Java source code", "Dalvik Application code", "Dalvik Byte code", "Dalvik Byte code");

        this.addQuestion(q19);

        Question q20 = new Question("We can pass Data between Activities in Android using-", "Intent", "Content Provider", "Broadcast Receiver", "Intent");

        this.addQuestion(q20);

        Question q21 = new Question("What is the package name of HTTP client in android?", "com.json", "org.apache.http.client", "com.android.JSON", "com.android.JSON");

        this.addQuestion(q21);

        // END

    }



    @Override

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        // Create tables again

        onCreate(db);

    }



    // Adding new question

    public void addQuestion(Question quest) {

        // SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_QUES, quest.getQUESTION());

        values.put(KEY_ANSWER, quest.getANSWER());

        values.put(KEY_OPTA, quest.getOPTA());

        values.put(KEY_OPTB, quest.getOPTB());

        values.put(KEY_OPTC, quest.getOPTC());



        // Inserting Row

        dbase.insert(TABLE_QUEST, null, values);

    }



    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();

        // Select All Query

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;

        dbase = this.getReadableDatabase();

        Cursor cursor = dbase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {

            do {

                Question quest = new Question();

                quest.setID(cursor.getInt(0));

                quest.setQUESTION(cursor.getString(1));

                quest.setANSWER(cursor.getString(2));

                quest.setOPTA(cursor.getString(3));

                quest.setOPTB(cursor.getString(4));

                quest.setOPTC(cursor.getString(5));



                quesList.add(quest);

            } while (cursor.moveToNext());

        }

        // return quest list

        return quesList;
    }
}
