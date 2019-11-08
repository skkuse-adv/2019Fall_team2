package com.kakao.usermgmt.response;

import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.usermgmt.StringSet;
import com.kakao.usermgmt.response.model.ShippingAddress;
import com.kakao.util.OptionalBoolean;
import java.util.List;

public class ShippingAddressResponse extends JSONObjectResponse {
    public static final ResponseStringConverter<ShippingAddressResponse> CONVERTER = new ResponseStringConverter<ShippingAddressResponse>() {
        public ShippingAddressResponse convert(String str) throws ResponseBodyException {
            return new ShippingAddressResponse(str);
        }
    };
    private final OptionalBoolean hasShippingAddresses;
    private final List<ShippingAddress> shippingAddresses;
    private final OptionalBoolean shippingAddressesNeedsAgreement;
    private final Long userId;

    private ShippingAddressResponse(String str) {
        super(str);
        String str2 = "user_id";
        List<ShippingAddress> list = null;
        this.userId = getBody().has(str2) ? Long.valueOf(getBody().getLong(str2)) : null;
        ResponseBody body = getBody();
        String str3 = StringSet.has_shipping_addresses;
        this.hasShippingAddresses = body.has(str3) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(getBody().getBoolean(str3))) : null;
        ResponseBody body2 = getBody();
        String str4 = StringSet.shipping_addresses_needs_agreement;
        this.shippingAddressesNeedsAgreement = body2.has(str4) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(getBody().getBoolean(str4))) : null;
        ResponseBody body3 = getBody();
        String str5 = StringSet.shipping_addresses;
        if (body3.has(str5)) {
            list = ShippingAddress.CONVERTER.convertList(getBody().getJSONArray(str5));
        }
        this.shippingAddresses = list;
    }

    public Long getUserId() {
        return this.userId;
    }

    public OptionalBoolean hasShippingAddresses() {
        return this.hasShippingAddresses;
    }

    public List<ShippingAddress> getShippingAddresses() {
        return this.shippingAddresses;
    }

    public OptionalBoolean shippingAddressesNeedsAgreement() {
        return this.shippingAddressesNeedsAgreement;
    }
}
