package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class IntentsKt {
    private static final <T extends Activity> void startActivity(@NotNull Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStartActivity(context, Activity.class, pairArr);
    }

    private static final <T extends Activity> void startActivity(@NotNull AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStartActivity(ctx, Activity.class, pairArr);
    }

    private static final <T extends Activity> void startActivity(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStartActivity(activity, Activity.class, pairArr);
    }

    private static final <T extends Activity> void startActivityForResult(@NotNull Activity activity, int i, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStartActivityForResult(activity, Activity.class, i, pairArr);
    }

    private static final <T extends Service> ComponentName startService(@NotNull Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.internalStartService(context, Service.class, pairArr);
    }

    private static final <T extends Service> ComponentName startService(@NotNull AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.internalStartService(ctx, Service.class, pairArr);
    }

    private static final <T extends Service> ComponentName startService(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.internalStartService(activity, Service.class, pairArr);
    }

    private static final <T extends Service> boolean stopService(@NotNull Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.internalStopService(context, Service.class, pairArr);
    }

    private static final <T extends Service> boolean stopService(@NotNull AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.internalStopService(ctx, Service.class, pairArr);
    }

    private static final <T extends Service> boolean stopService(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.internalStopService(activity, Service.class, pairArr);
    }

    private static final <T> Intent intentFor(@NotNull Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.createIntent(context, Object.class, pairArr);
    }

    private static final <T> Intent intentFor(@NotNull AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.createIntent(ctx, Object.class, pairArr);
    }

    private static final <T> Intent intentFor(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoInternals.createIntent(activity, Object.class, pairArr);
    }

    @NotNull
    public static final Intent clearTask(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(32768);
        return intent;
    }

    @NotNull
    public static final Intent clearTop(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(67108864);
        return intent;
    }

    @NotNull
    public static final Intent clearWhenTaskReset(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(524288);
        return intent;
    }

    @NotNull
    public static final Intent newDocument(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        if (VERSION.SDK_INT >= 21) {
            intent.addFlags(524288);
        } else {
            intent.addFlags(524288);
        }
        return intent;
    }

    @NotNull
    public static final Intent excludeFromRecents(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(8388608);
        return intent;
    }

    @NotNull
    public static final Intent multipleTask(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(134217728);
        return intent;
    }

    @NotNull
    public static final Intent newTask(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(268435456);
        return intent;
    }

    @NotNull
    public static final Intent noAnimation(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(65536);
        return intent;
    }

    @NotNull
    public static final Intent noHistory(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(1073741824);
        return intent;
    }

    @NotNull
    public static final Intent singleTop(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "receiver$0");
        intent.addFlags(536870912);
        return intent;
    }

    public static final boolean browse(@NotNull AnkoContext<?> ankoContext, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return browse(ankoContext.getCtx(), str, z);
    }

    public static /* synthetic */ boolean browse$default(AnkoContext ankoContext, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return browse(ankoContext.getCtx(), str, z);
    }

    public static final boolean browse(@NotNull Fragment fragment, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return browse((Context) activity, str, z);
    }

    public static /* synthetic */ boolean browse$default(Fragment fragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return browse((Context) activity, str, z);
    }

    public static /* synthetic */ boolean browse$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return browse(context, str, z);
    }

    public static final boolean browse(@NotNull Context context, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (z) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean share(@NotNull AnkoContext<?> ankoContext, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        return share(ankoContext.getCtx(), str, str2);
    }

    public static /* synthetic */ boolean share$default(AnkoContext ankoContext, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        return share(ankoContext.getCtx(), str, str2);
    }

    public static final boolean share(@NotNull Fragment fragment, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return share((Context) activity, str, str2);
    }

    public static /* synthetic */ boolean share$default(Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return share((Context) activity, str, str2);
    }

    public static /* synthetic */ boolean share$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return share(context, str, str2);
    }

    public static final boolean share(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            intent.putExtra("android.intent.extra.TEXT", str);
            context.startActivity(Intent.createChooser(intent, null));
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean email(@NotNull AnkoContext<?> ankoContext, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        return email(ankoContext.getCtx(), str, str2, str3);
    }

    public static /* synthetic */ boolean email$default(AnkoContext ankoContext, String str, String str2, String str3, int i, Object obj) {
        String str4 = "";
        if ((i & 2) != 0) {
            str2 = str4;
        }
        if ((i & 4) != 0) {
            str3 = str4;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        return email(ankoContext.getCtx(), str, str2, str3);
    }

    public static final boolean email(@NotNull Fragment fragment, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return email((Context) activity, str, str2, str3);
    }

    public static /* synthetic */ boolean email$default(Fragment fragment, String str, String str2, String str3, int i, Object obj) {
        String str4 = "";
        if ((i & 2) != 0) {
            str2 = str4;
        }
        if ((i & 4) != 0) {
            str3 = str4;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return email((Context) activity, str, str2, str3);
    }

    public static /* synthetic */ boolean email$default(Context context, String str, String str2, String str3, int i, Object obj) {
        String str4 = "";
        if ((i & 2) != 0) {
            str2 = str4;
        }
        if ((i & 4) != 0) {
            str3 = str4;
        }
        return email(context, str, str2, str3);
    }

    public static final boolean email(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (str2.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (str3.length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        }
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }

    public static final boolean makeCall(@NotNull AnkoContext<?> ankoContext, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        return makeCall(ankoContext.getCtx(), str);
    }

    public static final boolean makeCall(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return makeCall((Context) activity, str);
    }

    public static final boolean makeCall(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("tel:");
            sb.append(str);
            context.startActivity(new Intent("android.intent.action.CALL", Uri.parse(sb.toString())));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean sendSMS(@NotNull AnkoContext<?> ankoContext, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        return sendSMS(ankoContext.getCtx(), str, str2);
    }

    public static /* synthetic */ boolean sendSMS$default(AnkoContext ankoContext, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        return sendSMS(ankoContext.getCtx(), str, str2);
    }

    public static final boolean sendSMS(@NotNull Fragment fragment, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sendSMS((Context) activity, str, str2);
    }

    public static /* synthetic */ boolean sendSMS$default(Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sendSMS((Context) activity, str, str2);
    }

    public static /* synthetic */ boolean sendSMS$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return sendSMS(context, str, str2);
    }

    public static final boolean sendSMS(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("sms:");
            sb.append(str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.putExtra("sms_body", str2);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static final <T extends Activity> void startActivityForResult(@NotNull Fragment fragment, int i, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        fragment.startActivityForResult(AnkoInternals.createIntent(activity, Activity.class, pairArr), i);
    }
}
