package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CropTransformation extends BitmapTransformation {
    private static final byte[] ID_BYTES = "jp.wasabeef.glide.transformations.CropTransformation.1".getBytes(Key.CHARSET);
    private CropType cropType;
    private int height;
    private int width;

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType = new int[CropType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                jp.wasabeef.glide.transformations.CropTransformation$CropType[] r0 = jp.wasabeef.glide.transformations.CropTransformation.CropType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType = r0
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType     // Catch:{ NoSuchFieldError -> 0x0014 }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.TOP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType     // Catch:{ NoSuchFieldError -> 0x001f }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.CENTER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType     // Catch:{ NoSuchFieldError -> 0x002a }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.CropTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int i, int i2) {
        this(i, i2, CropType.CENTER);
    }

    public CropTransformation(int i, int i2, CropType cropType2) {
        this.cropType = CropType.CENTER;
        this.width = i;
        this.height = i2;
        this.cropType = cropType2;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int i3 = this.width;
        if (i3 == 0) {
            i3 = bitmap.getWidth();
        }
        this.width = i3;
        int i4 = this.height;
        if (i4 == 0) {
            i4 = bitmap.getHeight();
        }
        this.height = i4;
        Bitmap bitmap2 = bitmapPool.get(this.width, this.height, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        float max = Math.max(((float) this.width) / ((float) bitmap.getWidth()), ((float) this.height) / ((float) bitmap.getHeight()));
        float width2 = ((float) bitmap.getWidth()) * max;
        float height2 = max * ((float) bitmap.getHeight());
        float f = (((float) this.width) - width2) / 2.0f;
        float top = getTop(height2);
        new Canvas(bitmap2).drawBitmap(bitmap, null, new RectF(f, top, width2 + f, height2 + top), null);
        return bitmap2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CropTransformation(width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", cropType=");
        sb.append(this.cropType);
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return obj instanceof CropTransformation;
    }

    public int hashCode() {
        return "jp.wasabeef.glide.transformations.CropTransformation.1".hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }

    private float getTop(float f) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[this.cropType.ordinal()];
        if (i == 1) {
            return 0.0f;
        }
        if (i == 2) {
            return (((float) this.height) - f) / 2.0f;
        }
        if (i != 3) {
            return 0.0f;
        }
        return ((float) this.height) - f;
    }
}
