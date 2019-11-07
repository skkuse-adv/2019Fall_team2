package kr.co.popone.fitts.feature.category;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import org.jetbrains.annotations.NotNull;

final class CategorySearchFragment$productDecorator$2 extends Lambda implements Function0<RecyclerDecorator> {
    public static final CategorySearchFragment$productDecorator$2 INSTANCE = new CategorySearchFragment$productDecorator$2();

    CategorySearchFragment$productDecorator$2() {
        super(0);
    }

    @NotNull
    public final RecyclerDecorator invoke() {
        return new Builder().decoratorType(DecoratorType.TRIPLE).tripleLeftDecorator(0, 18, 8, 2).tripleCenterDecorator(0, 18, 5, 5).tripleRightDecorator(0, 18, 2, 8).build();
    }
}
