package com.onine.cricket;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import appwarp.example.ChatActivity;
import appwarp.example.Constants;
import appwarp.example.MainActivity;
import appwarp.example.Utils;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.onine.cloud.CloudConnect;
import com.onine.cricket.dao.GaaliDAO;
import com.onine.cricket.sensor.ShakeListener;
import com.onine.cricket.R;
import com.onine.model.Gaali;
import com.shephertz.app42.gaming.multiplayer.client.WarpClient;
import com.shephertz.app42.gaming.multiplayer.client.command.WarpResponseResultCode;
import com.shephertz.app42.gaming.multiplayer.client.events.ConnectEvent;
import com.shephertz.app42.gaming.multiplayer.client.events.LiveRoomInfoEvent;
import com.shephertz.app42.gaming.multiplayer.client.events.RoomEvent;
import com.shephertz.app42.gaming.multiplayer.client.listener.ConnectionRequestListener;
import com.shephertz.app42.gaming.multiplayer.client.listener.RoomRequestListener;

public class MainScreen extends Activity implements View.OnClickListener,
		AdListener, AppEventListener{
	Context context;
	int flag=0;
	String tabValue="";
	int fillOnlyOnce=0;
	int fillOnlyOnce1=0;
	TextView firstTab;
	boolean isShaking = false;
	DfpAdView adView;
	private ShakeListener mShaker;
	Vibrator vibe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dailydetail);
		adView = (DfpAdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
		TextView text = (TextView) findViewById(R.id.text_header);
	
		text.setText("Live Score");
		WebView webView = (WebView) findViewById(R.id.dailyDetailWebView);
		webView.getSettings().setCacheMode(
				android.webkit.WebSettings.LOAD_NO_CACHE);
		
		
		
		vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		webView.loadUrl("http://onine.in/god/LiveScore.html");
		webView.clearCache(true);
		webView.clearHistory();
		webView.getSettings().setJavaScriptEnabled(true);
		new ReloadWebView(this, 1, webView);
		//webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		
		mShaker = new ShakeListener(this);
		mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
			public void onShake() {				
					new AsyncSender().execute();
			}

		});
		context = this;
		this.firstTab = ((TextView) findViewById(R.id.firstTab));
		this.firstTab.setOnClickListener(this);
		this.firstTab.setBackgroundResource(R.drawable.tab_active);
	}

	
	private final class AsyncSender extends AsyncTask<Void, Void, Void> {

		ProgressDialog pd;
		MediaPlayer mediaPlayer = new MediaPlayer();

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pd = new ProgressDialog(MainScreen.this);
			pd.setIcon(R.drawable.ic_launcherbig);
			pd.setTitle("");
			pd.setCancelable(true);
			pd.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					mediaPlayer.stop();
				}
			});
			pd.setMessage("Score Updating....");
			pd.setIndeterminate(true); 
			pd.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			
			if (isShaking == false && isFirstTab) {
				isShaking = true;
				vibe.vibrate(100);
//			playAudio(); // You probably have to try/catch this
				
				
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); 
				try {
					//mediaPlayer.setDataSource("http://onine.in/god/SIREN1.mp3");
					mediaPlayer.prepare();
					//mediaPlayer.start();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				isShaking=false;
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			pd.dismiss();
		}

		
	}

	boolean isFirstTab = true;
	private ArrayAdapter<String> adapter;

	@Override
	public void onClick(View view) {
		
		WebView webView = (WebView) findViewById(R.id.dailyDetailWebView);

			isFirstTab = true;
			webView.setVisibility(View.VISIBLE);
			
			this.firstTab.setBackgroundResource(R.drawable.tab_active);
			
			flag=0;
			webView.loadUrl("http://onine.in/god/LiveScore.html");
			webView.clearCache(true);
			webView.clearHistory();
			webView.getSettings().setJavaScriptEnabled(true);
			//webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
			this.tabValue="";
			adView.loadAd(new AdRequest());
	}

	

	
	@Override
	public void onAppEvent(Ad arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDismissScreen(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLeaveApplication(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPresentScreen(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReceiveAd(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResume() {
		mShaker.resume();
		super.onResume();
	}

	@Override
	public void onPause() {
		mShaker.pause();
		super.onPause();
	}
	

	
	
	


}
