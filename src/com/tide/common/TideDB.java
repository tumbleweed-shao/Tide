package com.tide.common;

import java.util.ArrayList;

public class TideDB {
	public static Tide getTideByLunar(LunarEnum lunarDate){
		ArrayList<Tide> alltides = getHuangHaiSeaTidesInfo();
		return alltides.get(lunarDate.ordinal());
	}
	
	private static ArrayList<Tide> getHuangHaiSeaTidesInfo(){
		ArrayList<Tide> array = new ArrayList<Tide>();
		array.add(new Tide(LunarEnum.CHUYI,"10:21","4:09","22:21","16:09"));
		array.add(new Tide(LunarEnum.CHUER,"11:09","4:57","23:09","16:57"));
		array.add(new Tide(LunarEnum.CHUSAN,"11:57","5:45","23:57","17:45"));
		array.add(new Tide(LunarEnum.CHUSI,"12:45","6:33","0:45","18:33"));
		array.add(new Tide(LunarEnum.CHUWU,"13:33","7:21","1:33","19:21"));
		array.add(new Tide(LunarEnum.CHULIU,"14:21","8:09","2:21","20:09"));
		array.add(new Tide(LunarEnum.CHUQI,"15:09","8:57","3:09","20:57"));
		array.add(new Tide(LunarEnum.CHUBA,"15:57","9:45","3:57","21:45"));
		array.add(new Tide(LunarEnum.CHUJIU,"16:45","10:33","4:45","22:33"));
		array.add(new Tide(LunarEnum.CHUSHI,"17:33","11:21","5:33","23:21"));
		array.add(new Tide(LunarEnum.SHIYI,"18:21","12:09","6:21","0:09"));
		array.add(new Tide(LunarEnum.SHIER,"19:09","12:57","7:09","0:57"));
		array.add(new Tide(LunarEnum.SHISAN,"19:57","13:45","7:57","1:45"));
		array.add(new Tide(LunarEnum.SHISI,"20:45","14:33","8:45","2:33"));
		array.add(new Tide(LunarEnum.SHIWU,"21:33","15:21","9:33","3:21"));
		array.add(new Tide(LunarEnum.SHILIU,"10:21","4:09","22:21","16:09"));
		array.add(new Tide(LunarEnum.SHIQI,"11:09","4:57","23:09","16:57"));
		array.add(new Tide(LunarEnum.SHIBA,"11:57","5:45","23:57","17:45"));
		array.add(new Tide(LunarEnum.SHIJIU,"12:45","6:33","0:45","18:33"));
		array.add(new Tide(LunarEnum.ERSHI,"13:33","7:21","1:33","19:21"));
		array.add(new Tide(LunarEnum.ERSHIYI,"14:21","8:09","2:21","20:09"));
		array.add(new Tide(LunarEnum.ERSHIER,"15:09","8:57","3:09","20:57"));
		array.add(new Tide(LunarEnum.ERSHISAN,"15:57","9:45","3:57","21:45"));
		array.add(new Tide(LunarEnum.ERSHISI,"16:45","10:33","4:45","22:33"));
		array.add(new Tide(LunarEnum.ERSHIWU,"17:33","11:21","5:33","23:21"));
		array.add(new Tide(LunarEnum.ERSHILIU,"18:21","12:09","6:21","0:09"));
		array.add(new Tide(LunarEnum.ERSHIQI,"19:09","12:57","7:09","0:57"));
		array.add(new Tide(LunarEnum.ERSHIBA,"19:57","13:45","7:57","1:45"));
		array.add(new Tide(LunarEnum.ERSHIJIU,"20:45","14:33","8:45","2:33"));
		array.add(new Tide(LunarEnum.SANSHI,"21:33","15:21","9:33","3:21"));
		return array;
	}
}
