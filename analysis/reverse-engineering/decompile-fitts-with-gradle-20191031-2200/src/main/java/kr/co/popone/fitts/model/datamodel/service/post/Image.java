package kr.co.popone.fitts.model.datamodel.service.post;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class Image {
    private final int attachment_id;
    @Nullable
    private final String description;
    @SerializedName("dominant_color")
    @NotNull
    private final String dominantColor;
    @Nullable
    private Integer height;
    private final int id;
    @NotNull
    private final String lqip;
    @Nullable
    private final String small;
    @Nullable
    private final String thumbnail;
    @NotNull
    private final String url;
    @Nullable
    private final Integer width;

    @NotNull
    public static /* synthetic */ Image copy$default(Image image, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, int i3, Object obj) {
        Image image2 = image;
        int i4 = i3;
        return image.copy((i4 & 1) != 0 ? image2.id : i, (i4 & 2) != 0 ? image2.attachment_id : i2, (i4 & 4) != 0 ? image2.url : str, (i4 & 8) != 0 ? image2.thumbnail : str2, (i4 & 16) != 0 ? image2.small : str3, (i4 & 32) != 0 ? image2.lqip : str4, (i4 & 64) != 0 ? image2.description : str5, (i4 & 128) != 0 ? image2.dominantColor : str6, (i4 & 256) != 0 ? image2.width : num, (i4 & 512) != 0 ? image2.height : num2);
    }

    public final int component1() {
        return this.id;
    }

    @Nullable
    public final Integer component10() {
        return this.height;
    }

    public final int component2() {
        return this.attachment_id;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final String component4() {
        return this.thumbnail;
    }

    @Nullable
    public final String component5() {
        return this.small;
    }

    @NotNull
    public final String component6() {
        return this.lqip;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @NotNull
    public final String component8() {
        return this.dominantColor;
    }

    @Nullable
    public final Integer component9() {
        return this.width;
    }

    @NotNull
    public final Image copy(int i, int i2, @NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @NotNull String str6, @Nullable Integer num, @Nullable Integer num2) {
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str, "url");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "lqip");
        String str9 = str6;
        Intrinsics.checkParameterIsNotNull(str9, "dominantColor");
        Image image = new Image(i, i2, str7, str2, str3, str8, str5, str9, num, num2);
        return image;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Image) {
                Image image = (Image) obj;
                if (this.id == image.id) {
                    if (!(this.attachment_id == image.attachment_id) || !Intrinsics.areEqual((Object) this.url, (Object) image.url) || !Intrinsics.areEqual((Object) this.thumbnail, (Object) image.thumbnail) || !Intrinsics.areEqual((Object) this.small, (Object) image.small) || !Intrinsics.areEqual((Object) this.lqip, (Object) image.lqip) || !Intrinsics.areEqual((Object) this.description, (Object) image.description) || !Intrinsics.areEqual((Object) this.dominantColor, (Object) image.dominantColor) || !Intrinsics.areEqual((Object) this.width, (Object) image.width) || !Intrinsics.areEqual((Object) this.height, (Object) image.height)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.id * 31) + this.attachment_id) * 31;
        String str = this.url;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.thumbnail;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.small;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lqip;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.dominantColor;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num = this.width;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        return hashCode7 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Image(id=");
        sb.append(this.id);
        sb.append(", attachment_id=");
        sb.append(this.attachment_id);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", thumbnail=");
        sb.append(this.thumbnail);
        sb.append(", small=");
        sb.append(this.small);
        sb.append(", lqip=");
        sb.append(this.lqip);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", dominantColor=");
        sb.append(this.dominantColor);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(")");
        return sb.toString();
    }

    public Image(int i, int i2, @NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @NotNull String str6, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str4, "lqip");
        Intrinsics.checkParameterIsNotNull(str6, "dominantColor");
        this.id = i;
        this.attachment_id = i2;
        this.url = str;
        this.thumbnail = str2;
        this.small = str3;
        this.lqip = str4;
        this.description = str5;
        this.dominantColor = str6;
        this.width = num;
        this.height = num2;
    }

    @NonNull
    public final int getId() {
        return this.id;
    }

    public final int getAttachment_id() {
        return this.attachment_id;
    }

    @NotNull
    @NonNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Nullable
    public final String getSmall() {
        return this.small;
    }

    @NotNull
    public final String getLqip() {
        return this.lqip;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    @NonNull
    public final String getDominantColor() {
        return this.dominantColor;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    public final void setHeight(@Nullable Integer num) {
        this.height = num;
    }
}
