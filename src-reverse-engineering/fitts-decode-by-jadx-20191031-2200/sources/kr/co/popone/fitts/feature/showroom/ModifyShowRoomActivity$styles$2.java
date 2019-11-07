package kr.co.popone.fitts.feature.showroom;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0003R$array;
import org.jetbrains.annotations.NotNull;

final class ModifyShowRoomActivity$styles$2 extends Lambda implements Function0<List<? extends String>> {
    final /* synthetic */ ModifyShowRoomActivity this$0;

    ModifyShowRoomActivity$styles$2(ModifyShowRoomActivity modifyShowRoomActivity) {
        this.this$0 = modifyShowRoomActivity;
        super(0);
    }

    @NotNull
    public final List<String> invoke() {
        String[] stringArray = this.this$0.getResources().getStringArray(C0003R$array.fitts_styles);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray(R.array.fitts_styles)");
        return ArraysKt___ArraysKt.toList((T[]) stringArray);
    }
}
