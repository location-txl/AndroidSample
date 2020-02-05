package com.sun.android.mvvm_sample.databinding.bindmethod;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.sun.android.util.Logs;

/**
 * @author tianxiaolong
 * time：2019-12-29 15:55
 * description：
 */
public class ProgressData  extends BaseObservable {
	@Bindable
	public String progress;

	public int pos;

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
		Logs.INSTANCE.D("pos:"+pos);
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
		notifyPropertyChanged(BR.progress);
	}
}
