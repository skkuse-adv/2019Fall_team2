package kr.co.popone.fitts.feature.category;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import org.jetbrains.annotations.NotNull;

final class CategorySearchFragment$postDecorator$2 extends Lambda implements Function0<RecyclerDecorator> {
    public static final CategorySearchFragment$postDecorator$2 INSTANCE = new CategorySearchFragment$postDecorator$2();

    CategorySearchFragment$postDecorator$2() {
        super(0);
    }

    @NotNull
    public final RecyclerDecorator invoke() {
        return new Builder().decoratorType(DecoratorType.TRIPLE).tripleLeftDecorator(0, 4, 8, 0).tripleCenterDecorator(0, 4, 4, 4).tripleRightDecorator(0, 4, 0, 8).build();
    }
}
