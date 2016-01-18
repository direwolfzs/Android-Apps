package com.example.sitetrackerprox;

// Paste below the package name on line 1
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	// Fields
	// Layout Home
	private Button buttonTransition;
	private Button buttonAdd;
	private EditText EditTextUrl;
	private EditText EditTextUsername;
	private EditText EditTextPassword;
	private EditText EditTextEmail;

	// Layout Alternative
	private Button buttonBack;
	private Button buttonVisit;
	private Button buttonCycle;
	private EditText displayUrl;
	private TextView displayUsername;
	private TextView displayPassword;
	private TextView displayEmail;
	private TextView displayCountTotal;
	private TextView displayCurrent;

	int match;
	Linkage linkage = new Linkage();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		screenHome();
	}

	private void screenHome() {
		// set layout view
		setContentView(R.layout.activity_main);
		// set View object
		buttonTransition = (Button) findViewById(R.id.buttonTransition);
		buttonAdd = (Button) findViewById(R.id.buttonAdd);
		EditTextUrl = (EditText) findViewById(R.id.EditTextUrl);
		EditTextUsername = (EditText) findViewById(R.id.EditTextUsername);
		EditTextPassword = (EditText) findViewById(R.id.EditTextPassword);
		EditTextEmail = (EditText) findViewById(R.id.EditTextEmail);

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void screenDatabase() {
		// set layout view
		setContentView(R.layout.second_activity);
		// set View object
		buttonVisit = (Button) findViewById(R
				.id.buttonVisit);
		buttonCycle = (Button) findViewById(R.id.buttonCycle);
		displayUrl = (EditText) findViewById(R.id.displayUrl);
		displayUsername = (TextView) findViewById(R.id.displayUsername);
		displayPassword = (TextView) findViewById(R.id.displayPassword);
		displayEmail = (TextView) findViewById(R.id.displayEmail);
		displayCountTotal = (TextView) findViewById(R.id.displayCountTotal);
		displayCurrent = (TextView) findViewById(R.id.displayCurrent);
		buttonBack = (Button) findViewById(R.id.buttonBack);

	}// end function screenHome

	public void clickSwitchHome(View w) {
		screenHome();
	}

	public void clickSwitchSecondPage(View w) {
		screenDatabase();
	}

	public void buttonAddClicked(View v) {
		Website w = new Website();
		w.setUrl(EditTextUrl.getText().toString());
		w.setUser(EditTextUsername.getText().toString());
		w.setEmail(EditTextEmail.getText().toString());
		w.setPassword(EditTextPassword.getText().toString());
		EditTextUrl.setText(null);
		EditTextUsername.setText(null);
		EditTextPassword.setText(null);
		EditTextEmail.setText(null);

		linkage.addWebsite(w);
	}
	
	

	public void displayContents(View v) {
		String url = displayUrl.getText().toString();
		for (int i = 0; i < linkage.getNumOfWebsites(); i++) {
			if (linkage.getWebsite(i).getUrl().equals(url)) {
				match = i;
			}
		}
		String password = linkage.getWebsite(match).getPassword();
		String username = linkage.getWebsite(match).getUser();
		String email = linkage.getWebsite(match).getEmail();
		displayPassword.setText(password);
		displayUsername.setText(username);
		displayEmail.setText(email);
	}
	
	public void storageDatabase(){
	String password = displayPassword.getText().toString();
	String username = displayUsername.getText().toString();
	String email = displayEmail.getText().toString();
	
	}

	public void websiteTransition(View v){
		String url = displayUrl.getText().toString();
		if (!url.startsWith("http://") && !url.startsWith("https://"))
			   url = "http://" + url;
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(browserIntent);
	}
}

