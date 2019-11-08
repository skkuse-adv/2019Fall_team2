package kr.co.popone.fitts.model.remote.search;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KeywordSearchPostResult {
    @SerializedName("total_count")
    private final int count;
    @SerializedName("results")
    @NotNull
    private final List<Post> posts;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post>, for r1v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult copy$default(kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult r0, java.util.List<kr.co.popone.fitts.model.post.PostAPI.Post> r1, int r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r1 = r0.posts
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            int r2 = r0.count
        L_0x000c:
            kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult.copy$default(kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult, java.util.List, int, int, java.lang.Object):kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult");
    }

    @NotNull
    public final List<Post> component1() {
        return this.posts;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final KeywordSearchPostResult copy(@NotNull List<Post> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "posts");
        return new KeywordSearchPostResult(list, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof KeywordSearchPostResult) {
                KeywordSearchPostResult keywordSearchPostResult = (KeywordSearchPostResult) obj;
                if (Intrinsics.areEqual((Object) this.posts, (Object) keywordSearchPostResult.posts)) {
                    if (this.count == keywordSearchPostResult.count) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<Post> list = this.posts;
        return ((list != null ? list.hashCode() : 0) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeywordSearchPostResult(posts=");
        sb.append(this.posts);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(")");
        return sb.toString();
    }

    public KeywordSearchPostResult(@NotNull List<Post> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "posts");
        this.posts = list;
        this.count = i;
    }

    @NotNull
    public final List<Post> getPosts() {
        return this.posts;
    }

    public final int getCount() {
        return this.count;
    }
}
