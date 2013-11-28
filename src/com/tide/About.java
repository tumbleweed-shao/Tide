package com.tide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class About extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_tide_about);
		EditText wv = (EditText)findViewById(R.id.editText1);
		wv.setText("潮汐小提示——是一款提示当前海水最大潮和枯潮时间的小工具，" +
				"海水涨退潮是由阴历日期决定的，" +
				"我选择了大连地区黄海的涨退潮时间，" +
				"数据可能会有半个小时到一个小时的误差，" +
				"本软件只提供参考，如需要精确的涨退潮时间，" +
				"请查找权威的数据" +
				"谢谢您的使用");
		super.onCreate(savedInstanceState);
	}
	
}
