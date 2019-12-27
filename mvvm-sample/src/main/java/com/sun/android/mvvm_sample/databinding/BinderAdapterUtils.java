package com.sun.android.mvvm_sample.databinding;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.sun.android.util.Logs;

/**
 * @author tianxiaolong
 * time：2019-12-28 17:38
 * description：
 */
public class BinderAdapterUtils {
	@BindingAdapter("url")
public static void loadImage(ImageView imageView,String url){
	Logs.INSTANCE.D("load image:"+url);
		Glide.with(imageView.getContext()).load(url).into(imageView);
}

	/**
	 * 这里对子类也会有影响 需要注意
	 */
	@BindingAdapter("android:text")
public static void formatText(Button view, String oldText,String text){

		Logs.INSTANCE.D("formatText:"+text+"---oldText:"+oldText);
view.setText("button+"+text);
}
}
