package com.tide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class About extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_tide_about);
		EditText wv = (EditText)findViewById(R.id.editText1);
		wv.setText("��ϫС��ʾ������һ����ʾ��ǰ��ˮ��󳱺Ϳݳ�ʱ���С���ߣ�" +
				"��ˮ���˳������������ھ����ģ�" +
				"��ѡ���˴��������ƺ������˳�ʱ�䣬" +
				"���ݿ��ܻ��а��Сʱ��һ��Сʱ����" +
				"�����ֻ�ṩ�ο�������Ҫ��ȷ�����˳�ʱ�䣬" +
				"�����Ȩ��������" +
				"лл����ʹ��");
		super.onCreate(savedInstanceState);
	}
	
}
