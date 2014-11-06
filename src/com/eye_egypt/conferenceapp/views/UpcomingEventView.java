package com.eye_egypt.conferenceapp.views;

import com.eye_egypt.conferenceapp.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UpcomingEventView extends LinearLayout {

	public UpcomingEventView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public UpcomingEventView(Context context) {
		this(context, null);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.upcomingevent, this, true);
	}
	

	public void setEventTitle1(String title) {
		((TextView) findViewById(R.id.UpcomingEventTitle1)).setText(title);
	}

	public void setEventTitle2(String title) {
		((TextView) findViewById(R.id.UpcomingEventTitle2)).setText(title);
	}

	public void setEventDate(String title) {
		((TextView) findViewById(R.id.UpcomingEventDate)).setText(title);
	}
}
