package com.diary.superdiary;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class home extends Activity{
	
	
	ListView listView;
	//public static ArrayList<String> ArrayofName = new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.home);
		
		Button addnew = (Button) findViewById(R.id.addBtn);
		
		DatabaseHandler db = new DatabaseHandler(this);
		ArrayList<getsetinfo> contactList = new ArrayList<getsetinfo>();

		contactList=db.getAllContacts();

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(new MyCustomBaseAdapter(this, contactList));
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ArrayofName);

        listView.setAdapter(adapter);*/
        
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
	//static final String[] food=new String[]{"k","s","d","a"};
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.onCreate(null);
	}


	
}
