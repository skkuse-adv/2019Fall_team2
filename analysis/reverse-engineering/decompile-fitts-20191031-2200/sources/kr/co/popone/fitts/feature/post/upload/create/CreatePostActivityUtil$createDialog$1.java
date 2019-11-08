package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.dialog.PostTypeSelectDialog.Delegate;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity.Companion;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CreatePostActivityUtil$createDialog$1 implements Delegate {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0 $dismiss;
    final /* synthetic */ String $from;
    final /* synthetic */ CreatePostActivityUtil this$0;

    CreatePostActivityUtil$createDialog$1(CreatePostActivityUtil createPostActivityUtil, String str, Activity activity, Function0 function0) {
        this.this$0 = createPostActivityUtil;
        this.$from = str;
        this.$activity = activity;
        this.$dismiss = function0;
    }

    public void onNewPostClicked(@NotNull PostType postType) {
        Intrinsics.checkParameterIsNotNull(postType, "type");
        CreatePostActivityUtil createPostActivityUtil = this.this$0;
        String str = this.$from;
        String name = postType.name();
        String str2 = "null cannot be cast to non-null type java.lang.String";
        if (name != null) {
            String lowerCase = name.toLowerCase();
            String str3 = "(this as java.lang.String).toLowerCase()";
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, str3);
            createPostActivityUtil.writeCustomLog(str, lowerCase);
            Companion companion = CreatePostActivity.Companion;
            Activity activity = this.$activity;
            String name2 = postType.name();
            if (name2 != null) {
                String lowerCase2 = name2.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase2, str3);
                Companion.startCreate$default(companion, activity, lowerCase2, AppSettingsData.STATUS_NEW, null, 8, null);
                return;
            }
            throw new TypeCastException(str2);
        }
        throw new TypeCastException(str2);
    }

    public void onPostableItemClicked(long j, @NotNull String str, @Nullable PostType postType) {
        Intrinsics.checkParameterIsNotNull(str, "variantUrl");
        if (postType != null) {
            CreatePostActivityUtil createPostActivityUtil = this.this$0;
            String str2 = this.$from;
            String name = postType.name();
            String str3 = "null cannot be cast to non-null type java.lang.String";
            if (name != null) {
                String lowerCase = name.toLowerCase();
                String str4 = "(this as java.lang.String).toLowerCase()";
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, str4);
                createPostActivityUtil.writeCustomLog(str2, lowerCase);
                Companion companion = CreatePostActivity.Companion;
                Activity activity = this.$activity;
                String name2 = postType.name();
                if (name2 != null) {
                    String lowerCase2 = name2.toLowerCase();
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase2, str4);
                    companion.startCreate(activity, lowerCase2, AppSettingsData.STATUS_NEW, new PostVariantViewData(j, str));
                    return;
                }
                throw new TypeCastException(str3);
            }
            throw new TypeCastException(str3);
        }
    }

    public void onBannerClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        FittsSchemeHandler schemeHandler = this.this$0.getSchemeHandler();
        if (schemeHandler != null) {
            schemeHandler.handleScheme(this.$activity, str);
        }
    }

    public void onDialogDissmiss() {
        Function0 function0 = this.$dismiss;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
