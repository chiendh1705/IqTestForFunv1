package com.game.chiendh.iqtestforfun;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	public static final String DB_PATH="/data/data/com.game.chiendh.iqtestforfun/databases/UserDB";
	
	public static final String CREATE_TABLE = "CREATE TABLE User ("
			+"id integer primary key autoincrement,"
			+"name text)";
	
	private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }
	
	private static Sample[] mSamples;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSamples = new Sample[]{
                
                new Sample(R.string.title_activity_everyone, EveryoneActivity.class),
                
        };

        setListAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mSamples));
//        SQLiteDatabase db;
//        db = openOrCreateDatabase("UserDB", MODE_PRIVATE, null);
//        db = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
//        db.execSQL(CREATE_TABLE);
//        db.execSQL("INSERT INTO User(name) VALUES ('Chien');"); 
//    	db.close();
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }

}
