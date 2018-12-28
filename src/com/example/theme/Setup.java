package com.example.theme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Setup extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setup);
		Button backkey = (Button)findViewById(R.id.backkey);
		backkey.setOnClickListener(this);
		TextView tv = (TextView)findViewById(R.id.region);
		tv.setText(getIntent().getStringExtra("region"));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}

}
