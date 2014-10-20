package com.nadav.eliyahu.proj.scareselfie;

import java.io.IOException;
import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * This Class implements the camera surface for using the camera hardware API in the application .
 * This class implements @see SurfaceHolder.Callback so we can be notified of when the surface is created or destroyed.
 * This surface class tells the camera where to draw the image and take care of releasing the camera preview when the camera is no longer needed.
 * @author Nadav Eliyahu.
 *
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	
	    private SurfaceHolder mHolder;
	    private Camera mCamera;

	    /**
	     * This is the Constructor for the CameraSurfaceView Class.
	     * This Constructor instantiate the Camera object .
	     * @param context The context of this class
	     * @param camera  The Camera object needed for using the camera hardware.
	     */
	    public CameraSurfaceView(Context context, Camera camera) {
	        super(context);
	        mCamera = camera;

	        // Install a SurfaceHolder.Callback so we get notified when the
	        // underlying surface is created and destroyed.
	        mHolder = getHolder();
	        mHolder.addCallback(this);
	        // deprecated setting, but required on Android versions prior to 3.0
	        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	    }

	    /**
	     * This method creates the surface for the camera view and tells the camera where to draw the preview.
	     * @param holder The holder is the object that hold the display surface .
	     */
	    public void surfaceCreated(SurfaceHolder holder) {
	        // The Surface has been created, now tell the camera where to draw the preview.
	        try {
	            mCamera.setPreviewDisplay(holder);
	            mCamera.startPreview();
	        } catch (IOException e) {
	            Log.d("ERROR", "Error setting camera preview: " + e.getMessage());
	        }
	    }

	    
	    public void surfaceDestroyed(SurfaceHolder holder) {
	        // empty. Take care of releasing the Camera preview in your activity.
	    }

	    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
	        // If your preview can change or rotate, take care of those events here.
	        // Make sure to stop the preview before resizing or reformatting it.

	        if (mHolder.getSurface() == null){
	          // preview surface does not exist
	          return;
	        }

	        // stop preview before making changes
	        try {
	            mCamera.stopPreview();
	        } catch (Exception e){
	          // ignore: tried to stop a non-existent preview
	        }

	        // set preview size and make any resize, rotate or
	        // reformatting changes here

	        // start preview with new settings
	        try {
	            mCamera.setPreviewDisplay(mHolder);
	            mCamera.startPreview();

	        } catch (Exception e){
	            Log.d("ERROR", "Error starting camera preview: " + e.getMessage());
	        }
	    }
	}
	


