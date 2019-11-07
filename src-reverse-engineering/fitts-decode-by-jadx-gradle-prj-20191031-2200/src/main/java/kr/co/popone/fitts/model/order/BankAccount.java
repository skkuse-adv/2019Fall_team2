package kr.co.popone.fitts.model.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BankAccount implements Parcelable {
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
    private final long id;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            BankAccount bankAccount = new BankAccount(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
            return bankAccount;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new BankAccount[i];
        }
    }

    @NotNull
    public static /* synthetic */ BankAccount copy$default(BankAccount bankAccount, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = bankAccount.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = bankAccount.bankName;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = bankAccount.accountHolder;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = bankAccount.accountNumber;
        }
        return bankAccount.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.bankName;
    }

    @NotNull
    public final String component3() {
        return this.accountHolder;
    }

    @NotNull
    public final String component4() {
        return this.accountNumber;
    }

    @NotNull
    public final BankAccount copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "bankName");
        Intrinsics.checkParameterIsNotNull(str2, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str3, "accountNumber");
        BankAccount bankAccount = new BankAccount(j, str, str2, str3);
        return bankAccount;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BankAccount) {
                BankAccount bankAccount = (BankAccount) obj;
                if (!(this.id == bankAccount.id) || !Intrinsics.areEqual((Object) this.bankName, (Object) bankAccount.bankName) || !Intrinsics.areEqual((Object) this.accountHolder, (Object) bankAccount.accountHolder) || !Intrinsics.areEqual((Object) this.accountNumber, (Object) bankAccount.accountNumber)) {
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
        String str = this.bankName;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accountHolder;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountNumber;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankAccount(id=");
        sb.append(this.id);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", accountHolder=");
        sb.append(this.accountHolder);
        sb.append(", accountNumber=");
        sb.append(this.accountNumber);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.bankName);
        parcel.writeString(this.accountHolder);
        parcel.writeString(this.accountNumber);
    }

    public BankAccount(long j, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "bankName");
        Intrinsics.checkParameterIsNotNull(str2, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str3, "accountNumber");
        this.id = j;
        this.bankName = str;
        this.accountHolder = str2;
        this.accountNumber = str3;
    }

    public final long getId() {
        return this.id;
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
}
