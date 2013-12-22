package com.diary.superdiary;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class addnewrecord extends Activity {
	
	final DatabaseHandler db = new DatabaseHandler(this);
	EditText note;
	CharSequence s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.addnewrecord);
		
		Date d = new Date();
		s  = DateFormat.format("dd/MM/yyyy ", d.getTime());
		TextView dates = (TextView) findViewById(R.id.textView3);
		dates.setText(s);

		note=(EditText)findViewById(R.id.editText1);
		
		
		// Inserting Contacts
		/*Log.d("Insert: ", "Inserting ..");
		db.addContact(new getsetinfo("Ravi", "9100000000"));
		db.addContact(new getsetinfo("Srinivas", "9199999999"));
		db.addContact(new getsetinfo("Tommy", "9522222222"));
		db.addContact(new getsetinfo("Karthik", "9533333333"));*/
		
		//Reading Single Contact
		

		// Reading all contacts
		/*Log.d("Reading: ", "Reading all contacts..");
		List<getsetinfo> contacts = db.getAllContacts();

		for (getsetinfo cn : contacts) {
			String log = "Id: " + cn.getID() + " ,Name: " + cn.getDate()
					+ " ,Phone: " + cn.getnote();
			// Writing Contacts to log
			Log.d("Name: ", log);
		}*/
		
	
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	         
	        switch (item.getItemId())
	        {
	        case R.id.menu_save:
	            // Single menu item is selected do something
	            // Ex: launching new activity/screen or show alert message
	        	String notes=note.getText().toString();
				db.addContact(new getsetinfo(s.toString(), notes));

				finish();
	            Toast.makeText(addnewrecord.this, "Saved", Toast.LENGTH_SHORT).show();
	            return true;
	 
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    } 
	
}
