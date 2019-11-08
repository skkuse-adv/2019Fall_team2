package kr.co.popone.fitts.feature.trend;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import org.jetbrains.annotations.NotNull;

final class TrendFeedActivity$onCreate$3 extends FunctionReference implements Function1<List<? extends Feed>, Unit> {
    TrendFeedActivity$onCreate$3(TrendFeedAdapter trendFeedAdapter) {
        super(1, trendFeedAdapter);
    }

    public final String getName() {
        return "submitList";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TrendFeedAdapter.class);
    }

    public final String getSignature() {
        return "submitList(Ljava/util/List;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<Feed> list) {
        Intrinsics.checkParameterIsNotNull(list, "p1");
        ((TrendFeedAdapter) this.receiver).submitList(list);
    }
}
