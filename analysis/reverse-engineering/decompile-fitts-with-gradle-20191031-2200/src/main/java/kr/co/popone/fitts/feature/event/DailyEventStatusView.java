package kr.co.popone.fitts.feature.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DailyEventStatusView extends LinearLayout {
    private HashMap _$_findViewCache;
    @NotNull
    private String dayName;
    @Nullable
    private Function1<? super Integer, Unit> itemClickListener;
    private final OnClickListener itemViewClickListener;
    @NotNull
    private List<Item> items;

    public static final class Item {
        @NotNull
        private final String option;
        @NotNull
        private final String shopName;

        @NotNull
        public static /* synthetic */ Item copy$default(Item item, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.shopName;
            }
            if ((i & 2) != 0) {
                str2 = item.option;
            }
            return item.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.shopName;
        }

        @NotNull
        public final String component2() {
            return this.option;
        }

        @NotNull
        public final Item copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "shopName");
            Intrinsics.checkParameterIsNotNull(str2, "option");
            return new Item(str, str2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.option, (java.lang.Object) r3.option) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.feature.event.DailyEventStatusView.Item
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.feature.event.DailyEventStatusView$Item r3 = (kr.co.popone.fitts.feature.event.DailyEventStatusView.Item) r3
                java.lang.String r0 = r2.shopName
                java.lang.String r1 = r3.shopName
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.lang.String r0 = r2.option
                java.lang.String r3 = r3.option
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r3 = 0
                return r3
            L_0x001f:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.DailyEventStatusView.Item.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.shopName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.option;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Item(shopName=");
            sb.append(this.shopName);
            sb.append(", option=");
            sb.append(this.option);
            sb.append(")");
            return sb.toString();
        }

        public Item(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "shopName");
            Intrinsics.checkParameterIsNotNull(str2, "option");
            this.shopName = str;
            this.option = str2;
        }

        @NotNull
        public final String getOption() {
            return this.option;
        }

        @NotNull
        public final String getShopName() {
            return this.shopName;
        }
    }

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

    @NotNull
    public final String getDayName() {
        return this.dayName;
    }

    public final void setDayName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        this.dayName = str;
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.dayTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "dayTextView");
        textView.setText(str);
    }

    @NotNull
    public final List<Item> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<Item> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        updateView();
    }

    @Nullable
    public final Function1<Integer, Unit> getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.itemClickListener = function1;
    }

    private final void updateView() {
        ((LinearLayout) _$_findCachedViewById(C0010R$id.itemLayout)).removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext());
        boolean isEmpty = this.items.isEmpty();
        String str = "itemView.findViewById<View>(R.id.bottomLine)";
        String str2 = "itemView.findViewById(R.id.statusOptionButton)";
        int i = C0010R$id.statusOptionButton;
        int i2 = C0013R$layout.item_daily_event_status;
        if (isEmpty) {
            View inflate = from.inflate(C0013R$layout.item_daily_event_status, (LinearLayout) _$_findCachedViewById(C0010R$id.itemLayout), false);
            View findViewById = inflate.findViewById(C0010R$id.statusOptionButton);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, str2);
            ((ImageView) findViewById).setVisibility(4);
            View findViewById2 = inflate.findViewById(C0010R$id.bottomLine);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, str);
            findViewById2.setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(C0010R$id.itemLayout)).addView(inflate);
        } else {
            int i3 = 0;
            for (Object next : this.items) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Item item = (Item) next;
                View inflate2 = from.inflate(i2, (LinearLayout) _$_findCachedViewById(C0010R$id.itemLayout), false);
                View findViewById3 = inflate2.findViewById(i);
                Intrinsics.checkExpressionValueIsNotNull(findViewById3, str2);
                ImageView imageView = (ImageView) findViewById3;
                View findViewById4 = inflate2.findViewById(C0010R$id.statusOption);
                Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.statusOption)");
                TextView textView = (TextView) findViewById4;
                View findViewById5 = inflate2.findViewById(C0010R$id.shopNameTextView);
                Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.shopNameTextView)");
                ((TextView) findViewById5).setText(item.getShopName());
                textView.setText(item.getOption());
                imageView.setOnClickListener(this.itemViewClickListener);
                imageView.setTag(Integer.valueOf(i3));
                if (i3 == this.items.size() - 1) {
                    View findViewById6 = inflate2.findViewById(C0010R$id.bottomLine);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById6, str);
                    findViewById6.setVisibility(8);
                }
                ((LinearLayout) _$_findCachedViewById(C0010R$id.itemLayout)).addView(inflate2);
                i3 = i4;
                i = C0010R$id.statusOptionButton;
                i2 = C0013R$layout.item_daily_event_status;
            }
        }
        requestLayout();
    }

    public DailyEventStatusView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public DailyEventStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public DailyEventStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.dayName = "";
        this.items = CollectionsKt__CollectionsKt.emptyList();
        this.itemViewClickListener = new DailyEventStatusView$itemViewClickListener$1(this);
        LayoutInflater.from(context).inflate(C0013R$layout.view_daily_event_status, this, true);
    }
}
