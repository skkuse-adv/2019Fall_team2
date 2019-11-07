package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.category.CategoryViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CustomIconSpinnerAdapter extends ArrayAdapter<CategoryViewData> {
    @Nullable
    private final CategoryViewData[] objects;

    @Nullable
    public final CategoryViewData[] getObjects() {
        return this.objects;
    }

    public CustomIconSpinnerAdapter(@NotNull Context context, @Nullable CategoryViewData[] categoryViewDataArr) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, C0013R$layout.view_custom_spinner_category_main, 0, categoryViewDataArr);
        this.objects = categoryViewDataArr;
    }

    @NotNull
    public View getView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        return createViewHeaderHolder(viewGroup, i);
    }

    @NotNull
    public View getDropDownView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        return createViewHolder(viewGroup, i);
    }

    private final View createViewHeaderHolder(ViewGroup viewGroup, int i) {
        String str;
        View inflate = LayoutInflater.from(getContext()).inflate(C0013R$layout.view_custom_spinner_category_main, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C0010R$id.textCategoryName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textSubCategory");
        CategoryViewData[] categoryViewDataArr = this.objects;
        if (categoryViewDataArr != null) {
            CategoryViewData categoryViewData = categoryViewDataArr[i];
            if (categoryViewData != null) {
                str = categoryViewData.getCategory();
                textView.setText(str);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
                return inflate;
            }
        }
        str = null;
        textView.setText(str);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return inflate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View createViewHolder(android.view.ViewGroup r4, int r5) {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2131558787(0x7f0d0183, float:1.87429E38)
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            r0 = 2131363065(0x7f0a04f9, float:1.8345928E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131362466(0x7f0a02a2, float:1.8344713E38)
            android.view.View r1 = r4.findViewById(r1)
            java.lang.String r2 = "textSubCategory"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            kr.co.popone.fitts.model.category.CategoryViewData[] r2 = r3.objects
            if (r2 == 0) goto L_0x0032
            r2 = r2[r5]
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = r2.getCategory()
            goto L_0x0033
        L_0x0032:
            r2 = 0
        L_0x0033:
            r0.setText(r2)
            int r0 = r3.getCount()
            int r0 = r0 + -1
            if (r5 != r0) goto L_0x0048
            java.lang.String r5 = "divider"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
            r5 = 8
            r1.setVisibility(r5)
        L_0x0048:
            java.lang.String r5 = "view"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.ui.custom.CustomIconSpinnerAdapter.createViewHolder(android.view.ViewGroup, int):android.view.View");
    }
}
