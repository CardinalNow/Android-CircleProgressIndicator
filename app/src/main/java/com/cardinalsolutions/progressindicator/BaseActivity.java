/*
 * 
 */
package com.cardinalsolutions.progressindicator;

import android.app.Activity;
import android.os.Bundle;

import com.cardinalsolutions.android.arch.autowire.AndroidAutowire;

/**
 * BaseActivity
 * 
 * 
 * @author sking
 * 
 *         Oct 27, 2014 9:15:56 AM
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int layoutId = AndroidAutowire.getLayoutResourceByAnnotation(this,
		        this, BaseActivity.class);
		// If this activity is not annotated with AndroidLayout, do nothing
		if (layoutId == 0) {
			return;
		}
		setContentView(layoutId);

	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		AndroidAutowire.autowire(this, BaseActivity.class);
	}
}
