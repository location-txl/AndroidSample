package com.sun.android.sample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.Nullable;

/**
 * @author tianxiaolong
 * time：2019/11/29 14:55
 * description：
 */
public class RulerView extends View {

	private int mLineSpacing;

	public RulerView(Context context) {
		this(context, null);
	}

	public RulerView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RulerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}


	private Context mContext;

	private int mScaleColor = Color.RED;

	private int mTextColor = Color.BLACK;

	private int mTextSize = 20;

	private int mMaxLength = 5;

//	private int mItemCount;

	private Paint.Align mTextAlign = Paint.Align.CENTER;

	private Paint mTextPaint, mScalePaint;

	/**
	 * @hide
	 */
	private int mWidth;

	/**
	 * @hide
	 */
	private int mHeight;

	/**
	 * @hide
	 */
	private int mItemWidth;

	/**
	 * @hide
	 */
	private int translateX;

	private List<String> mItems;

	private List<ScaleData> mScaleDatas;

	private List<TextData> mTextDatas;

	private void init(Context context, AttributeSet attrs) {
		this.mContext = context;
		mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setColor(mTextColor);
		mTextPaint.setTextSize(mTextSize);
		mTextPaint.setTextAlign(mTextAlign);
		mScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mScalePaint.setColor(mScaleColor);
		mTextDatas = new ArrayList<>();
		initDefaultItems();
	}

	/**
	 * 默认数据
	 */
	private void initDefaultItems() {
		mItems = new ArrayList<>();
		mItems.add("水瓶座");
		mItems.add("花瓶坐");
		mItems.add("白羊坐");
		mItems.add("双鱼坐");
		mItems.add("处女坐");
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mWidth = getMeasuredWidth();
		mHeight = getMeasuredHeight();
		mItemWidth = mWidth / (mMaxLength - 1);
		mLineSpacing = mItemWidth / 4;
		int startX = 0;
		mScaleDatas = new ArrayList<>();
		for (int i = 0; i < mMaxLength; i++) {
			float[] px = new float[16];
			int tempStartX = startX;
			for (int j = 0; j < 4; j++) {
				int startIndex = j * 4;
				px[startIndex] = tempStartX;
				px[startIndex + 1] = 0;
				px[startIndex + 2] = tempStartX;
				// j == 0 第一条线的刻度长度 其他的比第一条少20长度 这个需要改成动态的
				px[startIndex + 3] = j == 0 ? mHeight / 2 : mHeight / 2 - 20;
				tempStartX += mLineSpacing;
			}
			startX += mItemWidth;
			mScaleDatas.add(new ScaleData(px));
		}

		measureText();


	}

	private void measureText() {
		AtomicInteger index = new AtomicInteger();
		mTextDatas.clear();
		mItems.forEach(it -> {
			/**
			 * mHeight/2 是下方字体的y轴位置
			 */
			TextData textData = new TextData(it, index.get() * mItemWidth, mHeight / 2);
			mTextDatas.add(textData);
			index.addAndGet(1);
		});

	}

	private float downX;

	/**
	 * 处理点击事件
	 *
	 * @param event
	 * @return
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		float x = event.getX();
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				downX = x;
				break;
			case MotionEvent.ACTION_MOVE:
				translateX += -(x - downX);
				downX = x;
				invalidate();
				break;
			case MotionEvent.ACTION_UP:
				int i = translateX % mItemWidth;
				if (i == 0) return true;
				if (i > mItemWidth / 2) {
					translateX += (mItemWidth - i);
					invalidate();
				} else {
					translateX -= i;
					invalidate();
				}
				break;
			default:
		}
		return true;
	}

	@Override
	protected void onDraw(final Canvas canvas) {
		super.onDraw(canvas);
		mScaleDatas.forEach(it -> canvas.drawLines(it.pts, mScalePaint));
		mTextDatas.forEach(it -> canvas.drawText(it.text, it.x - translateX, it.y, mTextPaint));
	}


	/**
	 * 刻度尺
	 */
	private static class ScaleData {
		float[] pts;

		public ScaleData(float[] pts) {
			this.pts = pts;
		}
	}


	private static class TextData {
		String text;
		float x;
		float y;

		public TextData(String text, float x, float y) {
			this.text = text;
			this.x = x;
			this.y = y;
		}
	}

}
