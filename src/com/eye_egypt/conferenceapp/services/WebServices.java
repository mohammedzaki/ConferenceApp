package com.eye_egypt.conferenceapp.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

import com.eye_egypt.conferenceapp.utilities.Constants;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class WebServices extends IntentService {
	public static final String WebServiceURL = "WebServiceURL";
	public static final String RESPONSE = "response";
	public static final String RECEIVER = "receiver";

	public WebServices() {
		super("WebServices");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d(Constants.AppName, "Service started");
		String response = "";
		try {
			Log.d(Constants.AppName + ": Call WebService", intent.getStringExtra(WebServiceURL));
			response = convertToString(getInputStream(intent.getStringExtra(WebServiceURL)));
		} catch (IOException e) {
			Log.e(Constants.AppError, e.getMessage(), e);
		}
		Bundle bundle = new Bundle();
		bundle.putString(RESPONSE, response);
		ResultReceiver receiver = intent.getParcelableExtra(RECEIVER);
		receiver.send(0, bundle);
	}

	public InputStream getInputStream(String link) {
		try {
			URL url = new URL(link);
			return url.openConnection().getInputStream();
		} catch (IOException e) {
			Log.e(Constants.AppError, "Exception while retrieving the input stream",
					e);
			return null;
		}
	}

	public String convertToString(InputStream inputStream) throws IOException {
		if (inputStream != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(
						inputStream, "UTF-8"), 1024);
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				inputStream.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
}