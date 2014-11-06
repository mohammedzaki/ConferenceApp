package com.eye_egypt.conferenceapp.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eye_egypt.conferenceapp.R;
import com.eye_egypt.conferenceapp.services.DownloadImageTask;
import com.eye_egypt.conferenceapp.services.DownloadPeresntation;

public class PresentationItemView extends LinearLayout {

	public PresentationItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	String presentationName = "";
	String presentationId = "";
	String userId = "";
	String presentationTitle = "";
	ImageButton btn_PresentationDownload;
	Intent downloadPeresntation;

	public PresentationItemView(Context context) {
		this(context, null);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.presentationitem, this, true);
		btn_PresentationDownload = (ImageButton) findViewById(R.id.btn_PresentationDownload);
		downloadPeresntation = new Intent(getContext(),
				DownloadPeresntation.class);

		btn_PresentationDownload.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				downloadPeresntation.putExtra("PresentationId", presentationId);
				downloadPeresntation.putExtra("UserId", userId);
				downloadPeresntation.putExtra("PresentationName",
						presentationName);
				downloadPeresntation.putExtra("PresentationTitle",
						presentationTitle);
				getContext().startActivity(downloadPeresntation);
			}
		});
	}

	public void setPresentationThump(String image_url) {
		new DownloadImageTask((ImageView) findViewById(R.id.img_thump))
				.execute(image_url);
	}

	public void setPresentationTitle(String title) {
		this.presentationTitle = title;
		((TextView) findViewById(R.id.presentationTitle)).setText(title);
	}

	public void setPresentationName(String name) {
		this.presentationName = name;
	}

	public void setPresentationId(String id) {
		this.presentationId = id;
	}

	public void setUserId(String id) {
		this.userId = id;
	}
}
