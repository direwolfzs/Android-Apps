package com.example.sitetracker;


import android.R;
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
//Fields
//Layout Home
private Button buttonTransition;
private Button buttonAdd;
private EditText EditTextUrl;
private EditText EditTextUsername;
private EditText EditTextPassword;
private EditText EditTextEmail;
 
 
 
//Layout Alternative
private Button buttonBack;
private Button buttonVisit;
private Button buttonCycle;
private EditText displayUrl;
private EditText displayUsername;
private EditText displayPassword;
private EditText displayEmail;
private TextView displayCountTotal;
private TextView displayCurrent;
 
 
 
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  
  screenHome();
 }

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
  // Inflate the menu; this adds items to the action bar if it is present.
 
  getMenuInflater().inflate(R.menu.main, menu);
  return true;
 }
 
 
 public void screenHome(){
  //set layout view
  setContentView(R.layout.activity_main);
  //set View object
  buttonTransition = (Button)findViewById(R.id.buttonTransition);
  buttonAdd = (Button)findViewById(R.id.buttonAdd);
  EditTextUrl = (EditText)findViewById(R.id.EditTextUrl);
  EditTextUsername = (EditText)findViewById(R.id.EditTextUsername);
  EditTextPassword = (EditText)findViewById(R.id.EditTextPassword);
  EditTextEmail = (EditText)findViewById(R.id.EditTextEmail);
 }//end function screenHome
 
 
 
 public void screenDatabase(){
  //set layout view
  setContentView(R.layout.second_activty);
  //set View object
  buttonVisit = (Button)findViewById(R.id.buttonVisit);
  buttonCycle = (Button)findViewById(R.id.buttonCycle);
  displayUrl = (EditText)findViewById(R.id.displayUrl);
  displayUsername = (EditText)findViewById(R.id.displayUsername);
  displayPassword = (EditText)findViewById(R.id.displayPassword);
  displayEmail = (EditText)findViewById(R.id.displayEmail);
  displayCountTotal = (TextView)findViewById(R.id.displayCountTotal);
  displayCurrent = (TextView)findViewById(R.id.displayCurrent);
  buttonBack = (Button)findViewById(R.id.buttonBack);
  
 }//end function screenHome
 
 
 public void clickSwitchHome(View w) {
  screenHome();
 }
 
 public void clickSwitchSecondPage(View w) {
  screenDatabase();
 }
 
 
 public void buttonAddClicked(View v) {
  Website w = new Website();
  w.setUrl(EditTextUrl.getText().toString());   //inputs into indexes 0,4,8 of websites arrayList
  w.setUser(EditTextUsername.getText().toString()); //inputs into indexes 1,5,9 of websites arrayList
  w.setEmail(EditTextEmail.getText().toString()); //inputs into indexes 2,6,10 of websites arrayList
  w.setPassword(EditTextPassword.getText().toString()); //inputs into indexes 3,7,11 of websites arrayList
  
  linkage.addWebsite(w);
  
  
  EditTextUrl.setText(null);
  EditTextUsername.setText(null);
  EditTextPassword.setText(null);
  EditTextEmail.setText(null);
  
  /*
  displayUrl.setText(websites.indexOf(0)); //only shows the first set of data
  displayUsername.setText(websites.indexOf(1)); //only shows the first set of data
  displayPassword.setText(websites.indexOf(2)); // only shows the first set of data
  displayEmail.setText(websites.indexOf(3));  //only shows the first set of data
*/
  
 }



 
 
public void buttonVisit(View v){
 if (!displayUrl.getText().toString().startsWith("https://") && !displayUrl.getText().toString().startsWith("http://")){
     String url = "http://" + displayUrl.getText().toString();
 }
 Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(displayUrl.getText().toString()));
 startActivity(openUrlIntent);
}

/*
myEditText.setOnFocusListener(new OnFocusListener(){
   public void onFocus(){
     myEditText.setHint("");
     EditTextUrl.setHint("");
     EditTextUsername.setHint("");
     EditTextPassword.setHint("");
     EditTextEmail.setHint("");
     displayUrl.setHint("");
     displayUsername.setHint("");
     displayPassword.setHint("");
     displayEmail.setHint("");
   }
 });
*/
}

 
 
 //Added deletion/reseting of EditTexts, hints in main and second activity, buttonVist to URL,
//and got screens to appear on second screen...
//Show displayCurrent and displayCountTotal, possibly get the cycle button to work if possible.