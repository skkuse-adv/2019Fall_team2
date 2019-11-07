package kr.co.popone.fitts.model.datamodel.service.promotion;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Promotion {
    @SerializedName("id")
    private final long id;
    @SerializedName("img_url")
    @Nullable
    private final String imageUrl;
    @SerializedName("target")
    @Nullable
    private final String target;
    @SerializedName("type")
    @Nullable
    private final Type type;
    @SerializedName("web_url")
    @Nullable
    private final String webUrl;

    public enum Type {
        IMAGE,
        WEB
    }

    @NotNull
    public static /* synthetic */ Promotion copy$default(Promotion promotion, long j, Type type2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = promotion.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            type2 = promotion.type;
        }
        Type type3 = type2;
        if ((i & 4) != 0) {
            str = promotion.target;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = promotion.imageUrl;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = promotion.webUrl;
        }
        return promotion.copy(j2, type3, str4, str5, str3);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final Type component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.target;
    }

    @Nullable
    public final String component4() {
        return this.imageUrl;
    }

    @Nullable
    public final String component5() {
        return this.webUrl;
    }

    @NotNull
    public final Promotion copy(long j, @Nullable Type type2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Promotion promotion = new Promotion(j, type2, str, str2, str3);
        return promotion;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Promotion) {
                Promotion promotion = (Promotion) obj;
                if (!(this.id == promotion.id) || !Intrinsics.areEqual((Object) this.type, (Object) promotion.type) || !Intrinsics.areEqual((Object) this.target, (Object) promotion.target) || !Intrinsics.areEqual((Object) this.imageUrl, (Object) promotion.imageUrl) || !Intrinsics.areEqual((Object) this.webUrl, (Object) promotion.webUrl)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Type type2 = this.type;
        int i2 = 0;
        int hashCode = (i + (type2 != null ? type2.hashCode() : 0)) * 31;
        String str = this.target;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.webUrl;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Promotion(id=");
        sb.append(this.id);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", target=");
        sb.append(this.target);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", webUrl=");
        sb.append(this.webUrl);
        sb.append(")");
        return sb.toString();
    }

    public Promotion(long j, @Nullable Type type2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.id = j;
        this.type = type2;
        this.target = str;
        this.imageUrl = str2;
        this.webUrl = str3;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Nullable
    public final String getTarget() {
        return this.target;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getWebUrl() {
        return this.webUrl;
    }
}
