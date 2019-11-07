package kr.co.popone.fitts.model.repository.social;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import org.jetbrains.annotations.NotNull;

final class FittsSocialRepositoryImpl$getFittsMemberships$1<T, R> implements Function<T, R> {
    public static final FittsSocialRepositoryImpl$getFittsMemberships$1 INSTANCE = new FittsSocialRepositoryImpl$getFittsMemberships$1();

    FittsSocialRepositoryImpl$getFittsMemberships$1() {
    }

    @NotNull
    public final List<Membership> apply(@NotNull List<Membership> list) {
        Intrinsics.checkParameterIsNotNull(list, "it");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((Membership) next).isNotDeative()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
