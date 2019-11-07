package kr.co.popone.fitts.feature.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo;
import org.jetbrains.annotations.NotNull;

public final class AppliableEventResultAdapter extends Adapter<ResultItemViewHolder> {
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener linkUrlClickListener = new AppliableEventResultAdapter$linkUrlClickListener$1(this);
    @NotNull
    private List<WinnerInfo> resultItems = CollectionsKt__CollectionsKt.emptyList();

    public interface Delegate {
        void onLinkUrlClicked(int i);
    }

    public static final class ResultItemViewHolder extends ViewHolder {
        @NotNull
        private final TextView fittsIDTextView;
        @NotNull
        private final TextView productLinkTextView;

        public ResultItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.fittsIDTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.fittsIDTextView)");
            this.fittsIDTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.productLinkTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.productLinkTextView)");
            this.productLinkTextView = (TextView) findViewById2;
        }

        @NotNull
        public final TextView getFittsIDTextView() {
            return this.fittsIDTextView;
        }

        @NotNull
        public final TextView getProductLinkTextView() {
            return this.productLinkTextView;
        }
    }

    public AppliableEventResultAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public final List<WinnerInfo> getResultItems() {
        return this.resultItems;
    }

    public final void setResultItems(@NotNull List<WinnerInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        if (!Intrinsics.areEqual((Object) list, (Object) this.resultItems)) {
            this.resultItems = list;
            notifyDataSetChanged();
        }
    }

    @NotNull
    public ResultItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_appliable_event_result, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        ResultItemViewHolder resultItemViewHolder = new ResultItemViewHolder(inflate);
        resultItemViewHolder.getProductLinkTextView().setOnClickListener(this.linkUrlClickListener);
        return resultItemViewHolder;
    }

    public int getItemCount() {
        return this.resultItems.size();
    }

    public void onBindViewHolder(@NotNull ResultItemViewHolder resultItemViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(resultItemViewHolder, "holder");
        resultItemViewHolder.getFittsIDTextView().setText(((WinnerInfo) this.resultItems.get(i)).getFittsID());
        resultItemViewHolder.getProductLinkTextView().setTag(Integer.valueOf(i));
    }
}
