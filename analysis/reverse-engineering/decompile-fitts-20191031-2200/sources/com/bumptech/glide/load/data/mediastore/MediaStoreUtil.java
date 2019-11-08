package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.MessageTemplateProtocol;

public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= MINI_THUMB_HEIGHT;
    }

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri != null) {
            if (MessageTemplateProtocol.CONTENT.equals(uri.getScheme())) {
                if (MessengerShareContentUtility.TEMPLATE_MEDIA_TYPE.equals(uri.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains(MessengerShareContentUtility.MEDIA_VIDEO);
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }
}
