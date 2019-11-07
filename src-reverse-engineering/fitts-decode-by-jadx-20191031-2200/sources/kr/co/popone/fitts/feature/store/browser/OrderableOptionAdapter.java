package kr.co.popone.fitts.feature.store.browser;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.gson.Gson;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.model.store.ProductOptionViewDataKt;
import org.jetbrains.annotations.NotNull;

public final class OrderableOptionAdapter extends Adapter<ViewHolder> implements kr.co.popone.fitts.feature.store.browser.ProductOptionSelectorViewHolder.Delegate {
    private final Delegate delegate;
    private List<OrderableOptionViewData> items = new ArrayList();
    @NotNull
    private final BehaviorSubject<Integer> orderableOptionCount;

    public interface Delegate {
        void onOptionDuplicated();

        void totalPriceChanged(@NotNull String str);
    }

    public OrderableOptionAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
        BehaviorSubject<Integer> createDefault = BehaviorSubject.createDefault(Integer.valueOf(0));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(0)");
        this.orderableOptionCount = createDefault;
    }

    @NotNull
    public final BehaviorSubject<Integer> getOrderableOptionCount() {
        return this.orderableOptionCount;
    }

    public final void addOrderableOptionViewData(@NotNull OrderableOptionViewData orderableOptionViewData) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "orderableOptionViewData");
        if (!this.items.contains(orderableOptionViewData)) {
            this.items = CollectionsKt___CollectionsKt.plus((Collection<? extends T>) this.items, orderableOptionViewData);
            notifyDataSetChanged();
            this.orderableOptionCount.onNext(Integer.valueOf(this.items.size()));
            Delegate delegate2 = this.delegate;
            String parsePriceAsJson = parsePriceAsJson();
            Intrinsics.checkExpressionValueIsNotNull(parsePriceAsJson, "parsePriceAsJson()");
            delegate2.totalPriceChanged(parsePriceAsJson);
            return;
        }
        this.delegate.onOptionDuplicated();
    }

    @NotNull
    public final List<OrderableOptionViewData> getOrderableItems() {
        return this.items;
    }

    public final String parsePriceAsJson() {
        return new Gson().toJson((Object) ProductOptionViewDataKt.mapToEntiry(this.items));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return ProductOptionSelectorViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof ProductOptionSelectorViewHolder) {
            ((ProductOptionSelectorViewHolder) viewHolder).bindTo((OrderableOptionViewData) this.items.get(i), i, this);
        }
    }

    public void onDeleteOptionClicked(@NotNull OrderableOptionViewData orderableOptionViewData) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "option");
        int indexOf = this.items.indexOf(orderableOptionViewData);
        this.items = CollectionsKt___CollectionsKt.minus((Iterable<? extends T>) this.items, orderableOptionViewData);
        notifyItemRemoved(indexOf);
        this.orderableOptionCount.onNext(Integer.valueOf(this.items.size()));
        Delegate delegate2 = this.delegate;
        String parsePriceAsJson = parsePriceAsJson();
        Intrinsics.checkExpressionValueIsNotNull(parsePriceAsJson, "parsePriceAsJson()");
        delegate2.totalPriceChanged(parsePriceAsJson);
    }

    public void onOptionCountChanged(@NotNull OrderableOptionViewData orderableOptionViewData, @NotNull OrderableOptionViewData orderableOptionViewData2) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "oldOption");
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData2, "newOption");
        ((OrderableOptionViewData) this.items.get(this.items.indexOf(orderableOptionViewData))).setProductCount(orderableOptionViewData2.getProductCount());
        Delegate delegate2 = this.delegate;
        String parsePriceAsJson = parsePriceAsJson();
        Intrinsics.checkExpressionValueIsNotNull(parsePriceAsJson, "parsePriceAsJson()");
        delegate2.totalPriceChanged(parsePriceAsJson);
    }

    public final void clear() {
        if (!this.items.isEmpty()) {
            List<OrderableOptionViewData> list = this.items;
            if (list != null) {
                ((ArrayList) list).clear();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<kr.co.popone.fitts.model.store.OrderableOptionViewData>");
            }
        }
        Delegate delegate2 = this.delegate;
        String parsePriceAsJson = parsePriceAsJson();
        Intrinsics.checkExpressionValueIsNotNull(parsePriceAsJson, "parsePriceAsJson()");
        delegate2.totalPriceChanged(parsePriceAsJson);
        this.orderableOptionCount.onNext(Integer.valueOf(this.items.size()));
        notifyDataSetChanged();
    }
}
