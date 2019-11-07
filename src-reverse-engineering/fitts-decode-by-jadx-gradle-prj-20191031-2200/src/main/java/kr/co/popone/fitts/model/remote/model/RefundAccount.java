package kr.co.popone.fitts.model.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundAccount implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("bank_account_holder")
    @NotNull
    private final String accountHolder;
    @SerializedName("bank_account_number")
    @NotNull
    private final String accountNumber;
    @SerializedName("bank_name")
    @NotNull
    private final String bankName;
    @SerializedName("user_id")
    private final long userId;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            RefundAccount refundAccount = new RefundAccount(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
            return refundAccount;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new RefundAccount[i];
        }
    }

    @NotNull
    public static /* synthetic */ RefundAccount copy$default(RefundAccount refundAccount, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = refundAccount.userId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = refundAccount.accountHolder;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = refundAccount.accountNumber;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = refundAccount.bankName;
        }
        return refundAccount.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.userId;
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
        return this.bankName;
    }

    @NotNull
    public final RefundAccount copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str2, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str3, "bankName");
        RefundAccount refundAccount = new RefundAccount(j, str, str2, str3);
        return refundAccount;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RefundAccount) {
                RefundAccount refundAccount = (RefundAccount) obj;
                if (!(this.userId == refundAccount.userId) || !Intrinsics.areEqual((Object) this.accountHolder, (Object) refundAccount.accountHolder) || !Intrinsics.areEqual((Object) this.accountNumber, (Object) refundAccount.accountNumber) || !Intrinsics.areEqual((Object) this.bankName, (Object) refundAccount.bankName)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.accountHolder;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accountNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankName;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RefundAccount(userId=");
        sb.append(this.userId);
        sb.append(", accountHolder=");
        sb.append(this.accountHolder);
        sb.append(", accountNumber=");
        sb.append(this.accountNumber);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.userId);
        parcel.writeString(this.accountHolder);
        parcel.writeString(this.accountNumber);
        parcel.writeString(this.bankName);
    }

    public RefundAccount(long j, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str2, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str3, "bankName");
        this.userId = j;
        this.accountHolder = str;
        this.accountNumber = str2;
        this.bankName = str3;
    }

    public final long getUserId() {
        return this.userId;
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
    public final String getBankName() {
        return this.bankName;
    }
}
