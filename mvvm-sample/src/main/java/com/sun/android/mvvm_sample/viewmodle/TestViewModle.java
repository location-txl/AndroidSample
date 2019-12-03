package com.sun.android.mvvm_sample.viewmodle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author tianxiaolong
 * time：2019/12/2 16:14
 * description：
 */
public class TestViewModle extends ViewModel {
	public int a =0;
	public MutableLiveData<String> liveData = new MutableLiveData<>();

	public void setValue(String msg){
		liveData.postValue(msg);
	}
}
