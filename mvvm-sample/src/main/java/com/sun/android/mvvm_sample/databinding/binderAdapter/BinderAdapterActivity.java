package com.sun.android.mvvm_sample.databinding.binderAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.sun.android.mvvm_sample.R;
import com.sun.android.mvvm_sample.databinding.ActivityBinderAdapterBinding;
import com.sun.android.mvvm_sample.databinding.bindmethod.ProgressData;

/**
 * @author tianxiaolong
 * time：2019-12-29 17:21
 * description：
 */
public class BinderAdapterActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityBinderAdapterBinding binderAdapterBinding = DataBindingUtil.setContentView(this, R.layout.activity_binder_adapter);
		ProgressData progressData = new ProgressData();
		binderAdapterBinding.setData(progressData);
		binderAdapterBinding.testViewpager.setAdapter(new PagerAdapter() {
			@Override
			public int getCount() {
				return 3;
			}

			@Override
			public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
				return view==object;
			}

			@NonNull
			@Override
			public Object instantiateItem(@NonNull ViewGroup container, int position) {
				View view = View.inflate(BinderAdapterActivity.this, R.layout.item_view, null);
				container.addView(view);
				return view;
			}

			@Override
			public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//				super.destroyItem(container, position, object);
				container.removeView((View) object);
			}
		});
	}
}
