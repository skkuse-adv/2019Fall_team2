package kr.co.popone.fitts.feature.ncommerce;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.social.point.PointInfo;
import kr.co.popone.fitts.utils.IntExtensionsKt;

final class NCommerceActivity$onCreate$7<T> implements Observer<PointInfo> {
    final /* synthetic */ NCommerceActivity this$0;

    NCommerceActivity$onCreate$7(NCommerceActivity nCommerceActivity) {
        this.this$0 = nCommerceActivity;
    }

    public final void onChanged(PointInfo pointInfo) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textUsablePoint);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textUsablePoint");
        if (pointInfo == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(IntExtensionsKt.commaString(pointInfo.getRewardPoints()));
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textTotalPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textTotalPoint");
        textView2.setText(IntExtensionsKt.commaString(pointInfo.getAccumulatedRewardPoints()));
    }
}
