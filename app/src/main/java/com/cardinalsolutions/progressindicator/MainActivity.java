package com.cardinalsolutions.progressindicator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cardinalsolutions.android.arch.autowire.AndroidLayout;
import com.cardinalsolutions.android.arch.autowire.AndroidView;

@AndroidLayout(R.layout.activity_main)
public class MainActivity extends BaseActivity {

	@AndroidView(R.id.circle_progress_bar)
	private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	    mProgress.setProgress(65);

    }

}
