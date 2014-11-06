package com.eye_egypt.conferenceapp.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ProgressBar;

import com.eye_egypt.conferenceapp.R;
import com.eye_egypt.conferenceapp.database.DatabaseHandler;
import com.eye_egypt.conferenceapp.database.LibraryItems;
import com.eye_egypt.conferenceapp.utilities.Constants;
import com.eye_egypt.conferenceapp.utilities.ZipFile;

public class DownloadPeresntation extends Activity {

	// Progress Dialog
	private ProgressBar pBar;
	private DownloadFileFromURL downloadFileFromURL;
	private DatabaseHandler db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		db = new DatabaseHandler(this);
		setContentView(R.layout.download_peresntation);

		pBar = (ProgressBar) findViewById(R.id.progressBar152);

		Log.d("PresentationName",
				getIntent().getExtras().getString("PresentationName"));
		downloadFileFromURL = new DownloadFileFromURL();
		downloadFileFromURL.execute(getIntent().getExtras().getString(
				"PresentationName"));
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
				&& keyCode == KeyEvent.KEYCODE_BACK
				&& event.getRepeatCount() == 0) {
			Log.w("CDA", "onKeyDown Called");
			// onBackPressed();
			downloadFileFromURL.cancel(false);
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		Log.w("CDA", "onBackPressed Called");
		downloadFileFromURL.cancel(false);
		return;
	}

	/**
	 * Background Async Task to download file
	 * */
	protected class DownloadFileFromURL extends
			AsyncTask<String, Integer, String> {

		/**
		 * Before starting background thread Show Progress Bar Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pBar.setMax(100);
		}

		/**
		 * Downloading file in background thread
		 * */
		@Override
		protected String doInBackground(String... PresentationName) {
			int count;
			try {
				URL url = new URL(
						"http://www.test.eye-egypt.com/ConferenceApp/presentation/"
								+ PresentationName[0] + "/"
								+ PresentationName[0] + ".zip");

				URLConnection conection = url.openConnection();
				conection.connect();

				// this will be useful so that you can show a tipical 0-100%
				// progress bar
				int lenghtOfFile = conection.getContentLength();

				// download the file
				InputStream input = new BufferedInputStream(url.openStream(),
						8192);
				// create a File object for the parent directory
				File presentationDirectory = new File(getFilesDir().toString()
						+ "/Presentation/");
				// have the object build the directory structure, if needed.
				presentationDirectory.mkdirs();
				// create a File object for the output file
				File outputFile = new File(presentationDirectory,
						PresentationName[0] + ".zip");

				// Output stream
				OutputStream output = new FileOutputStream(outputFile);

				byte data[] = new byte[1024];

				long total = 0;

				while ((count = input.read(data)) != -1) {
					total += count;
					// publishing the progress....
					// After this onProgressUpdate will be called
					publishProgress((int) ((total * 100) / lenghtOfFile));

					// writing data to file
					output.write(data, 0, count);
				}

				// flushing output
				output.flush();

				// closing streams
				output.close();
				input.close();

				Log.d("outputFile", outputFile.getAbsolutePath());
				Log.d("presentationDirectory",
						presentationDirectory.getAbsolutePath());

				ZipFile.unzip(outputFile.getAbsolutePath(),
						presentationDirectory.getAbsolutePath());

			} catch (Exception e) {
				Log.e(Constants.AppError, e.getMessage());
			}

			return null;
		}

		/**
		 * Updating progress bar
		 * */
		@Override
		protected void onProgressUpdate(Integer... progress) {
			// setting progress percentage
			pBar.setProgress(progress[0]);
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		@Override
		protected void onPostExecute(String file_url) {
			// dismiss the dialog after the file was downloaded
			SharedPreferences sp = getSharedPreferences(
					Constants.AppPreferences, Context.MODE_PRIVATE);
			String userId = sp.getString(Constants.UserId, "-1");
			String Url = "http://www.test.eye-egypt.com/ConferenceApp/SetPresentationStatus.php?userid="
					+ userId
					+ "&Presentationid="
					+ getIntent().getExtras().getString("PresentationId")
					+ "&status=" + 1;

			Log.d("SetPresentationStatus", Url);

			new ExecuteServerTask("SetPresentationStatus").execute(Url);

			db.addContact(new LibraryItems(getIntent().getExtras()
					.getString("PresentationName"), getIntent().getExtras()
					.getString("PresentationTitle")));

			finish();
		}

	}
}
