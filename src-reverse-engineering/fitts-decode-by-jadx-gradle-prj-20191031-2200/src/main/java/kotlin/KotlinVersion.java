package kotlin;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinVersion implements Comparable<KotlinVersion> {
    @NotNull
    public static final KotlinVersion CURRENT = new KotlinVersion(1, 3, 20);
    public static final Companion Companion = new Companion(null);
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        this.version = versionOf(this.major, this.minor, this.patch);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public KotlinVersion(int i, int i2) {
        this(i, i2, 0);
    }

    private final int versionOf(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Version components are out of range: ");
        sb.append(i);
        sb.append('.');
        sb.append(i2);
        sb.append('.');
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinVersion)) {
            obj = null;
        }
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        if (kotlinVersion == null) {
            return false;
        }
        if (this.version != kotlinVersion.version) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.version;
    }

    public int compareTo(@NotNull KotlinVersion kotlinVersion) {
        Intrinsics.checkParameterIsNotNull(kotlinVersion, FacebookRequestErrorClassification.KEY_OTHER);
        return this.version - kotlinVersion.version;
    }

    public final boolean isAtLeast(int i, int i2) {
        int i3 = this.major;
        return i3 > i || (i3 == i && this.minor >= i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r1.patch < r4) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isAtLeast(int r2, int r3, int r4) {
        /*
            r1 = this;
            int r0 = r1.major
            if (r0 > r2) goto L_0x0013
            if (r0 != r2) goto L_0x0011
            int r2 = r1.minor
            if (r2 > r3) goto L_0x0013
            if (r2 != r3) goto L_0x0011
            int r2 = r1.patch
            if (r2 < r4) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = 0
            goto L_0x0014
        L_0x0013:
            r2 = 1
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.KotlinVersion.isAtLeast(int, int, int):boolean");
    }
}
