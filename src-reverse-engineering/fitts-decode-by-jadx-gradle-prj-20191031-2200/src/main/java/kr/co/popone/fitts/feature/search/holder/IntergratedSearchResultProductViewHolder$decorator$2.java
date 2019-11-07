package kr.co.popone.fitts.feature.search.holder;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import org.jetbrains.annotations.NotNull;

final class IntergratedSearchResultProductViewHolder$decorator$2 extends Lambda implements Function0<RecyclerDecorator> {
    public static final IntergratedSearchResultProductViewHolder$decorator$2 INSTANCE = new IntergratedSearchResultProductViewHolder$decorator$2();

    IntergratedSearchResultProductViewHolder$decorator$2() {
        super(0);
    }

    @NotNull
    public final RecyclerDecorator invoke() {
        return new Builder().decoratorType(DecoratorType.TRIPLE).tripleLeftDecorator(0, 19, 2, 4).tripleCenterDecorator(0, 19, 3, 3).tripleRightDecorator(0, 19, 4, 2).build();
    }
}
