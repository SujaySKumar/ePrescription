package com.example.code;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class AddNewCategoryDoc extends AsyncTask<String, Void, Void>{
	
	public String URL_NEW_CATEGORY="http://192.168.43.55:80/ePrescription/setPres.php";

	boolean isNewCategoryCreated = false;

	@Override
	protected Void doInBackground(String... arg) {
		// TODO Auto-generated method stub
		String newName = arg[0];
		
		String newPres=arg[1];
		
		
		// Preparing post params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Name", newName));
		params.add(new BasicNameValuePair("prescription",newPres));
		
        //String par=params.toString();

		ServiceHandler serviceClient = new ServiceHandler();

		String json = serviceClient.makeServiceCall(URL_NEW_CATEGORY,
				ServiceHandler.POST, params);

		Log.d("Create Response: ", "> " + json);

		if (json != null) {
			try {
				JSONObject jsonObj = new JSONObject(json);
				boolean error = jsonObj.getBoolean("error");
				// checking for error node in json
				if (!error) {	
					// new category created successfully
					isNewCategoryCreated = true;
				} else {
					Log.e("Create Category Error: ", "> " + jsonObj.getString("message"));
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else {
			Log.e("JSON Data", "Didn't receive any data from server!");
		}
		return null;
	}
	

}
