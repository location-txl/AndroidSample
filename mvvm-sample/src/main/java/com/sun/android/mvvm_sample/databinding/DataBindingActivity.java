package com.sun.android.mvvm_sample.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.sun.android.mvvm_sample.R;
import com.sun.android.mvvm_sample.databinding.bindmethod.BindingMethodActivity;
import com.sun.android.util.Logs;
import com.sun.android.util.UtilsKt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;

/**
 * @author tianxiaolong
 * time：2019/12/23 18:59
 * description：
 */
public class DataBindingActivity extends AppCompatActivity {

	private DataBindingSample activityDatabindBinding;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityDatabindBinding = DataBindingUtil.setContentView(this, R.layout.activity_databind);
		ObservableArrayList<String> list = new ObservableArrayList<>();
		list.add("list文本");
		activityDatabindBinding.setList(list);
		activityDatabindBinding.dataButton.setOnClickListener(v -> activityDatabindBinding.setTitle(String.valueOf(System.currentTimeMillis())));
		UserData userData = new UserData(null,1,"a");
		userData.setUrl("http://img5.imgtn.bdimg.com/it/u=3373541372,149267451&fm=26&gp=0.jpg");
		/**
		 * 数据的更新监听
		 */
		userData.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
			@Override
			public void onPropertyChanged(Observable sender, int propertyId) {
				Logs.INSTANCE.I("DataBindingActivity","onPropertyChanged propertyId:"+propertyId);
			}
		});
		activityDatabindBinding.setUser(userData);
		activityDatabindBinding.setOnclick(v -> {userData.setName("姓名");
		userData.setVissable(true);});
		/**
		 * 这里测试双向数据绑定
		 */
        activityDatabindBinding.buttonUserContent.setOnClickListener(v -> Logs.INSTANCE.I("DataBindingActivity","user.content:"+userData.getContent()));

activityDatabindBinding.testButton.setOnClickListener(v ->
	startActivity(new Intent(this,BinderDataSampleActivity.class))
);
activityDatabindBinding.jumpBinderMethod.setOnClickListener(v -> UtilsKt.startActivity(this, BindingMethodActivity.class));
	}

}
