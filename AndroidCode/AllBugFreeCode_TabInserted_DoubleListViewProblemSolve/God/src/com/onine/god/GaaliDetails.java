package com.onine.god;

import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;

import com.onine.god.dao.GaaliDAO;
import com.onine.god.sensor.ShakeListener;
import com.onine.model.Gaali;

public class GaaliDetails extends Activity {
	WebView webView;
	private GaaliDAO gaaliDAO;
	Vibrator vibe;
	private ShakeListener mShaker;
	boolean isShaking = false;
	Integer gaaliID = 99999;
	final AsyncSender asyncsender = new AsyncSender();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gaalidetails);

		TextView text = (TextView) findViewById(R.id.text_header);
		text.setText("Gaali Of The Day");

		gaaliDAO = new GaaliDAO(this);
		gaaliDAO.open();

		// Disable Cache
		webView = (WebView) findViewById(R.id.gaaliDetails);
		webView.getSettings().setCacheMode(
				android.webkit.WebSettings.LOAD_NO_CACHE);

		gaaliID = getIntent().getExtras().getInt("gaaliID");
		System.out.println(gaaliID);
		Gaali gaali;
		String gaaliDetails = "Error: Please try again later";
		if (gaaliID != null) {
			gaali = gaaliDAO.getGaali(gaaliID + 1); // not here database starts
													// from +1
			gaaliDetails = constructHTML(gaali);
		}

		vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		webView.loadData(gaaliDetails, "text/html;charset=UTF-8", null);

		mShaker = new ShakeListener(this);
		
		
		
		mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
			public void onShake() {
				new AsyncSender().execute();
			}

		});

	}

	public String constructHTML(Gaali gaali) {
		String gaaliDescription = "<p><h1>"
				+ gaali.getGaali()
				+ "</h1></p>"
				+ "<p><h4><sub><i>SHAKE TO HEAR!</i></h4></h1></sub></p><p><h4>"
				+ gaali.getGaali().toLowerCase() + " ["
				+ gaali.getPronounciation() + "]</h4></p>";

		if (gaali.getDescription1().length() != 0)
			gaaliDescription += "<p><b>1. " + gaali.getDescription1()
					+ " </b></p>";

		if (gaali.getDescription2().length() != 0)
			gaaliDescription += "<p><b>2. " + gaali.getDescription2()
					+ " </b></p>";

		System.out.println("Gaali Description length is"
				+ gaali.getDescription3().length());

		if (gaali.getDescription3().length() != 0)
			gaaliDescription += "<p><b>3. " + gaali.getDescription3()
					+ " </b></p>";

		if (gaali.getDescription4().length() != 0)
			gaaliDescription += "<p><b>4. " + gaali.getDescription4()
					+ " </b></p>";

		gaaliDescription += "<p>" + gaali.getProperties() + "</p>"
				+ "<p><b>Origin: </b>" + gaali.getOrigin() + "</p>"
				+ "<p><b>Language support: </b>" + gaali.getLanguage() + "</p>"
				+ "<p><b>Usage :</b></p>";

		if (gaali.getUses1().length() != 0)
			gaaliDescription += "<p>&nbsp;&nbsp;&nbsp;1. " + gaali.getUses1()
					+ " </p>";

		if (gaali.getUses2().length() != 0)
			gaaliDescription += "<p>&nbsp;&nbsp;&nbsp;2. " + gaali.getUses2()
					+ " </p>";

		if (gaali.getUses3().length() != 0)
			gaaliDescription += "<p>&nbsp;&nbsp;&nbsp;3. " + gaali.getUses3()
					+ " </p>";

		if (gaali.getUses4().length() != 0)
			gaaliDescription += "<p>&nbsp;&nbsp;&nbsp;4. " + gaali.getUses4()
					+ " </p>";

		gaaliDescription += "<p><b>Related to : </b>" + gaali.getRelatedTo()
				+ "</p>";
		return gaaliDescription;
	}

	

	private final class AsyncSender extends AsyncTask<Void, Void, Void> {

		ProgressDialog pd;
		MediaPlayer mediaPlayer = new MediaPlayer();

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pd = new ProgressDialog(GaaliDetails.this);

			pd.setIcon(R.drawable.ic_launcherbig);
			pd.setTitle("I am cummminngg... ");
			pd.setMessage("Aaahhhhh....Aaahhh");
			pd.setCancelable(true);
			pd.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					mediaPlayer.stop();
				}
			});
			pd.setIndeterminate(true);
			pd.show();
		}

		@Override
		protected Void doInBackground(Void... params) {

			if (isShaking == false) {
				isShaking = true;
				vibe.vibrate(100);
//				playAudio(); // You probably have to try/catch this
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
				try {
					mediaPlayer.setDataSource("http://onine.in/god/sounds/" + gaaliID + ".mp3");
					mediaPlayer.prepare();
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
				mediaPlayer.start();
				
				isShaking = false;
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			pd.dismiss();
		}
	}

	/*public void playAudio() {
		try {
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer
					.setDataSource("http://onine.in/god/sounds/" + gaaliID + ".mp3");
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
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
}
