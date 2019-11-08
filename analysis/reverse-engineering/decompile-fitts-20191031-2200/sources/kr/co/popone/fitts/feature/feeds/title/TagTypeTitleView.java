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

public final class TagTypeTitleView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final TextView subtitleView;
    private final TextView titleView;
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

    public TagTypeTitleView(@NotNull Context context, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        this.view = LayoutInflater.from(context).inflate(C0013R$layout.item_tag_type_view, this);
        View view2 = this.view;
        String str3 = "view";
        Intrinsics.checkExpressionValueIsNotNull(view2, str3);
        this.titleView = (TextView) view2.findViewById(C0010R$id.tvTagTitle);
        View view3 = this.view;
        Intrinsics.checkExpressionValueIsNotNull(view3, str3);
        this.subtitleView = (TextView) view3.findViewById(C0010R$id.tvSubTagTitle);
        TextView textView = this.titleView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleView");
        textView.setText(str);
        TextView textView2 = this.subtitleView;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "subtitleView");
        textView2.setText(str2);
    }
}