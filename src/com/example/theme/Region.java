package com.example.theme;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Region extends Activity {
	private GridViewAdapter adapter;
	private ArrayList<String> listName;
	private ArrayList<Integer> listImage;
	private GridView gridView;
	private String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.region);
		TextView tv = (TextView) findViewById(R.id.region);
		name = getIntent().getStringExtra("selectedregion");
		tv.setText(name);
		prepare();
		Button bt = (Button) findViewById(R.id.backkey);
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		adapter = new GridViewAdapter(this, listName, listImage);
		gridView = (GridView) findViewById(R.id.gridView2);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String[] temp = listName.get(arg2).split("\n");
				Intent init = new Intent(Region.this, SpecInfo.class);
				init.putExtra("region", temp[0]);
				startActivity(init);
			}
		});
	}

	public void prepare() {
		listName = new ArrayList<String>();
		listImage = new ArrayList<Integer>();
		if (name.equals("경기도")) {
			listName.add("서울 재동 백송\n천연기념물 제 8 호");
			listName.add("서울 조계사 백송\n천연기념물 제 9 호");
			listName.add("용문사 은행나무\n천연기념물 제 30 호");
			listName.add("포천 직두리 부부송\n천연기념물 제 460호");
			listImage.add(R.drawable.t8);
			listImage.add(R.drawable.t9);
			listImage.add(R.drawable.t30);
			listImage.add(R.drawable.t460);
		} else if (name.equals("경남")) {
			listName.add("남해 미조리 상록수림\n천연기념물 제 29호");
			listName.add("함양 상림\n천연기념물 제 154호");
			listName.add("김해 천곡리 이팝나무\n천연기념물 제 307호");
			listName.add("의령 백곡리 감나무\n천연기념물 제 492호");
			listImage.add(R.drawable.t29);
			listImage.add(R.drawable.t154);
			listImage.add(R.drawable.t307);
			listImage.add(R.drawable.t492);
		} else if (name.equals("전남")) {
			listName.add("장성 백양사 비자나무 숲\n천연기념물 제 153호");
			listName.add("순천 선암사 선암매\n천연기념물 제 488호");
			listImage.add(R.drawable.t153);
			listImage.add(R.drawable.t488);
		}
	}

}
