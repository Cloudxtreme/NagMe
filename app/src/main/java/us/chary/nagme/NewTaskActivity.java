package us.chary.nagme;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        findViewById(R.id.save).setOnClickListener(saveClickListener);
    }

    View.OnClickListener saveClickListener = new View.OnClickListener() {
        public void onClick(View v){
            Intent i = new Intent(getApplicationContext(), NewTaskActivity.class);
            finishActivity(1);
        }
    };
}
