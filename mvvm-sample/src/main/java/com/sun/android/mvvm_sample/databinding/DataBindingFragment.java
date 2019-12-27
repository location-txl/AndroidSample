package com.sun.android.mvvm_sample.databinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.android.mvvm_sample.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * @author tianxiaolong
 * time：2019/12/23 20:27
 * description：
 */
public class DataBindingFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		//fragment的加载方式
		DataBindingSample dataBindingSample = DataBindingUtil.inflate(inflater, R.layout.activity_databind, container, false);
		return dataBindingSample.getRoot();
	}
}
