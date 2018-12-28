package com.example.theme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startActivity(new Intent(this, Loading.class));
		Button bt = (Button)findViewById(R.id.findname);
		bt.setOnClickListener(this);
		TextView tv1 = (TextView) findViewById(R.id.gunggi);
		TextView tv2 = (TextView) findViewById(R.id.gangwon);
		TextView tv3 = (TextView) findViewById(R.id.chungnam);
		TextView tv4 = (TextView) findViewById(R.id.chungbuck);
		TextView tv5 = (TextView) findViewById(R.id.gungbuck);
		TextView tv6 = (TextView) findViewById(R.id.junbuck);
		TextView tv7 = (TextView) findViewById(R.id.junnam);
		TextView tv8 = (TextView) findViewById(R.id.gungnam);
		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);
		tv4.setOnClickListener(this);
		tv5.setOnClickListener(this);
		tv6.setOnClickListener(this);
		tv7.setOnClickListener(this);
		tv8.setOnClickListener(this);
		Button find = (Button) findViewById(R.id.findname);
		find.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent init = new Intent(this, Region.class);
		switch (v.getId()) {
		case R.id.gunggi:
			init.putExtra("selectedregion", "경기도");
			startActivity(init);
			break;
		case R.id.gangwon:
			init.putExtra("selectedregion", "강원도");
			startActivity(init);
			break;
		case R.id.chungnam:
			init.putExtra("selectedregion", "충남");
			startActivity(init);
			break;
		case R.id.chungbuck:
			init.putExtra("selectedregion", "충북");
			startActivity(init);
			break;
		case R.id.gungbuck:
			init.putExtra("selectedregion", "경북");
			startActivity(init);
			break;
		case R.id.junbuck:
			init.putExtra("selectedregion", "전북");
			startActivity(init);
			break;
		case R.id.junnam:
			init.putExtra("selectedregion", "전남");
			startActivity(init);
			break;
		case R.id.gungnam:
			init.putExtra("selectedregion", "경남");
			startActivity(init);
			break;
		case R.id.findname:
			EditText search = (EditText)findViewById(R.id.inputname);
			init = new Intent(this,Search.class);
			init.putExtra("result", search.getText().toString());
			startActivity(init);
			break;
		default:
			break;
		}

	}

}
