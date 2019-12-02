package com.sun.android.mvvm_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.sun.android.mvvm_sample.viewmodle.TestViewModle;
import com.sun.android.util.Logs;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TestViewModle testViewModle = ViewModelProviders.of(this).get(TestViewModle.class);
		Logs.INSTANCE.D("test msg:"+testViewModle.a);

	}
}
