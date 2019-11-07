package bolts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;

public final class AppLinks {
    public static Bundle getAppLinkData(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle getAppLinkExtras(Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle(KakaoTalkLinkProtocol.EXTRAS);
    }

    public static Uri getTargetUrl(Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData != null) {
            String string = appLinkData.getString("target_url");
            if (string != null) {
                return Uri.parse(string);
            }
        }
        return intent.getData();
    }

    public static Uri getTargetUrlFromInboundIntent(Context context, Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData != null) {
            String string = appLinkData.getString("target_url");
            if (string != null) {
                MeasurementEvent.sendBroadcastEvent(context, MeasurementEvent.APP_LINK_NAVIGATE_IN_EVENT_NAME, intent, null);
                return Uri.parse(string);
            }
        }
        return null;
    }
}
