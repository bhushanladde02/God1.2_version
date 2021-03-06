package com.onine.god;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
import com.onine.god.dao.GaaliDAO;
import com.onine.god.sensor.ShakeListener;
import com.onine.model.Gaali;
import com.shephertz.app42.gaming.multiplayer.client.WarpClient;
import com.shephertz.app42.gaming.multiplayer.client.command.WarpResponseResultCode;
import com.shephertz.app42.gaming.multiplayer.client.events.ConnectEvent;
import com.shephertz.app42.gaming.multiplayer.client.events.LiveRoomInfoEvent;
import com.shephertz.app42.gaming.multiplayer.client.events.RoomEvent;
import com.shephertz.app42.gaming.multiplayer.client.listener.ConnectionRequestListener;
import com.shephertz.app42.gaming.multiplayer.client.listener.RoomRequestListener;

public class MainScreen extends Activity implements View.OnClickListener,
		AdListener, AppEventListener, ConnectionRequestListener, RoomRequestListener{
	Context context;
	TextView lastTab;//bhushan
	private EditText nameEditText;//bhushan
	private WarpClient theClient;//bhushan
	private ProgressDialog progressDialog;//bhushan
    private Handler handler = new Handler();//bhushan
	int flag=0;
	TextView previousTab;
	TextView firstTab;
	
	ListView listView;
	private List<Gaali> gaaliList;
	private List<String> values = new ArrayList<String>();
	private GaaliDAO gaaliDAO;
	
	boolean isShaking = false;
	DfpAdView adView;

	private ShakeListener mShaker;
	Vibrator vibe;
	Gson gson = new GsonBuilder().create();

	// Look up the DfpAdView as a resource and load a request.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dailydetail);
		
		
	
		init();//bhushan

		gaaliDAO = new GaaliDAO(this);
		gaaliDAO.open();
		
		// context=this;

		adView = (DfpAdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());

		TextView text = (TextView) findViewById(R.id.text_header);
		listView = (ListView) findViewById(R.id.god_list);
		text.setText("Gaali Of The Day");
		WebView webView = (WebView) findViewById(R.id.dailyDetailWebView);
		// WebView preWebView = (WebView)
		// findViewById(R.id.dailyPreDetailWebView);

		// Disable Cache
		webView.getSettings().setCacheMode(
				android.webkit.WebSettings.LOAD_NO_CACHE);

		vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		webView.loadUrl("http://onine.in/god/god1.html");

		adapter = new ArrayAdapter<String>(this,
				 android.R.layout.simple_list_item_1, android.R.id.text1, values);
				
				

		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		
		
			
		mShaker = new ShakeListener(this);
		mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
			public void onShake() {				
					new AsyncSender().execute();
			}

		});

		/*
		 * mShaker = new ShakeListener(this); mShaker.setOnShakeListener(new
		 * ShakeListener.OnShakeListener() { public void onShake() {
		 * 
		 * 
		 * 
		 * new AsyncSender().execute();
		 * 
		 * vibe.vibrate(100);
		 * 
		 * 
		 * 
		 * }
		 * 
		 * });
		 */

		context = this;
		this.firstTab = ((TextView) findViewById(R.id.firstTab));
		this.previousTab = ((TextView) findViewById(R.id.previousTab));
		
		this.lastTab=((TextView) findViewById(R.id.lastTab));//bhushan
		
		this.firstTab.setOnClickListener(this);
		this.previousTab.setOnClickListener(this);
		
	
		
		this.firstTab.setBackgroundResource(R.drawable.tab_active);
		this.previousTab.setBackgroundResource(R.drawable.tab);
		
		this.lastTab.setBackgroundResource(R.drawable.tab); //bhushan
		this.lastTab.setOnClickListener(this);
		

	}

	//Bhushan new Method - remove if dont want put for change tab
	public void settingOriginalViewOnceAgain()
	{
		flag=0;	
		System.out.println("object::::::::::::::::::"+this);
		setContentView(R.layout.dailydetail);
		
		
		
		init();//bhushan

		context = this;
		this.firstTab = ((TextView) findViewById(R.id.firstTab));
		this.previousTab = ((TextView) findViewById(R.id.previousTab));
		this.lastTab=((TextView) findViewById(R.id.lastTab));//bhushan
		
		
		
		gaaliDAO = new GaaliDAO(this);
		gaaliDAO.open();
		
		// context=this;

		adView = (DfpAdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());

		TextView text = (TextView) findViewById(R.id.text_header);
		text.setText("Gaali Of The Day");
		listView = (ListView) findViewById(R.id.god_list);
		WebView webView = (WebView) findViewById(R.id.dailyDetailWebView);
		// WebView preWebView = (WebView)
		// findViewById(R.id.dailyPreDetailWebView);
		// Disable Cache
		webView.getSettings().setCacheMode(
				android.webkit.WebSettings.LOAD_NO_CACHE);

		vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		webView.loadUrl("http://onine.in/god/god1.html");

		adapter = new ArrayAdapter<String>(this,
				 android.R.layout.simple_list_item_1, android.R.id.text1, values);
				
				

		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		
		
			
		mShaker = new ShakeListener(this);
		mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
			public void onShake() {				
					new AsyncSender().execute();
			}

		});

	


		this.firstTab.setBackgroundResource(R.drawable.tab_active);
		this.previousTab.setBackgroundResource(R.drawable.tab);
		this.lastTab.setBackgroundResource(R.drawable.tab); //bhushan
		this.firstTab.setOnClickListener(this);
		this.previousTab.setOnClickListener(this);

	
		this.lastTab.setOnClickListener(this);
	}
	
	
	//bhushan end of new Method
	
	/*public void playAudio() {
		try {
			MediaPlayer mediaPlayer = new MediaPlayer();
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); 
			mediaPlayer.setDataSource("http://onine.in/god/SIREN1.mp3");
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/

	private final class AsyncSender extends AsyncTask<Void, Void, Void> {

		ProgressDialog pd;
		MediaPlayer mediaPlayer = new MediaPlayer();

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pd = new ProgressDialog(MainScreen.this);
			pd.setIcon(R.drawable.ic_launcherbig);
			pd.setTitle("I am cummminngg... ");
			pd.setCancelable(true);
			pd.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					mediaPlayer.stop();
				}
			});
			pd.setMessage("Aaahhhhh....Aaahhh");
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
					mediaPlayer.setDataSource("http://onine.in/god/SIREN1.mp3");
					mediaPlayer.prepare();
					mediaPlayer.start();
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
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(flag==1){settingOriginalViewOnceAgain();}//Bhushan new Method -- remove if dont want put for change tab
		WebView webView = (WebView) findViewById(R.id.dailyDetailWebView);
		System.out.println("Webview..............................................................."+webView);
		System.out.println("I am in this method..........................re");
		
//		WebView preWebView = (WebView) findViewById(R.id.dailyPreDetailWebView);
		if (view == this.firstTab) {
		   System.out.println("I am in first tab.................................................................................");
			isFirstTab = true;
			// if(flag==1){settingOriginalViewOnceAgain();}//Bhushan new Method -- remove if dont want put for change tab
			webView.setVisibility(View.VISIBLE);
			listView.setVisibility(View.GONE);
			// this.firstTab=(TextView)findViewById(R.drawable.tab_active);
			this.firstTab.setBackgroundResource(R.drawable.tab_active);
			this.previousTab.setBackgroundResource(R.drawable.tab);
			this.lastTab.setBackgroundResource(R.drawable.tab);
			flag=0;
			// this.previousTab=(TextView)findViewById(R.drawable.tab);
//			System.out.println("First Tab");
			webView.loadUrl("http://onine.in/god/god1.html");

			adView.loadAd(new AdRequest());

		} else if (view == this.previousTab) {
			isFirstTab = false;
			System.out.println("I am in previous tab................................................................................");
			//if(flag==1){settingOriginalViewOnceAgain();}//Bhushan new Method --  remove if dont want put for change tab
			// this.previousTab=(TextView)findViewById(R.drawable.tab_active);
			// this.firstTab=(TextView)findViewById(R.drawable.tab);
			this.previousTab.setBackgroundResource(R.drawable.tab_active);
			this.firstTab.setBackgroundResource(R.drawable.tab);
			this.lastTab.setBackgroundResource(R.drawable.tab);
			this.previousTab.setTextColor(R.color.black_overlay);
     		adView.loadAd(new AdRequest());
			webView.setVisibility(View.GONE);
			flag=0;
			listView.setVisibility(View.VISIBLE);
			
			
			
			/*pd = ProgressDialog.show(
	                MainScreen.this,
	                "Please wait...",
	                "Loading the data",
	                true,
	                true,
	                null
	        )*/;
			
	        gaaliList= gaaliDAO.getAllGaali();
	        
	        values = getAllGaaliValuesArray(gaaliList);
	        if(values.size() > 0){
	        	adapter.clear();
				for (int i = 0; i < values.size(); i++) {
					adapter.add(values.get(i));
				}
			}
	       
		

			// Define a new Adapter
			// First parameter - Context
			// Second parameter - Layout for the row
			// Third parameter - ID of the TextView to which the data is written
			// Forth - the Array of data



			new AsyncLoadGaalis().execute();//load more gaalis
//			values= getAllGaaliValues(gaaliList);
//			adapter.notifyDataSetChanged();
			
			
			
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent gaaliDetail = new Intent(context,GaaliDetails.class);
					gaaliDetail.putExtra("gaaliID", position); 
					startActivity(gaaliDetail); 
					
				}
			});
		}else if (view == this.lastTab) {//bhushan
		isFirstTab = false;
	    flag=1;		
		this.lastTab.setBackgroundResource(R.drawable.tab_active);
		this.firstTab.setBackgroundResource(R.drawable.tab);
		this.previousTab.setBackgroundResource(R.drawable.tab);
		this.lastTab.setTextColor(R.color.black_overlay);
		
		setContentView(R.layout.activity_main);//bhushan
	
		//webView.setVisibility(View.GONE);
		//listView.setVisibility(View.GONE);
		nameEditText = (EditText)findViewById(R.id.editTextName);//bhushan
		//init();//bhushan
		////////////////////////////////////////////////////////////////   BBHUSHAN CODE <This Code is for Android activity_main.xml to set there content..>
		TextView text = (TextView) findViewById(R.id.text_header);
		text.setText("Gaali Of The Day");
		context = this;
		this.firstTab = ((TextView) findViewById(R.id.firstTab));
		this.previousTab = ((TextView) findViewById(R.id.previousTab));
	    this.lastTab=((TextView) findViewById(R.id.lastTab));//bhushan
		this.firstTab.setOnClickListener(this);
		this.previousTab.setOnClickListener(this);
		this.lastTab.setBackgroundResource(R.drawable.tab);
		this.previousTab.setBackgroundResource(R.drawable.tab);
		this.firstTab.setBackgroundResource(R.drawable.tab); //bhushan
		this.lastTab.setOnClickListener(this);
		
		/////////////////////////////////////////////////////////////////   BBHUSHAN CODE
			
		
		//setContentView(R.layout.activity_main);  //comment by me bhushan
		//nameEditText = (EditText)findViewById(R.id.editTextName);//comment by me bhushan
		//init();//comment by me bhushan
		//adView.loadAd(new AdRequest());
		
	}//end of bhushan
		
	}

	
	/*private String[] getAllGaaliValuesArray(List<Gaali> gaaliList) {
		// TODO Auto-generated method stub
		String[] values = new String[gaaliList.size()];
		for (int i = 0; i < gaaliList.size(); i++) {
			values[i]=gaaliList.get(i).getGaali();
		}
		return values;
	}*/
	
	private List<String> getAllGaaliValuesArray(List<Gaali> gaaliList) {
		// TODO Auto-generated method stub
		List<String> values = new ArrayList<String>();
		for (int i = 0; i < gaaliList.size(); i++) {
			values.add(gaaliList.get(i).getGaali());
		}
		return values;
	}

	private final class AsyncLoadGaalis extends AsyncTask<Void, Void, Void> {

		List<String> updatedList = new ArrayList<String>();
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			updatedList= getAllGaaliValues(gaaliList);
			System.out.println("Values are "+values.toString());
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			System.out.println("Inside Post Execute");
//			adapter.notifyDataSetChanged();
			for (int i = 0; i < updatedList.size(); i++) {
				adapter.add(updatedList.get(i));
			}
		}
	}
	
	
	
	private List<String> getAllGaaliValues(List<Gaali> gaaliList) {
		// TODO Auto-generated method stub
		List<String> gaaliValues = new ArrayList<String>();
		
		
		/*for (int i = 0; i < gaaliList.size(); i++) {
			gaaliValues.add(gaaliList.get(i).getGaali());
		}*/
		
		String gaaliJSON = CloudConnect.retriveGaalis(gaaliList.size()-1);
//		System.out.println("Gaali JSON"+gaaliJSON);
		Type listType = new TypeToken<ArrayList<Gaali>>() {}.getType();
		List<Gaali> updatedGaaliList  = gson.fromJson(gaaliJSON, listType);
		System.out.println("Gaali List"+updatedGaaliList);
		for (int i = 0; i < updatedGaaliList.size(); i++) {
			gaaliDAO.createGaali(gson.toJson(updatedGaaliList.get(i), Gaali.class));
			gaaliValues.add(updatedGaaliList.get(i).getGaali());
		}
		
		
//		return gaaliValues.toArray(new String[gaaliValues.size()]);
		return gaaliValues;
		
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
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		gaaliDAO.close();
	}

	
	
	//All Bhushan Method
	@Override
	protected void onStart(){
		super.onStart();
		theClient.addConnectionRequestListener(this); 
		theClient.addRoomRequestListener(this);
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		theClient.removeConnectionRequestListener(this);  
		theClient.removeRoomRequestListener(this);
	}
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		if(theClient!=null){
			theClient.disconnect();
		}
	}
	
	
	public void onConnectClicked(View view){
		String userName = nameEditText.getText().toString();
		if(userName.length()>0){
			Utils.USER_NAME  = userName;
			progressDialog = ProgressDialog.show(this, "", "Please wait...");
			progressDialog.setCancelable(true);
			theClient.connectWithUserName(userName);
		}else{
			Utils.showToast(this, "Please enter name");
		}
	}
	
	private void init(){
		WarpClient.initialize(Constants.apiKey, Constants.secretKey);
		WarpClient.setRecoveryAllowance(120);
        try {
            theClient = WarpClient.getInstance();
        } catch (Exception ex) {
            Toast.makeText(this, "Exception in Initilization", Toast.LENGTH_LONG).show();
        }
        
	}
	
	@Override
	public void onConnectDone(final ConnectEvent event) {
		if(progressDialog!=null){
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					progressDialog.dismiss();
					
				}
			});
		}
		if(event.getResult() == WarpResponseResultCode.SUCCESS){
        	showToastOnUIThread("Connection success");
            theClient.joinRoom(Constants.roomId);
        }
        else if(event.getResult() == WarpResponseResultCode.SUCCESS_RECOVERED){
        	showToastOnUIThread("Connection recovered");
        }
        else if(event.getResult() == WarpResponseResultCode.CONNECTION_ERROR_RECOVERABLE){
        	runOnUiThread(new Runnable() {
				@Override
				public void run() {
					progressDialog = ProgressDialog.show(MainScreen.this, "", "Recoverable connection error. Recovering session after 5 seconds");
				}
			});
        	System.out.println("I am came here!!!!!!!!!!!!!!!!!!!!1");
        	handler.postDelayed(new Runnable() {
                @Override
                public void run() {                                          
                    progressDialog.setMessage("Recovering...");
                    theClient.RecoverConnection();
                }
            }, 5000);
        }
        else{
        	showToastOnUIThread("Non-recoverable connection error.");
        }
	}
	
	@Override
	public void onDisconnectDone(final ConnectEvent event) {
		
	}
	
	@Override
	public void onInitUDPDone(byte result) {
		
	}

	@Override
	public void onGetLiveRoomInfoDone(LiveRoomInfoEvent arg0) {
		
		
	}

	@Override
	public void onJoinRoomDone(RoomEvent event) {
		if(event.getResult()==WarpResponseResultCode.SUCCESS){
			theClient.subscribeRoom(event.getData().getId());
		}else{
			showToastOnUIThread("onJoinRoomDone with ErrorCode: "+event.getResult());
		}
	}

	@Override
	public void onLeaveRoomDone(RoomEvent arg0) {
		
		
	}

	@Override
	public void onLockPropertiesDone(byte arg0) {
		
		
	}

	@Override
	public void onSetCustomRoomDataDone(LiveRoomInfoEvent arg0) {
		
		
	}

	@Override
	public void onSubscribeRoomDone(RoomEvent event) {
		if(event.getResult()==WarpResponseResultCode.SUCCESS){
			Intent intent = new Intent(this, ChatActivity.class);
			startActivity(intent);
		}else{
			showToastOnUIThread("onSubscribeRoomDone Failed with ErrorCode: "+event.getResult());
		}
		
	}

	@Override
	public void onUnSubscribeRoomDone(RoomEvent arg0) {
		
		
	}

	@Override
	public void onUnlockPropertiesDone(byte arg0) {
		
		
	}

	@Override
	public void onUpdatePropertyDone(LiveRoomInfoEvent arg0) {
		
		
	}
	private void showToastOnUIThread(final String message){
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MainScreen.this, message, Toast.LENGTH_LONG).show();
			}
		});
	}
	
	//End Of Bhushan Method


}
