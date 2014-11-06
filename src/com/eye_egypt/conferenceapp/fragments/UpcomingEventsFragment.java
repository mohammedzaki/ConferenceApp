package com.eye_egypt.conferenceapp.fragments;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.eye_egypt.conferenceapp.services.WebServices;
import com.eye_egypt.conferenceapp.views.UpcomingEventView;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class UpcomingEventsFragment extends Fragment {

	private LinearLayout layout;
	private ScrollView scrollView;
	private LinearLayout.LayoutParams layoutParams;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment

		if (scrollView == null) {
			scrollView = new ScrollView(this.getActivity());
			startService();
		} else {
			ViewGroup parent = (ViewGroup) scrollView.getParent();
			parent.removeView(scrollView);
		}
		return scrollView;
	}

	private void startService() {
		Intent intent = new Intent(this.getActivity(), WebServices.class);
		intent.putExtra(WebServices.WebServiceURL,
				"http://www.test.eye-egypt.com/ConferenceApp/GetUpcomingEvents.php");
		intent.putExtra(WebServices.RECEIVER, resultReceiver);
		getActivity().startService(intent);
	}

	private final ResultReceiver resultReceiver = new ResultReceiver(
			new Handler()) {
		
		@SuppressWarnings("deprecation")
		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {

			layout = new LinearLayout(getActivity());
			layoutParams = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			layout.setOrientation(LinearLayout.VERTICAL);

			try {
				String jsonString = resultData.getString(WebServices.RESPONSE);
				Log.w("josn", jsonString);
				JSONObject json = new JSONObject(jsonString);

				JSONArray jsonArray = json.getJSONArray("UpcommingEvents");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject;

					jsonObject = jsonArray.getJSONObject(i);

					UpcomingEventView event = new UpcomingEventView(getActivity());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
					Date date = sdf.parse(jsonObject.getString("date"));
					event.setEventTitle1(jsonObject.getString("title_1"));
					event.setEventTitle2(jsonObject.getString("title_2"));
					event.setEventDate((date.getDay() + "-" + new DateFormatSymbols().getMonths()[date.getMonth()]));
					layout.addView(event, layoutParams);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scrollView.addView(layout);

		};
	};

}
