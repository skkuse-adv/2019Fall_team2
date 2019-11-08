package kr.co.popone.fitts.model.datamodel.commerce;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PaymentInvoiceResult implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String RESULT_KEY = "result";
    private final boolean completedInvoice;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new PaymentInvoiceResult(parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PaymentInvoiceResult[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.completedInvoice ? 1 : 0);
    }

    public PaymentInvoiceResult(boolean z) {
        this.completedInvoice = z;
    }

    public final boolean getCompletedInvoice() {
        return this.completedInvoice;
    }
}
