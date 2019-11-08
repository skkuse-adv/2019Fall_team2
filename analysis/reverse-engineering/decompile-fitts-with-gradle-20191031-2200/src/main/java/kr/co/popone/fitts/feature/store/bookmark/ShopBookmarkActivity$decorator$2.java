package kr.co.popone.fitts.feature.store.bookmark;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.decorator.FirstItemMarginDecorator;
import kr.co.popone.fitts.ui.decorator.FirstItemMarginDecorator.Builder;
import org.jetbrains.annotations.NotNull;

final class ShopBookmarkActivity$decorator$2 extends Lambda implements Function0<FirstItemMarginDecorator> {
    public static final ShopBookmarkActivity$decorator$2 INSTANCE = new ShopBookmarkActivity$decorator$2();

    ShopBookmarkActivity$decorator$2() {
        super(0);
    }

    @NotNull
    public final FirstItemMarginDecorator invoke() {
        return new Builder().setFirstItemDecorator(5, 0, 0, 0).setItemDecorator(0, 0, 0, 0).build();
    }
}
