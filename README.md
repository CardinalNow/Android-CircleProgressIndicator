# Android Circle Progress Indicator

This widget is a cutomized version of the Android ProgressBar.  It provides developers the ability to add a dynamically populated progress circle with gradient.

## Features

* Increase or decrease progress changes
* Modifiable
 * Ring width
 * Ring background color
 * Ring fill color
 * Ring gradient

# Requirements

Compatible with all versions of the Android operating system

# Icluding in your project
First declare the JitPack repository:
```
repositories {
        // ...
        maven { url "https://jitpack.io" }
    }
```
Then declare the dependency like this:
```
compile 'com.github.CardinalNow:Android-CircleProgressIndicator:-SNAPSHOT'
```
Using `-SNAPSHOT` will get you the latest commit.

# Configuration

The progress ring is defined in /res/drawable/circle_progress_foreground.xml.  The developer can modify the ring thickness inside the applicable tags:

```XML
<shape
	android:innerRadius="@dimen/sixty_dp"
	android:shape="ring"
	android:thickness="@dimen/seven_dp">

<gradient
    android:startColor="@color/dark_blue"
    android:endColor="@color/coral_blue"
    android:type="sweep" />   

</shape>
```

* innerRadius defines the size of the hole inside the ring (in dp)
* thickness defines the width of the bar that goes around the outside of the ring (in dp)
* startColor/endColor defines the beginning and ending colors of the gradient as it travels around the ring
 * the operating system transitions the between colors for you
* sweep defines the type of gradient

The developer can also modify the background ring (in this screen shot, the gray ring).  It is defined (with same tags) in /res/drawable/circle_progress_background.xml.

![Screen at Launch](https://github.com/kingws/AndroidCirleProgressIndicator/blob/master/img/screen_shot.png)

To use this in your application, just add two progress bars in your layout.xml on top of each other.  Set the background on the first one to circle_progress_background, and the background on the second to circle_progress_foreground:

```XML
<ProgressBar
		style="?android:attr/progressBarStyleHorizontal"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:layout_centerInParent="true"
		android:indeterminate="false"
		android:max="100"
		android:progress="100"
		android:progressDrawable="@drawable/circle_progress_background" />

<ProgressBar
		android:id="@+id/circle_progress_bar"
		style="?android:attr/progressBarStyleHorizontal"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:layout_centerInParent="true"
		android:max="100"
		android:rotation="-90"
		android:indeterminate="false"
		android:progressDrawable="@drawable/circle_progress_foreground" />
```

*Note: the foreground progress bar android:rotation tag needs to be set to -90 to start the progress at 0*

Inside the activity, declare the ProgressBar you've defined as the foreground circle, and set it's progress:

```Java
@AndroidView(R.id.circle_progress_bar)
private ProgressBar mProgress;	

...
mProgress.setProgress(65);
```

That's all it takes!!

## Bonus Material

This app is utilizing the [AndroidAutowire](https://github.com/CardinalNow/AndroidAutowire) library to wire up the views.  While not necessary, it's a great tool that will reduce your boilerplate setup for Activities, Fragments, and Views with an annotation based approach.

## Author / License

Copyright Cardinal Solutions 2013. Licensed under the MIT license.
<img src="https://raw.github.com/CardinalNow/NSURLConnection-Debug/master/logo_footer.png"/>
