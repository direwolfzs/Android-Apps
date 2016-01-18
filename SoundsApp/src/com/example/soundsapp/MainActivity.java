package com.example.soundsapp;
// Paste below the package name on line 1
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	private ImageButton bugs;
	private ImageButton daffey;
	private ImageButton marvin;
	private ImageButton spike;
	private ImageButton taz;
	private ImageButton tweety;
	private Button stopButton;
	
	private MediaPlayer soundPlayer [] = new MediaPlayer[6];
	private int[] soundResources = {R.raw.whatsupdoc, R.raw.daffy, R.raw.marvin, R.raw.spike, R.raw.tasmanian, R.raw.tweety, 
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Bind ImageButton and button fields to XML
		bugs = (ImageButton)findViewById(R.id.bugs);
		daffey= (ImageButton)findViewById(R.id.daffey);
		marvin= (ImageButton)findViewById(R.id.marvin);
		spike= (ImageButton)findViewById(R.id.spike);
		taz= (ImageButton)findViewById(R.id.taz);
		tweety= (ImageButton)findViewById(R.id.tweety);
		stopButton=(Button)findViewById(R.id.stopButton);
		
		//Initializes the mediaPlayer objects and assign them
		//seconds from the raw folder
		soundPlayer[0] = MediaPlayer.create(this, soundResources[0]);
		soundPlayer[1] = MediaPlayer.create(this, soundResources[1]);
		soundPlayer[2] = MediaPlayer.create(this, soundResources[2]);
		soundPlayer[3] = MediaPlayer.create(this, soundResources[3]);
		soundPlayer[4] = MediaPlayer.create(this, soundResources[4]);
		soundPlayer[5] = MediaPlayer.create(this, soundResources[5]);
	}
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	//function to play sounds
	public void buttonBugsClick(View v){
		soundPlayer[0].start(); //starts the sound
	}
	//Functions to play sounds
	public void buttonDaffeyClick(View v) {
		soundPlayer[1].start();
	}
	
	public void buttonMarvinClick(View v) {
		soundPlayer[2].start();
	}
	
	public void buttonSpikeClick(View v) {
		soundPlayer[3].start();
	}
	
	public void buttonTazClick(View v) {
		soundPlayer[4].start();
	}
	
	public void buttonTweetyClick(View v) {
		soundPlayer[5].start();
	}
	
	public void stopAllSounds(View v){
		//iterate through all sounds
		for (int s = 0; s < soundPlayer.length; s++)
		{
			if(soundPlayer[s].isPlaying()){
				soundPlayer[s].pause();
				soundPlayer[s].seekTo(0);
			}
		}
	}
}
	
	

