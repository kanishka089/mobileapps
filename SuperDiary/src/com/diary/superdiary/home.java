package com.diary.superdiary;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

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
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
	    setListAdapter(adapter);
		/*setListAdapter(new ArrayAdapter<String>(this, R.layout.home,itms));
		ListView list=getListView();
		list.setTextFilterEnabled(true);*/
		
	}
	public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }
	
	
	
}
