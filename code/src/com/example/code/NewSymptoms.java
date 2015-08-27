package com.example.code;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class NewSymptoms extends ActionBarActivity {
	
	//final Button send=(Button)findViewById(R.id.sendButton);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_symptoms);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	}
	
	public void onClickSendButton(View view){
		
        final EditText name=(EditText)findViewById(R.id.nameBox);
    	final EditText num=(EditText)findViewById(R.id.editText2);
    	final EditText sym=(EditText)findViewById(R.id.editText3);
				String name1=name.getText().toString();
				String  num1=num.getText().toString();
				String sym1=sym.getText().toString();
				new AddNewCategory().execute(name1,num1,sym1);
				Toast.makeText(NewSymptoms.this, "Thankyou for your patience. The doctor will reply soon", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(this,PatientActivity.class);
				startActivity(intent);
				finish();
			}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_symptoms, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_new_symptoms,
					container, false);
			return rootView;
		}
	}
}
