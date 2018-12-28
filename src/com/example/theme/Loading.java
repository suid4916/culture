package com.example.theme;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends Activity {
	
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.loading);
		
		Handler hd = new Handler();
		hd.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
			}
		}, 2000);
	}

}
