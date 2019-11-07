package kr.co.popone.fitts.feature.openweb;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kakao.kakaolink.v2.KakaoLinkResponse;
import com.kakao.kakaolink.v2.KakaoLinkService;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.annotations.NotNull;

final class OpenWebActivity$handleScheme$4 implements OnClickListener {
    final /* synthetic */ BottomSheetDialog $dialog;
    final /* synthetic */ String $shareLinkUrl;
    final /* synthetic */ OpenWebActivity this$0;

    OpenWebActivity$handleScheme$4(OpenWebActivity openWebActivity, String str, BottomSheetDialog bottomSheetDialog) {
        this.this$0 = openWebActivity;
        this.$shareLinkUrl = str;
        this.$dialog = bottomSheetDialog;
    }

    public final void onClick(View view) {
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Tap KakaoTalk Share For Invitation", null, 2, null);
        KakaoLinkService.getInstance().sendScrap(this.this$0, this.$shareLinkUrl, new ResponseCallback<KakaoLinkResponse>(this) {
            final /* synthetic */ OpenWebActivity$handleScheme$4 this$0;

            public void onSuccess(@NotNull KakaoLinkResponse kakaoLinkResponse) {
                Intrinsics.checkParameterIsNotNull(kakaoLinkResponse, "result");
            }

            {
                this.this$0 = r1;
            }

            public void onFailure(@NotNull ErrorResult errorResult) {
                Intrinsics.checkParameterIsNotNull(errorResult, "errorResult");
                Logger.e(errorResult.toString(), new Object[0]);
                this.this$0.$dialog.dismiss();
                Snackbar.Companion.showMessage(this.this$0.this$0, "카카오톡이 설치 되어 있지 않습니다.");
            }
        });
    }
}
