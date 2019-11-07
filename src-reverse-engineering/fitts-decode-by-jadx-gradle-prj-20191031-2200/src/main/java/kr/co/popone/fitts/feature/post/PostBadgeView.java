package kr.co.popone.fitts.feature.post;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.R$styleable;
import kr.co.popone.fitts.ui.DrawableExtensionsKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostBadgeView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final List<TextView> postBadges;
    private float textSize;

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

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f) {
        this.textSize = f;
        setTextSize(0, this.textSize);
    }

    public final void setTextSize(int i, float f) {
        for (TextView textSize2 : this.postBadges) {
            textSize2.setTextSize(i, f);
        }
    }

    public static /* synthetic */ void setBadgeVisible$default(PostBadgeView postBadgeView, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        if ((i & 8) != 0) {
            z4 = false;
        }
        if ((i & 16) != 0) {
            z5 = false;
        }
        postBadgeView.setBadgeVisible(z, z2, z3, z4, z5);
    }

    public final void setBadgeVisible(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.postBadgeBest);
        Intrinsics.checkExpressionValueIsNotNull(textView, "postBadgeBest");
        int i = 0;
        textView.setVisibility(z ? 0 : 8);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.postBadgeEditor);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "postBadgeEditor");
        textView2.setVisibility(z2 ? 0 : 8);
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.postBadgeStylelist);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "postBadgeStylelist");
        textView3.setVisibility(z3 ? 0 : 8);
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.postBadgePhotogenic);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "postBadgePhotogenic");
        textView4.setVisibility(z4 ? 0 : 8);
        TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.postBadgeDetailer);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "postBadgeDetailer");
        if (!z5) {
            i = 8;
        }
        textView5.setVisibility(i);
    }

    public PostBadgeView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public PostBadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public PostBadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.textSize = (float) ViewExtensionsKt.spToPx((View) this, 8.5f);
        LayoutInflater.from(context).inflate(C0013R$layout.view_post_badge, this, true);
        this.postBadges = CollectionsKt__CollectionsKt.listOf((TextView) _$_findCachedViewById(C0010R$id.postBadgeBest), (TextView) _$_findCachedViewById(C0010R$id.postBadgeEditor), (TextView) _$_findCachedViewById(C0010R$id.postBadgeStylelist), (TextView) _$_findCachedViewById(C0010R$id.postBadgePhotogenic), (TextView) _$_findCachedViewById(C0010R$id.postBadgeDetailer));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.postBadgeEditor);
        Intrinsics.checkExpressionValueIsNotNull(textView, "postBadgeEditor");
        Drawable mutate = textView.getBackground().mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate, "postBadgeEditor.background.mutate()");
        DrawableExtensionsKt.setFittsColor(mutate, ContextCompat.getColor(context, C0006R$color.gray6));
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.postBadgeStylelist);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "postBadgeStylelist");
        Drawable mutate2 = textView2.getBackground().mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate2, "postBadgeStylelist.background.mutate()");
        DrawableExtensionsKt.setFittsColor(mutate2, Color.parseColor("#be69a0"));
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.postBadgePhotogenic);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "postBadgePhotogenic");
        Drawable mutate3 = textView3.getBackground().mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate3, "postBadgePhotogenic.background.mutate()");
        DrawableExtensionsKt.setFittsColor(mutate3, Color.parseColor("#c0d625"));
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.postBadgeDetailer);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "postBadgeDetailer");
        Drawable mutate4 = textView4.getBackground().mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate4, "postBadgeDetailer.background.mutate()");
        DrawableExtensionsKt.setFittsColor(mutate4, Color.parseColor("#775347"));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PostBadgeView);
            try {
                setTextSize((float) obtainStyledAttributes.getDimensionPixelSize(0, ViewExtensionsKt.spToPx((View) this, 8.5f)));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setBadgeVisible$default(this, false, false, false, false, false, 31, null);
    }
}
