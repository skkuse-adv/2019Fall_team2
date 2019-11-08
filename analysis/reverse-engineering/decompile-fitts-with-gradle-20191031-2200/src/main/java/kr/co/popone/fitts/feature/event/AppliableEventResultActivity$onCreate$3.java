package kr.co.popone.fitts.feature.event;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.event.AppliableEventResultAdapter.Delegate;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo;

public final class AppliableEventResultActivity$onCreate$3 implements Delegate {
    final /* synthetic */ AppliableEventResultActivity this$0;

    AppliableEventResultActivity$onCreate$3(AppliableEventResultActivity appliableEventResultActivity) {
        this.this$0 = appliableEventResultActivity;
    }

    public void onLinkUrlClicked(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onLinkUrlClicked ");
        sb.append(i);
        Logger.d(sb.toString(), new Object[0]);
        AppliableEventResultResponse access$getEventResultResponse$p = this.this$0.eventResultResponse;
        if (access$getEventResultResponse$p != null) {
            Parameters parameters = new Parameters(((WinnerInfo) access$getEventResultResponse$p.getWinners().get(i)).getLinkUrl(), "", false, null, null, null, null, 124, null);
            Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
            intent.putExtra("parameters", parameters);
            this.this$0.startActivity(intent);
            this.this$0.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
        }
    }
}
