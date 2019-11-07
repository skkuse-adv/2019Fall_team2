package kr.co.popone.fitts.feature.post.follow;

import android.view.ViewGroup;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.custom.RecyclerLoadingItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FollowingPostAdapter extends PagedListAdapter<Post, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<Post> COMPARATOR = new FollowingPostAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_FEED = 1;
    private static final int TYPE_LOADING = 2;
    @Nullable
    private NetworkState networkState;
    private final long userId;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<Post> getCOMPARATOR() {
            return FollowingPostAdapter.COMPARATOR;
        }
    }

    public FollowingPostAdapter(long j) {
        super(COMPARATOR);
        this.userId = j;
    }

    public final long getUserId() {
        return this.userId;
    }

    @Nullable
    public final NetworkState getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable NetworkState networkState2) {
        this.networkState = networkState2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == TYPE_FEED) {
            return FollowingPostHolder.Companion.create(viewGroup);
        }
        if (i == TYPE_LOADING) {
            return RecyclerLoadingItemView.Companion.create(viewGroup);
        }
        throw new IllegalAccessException();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof FollowingPostHolder) {
            ((FollowingPostHolder) viewHolder).bindTo(this.userId, (Post) super.getItem(i));
        }
    }

    public int getItemViewType(int i) {
        if (!hasExtraRow() || i != getItemCount() - 1) {
            return TYPE_FEED;
        }
        return TYPE_LOADING;
    }

    public final void updateNetworkState(@Nullable NetworkState networkState2) {
        NetworkState networkState3 = this.networkState;
        boolean hasExtraRow = hasExtraRow();
        this.networkState = networkState2;
        boolean hasExtraRow2 = hasExtraRow();
        if (hasExtraRow != hasExtraRow2) {
            if (hasExtraRow) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (hasExtraRow2 && (!Intrinsics.areEqual((Object) networkState3, (Object) networkState2))) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
    }

    private final boolean hasExtraRow() {
        NetworkState networkState2 = this.networkState;
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true);
    }

    public final void updateFittieFollowing(long j, boolean z) {
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(currentList, 10));
            int i = 0;
            for (Object next : currentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Post post = (Post) next;
                if (j == post.getUser().getId()) {
                    post.getUser().setFollowing(z);
                    notifyItemChanged(i);
                }
                arrayList.add(Unit.INSTANCE);
                i = i2;
            }
        }
    }

    public final void updatePostLike(long j, boolean z) {
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(currentList, 10));
            int i = 0;
            for (Object next : currentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Post post = (Post) next;
                if (j == post.getId()) {
                    post.setLiked(z);
                    post.setLikesCount(post.getLikesCount() + (z ? 1 : -1));
                    notifyItemChanged(i);
                }
                arrayList.add(Unit.INSTANCE);
                i = i2;
            }
        }
    }
}
