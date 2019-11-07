package kr.co.popone.fitts.feature.store.list;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreListAdapter extends BasePagedListAdapter<StoreInfo, BaseViewHolder> {
    private static final StoreListAdapter$Companion$COMPARATOR$1 COMPARATOR = new StoreListAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;
    @Nullable
    private NetworkState networkState;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.store.list.StoreListViewHolder.Delegate {
        void shopListEmpty();
    }

    public StoreListAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @Nullable
    public final NetworkState getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable NetworkState networkState2) {
        this.networkState = networkState2;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == StoreListViewHolder.Companion.getId()) {
            return StoreListViewHolder.Companion.create(viewGroup, this.delegate);
        }
        throw new IllegalAccessException("Can't find viewType");
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        if (baseViewHolder instanceof StoreListViewHolder) {
            BaseViewHolder.bind$default(baseViewHolder, super.getItem(i), null, 2, null);
        }
    }

    public int getItemViewTypeWithoutLoading(int i) {
        return StoreListViewHolder.Companion.getId();
    }

    public void onViewRecycled(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        baseViewHolder.recycle();
        super.onViewRecycled(baseViewHolder);
    }
}
