package org.jetbrains.anko.support.v4;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class __ViewPager_OnPageChangeListener implements OnPageChangeListener {
    private Function1<? super Integer, Unit> _onPageScrollStateChanged;
    private Function3<? super Integer, ? super Float, ? super Integer, Unit> _onPageScrolled;
    private Function1<? super Integer, Unit> _onPageSelected;

    public void onPageScrolled(int i, float f, int i2) {
        Function3<? super Integer, ? super Float, ? super Integer, Unit> function3 = this._onPageScrolled;
        if (function3 != null) {
            Unit unit = (Unit) function3.invoke(Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2));
        }
    }

    public final void onPageScrolled(@NotNull Function3<? super Integer, ? super Float, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onPageScrolled = function3;
    }

    public void onPageSelected(int i) {
        Function1<? super Integer, Unit> function1 = this._onPageSelected;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(Integer.valueOf(i));
        }
    }

    public final void onPageSelected(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "listener");
        this._onPageSelected = function1;
    }

    public void onPageScrollStateChanged(int i) {
        Function1<? super Integer, Unit> function1 = this._onPageScrollStateChanged;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(Integer.valueOf(i));
        }
    }

    public final void onPageScrollStateChanged(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "listener");
        this._onPageScrollStateChanged = function1;
    }
}
