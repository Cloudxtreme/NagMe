package us.chary.nagme;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        // retrieve tasks from database
        TaskDBOpenHelper t = new TaskDBOpenHelper(this);
        SQLiteDatabase d = t.getReadableDatabase();
        String[] columns = new String[]{"rowid as _id","description", "due", "nags", "difficulty", "priority"};
        Cursor c = d.query("tasks",columns,null,null,null,null,null);
        // fill listview with tasks
        ListView l = (ListView) findViewById(R.id.listView);
        l.setAdapter(new TaskListAdapter(this,c));
    }


}
