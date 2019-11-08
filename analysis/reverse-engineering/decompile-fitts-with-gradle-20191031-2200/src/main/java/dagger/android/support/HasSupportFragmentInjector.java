package dagger.android.support;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;

public interface HasSupportFragmentInjector {
    AndroidInjector<Fragment> supportFragmentInjector();
}
