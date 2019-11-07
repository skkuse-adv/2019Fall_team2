package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FeedEvent$FollowClicked {
    private final boolean isFollowed;
    private final long userId;

    @NotNull
    public static /* synthetic */ FeedEvent$FollowClicked copy$default(FeedEvent$FollowClicked feedEvent$FollowClicked, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = feedEvent$FollowClicked.userId;
        }
        if ((i & 2) != 0) {
            z = feedEvent$FollowClicked.isFollowed;
        }
        return feedEvent$FollowClicked.copy(j, z);
    }

    public final long component1() {
        return this.userId;
    }

    public final boolean component2() {
        return this.isFollowed;
    }

    @NotNull
    public final FeedEvent$FollowClicked copy(long j, boolean z) {
        return new FeedEvent$FollowClicked(j, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FeedEvent$FollowClicked) {
                FeedEvent$FollowClicked feedEvent$FollowClicked = (FeedEvent$FollowClicked) obj;
                if (this.userId == feedEvent$FollowClicked.userId) {
                    if (this.isFollowed == feedEvent$FollowClicked.isFollowed) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z = this.isFollowed;
        if (z) {
            z = true;
        }
        return i + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FollowClicked(userId=");
        sb.append(this.userId);
        sb.append(", isFollowed=");
        sb.append(this.isFollowed);
        sb.append(")");
        return sb.toString();
    }

    public FeedEvent$FollowClicked(long j, boolean z) {
        this.userId = j;
        this.isFollowed = z;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final boolean isFollowed() {
        return this.isFollowed;
    }
}
