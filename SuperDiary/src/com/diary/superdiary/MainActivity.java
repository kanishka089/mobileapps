package com.diary.superdiary;

import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText pass;
	public static String ps="empty";
	TextView url1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		final DatabaseHandler db1 = new DatabaseHandler(this);
		//db1.addContact(new getsetinfo("21/12/2013","this is test data"));
		//db1.addContactlogin(new getsetinfologin("kani"));
		/*getsetinfo get= db1.getContact(5);
		String date=get.getDate();
		String note=get.getnote();
		Toast.makeText(getApplicationContext(),
				date, Toast.LENGTH_LONG)
                .show();*/
		/*url1=(TextView)findViewById(R.id.url);
		Pattern pattern = Pattern.compile("google.com");
		//jmt: prefix our pattern with http://
		Linkify.addLinks(url1, pattern, "http://");*/
		
		int i=db1.getContactsCountlogin();
		if(i==0){
			startActivity(new Intent("com.diary.superdiary.passchange"));
			//finish();
		}
		else{
			getsetinfologin get= db1.getContactlogin(1);
			ps=get.getpass();
		}
		/*Toast.makeText(getApplicationContext(),
				i+"", Toast.LENGTH_LONG)
                .show();*/
		setContentView(R.layout.activity_main);
		
		
		
		/*if(ps.equals("empty")){
			startActivity(new Intent("com.diary.superdiary.passchange"));
			
		}*/
		
		Button enter = (Button) findViewById(R.id.button1);
				

		pass = (EditText) findViewById(R.id.pass);
		final Toast error = Toast.makeText(this, "Invalid Login",
				Toast.LENGTH_SHORT);
		enter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getsetinfologin get= db1.getContactlogin(1);
				ps=get.getpass();
				if (pass.getText().toString().equals(ps)) {
					startActivity(new Intent("com.diary.superdiary.login"));
					
					finish();
				} else {
					pass.setText("");
					error.show();
				}

			}
		});

	
	
	}


}
