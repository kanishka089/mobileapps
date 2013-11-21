package com.diary.superdiary;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{
	 EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button enter=(Button) findViewById(R.id.button1);
        pass=(EditText) findViewById(R.id.pass);
        final Toast error=Toast.makeText(this,"Invalid Login", Toast.LENGTH_SHORT);
        enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(pass.getText().toString().equals("kani")){
					startActivity(new Intent("com.diary.superdiary.login"));
				}
				else{
					pass.setText("");
					error.show();
				}
				
			}
		});
        
                
    }

    
}
