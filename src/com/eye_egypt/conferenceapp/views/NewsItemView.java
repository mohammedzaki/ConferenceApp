package com.eye_egypt.conferenceapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

import com.eye_egypt.conferenceapp.R;
import com.eye_egypt.conferenceapp.services.DownloadImageTask;
import com.eye_egypt.conferenceapp.services.ExecuteServerTask;

public class NewsItemView extends LinearLayout {

	public NewsItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public String PostId = "";
	public String UserId = "";
	private String Url = "";

	public NewsItemView(Context context) {
		this(context, null);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.newsitem, this, true);
		//PostId = "1";
		UserId = "1";
		((RatingBar) findViewById(R.id.ratingBar1))
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float rating, boolean fromUser) {
						Url = "http://www.test.eye-egypt.com/ConferenceApp/SetNewsRating.php?userid="
								+ UserId
								+ "&postid="
								+ PostId
								+ "&rating="
								+ rating;
						Log.w("SetNewsRating", Url);

						new ExecuteServerTask("News").execute(Url);
					}
				});
	}

	public void setImageView(String image_url) {
		new DownloadImageTask((ImageView) findViewById(R.id.newsImageViewbg))
				.execute(image_url);
	}

	public void setNewsTitle(String title) {
		((TextView) findViewById(R.id.NewsTitle)).setText(title);
	}

	public void setNewsContent(String content) {
		((TextView) findViewById(R.id.NewsContent)).setText(content);
	}

	public void setNewsRating(Float rate) {
		((RatingBar) findViewById(R.id.ratingBar1)).setRating(rate);
	}

}
