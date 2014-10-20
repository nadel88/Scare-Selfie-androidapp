package com.nadav.eliyahu.proj.scareselfie;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

/**
 * This activity start after taking the photo.
 * All this activity does is it shows a picture or animation(future version) and plays a sound to scare the person who is taking the picture.
 * This activity has an @see ImageView as the picture and @see MediaPlayer object  for sound effects.
 * @author Nadav Eliyahu.
 *
 */
public class ScaryPicture extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scary_picture);
		
		//sound effect for the scary picture
		MediaPlayer mp = MediaPlayer.create(this, R.raw.deathscream);
		mp.start();
		
		//set duration for the activity
		new Thread(new Runnable()
		{

			@Override
			public void run() {
				// TODO delay the taking photo operation 
				try {					
					Thread.sleep(2000);					
					startActivity(new Intent(ScaryPicture.this,ScareSelfie.class));
					finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scary_picture, menu);
		return true;
	}

}
