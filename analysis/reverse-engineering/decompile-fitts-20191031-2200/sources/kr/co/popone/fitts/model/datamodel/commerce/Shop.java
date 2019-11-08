package kr.co.popone.fitts.model.datamodel.commerce;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class Shop implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("domains")
    @NotNull
    private final List<String> domainNames;
    @Nullable
    private final String host;
    private final long id;
    @Nullable
    private final String name;
    @NotNull
    private final String url;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            Shop shop = new Shop(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
            return shop;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new Shop[i];
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r12v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.datamodel.commerce.Shop copy$default(kr.co.popone.fitts.model.datamodel.commerce.Shop r7, long r8, java.lang.String r10, java.lang.String r11, java.util.List<java.lang.String> r12, java.lang.String r13, int r14, java.lang.Object r15) {
        /*
            r15 = r14 & 1
            if (r15 == 0) goto L_0x0006
            long r8 = r7.id
        L_0x0006:
            r1 = r8
            r8 = r14 & 2
            if (r8 == 0) goto L_0x000d
            java.lang.String r10 = r7.name
        L_0x000d:
            r3 = r10
            r8 = r14 & 4
            if (r8 == 0) goto L_0x0014
            java.lang.String r11 = r7.url
        L_0x0014:
            r4 = r11
            r8 = r14 & 8
            if (r8 == 0) goto L_0x001b
            java.util.List<java.lang.String> r12 = r7.domainNames
        L_0x001b:
            r5 = r12
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0022
            java.lang.String r13 = r7.host
        L_0x0022:
            r6 = r13
            r0 = r7
            kr.co.popone.fitts.model.datamodel.commerce.Shop r7 = r0.copy(r1, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.Shop.copy$default(kr.co.popone.fitts.model.datamodel.commerce.Shop, long, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.commerce.Shop");
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final List<String> component4() {
        return this.domainNames;
    }

    @Nullable
    public final String component5() {
        return this.host;
    }

    @NotNull
    public final Shop copy(long j, @Nullable String str, @NotNull String str2, @NotNull List<String> list, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str2, "url");
        Intrinsics.checkParameterIsNotNull(list, "domainNames");
        Shop shop = new Shop(j, str, str2, list, str3);
        return shop;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Shop) {
                Shop shop = (Shop) obj;
                if (!(this.id == shop.id) || !Intrinsics.areEqual((Object) this.name, (Object) shop.name) || !Intrinsics.areEqual((Object) this.url, (Object) shop.url) || !Intrinsics.areEqual((Object) this.domainNames, (Object) shop.domainNames) || !Intrinsics.areEqual((Object) this.host, (Object) shop.host)) {
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
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.domainNames;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.host;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shop(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", domainNames=");
        sb.append(this.domainNames);
        sb.append(", host=");
        sb.append(this.host);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeStringList(this.domainNames);
        parcel.writeString(this.host);
    }

    public Shop(long j, @Nullable String str, @NotNull String str2, @NotNull List<String> list, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str2, "url");
        Intrinsics.checkParameterIsNotNull(list, "domainNames");
        this.id = j;
        this.name = str;
        this.url = str2;
        this.domainNames = list;
        this.host = str3;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final List<String> getDomainNames() {
        return this.domainNames;
    }

    @Nullable
    public final String getHost() {
        return this.host;
    }
}
