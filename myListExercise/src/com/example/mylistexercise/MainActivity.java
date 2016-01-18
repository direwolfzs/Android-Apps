package com.example.mylistexercise;

// Paste below the package name on line 1
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView; // display
	private ListView listView;// hold our list of strings
	private List<String> myList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView) findViewById(R.id.textView);
		listView = (ListView)findViewById(R.id.listView);
		myList = new ArrayList<String>(0);
		myList.add("Hello Mr. Michaud");
		myList.add("Antoher line of text");
		myList.add("Hey! It's Friday!!!");
		
		//Create an ArrayAdapter object
		//Take the String list and convert so it fits into listView object
		ArrayAdapter adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, myList);
		
	listView.setAdapter(adapter);
	listView.setOnItemClickListener(listener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

		private OnItemClickListener listener = new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, 
					long id) {
				String result = myList.get(position);
				textView.setText(result);
			}
			
		};
}
				
			
		