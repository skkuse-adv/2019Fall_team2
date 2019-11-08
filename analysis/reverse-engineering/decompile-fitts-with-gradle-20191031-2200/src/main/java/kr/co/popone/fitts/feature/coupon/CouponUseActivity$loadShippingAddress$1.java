package kr.co.popone.fitts.feature.coupon;

import android.widget.EditText;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;

final class CouponUseActivity$loadShippingAddress$1<T1, T2> implements BiConsumer<ShippingAddressResponse, Throwable> {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$loadShippingAddress$1(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void accept(ShippingAddressResponse shippingAddressResponse, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("shippingAddressRequest  response(");
        sb.append(shippingAddressResponse);
        sb.append(") error(");
        sb.append(th);
        sb.append(')');
        String sb2 = sb.toString();
        boolean z = false;
        Logger.d(sb2, new Object[0]);
        this.this$0.shippingAddressRequest = null;
        if (shippingAddressResponse != null) {
            String name = shippingAddressResponse.getName();
            if (!(name == null || StringsKt__StringsJVMKt.isBlank(name))) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingPersonEditText)).setText(shippingAddressResponse.getName());
            }
            String zipCode = shippingAddressResponse.getZipCode();
            if (!(zipCode == null || StringsKt__StringsJVMKt.isBlank(zipCode))) {
                this.this$0.shippingZipCodeSubject.onNext(shippingAddressResponse.getZipCode());
            }
            String address = shippingAddressResponse.getAddress();
            if (!(address == null || StringsKt__StringsJVMKt.isBlank(address))) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.address1EditText)).setText(shippingAddressResponse.getAddress());
            }
            String contact = shippingAddressResponse.getContact();
            if (!(contact == null || StringsKt__StringsJVMKt.isBlank(contact))) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingContactEditText)).setText(shippingAddressResponse.getContact());
            }
            String address2 = shippingAddressResponse.getAddress2();
            if (address2 == null || StringsKt__StringsJVMKt.isBlank(address2)) {
                z = true;
            }
            if (!z) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.address2EditText)).setText(shippingAddressResponse.getAddress2());
            }
        }
    }
}
