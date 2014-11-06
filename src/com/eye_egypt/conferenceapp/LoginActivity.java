package com.eye_egypt.conferenceapp;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eye_egypt.conferenceapp.services.WebServices;
import com.eye_egypt.conferenceapp.utilities.CommonUtilities;
import com.eye_egypt.conferenceapp.utilities.Constants;

public class LoginActivity extends Activity {

	Button btn_Login;
	TextView txt_Password, txt_Username;
	Intent mainActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//DatabaseHandler db = new DatabaseHandler(this);

		// Reading all contacts
		//Log.d("Reading: ", "Reading all contacts..");
		/*		List<LibraryItems> libraryItems = db.getAllContacts();

		for (LibraryItems cn : libraryItems) {
			String log = "Id: " + cn.getID() + " ,Name: " + cn.getName()
					+ " ,Title: " + cn.getTitle();
			// Writing Contacts to log
			Log.d("Name: ", log);
			//db.deleteContact(cn);
		}
*/
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_login);
		btn_Login = (Button) findViewById(R.id.btn_Login);
		txt_Password = (TextView) findViewById(R.id.txt_Password);
		txt_Username = (TextView) findViewById(R.id.txt_Username);
		mainActivity = new Intent(this, MainActivity.class);

		Log.w(Constants.AppName, "Application Started");

		// Log.w("Internal", this.getFilesDir().toString());
		// Log.w("External", this.getExternalFilesDir("data").toString());

		btn_Login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),
						"Loading...", Toast.LENGTH_SHORT).show();
				startServiceLogin(txt_Username.getText().toString(),
						txt_Password.getText().toString());
			}
		});
	}

	private void startServiceLogin(String username, String password) {
		Intent intent = new Intent(this, WebServices.class);
		intent.putExtra(WebServices.WebServiceURL,
				"http://www.test.eye-egypt.com/ConferenceApp/Login.php?username="
						+ username + "&password=" + password);
		intent.putExtra(WebServices.RECEIVER, resultReceiver);
		this.startService(intent);
	}

	private final ResultReceiver resultReceiver = new ResultReceiver(
			new Handler()) {
		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {

			try {
				String jsonString = resultData.getString(WebServices.RESPONSE);
				Log.w("josn", jsonString);
				JSONObject json = new JSONObject(jsonString);
				Log.w("User Status", json.getString("status"));
				if (json.getString("status").equals("True")) {
					
					JSONObject UserData = json.getJSONArray("UserData")
							.getJSONObject(0);
					Log.w("User ID", UserData.getString("id"));
					Log.w("User Name", UserData.getString("name"));
					Log.w("User Title", UserData.getString("title"));

					CommonUtilities.putInSharedPreferences(getApplicationContext(), Constants.UserId, UserData.getString("id"));
					CommonUtilities.putInSharedPreferences(getApplicationContext(), Constants.UserName, UserData.getString("name"));
					
					startActivity(mainActivity);
					finish();
				} else {
					Toast.makeText(getApplicationContext(),
							"Wrong Credentials", Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		};
	};

}
