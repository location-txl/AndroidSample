package androidx.lifecycle;

import android.os.Looper;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianxiaolong
 * time：2019/12/2 20:23
 * description：
 */
public class LiveDataBus {
	private static volatile LiveDataBus instalce;

	public static LiveDataBus getDefault() {
		if (instalce == null) {
			synchronized (LiveDataBus.class) {
				if (instalce == null) {
					instalce = new LiveDataBus();
				}
			}
		}
		return instalce;
	}

	private Map<String, BusLiveData<Object>> channelMap;

	private Map<String, BusLiveData<Object>> stickChannelMap;



	private BusLiveData<Object> getChannelLiveData(String key) {
		if (channelMap == null) {
			channelMap = new HashMap<>();
		}
		BusLiveData<Object> objectBusLiveData = channelMap.get(key);

		if (objectBusLiveData == null) {
			objectBusLiveData = new BusLiveData<>(key);
			channelMap.put(key, objectBusLiveData);
		}
		return objectBusLiveData;
	}

	private BusLiveData<Object> getChannelStickLiveData(String key) {
		if (stickChannelMap == null) {
			stickChannelMap = new HashMap<>();
		}
		BusLiveData<Object> objectBusLiveData = stickChannelMap.get(key);

		if (objectBusLiveData == null) {
			objectBusLiveData = new BusLiveData<>(key);
			stickChannelMap.put(key, objectBusLiveData);
		}
		return objectBusLiveData;
	}

	public <T> void observerStick(String key,LifecycleOwner lifecycleOwner,Observer<T> observer){
		checkNull(key, "observer key is null");
		BusLiveData<Object> channelStickLiveData = getChannelStickLiveData(key);
		ObserberWrapperLifecycle<T> tObserberWrapperLifecycle = new ObserberWrapperLifecycle<>(observer, channelStickLiveData, lifecycleOwner);
		tObserberWrapperLifecycle.setStick(true);
		channelStickLiveData.observe(lifecycleOwner,tObserberWrapperLifecycle);

	}


	public <T> void observer(String key, LifecycleOwner lifecycleOwner, Observer<T> observer) {
		checkNull(key, "observer key is null");
		BusLiveData<Object> objectBusLiveData = getChannelLiveData(key);
		objectBusLiveData.observe(lifecycleOwner,new ObserberWrapperLifecycle<>(observer,objectBusLiveData,lifecycleOwner));
	}



	private void checkNull(String checkMsg, String msg) {
		if (TextUtils.isEmpty(checkMsg)) {
			throw new NullPointerException(msg);
		}
	}

	void removeLiveData(String key){
		if(channelMap!=null){
			channelMap.remove(key);
		}
	}

	public void postValue(String key, Object value) {
		BusLiveData<Object> objectBusLiveData = channelMap.get(key);
		if (isMainThread()) {
			objectBusLiveData.setValue(value);
		} else {
			objectBusLiveData.postValue(value);
		}

	}

	private boolean isMainThread(){
		return Looper.getMainLooper()==Looper.myLooper();
	}





}
