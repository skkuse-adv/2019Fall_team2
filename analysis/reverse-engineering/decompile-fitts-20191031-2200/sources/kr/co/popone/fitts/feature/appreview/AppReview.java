package kr.co.popone.fitts.feature.appreview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppReview {
    public static final AppReview INSTANCE = new AppReview();
    @NotNull
    public static final String PREFERENCES_KEY = "appreview_key";
    private static int appLaunchCount;
    private static int appReviewDialogShowCount;
    /* access modifiers changed from: private */
    public static boolean appReviewShown;
    private static boolean canShowDialogAfterLike;
    private static final Gson gson = new Gson();
    private static int likeCount;
    private static SharedPreferences sharedPreferences;

    public static final class AppReviewData {
        private final int appLaunchCount;
        private final int appReviewDialogShowCount;
        private final boolean appReviewShown;
        private final int likeCount;

        @NotNull
        public static /* synthetic */ AppReviewData copy$default(AppReviewData appReviewData, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = appReviewData.likeCount;
            }
            if ((i4 & 2) != 0) {
                i2 = appReviewData.appLaunchCount;
            }
            if ((i4 & 4) != 0) {
                i3 = appReviewData.appReviewDialogShowCount;
            }
            if ((i4 & 8) != 0) {
                z = appReviewData.appReviewShown;
            }
            return appReviewData.copy(i, i2, i3, z);
        }

        public final int component1() {
            return this.likeCount;
        }

        public final int component2() {
            return this.appLaunchCount;
        }

        public final int component3() {
            return this.appReviewDialogShowCount;
        }

        public final boolean component4() {
            return this.appReviewShown;
        }

        @NotNull
        public final AppReviewData copy(int i, int i2, int i3, boolean z) {
            return new AppReviewData(i, i2, i3, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof AppReviewData) {
                    AppReviewData appReviewData = (AppReviewData) obj;
                    if (this.likeCount == appReviewData.likeCount) {
                        if (this.appLaunchCount == appReviewData.appLaunchCount) {
                            if (this.appReviewDialogShowCount == appReviewData.appReviewDialogShowCount) {
                                if (this.appReviewShown == appReviewData.appReviewShown) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = ((((this.likeCount * 31) + this.appLaunchCount) * 31) + this.appReviewDialogShowCount) * 31;
            boolean z = this.appReviewShown;
            if (z) {
                z = true;
            }
            return i + (z ? 1 : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AppReviewData(likeCount=");
            sb.append(this.likeCount);
            sb.append(", appLaunchCount=");
            sb.append(this.appLaunchCount);
            sb.append(", appReviewDialogShowCount=");
            sb.append(this.appReviewDialogShowCount);
            sb.append(", appReviewShown=");
            sb.append(this.appReviewShown);
            sb.append(")");
            return sb.toString();
        }

        public AppReviewData(int i, int i2, int i3, boolean z) {
            this.likeCount = i;
            this.appLaunchCount = i2;
            this.appReviewDialogShowCount = i3;
            this.appReviewShown = z;
        }

        public final int getAppLaunchCount() {
            return this.appLaunchCount;
        }

        public final int getAppReviewDialogShowCount() {
            return this.appReviewDialogShowCount;
        }

        public final boolean getAppReviewShown() {
            return this.appReviewShown;
        }

        public final int getLikeCount() {
            return this.likeCount;
        }
    }

    private AppReview() {
    }

    public final void resetData() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        sharedPreferences2.edit().remove(PREFERENCES_KEY).apply();
        canShowDialogAfterLike = false;
        likeCount = 0;
        appLaunchCount = 0;
        appReviewDialogShowCount = 0;
        appReviewShown = false;
    }

    public final void addLikeCount() {
        StringBuilder sb = new StringBuilder();
        sb.append("appreview likeCount ");
        sb.append(likeCount);
        Logger.d(sb.toString(), new Object[0]);
        if (!appReviewShown) {
            likeCount++;
            saveData();
        }
    }

    public final void addAppLaunchCount() {
        StringBuilder sb = new StringBuilder();
        sb.append("appreview appLaunchCount ");
        sb.append(appLaunchCount);
        Logger.d(sb.toString(), new Object[0]);
        if (!appReviewShown) {
            int i = appReviewDialogShowCount;
            if (i != 0) {
                if (i == 1) {
                    canShowDialogAfterLike = true;
                }
            } else if (likeCount >= 5 || appLaunchCount >= 3) {
                canShowDialogAfterLike = true;
            }
            appLaunchCount++;
            saveData();
        }
    }

    public final void showReviewDialogAfterLikeIfNeeded(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Logger.d("showReviewDialogAfterLikeIfNeeded called", new Object[0]);
        if (!appReviewShown && canShowDialogAfterLike) {
            canShowDialogAfterLike = false;
            appReviewDialogShowCount++;
            saveData();
            showAppReviewDialog$app_productionFittsRelease(activity);
        }
    }

    public final void showFirstReviewDialog(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (!appReviewShown) {
            int i = appReviewDialogShowCount;
            if (i == 0) {
                appReviewDialogShowCount = i + 1;
                canShowDialogAfterLike = false;
                saveData();
                showAppReviewDialog$app_productionFittsRelease(activity);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void saveData() {
        String json = gson.toJson((Object) new AppReviewData(likeCount, appLaunchCount, appReviewDialogShowCount, appReviewShown));
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        Editor edit = sharedPreferences2.edit();
        edit.putString(PREFERENCES_KEY, json);
        edit.apply();
    }

    public final void showAppReviewDialog$app_productionFittsRelease(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Dialog buildDialog = DialogExtensions.INSTANCE.buildDialog(activity, C0013R$layout.dialog_app_review);
        View findViewById = buildDialog.findViewById(C0010R$id.appReviewMainLayout);
        View findViewById2 = buildDialog.findViewById(C0010R$id.positiveReviewLayout);
        View findViewById3 = buildDialog.findViewById(C0010R$id.negativeReviewLayout);
        Button button = (Button) buildDialog.findViewById(C0010R$id.mainNegativeButton);
        Button button2 = (Button) buildDialog.findViewById(C0010R$id.positivePositiveButton);
        Button button3 = (Button) buildDialog.findViewById(C0010R$id.positiveNegativeButton);
        Button button4 = (Button) buildDialog.findViewById(C0010R$id.negativePositiveButton);
        Button button5 = (Button) buildDialog.findViewById(C0010R$id.negativeNegativeButton);
        ((Button) buildDialog.findViewById(C0010R$id.mainPositiveButton)).setOnClickListener(new AppReview$showAppReviewDialog$1(findViewById, findViewById2));
        button.setOnClickListener(new AppReview$showAppReviewDialog$2(findViewById, findViewById3));
        button3.setOnClickListener(new AppReview$showAppReviewDialog$3(buildDialog));
        button2.setOnClickListener(new AppReview$showAppReviewDialog$4(buildDialog, activity));
        button5.setOnClickListener(new AppReview$showAppReviewDialog$5(buildDialog));
        button4.setOnClickListener(new AppReview$showAppReviewDialog$6(buildDialog, activity));
        buildDialog.setOnDismissListener(AppReview$showAppReviewDialog$7.INSTANCE);
        buildDialog.setCanceledOnTouchOutside(false);
        buildDialog.show();
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
        sharedPreferences = defaultSharedPreferences;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        try {
            AppReviewData appReviewData = (AppReviewData) gson.fromJson(sharedPreferences2.getString(PREFERENCES_KEY, null), AppReviewData.class);
            if (appReviewData != null) {
                likeCount = appReviewData.getLikeCount();
                appLaunchCount = appReviewData.getAppLaunchCount();
                appReviewDialogShowCount = appReviewData.getAppReviewDialogShowCount();
                appReviewShown = appReviewData.getAppReviewShown();
            }
        } catch (JsonParseException unused) {
        }
    }
}
