package com.sun.hm_sp_lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.cardemulation.HostNfcFService;
import android.util.ArrayMap;

import java.io.File;

/**
 * @author tianxiaolong
 * time：2020-01-12 17:03
 * description：
 */
public class HmSharedPreferencesUtils {
	private static ArrayMap<String ,HmSharedPreferences> caches  = new ArrayMap<>(3);

	private static String dataFilePath = null;
	public static HmSharedPreferences get(Context context,String key){

		if(dataFilePath == null){
			dataFilePath = context.getFilesDir().getAbsolutePath();
		}
		HmSharedPreferences hmSharedPreferences = caches.get(key);
		if(hmSharedPreferences == null){
			hmSharedPreferences = new HmSharedPreferencesImpl(dataFilePath+ File.separator+key+".xml");
			caches.put(key,hmSharedPreferences);
		}
		return hmSharedPreferences;
	}
}
