package com.sun.android.mvvm_sample.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * @author tianxiaolong
 * time：2019/12/23 19:32
 * description：
 */
public class UserData extends BaseObservable {

	private String name;
	private int age;
	private String sax;

	private String url;


	@Bindable
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String content;

	private String defaultName = "默认名字";

	private boolean vissable;

	@Bindable
	public boolean getVissable() {
		return vissable;
	}

	public void setVissable(boolean vissable) {
		this.vissable = vissable;
		notifyPropertyChanged(BR.vissable);
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public UserData(String name, int age, String sax) {
		this.name = name;
		this.age = age;
		this.sax = sax;
		//这个是刷新所有
//		notifyChange();
	}

	/**
	 *  private 修饰的需要在get方法上加入这个注解
	 *  public 修饰的可以直接在变量上加入这个注解
	 * @return
	 */
	@Bindable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		//刷新name
		notifyPropertyChanged(BR.name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSax() {
		return sax;
	}

	public void setSax(String sax) {
		this.sax = sax;
	}
}
