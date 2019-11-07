package com.kakao.usermgmt.request;

import android.net.Uri.Builder;
import com.kakao.auth.network.AuthorizedApiRequest;
import com.kakao.network.ServerProtocol;
import com.kakao.usermgmt.StringSet;
import io.fabric.sdk.android.services.network.HttpRequest;

public class ShippingAddressesRequest extends AuthorizedApiRequest {
    private final Long addressId;
    private final Integer fromUpdatedAt;
    private final Integer pageSize;

    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    public ShippingAddressesRequest(Long l, Integer num, Integer num2) {
        this.addressId = l;
        this.fromUpdatedAt = num;
        this.pageSize = num2;
    }

    public Builder getUriBuilder() {
        Builder path = super.getUriBuilder().path(ServerProtocol.USER_SHIPPING_ADDRESS_PATH);
        Long l = this.addressId;
        if (l != null) {
            path.appendQueryParameter(StringSet.address_id, l.toString());
        }
        Integer num = this.fromUpdatedAt;
        if (num != null) {
            path.appendQueryParameter(StringSet.from_updated_at, num.toString());
        }
        Integer num2 = this.pageSize;
        if (num2 != null) {
            path.appendQueryParameter(StringSet.page_size, num2.toString());
        }
        return path;
    }
}
