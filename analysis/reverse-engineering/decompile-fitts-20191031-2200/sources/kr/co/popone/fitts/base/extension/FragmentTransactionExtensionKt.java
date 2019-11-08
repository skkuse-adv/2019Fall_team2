package kr.co.popone.fitts.base.extension;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FragmentTransactionExtensionKt {
    public static final void beginTransactionWithAnim(@NotNull AppCompatActivity appCompatActivity, int i, @NotNull Fragment fragment, @NotNull ActivityAnimationType activityAnimationType, @NotNull ActivityAnimationType activityAnimationType2) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        Intrinsics.checkParameterIsNotNull(activityAnimationType, "enter");
        Intrinsics.checkParameterIsNotNull(activityAnimationType2, "exit");
        appCompatActivity.getSupportFragmentManager().beginTransaction().setCustomAnimations(activityAnimationType.getEnter(), activityAnimationType.getExit(), activityAnimationType2.getEnter(), activityAnimationType2.getExit()).replace(i, fragment).addToBackStack(fragment.getTag()).commit();
    }

    public static final void beginTransaction(@NotNull AppCompatActivity appCompatActivity, int i, @NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(i, fragment).addToBackStack(fragment.getTag()).commit();
    }

    public static final int getBackstackCount(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        return supportFragmentManager.getBackStackEntryCount();
    }

    @Nullable
    public static final Fragment getCurrentFragment(@NotNull AppCompatActivity appCompatActivity, int i) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        return appCompatActivity.getSupportFragmentManager().findFragmentById(i);
    }

    public static final void beginTransaction(@NotNull Fragment fragment, int i, @NotNull Fragment fragment2) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        fragment.getChildFragmentManager().beginTransaction().replace(i, fragment2).commit();
    }
}
