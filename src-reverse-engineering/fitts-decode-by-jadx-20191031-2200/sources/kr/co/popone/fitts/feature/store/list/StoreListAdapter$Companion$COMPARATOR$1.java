package kr.co.popone.fitts.feature.store.list;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;

public final class StoreListAdapter$Companion$COMPARATOR$1 extends ItemCallback<StoreInfo> {
    StoreListAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull StoreInfo storeInfo, @NotNull StoreInfo storeInfo2) {
        Intrinsics.checkParameterIsNotNull(storeInfo, "oldItem");
        Intrinsics.checkParameterIsNotNull(storeInfo2, "newItem");
        return storeInfo.getId() == storeInfo2.getId();
    }

    public boolean areContentsTheSame(@NotNull StoreInfo storeInfo, @NotNull StoreInfo storeInfo2) {
        Intrinsics.checkParameterIsNotNull(storeInfo, "oldItem");
        Intrinsics.checkParameterIsNotNull(storeInfo2, "newItem");
        return storeInfo.getId() == storeInfo2.getId();
    }
}
