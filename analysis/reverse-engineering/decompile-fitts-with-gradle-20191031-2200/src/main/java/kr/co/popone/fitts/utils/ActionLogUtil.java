package kr.co.popone.fitts.utils;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ActionLogUtil {
    private final ActionLogAPI actionLogApi;
    private long fromId;
    private String mainPath;
    private String subPath;

    public ActionLogUtil(@NotNull ActionLogAPI actionLogAPI) {
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLogApi");
        this.actionLogApi = actionLogAPI;
        String str = "";
        this.mainPath = str;
        this.subPath = str;
    }

    public static /* synthetic */ void defineCurrentWindow$default(ActionLogUtil actionLogUtil, String str, String str2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        actionLogUtil.defineCurrentWindow(str, str2, j);
    }

    public final void defineCurrentWindow(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkParameterIsNotNull(str, "mainPath");
        Intrinsics.checkParameterIsNotNull(str2, "subPath");
        this.mainPath = str;
        this.subPath = str2;
        this.fromId = j;
    }

    @NotNull
    public final String getMainPath() {
        return this.mainPath;
    }

    @NotNull
    public final String getSubPath() {
        return this.subPath;
    }

    public final long getFromId() {
        return this.fromId;
    }

    @NotNull
    public final Completable actionLogMixedCollection(@NotNull String str, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return actionLog$default(this, str, "Collection", null, l, null, 16, null);
    }

    @NotNull
    public static /* synthetic */ Completable actionLogOpenSchemeFromMixedCollection$default(ActionLogUtil actionLogUtil, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return actionLogUtil.actionLogOpenSchemeFromMixedCollection(str, l);
    }

    @NotNull
    public final Completable actionLogOpenSchemeFromMixedCollection(@NotNull String str, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return actionLog(str, "Collection", null, null, l);
    }

    @NotNull
    public final Completable actionLogShopListSelectedShop(long j) {
        return actionLog("shop", "ShopList", null, null, Long.valueOf(j));
    }

    static /* synthetic */ Completable actionLog$default(ActionLogUtil actionLogUtil, String str, String str2, String str3, Long l, Long l2, int i, Object obj) {
        return actionLogUtil.actionLog(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    private final Completable actionLog(String str, String str2, String str3, Long l, Long l2) {
        Completable observeOn = this.actionLogApi.collectActionLog(str, str2, str3, l, l2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "actionLogApi.collectActi…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("main_path = ");
        sb.append(this.mainPath);
        sb.append(", sub_path = ");
        sb.append(this.subPath);
        sb.append(", fromId = ");
        sb.append(this.fromId);
        return sb.toString();
    }
}
