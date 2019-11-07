package org.jetbrains.anko;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextUtilsKt {
    public static /* synthetic */ void act$annotations(Activity activity) {
    }

    public static /* synthetic */ void act$annotations(Fragment fragment) {
    }

    public static /* synthetic */ void ctx$annotations(Fragment fragment) {
    }

    public static /* synthetic */ void ctx$annotations(Context context) {
    }

    public static /* synthetic */ void defaultSharedPreferences$annotations(Fragment fragment) {
    }

    @NotNull
    public static final Activity getAct(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        return activity;
    }

    @NotNull
    public static final Context getCtx(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return context;
    }

    @NotNull
    public static final Resources getResources(@NotNull AnkoContext<?> ankoContext) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Resources resources = ankoContext.getCtx().getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "ctx.resources");
        return resources;
    }

    @NotNull
    public static final AssetManager getAssets(@NotNull AnkoContext<?> ankoContext) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        AssetManager assets = ankoContext.getCtx().getAssets();
        Intrinsics.checkExpressionValueIsNotNull(assets, "ctx.assets");
        return assets;
    }

    @NotNull
    public static final SharedPreferences getDefaultSharedPreferences(@NotNull AnkoContext<?> ankoContext) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ankoContext.getCtx());
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDefaultSharedPreferences(ctx)");
        return defaultSharedPreferences;
    }

    @NotNull
    public static final SharedPreferences getDefaultSharedPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
        return defaultSharedPreferences;
    }

    @NotNull
    public static final SharedPreferences getDefaultSharedPreferences(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(fragment.getActivity());
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…aredPreferences(activity)");
        return defaultSharedPreferences;
    }

    @NotNull
    public static final Activity getAct(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return activity;
    }

    @NotNull
    public static final Context getCtx(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return activity;
    }

    private static final <T extends View> T find(@NotNull View view, @IdRes int i) {
        T findViewById = view.findViewById(i);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(id)");
        return findViewById;
    }

    private static final <T extends View> T find(@NotNull Activity activity, @IdRes int i) {
        T findViewById = activity.findViewById(i);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(id)");
        return findViewById;
    }

    private static final <T extends View> T find(@NotNull Fragment fragment, @IdRes int i) {
        View view = fragment.getView();
        T findViewById = view != null ? view.findViewById(i) : null;
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    private static final <T extends View> T find(@NotNull Dialog dialog, @IdRes int i) {
        T findViewById = dialog.findViewById(i);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(id)");
        return findViewById;
    }

    private static final <T extends View> T findOptional(@NotNull View view, @IdRes int i) {
        T findViewById = view.findViewById(i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    private static final <T extends View> T findOptional(@NotNull Activity activity, @IdRes int i) {
        T findViewById = activity.findViewById(i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    private static final <T extends View> T findOptional(@NotNull Fragment fragment, @IdRes int i) {
        View view = fragment.getView();
        T findViewById = view != null ? view.findViewById(i) : null;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    private static final <T extends View> T findOptional(@NotNull Dialog dialog, @IdRes int i) {
        T findViewById = dialog.findViewById(i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return findViewById;
    }

    @NotNull
    public static final <T extends Fragment> T withArguments(@NotNull T t, @NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        t.setArguments(bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return t;
    }

    @NotNull
    public static final Bundle bundleOf(@NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        Bundle bundle = new Bundle();
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                bundle.putSerializable(str, null);
            } else if (component2 instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Byte) {
                bundle.putByte(str, ((Number) component2).byteValue());
            } else if (component2 instanceof Character) {
                bundle.putChar(str, ((Character) component2).charValue());
            } else if (component2 instanceof Short) {
                bundle.putShort(str, ((Number) component2).shortValue());
            } else if (component2 instanceof Integer) {
                bundle.putInt(str, ((Number) component2).intValue());
            } else if (component2 instanceof Long) {
                bundle.putLong(str, ((Number) component2).longValue());
            } else if (component2 instanceof Float) {
                bundle.putFloat(str, ((Number) component2).floatValue());
            } else if (component2 instanceof Double) {
                bundle.putDouble(str, ((Number) component2).doubleValue());
            } else if (component2 instanceof String) {
                bundle.putString(str, (String) component2);
            } else if (component2 instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) component2);
            } else if (component2 instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) component2);
            } else if (component2 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) component2);
            } else if (component2 instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) component2);
            } else if (component2 instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) component2);
            } else if (component2 instanceof char[]) {
                bundle.putCharArray(str, (char[]) component2);
            } else if (component2 instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) component2);
            } else if (component2 instanceof float[]) {
                bundle.putFloatArray(str, (float[]) component2);
            } else if (component2 instanceof int[]) {
                bundle.putIntArray(str, (int[]) component2);
            } else if (component2 instanceof long[]) {
                bundle.putLongArray(str, (long[]) component2);
            } else {
                String str2 = "Unsupported bundle component (";
                if (component2 instanceof Object[]) {
                    Object[] objArr = (Object[]) component2;
                    if (objArr instanceof Parcelable[]) {
                        if (component2 != null) {
                            bundle.putParcelableArray(str, (Parcelable[]) component2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<out android.os.Parcelable>");
                        }
                    } else if (objArr instanceof CharSequence[]) {
                        if (component2 != null) {
                            bundle.putCharSequenceArray(str, (CharSequence[]) component2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<out kotlin.CharSequence>");
                        }
                    } else if (!(objArr instanceof String[])) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(objArr.getClass());
                        sb.append(')');
                        throw new AnkoException(sb.toString());
                    } else if (component2 != null) {
                        bundle.putStringArray(str, (String[]) component2);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<out kotlin.String>");
                    }
                } else if (component2 instanceof short[]) {
                    bundle.putShortArray(str, (short[]) component2);
                } else if (component2 instanceof Bundle) {
                    bundle.putBundle(str, (Bundle) component2);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(component2.getClass());
                    sb2.append(')');
                    throw new AnkoException(sb2.toString());
                }
            }
        }
        return bundle;
    }

    @NotNull
    public static final DisplayMetrics getDisplayMetrics(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkExpressionValueIsNotNull(displayMetrics, "resources.displayMetrics");
        return displayMetrics;
    }

    @NotNull
    public static final Configuration getConfiguration(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkExpressionValueIsNotNull(configuration, "resources.configuration");
        return configuration;
    }

    @NotNull
    public static final DisplayMetrics getDisplayMetrics(@NotNull AnkoContext<?> ankoContext) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Resources resources = ankoContext.getCtx().getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "ctx.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkExpressionValueIsNotNull(displayMetrics, "ctx.resources.displayMetrics");
        return displayMetrics;
    }

    @NotNull
    public static final Configuration getConfiguration(@NotNull AnkoContext<?> ankoContext) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Resources resources = ankoContext.getCtx().getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "ctx.resources");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkExpressionValueIsNotNull(configuration, "ctx.resources.configuration");
        return configuration;
    }

    public static final boolean getPortrait(@NotNull Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "receiver$0");
        return configuration.orientation == 1;
    }

    public static final boolean getLandscape(@NotNull Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "receiver$0");
        return configuration.orientation == 2;
    }

    public static final boolean getLong(@NotNull Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "receiver$0");
        return (configuration.screenLayout & 32) != 0;
    }

    @Nullable
    public static final View getContentView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            findViewById = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        if (viewGroup != null) {
            return viewGroup.getChildAt(0);
        }
        return null;
    }
}
