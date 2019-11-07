package com.kakao.util.apicompatibility;

import android.annotation.TargetApi;
import android.content.Intent;
import android.telephony.gsm.SmsMessage;
import com.kakao.util.helper.log.Logger;

@TargetApi(9)
class APILevel9Compatibility extends APICompatibility {
    APILevel9Compatibility() {
    }

    public String getSmsMessage(Intent intent) {
        Object[] objArr = (Object[]) intent.getExtras().get("pdus");
        int length = objArr.length;
        String str = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Object obj = objArr[i];
            Logger.d("legacy SMS implementation (before KitKat)");
            SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) obj);
            if (createFromPdu == null) {
                Logger.e("SMS message is null -- ABORT");
                break;
            }
            str = createFromPdu.getDisplayMessageBody();
            i++;
        }
        return str;
    }
}
