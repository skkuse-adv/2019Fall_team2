package dagger.android;

import android.app.Activity;

public interface HasActivityInjector {
    AndroidInjector<Activity> activityInjector();
}
