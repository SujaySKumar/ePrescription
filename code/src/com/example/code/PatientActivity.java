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
import android.os.Build;

public class PatientActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void onClickVideo(View view){
    	Intent sky = new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/hangouts/_/g5sy5ih5dtonim5rhesagaxmdaa"));
    	startActivity(sky);
    }
	public void onClickHistory(View view)
	{
		 Intent intent = new Intent(this, PatientHistory.class);
	        startActivity(intent);
	}
	public void onClickPrescription(View view)
	{
		Intent intent=new Intent(this,PatientPrescription.class);
		
		//final  String URL_CATEGORIES="http://192.168.43.55:80/ePrescription/getPres.php";
		//Intent i = new Intent(Intent.ACTION_VIEW);
		//i.setData(Uri.parse(URL_CATEGORIES));
		startActivity(intent);
	}
	public void onClickSymptom(View view)
	{
		 Intent intent = new Intent(this, NewSymptoms.class);
	        startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_patient,
					container, false);
			return rootView;
		}
	}
}
