package com.sun.android.mvvm_sample.databinding.bindmethod;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

import com.sun.android.mvvm_sample.R;

/**
 * @author tianxiaolong
 * time：2019-12-29 15:47
 * description：
 */
@BindingMethods({@BindingMethod(type = ProgressView.class,attribute = "progress",method = "setProgress" )})
public class ProgressView extends AppCompatTextView {

	private String progress;

	public ProgressView(Context context) {
		this(context,null);
	}

	public ProgressView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs,0);
	}

	public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context,attrs);
	}

	private Context mContext;
	private void init(Context context, AttributeSet attrs) {
		this.mContext = context;
		TypedArray a = context.getTheme().obtainStyledAttributes(
				attrs, R.styleable.ProgressView, 0, 0);

		progress = a.getString(R.styleable.ProgressView_progress);
		a.recycle();
	}

	public void setProgress(String progress){
		Toast.makeText(mContext, "progress:"+progress, Toast.LENGTH_SHORT).show();
	}


}
