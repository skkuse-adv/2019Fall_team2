package kr.co.popone.fitts.event;

import androidx.core.app.NotificationCompat;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class RxBus {
    public static final RxBus INSTANCE = new RxBus();
    private static final PublishSubject<Object> bus;

    static {
        PublishSubject<Object> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Any>()");
        bus = create;
    }

    private RxBus() {
    }

    public final void post(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, NotificationCompat.CATEGORY_EVENT);
        bus.onNext(obj);
    }

    @NotNull
    public final Observable<Object> toObservable() {
        return bus;
    }
}
