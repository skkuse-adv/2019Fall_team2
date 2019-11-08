package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopBookmarkEvent {
    private final boolean bookmark;
    private final long id;

    @NotNull
    public static /* synthetic */ ShopBookmarkEvent copy$default(ShopBookmarkEvent shopBookmarkEvent, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = shopBookmarkEvent.id;
        }
        if ((i & 2) != 0) {
            z = shopBookmarkEvent.bookmark;
        }
        return shopBookmarkEvent.copy(j, z);
    }

    public final long component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.bookmark;
    }

    @NotNull
    public final ShopBookmarkEvent copy(long j, boolean z) {
        return new ShopBookmarkEvent(j, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ShopBookmarkEvent) {
                ShopBookmarkEvent shopBookmarkEvent = (ShopBookmarkEvent) obj;
                if (this.id == shopBookmarkEvent.id) {
                    if (this.bookmark == shopBookmarkEvent.bookmark) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z = this.bookmark;
        if (z) {
            z = true;
        }
        return i + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopBookmarkEvent(id=");
        sb.append(this.id);
        sb.append(", bookmark=");
        sb.append(this.bookmark);
        sb.append(")");
        return sb.toString();
    }

    public ShopBookmarkEvent(long j, boolean z) {
        this.id = j;
        this.bookmark = z;
    }

    public final boolean getBookmark() {
        return this.bookmark;
    }

    public final long getId() {
        return this.id;
    }
}
