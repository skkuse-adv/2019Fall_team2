package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.orhanobut.logger.Logger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.store.browser.OrderableOptionAdapter;
import kr.co.popone.fitts.model.product.OrderableType;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.model.store.ProductOptionViewData;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.SimpleInnerOffsetDecorator;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;

public final class StoreOptionSelectDialog extends BottomSheetDialog {
    @NotNull
    private final Delegate delegate;
    private final CompositeDisposable disposable = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final OrderableOptionAdapter orderableOptionAdatper = new OrderableOptionAdapter(this.delegate);
    private final StoreOptionAdapter storeOptionAdatper = new StoreOptionAdapter(this.delegate);

    public interface Delegate extends kr.co.popone.fitts.ui.custom.StoreOptionAdapter.Delegate, kr.co.popone.fitts.feature.store.browser.OrderableOptionAdapter.Delegate {
        void onBuyButtonClicked(@NotNull List<OrderableOptionViewData> list);

        void onCartButtonClicked(@NotNull String str);
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[OrderableType.values().length];

        static {
            $EnumSwitchMapping$0[OrderableType.NORMAL.ordinal()] = 1;
            $EnumSwitchMapping$0[OrderableType.SPECIAL_DISCOUNT.ordinal()] = 2;
        }
    }

    public StoreOptionSelectDialog(@NotNull Context context, int i, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(context, i);
        this.delegate = delegate2;
        setContentView((int) C0013R$layout.view_store_option_dialog);
        initializeView();
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    private final void initializeView() {
        ((MaxHeightRecyclerView) findViewById(C0010R$id.recyclerCartItem)).setAdapter(this.orderableOptionAdatper);
        RecyclerView recyclerView = (RecyclerView) findViewById(C0010R$id.selectorRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.storeOptionAdatper);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new SimpleInnerOffsetDecorator(0, 0, 0, 6));
        }
        ((TextView) findViewById(C0010R$id.buttonCart)).setOnClickListener(new StoreOptionSelectDialog$initializeView$3(this));
        ((TextView) findViewById(C0010R$id.buttonBuy)).setOnClickListener(new StoreOptionSelectDialog$initializeView$4(this));
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = this.orderableOptionAdatper.getOrderableOptionCount().map(StoreOptionSelectDialog$initializeView$5.INSTANCE).subscribe((Consumer<? super T>) new StoreOptionSelectDialog$initializeView$6<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "orderableOptionAdatper.o…ons(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void setOptions(@NotNull List<ProductVariantViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "options");
        this.storeOptionAdatper.setItems(list);
    }

    public final void setTotalPrice(int i) {
        TextView textView = (TextView) findViewById(C0010R$id.textTotalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTotalPrice");
        textView.setText(IntExtensionsKt.commaString(i));
    }

    public final void productOptionSelected(int i, @NotNull List<ProductOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "options");
        StringBuilder sb = new StringBuilder();
        sb.append("OptionTest = parentPos : ");
        sb.append(i);
        sb.append(", ");
        sb.append(list);
        Logger.d(sb.toString(), new Object[0]);
        this.storeOptionAdatper.update(i, list);
    }

    public final void orderableOptionCreatead(@NotNull OrderableOptionViewData orderableOptionViewData) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "orderableOptionViewData");
        if (!orderableOptionViewData.isSpecialDiscount()) {
            this.orderableOptionAdatper.addOrderableOptionViewData(orderableOptionViewData);
        } else if (this.orderableOptionAdatper.getOrderableItems().isEmpty()) {
            this.orderableOptionAdatper.addOrderableOptionViewData(orderableOptionViewData);
        } else {
            DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            dialogExtensions.showMessageDialog(context, "", "하루에 1개의 상품만 구매 가능합니다.", StoreOptionSelectDialog$orderableOptionCreatead$1.INSTANCE, "확인");
        }
        this.storeOptionAdatper.reset();
    }

    public final void clear() {
        this.orderableOptionAdatper.clear();
        this.storeOptionAdatper.clear();
    }

    /* access modifiers changed from: private */
    public final void updateButtons(boolean z) {
        TextView textView = (TextView) findViewById(C0010R$id.buttonCart);
        String str = "buttonCart";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        Context context = getContext();
        int i = C0006R$color.gray2;
        Sdk27PropertiesKt.setBackgroundColor(textView, ContextCompat.getColor(context, z ? C0006R$color.gray2 : C0006R$color.gray6));
        TextView textView2 = (TextView) findViewById(C0010R$id.buttonCart);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        textView2.setEnabled(!z);
        TextView textView3 = (TextView) findViewById(C0010R$id.buttonBuy);
        String str2 = "buttonBuy";
        Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
        Context context2 = getContext();
        if (!z) {
            i = C0006R$color.point;
        }
        Sdk27PropertiesKt.setBackgroundColor(textView3, ContextCompat.getColor(context2, i));
        TextView textView4 = (TextView) findViewById(C0010R$id.buttonBuy);
        Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
        textView4.setEnabled(!z);
        View findViewById = findViewById(C0010R$id.summarizeView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "summarizeView");
        findViewById.setVisibility(z ? 8 : 0);
    }

    public final void updateOrderableType(@NotNull OrderableType orderableType) {
        Intrinsics.checkParameterIsNotNull(orderableType, "orderableType");
        int i = WhenMappings.$EnumSwitchMapping$0[orderableType.ordinal()];
        String str = "buttonCart";
        if (i == 1) {
            TextView textView = (TextView) findViewById(C0010R$id.buttonCart);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            ViewExtensionsKt.visible(textView);
        } else if (i == 2) {
            TextView textView2 = (TextView) findViewById(C0010R$id.buttonCart);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            ViewExtensionsKt.gone(textView2);
        }
    }
}
