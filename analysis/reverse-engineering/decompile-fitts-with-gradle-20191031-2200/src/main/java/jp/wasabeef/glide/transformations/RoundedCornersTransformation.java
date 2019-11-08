package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class RoundedCornersTransformation extends BitmapTransformation {
    private static final byte[] ID_BYTES = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1".getBytes(Key.CHARSET);
    private CornerType cornerType;
    private int diameter;
    private int margin;
    private int radius;

    /* renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType = new int[CornerType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType[] r0 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType = r0
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0014 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.ALL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x001f }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x002a }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0035 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0040 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x004b }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.TOP     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0056 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0062 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.LEFT     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x006e }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.RIGHT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x007a }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.OTHER_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0086 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.OTHER_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0092 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x009e }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x00aa }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x00b6 }
                jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r1 = jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.RoundedCornersTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int i, int i2) {
        this(i, i2, CornerType.ALL);
    }

    public RoundedCornersTransformation(int i, int i2, CornerType cornerType2) {
        this.radius = i;
        this.diameter = this.radius * 2;
        this.margin = i2;
        this.cornerType = cornerType2;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, (float) width, (float) height);
        return bitmap2;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        float f3 = f - ((float) i);
        float f4 = f2 - ((float) i);
        switch (AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[this.cornerType.ordinal()]) {
            case 1:
                int i2 = this.margin;
                RectF rectF = new RectF((float) i2, (float) i2, f3, f4);
                int i3 = this.radius;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                return;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 3:
                drawTopRightRoundRect(canvas, paint, f3, f4);
                return;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f3, f4);
                return;
            case 6:
                drawTopRoundRect(canvas, paint, f3, f4);
                return;
            case 7:
                drawBottomRoundRect(canvas, paint, f3, f4);
                return;
            case 8:
                drawLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 9:
                drawRightRoundRect(canvas, paint, f3, f4);
                return;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f3, f4);
                return;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f3, f4);
                return;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f3, f4);
                return;
            default:
                int i4 = this.margin;
                RectF rectF2 = new RectF((float) i4, (float) i4, f3, f4);
                int i5 = this.radius;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                return;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        float f3 = (float) i;
        float f4 = (float) i;
        int i2 = this.diameter;
        RectF rectF = new RectF(f3, f4, (float) (i + i2), (float) (i + i2));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        float f5 = (float) i4;
        int i5 = this.radius;
        canvas.drawRect(new RectF(f5, (float) (i4 + i5), (float) (i4 + i5), f2), paint);
        int i6 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i6), (float) i6, f, f2), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        float f3 = f - ((float) i);
        int i2 = this.margin;
        RectF rectF = new RectF(f3, (float) i2, f, (float) (i2 + i));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF((float) i4, (float) i4, f - ((float) this.radius), f2), paint);
        int i5 = this.radius;
        canvas.drawRect(new RectF(f - ((float) i5), (float) (this.margin + i5), f, f2), paint);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        float f3 = (float) i;
        int i2 = this.diameter;
        RectF rectF = new RectF(f3, f2 - ((float) i2), (float) (i + i2), f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.diameter), f2 - ((float) this.radius)), paint);
        int i5 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i5), (float) i5, f, f2), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        RectF rectF = new RectF(f - ((float) i), f2 - ((float) i), f, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) i3, (float) i3, f - ((float) this.radius), f2), paint);
        int i4 = this.radius;
        canvas.drawRect(new RectF(f - ((float) i4), (float) this.margin, f, f2 - ((float) i4)), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.radius), f, f2), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.margin, f2 - ((float) this.diameter), f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF((float) i2, (float) i2, f, f2 - ((float) this.radius)), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.diameter), f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i3), (float) i3, f, f2), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - ((float) this.diameter), (float) this.margin, f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF((float) i2, (float) i2, f - ((float) this.radius), f2), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.margin, f2 - ((float) this.diameter), f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        RectF rectF2 = new RectF(f - ((float) this.diameter), (float) this.margin, f, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        float f3 = (float) i3;
        float f4 = (float) i3;
        int i4 = this.radius;
        canvas.drawRect(new RectF(f3, f4, f - ((float) i4), f2 - ((float) i4)), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.diameter), f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF((float) this.margin, f2 - ((float) this.diameter), f, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, f, f2 - ((float) i5)), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF(f - ((float) this.diameter), (float) this.margin, f, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        float f3 = (float) i4;
        int i5 = this.radius;
        canvas.drawRect(new RectF(f3, (float) (i4 + i5), f - ((float) i5), f2), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.diameter));
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.margin;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.diameter), f2);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), f, f2), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        float f3 = (float) i;
        float f4 = (float) i;
        int i2 = this.diameter;
        RectF rectF = new RectF(f3, f4, (float) (i + i2), (float) (i + i2));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.diameter;
        RectF rectF2 = new RectF(f - ((float) i4), f2 - ((float) i4), f, f2);
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.margin;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.radius), f - ((float) this.diameter), f2), paint);
        int i7 = this.margin;
        canvas.drawRect(new RectF((float) (this.diameter + i7), (float) i7, f, f2 - ((float) this.radius)), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        float f3 = f - ((float) i);
        int i2 = this.margin;
        RectF rectF = new RectF(f3, (float) i2, f, (float) (i2 + i));
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.margin;
        float f4 = (float) i4;
        int i5 = this.diameter;
        RectF rectF2 = new RectF(f4, f2 - ((float) i5), (float) (i4 + i5), f2);
        int i6 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.margin;
        float f5 = (float) i7;
        float f6 = (float) i7;
        int i8 = this.radius;
        canvas.drawRect(new RectF(f5, f6, f - ((float) i8), f2 - ((float) i8)), paint);
        int i9 = this.margin;
        int i10 = this.radius;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), f, f2), paint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RoundedTransformation(radius=");
        sb.append(this.radius);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", diameter=");
        sb.append(this.diameter);
        sb.append(", cornerType=");
        sb.append(this.cornerType.name());
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return obj instanceof RoundedCornersTransformation;
    }

    public int hashCode() {
        return "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1".hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
