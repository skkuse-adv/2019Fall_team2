package kr.co.popone.fitts.feature.store.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreOptionSpinnerAdapter extends ArrayAdapter<String> {
    private final String[] objects;

    public StoreOptionSpinnerAdapter(@NotNull Context context, @Nullable String[] strArr) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, C0013R$layout.view_spinner_store_option_header, 0, strArr);
        this.objects = strArr;
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
        View inflate = LayoutInflater.from(getContext()).inflate(C0013R$layout.view_spinner_store_option_header, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C0010R$id.textCategoryName);
        if (i == 0) {
            textView.setTextColor(ContextCompat.getColor(getContext(), C0006R$color.gray3));
        } else {
            textView.setTextColor(ContextCompat.getColor(getContext(), C0006R$color.gray6));
        }
        Intrinsics.checkExpressionValueIsNotNull(textView, "textSubCategory");
        String[] strArr = this.objects;
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(strArr[i]);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return inflate;
    }

    private final View createViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(C0013R$layout.view_spinner_store_option_content, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C0010R$id.textCategoryName);
        if (i == 0) {
            textView.setTextColor(ContextCompat.getColor(getContext(), C0006R$color.gray3));
        } else {
            textView.setTextColor(ContextCompat.getColor(getContext(), C0006R$color.gray6));
        }
        Intrinsics.checkExpressionValueIsNotNull(textView, "textSubCategory");
        String[] strArr = this.objects;
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(strArr[i]);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return inflate;
    }
}
