package com.sun.android.lifecycle.sample;

import android.os.Bundle;

import java.security.interfaces.DSAKey;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sun.android.util.Logs;

/**
 * @author tianxiaolong
 * time：2020/1/17 17:37
 * description：
 */
public class TestActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Logs.INSTANCE.I("Test onCreate");
	}


	@Override
	protected void onResume() {
		super.onResume();
		Logs.INSTANCE.I("Test onResume");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}
}
