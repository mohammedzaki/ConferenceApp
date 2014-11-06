package com.eye_egypt.conferenceapp.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.eye_egypt.conferenceapp.R;

public class PresentationFragment extends Fragment {

	Button btn_Download, btn_Library;
	//ImageView imageView1;
	//Intent mainActivity;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.presentation, null);

		btn_Download = (Button) v.findViewById(R.id.btn_Download);
		btn_Library = (Button) v.findViewById(R.id.btn_Library);
		//imageView1 = (ImageView) v.findViewById(R.id.imageView1);
		//mainActivity = new Intent(getActivity(), HtmlActivity.class);
		
		switchFragment(R.id.presentation_container, new DownloadPresentationFragment(), "Download");

		btn_Download.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switchFragment(R.id.presentation_container, new DownloadPresentationFragment(), "Download");
			}
		});

		btn_Library.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switchFragment(R.id.presentation_container, new LibraryPresentationFragment(), "Library");
			}
		});
		
		/*
		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				//switchFragment(R.id.announcements_container, new UpcomingEventsFragment(), "Library");
				startActivity(mainActivity);
				//finish();
			}
		});*/
		
		return v;
	}

	public void switchFragment(int fragment_containerId, Fragment frg,
			String tag) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.replace(fragment_containerId, frg, tag);
		fragmentTransaction.commit();
	}
}