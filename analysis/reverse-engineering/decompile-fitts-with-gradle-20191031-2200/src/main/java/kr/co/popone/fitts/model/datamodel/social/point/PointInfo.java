package kr.co.popone.fitts.model.datamodel.social.point;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointInfo {
    @SerializedName("accumulate_reward_points")
    private final int accumulatedRewardPoints;
    @SerializedName("reward_points")
    private final int rewardPoints;

    @NotNull
    public static /* synthetic */ PointInfo copy$default(PointInfo pointInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pointInfo.rewardPoints;
        }
        if ((i3 & 2) != 0) {
            i2 = pointInfo.accumulatedRewardPoints;
        }
        return pointInfo.copy(i, i2);
    }

    public final int component1() {
        return this.rewardPoints;
    }

    public final int component2() {
        return this.accumulatedRewardPoints;
    }

    @NotNull
    public final PointInfo copy(int i, int i2) {
        return new PointInfo(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PointInfo) {
                PointInfo pointInfo = (PointInfo) obj;
                if (this.rewardPoints == pointInfo.rewardPoints) {
                    if (this.accumulatedRewardPoints == pointInfo.accumulatedRewardPoints) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.rewardPoints * 31) + this.accumulatedRewardPoints;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PointInfo(rewardPoints=");
        sb.append(this.rewardPoints);
        sb.append(", accumulatedRewardPoints=");
        sb.append(this.accumulatedRewardPoints);
        sb.append(")");
        return sb.toString();
    }

    public PointInfo(int i, int i2) {
        this.rewardPoints = i;
        this.accumulatedRewardPoints = i2;
    }

    @NonNull
    public final int getRewardPoints() {
        return this.rewardPoints;
    }

    @NonNull
    public final int getAccumulatedRewardPoints() {
        return this.accumulatedRewardPoints;
    }
}
