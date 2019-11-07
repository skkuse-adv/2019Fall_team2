package kr.co.popone.fitts.model.datamodel.social.feed;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public abstract class RecommendFittieInfo {

    public static final class FittieRecommendHeader extends RecommendFittieInfo {
        public static final FittieRecommendHeader INSTANCE = new FittieRecommendHeader();

        private FittieRecommendHeader() {
            super(null);
        }
    }

    public static final class RecommendFittie extends RecommendFittieInfo {
        @SerializedName("posts")
        @NotNull
        private final List<Post> posts;
        @SerializedName("user")
        @NotNull
        private final User user;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie copy$default(kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie r0, kr.co.popone.fitts.model.datamodel.service.user.User r1, java.util.List<kr.co.popone.fitts.model.post.PostAPI.Post> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                kr.co.popone.fitts.model.datamodel.service.user.User r1 = r0.user
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r2 = r0.posts
            L_0x000c:
                kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo$RecommendFittie r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie.copy$default(kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo$RecommendFittie, kr.co.popone.fitts.model.datamodel.service.user.User, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo$RecommendFittie");
        }

        @NotNull
        public final User component1() {
            return this.user;
        }

        @NotNull
        public final List<Post> component2() {
            return this.posts;
        }

        @NotNull
        public final RecommendFittie copy(@NotNull User user2, @NotNull List<Post> list) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(list, "posts");
            return new RecommendFittie(user2, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.posts, (java.lang.Object) r3.posts) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo$RecommendFittie r3 = (kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie) r3
                kr.co.popone.fitts.model.datamodel.service.user.User r0 = r2.user
                kr.co.popone.fitts.model.datamodel.service.user.User r1 = r3.user
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r0 = r2.posts
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r3 = r3.posts
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r3 = 0
                return r3
            L_0x001f:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            User user2 = this.user;
            int i = 0;
            int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
            List<Post> list = this.posts;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RecommendFittie(user=");
            sb.append(this.user);
            sb.append(", posts=");
            sb.append(this.posts);
            sb.append(")");
            return sb.toString();
        }

        @NotNull
        public final User getUser() {
            return this.user;
        }

        @NotNull
        public final List<Post> getPosts() {
            return this.posts;
        }

        public RecommendFittie(@NotNull User user2, @NotNull List<Post> list) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(list, "posts");
            super(null);
            this.user = user2;
            this.posts = list;
        }
    }

    private RecommendFittieInfo() {
    }

    public /* synthetic */ RecommendFittieInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
