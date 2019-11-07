package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import org.jetbrains.annotations.Nullable;

final class OrderActivity$onCreate$18 extends FunctionReference implements Function1<Throwable, Unit> {
    OrderActivity$onCreate$18(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "handleErrorCodeMessage";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ActivityExtensionKt.class, "app_productionFittsRelease");
    }

    public final String getSignature() {
        return "handleErrorCodeMessage(Landroid/app/Activity;Ljava/lang/Throwable;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        ActivityExtensionKt.handleErrorCodeMessage((OrderActivity) this.receiver, th);
    }
}
