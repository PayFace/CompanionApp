package com.hackmw.payfacecompanion;

import com.getpebble.android.kit.PebbleKit;
import com.hackmw.connection.PebbleConnector;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	public TextView textOutput;
	public PebbleConnector connector;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        connector = new PebbleConnector();
        textOutput = (TextView) findViewById(R.id.text_output);
        //String result = test();
//        textOutput.setText("This is a test");
        textOutput.setText(test());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public String test(){
		try{
			boolean connected = PebbleKit.isWatchConnected(getApplicationContext());
			String result = "Pebble is " + (connected ? "connected" : "not connected");
			//Log.i(getLocalClassName(), "Pebble is " + (connected ? "connected" : "not connected"));
			//Log.i(getLocalClassName(), result);
			return result;
		}
		catch(Exception e)
		{
			return e.toString();
		}
	}

}
