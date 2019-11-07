package kr.co.popone.fitts.model.datamodel.social.membership;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class MembershipKt {
    @NotNull
    public static final String[] toSpinnerViewData(@NotNull List<Membership> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        String str = "null cannot be cast to non-null type kotlin.Array<T>";
        String str2 = "null cannot be cast to non-null type java.util.Collection<T>";
        if (list.isEmpty()) {
            List listOf = CollectionsKt__CollectionsJVMKt.listOf("사용 가능한 멤버십 할인이 없습니다.");
            if (listOf != null) {
                Object[] array = listOf.toArray(new String[0]);
                if (array != null) {
                    return (String[]) array;
                }
                throw new TypeCastException(str);
            }
            throw new TypeCastException(str2);
        }
        List[] listArr = new List[2];
        listArr[0] = CollectionsKt__CollectionsJVMKt.listOf("멤버십 할인을 선택하세요");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Membership title : list) {
            arrayList.add(title.getTitle());
        }
        listArr[1] = arrayList;
        List flatten = CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(listArr));
        if (flatten != null) {
            Object[] array2 = flatten.toArray(new String[0]);
            if (array2 != null) {
                return (String[]) array2;
            }
            throw new TypeCastException(str);
        }
        throw new TypeCastException(str2);
    }
}
