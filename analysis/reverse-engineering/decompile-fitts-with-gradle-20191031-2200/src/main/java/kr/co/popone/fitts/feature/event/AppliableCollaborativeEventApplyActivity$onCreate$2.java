package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import kotlin.TuplesKt;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import org.jetbrains.anko.internals.AnkoInternals;

final class AppliableCollaborativeEventApplyActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ AppliableCollaborativeEventApplyActivity this$0;

    AppliableCollaborativeEventApplyActivity$onCreate$2(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
        this.this$0 = appliableCollaborativeEventApplyActivity;
    }

    public final void onClick(View view) {
        AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity = this.this$0;
        Parameters parameters = new Parameters(appliableCollaborativeEventApplyActivity.getParameters().getLinkUrl(), "", false, null, null, null, null, 124, null);
        appliableCollaborativeEventApplyActivity.startActivity(AnkoInternals.createIntent(appliableCollaborativeEventApplyActivity, ShopWebViewActivity.class, new Pair[]{TuplesKt.to("parameters", parameters)}));
    }
}
