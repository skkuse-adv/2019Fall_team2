package kr.co.popone.fitts.model.datamodel.service.user;

import com.uber.rave.annotation.Validated;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class BodyFilter {
    private int max_height;
    private int max_weight;
    private int min_height;
    private int min_weight;

    @NotNull
    public static /* synthetic */ BodyFilter copy$default(BodyFilter bodyFilter, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bodyFilter.min_height;
        }
        if ((i5 & 2) != 0) {
            i2 = bodyFilter.max_height;
        }
        if ((i5 & 4) != 0) {
            i3 = bodyFilter.min_weight;
        }
        if ((i5 & 8) != 0) {
            i4 = bodyFilter.max_weight;
        }
        return bodyFilter.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.min_height;
    }

    public final int component2() {
        return this.max_height;
    }

    public final int component3() {
        return this.min_weight;
    }

    public final int component4() {
        return this.max_weight;
    }

    @NotNull
    public final BodyFilter copy(int i, int i2, int i3, int i4) {
        return new BodyFilter(i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BodyFilter) {
                BodyFilter bodyFilter = (BodyFilter) obj;
                if (this.min_height == bodyFilter.min_height) {
                    if (this.max_height == bodyFilter.max_height) {
                        if (this.min_weight == bodyFilter.min_weight) {
                            if (this.max_weight == bodyFilter.max_weight) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.min_height * 31) + this.max_height) * 31) + this.min_weight) * 31) + this.max_weight;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BodyFilter(min_height=");
        sb.append(this.min_height);
        sb.append(", max_height=");
        sb.append(this.max_height);
        sb.append(", min_weight=");
        sb.append(this.min_weight);
        sb.append(", max_weight=");
        sb.append(this.max_weight);
        sb.append(")");
        return sb.toString();
    }

    public BodyFilter(int i, int i2, int i3, int i4) {
        this.min_height = i;
        this.max_height = i2;
        this.min_weight = i3;
        this.max_weight = i4;
    }

    public final int getMin_height() {
        return this.min_height;
    }

    public final void setMin_height(int i) {
        this.min_height = i;
    }

    public final int getMax_height() {
        return this.max_height;
    }

    public final void setMax_height(int i) {
        this.max_height = i;
    }

    public final int getMin_weight() {
        return this.min_weight;
    }

    public final void setMin_weight(int i) {
        this.min_weight = i;
    }

    public final int getMax_weight() {
        return this.max_weight;
    }

    public final void setMax_weight(int i) {
        this.max_weight = i;
    }
}
