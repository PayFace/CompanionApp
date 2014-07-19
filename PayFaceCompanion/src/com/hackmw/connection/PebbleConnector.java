package com.hackmw.connection;

import android.app.Activity;
import android.util.Log;

import com.getpebble.android.kit.PebbleKit;

public class PebbleConnector extends Activity{
	
	public String test(){
		try{
			boolean connected = PebbleKit.isWatchConnected(getApplicationContext());
			String result = "Pebble is " + (connected ? "connected" : "not connected");
			//Log.i(getLocalClassName(), "Pebble is " + (connected ? "connected" : "not connected"));
			Log.i(getLocalClassName(), result);
			return result;
		}
		catch(Exception e)
		{
			return e.toString();
		}
	}
}
