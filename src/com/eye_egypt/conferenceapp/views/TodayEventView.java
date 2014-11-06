package com.eye_egypt.conferenceapp.views;

import com.eye_egypt.conferenceapp.R;
import com.eye_egypt.conferenceapp.services.DownloadImageTask;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TodayEventView extends LinearLayout {

	public TodayEventView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public TodayEventView(Context context) {
		this(context, null);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.todayevent, this, true);
	}

	public void setImageView(String image_url) {
		new DownloadImageTask((ImageView) findViewById(R.id.TodayEventImageView))
				.execute(image_url);
	}

	public void setEventTitle1(String title) {
		((TextView) findViewById(R.id.TodayEventTitle1)).setText(title);
	}

	public void setEventTitle2(String title) {
		((TextView) findViewById(R.id.TodayEventTitle2)).setText(title);
	}

	public void setEventTitle3(String title) {
		((TextView) findViewById(R.id.TodayEventTitle3)).setText(title);
	}

}
