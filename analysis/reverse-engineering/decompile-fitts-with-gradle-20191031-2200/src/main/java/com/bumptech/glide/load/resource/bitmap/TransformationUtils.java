package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {
    private static final Lock BITMAP_DRAWABLE_LOCK = (MODELS_REQUIRING_BITMAP_LOCK.contains(Build.MODEL) ? new ReentrantLock() : new NoLock());
    private static final Paint CIRCLE_CROP_BITMAP_PAINT = new Paint(7);
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
    private static final Paint DEFAULT_PAINT = new Paint(6);
    private static final Set<String> MODELS_REQUIRING_BITMAP_LOCK = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    private static final class NoLock implements Lock {
        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }

        NoLock() {
        }

        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public static int getExifOrientationDegrees(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static boolean isExifOrientationRequired(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    static {
        CIRCLE_CROP_BITMAP_PAINT.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    public static Lock getBitmapDrawableLock() {
        return BITMAP_DRAWABLE_LOCK;
    }

    public static Bitmap centerCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            f2 = ((float) i2) / ((float) bitmap.getHeight());
            f = (((float) i) - (((float) bitmap.getWidth()) * f2)) * 0.5f;
        } else {
            f2 = ((float) i) / ((float) bitmap.getWidth());
            f3 = (((float) i2) - (((float) bitmap.getHeight()) * f2)) * 0.5f;
            f = 0.0f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float) ((int) (f + 0.5f)), (float) ((int) (f3 + 0.5f)));
        Bitmap bitmap2 = bitmapPool.get(i, i2, getNonNullConfig(bitmap));
        setAlpha(bitmap, bitmap2);
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap fitCenter(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        String str = TAG;
        if (width == i && bitmap.getHeight() == i2) {
            boolean isLoggable = Log.isLoggable(str, 2);
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            boolean isLoggable2 = Log.isLoggable(str, 2);
            return bitmap;
        }
        Bitmap bitmap2 = bitmapPool.get((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), getNonNullConfig(bitmap));
        setAlpha(bitmap, bitmap2);
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            sb.append(i);
            String str2 = "x";
            sb.append(str2);
            sb.append(i2);
            sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append(str2);
            sb2.append(bitmap.getHeight());
            sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(bitmap2.getWidth());
            sb3.append(str2);
            sb3.append(bitmap2.getHeight());
            sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
            sb4.toString();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap centerInside(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        String str = TAG;
        if (width > i || bitmap.getHeight() > i2) {
            boolean isLoggable = Log.isLoggable(str, 2);
            return fitCenter(bitmapPool, bitmap, i, i2);
        }
        boolean isLoggable2 = Log.isLoggable(str, 2);
        return bitmap;
    }

    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap rotateImage(@NonNull Bitmap bitmap, int i) {
        if (i == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception unused) {
            boolean isLoggable = Log.isLoggable(TAG, 6);
            return bitmap;
        }
    }

    public static Bitmap rotateImageExif(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        if (!isExifOrientationRequired(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        initializeMatrixForRotation(i, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmap2 = bitmapPool.get(Math.round(rectF.width()), Math.round(rectF.height()), getNonNullConfig(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap circleCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f = (float) min;
        float f2 = f / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
        Bitmap bitmap2 = bitmapPool.get(min, min, getAlphaSafeConfig(bitmap));
        bitmap2.setHasAlpha(true);
        BITMAP_DRAWABLE_LOCK.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawCircle(f2, f2, f2, CIRCLE_CROP_SHAPE_PAINT);
            canvas.drawBitmap(alphaSafeBitmap, null, rectF, CIRCLE_CROP_BITMAP_PAINT);
            clear(canvas);
            BITMAP_DRAWABLE_LOCK.unlock();
            if (!alphaSafeBitmap.equals(bitmap)) {
                bitmapPool.put(alphaSafeBitmap);
            }
            return bitmap2;
        } catch (Throwable th) {
            BITMAP_DRAWABLE_LOCK.unlock();
            throw th;
        }
    }

    private static Bitmap getAlphaSafeBitmap(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
        if (alphaSafeConfig.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), alphaSafeConfig);
        new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, null);
        return bitmap2;
    }

    @NonNull
    private static Config getAlphaSafeConfig(@NonNull Bitmap bitmap) {
        if (VERSION.SDK_INT < 26 || !Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Config.ARGB_8888;
        }
        return Config.RGBA_F16;
    }

    @Deprecated
    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2, int i3) {
        return roundedCorners(bitmapPool, bitmap, i3);
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        Preconditions.checkArgument(i > 0, "roundingRadius must be greater than 0.");
        Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
        Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
        Bitmap bitmap2 = bitmapPool.get(alphaSafeBitmap.getWidth(), alphaSafeBitmap.getHeight(), alphaSafeConfig);
        bitmap2.setHasAlpha(true);
        TileMode tileMode = TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(alphaSafeBitmap, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight());
        BITMAP_DRAWABLE_LOCK.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawColor(0, Mode.CLEAR);
            float f = (float) i;
            canvas.drawRoundRect(rectF, f, f, paint);
            clear(canvas);
            BITMAP_DRAWABLE_LOCK.unlock();
            if (!alphaSafeBitmap.equals(bitmap)) {
                bitmapPool.put(alphaSafeBitmap);
            }
            return bitmap2;
        } catch (Throwable th) {
            BITMAP_DRAWABLE_LOCK.unlock();
            throw th;
        }
    }

    private static void clear(Canvas canvas) {
        canvas.setBitmap(null);
    }

    @NonNull
    private static Config getNonNullConfig(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    private static void applyMatrix(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        BITMAP_DRAWABLE_LOCK.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, DEFAULT_PAINT);
            clear(canvas);
        } finally {
            BITMAP_DRAWABLE_LOCK.unlock();
        }
    }

    @VisibleForTesting
    static void initializeMatrixForRotation(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }
}
