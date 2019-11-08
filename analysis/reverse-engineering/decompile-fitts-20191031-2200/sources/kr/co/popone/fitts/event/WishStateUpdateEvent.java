package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class WishStateUpdateEvent {
    private final boolean isInWishList;
    private final long productId;

    @NotNull
    public static /* synthetic */ WishStateUpdateEvent copy$default(WishStateUpdateEvent wishStateUpdateEvent, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = wishStateUpdateEvent.productId;
        }
        if ((i & 2) != 0) {
            z = wishStateUpdateEvent.isInWishList;
        }
        return wishStateUpdateEvent.copy(j, z);
    }

    public final long component1() {
        return this.productId;
    }

    public final boolean component2() {
        return this.isInWishList;
    }

    @NotNull
    public final WishStateUpdateEvent copy(long j, boolean z) {
        return new WishStateUpdateEvent(j, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof WishStateUpdateEvent) {
                WishStateUpdateEvent wishStateUpdateEvent = (WishStateUpdateEvent) obj;
                if (this.productId == wishStateUpdateEvent.productId) {
                    if (this.isInWishList == wishStateUpdateEvent.isInWishList) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.productId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z = this.isInWishList;
        if (z) {
            z = true;
        }
        return i + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WishStateUpdateEvent(productId=");
        sb.append(this.productId);
        sb.append(", isInWishList=");
        sb.append(this.isInWishList);
        sb.append(")");
        return sb.toString();
    }

    public WishStateUpdateEvent(long j, boolean z) {
        this.productId = j;
        this.isInWishList = z;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final boolean isInWishList() {
        return this.isInWishList;
    }
}
