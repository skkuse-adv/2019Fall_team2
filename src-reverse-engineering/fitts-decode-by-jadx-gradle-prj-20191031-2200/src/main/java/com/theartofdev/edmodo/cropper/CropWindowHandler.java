package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;
import com.theartofdev.edmodo.cropper.CropImageView.CropShape;
import com.theartofdev.edmodo.cropper.CropWindowMoveHandler.Type;

final class CropWindowHandler {
    private final RectF mEdges = new RectF();
    private final RectF mGetEdges = new RectF();
    private float mMaxCropResultHeight;
    private float mMaxCropResultWidth;
    private float mMaxCropWindowHeight;
    private float mMaxCropWindowWidth;
    private float mMinCropResultHeight;
    private float mMinCropResultWidth;
    private float mMinCropWindowHeight;
    private float mMinCropWindowWidth;
    private float mScaleFactorHeight = 1.0f;
    private float mScaleFactorWidth = 1.0f;

    private static boolean isInCenterTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    CropWindowHandler() {
    }

    public RectF getRect() {
        this.mGetEdges.set(this.mEdges);
        return this.mGetEdges;
    }

    public float getMinCropWidth() {
        return Math.max(this.mMinCropWindowWidth, this.mMinCropResultWidth / this.mScaleFactorWidth);
    }

    public float getMinCropHeight() {
        return Math.max(this.mMinCropWindowHeight, this.mMinCropResultHeight / this.mScaleFactorHeight);
    }

    public float getMaxCropWidth() {
        return Math.min(this.mMaxCropWindowWidth, this.mMaxCropResultWidth / this.mScaleFactorWidth);
    }

    public float getMaxCropHeight() {
        return Math.min(this.mMaxCropWindowHeight, this.mMaxCropResultHeight / this.mScaleFactorHeight);
    }

    public float getScaleFactorWidth() {
        return this.mScaleFactorWidth;
    }

    public float getScaleFactorHeight() {
        return this.mScaleFactorHeight;
    }

    public void setMinCropResultSize(int i, int i2) {
        this.mMinCropResultWidth = (float) i;
        this.mMinCropResultHeight = (float) i2;
    }

    public void setMaxCropResultSize(int i, int i2) {
        this.mMaxCropResultWidth = (float) i;
        this.mMaxCropResultHeight = (float) i2;
    }

    public void setCropWindowLimits(float f, float f2, float f3, float f4) {
        this.mMaxCropWindowWidth = f;
        this.mMaxCropWindowHeight = f2;
        this.mScaleFactorWidth = f3;
        this.mScaleFactorHeight = f4;
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        this.mMinCropWindowWidth = (float) cropImageOptions.minCropWindowWidth;
        this.mMinCropWindowHeight = (float) cropImageOptions.minCropWindowHeight;
        this.mMinCropResultWidth = (float) cropImageOptions.minCropResultWidth;
        this.mMinCropResultHeight = (float) cropImageOptions.minCropResultHeight;
        this.mMaxCropResultWidth = (float) cropImageOptions.maxCropResultWidth;
        this.mMaxCropResultHeight = (float) cropImageOptions.maxCropResultHeight;
    }

    public void setRect(RectF rectF) {
        this.mEdges.set(rectF);
    }

    public boolean showGuidelines() {
        return this.mEdges.width() >= 100.0f && this.mEdges.height() >= 100.0f;
    }

    public CropWindowMoveHandler getMoveHandler(float f, float f2, float f3, CropShape cropShape) {
        Type type;
        if (cropShape == CropShape.OVAL) {
            type = getOvalPressedMoveType(f, f2);
        } else {
            type = getRectanglePressedMoveType(f, f2, f3);
        }
        if (type != null) {
            return new CropWindowMoveHandler(type, this, f, f2);
        }
        return null;
    }

    private Type getRectanglePressedMoveType(float f, float f2, float f3) {
        RectF rectF = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF.left, rectF.top, f3)) {
            return Type.TOP_LEFT;
        }
        RectF rectF2 = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF2.right, rectF2.top, f3)) {
            return Type.TOP_RIGHT;
        }
        RectF rectF3 = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF3.left, rectF3.bottom, f3)) {
            return Type.BOTTOM_LEFT;
        }
        RectF rectF4 = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF4.right, rectF4.bottom, f3)) {
            return Type.BOTTOM_RIGHT;
        }
        RectF rectF5 = this.mEdges;
        if (isInCenterTargetZone(f, f2, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && focusCenter()) {
            return Type.CENTER;
        }
        RectF rectF6 = this.mEdges;
        if (isInHorizontalTargetZone(f, f2, rectF6.left, rectF6.right, rectF6.top, f3)) {
            return Type.TOP;
        }
        RectF rectF7 = this.mEdges;
        if (isInHorizontalTargetZone(f, f2, rectF7.left, rectF7.right, rectF7.bottom, f3)) {
            return Type.BOTTOM;
        }
        RectF rectF8 = this.mEdges;
        if (isInVerticalTargetZone(f, f2, rectF8.left, rectF8.top, rectF8.bottom, f3)) {
            return Type.LEFT;
        }
        RectF rectF9 = this.mEdges;
        if (isInVerticalTargetZone(f, f2, rectF9.right, rectF9.top, rectF9.bottom, f3)) {
            return Type.RIGHT;
        }
        RectF rectF10 = this.mEdges;
        if (!isInCenterTargetZone(f, f2, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) || focusCenter()) {
            return null;
        }
        return Type.CENTER;
    }

    private Type getOvalPressedMoveType(float f, float f2) {
        float width = this.mEdges.width() / 6.0f;
        RectF rectF = this.mEdges;
        float f3 = rectF.left;
        float f4 = f3 + width;
        float f5 = f3 + (width * 5.0f);
        float height = rectF.height() / 6.0f;
        float f6 = this.mEdges.top;
        float f7 = f6 + height;
        float f8 = f6 + (height * 5.0f);
        if (f < f4) {
            if (f2 < f7) {
                return Type.TOP_LEFT;
            }
            if (f2 < f8) {
                return Type.LEFT;
            }
            return Type.BOTTOM_LEFT;
        } else if (f < f5) {
            if (f2 < f7) {
                return Type.TOP;
            }
            if (f2 < f8) {
                return Type.CENTER;
            }
            return Type.BOTTOM;
        } else if (f2 < f7) {
            return Type.TOP_RIGHT;
        } else {
            if (f2 < f8) {
                return Type.RIGHT;
            }
            return Type.BOTTOM_RIGHT;
        }
    }

    private static boolean isInCornerTargetZone(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    private static boolean isInHorizontalTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    private static boolean isInVerticalTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    private boolean focusCenter() {
        return !showGuidelines();
    }
}
