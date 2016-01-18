package com.example.pedometer;

// Paste below the package name on line 1
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Pedometer extends Activity {
	//Display Fields for Accelerometer
	private TextView textViewZ;
	private TextView textViewY;
	private TextView textViewX;
	
//Display Fields for sensitivity
	private TextView textSensitive;
	
	//Display for steps
	private TextView textViewSteps;
	
	//Reset Buttons
	private Button buttonReset;
	
	//Sensor Manager
	private SensorManager sensorManager;
	private float accelerator;
	
	//values to calculate number of steps
	private float previousY;
	private float currentY;
	private int numSteps;
	
	//Seekbar fields
	private SeekBar seekBar;
	private int threshold; //Point at which we want to trigger a step
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedometer);

		// bind to xml, so we can write values to them
		textViewX = (TextView) findViewById(R.id.textViewX);
		textViewY = (TextView) findViewById(R.id.textViewY);
		textViewZ = (TextView) findViewById(R.id.textViewZ);
		
		//Attach step and sensitive view objects to XML	
		textViewSteps= (TextView) findViewById(R.id.textSteps);
		textSensitive = (TextView) findViewById(R.id.textSensitive);
		
		//Attach resetButton to XML
		buttonReset = (Button)findViewById(R.id.buttonReset);
		
		//Attach the seekBar to XML
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		
		//set the values on the seekbar, threshold, and threshold display
		seekBar.setProgress(10);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
		threshold=10;
		textSensitive.setText(String.valueOf(threshold));
	
		//InitializesValues
		previousY = 0;
		currentY = 0; 
		numSteps = 0;
		
		//Initializes the accel values
		float acceleration = 0.00f;
		
		enableAccelerometerListening();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pedometer, menu);
		return true;
	}

	private void enableAccelerometerListening() {
		// Initialize the sensor manager
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorEventListener,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	// Define in inner class as the listener
	private SensorEventListener sensorEventListener = new SensorEventListener() {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			
			//gather values from accelerometer
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			//fetch y
			currentY=y;
			
			//measure if a step is taken
			if (Math.abs(currentY - previousY) > threshold){
				numSteps++;
				textViewSteps.setText(String.valueOf(numSteps));
			}
			
			//display the values
			textViewX.setText(String.valueOf(x));
			textViewY.setText(String.valueOf(y));
			textViewZ.setText(String.valueOf(z));
		
			
			previousY = y; 
		}
	}; //end private inner class
	
	
	//call by reset button to reset the step count and reset display
	public void resetSteps(View v) {
	numSteps = 0;
	textViewSteps.setText(String.valueOf(numSteps));
	
}
	
	private OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener()
	{
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
			//change from threshold
			threshold = seekBar.getProgress();
			
			//write textview
			textSensitive.setText(String.valueOf(threshold));
		}
		
		public void onStartTrackingTouch(SeekBar seekBar){
		}
		
		public void onStopTrackingTouch(SeekBar seekbar){
		
		}
	};
}
		
		

		//nebomusic.nets