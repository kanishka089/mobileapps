package com.diary.superdiary;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class home extends ListActivity{
	
	ArrayList<String> listItems=new ArrayList<String>();
	static final String[] itms=new String[]{
		"rice","tea","work","Babi","rice","tea","work","Babi"
	};
	int clickCounter=0;
	
    ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		Button addnew = (Button) findViewById(R.id.addBtn);
		
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
	    setListAdapter(adapter);
		
	    
	    addnew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.diary.superdiary.addnew"));
			}
		});
		
	}
	/*public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }*/
	
	
	
}
