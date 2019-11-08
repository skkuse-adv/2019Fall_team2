package kr.co.popone.fitts.feature.main;

import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.main.MainActivity.ShopTooltipState;
import kr.co.popone.fitts.feature.main.MainActivity.WhenMappings;
import org.jetbrains.annotations.NotNull;

public final class MainActivity$$special$$inlined$observable$1 extends ObservableProperty<ShopTooltipState> {
    final /* synthetic */ MainActivity this$0;

    public MainActivity$$special$$inlined$observable$1(Object obj, Object obj2, MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(obj2);
    }

    /* access modifiers changed from: protected */
    public void afterChange(@NotNull KProperty<?> kProperty, ShopTooltipState shopTooltipState, ShopTooltipState shopTooltipState2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        ShopTooltipState shopTooltipState3 = shopTooltipState2;
        ShopTooltipState shopTooltipState4 = shopTooltipState;
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.viewStoreToolTip);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "viewStoreToolTip");
        if (linearLayout.getVisibility() != 8 && shopTooltipState4 != ShopTooltipState.DISMISS && shopTooltipState4 != ShopTooltipState.CANCEL) {
            int i = WhenMappings.$EnumSwitchMapping$0[shopTooltipState3.ordinal()];
            if (i == 1) {
                this.this$0.getSessionManager$app_productionFittsRelease().setStoreToolTipShown(true);
                ((LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.viewStoreToolTip)).startAnimation(AnimationUtils.loadAnimation(this.this$0, C0001R$anim.scale_up_pivot_x_50));
            } else if (i == 2) {
                ((LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.viewStoreToolTip)).startAnimation(AnimationUtils.loadAnimation(this.this$0, C0001R$anim.scale_out_pivot_x_50));
            } else if (i == 3) {
                Disposable access$getShopTooltipDissmissDisposable$p = this.this$0.shopTooltipDissmissDisposable;
                if (access$getShopTooltipDissmissDisposable$p != null) {
                    access$getShopTooltipDissmissDisposable$p.dispose();
                }
                ((LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.viewStoreToolTip)).startAnimation(AnimationUtils.loadAnimation(this.this$0, C0001R$anim.scale_out_pivot_x_50));
            }
        }
    }
}
