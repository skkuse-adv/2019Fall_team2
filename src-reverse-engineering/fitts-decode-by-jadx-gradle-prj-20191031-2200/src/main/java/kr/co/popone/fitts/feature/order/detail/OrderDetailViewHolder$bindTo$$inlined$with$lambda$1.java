package kr.co.popone.fitts.feature.order.detail;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.OrderEvent$ContactCsNumber;
import kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.custom.CsContactDialog;
import kr.co.popone.fitts.ui.custom.CsContactDialog.Delegate;

final class OrderDetailViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ OrderListItemViewData $item$inlined;
    final /* synthetic */ View $this_with;

    OrderDetailViewHolder$bindTo$$inlined$with$lambda$1(View view, OrderDetailViewHolder orderDetailViewHolder, OrderListItemViewData orderListItemViewData) {
        this.$this_with = view;
        this.$item$inlined = orderListItemViewData;
    }

    public final void onClick(View view) {
        Context context = this.$this_with.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        new CsContactDialog(context, new Delegate(this) {
            final /* synthetic */ OrderDetailViewHolder$bindTo$$inlined$with$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public void onKakaoContactClicked() {
                String kakaoFriendUrl = this.this$0.$item$inlined.getStoreContact().getKakaoFriendUrl();
                if (!(kakaoFriendUrl == null || kakaoFriendUrl.length() == 0)) {
                    RxBus rxBus = RxBus.INSTANCE;
                    if (kakaoFriendUrl == null) {
                        Intrinsics.throwNpe();
                    }
                    rxBus.post(new OrderEvent$ContactKakaoUrl(kakaoFriendUrl));
                    return;
                }
                DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
                Context context = this.this$0.$this_with.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                dialogExtensions.showMessageDialog(context, "", "해당 스토어는 카카오톡 문의하기를\n제공하지 않아요😢", null, "확인");
            }

            public void onCsContactClicked() {
                String csContact = this.this$0.$item$inlined.getStoreContact().getCsContact();
                if (!(csContact == null || csContact.length() == 0)) {
                    RxBus.INSTANCE.post(new OrderEvent$ContactCsNumber(csContact));
                    return;
                }
                DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
                Context context = this.this$0.$this_with.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                dialogExtensions.showMessageDialog(context, "", "해당 스토어는 전화 문의하기를\n제공하지 않아요😢", null, "확인");
            }
        }).show();
    }
}
