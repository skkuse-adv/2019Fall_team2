package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser.PathDataNode;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.kakao.network.ServerProtocol;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final Mode DEFAULT_TINT_MODE = Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    private static class VClipPath extends VPath {
        public boolean isClipPath() {
            return true;
        }

        public VClipPath() {
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                updateStateFromTypedArray(obtainAttributes);
                obtainAttributes.recycle();
            }
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
        }
    }

    private static class VFullPath extends VPath {
        private static final int FILL_TYPE_WINDING = 0;
        float mFillAlpha = 1.0f;
        ComplexColorCompat mFillColor;
        int mFillRule = 0;
        float mStrokeAlpha = 1.0f;
        ComplexColorCompat mStrokeColor;
        Cap mStrokeLineCap = Cap.BUTT;
        Join mStrokeLineJoin = Join.MITER;
        float mStrokeMiterlimit = 4.0f;
        float mStrokeWidth = 0.0f;
        private int[] mThemeAttrs;
        float mTrimPathEnd = 1.0f;
        float mTrimPathOffset = 0.0f;
        float mTrimPathStart = 0.0f;

        public VFullPath() {
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        private Cap getStrokeLineCap(int i, Cap cap) {
            if (i == 0) {
                return Cap.BUTT;
            }
            if (i != 1) {
                return i != 2 ? cap : Cap.SQUARE;
            }
            return Cap.ROUND;
        }

        private Join getStrokeLineJoin(int i, Join join) {
            if (i == 0) {
                return Join.MITER;
            }
            if (i != 1) {
                return i != 2 ? join : Join.BEVEL;
            }
            return Join.ROUND;
        }

        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme) {
            this.mThemeAttrs = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mPathName = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.mNodes = PathParser.createNodesFromPathData(string2);
                }
                Theme theme2 = theme;
                this.mFillColor = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.mFillAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
                this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
                this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
                this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
                this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
                this.mStrokeWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
                this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
                this.mTrimPathStart = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
                this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.mFillRule);
            }
        }

        public boolean isStateful() {
            return this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.mStrokeColor.onStateChanged(iArr) | this.mFillColor.onStateChanged(iArr);
        }

        public void applyTheme(Theme theme) {
            if (this.mThemeAttrs == null) {
            }
        }

        /* access modifiers changed from: 0000 */
        @ColorInt
        public int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeColor(int i) {
            this.mStrokeColor.setColor(i);
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        /* access modifiers changed from: 0000 */
        @ColorInt
        public int getFillColor() {
            return this.mFillColor.getColor();
        }

        /* access modifiers changed from: 0000 */
        public void setFillColor(int i) {
            this.mFillColor.setColor(i);
        }

        /* access modifiers changed from: 0000 */
        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        /* access modifiers changed from: 0000 */
        public void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }
    }

    private static class VGroup extends VObject {
        int mChangingConfigurations;
        final ArrayList<VObject> mChildren = new ArrayList<>();
        private String mGroupName = null;
        final Matrix mLocalMatrix = new Matrix();
        private float mPivotX = 0.0f;
        private float mPivotY = 0.0f;
        float mRotate = 0.0f;
        private float mScaleX = 1.0f;
        private float mScaleY = 1.0f;
        final Matrix mStackedMatrix = new Matrix();
        private int[] mThemeAttrs;
        private float mTranslateX = 0.0f;
        private float mTranslateY = 0.0f;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            VPath vPath;
            super();
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            this.mGroupName = vGroup.mGroupName;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            String str = this.mGroupName;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            ArrayList<VObject> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) obj);
                    } else if (obj instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vPath);
                    String str2 = vPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        public VGroup() {
            super();
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.mRotate);
            this.mPivotX = typedArray.getFloat(1, this.mPivotX);
            this.mPivotY = typedArray.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
            String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            updateLocalMatrix();
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        public float getRotation() {
            return this.mRotate;
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }

        public boolean isStateful() {
            for (int i = 0; i < this.mChildren.size(); i++) {
                if (((VObject) this.mChildren.get(i)).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.mChildren.size(); i++) {
                z |= ((VObject) this.mChildren.get(i)).onStateChanged(iArr);
            }
            return z;
        }
    }

    private static abstract class VObject {
        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }

        private VObject() {
        }
    }

    private static abstract class VPath extends VObject {
        int mChangingConfigurations;
        protected PathDataNode[] mNodes = null;
        String mPathName;

        public void applyTheme(Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public boolean isClipPath() {
            return false;
        }

        public VPath() {
            super();
        }

        public void printVPath(int i) {
            String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("current path is :");
            sb2.append(this.mPathName);
            sb2.append(" pathData is ");
            sb2.append(nodesToString(this.mNodes));
            sb2.toString();
        }

        public String nodesToString(PathDataNode[] pathDataNodeArr) {
            String str = ServerProtocol.AUTHORIZATION_HEADER_DELIMITER;
            int i = 0;
            while (i < pathDataNodeArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(pathDataNodeArr[i].mType);
                sb.append(":");
                String sb2 = sb.toString();
                float[] fArr = pathDataNodeArr[i].mParams;
                String str2 = sb2;
                for (float append : fArr) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(append);
                    sb3.append(",");
                    str2 = sb3.toString();
                }
                i++;
                str = str2;
            }
            return str;
        }

        public VPath(VPath vPath) {
            super();
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
        }

        public void toPath(Path path) {
            path.reset();
            PathDataNode[] pathDataNodeArr = this.mNodes;
            if (pathDataNodeArr != null) {
                PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public String getPathName() {
            return this.mPathName;
        }

        public PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public void setPathData(PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                this.mNodes = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.mNodes, pathDataNodeArr);
            }
        }
    }

    private static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = new Matrix();
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        Boolean mIsStateful;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        final VGroup mRootGroup;
        String mRootName;
        Paint mStrokePaint;
        final ArrayMap<String, Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        private static float cross(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, this.mVGTargetsMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                this.mVGTargetsMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                VObject vObject = (VObject) vGroup.mChildren.get(i3);
                if (vObject instanceof VGroup) {
                    drawGroupTree((VGroup) vObject, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                } else if (vObject instanceof VPath) {
                    drawPath(vGroup, (VPath) vObject, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.mViewportWidth;
            float f2 = ((float) i2) / this.mViewportHeight;
            float min = Math.min(f, f2);
            Matrix matrix = vGroup.mStackedMatrix;
            this.mFinalPathMatrix.set(matrix);
            this.mFinalPathMatrix.postScale(f, f2);
            float matrixScale = getMatrixScale(matrix);
            if (matrixScale != 0.0f) {
                vPath.toPath(this.mPath);
                Path path = this.mPath;
                this.mRenderPath.reset();
                if (vPath.isClipPath()) {
                    this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                    canvas.clipPath(this.mRenderPath);
                } else {
                    VFullPath vFullPath = (VFullPath) vPath;
                    if (!(vFullPath.mTrimPathStart == 0.0f && vFullPath.mTrimPathEnd == 1.0f)) {
                        float f3 = vFullPath.mTrimPathStart;
                        float f4 = vFullPath.mTrimPathOffset;
                        float f5 = (f3 + f4) % 1.0f;
                        float f6 = (vFullPath.mTrimPathEnd + f4) % 1.0f;
                        if (this.mPathMeasure == null) {
                            this.mPathMeasure = new PathMeasure();
                        }
                        this.mPathMeasure.setPath(this.mPath, false);
                        float length = this.mPathMeasure.getLength();
                        float f7 = f5 * length;
                        float f8 = f6 * length;
                        path.reset();
                        if (f7 > f8) {
                            this.mPathMeasure.getSegment(f7, length, path, true);
                            this.mPathMeasure.getSegment(0.0f, f8, path, true);
                        } else {
                            this.mPathMeasure.getSegment(f7, f8, path, true);
                        }
                        path.rLineTo(0.0f, 0.0f);
                    }
                    this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                    if (vFullPath.mFillColor.willDraw()) {
                        ComplexColorCompat complexColorCompat = vFullPath.mFillColor;
                        if (this.mFillPaint == null) {
                            this.mFillPaint = new Paint(1);
                            this.mFillPaint.setStyle(Style.FILL);
                        }
                        Paint paint = this.mFillPaint;
                        if (complexColorCompat.isGradient()) {
                            Shader shader = complexColorCompat.getShader();
                            shader.setLocalMatrix(this.mFinalPathMatrix);
                            paint.setShader(shader);
                            paint.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                        } else {
                            paint.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat.getColor(), vFullPath.mFillAlpha));
                        }
                        paint.setColorFilter(colorFilter);
                        this.mRenderPath.setFillType(vFullPath.mFillRule == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                        canvas.drawPath(this.mRenderPath, paint);
                    }
                    if (vFullPath.mStrokeColor.willDraw()) {
                        ComplexColorCompat complexColorCompat2 = vFullPath.mStrokeColor;
                        if (this.mStrokePaint == null) {
                            this.mStrokePaint = new Paint(1);
                            this.mStrokePaint.setStyle(Style.STROKE);
                        }
                        Paint paint2 = this.mStrokePaint;
                        Join join = vFullPath.mStrokeLineJoin;
                        if (join != null) {
                            paint2.setStrokeJoin(join);
                        }
                        Cap cap = vFullPath.mStrokeLineCap;
                        if (cap != null) {
                            paint2.setStrokeCap(cap);
                        }
                        paint2.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                        if (complexColorCompat2.isGradient()) {
                            Shader shader2 = complexColorCompat2.getShader();
                            shader2.setLocalMatrix(this.mFinalPathMatrix);
                            paint2.setShader(shader2);
                            paint2.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                        } else {
                            paint2.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat2.getColor(), vFullPath.mStrokeAlpha));
                        }
                        paint2.setColorFilter(colorFilter);
                        paint2.setStrokeWidth(vFullPath.mStrokeWidth * min * matrixScale);
                        canvas.drawPath(this.mRenderPath, paint2);
                    }
                }
            }
        }

        private float getMatrixScale(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float cross = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(cross) / max;
            }
            return 0.0f;
        }

        public boolean isStateful() {
            if (this.mIsStateful == null) {
                this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
            }
            return this.mIsStateful.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.mRootGroup.onStateChanged(iArr);
        }
    }

    private static class VectorDrawableCompatState extends ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                this.mVPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                Paint paint = vectorDrawableCompatState.mVPathRenderer.mFillPaint;
                if (paint != null) {
                    this.mVPathRenderer.mFillPaint = new Paint(paint);
                }
                Paint paint2 = vectorDrawableCompatState.mVPathRenderer.mStrokePaint;
                if (paint2 != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(paint2);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.mCachedBitmap, null, rect, getPaint(colorFilter));
        }

        public boolean hasTranslucentRoot() {
            return this.mVPathRenderer.getRootAlpha() < 255;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.mTempPaint == null) {
                this.mTempPaint = new Paint();
                this.mTempPaint.setFilterBitmap(true);
            }
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(colorFilter);
            return this.mTempPaint;
        }

        public void updateCachedBitmap(int i, int i2) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), i, i2, null);
        }

        public void createCachedBitmapIfNeeded(int i, int i2) {
            if (this.mCachedBitmap == null || !canReuseBitmap(i, i2)) {
                this.mCachedBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public boolean canReuseBitmap(int i, int i2) {
            return i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight();
        }

        public boolean canReuseCache() {
            return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.isStateful();
        }

        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged = this.mVPathRenderer.onStateChanged(iArr);
            this.mCacheDirty |= onStateChanged;
            return onStateChanged;
        }
    }

    @RequiresApi(24)
    private static class VectorDrawableDelegateState extends ConstantState {
        private final ConstantState mDelegateState;

        public VectorDrawableDelegateState(ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Object getTargetByName(String str) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str);
    }

    public ConstantState getConstantState() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null && VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(drawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int height = (int) (((float) this.mTmpBounds.height()) * abs2);
            int min = Math.min(2048, (int) (((float) this.mTmpBounds.width()) * abs));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.mTmpBounds;
                canvas.translate((float) rect.left, (float) rect.top);
                if (needMirroring()) {
                    canvas.translate((float) this.mTmpBounds.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.mTmpBounds.offsetTo(0, 0);
                this.mVectorState.createCachedBitmapIfNeeded(min, min2);
                if (!this.mAllowCaching) {
                    this.mVectorState.updateCachedBitmap(min, min2);
                } else if (!this.mVectorState.canReuseCache()) {
                    this.mVectorState.updateCachedBitmap(min, min2);
                    this.mVectorState.updateCacheStates();
                }
                this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter, this.mTmpBounds);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
            return;
        }
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r0.isStateful() != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.mDelegateDrawable
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.mVectorState
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.mVectorState
            android.content.res.ColorStateList r0 = r0.mTint
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        if (colorStateList != null) {
            Mode mode = vectorDrawableCompatState.mTintMode;
            if (mode != null) {
                this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, mode);
                invalidateSelf();
                z = true;
            }
        }
        if (vectorDrawableCompatState.isStateful() && vectorDrawableCompatState.onStateChanged(iArr)) {
            invalidateSelf();
            z = true;
        }
        return z;
    }

    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.canApplyTheme(drawable);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.mVectorState.mAutoMirrored;
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public float getPixelSize() {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState != null) {
            VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
            if (vPathRenderer != null) {
                float f = vPathRenderer.mBaseWidth;
                if (f != 0.0f) {
                    float f2 = vPathRenderer.mBaseHeight;
                    if (f2 != 0.0f) {
                        float f3 = vPathRenderer.mViewportHeight;
                        if (f3 != 0.0f) {
                            float f4 = vPathRenderer.mViewportWidth;
                            if (f4 != 0.0f) {
                                return Math.min(f4 / f, f3 / f2);
                            }
                        }
                    }
                }
            }
        }
        return 1.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ IOException | XmlPullParserException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[Catch:{ IOException | XmlPullParserException -> 0x0041 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat create(@androidx.annotation.NonNull android.content.res.Resources r4, @androidx.annotation.DrawableRes int r5, @androidx.annotation.Nullable android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001f
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r4 = androidx.core.content.res.ResourcesCompat.getDrawable(r4, r5, r6)
            r0.mDelegateDrawable = r4
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState r4 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState
            android.graphics.drawable.Drawable r5 = r0.mDelegateDrawable
            android.graphics.drawable.Drawable$ConstantState r5 = r5.getConstantState()
            r4.<init>(r5)
            r0.mCachedConstantStateDelegate = r4
            return r0
        L_0x001f:
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
        L_0x0027:
            int r1 = r5.next()     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
            r2 = 2
            if (r1 == r2) goto L_0x0032
            r3 = 1
            if (r1 == r3) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            if (r1 != r2) goto L_0x0039
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r4 = createFromXmlInner(r4, r5, r0, r6)     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
            return r4
        L_0x0039:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
            throw r4     // Catch:{ IOException | XmlPullParserException -> 0x0041 }
        L_0x0041:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.create(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    static int applyAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
        vectorDrawableCompatState.mCacheDirty = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    private static Mode parseTintModeCompat(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        vectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            vectorDrawableCompatState.mTint = colorStateList;
        }
        vectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.mAutoMirrored);
        vPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.mViewportWidth);
        vPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.mViewportHeight);
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append(typedArray.getPositionDescription());
            sb.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(sb.toString());
        } else if (vPathRenderer.mViewportHeight > 0.0f) {
            vPathRenderer.mBaseWidth = typedArray.getDimension(3, vPathRenderer.mBaseWidth);
            vPathRenderer.mBaseHeight = typedArray.getDimension(2, vPathRenderer.mBaseHeight);
            if (vPathRenderer.mBaseWidth <= 0.0f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(typedArray.getPositionDescription());
                sb2.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(sb2.toString());
            } else if (vPathRenderer.mBaseHeight > 0.0f) {
                vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.mRootName = string;
                    vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(typedArray.getPositionDescription());
                sb3.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(sb3.toString());
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(typedArray.getPositionDescription());
            sb4.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(sb4.toString());
        }
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.mRootGroup);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            String str = SHAPE_GROUP;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if (SHAPE_PATH.equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                    }
                    z = false;
                    vectorDrawableCompatState.mChangingConfigurations = vFullPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                } else if (str.equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vGroup2.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                }
            } else if (eventType == 3 && str.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private void printGroupTree(VGroup vGroup, int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("current group is :");
        sb2.append(vGroup.getGroupName());
        sb2.append(" rotation is ");
        sb2.append(vGroup.mRotate);
        sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("matrix is :");
        sb3.append(vGroup.getLocalMatrix().toString());
        sb3.toString();
        for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
            VObject vObject = (VObject) vGroup.mChildren.get(i3);
            if (vObject instanceof VGroup) {
                printGroupTree((VGroup) vObject, i + 1);
            } else {
                ((VPath) vObject).printVPath(i + 1);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setAllowCaching(boolean z) {
        this.mAllowCaching = z;
    }

    private boolean needMirroring() {
        if (VERSION.SDK_INT < 17 || !isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
