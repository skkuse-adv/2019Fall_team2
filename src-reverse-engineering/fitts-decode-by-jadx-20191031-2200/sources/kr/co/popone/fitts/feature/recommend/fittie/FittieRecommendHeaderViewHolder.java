package kr.co.popone.fitts.feature.recommend.fittie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendHeaderViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_fittie_recommend_header;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FittieRecommendHeaderViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_fittie_recommend_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FittieRecommendHeaderViewHolder(inflate);
        }
    }

    public FittieRecommendHeaderViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo() {
        TextView textView = (TextView) this.itemView.findViewById(C0010R$id.textSubTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textSubTitle");
        textView.setText("핏티님의 취향을\n더 자세히 알고 싶어요 😊");
    }
}
