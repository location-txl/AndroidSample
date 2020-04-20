package com.sun.livedata_sample.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.sun.livedata_sample.FragmentUtils;
import com.sun.livedata_sample.R;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentUtils.getInstance(this)
				.start(FragmentOne.class)
				.add(R.id.id_frame_1)
				.commit();
		Bundle bundle = new Bundle();
		bundle.putString("title","Fragment two");
		FragmentUtils.getInstance(this)
				.start(FragmentOne.class,"two")
				.add(R.id.id_frame_2)
				.setBundle(bundle)
				.commit();
		findViewById(R.id.color_blue).setOnClickListener(this);
		findViewById(R.id.color_red).setOnClickListener(this);
		findViewById(R.id.color_green).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		EventBus.getDefault()
				.post(v.getBackground());
	}
}
