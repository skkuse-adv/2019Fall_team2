package photopicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PreviewViewPager extends ViewPager {
    private HashMap _$_findViewCache;

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

    public PreviewViewPager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
    }

    public PreviewViewPager(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "ev");
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
