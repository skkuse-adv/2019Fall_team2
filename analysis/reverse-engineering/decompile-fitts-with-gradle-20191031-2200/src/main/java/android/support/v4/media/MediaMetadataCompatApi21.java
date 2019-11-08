package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Parcel;
import androidx.annotation.RequiresApi;
import java.util.Set;

@RequiresApi(21)
class MediaMetadataCompatApi21 {
    public static Set<String> keySet(Object obj) {
        return ((MediaMetadata) obj).keySet();
    }

    public static Bitmap getBitmap(Object obj, String str) {
        return ((MediaMetadata) obj).getBitmap(str);
    }

    public static long getLong(Object obj, String str) {
        return ((MediaMetadata) obj).getLong(str);
    }

    public static Object getRating(Object obj, String str) {
        return ((MediaMetadata) obj).getRating(str);
    }

    public static CharSequence getText(Object obj, String str) {
        return ((MediaMetadata) obj).getText(str);
    }

    public static void writeToParcel(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }

    public static Object createFromParcel(Parcel parcel) {
        return MediaMetadata.CREATOR.createFromParcel(parcel);
    }
}
