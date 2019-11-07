package kr.co.popone.fitts.feature.search.holder;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import org.jetbrains.annotations.NotNull;

final class IntergratedSearchResultPostViewHolder$decorator$2 extends Lambda implements Function0<RecyclerDecorator> {
    public static final IntergratedSearchResultPostViewHolder$decorator$2 INSTANCE = new IntergratedSearchResultPostViewHolder$decorator$2();

    IntergratedSearchResultPostViewHolder$decorator$2() {
        super(0);
    }

    @NotNull
    public final RecyclerDecorator invoke() {
        return new Builder().decoratorType(DecoratorType.TRIPLE).tripleLeftDecorator(0, 25, 2, 2).tripleCenterDecorator(0, 25, 2, 2).tripleRightDecorator(0, 25, 2, 2).build();
    }
}
