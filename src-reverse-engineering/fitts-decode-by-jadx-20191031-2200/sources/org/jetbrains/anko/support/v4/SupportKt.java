package org.jetbrains.anko.support.v4;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.ContextUtilsKt;
import org.jetbrains.anko.Orientation;
import org.jetbrains.anko.ScreenSize;
import org.jetbrains.anko.UiMode;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SupportKt {
    private static final <T extends View> T find(@NotNull Fragment fragment, int i) {
        View view = fragment.getView();
        T findViewById = view != null ? view.findViewById(i) : null;
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    private static final <T extends View> T findOptional(@NotNull Fragment fragment, int i) {
        View view = fragment.getView();
        T findViewById = view != null ? view.findViewById(i) : null;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    @NotNull
    public static final AnkoContext<Fragment> UI(@NotNull Fragment fragment, @NotNull Function1<? super AnkoContext<? extends Fragment>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(requireActivity, fragment, false);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @Nullable
    public static /* synthetic */ Object configuration$default(Fragment fragment, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            screenSize = null;
        }
        if ((i & 2) != 0) {
            closedRange = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            orientation = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        if ((i & 128) != 0) {
            uiMode = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        if ((i & 512) != 0) {
            bool3 = null;
        }
        if ((i & 1024) != 0) {
            num3 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "init");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return function0.invoke();
    }

    @Nullable
    public static final <T> T configuration(@NotNull Fragment fragment, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Fragment fragment2 = fragment;
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "init");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return function0.invoke();
    }

    @NotNull
    public static final <T extends Fragment> T withArguments(@NotNull T t, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        t.setArguments(ContextUtilsKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return t;
    }
}
