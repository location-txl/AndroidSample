package com.sun.android.lifecycle.sample;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.sun.android.util.Logs;

/**
 * @author tianxiaolong
 * time：2020-02-04 11:20
 * description：
 */
public class FullLifecycleObserverSample implements LifecycleEventObserver {
	@Override
	public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
		Logs.INSTANCE.D("LifecycleEventObserver event:"+event.name());
	}
}
