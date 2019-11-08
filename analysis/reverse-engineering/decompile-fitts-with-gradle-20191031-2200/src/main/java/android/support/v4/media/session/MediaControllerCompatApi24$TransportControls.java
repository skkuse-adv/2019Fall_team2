package android.support.v4.media.session;

import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;

public class MediaControllerCompatApi24$TransportControls {
    public static void prepare(Object obj) {
        ((TransportControls) obj).prepare();
    }

    public static void prepareFromMediaId(Object obj, String str, Bundle bundle) {
        ((TransportControls) obj).prepareFromMediaId(str, bundle);
    }

    public static void prepareFromSearch(Object obj, String str, Bundle bundle) {
        ((TransportControls) obj).prepareFromSearch(str, bundle);
    }

    public static void prepareFromUri(Object obj, Uri uri, Bundle bundle) {
        ((TransportControls) obj).prepareFromUri(uri, bundle);
    }
}
