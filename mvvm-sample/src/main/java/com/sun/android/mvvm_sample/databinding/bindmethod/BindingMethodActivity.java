package com.sun.android.mvvm_sample.databinding.bindmethod;

import android.os.Bundle;
import android.os.Handler;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sun.android.mvvm_sample.R;
import com.sun.android.mvvm_sample.databinding.ActivityBinderMethodBinding;

/**
 * @author tianxiaolong
 * time：2019-12-29 15:45
 * description：
 * 用于解释自定义view属性和databinding的关联
 * {@link androidx.databinding.BindingMethod}
 * {@link androidx.databinding.BindingMethods}
 */
public class BindingMethodActivity extends AppCompatActivity {
	private static final long DELAY_TIME = 1000;
	private Handler handler = new Handler();

	private int progress;
	private ActivityBinderMethodBinding binding;

	private ProgressData progressData;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_binder_method);
 progressData = new ProgressData();
 binding.setData(progressData);
 postDelay();

	}


	private void postDelay(){
		handler.postDelayed(delayRunnable,DELAY_TIME);
	}

	private Runnable delayRunnable = () -> {
       progress+=100;
       progressData.setProgress(String.valueOf(progress));
       postDelay();
	};
}
