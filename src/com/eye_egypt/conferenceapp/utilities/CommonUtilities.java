package com.eye_egypt.conferenceapp.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class CommonUtilities {

	public static String getFromSharedPreferences(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.AppPreferences, Context.MODE_PRIVATE);
		return sp.getString(key, "Not Exist");
	}

	public static void putInSharedPreferences(Context context, String key,
			String Value) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.AppPreferences, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(key, Value);
		editor.commit();
	}

	/**
	 * Notifies UI to display a message.
	 * <p>
	 * This method is defined in the common helper because it's used both by the
	 * UI and the background service.
	 * 
	 * @param context
	 *            application's context.
	 * @param message
	 *            message to be displayed.
	 */
	public static void displayMessage(Context context, String message) {
		Intent intent = new Intent(Constants.DISPLAY_MESSAGE_ACTION);
		intent.putExtra(Constants.EXTRA_MESSAGE, message);
		context.sendBroadcast(intent);
	}
}
