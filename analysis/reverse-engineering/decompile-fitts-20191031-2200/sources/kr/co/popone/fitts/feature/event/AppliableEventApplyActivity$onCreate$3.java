package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.event.ProductTypeSelectFragment.Delegate;
import org.jetbrains.annotations.NotNull;

final class AppliableEventApplyActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onCreate$3(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
    }

    public final void onClick(View view) {
        ProductTypeSelectFragment productTypeSelectFragment = new ProductTypeSelectFragment();
        productTypeSelectFragment.setDelegate(new Delegate(this) {
            final /* synthetic */ AppliableEventApplyActivity$onCreate$3 this$0;

            {
                this.this$0 = r1;
            }

            public void onProductSelected(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "item");
                StringBuilder sb = new StringBuilder();
                sb.append("onProductSelected ");
                sb.append(str);
                Logger.d(sb.toString(), new Object[0]);
                this.this$0.this$0.selectedItemSubject.onNext(str);
            }
        });
        productTypeSelectFragment.setItems(AppliableEventApplyActivity.access$getParameters$p(this.this$0).getItems());
        productTypeSelectFragment.show(this.this$0.getSupportFragmentManager(), "fragment");
    }
}
