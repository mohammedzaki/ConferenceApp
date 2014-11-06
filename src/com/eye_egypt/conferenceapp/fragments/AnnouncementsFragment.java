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

public class AnnouncementsFragment extends Fragment {

	Button btn_TodayEvents, btn_UpcomingEvents, btn_Reminder,
			btn_EntertainmentPlaces;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.announcements, null);

		btn_TodayEvents = (Button) v.findViewById(R.id.btn_TodayEvents);
		btn_UpcomingEvents = (Button) v.findViewById(R.id.btn_UpcomingEvents);
		btn_Reminder = (Button) v.findViewById(R.id.btn_Reminder);
		btn_EntertainmentPlaces = (Button) v.findViewById(R.id.btn_EntertainmentPlaces);

		switchFragment(R.id.announcements_container, new TodayEventsFragment(),
				"Today Events");

		btn_TodayEvents.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				switchFragment(R.id.announcements_container,
						new TodayEventsFragment(), "Today Events");
			}
		});
		
		btn_UpcomingEvents.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				switchFragment(R.id.announcements_container,
						new UpcomingEventsFragment(), "Upcoming Events");
			}
		});

		btn_Reminder.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				switchFragment(R.id.announcements_container,
						new ReminderFragment(), "Reminder");
			}
		});

		btn_EntertainmentPlaces.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				switchFragment(R.id.announcements_container,
						new EntertainmentPlacesFragment(), "Entertainment Places");
			}
		});
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