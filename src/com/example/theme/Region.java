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
		if (name.equals("��⵵")) {
			listName.add("���� �絿 ���\nõ����买 �� 8 ȣ");
			listName.add("���� ����� ���\nõ����买 �� 9 ȣ");
			listName.add("�빮�� ���೪��\nõ����买 �� 30 ȣ");
			listName.add("��õ ���θ� �κμ�\nõ����买 �� 460ȣ");
			listImage.add(R.drawable.t8);
			listImage.add(R.drawable.t9);
			listImage.add(R.drawable.t30);
			listImage.add(R.drawable.t460);
		} else if (name.equals("�泲")) {
			listName.add("���� ������ ��ϼ���\nõ����买 �� 29ȣ");
			listName.add("�Ծ� ��\nõ����买 �� 154ȣ");
			listName.add("���� õ� ���˳���\nõ����买 �� 307ȣ");
			listName.add("�Ƿ� �� ������\nõ����买 �� 492ȣ");
			listImage.add(R.drawable.t29);
			listImage.add(R.drawable.t154);
			listImage.add(R.drawable.t307);
			listImage.add(R.drawable.t492);
		} else if (name.equals("����")) {
			listName.add("�强 ���� ���ڳ��� ��\nõ����买 �� 153ȣ");
			listName.add("��õ ���ϻ� ���ϸ�\nõ����买 �� 488ȣ");
			listImage.add(R.drawable.t153);
			listImage.add(R.drawable.t488);
		}
	}

}
