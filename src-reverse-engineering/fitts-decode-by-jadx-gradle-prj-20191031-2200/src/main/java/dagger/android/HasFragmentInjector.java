package dagger.android;

import android.app.Fragment;

public interface HasFragmentInjector {
    AndroidInjector<Fragment> fragmentInjector();
}
