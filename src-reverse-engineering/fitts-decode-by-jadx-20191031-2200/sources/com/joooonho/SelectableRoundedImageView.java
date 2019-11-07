package com.joooonho;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.view.ViewCompat;

public class SelectableRoundedImageView extends ImageView {
    public static final String TAG = "SelectableRoundedImageView";
    private static final ScaleType[] sScaleTypeArray = {ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    private boolean isOval;
    private ColorStateList mBorderColor;
    private float mBorderWidth;
    private Drawable mDrawable;
    private float mLeftBottomCornerRadius;
    private float mLeftTopCornerRadius;
    private float[] mRadii;
    private int mResource;
    private float mRightBottomCornerRadius;
    private float mRightTopCornerRadius;
    private ScaleType mScaleType;

    static class SelectableRoundedCornerDrawable extends Drawable {
        private Bitmap mBitmap;
        private final int mBitmapHeight;
        private final Paint mBitmapPaint;
        private final RectF mBitmapRect = new RectF();
        private BitmapShader mBitmapShader;
        private final int mBitmapWidth;
        private RectF mBorderBounds = new RectF();
        private ColorStateList mBorderColor = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        private final Paint mBorderPaint;
        private float[] mBorderRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        private float mBorderWidth = 0.0f;
        private RectF mBounds = new RectF();
        private boolean mBoundsConfigured = false;
        private boolean mOval = false;
        private Path mPath = new Path();
        private float[] mRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        private ScaleType mScaleType = ScaleType.FIT_CENTER;

        public SelectableRoundedCornerDrawable(Bitmap bitmap, Resources resources) {
            this.mBitmap = bitmap;
            TileMode tileMode = TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            if (bitmap != null) {
                this.mBitmapWidth = bitmap.getScaledWidth(resources.getDisplayMetrics());
                this.mBitmapHeight = bitmap.getScaledHeight(resources.getDisplayMetrics());
            } else {
                this.mBitmapHeight = -1;
                this.mBitmapWidth = -1;
            }
            this.mBitmapRect.set(0.0f, 0.0f, (float) this.mBitmapWidth, (float) this.mBitmapHeight);
            this.mBitmapPaint = new Paint(1);
            this.mBitmapPaint.setStyle(Style.FILL);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint = new Paint(1);
            this.mBorderPaint.setStyle(Style.STROKE);
            this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        }

        public static SelectableRoundedCornerDrawable fromBitmap(Bitmap bitmap, Resources resources) {
            if (bitmap != null) {
                return new SelectableRoundedCornerDrawable(bitmap, resources);
            }
            return null;
        }

        public static Drawable fromDrawable(Drawable drawable, Resources resources) {
            if (drawable != null) {
                if (drawable instanceof SelectableRoundedCornerDrawable) {
                    return drawable;
                }
                if (drawable instanceof LayerDrawable) {
                    LayerDrawable layerDrawable = (LayerDrawable) drawable;
                    int numberOfLayers = layerDrawable.getNumberOfLayers();
                    for (int i = 0; i < numberOfLayers; i++) {
                        layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), fromDrawable(layerDrawable.getDrawable(i), resources));
                    }
                    return layerDrawable;
                }
                Bitmap drawableToBitmap = drawableToBitmap(drawable);
                if (drawableToBitmap != null) {
                    drawable = new SelectableRoundedCornerDrawable(drawableToBitmap, resources);
                }
            }
            return drawable;
        }

        public static Bitmap drawableToBitmap(Drawable drawable) {
            Bitmap bitmap = null;
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                bitmap = createBitmap;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        public boolean isStateful() {
            return this.mBorderColor.isStateful();
        }

        /* access modifiers changed from: protected */
        public boolean onStateChange(int[] iArr) {
            int colorForState = this.mBorderColor.getColorForState(iArr, 0);
            if (this.mBorderPaint.getColor() == colorForState) {
                return super.onStateChange(iArr);
            }
            this.mBorderPaint.setColor(colorForState);
            return true;
        }

        private void configureBounds(Canvas canvas) {
            Rect clipBounds = canvas.getClipBounds();
            Matrix matrix = canvas.getMatrix();
            ScaleType scaleType = ScaleType.CENTER;
            ScaleType scaleType2 = this.mScaleType;
            if (scaleType == scaleType2) {
                this.mBounds.set(clipBounds);
            } else if (ScaleType.CENTER_CROP == scaleType2) {
                applyScaleToRadii(matrix);
                this.mBounds.set(clipBounds);
            } else if (ScaleType.FIT_XY == scaleType2) {
                Matrix matrix2 = new Matrix();
                matrix2.setRectToRect(this.mBitmapRect, new RectF(clipBounds), ScaleToFit.FILL);
                this.mBitmapShader.setLocalMatrix(matrix2);
                this.mBounds.set(clipBounds);
            } else if (ScaleType.FIT_START == scaleType2 || ScaleType.FIT_END == scaleType2 || ScaleType.FIT_CENTER == scaleType2 || ScaleType.CENTER_INSIDE == scaleType2) {
                applyScaleToRadii(matrix);
                this.mBounds.set(this.mBitmapRect);
            } else if (ScaleType.MATRIX == scaleType2) {
                applyScaleToRadii(matrix);
                this.mBounds.set(this.mBitmapRect);
            }
        }

        private void applyScaleToRadii(Matrix matrix) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            int i = 0;
            while (true) {
                float[] fArr2 = this.mRadii;
                if (i < fArr2.length) {
                    fArr2[i] = fArr2[i] / fArr[0];
                    i++;
                } else {
                    return;
                }
            }
        }

        private void adjustCanvasForBorder(Canvas canvas) {
            float[] fArr = new float[9];
            canvas.getMatrix().getValues(fArr);
            float f = fArr[0];
            float f2 = fArr[4];
            float f3 = fArr[2];
            float f4 = fArr[5];
            float width = this.mBounds.width();
            float width2 = this.mBounds.width();
            float f5 = this.mBorderWidth;
            float f6 = width / ((width2 + f5) + f5);
            float height = this.mBounds.height();
            float height2 = this.mBounds.height();
            float f7 = this.mBorderWidth;
            float f8 = height / ((height2 + f7) + f7);
            canvas.scale(f6, f8);
            ScaleType scaleType = ScaleType.FIT_START;
            ScaleType scaleType2 = this.mScaleType;
            if (scaleType == scaleType2 || ScaleType.FIT_END == scaleType2 || ScaleType.FIT_XY == scaleType2 || ScaleType.FIT_CENTER == scaleType2 || ScaleType.CENTER_INSIDE == scaleType2 || ScaleType.MATRIX == scaleType2) {
                float f9 = this.mBorderWidth;
                canvas.translate(f9, f9);
            } else if (ScaleType.CENTER == scaleType2 || ScaleType.CENTER_CROP == scaleType2) {
                canvas.translate((-f3) / (f6 * f), (-f4) / (f8 * f2));
                RectF rectF = this.mBounds;
                float f10 = rectF.left;
                float f11 = this.mBorderWidth;
                canvas.translate(-(f10 - f11), -(rectF.top - f11));
            }
        }

        private void adjustBorderWidthAndBorderBounds(Canvas canvas) {
            float[] fArr = new float[9];
            canvas.getMatrix().getValues(fArr);
            this.mBorderWidth = (this.mBorderWidth * this.mBounds.width()) / ((this.mBounds.width() * fArr[0]) - (this.mBorderWidth * 2.0f));
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderBounds.set(this.mBounds);
            RectF rectF = this.mBorderBounds;
            float f = this.mBorderWidth;
            rectF.inset((-f) / 2.0f, (-f) / 2.0f);
        }

        private void setBorderRadii() {
            int i = 0;
            while (true) {
                float[] fArr = this.mRadii;
                if (i < fArr.length) {
                    if (fArr[i] > 0.0f) {
                        this.mBorderRadii[i] = fArr[i];
                        fArr[i] = fArr[i] - this.mBorderWidth;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        public void draw(Canvas canvas) {
            canvas.save();
            if (!this.mBoundsConfigured) {
                configureBounds(canvas);
                if (this.mBorderWidth > 0.0f) {
                    adjustBorderWidthAndBorderBounds(canvas);
                    setBorderRadii();
                }
                this.mBoundsConfigured = true;
            }
            if (this.mOval) {
                if (this.mBorderWidth > 0.0f) {
                    adjustCanvasForBorder(canvas);
                    this.mPath.addOval(this.mBounds, Direction.CW);
                    canvas.drawPath(this.mPath, this.mBitmapPaint);
                    this.mPath.reset();
                    this.mPath.addOval(this.mBorderBounds, Direction.CW);
                    canvas.drawPath(this.mPath, this.mBorderPaint);
                } else {
                    this.mPath.addOval(this.mBounds, Direction.CW);
                    canvas.drawPath(this.mPath, this.mBitmapPaint);
                }
            } else if (this.mBorderWidth > 0.0f) {
                adjustCanvasForBorder(canvas);
                this.mPath.addRoundRect(this.mBounds, this.mRadii, Direction.CW);
                canvas.drawPath(this.mPath, this.mBitmapPaint);
                this.mPath.reset();
                this.mPath.addRoundRect(this.mBorderBounds, this.mBorderRadii, Direction.CW);
                canvas.drawPath(this.mPath, this.mBorderPaint);
            } else {
                this.mPath.addRoundRect(this.mBounds, this.mRadii, Direction.CW);
                canvas.drawPath(this.mPath, this.mBitmapPaint);
            }
            canvas.restore();
        }

        public void setCornerRadii(float[] fArr) {
            if (fArr != null) {
                if (fArr.length == 8) {
                    for (int i = 0; i < fArr.length; i++) {
                        this.mRadii[i] = fArr[i];
                    }
                    return;
                }
                throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
            }
        }

        public int getOpacity() {
            Bitmap bitmap = this.mBitmap;
            return (bitmap == null || bitmap.hasAlpha() || this.mBitmapPaint.getAlpha() < 255) ? -3 : -1;
        }

        public void setAlpha(int i) {
            this.mBitmapPaint.setAlpha(i);
            invalidateSelf();
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mBitmapPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setDither(boolean z) {
            this.mBitmapPaint.setDither(z);
            invalidateSelf();
        }

        public void setFilterBitmap(boolean z) {
            this.mBitmapPaint.setFilterBitmap(z);
            invalidateSelf();
        }

        public int getIntrinsicWidth() {
            return this.mBitmapWidth;
        }

        public int getIntrinsicHeight() {
            return this.mBitmapHeight;
        }

        public float getBorderWidth() {
            return this.mBorderWidth;
        }

        public void setBorderWidth(float f) {
            this.mBorderWidth = f;
            this.mBorderPaint.setStrokeWidth(f);
        }

        public int getBorderColor() {
            return this.mBorderColor.getDefaultColor();
        }

        public void setBorderColor(int i) {
            setBorderColor(ColorStateList.valueOf(i));
        }

        public ColorStateList getBorderColors() {
            return this.mBorderColor;
        }

        public void setBorderColor(ColorStateList colorStateList) {
            if (colorStateList == null) {
                this.mBorderWidth = 0.0f;
                this.mBorderColor = ColorStateList.valueOf(0);
                this.mBorderPaint.setColor(0);
                return;
            }
            this.mBorderColor = colorStateList;
            this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        }

        public boolean isOval() {
            return this.mOval;
        }

        public void setOval(boolean z) {
            this.mOval = z;
        }

        public ScaleType getScaleType() {
            return this.mScaleType;
        }

        public void setScaleType(ScaleType scaleType) {
            if (scaleType != null) {
                this.mScaleType = scaleType;
            }
        }
    }

    public SelectableRoundedImageView(Context context) {
        super(context);
        this.mResource = 0;
        this.mScaleType = ScaleType.FIT_CENTER;
        this.mLeftTopCornerRadius = 0.0f;
        this.mRightTopCornerRadius = 0.0f;
        this.mLeftBottomCornerRadius = 0.0f;
        this.mRightBottomCornerRadius = 0.0f;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.isOval = false;
        this.mRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SelectableRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectableRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mResource = 0;
        this.mScaleType = ScaleType.FIT_CENTER;
        this.mLeftTopCornerRadius = 0.0f;
        this.mRightTopCornerRadius = 0.0f;
        this.mLeftBottomCornerRadius = 0.0f;
        this.mRightBottomCornerRadius = 0.0f;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.isOval = false;
        this.mRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SelectableRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R$styleable.SelectableRoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(sScaleTypeArray[i2]);
        }
        this.mLeftTopCornerRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SelectableRoundedImageView_sriv_left_top_corner_radius, 0);
        this.mRightTopCornerRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SelectableRoundedImageView_sriv_right_top_corner_radius, 0);
        this.mLeftBottomCornerRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SelectableRoundedImageView_sriv_left_bottom_corner_radius, 0);
        this.mRightBottomCornerRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SelectableRoundedImageView_sriv_right_bottom_corner_radius, 0);
        float f = this.mLeftTopCornerRadius;
        if (f >= 0.0f) {
            float f2 = this.mRightTopCornerRadius;
            if (f2 >= 0.0f) {
                float f3 = this.mLeftBottomCornerRadius;
                if (f3 >= 0.0f) {
                    float f4 = this.mRightBottomCornerRadius;
                    if (f4 >= 0.0f) {
                        this.mRadii = new float[]{f, f, f2, f2, f4, f4, f3, f3};
                        this.mBorderWidth = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SelectableRoundedImageView_sriv_border_width, 0);
                        if (this.mBorderWidth >= 0.0f) {
                            this.mBorderColor = obtainStyledAttributes.getColorStateList(R$styleable.SelectableRoundedImageView_sriv_border_color);
                            if (this.mBorderColor == null) {
                                this.mBorderColor = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
                            }
                            this.isOval = obtainStyledAttributes.getBoolean(R$styleable.SelectableRoundedImageView_sriv_oval, false);
                            obtainStyledAttributes.recycle();
                            updateDrawable();
                            return;
                        }
                        throw new IllegalArgumentException("border width cannot be negative.");
                    }
                }
            }
        }
        throw new IllegalArgumentException("radius values cannot be negative.");
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.mScaleType = scaleType;
        updateDrawable();
    }

    public void setImageDrawable(Drawable drawable) {
        this.mResource = 0;
        this.mDrawable = SelectableRoundedCornerDrawable.fromDrawable(drawable, getResources());
        super.setImageDrawable(this.mDrawable);
        updateDrawable();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mResource = 0;
        this.mDrawable = SelectableRoundedCornerDrawable.fromBitmap(bitmap, getResources());
        super.setImageDrawable(this.mDrawable);
        updateDrawable();
    }

    public void setImageResource(int i) {
        if (this.mResource != i) {
            this.mResource = i;
            this.mDrawable = resolveResource();
            super.setImageDrawable(this.mDrawable);
            updateDrawable();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable resolveResource() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.mResource;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (NotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to find resource: ");
                sb.append(this.mResource);
                sb.toString();
                this.mResource = 0;
            }
        }
        return SelectableRoundedCornerDrawable.fromDrawable(drawable, getResources());
    }

    private void updateDrawable() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            ((SelectableRoundedCornerDrawable) drawable).setScaleType(this.mScaleType);
            ((SelectableRoundedCornerDrawable) this.mDrawable).setCornerRadii(this.mRadii);
            ((SelectableRoundedCornerDrawable) this.mDrawable).setBorderWidth(this.mBorderWidth);
            ((SelectableRoundedCornerDrawable) this.mDrawable).setBorderColor(this.mBorderColor);
            ((SelectableRoundedCornerDrawable) this.mDrawable).setOval(this.isOval);
        }
    }

    public float getCornerRadius() {
        return this.mLeftTopCornerRadius;
    }

    public void setCornerRadiiDP(float f, float f2, float f3, float f4) {
        float f5 = getResources().getDisplayMetrics().density;
        float f6 = f * f5;
        float f7 = f2 * f5;
        float f8 = f3 * f5;
        float f9 = f4 * f5;
        this.mRadii = new float[]{f6, f6, f7, f7, f9, f9, f8, f8};
        updateDrawable();
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidthDP(float f) {
        float f2 = getResources().getDisplayMetrics().density * f;
        if (this.mBorderWidth != f2) {
            this.mBorderWidth = f2;
            updateDrawable();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.mBorderColor.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mBorderColor = colorStateList;
            updateDrawable();
            if (this.mBorderWidth > 0.0f) {
                invalidate();
            }
        }
    }

    public boolean isOval() {
        return this.isOval;
    }

    public void setOval(boolean z) {
        this.isOval = z;
        updateDrawable();
        invalidate();
    }
}
