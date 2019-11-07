package kr.co.popone.fitts.feature.post;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class PostingViolationNoticeActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ PostingViolationNoticeActivity this$0;

    PostingViolationNoticeActivity$onCreate$3(PostingViolationNoticeActivity postingViolationNoticeActivity) {
        this.this$0 = postingViolationNoticeActivity;
    }

    public final void onClick(View view) {
        String str = "android.intent.action.VIEW";
        try {
            this.this$0.startActivity(new Intent(str, Uri.parse("kakaoplus://plusfriend/friend/@핏츠")));
        } catch (ActivityNotFoundException unused) {
            this.this$0.startActivity(new Intent(str, Uri.parse("http://plus.kakao.com/home/@핏츠")));
        }
        this.this$0.overridePendingTransition(C0001R$anim.slide_right, C0001R$anim.fade_out);
    }
}
