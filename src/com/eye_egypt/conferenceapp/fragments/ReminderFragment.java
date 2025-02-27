package com.eye_egypt.conferenceapp.fragments;

import com.eye_egypt.conferenceapp.views.ReminderView;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ReminderFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment

		//

		LinearLayout layout = new LinearLayout(this.getActivity());
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layout.setOrientation(LinearLayout.VERTICAL);
		ReminderView newsItem1 = new ReminderView(this.getActivity());

		layout.addView(newsItem1, layoutParams);
		ScrollView scrollView = new ScrollView(this.getActivity());
		scrollView.addView(layout);
		return scrollView;
	}

}
