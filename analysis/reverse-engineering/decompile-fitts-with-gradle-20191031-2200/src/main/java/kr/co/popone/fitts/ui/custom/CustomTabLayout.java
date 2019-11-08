package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.material.tabs.TabLayout;
import java.util.HashMap;
import kr.co.popone.fitts.C0006R$color;
import org.jetbrains.annotations.Nullable;

public final class CustomTabLayout extends TabLayout {
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

    public CustomTabLayout(@Nullable Context context) {
        super(context);
    }

    public CustomTabLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomTabLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTabTextColors(ContextCompat.getColor(getContext(), C0006R$color.gray6), ContextCompat.getColor(getContext(), C0006R$color.black));
        addOnTabSelectedListener(new CustomTabLayout$onAttachedToWindow$1(this));
    }
}
