package android.support.v4.media.session;

import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;

public class MediaControllerCompatApi23$TransportControls {
    public static void playFromUri(Object obj, Uri uri, Bundle bundle) {
        ((TransportControls) obj).playFromUri(uri, bundle);
    }
}
