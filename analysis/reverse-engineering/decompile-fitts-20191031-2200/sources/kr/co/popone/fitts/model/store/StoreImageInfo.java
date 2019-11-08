package kr.co.popone.fitts.model.store;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class StoreImageInfo {
    @SerializedName("main_image_ratio")
    private final double ratio;
    @SerializedName("main_image_url")
    @NotNull
    private final String url;

    @NotNull
    public static /* synthetic */ StoreImageInfo copy$default(StoreImageInfo storeImageInfo, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeImageInfo.url;
        }
        if ((i & 2) != 0) {
            d = storeImageInfo.ratio;
        }
        return storeImageInfo.copy(str, d);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    public final double component2() {
        return this.ratio;
    }

    @NotNull
    public final StoreImageInfo copy(@NotNull String str, double d) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        return new StoreImageInfo(str, d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (java.lang.Double.compare(r4.ratio, r5.ratio) == 0) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
        /*
            r4 = this;
            if (r4 == r5) goto L_0x001f
            boolean r0 = r5 instanceof kr.co.popone.fitts.model.store.StoreImageInfo
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.store.StoreImageInfo r5 = (kr.co.popone.fitts.model.store.StoreImageInfo) r5
            java.lang.String r0 = r4.url
            java.lang.String r1 = r5.url
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            double r0 = r4.ratio
            double r2 = r5.ratio
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.StoreImageInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.ratio);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreImageInfo(url=");
        sb.append(this.url);
        sb.append(", ratio=");
        sb.append(this.ratio);
        sb.append(")");
        return sb.toString();
    }

    public StoreImageInfo(@NotNull String str, double d) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.url = str;
        this.ratio = d;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final double getRatio() {
        return this.ratio;
    }
}
