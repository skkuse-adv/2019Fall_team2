package kr.co.popone.fitts.model.search;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HasMoreInfo {
    private final boolean hasMorePost;
    private final boolean hasMoreProduct;
    private final boolean hasMoreUser;

    @NotNull
    public static /* synthetic */ HasMoreInfo copy$default(HasMoreInfo hasMoreInfo, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hasMoreInfo.hasMorePost;
        }
        if ((i & 2) != 0) {
            z2 = hasMoreInfo.hasMoreProduct;
        }
        if ((i & 4) != 0) {
            z3 = hasMoreInfo.hasMoreUser;
        }
        return hasMoreInfo.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.hasMorePost;
    }

    public final boolean component2() {
        return this.hasMoreProduct;
    }

    public final boolean component3() {
        return this.hasMoreUser;
    }

    @NotNull
    public final HasMoreInfo copy(boolean z, boolean z2, boolean z3) {
        return new HasMoreInfo(z, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof HasMoreInfo) {
                HasMoreInfo hasMoreInfo = (HasMoreInfo) obj;
                if (this.hasMorePost == hasMoreInfo.hasMorePost) {
                    if (this.hasMoreProduct == hasMoreInfo.hasMoreProduct) {
                        if (this.hasMoreUser == hasMoreInfo.hasMoreUser) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.hasMorePost;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z2 = this.hasMoreProduct;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.hasMoreUser;
        if (!z3) {
            i = z3;
        }
        return i3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HasMoreInfo(hasMorePost=");
        sb.append(this.hasMorePost);
        sb.append(", hasMoreProduct=");
        sb.append(this.hasMoreProduct);
        sb.append(", hasMoreUser=");
        sb.append(this.hasMoreUser);
        sb.append(")");
        return sb.toString();
    }

    public HasMoreInfo(boolean z, boolean z2, boolean z3) {
        this.hasMorePost = z;
        this.hasMoreProduct = z2;
        this.hasMoreUser = z3;
    }

    public final boolean getHasMorePost() {
        return this.hasMorePost;
    }

    public final boolean getHasMoreProduct() {
        return this.hasMoreProduct;
    }

    public final boolean getHasMoreUser() {
        return this.hasMoreUser;
    }
}
