package kr.co.popone.fitts.event;

import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderEvent$CreatePostOrderVariant {
    @Nullable
    private final PostType postType;
    @NotNull
    private final PostVariantViewData postVariantViewData;
    @NotNull
    private final String state;

    @NotNull
    public static /* synthetic */ OrderEvent$CreatePostOrderVariant copy$default(OrderEvent$CreatePostOrderVariant orderEvent$CreatePostOrderVariant, String str, PostType postType2, PostVariantViewData postVariantViewData2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderEvent$CreatePostOrderVariant.state;
        }
        if ((i & 2) != 0) {
            postType2 = orderEvent$CreatePostOrderVariant.postType;
        }
        if ((i & 4) != 0) {
            postVariantViewData2 = orderEvent$CreatePostOrderVariant.postVariantViewData;
        }
        return orderEvent$CreatePostOrderVariant.copy(str, postType2, postVariantViewData2);
    }

    @NotNull
    public final String component1() {
        return this.state;
    }

    @Nullable
    public final PostType component2() {
        return this.postType;
    }

    @NotNull
    public final PostVariantViewData component3() {
        return this.postVariantViewData;
    }

    @NotNull
    public final OrderEvent$CreatePostOrderVariant copy(@NotNull String str, @Nullable PostType postType2, @NotNull PostVariantViewData postVariantViewData2) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(postVariantViewData2, "postVariantViewData");
        return new OrderEvent$CreatePostOrderVariant(str, postType2, postVariantViewData2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.postVariantViewData, (java.lang.Object) r3.postVariantViewData) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant r3 = (kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant) r3
            java.lang.String r0 = r2.state
            java.lang.String r1 = r3.state
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.feature.post.PostType r0 = r2.postType
            kr.co.popone.fitts.feature.post.PostType r1 = r3.postType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.post.PostVariantViewData r0 = r2.postVariantViewData
            kr.co.popone.fitts.model.post.PostVariantViewData r3 = r3.postVariantViewData
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.state;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        PostType postType2 = this.postType;
        int hashCode2 = (hashCode + (postType2 != null ? postType2.hashCode() : 0)) * 31;
        PostVariantViewData postVariantViewData2 = this.postVariantViewData;
        if (postVariantViewData2 != null) {
            i = postVariantViewData2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreatePostOrderVariant(state=");
        sb.append(this.state);
        sb.append(", postType=");
        sb.append(this.postType);
        sb.append(", postVariantViewData=");
        sb.append(this.postVariantViewData);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$CreatePostOrderVariant(@NotNull String str, @Nullable PostType postType2, @NotNull PostVariantViewData postVariantViewData2) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(postVariantViewData2, "postVariantViewData");
        this.state = str;
        this.postType = postType2;
        this.postVariantViewData = postVariantViewData2;
    }

    @Nullable
    public final PostType getPostType() {
        return this.postType;
    }

    @NotNull
    public final PostVariantViewData getPostVariantViewData() {
        return this.postVariantViewData;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }
}
