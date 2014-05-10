package br.com.cirocosta.android_alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmStuff {

	private boolean TRIGGERED = false;

	public AlarmStuff() {

	}

	public void setRepeatingAlarm(Context context, long milliSecs) {
		AlarmManager am = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		Intent i = new Intent(context, AlarmRec.class);
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);

		TRIGGERED = true;
		am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
				milliSecs, pi);
	}

	public void setOnetimeTimer(Context context, long milliSecs) {
		AlarmManager am = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, AlarmRec.class);
		PendingIntent pi;

		TRIGGERED = true;
		intent.putExtra("onetime", Boolean.TRUE);
		pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + milliSecs,
				pi);
		
	}

	public void cancelAlarm(Context context) {
		Intent intent = new Intent(context, AlarmRec.class);
		PendingIntent sender = PendingIntent
				.getBroadcast(context, 0, intent, 0);
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);

		alarmManager.cancel(sender);
	}
}
