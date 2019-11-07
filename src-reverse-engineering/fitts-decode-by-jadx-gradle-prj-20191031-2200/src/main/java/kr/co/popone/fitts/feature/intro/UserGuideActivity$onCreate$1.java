package kr.co.popone.fitts.feature.intro;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import org.jetbrains.annotations.NotNull;

public final class UserGuideActivity$onCreate$1 extends FragmentPagerAdapter {
    public int getCount() {
        return 3;
    }

    UserGuideActivity$onCreate$1(UserGuideActivity userGuideActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NotNull
    public Fragment getItem(int i) {
        if (i == 0) {
            return new UserGuide1Fragment();
        }
        if (i == 1) {
            return new UserGuide2Fragment();
        }
        if (i == 2) {
            return new UserGuide3Fragment();
        }
        throw new IllegalAccessException();
    }
}
