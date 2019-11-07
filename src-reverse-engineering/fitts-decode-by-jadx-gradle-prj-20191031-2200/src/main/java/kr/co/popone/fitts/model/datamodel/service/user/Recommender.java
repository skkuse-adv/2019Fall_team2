package kr.co.popone.fitts.model.datamodel.service.user;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Recommender {
    @SerializedName("is_available")
    private final boolean isRecommender;

    @NotNull
    public static /* synthetic */ Recommender copy$default(Recommender recommender, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = recommender.isRecommender;
        }
        return recommender.copy(z);
    }

    public final boolean component1() {
        return this.isRecommender;
    }

    @NotNull
    public final Recommender copy(boolean z) {
        return new Recommender(z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Recommender) {
                if (this.isRecommender == ((Recommender) obj).isRecommender) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isRecommender;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommender(isRecommender=");
        sb.append(this.isRecommender);
        sb.append(")");
        return sb.toString();
    }

    public Recommender(boolean z) {
        this.isRecommender = z;
    }

    public final boolean isRecommender() {
        return this.isRecommender;
    }
}
