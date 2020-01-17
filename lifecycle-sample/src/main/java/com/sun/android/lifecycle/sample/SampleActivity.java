package com.sun.android.lifecycle.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.sun.android.util.Logs;
import com.sun.android.util.UtilsKt;


public class SampleActivity extends AppCompatActivity {


	private View hmProgressButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getLifecycle().addObserver(new SampleObserver(getLifecycle()));
		getLifecycle().addObserver(new FullLifecycleObserverSample());
		String canonicalName = getClass().getCanonicalName();
		Logs.INSTANCE.I("canonicalName:"+canonicalName);
		Logs.INSTANCE.I("activity onCreate");
		hmProgressButton  = findViewById(R.id.id_button);
		hmProgressButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						finish();
					}

				});
		findViewById(R.id.id_jump)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						UtilsKt.startActivity(SampleActivity.this,TestActivity.class);
					}
				});
	}



	@Override
	protected void onStart() {
		super.onStart();
		Logs.INSTANCE.I("activity onStart");
	}


	@Override
	protected void onResume() {
		super.onResume();
		Logs.INSTANCE.I("activity onResume");
	}



	@Override
	protected void onPause() {
		super.onPause();
		Logs.INSTANCE.I("activity onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Logs.INSTANCE.I("activity onStop");
	}





	@Override
	protected void onRestart() {
		super.onRestart();
		Logs.INSTANCE.I("activity onRestart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Logs.INSTANCE.I("activity onDestroy");
	}
}
