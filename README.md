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

# Including in your project
First declare the JitPack repository:
```
repositories {
        // ...
        maven { url "https://jitpack.io" }
    }
```
Then declare the dependency like this:
```
compile 'com.github.CardinalNow:Android-CircleProgressIndicator:v0.2'
```
This tracks against the tag `v0.2`

# Using in Your Project

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
ProgressBar progressBar = (ProgressBar) findViewById(R.id.circle_progress_bar);
mProgress.setProgress(65);
```

That's all it takes!

# Configuration

There are a number of easily configurable values that you can override in your project.

Any of the values below can be put into your project and changed to re-configure the Circle Progress Indicator.

### Configuration values
* `<dimen name="circleProgressRadius">60dp</dimen>` - This is defines the radius (size) of the circle.
* `<dimen name="circleProgressThickness">7dp</dimen>` - This defines the thickness of the circle ring, where the fill colors are applied.
* `<color name="circleProgressCompleteStartGradient">@color/dark_blue</color>` - This defines the starting color for the gradient that covers the percentage of the progress circle ring that is completed.
* `<color name="circleProgressCompleteEndGradient">@color/coral_blue</color>` - This defines the ending color for the gradient that covers the percentage of the progress circle ring that is completed.
* `<color name="circleProgressIncompleteStartGradient">@color/light_gray</color>` and `<color name="circleProgressIncompleteEndGradient">@color/light_gray</color>` define the gradient for the remaining section of the progress circle. Note that they are by default set to the same color, which acts as a solid fill color.

### How it works

The progress ring is defined in `/res/drawable/circle_progress_foreground.xml`.  The developer can override the dimention and color values:

```XML
<shape
	android:innerRadius="@dimen/circleProgressRadius"
	android:shape="ring"
	android:thickness="@dimen/circleProgressThickness">

<gradient
    android:startColor="@color/circleProgressCompleteStartGradient"
    android:endColor="@color/circleProgressCompleteEndGradient"
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

## Author / License

Copyright Cardinal Solutions 2016. Licensed under the MIT license.
<img src="https://raw.github.com/CardinalNow/NSURLConnection-Debug/master/logo_footer.png"/>
