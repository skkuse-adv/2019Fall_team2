package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
    private static final int MARK_POSITION = 5242880;

    private ImageHeaderParserUtils() {
    }

    /* JADX INFO: finally extract failed */
    @NonNull
    public static ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_POSITION);
        int i = 0;
        int size = list.size();
        while (i < size) {
            try {
                ImageType type = ((ImageHeaderParser) list.get(i)).getType(inputStream);
                if (type != ImageType.UNKNOWN) {
                    inputStream.reset();
                    return type;
                }
                inputStream.reset();
                i++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageType type = ((ImageHeaderParser) list.get(i)).getType(byteBuffer);
            if (type != ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageType.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_POSITION);
        int i = 0;
        int size = list.size();
        while (i < size) {
            try {
                int orientation = ((ImageHeaderParser) list.get(i)).getOrientation(inputStream, arrayPool);
                if (orientation != -1) {
                    inputStream.reset();
                    return orientation;
                }
                inputStream.reset();
                i++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return -1;
    }
}
