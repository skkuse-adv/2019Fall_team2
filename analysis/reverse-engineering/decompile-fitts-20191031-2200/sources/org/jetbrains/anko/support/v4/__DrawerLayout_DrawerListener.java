package org.jetbrains.anko.support.v4;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class __DrawerLayout_DrawerListener implements DrawerListener {
    private Function1<? super View, Unit> _onDrawerClosed;
    private Function1<? super View, Unit> _onDrawerOpened;
    private Function2<? super View, ? super Float, Unit> _onDrawerSlide;
    private Function1<? super Integer, Unit> _onDrawerStateChanged;

    public void onDrawerSlide(@NotNull View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "drawerView");
        Function2<? super View, ? super Float, Unit> function2 = this._onDrawerSlide;
        if (function2 != null) {
            Unit unit = (Unit) function2.invoke(view, Float.valueOf(f));
        }
    }

    public final void onDrawerSlide(@NotNull Function2<? super View, ? super Float, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "listener");
        this._onDrawerSlide = function2;
    }

    public void onDrawerOpened(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "drawerView");
        Function1<? super View, Unit> function1 = this._onDrawerOpened;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(view);
        }
    }

    public final void onDrawerOpened(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "listener");
        this._onDrawerOpened = function1;
    }

    public void onDrawerClosed(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "drawerView");
        Function1<? super View, Unit> function1 = this._onDrawerClosed;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(view);
        }
    }

    public final void onDrawerClosed(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "listener");
        this._onDrawerClosed = function1;
    }

    public void onDrawerStateChanged(int i) {
        Function1<? super Integer, Unit> function1 = this._onDrawerStateChanged;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(Integer.valueOf(i));
        }
    }

    public final void onDrawerStateChanged(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "listener");
        this._onDrawerStateChanged = function1;
    }
}
