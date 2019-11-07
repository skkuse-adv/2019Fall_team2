package kr.co.popone.fitts.feature.search;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.orhanobut.logger.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result;
import kr.co.popone.fitts.ui.DialogExtensions;

final class ShopWebViewActivity$onCreate$6 implements OnClickListener {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ ShopWebViewActivity this$0;

    ShopWebViewActivity$onCreate$6(ShopWebViewActivity shopWebViewActivity, Parameters parameters) {
        this.this$0 = shopWebViewActivity;
        this.$parameters = parameters;
    }

    public final void onClick(View view) {
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        ShopWebViewActivity shopWebViewActivity = this.this$0;
        String confirmMessage = this.$parameters.getConfirmMessage();
        if (confirmMessage == null) {
            confirmMessage = "구매를 원하는 상품의\n상세 페이지가 맞는지 확인해주세요";
        }
        DialogExtensions.showConfirmDialog$default(dialogExtensions, shopWebViewActivity, "상세 페이지가 맞나요?", confirmMessage, new Function0<Unit>(this) {
            final /* synthetic */ ShopWebViewActivity$onCreate$6 this$0;

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
                Intent intent = new Intent();
                WebView webView2 = (WebView) this.this$0.this$0._$_findCachedViewById(C0010R$id.webView);
                Intrinsics.checkExpressionValueIsNotNull(webView2, str);
                String url = webView2.getUrl();
                Intrinsics.checkExpressionValueIsNotNull(url, "webView.url");
                intent.putExtra("result", new Result(url));
                this.this$0.this$0.setResult(1000, intent);
                this.this$0.this$0.finish();
                this.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
            }
        }, null, "네,맞아요", "아니요,수정할게요", 0, 144, null);
    }
}
