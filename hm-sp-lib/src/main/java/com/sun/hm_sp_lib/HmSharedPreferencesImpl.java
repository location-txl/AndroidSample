package com.sun.hm_sp_lib;

import android.text.TextUtils;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tianxiaolong
 * time：2020-01-12 17:02
 * description：
 */
public class HmSharedPreferencesImpl implements HmSharedPreferences {

	private static final String ELEMENT_KEY = "key";
	private static final String ELEMENT_STRING = "String";
	private static final String ELEMENT_SET = "Set";
	private static final String ELEMENT_SET_VALUE = "set_value";
	 static final String ELEMENT_START_DOMENT = "sps";
	private String path;


	private Map<String, Object> data = new HashMap<String, Object>();

	public HmSharedPreferencesImpl(String path) {
		this.path = path;

		File file = new File(path);
		if(!file.exists()){
			// 文件不存在 停止解析
			return;
		}
		XmlPullParser parser = Xml.newPullParser();
		InputStream inputStream = null;
		try {
			 inputStream = new FileInputStream(file);
			parser.setInput(inputStream,"utf-8");
			int eventType = parser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT){

				switch (eventType){

					case XmlPullParser.START_DOCUMENT:
						// 开始
						break;
					case XmlPullParser.START_TAG:
						String tag = parser.getName();
						parseTag(tag,parser);
						//标签开始
						break;
					case XmlPullParser.END_TAG:
						//标签结束
						String endTag = parser.getName();
						if(ELEMENT_SET.equals(endTag)){
							lastKey = null;
						}
						break;

						default:
				}
				eventType = parser.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream !=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String lastKey;
	private void parseTag(String tag,XmlPullParser pullParser) throws IOException, XmlPullParserException {

		switch (tag){
			case ELEMENT_SET:
				String key = pullParser.getAttributeValue(null, ELEMENT_KEY);
				Set<String> startSet = new HashSet<>();
				data.put(key,startSet);
				lastKey = key;
				break;
			case ELEMENT_SET_VALUE:
				if(!TextUtils.isEmpty(lastKey)){
					String value = pullParser.nextText();
					Set<String> set = (Set<String>) data.get(lastKey);
					if(set == null){
						break;
					}
					set.add(value);
				}
				break;
				default:
		}
	}


	@Override
	public <T> T get(String key, T defaultValue) {
		Object o = data.get(key);
		if(o == null){
			return defaultValue;
		}
		return (T) o;
	}

	@Override
	public HmEditor editor() {
		return new EditorImpl();
	}

	private class EditorImpl implements HmEditor{
		private  boolean dataChange = false;
        final Map<String,Object> edData;
		{
			edData = new HashMap<>(data);
		}
		@Override
		public void putSet(String key, Set<String> stringSet) {
			praseChange();
			Object oldSet = edData.put(key, stringSet);
			if(oldSet instanceof Set){
				((Set) oldSet).clear();
			}
		}

		@Override
		public void putString(String key, String value) {
			praseChange();
               edData.put(key,value);
		}

		@Override
		public void remove(String key) {
			praseChange();
             edData.remove(key);
		}

		@Override
		public void clear() {
			  praseChange();
              edData.clear();
		}


		void praseChange(){
			if(!dataChange){
				dataChange = true;
			}
		}
		@Override
		public void apply() {
             if(dataChange){
             	   data.clear();
             	   data.putAll(edData);

			 }
		}
	}
}
