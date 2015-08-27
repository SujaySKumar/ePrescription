package com.example.code;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Build;

public class SetPrescription extends ActionBarActivity {
	  private RadioGroup radioGroup;
	  private RadioButton radioButton;
	  String radio;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_prescription);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		
		}
	}
		public void onClickRadio(View view) {
			 
			 boolean checked = ((RadioButton) view).isChecked();
			    
			    // Check which radio button was clicked
			    switch(view.getId()) {
			        case R.id.radioChronic:
			            if (checked)
			                radio="ChronicDisease";// Pirates are the best
			            break;
			        case R.id.radioHeredity:
			            if (checked)
			            	radio="HeredityDisease"; // Ninjas rule
			            break;
			        case R.id.radioCommon:
			        	if(checked)
			        		radio="CommonDisease";
			        		break;
			    }
			    Toast.makeText(SetPrescription.this, radio, Toast.LENGTH_SHORT).show();
		}
		  
	
	public void onSendButton(View view){
		
        final EditText name=(EditText)findViewById(R.id.nameBox);
    	final EditText pres=(EditText)findViewById(R.id.editText2);
    	//Intent intent1 = getIntent(); // gets the previously created intent
    	//String name1 = intent1.getStringExtra("name"); // will return "FirstKeyValue"
    	//name.setText(name1);
				String name1=name.getText().toString();
				String  pres1=pres.getText().toString();
				//Log.d("THE SELECTED DISEASE TYPE IS -------",radioButton.getText().toString());
				
				 
				// find the radiobutton by returned id
			      //radioButton = (RadioButton) findViewById(selectedId);
	 
				new AddNewCategoryDoc().execute(name1,pres1);
				Toast.makeText(SetPrescription.this, "Prescription updated", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(this,DoctorActivity.class);
				startActivity(intent);
				
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set_prescription, menu);
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
			View rootView = inflater.inflate(
					R.layout.fragment_set_prescription, container, false);
			return rootView;
		}
	}
}
