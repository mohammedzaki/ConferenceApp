package com.eye_egypt.conferenceapp.fragments;

import com.eye_egypt.conferenceapp.views.VotingSystemItemView;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class VotingSystemFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment

		//

		LinearLayout layout = new LinearLayout(this.getActivity());
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		VotingSystemItemView votingItem1 = new VotingSystemItemView(this.getActivity());
		VotingSystemItemView votingItem2 = new VotingSystemItemView(this.getActivity());
		VotingSystemItemView votingItem3 = new VotingSystemItemView(this.getActivity());
		VotingSystemItemView votingItem4 = new VotingSystemItemView(this.getActivity());
		VotingSystemItemView votingItem5 = new VotingSystemItemView(this.getActivity());

		layout.addView(votingItem1, layoutParams);
		layout.addView(votingItem2, layoutParams);
		layout.addView(votingItem3, layoutParams);
		layout.addView(votingItem4, layoutParams);
		layout.addView(votingItem5, layoutParams);
		ScrollView scrollView = new ScrollView(this.getActivity());
		scrollView.addView(layout);
		return scrollView;
	}

}
