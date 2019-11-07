package kr.co.popone.fitts.model.order;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class BankAccountKt {
    @NotNull
    public static final String[] mapToBankNameArray(@NotNull List<BankAccount> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        arrayList.add("은행 선택");
        for (BankAccount bankName : list) {
            arrayList.add(bankName.getBankName());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
