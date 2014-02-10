package com.onine.god;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.android.gcm.GCMBaseIntentService;
import com.onine.cloud.CloudConnect;

public class GCMIntentService extends GCMBaseIntentService {
	private static final String SENDER_ID = "263505509884"; //GCM Sender ID for Google Cloud Messaging
	
	 public GCMIntentService() {
	        super(SENDER_ID);
	    }
	
	@Override
	protected void onError(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMessage(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		// Prepare intent which is triggered if the
		// notification is selected
//		startActivity(new Intent(this,GodSplash.class));
		Intent intent = new Intent(this,MainScreen.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		NotificationCompat.Builder mBuilder =
	        new NotificationCompat.Builder(this)
	        .setSmallIcon(R.drawable.ic_launcherbig)
	        .setContentTitle("Gaali has arrived")
	        .setContentText("Phone utha bhench***!")
	        .setContentIntent(pendingIntent);
			
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		try {
	        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
	        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
	        r.play();
	    } catch (Exception e) {}
		
		mBuilder.getNotification().flags = Notification.FLAG_AUTO_CANCEL;
		
		notificationManager.notify(0, mBuilder.getNotification());
	}

	@Override
	protected void onRegistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		CloudConnect.registerDevice(arg1, "1");
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		CloudConnect.registerDevice(arg1, "0");
	}
	
	

	
	
}
