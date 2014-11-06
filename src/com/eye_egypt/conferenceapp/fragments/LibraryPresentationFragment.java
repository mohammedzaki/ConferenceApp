package com.eye_egypt.conferenceapp.fragments;

import java.util.List;

import com.eye_egypt.conferenceapp.database.DatabaseHandler;
import com.eye_egypt.conferenceapp.database.LibraryItems;
import com.eye_egypt.conferenceapp.views.LibraryItemView;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class LibraryPresentationFragment extends Fragment {

	private LinearLayout layout;
	private ScrollView scrollView;
	private LinearLayout.LayoutParams layoutParams;
	private DatabaseHandler db;

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
			layout = new LinearLayout(getActivity());
			layoutParams = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			layout.setOrientation(LinearLayout.VERTICAL);
			db = new DatabaseHandler(this.getActivity());
			// Reading all contacts
			Log.d("Reading: ", "Reading all contacts..");
			List<LibraryItems> libraryItems = db.getAllContacts();

			for (LibraryItems LI : libraryItems) {
				String log = "Id: " + LI.getID() + " ,Name: " + LI.getName()
						+ " ,Title: " + LI.getTitle();
				// Writing Contacts to log
				Log.d("Name: ", log);

				LibraryItemView item = new LibraryItemView(getActivity());

				// item.setPresentationId(LI.getID());
				// item.setUserId(jsonObject.getString("user_id"));

				item.setPresentationTitle(LI.getTitle());

				item.setPresentationThump("file:///"
						+ this.getActivity().getFilesDir().toString()
						+ "/Presentation/" + LI.getName() + "/thumb.jpg");

				item.setPresentationName(LI.getName());

				layout.addView(item, layoutParams);
			}
			scrollView.addView(layout);
		} else {
			ViewGroup parent = (ViewGroup) scrollView.getParent();
			parent.removeView(scrollView);
		}
		return scrollView;
	}
}
