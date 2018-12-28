package com.example.theme;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class SpecInfo extends Activity implements OnClickListener {

	VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.specinfo);
		Button setting = (Button) findViewById(R.id.setting);
		setting.setOnClickListener(this);
		Button backkey = (Button) findViewById(R.id.backkey);
		backkey.setOnClickListener(this);
		TextView tv = (TextView) findViewById(R.id.region);
		String temp = getIntent().getStringExtra("region");
		tv.setText(temp);
		vv = (VideoView) findViewById(R.id.video);
		Uri uri = Uri.parse("android.resource://com.example.theme/"
				+ R.drawable.video02);
		MediaController mc = new MediaController(this,false);
		vv.setMediaController(mc);
		vv.setVideoURI(uri);
		vv.start();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.backkey:
			finish();
			break;
		case R.id.setting:
			Intent init = new Intent(this, Setup.class);
			init.putExtra("region", getIntent().getStringExtra("region"));
			startActivity(init);
			break;

		}

	}
}
