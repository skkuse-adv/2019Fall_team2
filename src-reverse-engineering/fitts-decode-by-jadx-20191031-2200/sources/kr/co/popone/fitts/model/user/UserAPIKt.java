package kr.co.popone.fitts.model.user;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.view.FittieFollowViewData;
import org.jetbrains.annotations.NotNull;

public final class UserAPIKt {
    @NotNull
    public static final FittieFollowViewData mapToFittieFollowViewData(@NotNull User user) {
        Intrinsics.checkParameterIsNotNull(user, "receiver$0");
        FittieFollowViewData fittieFollowViewData = new FittieFollowViewData(user.getId(), user.getFittsID(), user.getProfileImageUrl(), user.isFollowing(), user.isSuitable());
        return fittieFollowViewData;
    }

    @NotNull
    public static final List<FittieFollowViewData> mapToFittieFollowViewDataList(@NotNull List<User> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (User mapToFittieFollowViewData : list) {
            arrayList.add(mapToFittieFollowViewData(mapToFittieFollowViewData));
        }
        return arrayList;
    }
}
