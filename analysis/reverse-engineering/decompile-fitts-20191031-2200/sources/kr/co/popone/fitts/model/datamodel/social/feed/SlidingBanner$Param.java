package kr.co.popone.fitts.model.datamodel.social.feed;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SlidingBanner$Param {
    private final int height;
    private final int margin;
    private final int width;

    @NotNull
    public static /* synthetic */ SlidingBanner$Param copy$default(SlidingBanner$Param slidingBanner$Param, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = slidingBanner$Param.width;
        }
        if ((i4 & 2) != 0) {
            i2 = slidingBanner$Param.margin;
        }
        if ((i4 & 4) != 0) {
            i3 = slidingBanner$Param.height;
        }
        return slidingBanner$Param.copy(i, i2, i3);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.margin;
    }

    public final int component3() {
        return this.height;
    }

    @NotNull
    public final SlidingBanner$Param copy(int i, int i2, int i3) {
        return new SlidingBanner$Param(i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SlidingBanner$Param) {
                SlidingBanner$Param slidingBanner$Param = (SlidingBanner$Param) obj;
                if (this.width == slidingBanner$Param.width) {
                    if (this.margin == slidingBanner$Param.margin) {
                        if (this.height == slidingBanner$Param.height) {
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
        return (((this.width * 31) + this.margin) * 31) + this.height;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Param(width=");
        sb.append(this.width);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(")");
        return sb.toString();
    }

    public SlidingBanner$Param(int i, int i2, int i3) {
        this.width = i;
        this.margin = i2;
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMargin() {
        return this.margin;
    }

    public final int getWidth() {
        return this.width;
    }
}
