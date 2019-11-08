package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FeedEvent$LikePostClicked {
    private final boolean isLiked;
    private final long postId;

    @NotNull
    public static /* synthetic */ FeedEvent$LikePostClicked copy$default(FeedEvent$LikePostClicked feedEvent$LikePostClicked, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = feedEvent$LikePostClicked.postId;
        }
        if ((i & 2) != 0) {
            z = feedEvent$LikePostClicked.isLiked;
        }
        return feedEvent$LikePostClicked.copy(j, z);
    }

    public final long component1() {
        return this.postId;
    }

    public final boolean component2() {
        return this.isLiked;
    }

    @NotNull
    public final FeedEvent$LikePostClicked copy(long j, boolean z) {
        return new FeedEvent$LikePostClicked(j, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FeedEvent$LikePostClicked) {
                FeedEvent$LikePostClicked feedEvent$LikePostClicked = (FeedEvent$LikePostClicked) obj;
                if (this.postId == feedEvent$LikePostClicked.postId) {
                    if (this.isLiked == feedEvent$LikePostClicked.isLiked) {
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
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z = this.isLiked;
        if (z) {
            z = true;
        }
        return i + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LikePostClicked(postId=");
        sb.append(this.postId);
        sb.append(", isLiked=");
        sb.append(this.isLiked);
        sb.append(")");
        return sb.toString();
    }

    public FeedEvent$LikePostClicked(long j, boolean z) {
        this.postId = j;
        this.isLiked = z;
    }

    public final long getPostId() {
        return this.postId;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }
}
