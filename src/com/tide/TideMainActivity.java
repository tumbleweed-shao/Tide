package com.tide;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import net.youmi.android.AdManager;
import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import com.tide.common.Lunar;
import com.tide.common.Tide;
import com.tide.common.TideHelper;
import com.tide.service.TideService;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TideMainActivity extends Activity {
	MediaPlayer player = null;
	LinearLayout llfather;
	static Tide tideInfo = null;
	TextView txtSpring = null;
	TextView txtNeap = null;
	boolean  loopFlag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tide_main);
		
		llfather = (LinearLayout)findViewById(R.id.line1);
		llfather.post(new Runnable() {
			@Override
			public void run() {
				InitController();
			}
		});
		
		Intent in = new Intent();
		in.setClass(TideMainActivity.this, TideService.class);
		startService(in);
	     
	}

	@Override
	protected void onDestroy() {
		if (player.isPlaying()) 
        {
		player.stop();
        }
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		if (player.isPlaying()) 
        {
		player.stop();
        }
		super.onPause();
	}

	@Override
	protected void onStop() {
		if (player.isPlaying()) 
        {
		player.stop();
        }
		super.onStop();
	}

	@Override
	protected void onStart() {
		
		playWave();
		
		final Handler handler = new Handler();
		Timer timer = new Timer(false);
		TimerTask timerTask = new TimerTask() {
		    @Override
		    public void run() {
		        handler.post(new Runnable() {
		            @Override
		            public void run() {
		                if (tideInfo != null && loopFlag){
		                	txtSpring = (TextView)findViewById(R.id.txtViewSpring);
		            		txtNeap = (TextView)findViewById(R.id.txtViewNeap);
		            		txtSpring.setText(txtSpring.getText() + TideHelper.Space5 + tideInfo.getFirstSpringTide() +TideHelper.Space5 + tideInfo.getSecondSpringTide());
		            		txtNeap.setText(txtNeap.getText() + TideHelper.Space5 + tideInfo.getFirstNeapTide() + TideHelper.Space5 + tideInfo.getSecondNeapTide());
		            		loopFlag = false;
		                }
		            }
		        });
		    }
		};
		timer.scheduleAtFixedRate(timerTask,0, 1000);
		super.onStart();
	}

	@Override
	protected void onRestart() {
		playWave();
		super.onRestart();
	}

	@Override
	protected void onResume() {
		playWave();
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tide_main, menu);
		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent in = new Intent();
		in.setClass(TideMainActivity.this, About.class);
		TideMainActivity.this.startActivity(in);
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("NewApi")
	private void InitController(){
		//Rect rect = new Rect();  
        //llfather.getWindowVisibleDisplayFrame(rect);  
        //int statusBarHeight = rect.top; 
		Window window = getWindow();  
        View currentView = window.findViewById(Window.ID_ANDROID_CONTENT);
        //int contentViewTop = currentView.getTop();  
        int mesureHeight = currentView.getMeasuredHeight(); 
        int measuredWidth = currentView.getMeasuredWidth(); 
        //int titleBarHeight = contentViewTop - statusBarHeight;  
		LinearLayout ll1 = (LinearLayout)findViewById(R.id.line1);
		LinearLayout ll2 = (LinearLayout)findViewById(R.id.line2);
		LinearLayout ll3 = (LinearLayout)findViewById(R.id.line3);
		LinearLayout ll4 = (LinearLayout)findViewById(R.id.line4);
		ll1.setLayoutParams(new LinearLayout.LayoutParams(measuredWidth, (int)(mesureHeight * 0.15)));
		ll2.setLayoutParams(new LinearLayout.LayoutParams(measuredWidth, (int)(mesureHeight * 0.1)));
		ll3.setLayoutParams(new LinearLayout.LayoutParams(measuredWidth, (int)(mesureHeight * 0.65)));
		ll4.setLayoutParams(new LinearLayout.LayoutParams(measuredWidth, (int)(mesureHeight * 0.11)));
		Button btExit = (Button)findViewById(R.id.btExit);
		btExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.exit(0);
			}
		});
		DigitalClock dgClock = (DigitalClock)findViewById(R.id.digitalClock);
		//dgClock.("GMT+8:00");
		TextView tv = (TextView)findViewById(R.id.txtViewCurrentDate);
		Calendar c = Calendar.getInstance(); 
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		c.setTime(new java.util.Date());
		Lunar lu = new Lunar(c);
		tv.setText(tv.getText() + df.format(c.getTime()) + " 农历：" + lu.toString() );
	}
	private void playWave()
	{
		player = new MediaPlayer();
		AssetFileDescriptor aDr;
		try {
			aDr = getAssets().openFd("wave.mp3");
			player.setDataSource(aDr.getFileDescriptor());
			player.prepare();
			player.setVolume(0.03f, 0.03f);
			player.setLooping(false);
			if (!player.isPlaying()) 
	        {
				player.start();
	        }
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static class ManagerReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			tideInfo = (Tide) intent.getExtras().getSerializable("TIDEINFO");

		}
		
	}
}
