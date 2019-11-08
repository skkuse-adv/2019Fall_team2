package kr.co.popone.fitts.feature.ncommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PointRevenueTopThreeAdapter extends Adapter<RevenueTopThreeHolder> {
    @NotNull
    private List<Post> items = new ArrayList();

    public final class RevenueTopThreeHolder extends ViewHolder {
        public RevenueTopThreeHolder(@NotNull PointRevenueTopThreeAdapter pointRevenueTopThreeAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
        }

        public final void bindTo(@NotNull Post post, int i) {
            Intrinsics.checkParameterIsNotNull(post, "post");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(C0010R$id.textProductName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textProductName");
            textView.setText(post.getTitle());
            ((TextView) view.findViewById(C0010R$id.textProductName)).setTextColor(ContextCompat.getColor(view.getContext(), C0006R$color.gray6));
            TextView textView2 = (TextView) view.findViewById(C0010R$id.textRanking);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textRanking");
            StringBuilder sb = new StringBuilder();
            sb.append(i + 1);
            sb.append(50948);
            textView2.setText(sb.toString());
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.iconMore);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "iconMore");
            imageView.setVisibility(0);
            view.setOnClickListener(new PointRevenueTopThreeAdapter$RevenueTopThreeHolder$bindTo$$inlined$with$lambda$1(post, i));
        }

        public final void updateAsBasicUi(int i) {
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(C0010R$id.textProductName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textProductName");
            textView.setText("포스팅하고 수익을 창출해보세요");
            ((TextView) view.findViewById(C0010R$id.textProductName)).setTextColor(ContextCompat.getColor(view.getContext(), C0006R$color.gray3));
            TextView textView2 = (TextView) view.findViewById(C0010R$id.textRanking);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textRanking");
            StringBuilder sb = new StringBuilder();
            sb.append(i + 1);
            sb.append(50948);
            textView2.setText(sb.toString());
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.iconMore);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "iconMore");
            imageView.setVisibility(4);
        }
    }

    public int getItemCount() {
        return 3;
    }

    @NotNull
    public final List<Post> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<Post> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public RevenueTopThreeHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_revenue_top_three, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new RevenueTopThreeHolder(this, inflate);
    }

    public void onBindViewHolder(@NotNull RevenueTopThreeHolder revenueTopThreeHolder, int i) {
        Intrinsics.checkParameterIsNotNull(revenueTopThreeHolder, "holder");
        try {
            revenueTopThreeHolder.bindTo((Post) this.items.get(i), i);
        } catch (IndexOutOfBoundsException unused) {
            revenueTopThreeHolder.updateAsBasicUi(i);
        }
    }
}
