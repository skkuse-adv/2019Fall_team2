package kr.co.popone.fitts.model;

import androidx.annotation.NonNull;
import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;

@Validated(factory = ValidatorFactoryImpl.class)
public final class ImageUrlWithRatio {
    private final float ratio;
    @NotNull
    private final String url;

    @NotNull
    public static /* synthetic */ ImageUrlWithRatio copy$default(ImageUrlWithRatio imageUrlWithRatio, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageUrlWithRatio.url;
        }
        if ((i & 2) != 0) {
            f = imageUrlWithRatio.ratio;
        }
        return imageUrlWithRatio.copy(str, f);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    public final float component2() {
        return this.ratio;
    }

    @NotNull
    public final ImageUrlWithRatio copy(@NotNull String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        return new ImageUrlWithRatio(str, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (java.lang.Float.compare(r2.ratio, r3.ratio) == 0) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.ImageUrlWithRatio
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.ImageUrlWithRatio r3 = (kr.co.popone.fitts.model.ImageUrlWithRatio) r3
            java.lang.String r0 = r2.url
            java.lang.String r1 = r3.url
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            float r0 = r2.ratio
            float r3 = r3.ratio
            int r3 = java.lang.Float.compare(r0, r3)
            if (r3 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.ImageUrlWithRatio.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.url;
        return ((str != null ? str.hashCode() : 0) * 31) + Float.floatToIntBits(this.ratio);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageUrlWithRatio(url=");
        sb.append(this.url);
        sb.append(", ratio=");
        sb.append(this.ratio);
        sb.append(")");
        return sb.toString();
    }

    public ImageUrlWithRatio(@NotNull String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.url = str;
        this.ratio = f;
    }

    @NotNull
    @NonNull
    public final String getUrl() {
        return this.url;
    }

    public final float getRatio() {
        return this.ratio;
    }
}
