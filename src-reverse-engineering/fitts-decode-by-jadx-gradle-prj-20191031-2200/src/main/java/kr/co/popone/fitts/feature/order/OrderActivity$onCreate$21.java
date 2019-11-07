package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import org.jetbrains.annotations.Nullable;

final class OrderActivity$onCreate$21 extends FunctionReference implements Function1<Throwable, Unit> {
    OrderActivity$onCreate$21(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "handleError";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ActivityExtensionKt.class, "app_productionFittsRelease");
    }

    public final String getSignature() {
        return "handleError(Landroid/app/Activity;Ljava/lang/Throwable;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        ActivityExtensionKt.handleError((OrderActivity) this.receiver, th);
    }
}
