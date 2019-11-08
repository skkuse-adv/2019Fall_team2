package com.isseiaoki.simplecropview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.Registry;
import com.isseiaoki.simplecropview.animation.SimpleValueAnimator;
import com.isseiaoki.simplecropview.animation.SimpleValueAnimatorListener;
import com.isseiaoki.simplecropview.animation.ValueAnimatorV14;
import com.isseiaoki.simplecropview.animation.ValueAnimatorV8;
import com.isseiaoki.simplecropview.callback.Callback;
import com.isseiaoki.simplecropview.callback.CropCallback;
import com.isseiaoki.simplecropview.callback.LoadCallback;
import com.isseiaoki.simplecropview.callback.SaveCallback;
import com.isseiaoki.simplecropview.util.Logger;
import com.isseiaoki.simplecropview.util.Utils;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CropImageView extends ImageView {
    private final Interpolator DEFAULT_INTERPOLATOR;
    /* access modifiers changed from: private */
    public float mAngle;
    private int mAnimationDurationMillis;
    private SimpleValueAnimator mAnimator;
    private int mBackgroundColor;
    private PointF mCenter;
    private CompressFormat mCompressFormat;
    private int mCompressQuality;
    private CropMode mCropMode;
    private PointF mCustomRatio;
    private ExecutorService mExecutor;
    /* access modifiers changed from: private */
    public int mExifRotation;
    private int mFrameColor;
    /* access modifiers changed from: private */
    public RectF mFrameRect;
    private float mFrameStrokeWeight;
    private int mGuideColor;
    private ShowMode mGuideShowMode;
    private float mGuideStrokeWeight;
    private int mHandleColor;
    private ShowMode mHandleShowMode;
    private int mHandleSize;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private RectF mImageRect;
    private float mImgHeight;
    private float mImgWidth;
    /* access modifiers changed from: private */
    public RectF mInitialFrameRect;
    private float mInitialFrameScale;
    private int mInputImageHeight;
    private int mInputImageWidth;
    private Interpolator mInterpolator;
    /* access modifiers changed from: private */
    public boolean mIsAnimating;
    private boolean mIsAnimationEnabled;
    private boolean mIsCropEnabled;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsCropping;
    /* access modifiers changed from: private */
    public boolean mIsDebug;
    private boolean mIsEnabled;
    private boolean mIsHandleShadowEnabled;
    private boolean mIsInitialized;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsLoading;
    /* access modifiers changed from: private */
    public boolean mIsRotating;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsSaving;
    private float mLastX;
    private float mLastY;
    private Matrix mMatrix;
    private float mMinFrameSize;
    private int mOutputHeight;
    private int mOutputImageHeight;
    private int mOutputImageWidth;
    private int mOutputMaxHeight;
    private int mOutputMaxWidth;
    private int mOutputWidth;
    private int mOverlayColor;
    private Paint mPaintBitmap;
    private Paint mPaintDebug;
    private Paint mPaintFrame;
    private Paint mPaintTranslucent;
    private Uri mSaveUri;
    /* access modifiers changed from: private */
    public float mScale;
    private boolean mShowGuide;
    private boolean mShowHandle;
    /* access modifiers changed from: private */
    public Uri mSourceUri;
    private TouchArea mTouchArea;
    private int mTouchPadding;
    /* access modifiers changed from: private */
    public int mViewHeight;
    /* access modifiers changed from: private */
    public int mViewWidth;

    /* renamed from: com.isseiaoki.simplecropview.CropImageView$18 reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode = new int[CropMode.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode = new int[ShowMode.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea = new int[TouchArea.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00dc */
        static {
            /*
                com.isseiaoki.simplecropview.CropImageView$ShowMode[] r0 = com.isseiaoki.simplecropview.CropImageView.ShowMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.isseiaoki.simplecropview.CropImageView$ShowMode r2 = com.isseiaoki.simplecropview.CropImageView.ShowMode.SHOW_ALWAYS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode     // Catch:{ NoSuchFieldError -> 0x001f }
                com.isseiaoki.simplecropview.CropImageView$ShowMode r3 = com.isseiaoki.simplecropview.CropImageView.ShowMode.NOT_SHOW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode     // Catch:{ NoSuchFieldError -> 0x002a }
                com.isseiaoki.simplecropview.CropImageView$ShowMode r4 = com.isseiaoki.simplecropview.CropImageView.ShowMode.SHOW_ON_TOUCH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.isseiaoki.simplecropview.CropImageView$CropMode[] r3 = com.isseiaoki.simplecropview.CropImageView.CropMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode = r3
                int[] r3 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x003d }
                com.isseiaoki.simplecropview.CropImageView$CropMode r4 = com.isseiaoki.simplecropview.CropImageView.CropMode.FIT_IMAGE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r3 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r4 = com.isseiaoki.simplecropview.CropImageView.CropMode.FREE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r4 = com.isseiaoki.simplecropview.CropImageView.CropMode.RATIO_4_3     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r3 = 4
                int[] r4 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x005c }
                com.isseiaoki.simplecropview.CropImageView$CropMode r5 = com.isseiaoki.simplecropview.CropImageView.CropMode.RATIO_3_4     // Catch:{ NoSuchFieldError -> 0x005c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                r4 = 5
                int[] r5 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r6 = com.isseiaoki.simplecropview.CropImageView.CropMode.RATIO_16_9     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                r5 = 6
                int[] r6 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r7 = com.isseiaoki.simplecropview.CropImageView.CropMode.RATIO_9_16     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r6 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x007d }
                com.isseiaoki.simplecropview.CropImageView$CropMode r7 = com.isseiaoki.simplecropview.CropImageView.CropMode.SQUARE     // Catch:{ NoSuchFieldError -> 0x007d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r6 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r7 = com.isseiaoki.simplecropview.CropImageView.CropMode.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r6 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r7 = com.isseiaoki.simplecropview.CropImageView.CropMode.CIRCLE_SQUARE     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r8 = 9
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r6 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.isseiaoki.simplecropview.CropImageView$CropMode r7 = com.isseiaoki.simplecropview.CropImageView.CropMode.CUSTOM     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r8 = 10
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                com.isseiaoki.simplecropview.CropImageView$TouchArea[] r6 = com.isseiaoki.simplecropview.CropImageView.TouchArea.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea = r6
                int[] r6 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.isseiaoki.simplecropview.CropImageView$TouchArea r7 = com.isseiaoki.simplecropview.CropImageView.TouchArea.CENTER     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea     // Catch:{ NoSuchFieldError -> 0x00be }
                com.isseiaoki.simplecropview.CropImageView$TouchArea r6 = com.isseiaoki.simplecropview.CropImageView.TouchArea.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x00be }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                int[] r0 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea     // Catch:{ NoSuchFieldError -> 0x00c8 }
                com.isseiaoki.simplecropview.CropImageView$TouchArea r1 = com.isseiaoki.simplecropview.CropImageView.TouchArea.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                int[] r0 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea     // Catch:{ NoSuchFieldError -> 0x00d2 }
                com.isseiaoki.simplecropview.CropImageView$TouchArea r1 = com.isseiaoki.simplecropview.CropImageView.TouchArea.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                int[] r0 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea     // Catch:{ NoSuchFieldError -> 0x00dc }
                com.isseiaoki.simplecropview.CropImageView$TouchArea r1 = com.isseiaoki.simplecropview.CropImageView.TouchArea.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                int[] r0 = $SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea     // Catch:{ NoSuchFieldError -> 0x00e6 }
                com.isseiaoki.simplecropview.CropImageView$TouchArea r1 = com.isseiaoki.simplecropview.CropImageView.TouchArea.OUT_OF_BOUNDS     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.CropImageView.AnonymousClass18.<clinit>():void");
        }
    }

    public enum CropMode {
        FIT_IMAGE(0),
        RATIO_4_3(1),
        RATIO_3_4(2),
        SQUARE(3),
        RATIO_16_9(4),
        RATIO_9_16(5),
        FREE(6),
        CUSTOM(7),
        CIRCLE(8),
        CIRCLE_SQUARE(9);
        
        private final int ID;

        private CropMode(int i) {
            this.ID = i;
        }

        public int getId() {
            return this.ID;
        }
    }

    public enum RotateDegrees {
        ROTATE_90D(90),
        ROTATE_180D(180),
        ROTATE_270D(270),
        ROTATE_M90D(-90),
        ROTATE_M180D(-180),
        ROTATE_M270D(-270);
        
        private final int VALUE;

        private RotateDegrees(int i) {
            this.VALUE = i;
        }

        public int getValue() {
            return this.VALUE;
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new Creator() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        float angle;
        int animationDuration;
        int backgroundColor;
        CompressFormat compressFormat;
        int compressQuality;
        float customRatioX;
        float customRatioY;
        int exifRotation;
        int frameColor;
        float frameStrokeWeight;
        int guideColor;
        ShowMode guideShowMode;
        float guideStrokeWeight;
        int handleColor;
        ShowMode handleShowMode;
        int handleSize;
        float initialFrameScale;
        int inputImageHeight;
        int inputImageWidth;
        boolean isAnimationEnabled;
        boolean isCropEnabled;
        boolean isDebug;
        boolean isHandleShadowEnabled;
        float minFrameSize;
        CropMode mode;
        int outputHeight;
        int outputImageHeight;
        int outputImageWidth;
        int outputMaxHeight;
        int outputMaxWidth;
        int outputWidth;
        int overlayColor;
        Uri saveUri;
        boolean showGuide;
        boolean showHandle;
        Uri sourceUri;
        int touchPadding;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mode = (CropMode) parcel.readSerializable();
            this.backgroundColor = parcel.readInt();
            this.overlayColor = parcel.readInt();
            this.frameColor = parcel.readInt();
            this.guideShowMode = (ShowMode) parcel.readSerializable();
            this.handleShowMode = (ShowMode) parcel.readSerializable();
            boolean z = true;
            this.showGuide = parcel.readInt() != 0;
            this.showHandle = parcel.readInt() != 0;
            this.handleSize = parcel.readInt();
            this.touchPadding = parcel.readInt();
            this.minFrameSize = parcel.readFloat();
            this.customRatioX = parcel.readFloat();
            this.customRatioY = parcel.readFloat();
            this.frameStrokeWeight = parcel.readFloat();
            this.guideStrokeWeight = parcel.readFloat();
            this.isCropEnabled = parcel.readInt() != 0;
            this.handleColor = parcel.readInt();
            this.guideColor = parcel.readInt();
            this.initialFrameScale = parcel.readFloat();
            this.angle = parcel.readFloat();
            this.isAnimationEnabled = parcel.readInt() != 0;
            this.animationDuration = parcel.readInt();
            this.exifRotation = parcel.readInt();
            this.sourceUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.saveUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.compressFormat = (CompressFormat) parcel.readSerializable();
            this.compressQuality = parcel.readInt();
            this.isDebug = parcel.readInt() != 0;
            this.outputMaxWidth = parcel.readInt();
            this.outputMaxHeight = parcel.readInt();
            this.outputWidth = parcel.readInt();
            this.outputHeight = parcel.readInt();
            if (parcel.readInt() == 0) {
                z = false;
            }
            this.isHandleShadowEnabled = z;
            this.inputImageWidth = parcel.readInt();
            this.inputImageHeight = parcel.readInt();
            this.outputImageWidth = parcel.readInt();
            this.outputImageHeight = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.mode);
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.overlayColor);
            parcel.writeInt(this.frameColor);
            parcel.writeSerializable(this.guideShowMode);
            parcel.writeSerializable(this.handleShowMode);
            parcel.writeInt(this.showGuide ? 1 : 0);
            parcel.writeInt(this.showHandle ? 1 : 0);
            parcel.writeInt(this.handleSize);
            parcel.writeInt(this.touchPadding);
            parcel.writeFloat(this.minFrameSize);
            parcel.writeFloat(this.customRatioX);
            parcel.writeFloat(this.customRatioY);
            parcel.writeFloat(this.frameStrokeWeight);
            parcel.writeFloat(this.guideStrokeWeight);
            parcel.writeInt(this.isCropEnabled ? 1 : 0);
            parcel.writeInt(this.handleColor);
            parcel.writeInt(this.guideColor);
            parcel.writeFloat(this.initialFrameScale);
            parcel.writeFloat(this.angle);
            parcel.writeInt(this.isAnimationEnabled ? 1 : 0);
            parcel.writeInt(this.animationDuration);
            parcel.writeInt(this.exifRotation);
            parcel.writeParcelable(this.sourceUri, i);
            parcel.writeParcelable(this.saveUri, i);
            parcel.writeSerializable(this.compressFormat);
            parcel.writeInt(this.compressQuality);
            parcel.writeInt(this.isDebug ? 1 : 0);
            parcel.writeInt(this.outputMaxWidth);
            parcel.writeInt(this.outputMaxHeight);
            parcel.writeInt(this.outputWidth);
            parcel.writeInt(this.outputHeight);
            parcel.writeInt(this.isHandleShadowEnabled ? 1 : 0);
            parcel.writeInt(this.inputImageWidth);
            parcel.writeInt(this.inputImageHeight);
            parcel.writeInt(this.outputImageWidth);
            parcel.writeInt(this.outputImageHeight);
        }
    }

    public enum ShowMode {
        SHOW_ALWAYS(1),
        SHOW_ON_TOUCH(2),
        NOT_SHOW(3);
        
        private final int ID;

        private ShowMode(int i) {
            this.ID = i;
        }

        public int getId() {
            return this.ID;
        }
    }

    private enum TouchArea {
        OUT_OF_BOUNDS,
        CENTER,
        LEFT_TOP,
        RIGHT_TOP,
        LEFT_BOTTOM,
        RIGHT_BOTTOM
    }

    private float constrain(float f, float f2, float f3, float f4) {
        return (f < f2 || f > f3) ? f4 : f;
    }

    private float getRotatedHeight(float f, float f2, float f3) {
        return f % 180.0f == 0.0f ? f3 : f2;
    }

    private float getRotatedWidth(float f, float f2, float f3) {
        return f % 180.0f == 0.0f ? f2 : f3;
    }

    private float sq(float f) {
        return f * f;
    }

    static {
        Class<CropImageView> cls = CropImageView.class;
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mScale = 1.0f;
        this.mAngle = 0.0f;
        this.mImgWidth = 0.0f;
        this.mImgHeight = 0.0f;
        this.mIsInitialized = false;
        this.mMatrix = null;
        this.mCenter = new PointF();
        this.mIsRotating = false;
        this.mIsAnimating = false;
        this.mAnimator = null;
        this.DEFAULT_INTERPOLATOR = new DecelerateInterpolator();
        this.mInterpolator = this.DEFAULT_INTERPOLATOR;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mSourceUri = null;
        this.mSaveUri = null;
        this.mExifRotation = 0;
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
        this.mIsDebug = false;
        this.mCompressFormat = CompressFormat.PNG;
        this.mCompressQuality = 100;
        this.mInputImageWidth = 0;
        this.mInputImageHeight = 0;
        this.mOutputImageWidth = 0;
        this.mOutputImageHeight = 0;
        this.mIsLoading = new AtomicBoolean(false);
        this.mIsCropping = new AtomicBoolean(false);
        this.mIsSaving = new AtomicBoolean(false);
        this.mTouchArea = TouchArea.OUT_OF_BOUNDS;
        this.mCropMode = CropMode.SQUARE;
        ShowMode showMode = ShowMode.SHOW_ALWAYS;
        this.mGuideShowMode = showMode;
        this.mHandleShowMode = showMode;
        this.mTouchPadding = 0;
        this.mShowGuide = true;
        this.mShowHandle = true;
        this.mIsCropEnabled = true;
        this.mIsEnabled = true;
        this.mCustomRatio = new PointF(1.0f, 1.0f);
        this.mFrameStrokeWeight = 2.0f;
        this.mGuideStrokeWeight = 2.0f;
        this.mIsAnimationEnabled = true;
        this.mAnimationDurationMillis = 100;
        this.mIsHandleShadowEnabled = true;
        this.mExecutor = Executors.newSingleThreadExecutor();
        float density = getDensity();
        this.mHandleSize = (int) (14.0f * density);
        this.mMinFrameSize = 50.0f * density;
        float f = density * 1.0f;
        this.mFrameStrokeWeight = f;
        this.mGuideStrokeWeight = f;
        this.mPaintFrame = new Paint();
        this.mPaintTranslucent = new Paint();
        this.mPaintBitmap = new Paint();
        this.mPaintBitmap.setFilterBitmap(true);
        this.mPaintDebug = new Paint();
        this.mPaintDebug.setAntiAlias(true);
        this.mPaintDebug.setStyle(Style.STROKE);
        this.mPaintDebug.setColor(-1);
        this.mPaintDebug.setTextSize(15.0f * density);
        this.mMatrix = new Matrix();
        this.mScale = 1.0f;
        this.mBackgroundColor = 0;
        this.mFrameColor = -1;
        this.mOverlayColor = -1157627904;
        this.mHandleColor = -1;
        this.mGuideColor = -1140850689;
        handleStyleable(context, attributeSet, i, density);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mode = this.mCropMode;
        savedState.backgroundColor = this.mBackgroundColor;
        savedState.overlayColor = this.mOverlayColor;
        savedState.frameColor = this.mFrameColor;
        savedState.guideShowMode = this.mGuideShowMode;
        savedState.handleShowMode = this.mHandleShowMode;
        savedState.showGuide = this.mShowGuide;
        savedState.showHandle = this.mShowHandle;
        savedState.handleSize = this.mHandleSize;
        savedState.touchPadding = this.mTouchPadding;
        savedState.minFrameSize = this.mMinFrameSize;
        PointF pointF = this.mCustomRatio;
        savedState.customRatioX = pointF.x;
        savedState.customRatioY = pointF.y;
        savedState.frameStrokeWeight = this.mFrameStrokeWeight;
        savedState.guideStrokeWeight = this.mGuideStrokeWeight;
        savedState.isCropEnabled = this.mIsCropEnabled;
        savedState.handleColor = this.mHandleColor;
        savedState.guideColor = this.mGuideColor;
        savedState.initialFrameScale = this.mInitialFrameScale;
        savedState.angle = this.mAngle;
        savedState.isAnimationEnabled = this.mIsAnimationEnabled;
        savedState.animationDuration = this.mAnimationDurationMillis;
        savedState.exifRotation = this.mExifRotation;
        savedState.sourceUri = this.mSourceUri;
        savedState.saveUri = this.mSaveUri;
        savedState.compressFormat = this.mCompressFormat;
        savedState.compressQuality = this.mCompressQuality;
        savedState.isDebug = this.mIsDebug;
        savedState.outputMaxWidth = this.mOutputMaxWidth;
        savedState.outputMaxHeight = this.mOutputMaxHeight;
        savedState.outputWidth = this.mOutputWidth;
        savedState.outputHeight = this.mOutputHeight;
        savedState.isHandleShadowEnabled = this.mIsHandleShadowEnabled;
        savedState.inputImageWidth = this.mInputImageWidth;
        savedState.inputImageHeight = this.mInputImageHeight;
        savedState.outputImageWidth = this.mOutputImageWidth;
        savedState.outputImageHeight = this.mOutputImageHeight;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCropMode = savedState.mode;
        this.mBackgroundColor = savedState.backgroundColor;
        this.mOverlayColor = savedState.overlayColor;
        this.mFrameColor = savedState.frameColor;
        this.mGuideShowMode = savedState.guideShowMode;
        this.mHandleShowMode = savedState.handleShowMode;
        this.mShowGuide = savedState.showGuide;
        this.mShowHandle = savedState.showHandle;
        this.mHandleSize = savedState.handleSize;
        this.mTouchPadding = savedState.touchPadding;
        this.mMinFrameSize = savedState.minFrameSize;
        this.mCustomRatio = new PointF(savedState.customRatioX, savedState.customRatioY);
        this.mFrameStrokeWeight = savedState.frameStrokeWeight;
        this.mGuideStrokeWeight = savedState.guideStrokeWeight;
        this.mIsCropEnabled = savedState.isCropEnabled;
        this.mHandleColor = savedState.handleColor;
        this.mGuideColor = savedState.guideColor;
        this.mInitialFrameScale = savedState.initialFrameScale;
        this.mAngle = savedState.angle;
        this.mIsAnimationEnabled = savedState.isAnimationEnabled;
        this.mAnimationDurationMillis = savedState.animationDuration;
        this.mExifRotation = savedState.exifRotation;
        this.mSourceUri = savedState.sourceUri;
        this.mSaveUri = savedState.saveUri;
        this.mCompressFormat = savedState.compressFormat;
        this.mCompressQuality = savedState.compressQuality;
        this.mIsDebug = savedState.isDebug;
        this.mOutputMaxWidth = savedState.outputMaxWidth;
        this.mOutputMaxHeight = savedState.outputMaxHeight;
        this.mOutputWidth = savedState.outputWidth;
        this.mOutputHeight = savedState.outputHeight;
        this.mIsHandleShadowEnabled = savedState.isHandleShadowEnabled;
        this.mInputImageWidth = savedState.inputImageWidth;
        this.mInputImageHeight = savedState.inputImageHeight;
        this.mOutputImageWidth = savedState.outputImageWidth;
        this.mOutputImageHeight = savedState.outputImageHeight;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        this.mViewWidth = (size - getPaddingLeft()) - getPaddingRight();
        this.mViewHeight = (size2 - getPaddingTop()) - getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getDrawable() != null) {
            setupLayout(this.mViewWidth, this.mViewHeight);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.mBackgroundColor);
        if (this.mIsInitialized) {
            setMatrix();
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.mMatrix, this.mPaintBitmap);
                drawCropFrame(canvas);
            }
            if (this.mIsDebug) {
                drawDebugInfo(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mExecutor.shutdown();
        super.onDetachedFromWindow();
    }

    private void handleStyleable(Context context, AttributeSet attributeSet, int i, float f) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.scv_CropImageView, i, 0);
        this.mCropMode = CropMode.SQUARE;
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.scv_CropImageView_scv_img_src);
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            CropMode[] values = CropMode.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                CropMode cropMode = values[i2];
                if (obtainStyledAttributes.getInt(R$styleable.scv_CropImageView_scv_crop_mode, 3) == cropMode.getId()) {
                    this.mCropMode = cropMode;
                    break;
                }
                i2++;
            }
            this.mBackgroundColor = obtainStyledAttributes.getColor(R$styleable.scv_CropImageView_scv_background_color, 0);
            this.mOverlayColor = obtainStyledAttributes.getColor(R$styleable.scv_CropImageView_scv_overlay_color, -1157627904);
            this.mFrameColor = obtainStyledAttributes.getColor(R$styleable.scv_CropImageView_scv_frame_color, -1);
            this.mHandleColor = obtainStyledAttributes.getColor(R$styleable.scv_CropImageView_scv_handle_color, -1);
            this.mGuideColor = obtainStyledAttributes.getColor(R$styleable.scv_CropImageView_scv_guide_color, -1140850689);
            ShowMode[] values2 = ShowMode.values();
            int length2 = values2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                ShowMode showMode = values2[i3];
                if (obtainStyledAttributes.getInt(R$styleable.scv_CropImageView_scv_guide_show_mode, 1) == showMode.getId()) {
                    this.mGuideShowMode = showMode;
                    break;
                }
                i3++;
            }
            ShowMode[] values3 = ShowMode.values();
            int length3 = values3.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    break;
                }
                ShowMode showMode2 = values3[i4];
                if (obtainStyledAttributes.getInt(R$styleable.scv_CropImageView_scv_handle_show_mode, 1) == showMode2.getId()) {
                    this.mHandleShowMode = showMode2;
                    break;
                }
                i4++;
            }
            setGuideShowMode(this.mGuideShowMode);
            setHandleShowMode(this.mHandleShowMode);
            this.mHandleSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.scv_CropImageView_scv_handle_size, (int) (14.0f * f));
            this.mTouchPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.scv_CropImageView_scv_touch_padding, 0);
            this.mMinFrameSize = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.scv_CropImageView_scv_min_frame_size, (int) (50.0f * f));
            int i5 = (int) (f * 1.0f);
            this.mFrameStrokeWeight = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.scv_CropImageView_scv_frame_stroke_weight, i5);
            this.mGuideStrokeWeight = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.scv_CropImageView_scv_guide_stroke_weight, i5);
            this.mIsCropEnabled = obtainStyledAttributes.getBoolean(R$styleable.scv_CropImageView_scv_crop_enabled, true);
            this.mInitialFrameScale = constrain(obtainStyledAttributes.getFloat(R$styleable.scv_CropImageView_scv_initial_frame_scale, 1.0f), 0.01f, 1.0f, 1.0f);
            this.mIsAnimationEnabled = obtainStyledAttributes.getBoolean(R$styleable.scv_CropImageView_scv_animation_enabled, true);
            this.mAnimationDurationMillis = obtainStyledAttributes.getInt(R$styleable.scv_CropImageView_scv_animation_duration, 100);
            this.mIsHandleShadowEnabled = obtainStyledAttributes.getBoolean(R$styleable.scv_CropImageView_scv_handle_shadow_enabled, true);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
    }

    private void drawDebugInfo(Canvas canvas) {
        StringBuilder sb;
        int i;
        FontMetrics fontMetrics = this.mPaintDebug.getFontMetrics();
        this.mPaintDebug.measureText(ExifInterface.LONGITUDE_WEST);
        int i2 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int density = (int) (this.mImageRect.left + (((float) this.mHandleSize) * 0.5f * getDensity()));
        int density2 = (int) (this.mImageRect.top + ((float) i2) + (((float) this.mHandleSize) * 0.5f * getDensity()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LOADED FROM: ");
        sb2.append(this.mSourceUri != null ? "Uri" : Registry.BUCKET_BITMAP);
        float f = (float) density;
        canvas.drawText(sb2.toString(), f, (float) density2, this.mPaintDebug);
        StringBuilder sb3 = new StringBuilder();
        String str = "INPUT_IMAGE_SIZE: ";
        String str2 = "x";
        if (this.mSourceUri == null) {
            sb3.append(str);
            sb3.append((int) this.mImgWidth);
            sb3.append(str2);
            sb3.append((int) this.mImgHeight);
            i = density2 + i2;
            canvas.drawText(sb3.toString(), f, (float) i, this.mPaintDebug);
            sb = new StringBuilder();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(this.mInputImageWidth);
            sb4.append(str2);
            sb4.append(this.mInputImageHeight);
            i = density2 + i2;
            canvas.drawText(sb4.toString(), f, (float) i, this.mPaintDebug);
            sb = new StringBuilder();
        }
        sb.append("LOADED_IMAGE_SIZE: ");
        sb.append(getBitmap().getWidth());
        sb.append(str2);
        sb.append(getBitmap().getHeight());
        int i3 = i + i2;
        canvas.drawText(sb.toString(), f, (float) i3, this.mPaintDebug);
        StringBuilder sb5 = new StringBuilder();
        if (this.mOutputImageWidth > 0 && this.mOutputImageHeight > 0) {
            sb5.append("OUTPUT_IMAGE_SIZE: ");
            sb5.append(this.mOutputImageWidth);
            sb5.append(str2);
            sb5.append(this.mOutputImageHeight);
            int i4 = i3 + i2;
            canvas.drawText(sb5.toString(), f, (float) i4, this.mPaintDebug);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("EXIF ROTATION: ");
            sb6.append(this.mExifRotation);
            int i5 = i4 + i2;
            canvas.drawText(sb6.toString(), f, (float) i5, this.mPaintDebug);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("CURRENT_ROTATION: ");
            sb7.append((int) this.mAngle);
            i3 = i5 + i2;
            canvas.drawText(sb7.toString(), f, (float) i3, this.mPaintDebug);
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("FRAME_RECT: ");
        sb8.append(this.mFrameRect.toString());
        int i6 = i3 + i2;
        canvas.drawText(sb8.toString(), f, (float) i6, this.mPaintDebug);
        StringBuilder sb9 = new StringBuilder();
        sb9.append("ACTUAL_CROP_RECT: ");
        sb9.append(getActualCropRect().toString());
        canvas.drawText(sb9.toString(), f, (float) (i6 + i2), this.mPaintDebug);
    }

    private void drawCropFrame(Canvas canvas) {
        if (this.mIsCropEnabled && !this.mIsRotating) {
            drawOverlay(canvas);
            drawFrame(canvas);
            if (this.mShowGuide) {
                drawGuidelines(canvas);
            }
            if (this.mShowHandle) {
                drawHandles(canvas);
            }
        }
    }

    private void drawOverlay(Canvas canvas) {
        this.mPaintTranslucent.setAntiAlias(true);
        this.mPaintTranslucent.setFilterBitmap(true);
        this.mPaintTranslucent.setColor(this.mOverlayColor);
        this.mPaintTranslucent.setStyle(Style.FILL);
        Path path = new Path();
        RectF rectF = new RectF((float) Math.floor((double) this.mImageRect.left), (float) Math.floor((double) this.mImageRect.top), (float) Math.ceil((double) this.mImageRect.right), (float) Math.ceil((double) this.mImageRect.bottom));
        if (!this.mIsAnimating) {
            CropMode cropMode = this.mCropMode;
            if (cropMode == CropMode.CIRCLE || cropMode == CropMode.CIRCLE_SQUARE) {
                path.addRect(rectF, Direction.CW);
                RectF rectF2 = this.mFrameRect;
                PointF pointF = new PointF((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
                RectF rectF3 = this.mFrameRect;
                path.addCircle(pointF.x, pointF.y, (rectF3.right - rectF3.left) / 2.0f, Direction.CCW);
                canvas.drawPath(path, this.mPaintTranslucent);
                return;
            }
        }
        path.addRect(rectF, Direction.CW);
        path.addRect(this.mFrameRect, Direction.CCW);
        canvas.drawPath(path, this.mPaintTranslucent);
    }

    private void drawFrame(Canvas canvas) {
        this.mPaintFrame.setAntiAlias(true);
        this.mPaintFrame.setFilterBitmap(true);
        this.mPaintFrame.setStyle(Style.STROKE);
        this.mPaintFrame.setColor(this.mFrameColor);
        this.mPaintFrame.setStrokeWidth(this.mFrameStrokeWeight);
        canvas.drawRect(this.mFrameRect, this.mPaintFrame);
    }

    private void drawGuidelines(Canvas canvas) {
        this.mPaintFrame.setColor(this.mGuideColor);
        this.mPaintFrame.setStrokeWidth(this.mGuideStrokeWeight);
        RectF rectF = this.mFrameRect;
        float f = rectF.left;
        float f2 = rectF.right;
        float f3 = f + ((f2 - f) / 3.0f);
        float f4 = f2 - ((f2 - f) / 3.0f);
        float f5 = rectF.top;
        float f6 = rectF.bottom;
        float f7 = f5 + ((f6 - f5) / 3.0f);
        float f8 = f6 - ((f6 - f5) / 3.0f);
        canvas.drawLine(f3, f5, f3, f6, this.mPaintFrame);
        RectF rectF2 = this.mFrameRect;
        canvas.drawLine(f4, rectF2.top, f4, rectF2.bottom, this.mPaintFrame);
        RectF rectF3 = this.mFrameRect;
        canvas.drawLine(rectF3.left, f7, rectF3.right, f7, this.mPaintFrame);
        RectF rectF4 = this.mFrameRect;
        canvas.drawLine(rectF4.left, f8, rectF4.right, f8, this.mPaintFrame);
    }

    private void drawHandles(Canvas canvas) {
        if (this.mIsHandleShadowEnabled) {
            drawHandleShadows(canvas);
        }
        this.mPaintFrame.setStyle(Style.FILL);
        this.mPaintFrame.setColor(this.mHandleColor);
        RectF rectF = this.mFrameRect;
        canvas.drawCircle(rectF.left, rectF.top, (float) this.mHandleSize, this.mPaintFrame);
        RectF rectF2 = this.mFrameRect;
        canvas.drawCircle(rectF2.right, rectF2.top, (float) this.mHandleSize, this.mPaintFrame);
        RectF rectF3 = this.mFrameRect;
        canvas.drawCircle(rectF3.left, rectF3.bottom, (float) this.mHandleSize, this.mPaintFrame);
        RectF rectF4 = this.mFrameRect;
        canvas.drawCircle(rectF4.right, rectF4.bottom, (float) this.mHandleSize, this.mPaintFrame);
    }

    private void drawHandleShadows(Canvas canvas) {
        this.mPaintFrame.setStyle(Style.FILL);
        this.mPaintFrame.setColor(-1157627904);
        RectF rectF = new RectF(this.mFrameRect);
        rectF.offset(0.0f, 1.0f);
        canvas.drawCircle(rectF.left, rectF.top, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(rectF.right, rectF.top, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(rectF.left, rectF.bottom, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(rectF.right, rectF.bottom, (float) this.mHandleSize, this.mPaintFrame);
    }

    /* access modifiers changed from: private */
    public void setMatrix() {
        this.mMatrix.reset();
        Matrix matrix = this.mMatrix;
        PointF pointF = this.mCenter;
        matrix.setTranslate(pointF.x - (this.mImgWidth * 0.5f), pointF.y - (this.mImgHeight * 0.5f));
        Matrix matrix2 = this.mMatrix;
        float f = this.mScale;
        PointF pointF2 = this.mCenter;
        matrix2.postScale(f, f, pointF2.x, pointF2.y);
        Matrix matrix3 = this.mMatrix;
        float f2 = this.mAngle;
        PointF pointF3 = this.mCenter;
        matrix3.postRotate(f2, pointF3.x, pointF3.y);
    }

    /* access modifiers changed from: private */
    public void setupLayout(int i, int i2) {
        if (i != 0 && i2 != 0) {
            setCenter(new PointF(((float) getPaddingLeft()) + (((float) i) * 0.5f), ((float) getPaddingTop()) + (((float) i2) * 0.5f)));
            setScale(calcScale(i, i2, this.mAngle));
            setMatrix();
            this.mImageRect = calcImageRect(new RectF(0.0f, 0.0f, this.mImgWidth, this.mImgHeight), this.mMatrix);
            RectF rectF = this.mInitialFrameRect;
            if (rectF != null) {
                this.mFrameRect = applyInitialFrameRect(rectF);
            } else {
                this.mFrameRect = calcFrameRect(this.mImageRect);
            }
            this.mIsInitialized = true;
            invalidate();
        }
    }

    private float calcScale(int i, int i2, float f) {
        this.mImgWidth = (float) getDrawable().getIntrinsicWidth();
        this.mImgHeight = (float) getDrawable().getIntrinsicHeight();
        if (this.mImgWidth <= 0.0f) {
            this.mImgWidth = (float) i;
        }
        if (this.mImgHeight <= 0.0f) {
            this.mImgHeight = (float) i2;
        }
        float f2 = (float) i;
        float f3 = (float) i2;
        float f4 = f2 / f3;
        float rotatedWidth = getRotatedWidth(f) / getRotatedHeight(f);
        if (rotatedWidth >= f4) {
            return f2 / getRotatedWidth(f);
        }
        if (rotatedWidth < f4) {
            return f3 / getRotatedHeight(f);
        }
        return 1.0f;
    }

    private RectF calcImageRect(RectF rectF, Matrix matrix) {
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        return rectF2;
    }

    private RectF calcFrameRect(RectF rectF) {
        float width = rectF.width() / rectF.height();
        float ratioX = getRatioX(rectF.width()) / getRatioY(rectF.height());
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        if (ratioX >= width) {
            float f5 = (f2 + f4) * 0.5f;
            float width2 = (rectF.width() / ratioX) * 0.5f;
            f4 = f5 + width2;
            f2 = f5 - width2;
        } else if (ratioX < width) {
            float f6 = (f + f3) * 0.5f;
            float height = rectF.height() * ratioX * 0.5f;
            f3 = f6 + height;
            f = f6 - height;
        }
        float f7 = f3 - f;
        float f8 = f4 - f2;
        float f9 = f + (f7 / 2.0f);
        float f10 = f2 + (f8 / 2.0f);
        float f11 = this.mInitialFrameScale;
        float f12 = (f7 * f11) / 2.0f;
        float f13 = (f8 * f11) / 2.0f;
        return new RectF(f9 - f12, f10 - f13, f9 + f12, f10 + f13);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsInitialized || !this.mIsCropEnabled || !this.mIsEnabled || this.mIsRotating || this.mIsAnimating || this.mIsLoading.get() || this.mIsCropping.get()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            onDown(motionEvent);
            return true;
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            onUp(motionEvent);
            return true;
        } else if (action == 2) {
            onMove(motionEvent);
            if (this.mTouchArea != TouchArea.OUT_OF_BOUNDS) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        } else if (action != 3) {
            return false;
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
            onCancel();
            return true;
        }
    }

    private void onDown(MotionEvent motionEvent) {
        invalidate();
        this.mLastX = motionEvent.getX();
        this.mLastY = motionEvent.getY();
        checkTouchArea(motionEvent.getX(), motionEvent.getY());
    }

    private void onMove(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.mLastX;
        float y = motionEvent.getY() - this.mLastY;
        int i = AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$TouchArea[this.mTouchArea.ordinal()];
        if (i == 1) {
            moveFrame(x, y);
        } else if (i == 2) {
            moveHandleLT(x, y);
        } else if (i == 3) {
            moveHandleRT(x, y);
        } else if (i == 4) {
            moveHandleLB(x, y);
        } else if (i == 5) {
            moveHandleRB(x, y);
        }
        invalidate();
        this.mLastX = motionEvent.getX();
        this.mLastY = motionEvent.getY();
    }

    private void onUp(MotionEvent motionEvent) {
        if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = false;
        }
        if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
            this.mShowHandle = false;
        }
        this.mTouchArea = TouchArea.OUT_OF_BOUNDS;
        invalidate();
    }

    private void onCancel() {
        this.mTouchArea = TouchArea.OUT_OF_BOUNDS;
        invalidate();
    }

    private void checkTouchArea(float f, float f2) {
        if (isInsideCornerLeftTop(f, f2)) {
            this.mTouchArea = TouchArea.LEFT_TOP;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideCornerRightTop(f, f2)) {
            this.mTouchArea = TouchArea.RIGHT_TOP;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideCornerLeftBottom(f, f2)) {
            this.mTouchArea = TouchArea.LEFT_BOTTOM;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideCornerRightBottom(f, f2)) {
            this.mTouchArea = TouchArea.RIGHT_BOTTOM;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideFrame(f, f2)) {
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
            this.mTouchArea = TouchArea.CENTER;
        } else {
            this.mTouchArea = TouchArea.OUT_OF_BOUNDS;
        }
    }

    private boolean isInsideFrame(float f, float f2) {
        RectF rectF = this.mFrameRect;
        if (rectF.left > f || rectF.right < f || rectF.top > f2 || rectF.bottom < f2) {
            return false;
        }
        this.mTouchArea = TouchArea.CENTER;
        return true;
    }

    private boolean isInsideCornerLeftTop(float f, float f2) {
        RectF rectF = this.mFrameRect;
        float f3 = f - rectF.left;
        float f4 = f2 - rectF.top;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean isInsideCornerRightTop(float f, float f2) {
        RectF rectF = this.mFrameRect;
        float f3 = f - rectF.right;
        float f4 = f2 - rectF.top;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean isInsideCornerLeftBottom(float f, float f2) {
        RectF rectF = this.mFrameRect;
        float f3 = f - rectF.left;
        float f4 = f2 - rectF.bottom;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean isInsideCornerRightBottom(float f, float f2) {
        RectF rectF = this.mFrameRect;
        float f3 = f - rectF.right;
        float f4 = f2 - rectF.bottom;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f3 * f3) + (f4 * f4);
    }

    private void moveFrame(float f, float f2) {
        RectF rectF = this.mFrameRect;
        rectF.left += f;
        rectF.right += f;
        rectF.top += f2;
        rectF.bottom += f2;
        checkMoveBounds();
    }

    private void moveHandleLT(float f, float f2) {
        if (this.mCropMode == CropMode.FREE) {
            RectF rectF = this.mFrameRect;
            rectF.left += f;
            rectF.top += f2;
            if (isWidthTooSmall()) {
                float frameW = this.mMinFrameSize - getFrameW();
                this.mFrameRect.left -= frameW;
            }
            if (isHeightTooSmall()) {
                float frameH = this.mMinFrameSize - getFrameH();
                this.mFrameRect.top -= frameH;
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        RectF rectF2 = this.mFrameRect;
        rectF2.left += f;
        rectF2.top += ratioY;
        if (isWidthTooSmall()) {
            float frameW2 = this.mMinFrameSize - getFrameW();
            this.mFrameRect.left -= frameW2;
            float ratioY2 = (frameW2 * getRatioY()) / getRatioX();
            this.mFrameRect.top -= ratioY2;
        }
        if (isHeightTooSmall()) {
            float frameH2 = this.mMinFrameSize - getFrameH();
            this.mFrameRect.top -= frameH2;
            float ratioX = (frameH2 * getRatioX()) / getRatioY();
            this.mFrameRect.left -= ratioX;
        }
        if (!isInsideHorizontal(this.mFrameRect.left)) {
            float f3 = this.mImageRect.left;
            RectF rectF3 = this.mFrameRect;
            float f4 = rectF3.left;
            float f5 = f3 - f4;
            rectF3.left = f4 + f5;
            float ratioY3 = (f5 * getRatioY()) / getRatioX();
            this.mFrameRect.top += ratioY3;
        }
        if (!isInsideVertical(this.mFrameRect.top)) {
            float f6 = this.mImageRect.top;
            RectF rectF4 = this.mFrameRect;
            float f7 = rectF4.top;
            float f8 = f6 - f7;
            rectF4.top = f7 + f8;
            float ratioX2 = (f8 * getRatioX()) / getRatioY();
            this.mFrameRect.left += ratioX2;
        }
    }

    private void moveHandleRT(float f, float f2) {
        if (this.mCropMode == CropMode.FREE) {
            RectF rectF = this.mFrameRect;
            rectF.right += f;
            rectF.top += f2;
            if (isWidthTooSmall()) {
                float frameW = this.mMinFrameSize - getFrameW();
                this.mFrameRect.right += frameW;
            }
            if (isHeightTooSmall()) {
                float frameH = this.mMinFrameSize - getFrameH();
                this.mFrameRect.top -= frameH;
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        RectF rectF2 = this.mFrameRect;
        rectF2.right += f;
        rectF2.top -= ratioY;
        if (isWidthTooSmall()) {
            float frameW2 = this.mMinFrameSize - getFrameW();
            this.mFrameRect.right += frameW2;
            float ratioY2 = (frameW2 * getRatioY()) / getRatioX();
            this.mFrameRect.top -= ratioY2;
        }
        if (isHeightTooSmall()) {
            float frameH2 = this.mMinFrameSize - getFrameH();
            this.mFrameRect.top -= frameH2;
            float ratioX = (frameH2 * getRatioX()) / getRatioY();
            this.mFrameRect.right += ratioX;
        }
        if (!isInsideHorizontal(this.mFrameRect.right)) {
            RectF rectF3 = this.mFrameRect;
            float f3 = rectF3.right;
            float f4 = f3 - this.mImageRect.right;
            rectF3.right = f3 - f4;
            float ratioY3 = (f4 * getRatioY()) / getRatioX();
            this.mFrameRect.top += ratioY3;
        }
        if (!isInsideVertical(this.mFrameRect.top)) {
            float f5 = this.mImageRect.top;
            RectF rectF4 = this.mFrameRect;
            float f6 = rectF4.top;
            float f7 = f5 - f6;
            rectF4.top = f6 + f7;
            float ratioX2 = (f7 * getRatioX()) / getRatioY();
            this.mFrameRect.right -= ratioX2;
        }
    }

    private void moveHandleLB(float f, float f2) {
        if (this.mCropMode == CropMode.FREE) {
            RectF rectF = this.mFrameRect;
            rectF.left += f;
            rectF.bottom += f2;
            if (isWidthTooSmall()) {
                float frameW = this.mMinFrameSize - getFrameW();
                this.mFrameRect.left -= frameW;
            }
            if (isHeightTooSmall()) {
                float frameH = this.mMinFrameSize - getFrameH();
                this.mFrameRect.bottom += frameH;
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        RectF rectF2 = this.mFrameRect;
        rectF2.left += f;
        rectF2.bottom -= ratioY;
        if (isWidthTooSmall()) {
            float frameW2 = this.mMinFrameSize - getFrameW();
            this.mFrameRect.left -= frameW2;
            float ratioY2 = (frameW2 * getRatioY()) / getRatioX();
            this.mFrameRect.bottom += ratioY2;
        }
        if (isHeightTooSmall()) {
            float frameH2 = this.mMinFrameSize - getFrameH();
            this.mFrameRect.bottom += frameH2;
            float ratioX = (frameH2 * getRatioX()) / getRatioY();
            this.mFrameRect.left -= ratioX;
        }
        if (!isInsideHorizontal(this.mFrameRect.left)) {
            float f3 = this.mImageRect.left;
            RectF rectF3 = this.mFrameRect;
            float f4 = rectF3.left;
            float f5 = f3 - f4;
            rectF3.left = f4 + f5;
            float ratioY3 = (f5 * getRatioY()) / getRatioX();
            this.mFrameRect.bottom -= ratioY3;
        }
        if (!isInsideVertical(this.mFrameRect.bottom)) {
            RectF rectF4 = this.mFrameRect;
            float f6 = rectF4.bottom;
            float f7 = f6 - this.mImageRect.bottom;
            rectF4.bottom = f6 - f7;
            float ratioX2 = (f7 * getRatioX()) / getRatioY();
            this.mFrameRect.left += ratioX2;
        }
    }

    private void moveHandleRB(float f, float f2) {
        if (this.mCropMode == CropMode.FREE) {
            RectF rectF = this.mFrameRect;
            rectF.right += f;
            rectF.bottom += f2;
            if (isWidthTooSmall()) {
                float frameW = this.mMinFrameSize - getFrameW();
                this.mFrameRect.right += frameW;
            }
            if (isHeightTooSmall()) {
                float frameH = this.mMinFrameSize - getFrameH();
                this.mFrameRect.bottom += frameH;
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        RectF rectF2 = this.mFrameRect;
        rectF2.right += f;
        rectF2.bottom += ratioY;
        if (isWidthTooSmall()) {
            float frameW2 = this.mMinFrameSize - getFrameW();
            this.mFrameRect.right += frameW2;
            float ratioY2 = (frameW2 * getRatioY()) / getRatioX();
            this.mFrameRect.bottom += ratioY2;
        }
        if (isHeightTooSmall()) {
            float frameH2 = this.mMinFrameSize - getFrameH();
            this.mFrameRect.bottom += frameH2;
            float ratioX = (frameH2 * getRatioX()) / getRatioY();
            this.mFrameRect.right += ratioX;
        }
        if (!isInsideHorizontal(this.mFrameRect.right)) {
            RectF rectF3 = this.mFrameRect;
            float f3 = rectF3.right;
            float f4 = f3 - this.mImageRect.right;
            rectF3.right = f3 - f4;
            float ratioY3 = (f4 * getRatioY()) / getRatioX();
            this.mFrameRect.bottom -= ratioY3;
        }
        if (!isInsideVertical(this.mFrameRect.bottom)) {
            RectF rectF4 = this.mFrameRect;
            float f5 = rectF4.bottom;
            float f6 = f5 - this.mImageRect.bottom;
            rectF4.bottom = f5 - f6;
            float ratioX2 = (f6 * getRatioX()) / getRatioY();
            this.mFrameRect.right -= ratioX2;
        }
    }

    private void checkScaleBounds() {
        RectF rectF = this.mFrameRect;
        float f = rectF.left;
        RectF rectF2 = this.mImageRect;
        float f2 = f - rectF2.left;
        float f3 = rectF.right - rectF2.right;
        float f4 = rectF.top - rectF2.top;
        float f5 = rectF.bottom - rectF2.bottom;
        if (f2 < 0.0f) {
            rectF.left = f - f2;
        }
        if (f3 > 0.0f) {
            this.mFrameRect.right -= f3;
        }
        if (f4 < 0.0f) {
            this.mFrameRect.top -= f4;
        }
        if (f5 > 0.0f) {
            this.mFrameRect.bottom -= f5;
        }
    }

    private void checkMoveBounds() {
        RectF rectF = this.mFrameRect;
        float f = rectF.left;
        float f2 = f - this.mImageRect.left;
        if (f2 < 0.0f) {
            rectF.left = f - f2;
            rectF.right -= f2;
        }
        RectF rectF2 = this.mFrameRect;
        float f3 = rectF2.right;
        float f4 = f3 - this.mImageRect.right;
        if (f4 > 0.0f) {
            rectF2.left -= f4;
            rectF2.right = f3 - f4;
        }
        RectF rectF3 = this.mFrameRect;
        float f5 = rectF3.top;
        float f6 = f5 - this.mImageRect.top;
        if (f6 < 0.0f) {
            rectF3.top = f5 - f6;
            rectF3.bottom -= f6;
        }
        RectF rectF4 = this.mFrameRect;
        float f7 = rectF4.bottom;
        float f8 = f7 - this.mImageRect.bottom;
        if (f8 > 0.0f) {
            rectF4.top -= f8;
            rectF4.bottom = f7 - f8;
        }
    }

    private boolean isInsideHorizontal(float f) {
        RectF rectF = this.mImageRect;
        return rectF.left <= f && rectF.right >= f;
    }

    private boolean isInsideVertical(float f) {
        RectF rectF = this.mImageRect;
        return rectF.top <= f && rectF.bottom >= f;
    }

    private boolean isWidthTooSmall() {
        return getFrameW() < this.mMinFrameSize;
    }

    private boolean isHeightTooSmall() {
        return getFrameH() < this.mMinFrameSize;
    }

    private void recalculateFrameRect(int i) {
        if (this.mImageRect != null) {
            if (this.mIsAnimating) {
                getAnimator().cancelAnimation();
            }
            final RectF rectF = new RectF(this.mFrameRect);
            final RectF calcFrameRect = calcFrameRect(this.mImageRect);
            final float f = calcFrameRect.left - rectF.left;
            final float f2 = calcFrameRect.top - rectF.top;
            final float f3 = calcFrameRect.right - rectF.right;
            final float f4 = calcFrameRect.bottom - rectF.bottom;
            if (this.mIsAnimationEnabled) {
                SimpleValueAnimator animator = getAnimator();
                AnonymousClass1 r1 = new SimpleValueAnimatorListener() {
                    public void onAnimationStarted() {
                        CropImageView.this.mIsAnimating = true;
                    }

                    public void onAnimationUpdated(float f) {
                        CropImageView cropImageView = CropImageView.this;
                        RectF rectF = rectF;
                        cropImageView.mFrameRect = new RectF(rectF.left + (f * f), rectF.top + (f2 * f), rectF.right + (f3 * f), rectF.bottom + (f4 * f));
                        CropImageView.this.invalidate();
                    }

                    public void onAnimationFinished() {
                        CropImageView.this.mFrameRect = calcFrameRect;
                        CropImageView.this.invalidate();
                        CropImageView.this.mIsAnimating = false;
                    }
                };
                animator.addAnimatorListener(r1);
                animator.startAnimation((long) i);
            } else {
                this.mFrameRect = calcFrameRect(this.mImageRect);
                invalidate();
            }
        }
    }

    private float getRatioX(float f) {
        switch (AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode[this.mCropMode.ordinal()]) {
            case 1:
                return this.mImageRect.width();
            case 2:
                break;
            case 3:
                f = 4.0f;
                break;
            case 4:
                return 3.0f;
            case 5:
                return 16.0f;
            case 6:
                return 9.0f;
            case 7:
            case 8:
            case 9:
                return 1.0f;
            case 10:
                return this.mCustomRatio.x;
            default:
                return f;
        }
        return f;
    }

    private float getRatioY(float f) {
        switch (AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode[this.mCropMode.ordinal()]) {
            case 1:
                return this.mImageRect.height();
            case 2:
                break;
            case 3:
                f = 3.0f;
                break;
            case 4:
                return 4.0f;
            case 5:
                return 9.0f;
            case 6:
                return 16.0f;
            case 7:
            case 8:
            case 9:
                return 1.0f;
            case 10:
                return this.mCustomRatio.y;
            default:
                return f;
        }
        return f;
    }

    private float getRatioX() {
        switch (AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode[this.mCropMode.ordinal()]) {
            case 1:
                return this.mImageRect.width();
            case 3:
                return 4.0f;
            case 4:
                return 3.0f;
            case 5:
                return 16.0f;
            case 6:
                return 9.0f;
            case 7:
            case 8:
            case 9:
                return 1.0f;
            case 10:
                return this.mCustomRatio.x;
            default:
                return 1.0f;
        }
    }

    private float getRatioY() {
        switch (AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$CropMode[this.mCropMode.ordinal()]) {
            case 1:
                return this.mImageRect.height();
            case 3:
                return 3.0f;
            case 4:
                return 4.0f;
            case 5:
                return 9.0f;
            case 6:
                return 16.0f;
            case 7:
            case 8:
            case 9:
                return 1.0f;
            case 10:
                return this.mCustomRatio.y;
            default:
                return 1.0f;
        }
    }

    private float getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /* access modifiers changed from: private */
    public void postErrorOnMainThread(final Callback callback, final Throwable th) {
        if (callback != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                callback.onError(th);
            } else {
                this.mHandler.post(new Runnable(this) {
                    public void run() {
                        callback.onError(th);
                    }
                });
            }
        }
    }

    private Bitmap getBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private float getRotatedWidth(float f) {
        return getRotatedWidth(f, this.mImgWidth, this.mImgHeight);
    }

    private float getRotatedHeight(float f) {
        return getRotatedHeight(f, this.mImgWidth, this.mImgHeight);
    }

    private Bitmap getRotatedBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setRotate(this.mAngle, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private SimpleValueAnimator getAnimator() {
        setupAnimatorIfNeeded();
        return this.mAnimator;
    }

    private void setupAnimatorIfNeeded() {
        if (this.mAnimator != null) {
            return;
        }
        if (VERSION.SDK_INT < 14) {
            this.mAnimator = new ValueAnimatorV8(this.mInterpolator);
        } else {
            this.mAnimator = new ValueAnimatorV14(this.mInterpolator);
        }
    }

    private Bitmap getCroppedBitmapFromUri() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = getContext().getContentResolver().openInputStream(this.mSourceUri);
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            int width = newInstance.getWidth();
            int height = newInstance.getHeight();
            Rect calcCropRect = calcCropRect(width, height);
            if (this.mAngle != 0.0f) {
                Matrix matrix = new Matrix();
                matrix.setRotate(-this.mAngle);
                RectF rectF = new RectF();
                matrix.mapRect(rectF, new RectF(calcCropRect));
                rectF.offset(rectF.left < 0.0f ? (float) width : 0.0f, rectF.top < 0.0f ? (float) height : 0.0f);
                calcCropRect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            }
            Bitmap decodeRegion = newInstance.decodeRegion(calcCropRect, new Options());
            if (this.mAngle != 0.0f) {
                Bitmap rotatedBitmap = getRotatedBitmap(decodeRegion);
                if (!(decodeRegion == getBitmap() || decodeRegion == rotatedBitmap)) {
                    decodeRegion.recycle();
                }
                decodeRegion = rotatedBitmap;
            }
            return decodeRegion;
        } finally {
            Utils.closeQuietly(inputStream);
        }
    }

    private Rect calcCropRect(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        float rotatedWidth = getRotatedWidth(this.mAngle, f, f2) / this.mImageRect.width();
        RectF rectF = this.mImageRect;
        float f3 = rectF.left * rotatedWidth;
        float f4 = rectF.top * rotatedWidth;
        int round = Math.round((this.mFrameRect.left * rotatedWidth) - f3);
        int round2 = Math.round((this.mFrameRect.top * rotatedWidth) - f4);
        int round3 = Math.round((this.mFrameRect.right * rotatedWidth) - f3);
        int round4 = Math.round((this.mFrameRect.bottom * rotatedWidth) - f4);
        return new Rect(Math.max(round, 0), Math.max(round2, 0), Math.min(round3, Math.round(getRotatedWidth(this.mAngle, f, f2))), Math.min(round4, Math.round(getRotatedHeight(this.mAngle, f, f2))));
    }

    private Bitmap scaleBitmapIfNeeded(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float ratioX = getRatioX(this.mFrameRect.width()) / getRatioY(this.mFrameRect.height());
        int i = this.mOutputWidth;
        int i2 = 0;
        if (i > 0) {
            i2 = Math.round(((float) i) / ratioX);
        } else {
            int i3 = this.mOutputHeight;
            if (i3 > 0) {
                i2 = i3;
                i = Math.round(((float) i3) * ratioX);
            } else {
                int i4 = this.mOutputMaxWidth;
                if (i4 > 0) {
                    int i5 = this.mOutputMaxHeight;
                    if (i5 > 0 && (width > i4 || height > i5)) {
                        i = this.mOutputMaxWidth;
                        float f = (float) i;
                        i2 = this.mOutputMaxHeight;
                        if (f / ((float) i2) >= ratioX) {
                            i = Math.round(((float) i2) * ratioX);
                        } else {
                            i2 = Math.round(((float) i) / ratioX);
                        }
                    }
                }
                i = 0;
            }
        }
        if (i <= 0 || i2 <= 0) {
            return bitmap;
        }
        Bitmap scaledBitmap = Utils.getScaledBitmap(bitmap, i, i2);
        if (!(bitmap == getBitmap() || bitmap == scaledBitmap)) {
            bitmap.recycle();
        }
        return scaledBitmap;
    }

    /* access modifiers changed from: private */
    public Uri saveImage(Bitmap bitmap, Uri uri) throws IOException, IllegalStateException {
        this.mSaveUri = uri;
        if (this.mSaveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContext().getContentResolver().openOutputStream(uri);
                bitmap.compress(this.mCompressFormat, this.mCompressQuality, outputStream);
                Utils.copyExifInfo(getContext(), this.mSourceUri, uri, bitmap.getWidth(), bitmap.getHeight());
                Utils.updateGalleryInfo(getContext(), uri);
                return uri;
            } finally {
                Utils.closeQuietly(outputStream);
            }
        } else {
            throw new IllegalStateException("Save uri must not be null.");
        }
    }

    public Bitmap getImageBitmap() {
        return getBitmap();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageResource(int i) {
        this.mIsInitialized = false;
        resetImageInfo();
        super.setImageResource(i);
        updateLayout();
    }

    public void setImageDrawable(Drawable drawable) {
        this.mIsInitialized = false;
        resetImageInfo();
        setImageDrawableInternal(drawable);
    }

    /* access modifiers changed from: private */
    public void setImageDrawableInternal(Drawable drawable) {
        super.setImageDrawable(drawable);
        updateLayout();
    }

    public void setImageURI(Uri uri) {
        this.mIsInitialized = false;
        super.setImageURI(uri);
        updateLayout();
    }

    private void updateLayout() {
        if (getDrawable() != null) {
            setupLayout(this.mViewWidth, this.mViewHeight);
        }
    }

    private void resetImageInfo() {
        if (!this.mIsLoading.get()) {
            this.mSourceUri = null;
            this.mSaveUri = null;
            this.mInputImageWidth = 0;
            this.mInputImageHeight = 0;
            this.mOutputImageWidth = 0;
            this.mOutputImageHeight = 0;
            this.mAngle = (float) this.mExifRotation;
        }
    }

    public void startLoad(Uri uri, LoadCallback loadCallback) {
        loadAsync(uri, loadCallback);
    }

    public void loadAsync(Uri uri, LoadCallback loadCallback) {
        loadAsync(uri, false, null, loadCallback);
    }

    public void loadAsync(Uri uri, boolean z, RectF rectF, LoadCallback loadCallback) {
        ExecutorService executorService = this.mExecutor;
        final Uri uri2 = uri;
        final RectF rectF2 = rectF;
        final boolean z2 = z;
        final LoadCallback loadCallback2 = loadCallback;
        AnonymousClass3 r1 = new Runnable() {
            public void run() {
                try {
                    CropImageView.this.mIsLoading.set(true);
                    CropImageView.this.mSourceUri = uri2;
                    CropImageView.this.mInitialFrameRect = rectF2;
                    if (z2) {
                        CropImageView.this.applyThumbnail(uri2);
                    }
                    final Bitmap access$600 = CropImageView.this.getImage(uri2);
                    CropImageView.this.mHandler.post(new Runnable() {
                        public void run() {
                            CropImageView cropImageView = CropImageView.this;
                            cropImageView.mAngle = (float) cropImageView.mExifRotation;
                            CropImageView cropImageView2 = CropImageView.this;
                            cropImageView2.setImageDrawableInternal(new BitmapDrawable(cropImageView2.getResources(), access$600));
                            LoadCallback loadCallback = loadCallback2;
                            if (loadCallback != null) {
                                loadCallback.onSuccess();
                            }
                        }
                    });
                } catch (Exception e) {
                    CropImageView.this.postErrorOnMainThread(loadCallback2, e);
                } catch (Throwable th) {
                    CropImageView.this.mIsLoading.set(false);
                    throw th;
                }
                CropImageView.this.mIsLoading.set(false);
            }
        };
        executorService.submit(r1);
    }

    public Completable loadAsCompletable(Uri uri) {
        return loadAsCompletable(uri, false, null);
    }

    public Completable loadAsCompletable(final Uri uri, final boolean z, final RectF rectF) {
        return Completable.create(new CompletableOnSubscribe() {
            public void subscribe(final CompletableEmitter completableEmitter) throws Exception {
                CropImageView.this.mInitialFrameRect = rectF;
                CropImageView.this.mSourceUri = uri;
                if (z) {
                    CropImageView.this.applyThumbnail(uri);
                }
                final Bitmap access$600 = CropImageView.this.getImage(uri);
                CropImageView.this.mHandler.post(new Runnable() {
                    public void run() {
                        CropImageView cropImageView = CropImageView.this;
                        cropImageView.mAngle = (float) cropImageView.mExifRotation;
                        CropImageView cropImageView2 = CropImageView.this;
                        cropImageView2.setImageDrawableInternal(new BitmapDrawable(cropImageView2.getResources(), access$600));
                        completableEmitter.onComplete();
                    }
                });
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            public void accept(Disposable disposable) throws Exception {
                CropImageView.this.mIsLoading.set(true);
            }
        }).doFinally(new Action() {
            public void run() throws Exception {
                CropImageView.this.mIsLoading.set(false);
            }
        });
    }

    public LoadRequest load(Uri uri) {
        return new LoadRequest(this, uri);
    }

    /* access modifiers changed from: private */
    public void applyThumbnail(Uri uri) {
        final Bitmap thumbnail = getThumbnail(uri);
        if (thumbnail != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    CropImageView cropImageView = CropImageView.this;
                    cropImageView.mAngle = (float) cropImageView.mExifRotation;
                    CropImageView cropImageView2 = CropImageView.this;
                    cropImageView2.setImageDrawableInternal(new BitmapDrawable(cropImageView2.getResources(), thumbnail));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public Bitmap getImage(Uri uri) {
        if (uri != null) {
            this.mExifRotation = Utils.getExifOrientation(getContext(), this.mSourceUri);
            int maxSize = Utils.getMaxSize();
            int max = Math.max(this.mViewWidth, this.mViewHeight);
            if (max != 0) {
                maxSize = max;
            }
            Bitmap decodeSampledBitmapFromUri = Utils.decodeSampledBitmapFromUri(getContext(), this.mSourceUri, maxSize);
            this.mInputImageWidth = Utils.sInputImageWidth;
            this.mInputImageHeight = Utils.sInputImageHeight;
            return decodeSampledBitmapFromUri;
        }
        throw new IllegalStateException("Source Uri must not be null.");
    }

    private Bitmap getThumbnail(Uri uri) {
        if (uri != null) {
            this.mExifRotation = Utils.getExifOrientation(getContext(), this.mSourceUri);
            int max = (int) (((float) Math.max(this.mViewWidth, this.mViewHeight)) * 0.1f);
            if (max == 0) {
                return null;
            }
            Bitmap decodeSampledBitmapFromUri = Utils.decodeSampledBitmapFromUri(getContext(), this.mSourceUri, max);
            this.mInputImageWidth = Utils.sInputImageWidth;
            this.mInputImageHeight = Utils.sInputImageHeight;
            return decodeSampledBitmapFromUri;
        }
        throw new IllegalStateException("Source Uri must not be null.");
    }

    public void rotateImage(RotateDegrees rotateDegrees, int i) {
        if (this.mIsRotating) {
            getAnimator().cancelAnimation();
        }
        final float f = this.mAngle;
        final float value = f + ((float) rotateDegrees.getValue());
        final float f2 = value - f;
        final float f3 = this.mScale;
        final float calcScale = calcScale(this.mViewWidth, this.mViewHeight, value);
        if (this.mIsAnimationEnabled) {
            final float f4 = calcScale - f3;
            SimpleValueAnimator animator = getAnimator();
            AnonymousClass8 r1 = new SimpleValueAnimatorListener() {
                public void onAnimationStarted() {
                    CropImageView.this.mIsRotating = true;
                }

                public void onAnimationUpdated(float f) {
                    CropImageView.this.mAngle = f + (f2 * f);
                    CropImageView.this.mScale = f3 + (f4 * f);
                    CropImageView.this.setMatrix();
                    CropImageView.this.invalidate();
                }

                public void onAnimationFinished() {
                    CropImageView.this.mAngle = value % 360.0f;
                    CropImageView.this.mScale = calcScale;
                    CropImageView.this.mInitialFrameRect = null;
                    CropImageView cropImageView = CropImageView.this;
                    cropImageView.setupLayout(cropImageView.mViewWidth, CropImageView.this.mViewHeight);
                    CropImageView.this.mIsRotating = false;
                }
            };
            animator.addAnimatorListener(r1);
            animator.startAnimation((long) i);
            return;
        }
        this.mAngle = value % 360.0f;
        this.mScale = calcScale;
        setupLayout(this.mViewWidth, this.mViewHeight);
    }

    public void rotateImage(RotateDegrees rotateDegrees) {
        rotateImage(rotateDegrees, this.mAnimationDurationMillis);
    }

    public Bitmap getCroppedBitmap() {
        Bitmap bitmap;
        Bitmap bitmap2 = getBitmap();
        if (bitmap2 == null) {
            return null;
        }
        Bitmap rotatedBitmap = getRotatedBitmap(bitmap2);
        Rect calcCropRect = calcCropRect(bitmap2.getWidth(), bitmap2.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(rotatedBitmap, calcCropRect.left, calcCropRect.top, calcCropRect.width(), calcCropRect.height(), null, false);
        if (!(rotatedBitmap == createBitmap || rotatedBitmap == bitmap2)) {
            rotatedBitmap.recycle();
        }
        if (this.mCropMode == CropMode.CIRCLE) {
            bitmap = getCircularBitmap(createBitmap);
            if (createBitmap != getBitmap()) {
                createBitmap.recycle();
            }
        } else {
            bitmap = createBitmap;
        }
        return bitmap;
    }

    public Bitmap getCircularBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public void startCrop(final Uri uri, final CropCallback cropCallback, final SaveCallback saveCallback) {
        this.mExecutor.submit(new Runnable() {
            public void run() {
                final Bitmap bitmap = null;
                try {
                    CropImageView.this.mIsCropping.set(true);
                    bitmap = CropImageView.this.cropImage();
                    CropImageView.this.mHandler.post(new Runnable() {
                        public void run() {
                            CropCallback cropCallback = cropCallback;
                            if (cropCallback != null) {
                                cropCallback.onSuccess(bitmap);
                            }
                            if (CropImageView.this.mIsDebug) {
                                CropImageView.this.invalidate();
                            }
                        }
                    });
                    CropImageView.this.saveImage(bitmap, uri);
                    CropImageView.this.mHandler.post(new Runnable() {
                        public void run() {
                            AnonymousClass9 r0 = AnonymousClass9.this;
                            SaveCallback saveCallback = saveCallback;
                            if (saveCallback != null) {
                                saveCallback.onSuccess(uri);
                            }
                        }
                    });
                } catch (Exception e) {
                    if (bitmap == null) {
                        CropImageView.this.postErrorOnMainThread(cropCallback, e);
                    } else {
                        CropImageView.this.postErrorOnMainThread(saveCallback, e);
                    }
                } catch (Throwable th) {
                    CropImageView.this.mIsCropping.set(false);
                    throw th;
                }
                CropImageView.this.mIsCropping.set(false);
            }
        });
    }

    public void cropAsync(final Uri uri, final CropCallback cropCallback) {
        this.mExecutor.submit(new Runnable() {
            public void run() {
                try {
                    CropImageView.this.mIsCropping.set(true);
                    if (uri != null) {
                        CropImageView.this.mSourceUri = uri;
                    }
                    final Bitmap access$1900 = CropImageView.this.cropImage();
                    CropImageView.this.mHandler.post(new Runnable() {
                        public void run() {
                            CropCallback cropCallback = cropCallback;
                            if (cropCallback != null) {
                                cropCallback.onSuccess(access$1900);
                            }
                            if (CropImageView.this.mIsDebug) {
                                CropImageView.this.invalidate();
                            }
                        }
                    });
                } catch (Exception e) {
                    CropImageView.this.postErrorOnMainThread(cropCallback, e);
                } catch (Throwable th) {
                    CropImageView.this.mIsCropping.set(false);
                    throw th;
                }
                CropImageView.this.mIsCropping.set(false);
            }
        });
    }

    public void cropAsync(CropCallback cropCallback) {
        cropAsync(null, cropCallback);
    }

    public Single<Bitmap> cropAsSingle(final Uri uri) {
        return Single.fromCallable(new Callable<Bitmap>() {
            public Bitmap call() throws Exception {
                Uri uri = uri;
                if (uri != null) {
                    CropImageView.this.mSourceUri = uri;
                }
                return CropImageView.this.cropImage();
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            public void accept(Disposable disposable) throws Exception {
                CropImageView.this.mIsCropping.set(true);
            }
        }).doFinally(new Action() {
            public void run() throws Exception {
                CropImageView.this.mIsCropping.set(false);
            }
        });
    }

    public Single<Bitmap> cropAsSingle() {
        return cropAsSingle(null);
    }

    public CropRequest crop(Uri uri) {
        return new CropRequest(this, uri);
    }

    public void saveAsync(final Uri uri, final Bitmap bitmap, final SaveCallback saveCallback) {
        this.mExecutor.submit(new Runnable() {
            public void run() {
                try {
                    CropImageView.this.mIsSaving.set(true);
                    CropImageView.this.saveImage(bitmap, uri);
                    CropImageView.this.mHandler.post(new Runnable() {
                        public void run() {
                            AnonymousClass14 r0 = AnonymousClass14.this;
                            SaveCallback saveCallback = saveCallback;
                            if (saveCallback != null) {
                                saveCallback.onSuccess(uri);
                            }
                        }
                    });
                } catch (Exception e) {
                    CropImageView.this.postErrorOnMainThread(saveCallback, e);
                } catch (Throwable th) {
                    CropImageView.this.mIsSaving.set(false);
                    throw th;
                }
                CropImageView.this.mIsSaving.set(false);
            }
        });
    }

    public Single<Uri> saveAsSingle(final Bitmap bitmap, final Uri uri) {
        return Single.fromCallable(new Callable<Uri>() {
            public Uri call() throws Exception {
                CropImageView cropImageView = CropImageView.this;
                Bitmap bitmap = bitmap;
                Uri uri = uri;
                cropImageView.saveImage(bitmap, uri);
                return uri;
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            public void accept(Disposable disposable) throws Exception {
                CropImageView.this.mIsSaving.set(true);
            }
        }).doFinally(new Action() {
            public void run() throws Exception {
                CropImageView.this.mIsSaving.set(false);
            }
        });
    }

    public SaveRequest save(Bitmap bitmap) {
        return new SaveRequest(this, bitmap);
    }

    /* access modifiers changed from: private */
    public Bitmap cropImage() throws IOException, IllegalStateException {
        Bitmap bitmap;
        if (this.mSourceUri == null) {
            bitmap = getCroppedBitmap();
        } else {
            bitmap = getCroppedBitmapFromUri();
            if (this.mCropMode == CropMode.CIRCLE) {
                Bitmap circularBitmap = getCircularBitmap(bitmap);
                if (bitmap != getBitmap()) {
                    bitmap.recycle();
                }
                bitmap = circularBitmap;
            }
        }
        Bitmap scaleBitmapIfNeeded = scaleBitmapIfNeeded(bitmap);
        this.mOutputImageWidth = scaleBitmapIfNeeded.getWidth();
        this.mOutputImageHeight = scaleBitmapIfNeeded.getHeight();
        return scaleBitmapIfNeeded;
    }

    public RectF getActualCropRect() {
        RectF rectF = this.mImageRect;
        float f = rectF.left;
        float f2 = this.mScale;
        float f3 = f / f2;
        float f4 = rectF.top / f2;
        RectF rectF2 = this.mFrameRect;
        return new RectF(Math.max(0.0f, (rectF2.left / f2) - f3), Math.max(0.0f, (rectF2.top / f2) - f4), Math.min(this.mImageRect.right / this.mScale, (rectF2.right / f2) - f3), Math.min(this.mImageRect.bottom / this.mScale, (rectF2.bottom / f2) - f4));
    }

    private RectF applyInitialFrameRect(RectF rectF) {
        RectF rectF2 = new RectF();
        float f = rectF.left;
        float f2 = this.mScale;
        rectF2.set(f * f2, rectF.top * f2, rectF.right * f2, rectF.bottom * f2);
        RectF rectF3 = this.mImageRect;
        rectF2.offset(rectF3.left, rectF3.top);
        rectF2.set(Math.max(this.mImageRect.left, rectF2.left), Math.max(this.mImageRect.top, rectF2.top), Math.min(this.mImageRect.right, rectF2.right), Math.min(this.mImageRect.bottom, rectF2.bottom));
        return rectF2;
    }

    public void setCropMode(CropMode cropMode, int i) {
        if (cropMode == CropMode.CUSTOM) {
            setCustomRatio(1, 1);
            return;
        }
        this.mCropMode = cropMode;
        recalculateFrameRect(i);
    }

    public void setCropMode(CropMode cropMode) {
        setCropMode(cropMode, this.mAnimationDurationMillis);
    }

    public void setCustomRatio(int i, int i2, int i3) {
        if (i != 0 && i2 != 0) {
            this.mCropMode = CropMode.CUSTOM;
            this.mCustomRatio = new PointF((float) i, (float) i2);
            recalculateFrameRect(i3);
        }
    }

    public void setCustomRatio(int i, int i2) {
        setCustomRatio(i, i2, this.mAnimationDurationMillis);
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        invalidate();
    }

    public void setFrameColor(int i) {
        this.mFrameColor = i;
        invalidate();
    }

    public void setHandleColor(int i) {
        this.mHandleColor = i;
        invalidate();
    }

    public void setGuideColor(int i) {
        this.mGuideColor = i;
        invalidate();
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        invalidate();
    }

    public void setMinFrameSizeInDp(int i) {
        this.mMinFrameSize = ((float) i) * getDensity();
    }

    public void setMinFrameSizeInPx(int i) {
        this.mMinFrameSize = (float) i;
    }

    public void setHandleSizeInDp(int i) {
        this.mHandleSize = (int) (((float) i) * getDensity());
    }

    public void setTouchPaddingInDp(int i) {
        this.mTouchPadding = (int) (((float) i) * getDensity());
    }

    public void setGuideShowMode(ShowMode showMode) {
        this.mGuideShowMode = showMode;
        int i = AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode[showMode.ordinal()];
        if (i == 1) {
            this.mShowGuide = true;
        } else if (i == 2 || i == 3) {
            this.mShowGuide = false;
        }
        invalidate();
    }

    public void setHandleShowMode(ShowMode showMode) {
        this.mHandleShowMode = showMode;
        int i = AnonymousClass18.$SwitchMap$com$isseiaoki$simplecropview$CropImageView$ShowMode[showMode.ordinal()];
        if (i == 1) {
            this.mShowHandle = true;
        } else if (i == 2 || i == 3) {
            this.mShowHandle = false;
        }
        invalidate();
    }

    public void setFrameStrokeWeightInDp(int i) {
        this.mFrameStrokeWeight = ((float) i) * getDensity();
        invalidate();
    }

    public void setGuideStrokeWeightInDp(int i) {
        this.mGuideStrokeWeight = ((float) i) * getDensity();
        invalidate();
    }

    public void setCropEnabled(boolean z) {
        this.mIsCropEnabled = z;
        invalidate();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mIsEnabled = z;
    }

    public void setInitialFrameScale(float f) {
        this.mInitialFrameScale = constrain(f, 0.01f, 1.0f, 1.0f);
    }

    public void setAnimationEnabled(boolean z) {
        this.mIsAnimationEnabled = z;
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDurationMillis = i;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        this.mAnimator = null;
        setupAnimatorIfNeeded();
    }

    public void setDebug(boolean z) {
        this.mIsDebug = z;
        Logger.enabled = true;
        invalidate();
    }

    public void setLoggingEnabled(boolean z) {
        Logger.enabled = z;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
        this.mOutputHeight = 0;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
        this.mOutputWidth = 0;
    }

    public void setOutputMaxSize(int i, int i2) {
        this.mOutputMaxWidth = i;
        this.mOutputMaxHeight = i2;
    }

    public void setCompressFormat(CompressFormat compressFormat) {
        this.mCompressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.mCompressQuality = i;
    }

    public void setHandleShadowEnabled(boolean z) {
        this.mIsHandleShadowEnabled = z;
    }

    public boolean isCropping() {
        return this.mIsCropping.get();
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public Uri getSaveUri() {
        return this.mSaveUri;
    }

    public boolean isSaving() {
        return this.mIsSaving.get();
    }

    private void setScale(float f) {
        this.mScale = f;
    }

    private void setCenter(PointF pointF) {
        this.mCenter = pointF;
    }

    private float getFrameW() {
        RectF rectF = this.mFrameRect;
        return rectF.right - rectF.left;
    }

    private float getFrameH() {
        RectF rectF = this.mFrameRect;
        return rectF.bottom - rectF.top;
    }
}
