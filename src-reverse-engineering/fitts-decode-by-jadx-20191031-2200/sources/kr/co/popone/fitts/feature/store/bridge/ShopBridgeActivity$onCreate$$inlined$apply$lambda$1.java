package kr.co.popone.fitts.feature.store.bridge;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class ShopBridgeActivity$onCreate$$inlined$apply$lambda$1 extends OnScrollListener {
    private int overallYScroll;
    final /* synthetic */ ShopBridgeActivity this$0;

    ShopBridgeActivity$onCreate$$inlined$apply$lambda$1(ShopBridgeActivity shopBridgeActivity) {
        this.this$0 = shopBridgeActivity;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        String str = "toolbar";
        if (this.overallYScroll > this.this$0.getOffset()) {
            Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, str);
            if (Intrinsics.areEqual(toolbar.getTag(), (Object) "transparent")) {
                Toolbar toolbar2 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar2, str);
                ViewExtensionsKt.visibleWithWhiteBackground(toolbar2, new Function0<Unit>(this) {
                    final /* synthetic */ ShopBridgeActivity$onCreate$$inlined$apply$lambda$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        Group group = (Group) this.this$0.this$0._$_findCachedViewById(C0010R$id.toolbarGroup);
                        Intrinsics.checkExpressionValueIsNotNull(group, "toolbarGroup");
                        ViewExtensionsKt.visible(group);
                    }
                });
            }
        } else {
            Toolbar toolbar3 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar3, str);
            if (Intrinsics.areEqual(toolbar3.getTag(), (Object) "white")) {
                Toolbar toolbar4 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar4, str);
                ViewExtensionsKt.visibleWithTransparentBackground(toolbar4, new Function0<Unit>(this) {
                    final /* synthetic */ ShopBridgeActivity$onCreate$$inlined$apply$lambda$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        Group group = (Group) this.this$0.this$0._$_findCachedViewById(C0010R$id.toolbarGroup);
                        Intrinsics.checkExpressionValueIsNotNull(group, "toolbarGroup");
                        ViewExtensionsKt.gone(group);
                    }
                });
            }
        }
        this.overallYScroll += i2;
    }
}
