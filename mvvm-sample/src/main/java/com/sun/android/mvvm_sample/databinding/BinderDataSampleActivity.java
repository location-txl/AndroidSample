package com.sun.android.mvvm_sample.databinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.sun.android.mvvm_sample.R;

/**
 * @author tianxiaolong
 * time：2019-12-28 22:19
 * description：
 */
public class BinderDataSampleActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BinderSample sample = DataBindingUtil.setContentView(this, R.layout.activity_bind);
		UserData userData = new UserData("test",1,"sex");
		sample.setUser(userData);

	}
}
