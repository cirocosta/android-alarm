package br.com.cirocosta.android_alarm;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity {


	AlarmStuff as;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		as = new AlarmStuff();
		initializeUi();
	}

	private void initializeUi() {
		(findViewById(R.id.btn_setAlarm)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				as.setOnetimeTimer(MainActivity.this, 5000);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
