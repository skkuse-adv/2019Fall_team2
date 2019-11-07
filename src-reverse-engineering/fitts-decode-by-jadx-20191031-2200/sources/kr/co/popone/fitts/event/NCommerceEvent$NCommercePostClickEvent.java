package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class NCommerceEvent$NCommercePostClickEvent {
    @NotNull
    private final Post post;

    @NotNull
    public static /* synthetic */ NCommerceEvent$NCommercePostClickEvent copy$default(NCommerceEvent$NCommercePostClickEvent nCommerceEvent$NCommercePostClickEvent, Post post2, int i, Object obj) {
        if ((i & 1) != 0) {
            post2 = nCommerceEvent$NCommercePostClickEvent.post;
        }
        return nCommerceEvent$NCommercePostClickEvent.copy(post2);
    }

    @NotNull
    public final Post component1() {
        return this.post;
    }

    @NotNull
    public final NCommerceEvent$NCommercePostClickEvent copy(@NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post2, "post");
        return new NCommerceEvent$NCommercePostClickEvent(post2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.post, (java.lang.Object) ((kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent) r2).post) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent r2 = (kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent) r2
            kr.co.popone.fitts.model.post.PostAPI$Post r0 = r1.post
            kr.co.popone.fitts.model.post.PostAPI$Post r2 = r2.post
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Post post2 = this.post;
        if (post2 != null) {
            return post2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NCommercePostClickEvent(post=");
        sb.append(this.post);
        sb.append(")");
        return sb.toString();
    }

    public NCommerceEvent$NCommercePostClickEvent(@NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post2, "post");
        this.post = post2;
    }

    @NotNull
    public final Post getPost() {
        return this.post;
    }
}
