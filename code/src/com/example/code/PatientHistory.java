package com.example.code;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class PatientHistory extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_history);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void onClickChronic(View view)
	{
		String f;
		//final EditText name=(EditText)findViewById(R.id.editText1);
		//String name1=name.getText().toString();
		Intent intent=new Intent(this,ChronicDiseases.class);
		
		//if(name1.equals("Vinay")){
		//	intent.putExtra(name1, "HIV");}
		//else if(name1.equals("Sujay")){
		//	intent.putExtra(name1, "EBOLA");
		//}
		//else { intent.putExtra(name1, "Breast Cancer");
		//}
		
		
		startActivity(intent);
		
		
	}
	public void onClickHeredity(View view)
	{
String f;
		//final EditText name=(EditText)findViewById(R.id.editText1);
		//String name1=name.getText().toString();
		Intent intent=new Intent(this,HeredityDisease.class);
		//if(name1.equals("Vinay")){
		//	intent.putExtra(name1, "HairLoss");}
		//else if(name1.equals("Sujay")){
		//	intent.putExtra(name1,"Sickle Cell Anaemia");
		//}
		//else { intent.putExtra(name1,"Diabetes");
		//}
		
		
		startActivity(intent);
		
	}
	public void onClickCommunicable(View view)
	{
		//final EditText name=(EditText)findViewById(R.id.editText1);
		//String name1=name.getText().toString();
		String f;
		Intent intent=new Intent(this,CommonDisease.class);
		//if(name1.equals("Vinay")){
		//	intent.putExtra(name1, "CommonCold");}
		//else if(name1.equals("Sujay")){
		//	intent.putExtra(name1, "Cholera");;
		//}
		//else { intent.putExtra(name1, "Dengue");
		//}
		
		
		startActivity(intent);
			}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_history, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_patient_history,
					container, false);
			return rootView;
		}
	}
}
