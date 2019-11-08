package com.kakao.usermgmt.response.model;

import androidx.annotation.NonNull;
import com.kakao.network.response.JSONObjectConverter;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.usermgmt.StringSet;
import com.kakao.util.OptionalBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class ShippingAddress {
    public static final JSONObjectConverter<ShippingAddress> CONVERTER = new JSONObjectConverter<ShippingAddress>() {
        public ShippingAddress convert(JSONObject jSONObject) {
            return new ShippingAddress(jSONObject);
        }
    };
    private final String baseAddress;
    private final String detailAddress;
    private final Long id;
    private final OptionalBoolean isDefault;
    private final String name;
    private final String receiverName;
    private final String receiverPhoneNumber1;
    private final String receiverPhoneNumber2;
    private final String type;
    private final Integer updatedAt;
    private final String zipCode;
    private final String zoneNumber;

    private ShippingAddress(@NonNull JSONObject jSONObject) {
        String str = StringSet.updated_at;
        String str2 = StringSet.is_default;
        String str3 = "id";
        try {
            this.id = jSONObject.has(str3) ? Long.valueOf(jSONObject.getLong(str3)) : null;
            this.isDefault = jSONObject.has(str2) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(jSONObject.getBoolean(str2))) : null;
            this.updatedAt = jSONObject.has(str) ? Integer.valueOf(jSONObject.getInt(str)) : null;
            this.name = jSONObject.optString("name", null);
            this.type = jSONObject.optString("type", null);
            this.baseAddress = jSONObject.optString(StringSet.base_address);
            this.detailAddress = jSONObject.optString(StringSet.detail_address);
            this.receiverName = jSONObject.optString(StringSet.receiver_name);
            this.receiverPhoneNumber1 = jSONObject.optString(StringSet.receiver_phone_number1);
            this.receiverPhoneNumber2 = jSONObject.optString(StringSet.receiver_phone_number2);
            this.zoneNumber = jSONObject.optString(StringSet.zone_number);
            this.zipCode = jSONObject.optString(StringSet.zip_code);
        } catch (JSONException e) {
            throw new ResponseBodyException((Exception) e);
        }
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public OptionalBoolean isDefault() {
        return this.isDefault;
    }

    public Integer getUpdatedAt() {
        return this.updatedAt;
    }

    public String getType() {
        return this.type;
    }

    public String getBaseAddress() {
        return this.baseAddress;
    }

    public String getDetailAddress() {
        return this.detailAddress;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public String getReceiverPhoneNumber1() {
        return this.receiverPhoneNumber1;
    }

    public String getReceiverPhoneNumber2() {
        return this.receiverPhoneNumber2;
    }

    public String getZoneNumber() {
        return this.zoneNumber;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String toString() {
        Object obj;
        try {
            JSONObject put = new JSONObject().put("id", this.id).put("name", this.name);
            String str = StringSet.is_default;
            if (this.isDefault == null) {
                obj = null;
            } else {
                obj = this.isDefault.getBoolean();
            }
            return put.put(str, obj).put(StringSet.updated_at, this.updatedAt).put("type", this.type).put(StringSet.base_address, this.baseAddress).put(StringSet.detail_address, this.detailAddress).put(StringSet.receiver_name, this.receiverName).put(StringSet.receiver_phone_number1, this.receiverPhoneNumber1).put(StringSet.receiver_phone_number2, this.receiverPhoneNumber2).put(StringSet.zone_number, this.zoneNumber).put(StringSet.zip_code, this.zipCode).toString();
        } catch (JSONException unused) {
            return null;
        }
    }
}
