package com.eye_egypt.conferenceapp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.eye_egypt.conferenceapp.R;

public class HtmlActivity extends Activity {
	private static final String TAG = null;
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_html);
		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		WebSettings ws = webView.getSettings();

		ws.setJavaScriptEnabled(true);
		ws.setAllowFileAccess(true);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
			try {
				Log.d(TAG, "Enabling HTML5-Features");
				Method m1 = WebSettings.class.getMethod("setDomStorageEnabled",
						new Class[] { Boolean.TYPE });
				m1.invoke(ws, Boolean.TRUE);

				Method m2 = WebSettings.class.getMethod("setDatabaseEnabled",
						new Class[] { Boolean.TYPE });
				m2.invoke(ws, Boolean.TRUE);

				Method m3 = WebSettings.class.getMethod("setDatabasePath",
						new Class[] { String.class });
				m3.invoke(ws, "/data/data/" + getPackageName() + "/databases/");

				Method m4 = WebSettings.class.getMethod("setAppCacheMaxSize",
						new Class[] { Long.TYPE });
				m4.invoke(ws, 1024 * 1024 * 8);

				Method m5 = WebSettings.class.getMethod("setAppCachePath",
						new Class[] { String.class });
				m5.invoke(ws, "/data/data/" + getPackageName() + "/cache/");

				Method m6 = WebSettings.class.getMethod("setAppCacheEnabled",
						new Class[] { Boolean.TYPE });
				m6.invoke(ws, Boolean.TRUE);
				Log.d(TAG, "Enabled HTML5-Features");
			} catch (NoSuchMethodException e) {
				Log.e(TAG, "Reflection fail", e);
			} catch (InvocationTargetException e) {
				Log.e(TAG, "Reflection fail", e);
			} catch (IllegalAccessException e) {
				Log.e(TAG, "Reflection fail", e);
			}
		}
		webView.loadUrl(getIntent().getExtras().getString(
				"PresentationFilePath"));
		// webView.loadUrl("http://www.test.eye-egypt.com/ergame4/game.html");
	}
}
