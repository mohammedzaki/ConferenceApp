package com.eye_egypt.conferenceapp;

import static com.eye_egypt.conferenceapp.utilities.Constants.DISPLAY_MESSAGE_ACTION;
import static com.eye_egypt.conferenceapp.utilities.Constants.EXTRA_MESSAGE;
import static com.eye_egypt.conferenceapp.utilities.Constants.SENDER_ID;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eye_egypt.conferenceapp.R;
import com.eye_egypt.conferenceapp.fragments.AnnouncementsFragment;
import com.eye_egypt.conferenceapp.fragments.NewsFragment;
import com.eye_egypt.conferenceapp.fragments.NotificationsFragment;
import com.eye_egypt.conferenceapp.fragments.PresentationFragment;
import com.eye_egypt.conferenceapp.fragments.VotingSystemFragment;
import com.eye_egypt.conferenceapp.notifications.WakeLocker;
import com.eye_egypt.conferenceapp.utilities.AlertDialogManager;
import com.eye_egypt.conferenceapp.utilities.CommonUtilities;
import com.eye_egypt.conferenceapp.utilities.ConnectionDetector;
import com.eye_egypt.conferenceapp.utilities.Constants;
import com.eye_egypt.conferenceapp.utilities.ServerUtilities;
import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	Button btn_Announcements, btn_News, btn_VotingSystem, btn_Notifications,
			btn_Presentation, btn_logout;
	Intent loginActivity;
	// label to display gcm messages
	TextView lblMessage;

	// Asyntask
	AsyncTask<Void, Void, Void> mRegisterTask;

	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();

	// Connection detector
	ConnectionDetector cd;

	public static String name;
	public static String email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		loginActivity = new Intent(this, LoginActivity.class);

		btn_Announcements = (Button) findViewById(R.id.btn_Announcements);
		btn_News = (Button) findViewById(R.id.btn_News);
		btn_VotingSystem = (Button) findViewById(R.id.btn_VotingSystem);
		btn_Notifications = (Button) findViewById(R.id.btn_Notifications);
		btn_Presentation = (Button) findViewById(R.id.btn_Presentation);
		btn_logout = (Button) findViewById(R.id.btn_logout);

		switchFragment(R.id.main_container, new NewsFragment(), "News");

		btn_Announcements.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				switchFragment(R.id.main_container,
						new AnnouncementsFragment(), "Announcements");
			}
		});
		btn_News.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switchFragment(R.id.main_container, new NewsFragment(), "News");
			}
		});
		btn_VotingSystem.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switchFragment(R.id.main_container, new VotingSystemFragment(),
						"News");
			}
		});
		btn_Notifications.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switchFragment(R.id.main_container,
						new NotificationsFragment(), "News");
			}
		});
		btn_Presentation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switchFragment(R.id.main_container, new PresentationFragment(),
						"News");
			}
		});

		btn_logout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(loginActivity);
				finish();
			}
		});
		
		cd = new ConnectionDetector(getApplicationContext());

		// Check if Internet present
		if (!cd.isConnectingToInternet()) {
			// Internet Connection is not present
			alert.showAlertDialog(MainActivity.this,
					"Internet Connection Error",
					"Please connect to working Internet connection", false);
			// stop executing code by return
			return;
		}

		name = CommonUtilities.getFromSharedPreferences(this, Constants.UserName);
		email = CommonUtilities.getFromSharedPreferences(this, Constants.UserId);
		
		// Make sure the device has the proper dependencies.
		GCMRegistrar.checkDevice(this);

		// Make sure the manifest was properly set - comment out this line
		// while developing the app, then uncomment it when it's ready.
		GCMRegistrar.checkManifest(this);

		//lblMessage = (TextView) findViewById(R.id.lblMessage);

		registerReceiver(mHandleMessageReceiver, new IntentFilter(
				DISPLAY_MESSAGE_ACTION));

		// Get GCM registration id
		final String regId = GCMRegistrar.getRegistrationId(this);
		// Log.w("regId", regId);

		// Check if regid already presents
		if (regId.equals("")) {
			// Registration is not present, register now with GCM
			GCMRegistrar.register(this, SENDER_ID);
		} else {
			// Device is already registered on GCM
			if (GCMRegistrar.isRegisteredOnServer(this)) {
				// Skips registration.
				Toast.makeText(getApplicationContext(),
						"Already registered with GCM", Toast.LENGTH_LONG)
						.show();
			} else {
				// Try to register again, but not in the UI thread.
				// It's also necessary to cancel the thread onDestroy(),
				// hence the use of AsyncTask instead of a raw thread.
				final Context context = this;
				mRegisterTask = new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						// Register on our server
						// On server creates a new user
						ServerUtilities.register(context, name, email, regId);
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						mRegisterTask = null;
					}

				};
				mRegisterTask.execute(null, null, null);
			}
		}
	}

	public void switchFragment(int fragment_containerId, Fragment frg,
			String tag) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.replace(fragment_containerId, frg, tag);
		fragmentTransaction.commit();
	}

	/**
	 * Receiving push messages
	 * */
	private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			//String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
			// Waking up mobile if it is sleeping
			WakeLocker.acquire(getApplicationContext());

			/**
			 * Take appropriate action on this message depending upon your app
			 * requirement For now i am just displaying it on the screen
			 * */

			// Showing received message
			//lblMessage.append(newMessage + "\n");
			//Toast.makeText(getApplicationContext(),
			//		"New Message: " + newMessage, Toast.LENGTH_LONG).show();

			// Releasing wake lock
			WakeLocker.release();
			switchFragment(R.id.main_container,
					new AnnouncementsFragment(), "Announcements");
		}
	};

	@Override
	protected void onDestroy() {
		if (mRegisterTask != null) {
			mRegisterTask.cancel(true);
		}
		try {
			unregisterReceiver(mHandleMessageReceiver);
			GCMRegistrar.onDestroy(this);
		} catch (Exception e) {
			Log.e("UnRegister Receiver Error", "> " + e.getMessage());
		}
		super.onDestroy();
	}

}
