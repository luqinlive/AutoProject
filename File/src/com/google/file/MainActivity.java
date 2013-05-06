package com.google.file;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(new ButtonClickListener());
	}
	
	public final class  ButtonClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			 EditText filenameText = (EditText) findViewById(R.id.filename);
			 EditText contentText = (EditText) findViewById(R.id.filecontent);
			String  filename = filenameText.getText().toString();
			String  filecontent = contentText.getText().toString();
			FileService service = new  FileService(getApplicationContext());
			try {
				service.save(filename,filecontent);
				Log.v("ingo", filename+filecontent);
				Toast.makeText(getApplicationContext(), "Save Success!", 1).show();
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Save Fail!", 1).show();
				e.printStackTrace();
			}
			
			FileService service1= new FileService(getApplicationContext());
			String result;
			try {
				result = service1.read("a.txt");
				Toast.makeText(getApplicationContext(), result ,1).show();
				Log.i("TAG",result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
