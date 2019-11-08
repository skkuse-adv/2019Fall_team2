package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.orhanobut.logger.Logger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventApplyActivity.Parameters;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.anko.internals.AnkoInternals;

final class EventShopWebActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ EventShopWebActivity this$0;

    EventShopWebActivity$onCreate$5(EventShopWebActivity eventShopWebActivity) {
        this.this$0 = eventShopWebActivity;
    }

    public final void onClick(View view) {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this.this$0, "상세 페이지가 맞나요?", "쇼핑몰홈 링크 주소가 아닌\n상세페이지 링크 주소가 맞는지 확인해주세요", new Function0<Unit>(this) {
            final /* synthetic */ EventShopWebActivity$onCreate$5 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append("current url ");
                WebView webView = (WebView) this.this$0.this$0._$_findCachedViewById(C0010R$id.webView);
                String str = "webView";
                Intrinsics.checkExpressionValueIsNotNull(webView, str);
                sb.append(webView.getUrl());
                Logger.d(sb.toString(), new Object[0]);
                EventShopWebActivity eventShopWebActivity = this.this$0.this$0;
                long eventID = eventShopWebActivity.getParameters().getEventID();
                WebView webView2 = (WebView) this.this$0.this$0._$_findCachedViewById(C0010R$id.webView);
                Intrinsics.checkExpressionValueIsNotNull(webView2, str);
                String url = webView2.getUrl();
                Intrinsics.checkExpressionValueIsNotNull(url, "webView.url");
                eventShopWebActivity.startActivityForResult(AnkoInternals.createIntent(eventShopWebActivity, AppliableCollaborativeEventApplyActivity.class, new Pair[]{TuplesKt.to("parameters", new Parameters(eventID, url, this.this$0.this$0.getParameters().getShop()))}), 100);
                this.this$0.this$0.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
            }
        }, null, "네,맞아요", "아니요", 0, 144, null);
    }
}
