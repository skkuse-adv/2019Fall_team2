package kr.co.popone.fitts.feature.category;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;

final class CategorySearchActivity$onCreate$6<T> implements Consumer<MainEvent$MainTabChangeEvent> {
    final /* synthetic */ CategorySearchActivity this$0;

    CategorySearchActivity$onCreate$6(CategorySearchActivity categorySearchActivity) {
        this.this$0 = categorySearchActivity;
    }

    public final void accept(MainEvent$MainTabChangeEvent mainEvent$MainTabChangeEvent) {
        this.this$0.finish();
    }
}
