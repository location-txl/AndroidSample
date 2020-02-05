package com.sun.android.mvvm_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveDataBus;
import com.sun.android.util.UtilsKt;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LiveDataBus.getDefault().observer("test", this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
			}
		});
		LiveDataBus.getDefault().observer("button", this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				Toast.makeText(MainActivity.this, "TestActivity:"+s, Toast.LENGTH_SHORT).show();
			}
		});
		findViewById(R.id.id_test)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
//						LiveDataBus.getDefault().postValue("test","hhhhh");
						UtilsKt.startActivity(MainActivity.this,TestActivity.class);
					}
				});


	}
}
