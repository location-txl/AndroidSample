package com.sun.hm_sp_lib;

import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

/**
 * @author tianxiaolong
 * time：2020-01-12 17:47
 * description：
 */
public final class HmThread extends Thread {

	private Map<String,Object> data;

	private String path;
	public HmThread(Map<String, Object> data,String path) {
		this.data = data;
		this.path = path;
	}

	@Override
	public void run() {
		super.run();
		Set<String> set = data.keySet();
		XmlSerializer xmlSerializer = Xml.newSerializer();
		try {
			OutputStream outputStream = new FileOutputStream(path);
			xmlSerializer.setOutput(outputStream,"UTF-8");
			xmlSerializer.startDocument("UTF-8", true);
			xmlSerializer.startTag(null, HmSharedPreferencesImpl.ELEMENT_START_DOMENT);
			xmlSerializer.flush();


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		synchronized (this){
			notifyAll();
		}
	}
}
