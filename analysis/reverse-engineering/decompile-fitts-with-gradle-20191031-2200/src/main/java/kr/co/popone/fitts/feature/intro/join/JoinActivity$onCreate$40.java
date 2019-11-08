package kr.co.popone.fitts.feature.intro.join;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$onCreate$40 extends FunctionReference implements Function1<RecommenderCheckState, Unit> {
    JoinActivity$onCreate$40(JoinActivity joinActivity) {
        super(1, joinActivity);
    }

    public final String getName() {
        return "handleRecommenderCheckState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(JoinActivity.class);
    }

    public final String getSignature() {
        return "handleRecommenderCheckState(Lkr/co/popone/fitts/model/datamodel/service/join/RecommenderCheckState;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecommenderCheckState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecommenderCheckState recommenderCheckState) {
        Intrinsics.checkParameterIsNotNull(recommenderCheckState, "p1");
        ((JoinActivity) this.receiver).handleRecommenderCheckState(recommenderCheckState);
    }
}
