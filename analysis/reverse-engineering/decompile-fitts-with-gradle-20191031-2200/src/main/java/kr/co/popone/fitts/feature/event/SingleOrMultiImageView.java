package kr.co.popone.fitts.feature.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.ui.ImageViewForList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SingleOrMultiImageView extends FrameLayout {
    private HashMap _$_findViewCache;
    private float imageRatio;
    @NotNull
    private final ImageViewForList imageView1;
    @NotNull
    private final ImageViewForList imageView2;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final ImageViewForList getImageView1() {
        return this.imageView1;
    }

    @NotNull
    public final ImageViewForList getImageView2() {
        return this.imageView2;
    }

    public final float getImageRatio() {
        return this.imageRatio;
    }

    public final void setImageRatio(float f) {
        this.imageRatio = f;
        requestLayout();
    }

    public SingleOrMultiImageView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public SingleOrMultiImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public SingleOrMultiImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.imageRatio = 1.0f;
        View inflate = LayoutInflater.from(context).inflate(C0013R$layout.view_collaborative_event_single_or_multi_imageview, this, true);
        View findViewById = inflate.findViewById(C0010R$id.imageView1);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.imageView1)");
        this.imageView1 = (ImageViewForList) findViewById;
        View findViewById2 = inflate.findViewById(C0010R$id.imageView2);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.imageView2)");
        this.imageView2 = (ImageViewForList) findViewById2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int roundToInt = MathKt__MathJVMKt.roundToInt(((float) defaultSize) / this.imageRatio);
        if (this.imageView2.getVisibility() == 0) {
            roundToInt /= 2;
        }
        setMeasuredDimension(defaultSize, roundToInt);
        Iterator it = RangesKt___RangesKt.until(0, getChildCount()).iterator();
        while (it.hasNext()) {
            getChildAt(((IntIterator) it).nextInt()).measure(MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), MeasureSpec.makeMeasureSpec(roundToInt, 1073741824));
        }
    }
}
