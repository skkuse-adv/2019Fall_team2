package kr.co.popone.fitts.feature.recommend.fittie;

import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import org.jetbrains.annotations.NotNull;

final class FittieRecommendActivity$onCreate$7 extends FunctionReference implements Function1<PagedList<RecommendFittieInfo>, Unit> {
    FittieRecommendActivity$onCreate$7(FittieRecommendActivity fittieRecommendActivity) {
        super(1, fittieRecommendActivity);
    }

    public final String getName() {
        return "updateRecommendFitties";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FittieRecommendActivity.class);
    }

    public final String getSignature() {
        return "updateRecommendFitties(Landroidx/paging/PagedList;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PagedList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PagedList<RecommendFittieInfo> pagedList) {
        Intrinsics.checkParameterIsNotNull(pagedList, "p1");
        ((FittieRecommendActivity) this.receiver).updateRecommendFitties(pagedList);
    }
}
