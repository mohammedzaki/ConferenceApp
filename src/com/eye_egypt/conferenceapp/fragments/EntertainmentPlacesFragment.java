package com.eye_egypt.conferenceapp.fragments;

import com.eye_egypt.conferenceapp.views.EntertainmentPlaceView;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class EntertainmentPlacesFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment //

		LinearLayout layout = new LinearLayout(this.getActivity());
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layout.setOrientation(LinearLayout.VERTICAL);

		EntertainmentPlaceView Place1 = new EntertainmentPlaceView(this.getActivity());
		EntertainmentPlaceView Place2 = new EntertainmentPlaceView(this.getActivity());
		EntertainmentPlaceView Place3 = new EntertainmentPlaceView(this.getActivity());
		EntertainmentPlaceView Place4 = new EntertainmentPlaceView(this.getActivity());
		EntertainmentPlaceView Place5 = new EntertainmentPlaceView(this.getActivity());

		layout.addView(Place1, layoutParams);
		layout.addView(Place2, layoutParams);
		layout.addView(Place3, layoutParams);
		layout.addView(Place4, layoutParams);
		layout.addView(Place5, layoutParams);
		ScrollView scrollView = new ScrollView(this.getActivity());
		scrollView.addView(layout);
		return scrollView;
	}

}
