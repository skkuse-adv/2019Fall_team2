package kr.co.popone.fitts.feature.order;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.ui.ToastExtensionKt;
import org.jetbrains.annotations.Nullable;

final class OrderActivity$onCreate$13 extends FunctionReference implements Function1<String, Unit> {
    OrderActivity$onCreate$13(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "showToast";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ToastExtensionKt.class, "app_productionFittsRelease");
    }

    public final String getSignature() {
        return "showToast(Landroid/content/Context;Ljava/lang/String;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        ToastExtensionKt.showToast((Context) (OrderActivity) this.receiver, str);
    }
}
