package com.example.lastnamebouncing2;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	
	private Paint paint; // For Text

	
	// Breakout Actors
	private Actor paddle;
	private Actor ball;
	

	
	// values to hold the Accel Data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;
	
	// Create the Handler for animation
	private Handler h;
	private int RATE = 30;  // about 30 Frames a Second
	
	private boolean isRunning; // whether the animation runs

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		isRunning = true;
		
		// Breakout Actors
		ball = new Actor(context, 200, 500, Color.BLUE, 25);
		paddle = new Actor(context, 300, 300, Color.RED, 40);
		
		paddle.setWidth(150);
		paddle.setHeight(40);
		
		ball.setDX(10);
		ball.setDY(10);
		
		paint = new Paint(); // Initialize Paint
		paint.setColor(Color.RED); // Set color to RED
		paint.setTextSize(100);
		
		
		// Initialize the Handler
		h = new Handler();
		
	} // end onCreate
	
	// Create the onDraw Method - in all View Classes
	public void onDraw(Canvas c) {
		// Actors for Breakout
		
		paddle.drawRect(c);
		ball.drawCircle(c);
		
		
		ball.move();
		ball.bounce(c);
		if (ball.isTouching(paddle)) {
			ball.bounceUp();
		}

		if (isRunning) {
		// Call the Runnable for Animation
			h.postDelayed(r, RATE);
		}
		
		//String total = String.valueOf(paddle.getScore()) + " - " + String.valueOf(paddle2.getScore());
		//c.drawText(total, 100, 100, paint);
		
		
	} // End onDraw
	
	// Create the Runnable
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// Call the Invalidate Method to reDraw
			invalidate();
		}
		
	};
	
	// Function to Grab touch event data
	public boolean onTouchEvent(MotionEvent event) {
		// Fetch data from touch event
		int action = event.getActionMasked(); // get type of action
		int actionIdex = event.getActionIndex(); // get index of action
		
		// set Position of paddle to touch data
		paddle.goTo((int)event.getX(), 750); 
		
		return true;
	} // end onTouchEvent

	// Modifier fields for acceleration data on x, y, and z
	public void setAX(float x) {
		ax = x;
	}
	
	public void setAY(float y) {
		ay = y;
	}
	
	public void setAZ(float z) {
		az = z;
	}
	
	

} // end class AnimationView

