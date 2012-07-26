package com.ryanthomas.disgaea;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;

public class Special extends Activity {
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special);
        
        /*ShakeListener MyShake = new ShakeListener((SensorManager) getSystemService(SENSOR_SERVICE));
    	MyShake.setForceThreshHold(1.9);
    	MyShake.setOnShakeListener(new ShakeListener.OnShakeListener() {
    	     @Override
    	     public void onShake() {
    	          setContentView(R.layout.info);;
    	     }
    	});   */
        
        
    }
	
	 
	
}