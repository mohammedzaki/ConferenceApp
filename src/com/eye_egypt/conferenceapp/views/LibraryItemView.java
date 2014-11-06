package com.eye_egypt.conferenceapp.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eye_egypt.conferenceapp.HtmlActivity;
import com.eye_egypt.conferenceapp.R;
import com.eye_egypt.conferenceapp.services.DownloadImageTask;

public class LibraryItemView extends LinearLayout {

	public LibraryItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	String presentationName = "";
	String presentationId = "";
	String userId = "";
	String libraryTitle = "";
	ImageView btn_ViewPresentation;
	Intent intentViewPeresntation;

	public LibraryItemView(Context context) {
		this(context, null);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.libraryitem, this, true);
		intentViewPeresntation = new Intent(getContext(),
				HtmlActivity.class);

		btn_ViewPresentation = (ImageView) findViewById(R.id.btn_ViewPresentation);
		btn_ViewPresentation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = "file:///"
						+ getContext().getFilesDir().toString()
						+ "/Presentation/" + presentationName + "/scene.html";
				//intentViewPeresntation = 
				intentViewPeresntation.putExtra("PresentationFilePath",
						filePath);
				getContext().startActivity(intentViewPeresntation);
			}
		});
	}

	public void setPresentationThump(String image_url) {
		new DownloadImageTask(
				(ImageView) findViewById(R.id.btn_ViewPresentation))
				.execute(image_url);
	}

	public void setPresentationTitle(String title) {
		this.libraryTitle = title;
		((TextView) findViewById(R.id.libraryTitle)).setText(title);
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
