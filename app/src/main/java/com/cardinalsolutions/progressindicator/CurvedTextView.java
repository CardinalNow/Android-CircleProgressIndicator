/*
 * 
 */
package com.cardinalsolutions.progressindicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * CurvedTextView
 * 
 * 
 * @author sking
 * 
 *         Jun 23, 2014 11:15:32 AM
 */
public class CurvedTextView extends TextView {

	private Path myArc;

	private Paint mPaintText;

	public CurvedTextView(Context context, AttributeSet ats, int defStyle) {
		super(context, ats, defStyle);
		init(ats, context);

	}

	public CurvedTextView(Context context, AttributeSet ats) {
		super(context, ats);
		init(ats, context);
	}

	public CurvedTextView(Context context) {
		super(context);
		init(null, context);
	}

	private void init(AttributeSet attrs, Context context) {
		this.myArc = new Path();
		// create paint object
		this.mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
		// set style
		this.mPaintText.setStyle(Paint.Style.FILL_AND_STROKE);
		// set color
		this.mPaintText.setColor(getResources().getColor(R.color.black));
		// set text Size
		this.mPaintText.setTextSize(getResources().getDimension(
		        R.dimen.fifteen_sp));
	}

	@Override
	protected void onDraw(Canvas canvas) {

		int centerXOnView = getWidth() / 2;
		int centerYOnView = getHeight() / 2;

		int viewXCenterOnScreen = getLeft() + centerXOnView;
		int viewYCenterOnScreen = getTop() + centerYOnView;

		float threeDpPad = getResources().getDimension(R.dimen.three_dp);
		float rad = getResources().getDimension(R.dimen.seventy_dp);

		int leftOffset = (int) (viewXCenterOnScreen - (rad + (threeDpPad * 4)));
		int topOffset = (int) (viewYCenterOnScreen - (rad + (threeDpPad * 3)));
		int rightOffset = (int) (viewXCenterOnScreen + (rad + (threeDpPad * 4)));
		int bottomOffset = (int) (viewYCenterOnScreen + (rad + threeDpPad));

		RectF oval = new RectF(leftOffset, topOffset, rightOffset, bottomOffset);

		int textLength = getText().length();
		if ((textLength % 2) != 0) {
			textLength = textLength + 1;
		}

		this.myArc.addArc(oval, -90 - (textLength * 2), 90 + textLength + 10);

		canvas.drawTextOnPath((String) getText(), this.myArc, 0, 10,
		        this.mPaintText);
	}
}
