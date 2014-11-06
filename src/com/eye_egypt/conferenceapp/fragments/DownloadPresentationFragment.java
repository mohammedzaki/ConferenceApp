package com.eye_egypt.conferenceapp.fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.eye_egypt.conferenceapp.services.WebServices;
import com.eye_egypt.conferenceapp.utilities.Constants;
import com.eye_egypt.conferenceapp.views.PresentationItemView;

public class DownloadPresentationFragment extends Fragment {

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
		SharedPreferences sp = this.getActivity().getSharedPreferences(
				Constants.AppPreferences, Context.MODE_PRIVATE);
		String userId = sp.getString(Constants.UserId, "-1");

		intent.putExtra(WebServices.WebServiceURL,
				"http://www.test.eye-egypt.com/ConferenceApp/GetPresentations.php?userid="
						+ userId);

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

				JSONArray jsonArray = json.getJSONArray("Presentations");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject;

					jsonObject = jsonArray.getJSONObject(i);

					PresentationItemView item = new PresentationItemView(
							getActivity());
					item.setPresentationId(jsonObject.getString("id"));
					
					//
					SharedPreferences sp = getActivity().getSharedPreferences(
							Constants.AppPreferences, Context.MODE_PRIVATE);
					String userId = sp.getString(Constants.UserId, "-1");
					item.setUserId(userId);
					
					item.setPresentationTitle(jsonObject.getString("title"));

					item.setPresentationThump("http://www.test.eye-egypt.com/ConferenceApp/presentation/"
							+ jsonObject.getString("name")
							+ "/"
							+ jsonObject.getString("thumb_url"));

					item.setPresentationName(jsonObject.getString("name"));
					layout.addView(item, layoutParams);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scrollView.addView(layout);

		};
	};

}
