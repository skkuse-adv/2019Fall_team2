package com.kakao.util.apicompatibility;

import android.annotation.TargetApi;
import android.content.Intent;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsMessage;
import com.kakao.util.helper.log.Logger;

@TargetApi(19)
class APILevel19Compatibility extends APILevel9Compatibility {
    APILevel19Compatibility() {
    }

    public String getSmsMessage(Intent intent) {
        SmsMessage[] messagesFromIntent = Intents.getMessagesFromIntent(intent);
        int length = messagesFromIntent.length;
        String str = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            SmsMessage smsMessage = messagesFromIntent[i];
            Logger.d("KitKat or newer");
            if (smsMessage == null) {
                Logger.e("SMS message is null -- ABORT");
                break;
            }
            str = smsMessage.getDisplayMessageBody();
            i++;
        }
        return str;
    }
}
