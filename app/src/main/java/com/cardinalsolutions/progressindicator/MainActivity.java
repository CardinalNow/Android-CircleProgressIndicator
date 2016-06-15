package com.cardinalsolutions.progressindicator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progress = (ProgressBar) findViewById(R.id.circle_progress_bar);
	    progress.setProgress(33);

    }

}
