package kr.co.popone.fitts.model.datamodel.service.user;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class BodyInfo {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final List<String> sizeList = CollectionsKt__CollectionsKt.listOf("2XS", "2XS반", "XS", "XS반", ExifInterface.LATITUDE_SOUTH, "S반", "M", "M반", "L", "L반", "XL", "XL반", "2XL", "2XL반", "3XL", "3XL반", "4XL", "4XL반", "5XL");
    @SerializedName("type")
    @NotNull
    private final BodyType bodyType;
    @Nullable
    private final String bottom;
    @Nullable
    private final String description;
    @SerializedName("shoe_description")
    @Nullable
    private final String footDescription;
    private final int height;
    @SerializedName("shoe_size")
    private final int shoeSize;
    @Nullable
    private final String top;
    private final int weight;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> getSizeList() {
            return BodyInfo.sizeList;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BodyType.values().length];

        static {
            $EnumSwitchMapping$0[BodyType.TRIANGLE.ordinal()] = 1;
            $EnumSwitchMapping$0[BodyType.INVERTED_TRIANGLE.ordinal()] = 2;
            $EnumSwitchMapping$0[BodyType.RECTANGLE.ordinal()] = 3;
            $EnumSwitchMapping$0[BodyType.HOURGLASS.ordinal()] = 4;
            $EnumSwitchMapping$0[BodyType.NORMAL.ordinal()] = 5;
        }
    }

    @NotNull
    public static /* synthetic */ BodyInfo copy$default(BodyInfo bodyInfo, BodyType bodyType2, int i, int i2, String str, String str2, int i3, String str3, String str4, int i4, Object obj) {
        BodyInfo bodyInfo2 = bodyInfo;
        int i5 = i4;
        return bodyInfo.copy((i5 & 1) != 0 ? bodyInfo2.bodyType : bodyType2, (i5 & 2) != 0 ? bodyInfo2.weight : i, (i5 & 4) != 0 ? bodyInfo2.height : i2, (i5 & 8) != 0 ? bodyInfo2.top : str, (i5 & 16) != 0 ? bodyInfo2.bottom : str2, (i5 & 32) != 0 ? bodyInfo2.shoeSize : i3, (i5 & 64) != 0 ? bodyInfo2.footDescription : str3, (i5 & 128) != 0 ? bodyInfo2.description : str4);
    }

    @NotNull
    public final BodyType component1() {
        return this.bodyType;
    }

    public final int component2() {
        return this.weight;
    }

    public final int component3() {
        return this.height;
    }

    @Nullable
    public final String component4() {
        return this.top;
    }

    @Nullable
    public final String component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.shoeSize;
    }

    @Nullable
    public final String component7() {
        return this.footDescription;
    }

    @Nullable
    public final String component8() {
        return this.description;
    }

    @NotNull
    public final BodyInfo copy(@NotNull BodyType bodyType2, int i, int i2, @Nullable String str, @Nullable String str2, int i3, @Nullable String str3, @Nullable String str4) {
        BodyType bodyType3 = bodyType2;
        Intrinsics.checkParameterIsNotNull(bodyType2, "bodyType");
        BodyInfo bodyInfo = new BodyInfo(bodyType3, i, i2, str, str2, i3, str3, str4);
        return bodyInfo;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BodyInfo) {
                BodyInfo bodyInfo = (BodyInfo) obj;
                if (Intrinsics.areEqual((Object) this.bodyType, (Object) bodyInfo.bodyType)) {
                    if (this.weight == bodyInfo.weight) {
                        if ((this.height == bodyInfo.height) && Intrinsics.areEqual((Object) this.top, (Object) bodyInfo.top) && Intrinsics.areEqual((Object) this.bottom, (Object) bodyInfo.bottom)) {
                            if (!(this.shoeSize == bodyInfo.shoeSize) || !Intrinsics.areEqual((Object) this.footDescription, (Object) bodyInfo.footDescription) || !Intrinsics.areEqual((Object) this.description, (Object) bodyInfo.description)) {
                                return false;
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
        BodyType bodyType2 = this.bodyType;
        int i = 0;
        int hashCode = (((((bodyType2 != null ? bodyType2.hashCode() : 0) * 31) + this.weight) * 31) + this.height) * 31;
        String str = this.top;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bottom;
        int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.shoeSize) * 31;
        String str3 = this.footDescription;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BodyInfo(bodyType=");
        sb.append(this.bodyType);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", bottom=");
        sb.append(this.bottom);
        sb.append(", shoeSize=");
        sb.append(this.shoeSize);
        sb.append(", footDescription=");
        sb.append(this.footDescription);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(")");
        return sb.toString();
    }

    public BodyInfo(@NotNull BodyType bodyType2, int i, int i2, @Nullable String str, @Nullable String str2, int i3, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkParameterIsNotNull(bodyType2, "bodyType");
        this.bodyType = bodyType2;
        this.weight = i;
        this.height = i2;
        this.top = str;
        this.bottom = str2;
        this.shoeSize = i3;
        this.footDescription = str3;
        this.description = str4;
    }

    @NotNull
    @NonNull
    public final BodyType getBodyType() {
        return this.bodyType;
    }

    @IntRange(from = 1)
    public final int getWeight() {
        return this.weight;
    }

    @IntRange(from = 1)
    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final String getTop() {
        return this.top;
    }

    @Nullable
    public final String getBottom() {
        return this.bottom;
    }

    public final int getShoeSize() {
        return this.shoeSize;
    }

    @Nullable
    public final String getFootDescription() {
        return this.footDescription;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String toSimpleInfo() {
        String str = this.top;
        boolean z = false;
        if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
            String str2 = this.bottom;
            if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
                z = true;
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.height);
                String str3 = " . ";
                sb.append(str3);
                sb.append(this.top);
                sb.append(str3);
                sb.append(this.bottom);
                return sb.toString();
            }
        }
        return String.valueOf(this.height);
    }

    public final int getBodyIconResource() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.bodyType.ordinal()];
        if (i == 1) {
            return C0008R$drawable.image_profile_triangle;
        }
        if (i == 2) {
            return C0008R$drawable.image_profile_invert;
        }
        if (i == 3) {
            return C0008R$drawable.image_profile_rectangle;
        }
        if (i == 4) {
            return C0008R$drawable.image_profile_hourglass;
        }
        if (i == 5) {
            return C0008R$drawable.image_profile_regular;
        }
        throw new NoWhenBranchMatchedException();
    }
}
