package com.sun.android.lifecycle.sample;

import com.sun.android.util.Logs;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author tianxiaolong
 * time：2020/1/15 17:20
 * description：
 */
public class SampleObserver implements LifecycleObserver {

	private Lifecycle lifecycle;


	public SampleObserver(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	/**
	 * 在需要调用的方法上使用OnLifecycleEvent注解来告诉Lifecycle当前方法的事件类型
	 * Lifecycle支持的事件类型后续会以表格写出
	 */
	@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
	public void onCreate() {
		log("onCreate");
//		LifecycleEventObserver lifecycleEventObserver = new  Ob
		getCurentState();
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_START)
	public void onStart() {
		log("onStart");
		getCurentState();
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
	public void onResume() {
		log("onResume");
		getCurentState();
	}


	@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
	public void onPause() {
		log("onPause");
		getCurentState();
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_STOP)
	public void onStop() {
		log("onStop");
		getCurentState();
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_ANY)
	public void onAny(){

	}
	@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
	public void onDestroy() {
		log("onDestroy");
		getCurentState();
	}

//	@OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//	public void onAny(){
//		log("onAny");
//	}


	private void log(String msg) {
		Logs.INSTANCE.I("TestObserver-" + msg);
	}

	public void getCurentState() {
		Lifecycle.State currentState = lifecycle.getCurrentState();
		int type = currentState.compareTo(Lifecycle.State.CREATED);
		log("type:"+type);
		if (currentState == Lifecycle.State.CREATED) {
			log("state is CREATED");
		} else if (currentState == Lifecycle.State.DESTROYED) {
			log("state is DESTROYED");
		} else if (currentState == Lifecycle.State.INITIALIZED) {
			log("state is init");
		} else if (currentState == Lifecycle.State.RESUMED) {
			log("state is RESUMED");
		} else if (currentState == Lifecycle.State.STARTED) {
			log("state is STARTED");
		}
	}


}
