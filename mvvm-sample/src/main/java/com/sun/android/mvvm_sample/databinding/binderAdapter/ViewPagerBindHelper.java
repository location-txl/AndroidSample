package com.sun.android.mvvm_sample.databinding.binderAdapter;

import androidx.databinding.BindingAdapter;
import androidx.databinding.adapters.ListenerUtil;
import androidx.viewpager.widget.ViewPager;

import com.sun.android.mvvm_sample.R;

/**
 * @author tianxiaolong
 * time：2019-12-29 17:15
 * description：
 */
public class ViewPagerBindHelper {
	public static interface OnPageSelectedListener
	{
		void onPageSelected(int position);

	}
	public static interface OnPageScrollStateChangedListener{
		void onPageScrollStateChanged(int state);
	}

	private static final int PAGE_ID = R.id.OnPageChangeListener;
	@BindingAdapter(value = {"onPageSelected","onPageScrollStateChanged"},requireAll = false)
	public static void onPageSelected(ViewPager viewPager,OnPageSelectedListener listener,OnPageScrollStateChangedListener onPageScrollStateChangedListener){

		ViewPager.OnPageChangeListener newListener = null;
		if(listener!=null || onPageScrollStateChangedListener!=null){
			newListener = new ViewPager.OnPageChangeListener() {
				@Override
				public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

				}

				@Override
				public void onPageSelected(int position) {
					if(listener!=null){
						listener.onPageSelected(position);
					}
				}

				@Override
				public void onPageScrollStateChanged(int state) {
    if(onPageScrollStateChangedListener!=null){
    	onPageScrollStateChangedListener.onPageScrollStateChanged(state);
	}
				}
			};
		}
		ViewPager.OnPageChangeListener oldListener = ListenerUtil.trackListener(viewPager, newListener, PAGE_ID);
		if(oldListener!=null){
			viewPager.removeOnPageChangeListener(oldListener);
		}
		if(newListener!=null){
			viewPager.addOnPageChangeListener(newListener);
		}
	}
}
