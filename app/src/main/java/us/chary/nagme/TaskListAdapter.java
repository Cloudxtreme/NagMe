package us.chary.nagme;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Zach on 10/24/2015.
 */
public class TaskListAdapter extends CursorAdapter {
    private Context context;
    Cursor cursor;
    LayoutInflater inflater;
    public TaskListAdapter(Context context, Cursor cursor) {
        super(context, cursor, true);
        inflater = (LayoutInflater.from(context));
    }
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = inflater.inflate(R.layout.task_list_item,parent,false);
        view.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        ((TextView) view.findViewById(R.id.description)).setText(cursor.getString(cursor.getColumnIndex("description")));
        ((TextView) view.findViewById(R.id.due)).setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("due"))));
        ((TextView) view.findViewById(R.id.nags)).setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("nags"))));
        ((TextView) view.findViewById(R.id.difficulty)).setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("difficulty"))));
        return view;
    }
    public void bindView(View view, Context context, Cursor cursor) {
    }

}
