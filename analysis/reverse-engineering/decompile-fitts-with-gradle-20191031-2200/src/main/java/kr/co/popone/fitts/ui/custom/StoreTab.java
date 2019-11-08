package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreTab extends FrameLayout {
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

    public StoreTab(@Nullable Context context, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        super(context);
        View inflate = LayoutInflater.from(context).inflate(C0013R$layout.view_store_tab, this, true);
        TextView textView = (TextView) inflate.findViewById(C0010R$id.tvTabTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvTabTitle");
        textView.setText(str);
        String str2 = "viewDot";
        if (z) {
            View findViewById = inflate.findViewById(C0010R$id.viewDot);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, str2);
            ViewExtensionsKt.visible(findViewById);
            return;
        }
        View findViewById2 = inflate.findViewById(C0010R$id.viewDot);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, str2);
        ViewExtensionsKt.gone(findViewById2);
    }

    public /* synthetic */ StoreTab(Context context, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            z = false;
        }
        this(context, str, z);
    }
}
