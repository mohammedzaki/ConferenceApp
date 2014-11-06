package com.eye_egypt.conferenceapp.fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.eye_egypt.conferenceapp.services.WebServices;
import com.eye_egypt.conferenceapp.views.TodayEventView;

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

public class TodayEventsFragment extends Fragment {

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
				"http://www.test.eye-egypt.com/ConferenceApp/GetTodayEvents.php");
		intent.putExtra(WebServices.RECEIVER, resultReceiver);
		getActivity().startService(intent);
	}

	private final ResultReceiver resultReceiver = new ResultReceiver(
			new Handler()) {
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

				JSONArray jsonArray = json.getJSONArray("TodayEvents");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject;

					jsonObject = jsonArray.getJSONObject(i);

					TodayEventView event = new TodayEventView(getActivity());

					event.setEventTitle1(jsonObject.getString("title_1"));
					event.setEventTitle2(jsonObject.getString("title_2"));
					event.setEventTitle3(jsonObject.getString("title_3"));
					event.setImageView(jsonObject.getString("img_url"));

					layout.addView(event, layoutParams);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scrollView.addView(layout);

		};
	};

}
