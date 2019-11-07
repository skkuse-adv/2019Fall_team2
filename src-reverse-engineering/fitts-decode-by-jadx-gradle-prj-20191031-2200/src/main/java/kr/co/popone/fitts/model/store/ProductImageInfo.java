package kr.co.popone.fitts.model.store;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductImageInfo {
    @SerializedName("ratio")
    private final double imageRatio;
    @SerializedName("image_url")
    @Nullable
    private final String imageUrl;

    @NotNull
    public static /* synthetic */ ProductImageInfo copy$default(ProductImageInfo productImageInfo, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productImageInfo.imageUrl;
        }
        if ((i & 2) != 0) {
            d = productImageInfo.imageRatio;
        }
        return productImageInfo.copy(str, d);
    }

    @Nullable
    public final String component1() {
        return this.imageUrl;
    }

    public final double component2() {
        return this.imageRatio;
    }

    @NotNull
    public final ProductImageInfo copy(@Nullable String str, double d) {
        return new ProductImageInfo(str, d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (java.lang.Double.compare(r4.imageRatio, r5.imageRatio) == 0) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
        /*
            r4 = this;
            if (r4 == r5) goto L_0x001f
            boolean r0 = r5 instanceof kr.co.popone.fitts.model.store.ProductImageInfo
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.store.ProductImageInfo r5 = (kr.co.popone.fitts.model.store.ProductImageInfo) r5
            java.lang.String r0 = r4.imageUrl
            java.lang.String r1 = r5.imageUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            double r0 = r4.imageRatio
            double r2 = r5.imageRatio
            int r5 = java.lang.Double.compare(r0, r2)
            if (r5 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            return r5
        L_0x001f:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductImageInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.imageUrl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.imageRatio);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductImageInfo(imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", imageRatio=");
        sb.append(this.imageRatio);
        sb.append(")");
        return sb.toString();
    }

    public ProductImageInfo(@Nullable String str, double d) {
        this.imageUrl = str;
        this.imageRatio = d;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final double getImageRatio() {
        return this.imageRatio;
    }
}
