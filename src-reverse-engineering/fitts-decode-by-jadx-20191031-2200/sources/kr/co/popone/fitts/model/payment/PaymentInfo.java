package kr.co.popone.fitts.model.payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PaymentInfo implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("account_holder")
    @NotNull
    private final String accountHolder;
    @SerializedName("account_number")
    @NotNull
    private final String accountNumber;
    @SerializedName("bank_name")
    @NotNull
    private final String bankName;
    @SerializedName("due_date")
    @NotNull
    private final Date dueDate;
    @SerializedName("remittor_name")
    @NotNull
    private final String remittorName;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            PaymentInfo paymentInfo = new PaymentInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable());
            return paymentInfo;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PaymentInfo[i];
        }
    }

    @NotNull
    public static /* synthetic */ PaymentInfo copy$default(PaymentInfo paymentInfo, String str, String str2, String str3, String str4, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentInfo.bankName;
        }
        if ((i & 2) != 0) {
            str2 = paymentInfo.accountHolder;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = paymentInfo.accountNumber;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = paymentInfo.remittorName;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            date = paymentInfo.dueDate;
        }
        return paymentInfo.copy(str, str5, str6, str7, date);
    }

    @NotNull
    public final String component1() {
        return this.bankName;
    }

    @NotNull
    public final String component2() {
        return this.accountHolder;
    }

    @NotNull
    public final String component3() {
        return this.accountNumber;
    }

    @NotNull
    public final String component4() {
        return this.remittorName;
    }

    @NotNull
    public final Date component5() {
        return this.dueDate;
    }

    @NotNull
    public final PaymentInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Date date) {
        Intrinsics.checkParameterIsNotNull(str, "bankName");
        Intrinsics.checkParameterIsNotNull(str2, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str3, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str4, "remittorName");
        Intrinsics.checkParameterIsNotNull(date, "dueDate");
        PaymentInfo paymentInfo = new PaymentInfo(str, str2, str3, str4, date);
        return paymentInfo;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.dueDate, (java.lang.Object) r3.dueDate) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.payment.PaymentInfo
            if (r0 == 0) goto L_0x003b
            kr.co.popone.fitts.model.payment.PaymentInfo r3 = (kr.co.popone.fitts.model.payment.PaymentInfo) r3
            java.lang.String r0 = r2.bankName
            java.lang.String r1 = r3.bankName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.accountHolder
            java.lang.String r1 = r3.accountHolder
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.accountNumber
            java.lang.String r1 = r3.accountNumber
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.remittorName
            java.lang.String r1 = r3.remittorName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.util.Date r0 = r2.dueDate
            java.util.Date r3 = r3.dueDate
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            return r3
        L_0x003d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.payment.PaymentInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.bankName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accountHolder;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.remittorName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Date date = this.dueDate;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentInfo(bankName=");
        sb.append(this.bankName);
        sb.append(", accountHolder=");
        sb.append(this.accountHolder);
        sb.append(", accountNumber=");
        sb.append(this.accountNumber);
        sb.append(", remittorName=");
        sb.append(this.remittorName);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.bankName);
        parcel.writeString(this.accountHolder);
        parcel.writeString(this.accountNumber);
        parcel.writeString(this.remittorName);
        parcel.writeSerializable(this.dueDate);
    }

    public PaymentInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Date date) {
        Intrinsics.checkParameterIsNotNull(str, "bankName");
        Intrinsics.checkParameterIsNotNull(str2, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str3, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str4, "remittorName");
        Intrinsics.checkParameterIsNotNull(date, "dueDate");
        this.bankName = str;
        this.accountHolder = str2;
        this.accountNumber = str3;
        this.remittorName = str4;
        this.dueDate = date;
    }

    @NotNull
    public final String getBankName() {
        return this.bankName;
    }

    @NotNull
    public final String getAccountHolder() {
        return this.accountHolder;
    }

    @NotNull
    public final String getAccountNumber() {
        return this.accountNumber;
    }

    @NotNull
    public final String getRemittorName() {
        return this.remittorName;
    }

    @NotNull
    public final Date getDueDate() {
        return this.dueDate;
    }
}
