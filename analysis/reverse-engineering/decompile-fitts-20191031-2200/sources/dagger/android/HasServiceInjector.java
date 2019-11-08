package dagger.android;

import android.app.Service;

public interface HasServiceInjector {
    AndroidInjector<Service> serviceInjector();
}
