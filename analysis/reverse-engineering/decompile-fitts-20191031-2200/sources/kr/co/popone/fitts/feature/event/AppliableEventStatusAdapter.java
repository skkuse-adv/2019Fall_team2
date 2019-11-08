package kr.co.popone.fitts.feature.event;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.event.EventAPI.EventHistory;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;
import org.jetbrains.annotations.NotNull;

public final class AppliableEventStatusAdapter extends Adapter<StatusItemViewHolder> {
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener optionClickListener = new AppliableEventStatusAdapter$optionClickListener$1(this);
    @NotNull
    private List<EventHistory> statusItems = CollectionsKt__CollectionsKt.emptyList();

    public interface Delegate {
        void onOptionClicked(int i);
    }

    public static final class StatusItemViewHolder extends ViewHolder {
        @NotNull
        private final TextView statusDayTextView;
        @NotNull
        private final ImageView statusOptionButton;
        @NotNull
        private final TextView statusOptionTextView;
        @NotNull
        private final TextView statusTypeTextView;

        public StatusItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.statusDay);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.statusDay)");
            this.statusDayTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.statusOptionButton);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.statusOptionButton)");
            this.statusOptionButton = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(C0010R$id.statusOption);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.statusOption)");
            this.statusOptionTextView = (TextView) findViewById3;
            View findViewById4 = view.findViewById(C0010R$id.statusType);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.statusType)");
            this.statusTypeTextView = (TextView) findViewById4;
        }

        @NotNull
        public final TextView getStatusDayTextView() {
            return this.statusDayTextView;
        }

        @NotNull
        public final ImageView getStatusOptionButton() {
            return this.statusOptionButton;
        }

        @NotNull
        public final TextView getStatusOptionTextView() {
            return this.statusOptionTextView;
        }

        @NotNull
        public final TextView getStatusTypeTextView() {
            return this.statusTypeTextView;
        }
    }

    public AppliableEventStatusAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public final List<EventHistory> getStatusItems() {
        return this.statusItems;
    }

    public final void setStatusItems(@NotNull List<EventHistory> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        if (!Intrinsics.areEqual((Object) list, (Object) this.statusItems)) {
            this.statusItems = list;
            notifyDataSetChanged();
        }
    }

    @NotNull
    public StatusItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_applicable_event_status, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        StatusItemViewHolder statusItemViewHolder = new StatusItemViewHolder(inflate);
        statusItemViewHolder.getStatusOptionButton().setOnClickListener(this.optionClickListener);
        return statusItemViewHolder;
    }

    public int getItemCount() {
        return this.statusItems.size();
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull StatusItemViewHolder statusItemViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(statusItemViewHolder, "holder");
        EventHistory eventHistory = (EventHistory) this.statusItems.get(i);
        TextView statusDayTextView = statusItemViewHolder.getStatusDayTextView();
        StringBuilder sb = new StringBuilder();
        sb.append(eventHistory.getDay());
        sb.append("일차");
        statusDayTextView.setText(sb.toString());
        if (CollectionsKt___CollectionsKt.firstOrNull(eventHistory.getTickets()) != null) {
            statusItemViewHolder.getStatusTypeTextView().setText(((Ticket) CollectionsKt___CollectionsKt.first(eventHistory.getTickets())).getItem());
            TextView statusOptionTextView = statusItemViewHolder.getStatusOptionTextView();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((Ticket) CollectionsKt___CollectionsKt.first(eventHistory.getTickets())).getColor());
            sb2.append(' ');
            sb2.append(((Ticket) CollectionsKt___CollectionsKt.first(eventHistory.getTickets())).getSize());
            statusOptionTextView.setText(sb2.toString());
            statusItemViewHolder.getStatusOptionButton().setVisibility(0);
            statusItemViewHolder.getStatusOptionButton().setTag(Integer.valueOf(i));
            return;
        }
        statusItemViewHolder.getStatusOptionButton().setVisibility(4);
        String str = "";
        statusItemViewHolder.getStatusOptionTextView().setText(str);
        statusItemViewHolder.getStatusTypeTextView().setText(str);
    }
}
