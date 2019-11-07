package kr.co.popone.fitts.model.collection;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MixedCollection {
    @NotNull
    private ArrayList<CollectionEntry> mixedCollectionEntries = new ArrayList<>();
    private final long postId;
    private int scrollY;
    private ToolbarState toolbarState = ToolbarState.TRANSPARENT;
    private final int verticalPixelY;

    public enum ToolbarState {
        TRANSPARENT,
        WHITE,
        NOT
    }

    @NotNull
    public static /* synthetic */ MixedCollection copy$default(MixedCollection mixedCollection, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = mixedCollection.postId;
        }
        if ((i2 & 2) != 0) {
            i = mixedCollection.verticalPixelY;
        }
        return mixedCollection.copy(j, i);
    }

    public final long component1() {
        return this.postId;
    }

    public final int component2() {
        return this.verticalPixelY;
    }

    @NotNull
    public final MixedCollection copy(long j, int i) {
        return new MixedCollection(j, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MixedCollection) {
                MixedCollection mixedCollection = (MixedCollection) obj;
                if (this.postId == mixedCollection.postId) {
                    if (this.verticalPixelY == mixedCollection.verticalPixelY) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.postId;
        return (((int) (j ^ (j >>> 32))) * 31) + this.verticalPixelY;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MixedCollection(postId=");
        sb.append(this.postId);
        sb.append(", verticalPixelY=");
        sb.append(this.verticalPixelY);
        sb.append(")");
        return sb.toString();
    }

    public MixedCollection(long j, int i) {
        this.postId = j;
        this.verticalPixelY = i;
    }

    public final long getPostId() {
        return this.postId;
    }

    public final int getVerticalPixelY() {
        return this.verticalPixelY;
    }

    @NotNull
    public final ArrayList<CollectionEntry> getMixedCollectionEntries() {
        return this.mixedCollectionEntries;
    }

    public final void setMixedCollectionEntries(@NotNull ArrayList<CollectionEntry> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.mixedCollectionEntries = arrayList;
    }

    public final void updateFollowingUser(int i, boolean z) {
        User user = ((CollectionEntry) this.mixedCollectionEntries.get(i)).getUser();
        if (user != null) {
            user.setFollowing(z);
        }
    }

    public final void addAllMixedCollectionEntries(@NotNull ArrayList<CollectionEntry> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "items");
        this.mixedCollectionEntries.addAll(arrayList);
    }

    public final void addAllMixedCollectionEntriesWithClear(@NotNull ArrayList<CollectionEntry> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "items");
        this.mixedCollectionEntries.clear();
        this.mixedCollectionEntries.addAll(arrayList);
    }

    @Nullable
    public final Long getUserId(int i) {
        User user = ((CollectionEntry) this.mixedCollectionEntries.get(i)).getUser();
        if (user != null) {
            return Long.valueOf(user.getId());
        }
        return null;
    }

    @Nullable
    public final User getUser(int i) {
        return ((CollectionEntry) this.mixedCollectionEntries.get(i)).getUser();
    }

    @Nullable
    public final Long getLastItemId() {
        if (!this.mixedCollectionEntries.isEmpty()) {
            return Long.valueOf(((CollectionEntry) CollectionsKt___CollectionsKt.last((List<? extends T>) this.mixedCollectionEntries)).getId());
        }
        return null;
    }

    public final void clearMixedCollectionEntries() {
        this.mixedCollectionEntries.clear();
    }

    @NotNull
    public final ToolbarState getToolbarState(int i) {
        this.scrollY += i;
        if (this.scrollY > this.verticalPixelY) {
            if (this.toolbarState != ToolbarState.TRANSPARENT) {
                return ToolbarState.NOT;
            }
            this.toolbarState = ToolbarState.WHITE;
            return this.toolbarState;
        } else if (this.toolbarState != ToolbarState.WHITE) {
            return ToolbarState.NOT;
        } else {
            this.toolbarState = ToolbarState.TRANSPARENT;
            return this.toolbarState;
        }
    }
}
