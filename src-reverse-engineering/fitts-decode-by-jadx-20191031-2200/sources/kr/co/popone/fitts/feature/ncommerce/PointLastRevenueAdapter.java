package kr.co.popone.fitts.feature.ncommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.remote.user.NCommerce;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class PointLastRevenueAdapter extends Adapter<LastRevenueHolder> {
    @NotNull
    private List<NCommerce> items = new ArrayList();

    public final class LastRevenueHolder extends ViewHolder {
        public LastRevenueHolder(@NotNull PointLastRevenueAdapter pointLastRevenueAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
        }

        public final void bindTo(@NotNull NCommerce nCommerce, int i) {
            Intrinsics.checkParameterIsNotNull(nCommerce, "nCommerce");
            View view = this.itemView;
            if (i % 2 == 0) {
                ((LinearLayout) view.findViewById(C0010R$id.layoutContainer)).setBackgroundResource(0);
            } else {
                ((LinearLayout) view.findViewById(C0010R$id.layoutContainer)).setBackgroundResource(C0008R$drawable.background_round_transparent_gray1);
            }
            TextView textView = (TextView) view.findViewById(C0010R$id.textPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textPrice");
            textView.setText(IntExtensionsKt.commaString(nCommerce.getTotalPoint()));
            TextView textView2 = (TextView) view.findViewById(C0010R$id.textMonth);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textMonth");
            StringBuilder sb = new StringBuilder();
            sb.append(StringsKt__StringsJVMKt.replace$default(nCommerce.getMonth(), "-", "년 ", false, 4, (Object) null));
            sb.append(50900);
            textView2.setText(sb.toString());
        }
    }

    @NotNull
    public final List<NCommerce> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<NCommerce> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public LastRevenueHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_last_revenue, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new LastRevenueHolder(this, inflate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull LastRevenueHolder lastRevenueHolder, int i) {
        Intrinsics.checkParameterIsNotNull(lastRevenueHolder, "holder");
        lastRevenueHolder.bindTo((NCommerce) this.items.get(i), i);
    }
}
