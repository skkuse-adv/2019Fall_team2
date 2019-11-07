package kr.co.popone.fitts.feature.openweb;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.TypeCastException;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.utils.Snackbar;

final class OpenWebActivity$handleScheme$3 implements OnClickListener {
    final /* synthetic */ BottomSheetDialog $dialog;
    final /* synthetic */ String $shareLinkUrl;
    final /* synthetic */ OpenWebActivity this$0;

    OpenWebActivity$handleScheme$3(OpenWebActivity openWebActivity, String str, BottomSheetDialog bottomSheetDialog) {
        this.this$0 = openWebActivity;
        this.$shareLinkUrl = str;
        this.$dialog = bottomSheetDialog;
    }

    public final void onClick(View view) {
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Tap Copy Link For Invitation", null, 2, null);
        Object systemService = this.this$0.getSystemService("clipboard");
        if (systemService != null) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(MessageTemplateProtocol.LINK, this.$shareLinkUrl));
            this.$dialog.dismiss();
            Snackbar.Companion.showMessage(this.this$0, "링크가 복사되었습니다");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
