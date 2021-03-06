package kr.co.popone.fitts.feature.feeds.title;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RightAlignTitleView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final TextView titleTextView;
    private final View view;

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
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public RightAlignTitleView(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        this.view = LayoutInflater.from(context).inflate(C0013R$layout.view_right_align_title, this);
        View view2 = this.view;
        Intrinsics.checkExpressionValueIsNotNull(view2, "view");
        this.titleTextView = (TextView) view2.findViewById(C0010R$id.tvTitle);
        TextView textView = this.titleTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleTextView");
        textView.setText(str);
    }
}
