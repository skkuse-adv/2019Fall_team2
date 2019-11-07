package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

public class CircleImageView extends ImageView {
    private static final Config BITMAP_CONFIG = Config.ARGB_8888;
    private static final ScaleType SCALE_TYPE = ScaleType.CENTER_CROP;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    /* access modifiers changed from: private */
    public final RectF mBorderRect;
    private int mBorderWidth;
    private int mCircleBackgroundColor;
    private final Paint mCircleBackgroundPaint;
    private ColorFilter mColorFilter;
    private boolean mDisableCircularTransformation;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;

    @RequiresApi(api = 21)
    private class OutlineProvider extends ViewOutlineProvider {
        private OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.mBorderRect.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        init();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = ViewCompat.MEASURED_STATE_MASK;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleImageView, i, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleImageView_civ_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R$styleable.CircleImageView_civ_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(R$styleable.CircleImageView_civ_border_overlay, false);
        if (obtainStyledAttributes.hasValue(R$styleable.CircleImageView_civ_circle_background_color)) {
            this.mCircleBackgroundColor = obtainStyledAttributes.getColor(R$styleable.CircleImageView_civ_circle_background_color, 0);
        } else if (obtainStyledAttributes.hasValue(R$styleable.CircleImageView_civ_fill_color)) {
            this.mCircleBackgroundColor = obtainStyledAttributes.getColor(R$styleable.CircleImageView_civ_fill_color, 0);
        }
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    public ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDisableCircularTransformation) {
            super.onDraw(canvas);
        } else if (this.mBitmap != null) {
            if (this.mCircleBackgroundColor != 0) {
                canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mCircleBackgroundPaint);
            }
            canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
            if (this.mBorderWidth > 0) {
                canvas.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        setup();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        setup();
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(@ColorInt int i) {
        if (i != this.mBorderColor) {
            this.mBorderColor = i;
            this.mBorderPaint.setColor(this.mBorderColor);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(@ColorRes int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public int getCircleBackgroundColor() {
        return this.mCircleBackgroundColor;
    }

    public void setCircleBackgroundColor(@ColorInt int i) {
        if (i != this.mCircleBackgroundColor) {
            this.mCircleBackgroundColor = i;
            this.mCircleBackgroundPaint.setColor(i);
            invalidate();
        }
    }

    public void setCircleBackgroundColorResource(@ColorRes int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public int getFillColor() {
        return getCircleBackgroundColor();
    }

    @Deprecated
    public void setFillColor(@ColorInt int i) {
        setCircleBackgroundColor(i);
    }

    @Deprecated
    public void setFillColorResource(@ColorRes int i) {
        setCircleBackgroundColorResource(i);
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        if (i != this.mBorderWidth) {
            this.mBorderWidth = i;
            setup();
        }
    }

    public boolean isBorderOverlay() {
        return this.mBorderOverlay;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.mBorderOverlay) {
            this.mBorderOverlay = z;
            setup();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.mDisableCircularTransformation;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.mDisableCircularTransformation != z) {
            this.mDisableCircularTransformation = z;
            initializeBitmap();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initializeBitmap();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    public void setImageResource(@DrawableRes int i) {
        super.setImageResource(i);
        initializeBitmap();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initializeBitmap();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mColorFilter) {
            this.mColorFilter = colorFilter;
            applyColorFilter();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    private void applyColorFilter() {
        Paint paint = this.mBitmapPaint;
        if (paint != null) {
            paint.setColorFilter(this.mColorFilter);
        }
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initializeBitmap() {
        if (this.mDisableCircularTransformation) {
            this.mBitmap = null;
        } else {
            this.mBitmap = getBitmapFromDrawable(getDrawable());
        }
        setup();
    }

    private void setup() {
        if (!this.mReady) {
            this.mSetupPending = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null) {
                invalidate();
                return;
            }
            TileMode tileMode = TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint.setStyle(Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
            this.mCircleBackgroundPaint.setStyle(Style.FILL);
            this.mCircleBackgroundPaint.setAntiAlias(true);
            this.mCircleBackgroundPaint.setColor(this.mCircleBackgroundColor);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBorderRect.set(calculateBounds());
            this.mBorderRadius = Math.min((this.mBorderRect.height() - ((float) this.mBorderWidth)) / 2.0f, (this.mBorderRect.width() - ((float) this.mBorderWidth)) / 2.0f);
            this.mDrawableRect.set(this.mBorderRect);
            if (!this.mBorderOverlay) {
                int i = this.mBorderWidth;
                if (i > 0) {
                    this.mDrawableRect.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
                }
            }
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
            applyColorFilter();
            updateShaderMatrix();
            invalidate();
        }
    }

    private RectF calculateBounds() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    private void updateShaderMatrix() {
        float f;
        float f2;
        this.mShaderMatrix.set(null);
        float f3 = 0.0f;
        if (((float) this.mBitmapWidth) * this.mDrawableRect.height() > this.mDrawableRect.width() * ((float) this.mBitmapHeight)) {
            f2 = this.mDrawableRect.height() / ((float) this.mBitmapHeight);
            f = (this.mDrawableRect.width() - (((float) this.mBitmapWidth) * f2)) * 0.5f;
        } else {
            f2 = this.mDrawableRect.width() / ((float) this.mBitmapWidth);
            f3 = (this.mDrawableRect.height() - (((float) this.mBitmapHeight) * f2)) * 0.5f;
            f = 0.0f;
        }
        this.mShaderMatrix.setScale(f2, f2);
        Matrix matrix = this.mShaderMatrix;
        float f4 = (float) ((int) (f + 0.5f));
        RectF rectF = this.mDrawableRect;
        matrix.postTranslate(f4 + rectF.left, ((float) ((int) (f3 + 0.5f))) + rectF.top);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }
}
