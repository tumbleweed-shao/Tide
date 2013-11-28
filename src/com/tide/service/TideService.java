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
		if (chinaDay.equals("��һ")){
			return LunarEnum.CHUYI;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUER;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUSAN;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUSI ;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUWU;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHULIU;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUQI;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUBA;
		}else if(chinaDay.equals("����")){
			return LunarEnum.CHUJIU;
		}else if(chinaDay.equals("��ʮ")){
			return LunarEnum.CHUSHI;
		}else if(chinaDay.equals("ʮһ")){
			return LunarEnum.SHIYI;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHIER;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHISAN;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHISI;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHIWU;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHILIU;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHIQI;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHIBA;
		}else if(chinaDay.equals("ʮ��")){
			return LunarEnum.SHIJIU;
		}else if(chinaDay.equals("إʮ")){
			return LunarEnum.ERSHI;
		}else if(chinaDay.equals("إһ")){
			return LunarEnum.ERSHIYI;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHIER;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHISAN;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHISI;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHIWU;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHILIU;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHIQI;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHIBA;
		}else if(chinaDay.equals("إ��")){
			return LunarEnum.ERSHIJIU;
		}else{
			return LunarEnum.SANSHI;
		}
	}
	
}
