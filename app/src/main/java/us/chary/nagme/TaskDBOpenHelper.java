package us.chary.nagme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zach on 10/24/2015.
 */
public class TaskDBOpenHelper extends SQLiteOpenHelper {
    private static final String CREATE_STATEMENT =
            "CREATE TABLE tasks (" +
                    "description TEXT," +
                    "due INTEGER," +
                    "created INTEGER," +
                    "nags INTEGER," +
                    "difficulty INTEGER," +
                ");";
    private static final String INSERT_SAMPLE_STATEMENT =
            "INSERT INTO tasks (description, due, created, nags, difficulty) VALUES ('Sample Text',0,0,0,0)";
    TaskDBOpenHelper(Context context){
        super(context,"tasks",null,1);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_STATEMENT);
        db.execSQL(INSERT_SAMPLE_STATEMENT);
    }
    public void onUpgrade(SQLiteDatabase db, int a, int b){
        // this function intentionally left blank
    }
}
