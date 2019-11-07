package com.theartofdev.edmodo.cropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import com.theartofdev.edmodo.cropper.CropImageView.CropShape;
import com.theartofdev.edmodo.cropper.CropImageView.Guidelines;
import java.util.Arrays;

public class CropOverlayView extends View {
    private boolean initializedCropWindow;
    private int mAspectRatioX;
    private int mAspectRatioY;
    private Paint mBackgroundPaint;
    private float mBorderCornerLength;
    private float mBorderCornerOffset;
    private Paint mBorderCornerPaint;
    private Paint mBorderPaint;
    private final float[] mBoundsPoints;
    private final RectF mCalcBounds;
    private CropShape mCropShape;
    private CropWindowChangeListener mCropWindowChangeListener;
    /* access modifiers changed from: private */
    public final CropWindowHandler mCropWindowHandler;
    private final RectF mDrawRect;
    private boolean mFixAspectRatio;
    private Paint mGuidelinePaint;
    private Guidelines mGuidelines;
    private float mInitialCropWindowPaddingRatio;
    private final Rect mInitialCropWindowRect;
    private CropWindowMoveHandler mMoveHandler;
    private boolean mMultiTouchEnabled;
    private Integer mOriginalLayerType;
    private Path mPath;
    private ScaleGestureDetector mScaleDetector;
    private float mSnapRadius;
    private float mTargetAspectRatio;
    private float mTouchRadius;
    private int mViewHeight;
    private int mViewWidth;

    public interface CropWindowChangeListener {
        void onCropWindowChanged(boolean z);
    }

    private class ScaleListener extends SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF rect = CropOverlayView.this.mCropWindowHandler.getRect();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f = focusY - currentSpanY;
            float f2 = focusX - currentSpanX;
            float f3 = focusX + currentSpanX;
            float f4 = focusY + currentSpanY;
            if (f2 < f3 && f <= f4 && f2 >= 0.0f && f3 <= CropOverlayView.this.mCropWindowHandler.getMaxCropWidth() && f >= 0.0f && f4 <= CropOverlayView.this.mCropWindowHandler.getMaxCropHeight()) {
                rect.set(f2, f, f3, f4);
                CropOverlayView.this.mCropWindowHandler.setRect(rect);
                CropOverlayView.this.invalidate();
            }
            return true;
        }
    }

    public CropOverlayView(Context context) {
        this(context, null);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCropWindowHandler = new CropWindowHandler();
        this.mDrawRect = new RectF();
        this.mPath = new Path();
        this.mBoundsPoints = new float[8];
        this.mCalcBounds = new RectF();
        this.mTargetAspectRatio = ((float) this.mAspectRatioX) / ((float) this.mAspectRatioY);
        this.mInitialCropWindowRect = new Rect();
    }

    public void setCropWindowChangeListener(CropWindowChangeListener cropWindowChangeListener) {
        this.mCropWindowChangeListener = cropWindowChangeListener;
    }

    public RectF getCropWindowRect() {
        return this.mCropWindowHandler.getRect();
    }

    public void setCropWindowRect(RectF rectF) {
        this.mCropWindowHandler.setRect(rectF);
    }

    public void fixCurrentCropWindowRect() {
        RectF cropWindowRect = getCropWindowRect();
        fixCropWindowRectByRules(cropWindowRect);
        this.mCropWindowHandler.setRect(cropWindowRect);
    }

    public void setBounds(float[] fArr, int i, int i2) {
        if (fArr == null || !Arrays.equals(this.mBoundsPoints, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.mBoundsPoints, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.mBoundsPoints, 0, fArr.length);
            }
            this.mViewWidth = i;
            this.mViewHeight = i2;
            RectF rect = this.mCropWindowHandler.getRect();
            if (rect.width() == 0.0f || rect.height() == 0.0f) {
                initCropWindow();
            }
        }
    }

    public void resetCropOverlayView() {
        if (this.initializedCropWindow) {
            setCropWindowRect(BitmapUtils.EMPTY_RECT_F);
            initCropWindow();
            invalidate();
        }
    }

    public CropShape getCropShape() {
        return this.mCropShape;
    }

    public void setCropShape(CropShape cropShape) {
        if (this.mCropShape != cropShape) {
            this.mCropShape = cropShape;
            if (VERSION.SDK_INT <= 17) {
                if (this.mCropShape == CropShape.OVAL) {
                    this.mOriginalLayerType = Integer.valueOf(getLayerType());
                    if (this.mOriginalLayerType.intValue() != 1) {
                        setLayerType(1, null);
                    } else {
                        this.mOriginalLayerType = null;
                    }
                } else {
                    Integer num = this.mOriginalLayerType;
                    if (num != null) {
                        setLayerType(num.intValue(), null);
                        this.mOriginalLayerType = null;
                    }
                }
            }
            invalidate();
        }
    }

    public Guidelines getGuidelines() {
        return this.mGuidelines;
    }

    public void setGuidelines(Guidelines guidelines) {
        if (this.mGuidelines != guidelines) {
            this.mGuidelines = guidelines;
            if (this.initializedCropWindow) {
                invalidate();
            }
        }
    }

    public boolean isFixAspectRatio() {
        return this.mFixAspectRatio;
    }

    public void setFixedAspectRatio(boolean z) {
        if (this.mFixAspectRatio != z) {
            this.mFixAspectRatio = z;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public int getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.mAspectRatioX != i) {
            this.mAspectRatioX = i;
            this.mTargetAspectRatio = ((float) this.mAspectRatioX) / ((float) this.mAspectRatioY);
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public int getAspectRatioY() {
        return this.mAspectRatioY;
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.mAspectRatioY != i) {
            this.mAspectRatioY = i;
            this.mTargetAspectRatio = ((float) this.mAspectRatioX) / ((float) this.mAspectRatioY);
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public void setSnapRadius(float f) {
        this.mSnapRadius = f;
    }

    public boolean setMultiTouchEnabled(boolean z) {
        if (this.mMultiTouchEnabled == z) {
            return false;
        }
        this.mMultiTouchEnabled = z;
        if (this.mMultiTouchEnabled && this.mScaleDetector == null) {
            this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        }
        return true;
    }

    public void setMinCropResultSize(int i, int i2) {
        this.mCropWindowHandler.setMinCropResultSize(i, i2);
    }

    public void setMaxCropResultSize(int i, int i2) {
        this.mCropWindowHandler.setMaxCropResultSize(i, i2);
    }

    public void setCropWindowLimits(float f, float f2, float f3, float f4) {
        this.mCropWindowHandler.setCropWindowLimits(f, f2, f3, f4);
    }

    public Rect getInitialCropWindowRect() {
        return this.mInitialCropWindowRect;
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.mInitialCropWindowRect;
        if (rect == null) {
            rect = BitmapUtils.EMPTY_RECT;
        }
        rect2.set(rect);
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            callOnCropWindowChanged(false);
        }
    }

    public void resetCropWindowRect() {
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            callOnCropWindowChanged(false);
        }
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        this.mCropWindowHandler.setInitialAttributeValues(cropImageOptions);
        setCropShape(cropImageOptions.cropShape);
        setSnapRadius(cropImageOptions.snapRadius);
        setGuidelines(cropImageOptions.guidelines);
        setFixedAspectRatio(cropImageOptions.fixAspectRatio);
        setAspectRatioX(cropImageOptions.aspectRatioX);
        setAspectRatioY(cropImageOptions.aspectRatioY);
        setMultiTouchEnabled(cropImageOptions.multiTouchEnabled);
        this.mTouchRadius = cropImageOptions.touchRadius;
        this.mInitialCropWindowPaddingRatio = cropImageOptions.initialCropWindowPaddingRatio;
        this.mBorderPaint = getNewPaintOrNull(cropImageOptions.borderLineThickness, cropImageOptions.borderLineColor);
        this.mBorderCornerOffset = cropImageOptions.borderCornerOffset;
        this.mBorderCornerLength = cropImageOptions.borderCornerLength;
        this.mBorderCornerPaint = getNewPaintOrNull(cropImageOptions.borderCornerThickness, cropImageOptions.borderCornerColor);
        this.mGuidelinePaint = getNewPaintOrNull(cropImageOptions.guidelinesThickness, cropImageOptions.guidelinesColor);
        this.mBackgroundPaint = getNewPaint(cropImageOptions.backgroundColor);
    }

    private void initCropWindow() {
        float max = Math.max(BitmapUtils.getRectLeft(this.mBoundsPoints), 0.0f);
        float max2 = Math.max(BitmapUtils.getRectTop(this.mBoundsPoints), 0.0f);
        float min = Math.min(BitmapUtils.getRectRight(this.mBoundsPoints), (float) getWidth());
        float min2 = Math.min(BitmapUtils.getRectBottom(this.mBoundsPoints), (float) getHeight());
        if (min > max && min2 > max2) {
            RectF rectF = new RectF();
            this.initializedCropWindow = true;
            float f = this.mInitialCropWindowPaddingRatio;
            float f2 = min - max;
            float f3 = f * f2;
            float f4 = min2 - max2;
            float f5 = f * f4;
            if (this.mInitialCropWindowRect.width() > 0 && this.mInitialCropWindowRect.height() > 0) {
                rectF.left = (((float) this.mInitialCropWindowRect.left) / this.mCropWindowHandler.getScaleFactorWidth()) + max;
                rectF.top = (((float) this.mInitialCropWindowRect.top) / this.mCropWindowHandler.getScaleFactorHeight()) + max2;
                rectF.right = rectF.left + (((float) this.mInitialCropWindowRect.width()) / this.mCropWindowHandler.getScaleFactorWidth());
                rectF.bottom = rectF.top + (((float) this.mInitialCropWindowRect.height()) / this.mCropWindowHandler.getScaleFactorHeight());
                rectF.left = Math.max(max, rectF.left);
                rectF.top = Math.max(max2, rectF.top);
                rectF.right = Math.min(min, rectF.right);
                rectF.bottom = Math.min(min2, rectF.bottom);
            } else if (!this.mFixAspectRatio || min <= max || min2 <= max2) {
                rectF.left = max + f3;
                rectF.top = max2 + f5;
                rectF.right = min - f3;
                rectF.bottom = min2 - f5;
            } else if (f2 / f4 > this.mTargetAspectRatio) {
                rectF.top = max2 + f5;
                rectF.bottom = min2 - f5;
                float width = ((float) getWidth()) / 2.0f;
                this.mTargetAspectRatio = ((float) this.mAspectRatioX) / ((float) this.mAspectRatioY);
                float max3 = Math.max(this.mCropWindowHandler.getMinCropWidth(), rectF.height() * this.mTargetAspectRatio) / 2.0f;
                rectF.left = width - max3;
                rectF.right = width + max3;
            } else {
                rectF.left = max + f3;
                rectF.right = min - f3;
                float height = ((float) getHeight()) / 2.0f;
                float max4 = Math.max(this.mCropWindowHandler.getMinCropHeight(), rectF.width() / this.mTargetAspectRatio) / 2.0f;
                rectF.top = height - max4;
                rectF.bottom = height + max4;
            }
            fixCropWindowRectByRules(rectF);
            this.mCropWindowHandler.setRect(rectF);
        }
    }

    private void fixCropWindowRectByRules(RectF rectF) {
        if (rectF.width() < this.mCropWindowHandler.getMinCropWidth()) {
            float minCropWidth = (this.mCropWindowHandler.getMinCropWidth() - rectF.width()) / 2.0f;
            rectF.left -= minCropWidth;
            rectF.right += minCropWidth;
        }
        if (rectF.height() < this.mCropWindowHandler.getMinCropHeight()) {
            float minCropHeight = (this.mCropWindowHandler.getMinCropHeight() - rectF.height()) / 2.0f;
            rectF.top -= minCropHeight;
            rectF.bottom += minCropHeight;
        }
        if (rectF.width() > this.mCropWindowHandler.getMaxCropWidth()) {
            float width = (rectF.width() - this.mCropWindowHandler.getMaxCropWidth()) / 2.0f;
            rectF.left += width;
            rectF.right -= width;
        }
        if (rectF.height() > this.mCropWindowHandler.getMaxCropHeight()) {
            float height = (rectF.height() - this.mCropWindowHandler.getMaxCropHeight()) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
        }
        calculateBounds(rectF);
        if (this.mCalcBounds.width() > 0.0f && this.mCalcBounds.height() > 0.0f) {
            float max = Math.max(this.mCalcBounds.left, 0.0f);
            float max2 = Math.max(this.mCalcBounds.top, 0.0f);
            float min = Math.min(this.mCalcBounds.right, (float) getWidth());
            float min2 = Math.min(this.mCalcBounds.bottom, (float) getHeight());
            if (rectF.left < max) {
                rectF.left = max;
            }
            if (rectF.top < max2) {
                rectF.top = max2;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.mFixAspectRatio && ((double) Math.abs(rectF.width() - (rectF.height() * this.mTargetAspectRatio))) > 0.1d) {
            if (rectF.width() > rectF.height() * this.mTargetAspectRatio) {
                float abs = Math.abs((rectF.height() * this.mTargetAspectRatio) - rectF.width()) / 2.0f;
                rectF.left += abs;
                rectF.right -= abs;
                return;
            }
            float abs2 = Math.abs((rectF.width() / this.mTargetAspectRatio) - rectF.height()) / 2.0f;
            rectF.top += abs2;
            rectF.bottom -= abs2;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        if (this.mCropWindowHandler.showGuidelines()) {
            Guidelines guidelines = this.mGuidelines;
            if (guidelines == Guidelines.ON) {
                drawGuidelines(canvas);
            } else if (guidelines == Guidelines.ON_TOUCH && this.mMoveHandler != null) {
                drawGuidelines(canvas);
            }
        }
        drawBorders(canvas);
        drawCorners(canvas);
    }

    private void drawBackground(Canvas canvas) {
        RectF rect = this.mCropWindowHandler.getRect();
        float max = Math.max(BitmapUtils.getRectLeft(this.mBoundsPoints), 0.0f);
        float max2 = Math.max(BitmapUtils.getRectTop(this.mBoundsPoints), 0.0f);
        float min = Math.min(BitmapUtils.getRectRight(this.mBoundsPoints), (float) getWidth());
        float min2 = Math.min(BitmapUtils.getRectBottom(this.mBoundsPoints), (float) getHeight());
        if (this.mCropShape != CropShape.RECTANGLE) {
            this.mPath.reset();
            if (VERSION.SDK_INT > 17 || this.mCropShape != CropShape.OVAL) {
                this.mDrawRect.set(rect.left, rect.top, rect.right, rect.bottom);
            } else {
                this.mDrawRect.set(rect.left + 2.0f, rect.top + 2.0f, rect.right - 2.0f, rect.bottom - 2.0f);
            }
            this.mPath.addOval(this.mDrawRect, Direction.CW);
            canvas.save();
            canvas.clipPath(this.mPath, Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.mBackgroundPaint);
            canvas.restore();
        } else if (!isNonStraightAngleRotated() || VERSION.SDK_INT <= 17) {
            Canvas canvas2 = canvas;
            float f = max;
            float f2 = min;
            canvas2.drawRect(f, max2, f2, rect.top, this.mBackgroundPaint);
            canvas2.drawRect(f, rect.bottom, f2, min2, this.mBackgroundPaint);
            canvas2.drawRect(f, rect.top, rect.left, rect.bottom, this.mBackgroundPaint);
            canvas.drawRect(rect.right, rect.top, min, rect.bottom, this.mBackgroundPaint);
        } else {
            this.mPath.reset();
            Path path = this.mPath;
            float[] fArr = this.mBoundsPoints;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.mPath;
            float[] fArr2 = this.mBoundsPoints;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.mPath;
            float[] fArr3 = this.mBoundsPoints;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.mPath;
            float[] fArr4 = this.mBoundsPoints;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.mPath.close();
            canvas.save();
            canvas.clipPath(this.mPath, Op.INTERSECT);
            canvas.clipRect(rect, Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.mBackgroundPaint);
            canvas.restore();
        }
    }

    private void drawGuidelines(Canvas canvas) {
        if (this.mGuidelinePaint != null) {
            Paint paint = this.mBorderPaint;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF rect = this.mCropWindowHandler.getRect();
            rect.inset(strokeWidth, strokeWidth);
            float width = rect.width() / 3.0f;
            float height = rect.height() / 3.0f;
            if (this.mCropShape == CropShape.OVAL) {
                float width2 = (rect.width() / 2.0f) - strokeWidth;
                float height2 = (rect.height() / 2.0f) - strokeWidth;
                float f = rect.left + width;
                float f2 = rect.right - width;
                double d = (double) height2;
                double sin = Math.sin(Math.acos((double) ((width2 - width) / width2)));
                Double.isNaN(d);
                float f3 = (float) (d * sin);
                canvas.drawLine(f, (rect.top + height2) - f3, f, (rect.bottom - height2) + f3, this.mGuidelinePaint);
                canvas.drawLine(f2, (rect.top + height2) - f3, f2, (rect.bottom - height2) + f3, this.mGuidelinePaint);
                float f4 = rect.top + height;
                float f5 = rect.bottom - height;
                double d2 = (double) width2;
                double cos = Math.cos(Math.asin((double) ((height2 - height) / height2)));
                Double.isNaN(d2);
                float f6 = (float) (d2 * cos);
                canvas.drawLine((rect.left + width2) - f6, f4, (rect.right - width2) + f6, f4, this.mGuidelinePaint);
                canvas.drawLine((rect.left + width2) - f6, f5, (rect.right - width2) + f6, f5, this.mGuidelinePaint);
                return;
            }
            float f7 = rect.left + width;
            float f8 = rect.right - width;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f7, rect.top, f7, rect.bottom, this.mGuidelinePaint);
            canvas.drawLine(f8, rect.top, f8, rect.bottom, this.mGuidelinePaint);
            float f9 = rect.top + height;
            float f10 = rect.bottom - height;
            canvas2.drawLine(rect.left, f9, rect.right, f9, this.mGuidelinePaint);
            canvas.drawLine(rect.left, f10, rect.right, f10, this.mGuidelinePaint);
        }
    }

    private void drawBorders(Canvas canvas) {
        Paint paint = this.mBorderPaint;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF rect = this.mCropWindowHandler.getRect();
            float f = strokeWidth / 2.0f;
            rect.inset(f, f);
            if (this.mCropShape == CropShape.RECTANGLE) {
                canvas.drawRect(rect, this.mBorderPaint);
            } else {
                canvas.drawOval(rect, this.mBorderPaint);
            }
        }
    }

    private void drawCorners(Canvas canvas) {
        if (this.mBorderCornerPaint != null) {
            Paint paint = this.mBorderPaint;
            float f = 0.0f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.mBorderCornerPaint.getStrokeWidth();
            float f2 = strokeWidth2 / 2.0f;
            if (this.mCropShape == CropShape.RECTANGLE) {
                f = this.mBorderCornerOffset;
            }
            float f3 = f + f2;
            RectF rect = this.mCropWindowHandler.getRect();
            rect.inset(f3, f3);
            float f4 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f5 = f2 + f4;
            float f6 = rect.left;
            float f7 = f6 - f4;
            float f8 = rect.top;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f7, f8 - f5, f6 - f4, f8 + this.mBorderCornerLength, this.mBorderCornerPaint);
            float f9 = rect.left;
            float f10 = f9 - f5;
            float f11 = rect.top;
            canvas2.drawLine(f10, f11 - f4, f9 + this.mBorderCornerLength, f11 - f4, this.mBorderCornerPaint);
            float f12 = rect.right;
            float f13 = f12 + f4;
            float f14 = rect.top;
            canvas2.drawLine(f13, f14 - f5, f12 + f4, f14 + this.mBorderCornerLength, this.mBorderCornerPaint);
            float f15 = rect.right;
            float f16 = f15 + f5;
            float f17 = rect.top;
            canvas2.drawLine(f16, f17 - f4, f15 - this.mBorderCornerLength, f17 - f4, this.mBorderCornerPaint);
            float f18 = rect.left;
            float f19 = f18 - f4;
            float f20 = rect.bottom;
            canvas2.drawLine(f19, f20 + f5, f18 - f4, f20 - this.mBorderCornerLength, this.mBorderCornerPaint);
            float f21 = rect.left;
            float f22 = f21 - f5;
            float f23 = rect.bottom;
            canvas2.drawLine(f22, f23 + f4, f21 + this.mBorderCornerLength, f23 + f4, this.mBorderCornerPaint);
            float f24 = rect.right;
            float f25 = f24 + f4;
            float f26 = rect.bottom;
            canvas2.drawLine(f25, f26 + f5, f24 + f4, f26 - this.mBorderCornerLength, this.mBorderCornerPaint);
            float f27 = rect.right;
            float f28 = f27 + f5;
            float f29 = rect.bottom;
            canvas2.drawLine(f28, f29 + f4, f27 - this.mBorderCornerLength, f29 + f4, this.mBorderCornerPaint);
        }
    }

    private static Paint getNewPaint(int i) {
        Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    private static Paint getNewPaintOrNull(float f, int i) {
        if (f <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStrokeWidth(f);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.mMultiTouchEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    onActionMove(motionEvent.getX(), motionEvent.getY());
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            onActionUp();
            return true;
        }
        onActionDown(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    private void onActionDown(float f, float f2) {
        this.mMoveHandler = this.mCropWindowHandler.getMoveHandler(f, f2, this.mTouchRadius, this.mCropShape);
        if (this.mMoveHandler != null) {
            invalidate();
        }
    }

    private void onActionUp() {
        if (this.mMoveHandler != null) {
            this.mMoveHandler = null;
            callOnCropWindowChanged(false);
            invalidate();
        }
    }

    private void onActionMove(float f, float f2) {
        if (this.mMoveHandler != null) {
            float f3 = this.mSnapRadius;
            RectF rect = this.mCropWindowHandler.getRect();
            this.mMoveHandler.move(rect, f, f2, this.mCalcBounds, this.mViewWidth, this.mViewHeight, calculateBounds(rect) ? 0.0f : f3, this.mFixAspectRatio, this.mTargetAspectRatio);
            this.mCropWindowHandler.setRect(rect);
            callOnCropWindowChanged(true);
            invalidate();
        }
    }

    private boolean calculateBounds(RectF rectF) {
        RectF rectF2 = rectF;
        float rectLeft = BitmapUtils.getRectLeft(this.mBoundsPoints);
        float rectTop = BitmapUtils.getRectTop(this.mBoundsPoints);
        float rectRight = BitmapUtils.getRectRight(this.mBoundsPoints);
        float rectBottom = BitmapUtils.getRectBottom(this.mBoundsPoints);
        if (!isNonStraightAngleRotated()) {
            this.mCalcBounds.set(rectLeft, rectTop, rectRight, rectBottom);
            return false;
        }
        float[] fArr = this.mBoundsPoints;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[4];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[7];
        if (fArr[7] < fArr[1]) {
            if (fArr[1] < fArr[3]) {
                f = fArr[6];
                f2 = fArr[7];
                f3 = fArr[2];
                f4 = fArr[3];
                f5 = fArr[4];
                f6 = fArr[5];
            } else {
                f = fArr[4];
                f2 = fArr[5];
                f3 = fArr[0];
                f4 = fArr[1];
                f5 = fArr[2];
                f6 = fArr[3];
            }
        } else if (fArr[1] > fArr[3]) {
            f = fArr[2];
            f2 = fArr[3];
            f3 = fArr[6];
            f4 = fArr[7];
            f5 = fArr[0];
            f6 = fArr[1];
        }
        float f7 = (f6 - f2) / (f5 - f);
        float f8 = -1.0f / f7;
        float f9 = f2 - (f7 * f);
        float f10 = f2 - (f * f8);
        float f11 = f4 - (f7 * f3);
        float f12 = f4 - (f3 * f8);
        float centerY = rectF.centerY() - rectF2.top;
        float centerX = rectF.centerX();
        float f13 = rectF2.left;
        float f14 = centerY / (centerX - f13);
        float f15 = -f14;
        float f16 = rectF2.top;
        float f17 = f16 - (f13 * f14);
        float f18 = rectF2.right;
        float f19 = f16 - (f15 * f18);
        float f20 = f7 - f14;
        float f21 = (f17 - f9) / f20;
        float max = Math.max(rectLeft, f21 < f18 ? f21 : rectLeft);
        float f22 = (f17 - f10) / (f8 - f14);
        if (f22 >= rectF2.right) {
            f22 = max;
        }
        float max2 = Math.max(max, f22);
        float f23 = f8 - f15;
        float f24 = (f19 - f12) / f23;
        if (f24 >= rectF2.right) {
            f24 = max2;
        }
        float max3 = Math.max(max2, f24);
        float f25 = (f19 - f10) / f23;
        if (f25 <= rectF2.left) {
            f25 = rectRight;
        }
        float min = Math.min(rectRight, f25);
        float f26 = (f19 - f11) / (f7 - f15);
        if (f26 <= rectF2.left) {
            f26 = min;
        }
        float min2 = Math.min(min, f26);
        float f27 = (f17 - f11) / f20;
        if (f27 <= rectF2.left) {
            f27 = min2;
        }
        float min3 = Math.min(min2, f27);
        float max4 = Math.max(rectTop, Math.max((f7 * max3) + f9, (f8 * min3) + f10));
        float min4 = Math.min(rectBottom, Math.min((f8 * max3) + f12, (f7 * min3) + f11));
        RectF rectF3 = this.mCalcBounds;
        rectF3.left = max3;
        rectF3.top = max4;
        rectF3.right = min3;
        rectF3.bottom = min4;
        return true;
    }

    private boolean isNonStraightAngleRotated() {
        float[] fArr = this.mBoundsPoints;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private void callOnCropWindowChanged(boolean z) {
        try {
            if (this.mCropWindowChangeListener != null) {
                this.mCropWindowChangeListener.onCropWindowChanged(z);
            }
        } catch (Exception unused) {
        }
    }
}
