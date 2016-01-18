package com.example.texttospeech;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener{
	private EditText enterText;  //instance of editText
	private Button button1; //instance of speechButton
	private TextToSpeech speaker; //does the talking
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//Binding enterText and speechButton
		enterText = (EditText) findViewById(R.id.enterText);
		button1 = (Button) findViewById(R.id.speechButton);
		speaker = new TextToSpeech(this, this);
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
	}
	
		public void speak(View v) {
			speaker.speak("Hello", 1, null);
			String phrase = enterText.getText().toString();
			
		}
	}
