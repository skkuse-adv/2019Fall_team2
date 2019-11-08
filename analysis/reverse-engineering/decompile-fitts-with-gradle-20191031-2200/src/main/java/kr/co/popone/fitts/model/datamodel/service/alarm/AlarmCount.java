package kr.co.popone.fitts.model.datamodel.service.alarm;

import com.uber.rave.annotation.Validated;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class AlarmCount {
    private final int new_badge_count;

    @NotNull
    public static /* synthetic */ AlarmCount copy$default(AlarmCount alarmCount, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = alarmCount.new_badge_count;
        }
        return alarmCount.copy(i);
    }

    public final int component1() {
        return this.new_badge_count;
    }

    @NotNull
    public final AlarmCount copy(int i) {
        return new AlarmCount(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AlarmCount) {
                if (this.new_badge_count == ((AlarmCount) obj).new_badge_count) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.new_badge_count;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlarmCount(new_badge_count=");
        sb.append(this.new_badge_count);
        sb.append(")");
        return sb.toString();
    }

    public AlarmCount(int i) {
        this.new_badge_count = i;
    }

    public final int getNew_badge_count() {
        return this.new_badge_count;
    }
}
