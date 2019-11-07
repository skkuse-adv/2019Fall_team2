package kr.co.popone.fitts.feature.recommend.fittie;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import org.jetbrains.annotations.NotNull;

final class FittieRecommendActivity$decorator$2 extends Lambda implements Function0<RecyclerDecorator> {
    public static final FittieRecommendActivity$decorator$2 INSTANCE = new FittieRecommendActivity$decorator$2();

    FittieRecommendActivity$decorator$2() {
        super(0);
    }

    @NotNull
    public final RecyclerDecorator invoke() {
        return new Builder().decoratorType(DecoratorType.SINGLE).singleDecorator(29, 0, 0, 0).build();
    }
}
