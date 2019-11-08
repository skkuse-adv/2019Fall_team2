package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import dagger.internal.Preconditions;

public final class AndroidInjection {
    public static void inject(Activity activity) {
        Preconditions.checkNotNull(activity, "activity");
        Application application = activity.getApplication();
        if (application instanceof HasActivityInjector) {
            AndroidInjector activityInjector = ((HasActivityInjector) application).activityInjector();
            Preconditions.checkNotNull(activityInjector, "%s.activityInjector() returned null", application.getClass());
            activityInjector.inject(activity);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), HasActivityInjector.class.getCanonicalName()}));
    }

    public static void inject(Fragment fragment) {
        Preconditions.checkNotNull(fragment, "fragment");
        HasFragmentInjector findHasFragmentInjector = findHasFragmentInjector(fragment);
        if (Log.isLoggable("dagger.android", 3)) {
            String.format("An injector for %s was found in %s", new Object[]{fragment.getClass().getCanonicalName(), findHasFragmentInjector.getClass().getCanonicalName()});
        }
        AndroidInjector fragmentInjector = findHasFragmentInjector.fragmentInjector();
        Preconditions.checkNotNull(fragmentInjector, "%s.fragmentInjector() returned null", findHasFragmentInjector.getClass());
        fragmentInjector.inject(fragment);
    }

    private static HasFragmentInjector findHasFragmentInjector(Fragment fragment) {
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 == null) {
                Activity activity = fragment.getActivity();
                if (activity instanceof HasFragmentInjector) {
                    return (HasFragmentInjector) activity;
                }
                if (activity.getApplication() instanceof HasFragmentInjector) {
                    return (HasFragmentInjector) activity.getApplication();
                }
                throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[]{fragment.getClass().getCanonicalName()}));
            }
        } while (!(fragment2 instanceof HasFragmentInjector));
        return (HasFragmentInjector) fragment2;
    }

    public static void inject(Service service) {
        Preconditions.checkNotNull(service, NotificationCompat.CATEGORY_SERVICE);
        Application application = service.getApplication();
        if (application instanceof HasServiceInjector) {
            AndroidInjector serviceInjector = ((HasServiceInjector) application).serviceInjector();
            Preconditions.checkNotNull(serviceInjector, "%s.serviceInjector() returned null", application.getClass());
            serviceInjector.inject(service);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), HasServiceInjector.class.getCanonicalName()}));
    }

    public static void inject(BroadcastReceiver broadcastReceiver, Context context) {
        Preconditions.checkNotNull(broadcastReceiver, "broadcastReceiver");
        Preconditions.checkNotNull(context, "context");
        Application application = (Application) context.getApplicationContext();
        if (application instanceof HasBroadcastReceiverInjector) {
            AndroidInjector broadcastReceiverInjector = ((HasBroadcastReceiverInjector) application).broadcastReceiverInjector();
            Preconditions.checkNotNull(broadcastReceiverInjector, "%s.broadcastReceiverInjector() returned null", application.getClass());
            broadcastReceiverInjector.inject(broadcastReceiver);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), HasBroadcastReceiverInjector.class.getCanonicalName()}));
    }

    public static void inject(ContentProvider contentProvider) {
        Preconditions.checkNotNull(contentProvider, "contentProvider");
        Application application = (Application) contentProvider.getContext().getApplicationContext();
        if (application instanceof HasContentProviderInjector) {
            AndroidInjector contentProviderInjector = ((HasContentProviderInjector) application).contentProviderInjector();
            Preconditions.checkNotNull(contentProviderInjector, "%s.contentProviderInjector() returned null", application.getClass());
            contentProviderInjector.inject(contentProvider);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{application.getClass().getCanonicalName(), HasContentProviderInjector.class.getCanonicalName()}));
    }
}
