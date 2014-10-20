
package com.nadav.eliyahu.proj.scareselfie;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * This activity is the main activity of the application.
 * From this activity the user can get access to the camera view in order to take a self portrait photo (selfie).
 * in this early version of the application the user can only access the camera , take a photo , save it and get scared.
 * future version will include options to chose the picture or animation to scare and share the photo taken via social media .
 *  @author Nadav Eliyahu.
 */
public class ScareSelfie extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scare_selfie);
        final ImageButton ib =(ImageButton) findViewById(R.id.imageButton1);
        
        //check if the device has a camera hardware in it 
        if(isDeviceSupportCamera())
        {
        	//the image button to start the camera view activity 
			ib.setOnClickListener(new OnClickListener() 
			{
							
				@Override
				public void onClick(View v) 
				{
					//start the camera view activity to take picture
					startActivity(new Intent(ScareSelfie.this,CameraViewActivity.class)); //CameraViewActivity
				}
			});
        		
        	
        }
        //display a quick message to the user that he cannot use the application (later it will be a condition for downloading the application).
        else
        {
        	Toast toast=Toast.makeText(ScareSelfie.this, "This device is not compatible with the application", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
        }
    }

    /**
     * This method check if the device using the application has the ability to access the front facing camera
     * @return boolean value according to device compatibility
     */
    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.scare_selfie, menu);
        return true;
    }
    
}
