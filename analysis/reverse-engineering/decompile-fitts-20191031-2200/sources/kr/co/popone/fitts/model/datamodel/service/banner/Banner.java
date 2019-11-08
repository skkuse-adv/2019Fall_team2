package kr.co.popone.fitts.model.datamodel.service.banner;

import androidx.annotation.NonNull;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class Banner {
    private final long id;
    @SerializedName("image")
    @NotNull
    private final BannerImage image;
    @SerializedName("post_index")
    private final int index;
    @SerializedName("banner_scheme")
    @NotNull
    private final String scheme;

    @NotNull
    public static /* synthetic */ Banner copy$default(Banner banner, long j, BannerImage bannerImage, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = banner.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            bannerImage = banner.image;
        }
        BannerImage bannerImage2 = bannerImage;
        if ((i2 & 4) != 0) {
            str = banner.scheme;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = banner.index;
        }
        return banner.copy(j2, bannerImage2, str2, i);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final BannerImage component2() {
        return this.image;
    }

    @NotNull
    public final String component3() {
        return this.scheme;
    }

    public final int component4() {
        return this.index;
    }

    @NotNull
    public final Banner copy(long j, @NotNull BannerImage bannerImage, @NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(bannerImage, MessengerShareContentUtility.MEDIA_IMAGE);
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        Banner banner = new Banner(j, bannerImage, str, i);
        return banner;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Banner) {
                Banner banner = (Banner) obj;
                if ((this.id == banner.id) && Intrinsics.areEqual((Object) this.image, (Object) banner.image) && Intrinsics.areEqual((Object) this.scheme, (Object) banner.scheme)) {
                    if (this.index == banner.index) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        BannerImage bannerImage = this.image;
        int i2 = 0;
        int hashCode = (i + (bannerImage != null ? bannerImage.hashCode() : 0)) * 31;
        String str = this.scheme;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((hashCode + i2) * 31) + this.index;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Banner(id=");
        sb.append(this.id);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(", scheme=");
        sb.append(this.scheme);
        sb.append(", index=");
        sb.append(this.index);
        sb.append(")");
        return sb.toString();
    }

    public Banner(long j, @NotNull BannerImage bannerImage, @NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(bannerImage, MessengerShareContentUtility.MEDIA_IMAGE);
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        this.id = j;
        this.image = bannerImage;
        this.scheme = str;
        this.index = i;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @NotNull
    public final BannerImage getImage() {
        return this.image;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    public final int getIndex() {
        return this.index;
    }
}
