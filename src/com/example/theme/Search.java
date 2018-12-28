package com.example.theme;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Search extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		String result = getIntent().getStringExtra("result");
		EditText ed = (EditText) findViewById(R.id.inputname2);
		ed.setText(result);
		ArrayList<String> items = new ArrayList<String>();
		XmlPullParser customList = getResources().getXml(R.xml.culturelist);
		try {
			while (customList.getEventType() != XmlPullParser.END_DOCUMENT) {
				// 태그의 첫번째 속성일 때,
				if (customList.getEventType() == XmlPullParser.START_TAG) {
					// 이름이 "custom" 일때, 첫번째 속성값을 ArrayList에 저장
					if (customList.getName().equals("culture")) {
						items.add(customList.getAttributeValue(0));
					}

				}
				// 다음 태그로 이동
				customList.next();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		ListView listView1 = (ListView) findViewById(R.id.resultView);
		listView1.setAdapter(adapter);
		OnItemClickListener listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent init = new Intent(getApplicationContext(),SpecInfo.class);
				init.putExtra("region", ((TextView)arg1).getText().toString());
				startActivity(init);
			}
		};
		listView1.setOnItemClickListener(listener);
	}
}
