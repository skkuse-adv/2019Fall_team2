package kr.co.popone.fitts.feature.event;

import android.widget.EditText;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;

final class AppliableEventWinnerInputActivity$loadShippingInfo$1<T1, T2> implements BiConsumer<ShippingAddressResponse, Throwable> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$loadShippingInfo$1(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void accept(ShippingAddressResponse shippingAddressResponse, Throwable th) {
        this.this$0.shippingInfoRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("shippingInfoResponse ");
        sb.append(shippingAddressResponse);
        sb.append(' ');
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (shippingAddressResponse != null) {
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingPersonEditText)).setText(shippingAddressResponse.getName());
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingContactEditText)).setText(shippingAddressResponse.getContact());
            this.this$0.shippingZipCodeSubject.onNext(shippingAddressResponse.getZipCode());
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.address1EditText)).setText(shippingAddressResponse.getAddress());
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.address2EditText)).setText(shippingAddressResponse.getAddress2());
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoEditText)).setText(shippingAddressResponse.getMessage());
        }
    }
}
