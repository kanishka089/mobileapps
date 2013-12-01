package com.diary.superdiary;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class home extends Activity{
	
	
	ListView listView;
	public static ArrayList<String> ArrayofName = new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		Button addnew = (Button) findViewById(R.id.addBtn);
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		// Reading all contacts
        /*Log.d("Reading: ", "Reading all contacts..");
        List<getsetinfo> contacts = db.getAllContacts();       

        for (getsetinfo cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getDate() + " ,Phone: " + cn.getnote();
                // Writing Contacts to log
        Log.d("Name: ", log);

        }*/

        db.getAllContacts();

        
        listView = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ArrayofName);

        //gridView.setAdapter(adapter);
        listView.setAdapter(adapter);
        
        //ArrayofName.clear();
        
        /*gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                int position, long id) {
               Toast.makeText(getApplicationContext(),
                ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });*/
		
		
		
	    
	    addnew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.diary.superdiary.addnew"));
			}
		});
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.onCreate(null);
	}
	
	
	
}
