package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ScrollChildSwipeRefreshLayout extends SwipeRefreshLayout {
    private HashMap _$_findViewCache;
    private View mScrollUpChild;

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

    public ScrollChildSwipeRefreshLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
    }

    public ScrollChildSwipeRefreshLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public boolean canChildScrollUp() {
        View view = this.mScrollUpChild;
        return view != null ? view.canScrollVertically(-1) : super.canChildScrollUp();
    }

    public final void setScrollUpChild(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.mScrollUpChild = view;
    }
}
