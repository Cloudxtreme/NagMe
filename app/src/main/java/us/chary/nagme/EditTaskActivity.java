package us.chary.nagme;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditTaskActivity extends AppCompatActivity {
    private SQLiteDatabase d;
    private LinearLayout root;
    int taskId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        findViewById(R.id.save).setOnClickListener(saveClickListener);
        TaskDBOpenHelper t = new TaskDBOpenHelper(getApplicationContext());
        d = t.getReadableDatabase();
        root = (LinearLayout) findViewById(R.id.form);
        String[] columns = new String[]{"description", "due", "difficulty"};
        taskId = getIntent().getExtras().getInt("taskId");
        Cursor c = d.query("tasks", columns, "rowid = " + taskId , null, null, null, null);
        c.moveToPosition(0);
        String description = c.getString(c.getColumnIndex("description"));
        int due = c.getInt(c.getColumnIndex("due"));
        int difficulty = c.getInt(c.getColumnIndex("difficulty"));
        ((EditText) root.findViewById(R.id.description)).setText(description);
        ((EditText) root.findViewById(R.id.due)).setText(Integer.toString(due));
        ((EditText) root.findViewById(R.id.difficulty)).setText(Integer.toString(difficulty));
    }

    View.OnClickListener saveClickListener = new View.OnClickListener() {
        public void onClick(View v){
            Log.d("save", "Saving.");
            ContentValues values = new ContentValues();
            values.put("description", ((EditText) root.findViewById(R.id.description)).getText().toString());
            values.put("due", ((EditText) root.findViewById(R.id.due)).getText().toString());
            values.put("difficulty", ((EditText) root.findViewById(R.id.difficulty)).getText().toString());
            if(values.getAsString("description").isEmpty() ||
                    values.getAsString("due").isEmpty() ||
                    values.getAsString("difficulty").isEmpty()) {
                Toast.makeText(getApplicationContext(),"Please fill out all fields.",Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                d.update("tasks",values,"rowid = ?",new String[]{Integer.toString(taskId)});
            } catch (SQLException e) {
                Toast.makeText(getApplicationContext(),"Could not save to database!",Toast.LENGTH_SHORT).show();
                Log.d("save", "SQLException while saving. " + e.getMessage());
                return;
            }
            Intent i = new Intent(getApplicationContext(), TaskListActivity.class);
            startActivity(i);
        }
    };
}
