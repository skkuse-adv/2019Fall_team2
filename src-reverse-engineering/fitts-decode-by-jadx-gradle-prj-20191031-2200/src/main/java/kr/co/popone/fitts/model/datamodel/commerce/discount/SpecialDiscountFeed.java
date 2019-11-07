package kr.co.popone.fitts.model.datamodel.commerce.discount;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialDiscountFeed implements Parcelable, FeedItem {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final String banner;
    private final long eventId;
    @NotNull
    private final List<SpecialDiscount> feeds;
    @Nullable
    private final Type type;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Type type;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            long readLong = parcel.readLong();
            if (parcel.readInt() != 0) {
                type = (Type) Enum.valueOf(Type.class, parcel.readString());
            } else {
                type = null;
            }
            Type type2 = type;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SpecialDiscount) SpecialDiscount.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            SpecialDiscountFeed specialDiscountFeed = new SpecialDiscountFeed(readLong, type2, arrayList, parcel.readString());
            return specialDiscountFeed;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SpecialDiscountFeed[i];
        }
    }

    public enum Type {
        SINGLE,
        DOUBLE
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount>, for r10v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed copy$default(kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed r6, long r7, kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed.Type r9, java.util.List<kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount> r10, java.lang.String r11, int r12, java.lang.Object r13) {
        /*
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0006
            long r7 = r6.eventId
        L_0x0006:
            r1 = r7
            r7 = r12 & 2
            if (r7 == 0) goto L_0x000d
            kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed$Type r9 = r6.type
        L_0x000d:
            r3 = r9
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0014
            java.util.List<kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount> r10 = r6.feeds
        L_0x0014:
            r4 = r10
            r7 = r12 & 8
            if (r7 == 0) goto L_0x001b
            java.lang.String r11 = r6.banner
        L_0x001b:
            r5 = r11
            r0 = r6
            kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed r6 = r0.copy(r1, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed.copy$default(kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed, long, kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed$Type, java.util.List, java.lang.String, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed");
    }

    public final long component1() {
        return this.eventId;
    }

    @Nullable
    public final Type component2() {
        return this.type;
    }

    @NotNull
    public final List<SpecialDiscount> component3() {
        return this.feeds;
    }

    @Nullable
    public final String component4() {
        return this.banner;
    }

    @NotNull
    public final SpecialDiscountFeed copy(long j, @Nullable Type type2, @NotNull List<SpecialDiscount> list, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(list, "feeds");
        SpecialDiscountFeed specialDiscountFeed = new SpecialDiscountFeed(j, type2, list, str);
        return specialDiscountFeed;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SpecialDiscountFeed) {
                SpecialDiscountFeed specialDiscountFeed = (SpecialDiscountFeed) obj;
                if (!(this.eventId == specialDiscountFeed.eventId) || !Intrinsics.areEqual((Object) this.type, (Object) specialDiscountFeed.type) || !Intrinsics.areEqual((Object) this.feeds, (Object) specialDiscountFeed.feeds) || !Intrinsics.areEqual((Object) this.banner, (Object) specialDiscountFeed.banner)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.eventId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Type type2 = this.type;
        int i2 = 0;
        int hashCode = (i + (type2 != null ? type2.hashCode() : 0)) * 31;
        List<SpecialDiscount> list = this.feeds;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.banner;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpecialDiscountFeed(eventId=");
        sb.append(this.eventId);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", feeds=");
        sb.append(this.feeds);
        sb.append(", banner=");
        sb.append(this.banner);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.eventId);
        Type type2 = this.type;
        if (type2 != null) {
            parcel.writeInt(1);
            parcel.writeString(type2.name());
        } else {
            parcel.writeInt(0);
        }
        List<SpecialDiscount> list = this.feeds;
        parcel.writeInt(list.size());
        for (SpecialDiscount writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.banner);
    }

    public SpecialDiscountFeed(long j, @Nullable Type type2, @NotNull List<SpecialDiscount> list, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(list, "feeds");
        this.eventId = j;
        this.type = type2;
        this.feeds = list;
        this.banner = str;
    }

    public final long getEventId() {
        return this.eventId;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public final List<SpecialDiscount> getFeeds() {
        return this.feeds;
    }

    public /* synthetic */ SpecialDiscountFeed(long j, Type type2, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            str = null;
        }
        this(j, type2, list, str);
    }

    @Nullable
    public final String getBanner() {
        return this.banner;
    }
}
