package com.eye_egypt.conferenceapp.views;

import com.eye_egypt.conferenceapp.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ReminderView extends LinearLayout {

	public ReminderView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public ReminderView(Context context) {
		this(context, null);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.reminder, this, true);
	}
}
