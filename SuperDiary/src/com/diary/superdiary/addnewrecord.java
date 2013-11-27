package com.diary.superdiary;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addnewrecord extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.addnewrecord);
		final DatabaseHandler db = new DatabaseHandler(this);
		
		Date d = new Date();
		final CharSequence s  = DateFormat.format("dd/MM/yyyy ", d.getTime());
		TextView dates = (TextView) findViewById(R.id.textView3);
		dates.setText(s);
		
		Button save=(Button)findViewById(R.id.save);
		final EditText note=(EditText)findViewById(R.id.editText1);
		//final String notes=note.getText().toString();
		//db.addContact(new getsetinfo(notes, notes));
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String notes=note.getText().toString();
				db.addContact(new getsetinfo(s.toString(), notes));
				
				String k=db.getContact(2).date;
				TextView stg = (TextView) findViewById(R.id.textView2);
				stg.setText(k);
			}
		});
				
		/**
		 * CRUD Operations
		 * */
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
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	
	
}