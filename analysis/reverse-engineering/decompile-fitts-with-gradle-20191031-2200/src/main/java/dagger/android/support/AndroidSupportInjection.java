package dagger.android.support;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import dagger.android.AndroidInjector;
import dagger.internal.Preconditions;

public final class AndroidSupportInjection {
    public static void inject(Fragment fragment) {
        Preconditions.checkNotNull(fragment, "fragment");
        HasSupportFragmentInjector findHasFragmentInjector = findHasFragmentInjector(fragment);
        if (Log.isLoggable("dagger.android.support", 3)) {
            String.format("An injector for %s was found in %s", new Object[]{fragment.getClass().getCanonicalName(), findHasFragmentInjector.getClass().getCanonicalName()});
        }
        AndroidInjector supportFragmentInjector = findHasFragmentInjector.supportFragmentInjector();
        Preconditions.checkNotNull(supportFragmentInjector, "%s.supportFragmentInjector() returned null", findHasFragmentInjector.getClass());
        supportFragmentInjector.inject(fragment);
    }

    private static HasSupportFragmentInjector findHasFragmentInjector(Fragment fragment) {
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 == null) {
                FragmentActivity activity = fragment.getActivity();
                if (activity instanceof HasSupportFragmentInjector) {
                    return (HasSupportFragmentInjector) activity;
                }
                if (activity.getApplication() instanceof HasSupportFragmentInjector) {
                    return (HasSupportFragmentInjector) activity.getApplication();
                }
                throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[]{fragment.getClass().getCanonicalName()}));
            }
        } while (!(fragment2 instanceof HasSupportFragmentInjector));
        return (HasSupportFragmentInjector) fragment2;
    }
}
