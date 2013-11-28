package com.tide.service;

import java.util.Calendar;

import com.tide.common.Lunar;
import com.tide.common.LunarEnum;
import com.tide.common.Tide;
import com.tide.common.TideDB;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TideService extends Service{

	@SuppressLint("NewApi")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Calendar today  = Calendar.getInstance();
		today.setTime(new java.util.Date());
		Lunar lu = new Lunar(today);
		Tide currentTide = TideDB.getTideByLunar(convertToEnum(lu.getChinaDay()));
		Intent intentNew = new Intent();
		intentNew.setAction("android.intent.action.SENDTIDETOACTIVITY");
		intentNew.putExtra("TIDEINFO", currentTide);
		sendBroadcast(intentNew);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		
		return null;
	}
	private LunarEnum convertToEnum(String chinaDay){
		if (chinaDay.equals("初一")){
			return LunarEnum.CHUYI;
		}else if(chinaDay.equals("初二")){
			return LunarEnum.CHUER;
		}else if(chinaDay.equals("初三")){
			return LunarEnum.CHUSAN;
		}else if(chinaDay.equals("初四")){
			return LunarEnum.CHUSI ;
		}else if(chinaDay.equals("初五")){
			return LunarEnum.CHUWU;
		}else if(chinaDay.equals("初六")){
			return LunarEnum.CHULIU;
		}else if(chinaDay.equals("初七")){
			return LunarEnum.CHUQI;
		}else if(chinaDay.equals("初八")){
			return LunarEnum.CHUBA;
		}else if(chinaDay.equals("初九")){
			return LunarEnum.CHUJIU;
		}else if(chinaDay.equals("初十")){
			return LunarEnum.CHUSHI;
		}else if(chinaDay.equals("十一")){
			return LunarEnum.SHIYI;
		}else if(chinaDay.equals("十二")){
			return LunarEnum.SHIER;
		}else if(chinaDay.equals("十三")){
			return LunarEnum.SHISAN;
		}else if(chinaDay.equals("十四")){
			return LunarEnum.SHISI;
		}else if(chinaDay.equals("十五")){
			return LunarEnum.SHIWU;
		}else if(chinaDay.equals("十六")){
			return LunarEnum.SHILIU;
		}else if(chinaDay.equals("十七")){
			return LunarEnum.SHIQI;
		}else if(chinaDay.equals("十八")){
			return LunarEnum.SHIBA;
		}else if(chinaDay.equals("十九")){
			return LunarEnum.SHIJIU;
		}else if(chinaDay.equals("廿十")){
			return LunarEnum.ERSHI;
		}else if(chinaDay.equals("廿一")){
			return LunarEnum.ERSHIYI;
		}else if(chinaDay.equals("廿二")){
			return LunarEnum.ERSHIER;
		}else if(chinaDay.equals("廿三")){
			return LunarEnum.ERSHISAN;
		}else if(chinaDay.equals("廿四")){
			return LunarEnum.ERSHISI;
		}else if(chinaDay.equals("廿五")){
			return LunarEnum.ERSHIWU;
		}else if(chinaDay.equals("廿六")){
			return LunarEnum.ERSHILIU;
		}else if(chinaDay.equals("廿七")){
			return LunarEnum.ERSHIQI;
		}else if(chinaDay.equals("廿八")){
			return LunarEnum.ERSHIBA;
		}else if(chinaDay.equals("廿九")){
			return LunarEnum.ERSHIJIU;
		}else{
			return LunarEnum.SANSHI;
		}
	}
	
}
