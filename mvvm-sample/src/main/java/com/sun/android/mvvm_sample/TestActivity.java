package com.sun.android.mvvm_sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveDataBus;
import androidx.lifecycle.Observer;

/**
 * @author tianxiaolong
 * time：2019/12/3 17:50
 * description：
 */
public class TestActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = findViewById(R.id.id_test);
		button.setText("dsadsadsadsa");
		LiveDataBus.getDefault().observer("button", this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				Toast.makeText(TestActivity.this, s, Toast.LENGTH_SHORT).show();
			}
		});
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LiveDataBus.getDefault().postValue("button","button");
			}
		});
	}
}
