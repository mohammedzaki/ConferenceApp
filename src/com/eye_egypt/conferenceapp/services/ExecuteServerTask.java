package com.eye_egypt.conferenceapp.services;

import java.io.InputStream;

import android.os.AsyncTask;
import android.util.Log;

public class ExecuteServerTask extends AsyncTask<String, Void, String> {
	String result;

    public ExecuteServerTask(String Task) {
        this.result = Task;
    }

    @Override
	protected String doInBackground(String... urls) {
        String urldisplay = urls[0];
        String res = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            res = in.toString();
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    @Override
	protected void onPostExecute(String result) {
    	this.result = result;
    }

}