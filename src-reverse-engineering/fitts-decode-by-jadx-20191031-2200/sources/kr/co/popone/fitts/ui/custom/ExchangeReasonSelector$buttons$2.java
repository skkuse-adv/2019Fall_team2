package kr.co.popone.fitts.ui.custom;

import android.widget.TextView;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

final class ExchangeReasonSelector$buttons$2 extends Lambda implements Function0<List<? extends TextView>> {
    final /* synthetic */ ExchangeReasonSelector this$0;

    ExchangeReasonSelector$buttons$2(ExchangeReasonSelector exchangeReasonSelector) {
        this.this$0 = exchangeReasonSelector;
        super(0);
    }

    @NotNull
    public final List<TextView> invoke() {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonChangeMind);
        Intrinsics.checkExpressionValueIsNotNull(textView, "buttonChangeMind");
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonUserMistake);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonUserMistake");
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonProductProblem);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "buttonProductProblem");
        TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonDelay);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "buttonDelay");
        return CollectionsKt__CollectionsKt.listOf(textView, textView2, textView3, textView4);
    }
}
