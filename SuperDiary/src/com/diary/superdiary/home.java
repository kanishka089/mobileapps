package com.diary.superdiary;

import java.util.ArrayList;
import java.util.List;



import android.R.color;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class home extends Activity{
	
	
	ListView listView;
	//public static ArrayList<String> ArrayofName = new ArrayList<String>();
	ArrayList<getsetinfo> contactList = new ArrayList<getsetinfo>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.home);
		
		Button addnew = (Button) findViewById(R.id.addBtn);
		
		final DatabaseHandler db = new DatabaseHandler(this);
		

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
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int position,long arg3) {
				Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				// Vibrate for 500 milliseconds
				v.vibrate(50);
				// TODO Auto-generated method stub
				AlertDialog.Builder b=new AlertDialog.Builder(home.this);
				b.setIcon(android.R.drawable.ic_dialog_alert);
				b.setMessage("Are you sure you want to delete this");
				b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int whichButton) {
						  
						  Toast.makeText(getApplicationContext(),
                                  "Deleted", Toast.LENGTH_LONG)
                                  .show();
						  TextView dbid = (TextView) findViewById(R.id.cityState);
						  db.deleteRow(Integer.parseInt(dbid.getText().toString()));
						  
					  }
					});
				b.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                    int whichButton) {
                                dialog.cancel();
                            }
                        });

                b.show();
				return false;
			}
			
		});
		
	    
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
