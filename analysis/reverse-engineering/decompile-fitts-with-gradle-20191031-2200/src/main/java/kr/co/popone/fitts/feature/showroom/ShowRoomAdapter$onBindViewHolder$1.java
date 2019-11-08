package kr.co.popone.fitts.feature.showroom;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.home.PostListTypeControl.Type;
import kr.co.popone.fitts.feature.showroom.ShowRoomAdapter.WhenMappings;
import org.jetbrains.annotations.NotNull;

final class ShowRoomAdapter$onBindViewHolder$1 extends Lambda implements Function1<Type, Unit> {
    final /* synthetic */ ShowRoomAdapter this$0;

    ShowRoomAdapter$onBindViewHolder$1(ShowRoomAdapter showRoomAdapter) {
        this.this$0 = showRoomAdapter;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Type) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Type type) {
        Intrinsics.checkParameterIsNotNull(type, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            this.this$0.delegate.onLinearClicked();
        } else if (i == 2) {
            this.this$0.delegate.onGridClicked();
        }
    }
}
