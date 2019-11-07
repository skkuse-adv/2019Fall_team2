package dagger.android;

import android.content.ContentProvider;

public interface HasContentProviderInjector {
    AndroidInjector<ContentProvider> contentProviderInjector();
}
