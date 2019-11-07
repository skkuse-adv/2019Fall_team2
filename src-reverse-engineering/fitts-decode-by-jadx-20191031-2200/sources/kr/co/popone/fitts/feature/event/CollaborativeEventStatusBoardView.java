package kr.co.popone.fitts.feature.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.event.DailyEventStatusView.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CollaborativeEventStatusBoardView extends FrameLayout {
    private HashMap _$_findViewCache;
    @Nullable
    private Function2<? super Integer, ? super Integer, Unit> itemClickListener;
    @NotNull
    private List<DayItem> items;

    public static final class DayItem {
        @NotNull
        private final String dayName;
        @NotNull
        private final List<Item> items;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.feature.event.DailyEventStatusView$Item>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView.DayItem copy$default(kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView.DayItem r0, java.lang.String r1, java.util.List<kr.co.popone.fitts.feature.event.DailyEventStatusView.Item> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.lang.String r1 = r0.dayName
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.feature.event.DailyEventStatusView$Item> r2 = r0.items
            L_0x000c:
                kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView$DayItem r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView.DayItem.copy$default(kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView$DayItem, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView$DayItem");
        }

        @NotNull
        public final String component1() {
            return this.dayName;
        }

        @NotNull
        public final List<Item> component2() {
            return this.items;
        }

        @NotNull
        public final DayItem copy(@NotNull String str, @NotNull List<Item> list) {
            Intrinsics.checkParameterIsNotNull(str, "dayName");
            Intrinsics.checkParameterIsNotNull(list, "items");
            return new DayItem(str, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView.DayItem
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView$DayItem r3 = (kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView.DayItem) r3
                java.lang.String r0 = r2.dayName
                java.lang.String r1 = r3.dayName
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.util.List<kr.co.popone.fitts.feature.event.DailyEventStatusView$Item> r0 = r2.items
                java.util.List<kr.co.popone.fitts.feature.event.DailyEventStatusView$Item> r3 = r3.items
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.CollaborativeEventStatusBoardView.DayItem.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.dayName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<Item> list = this.items;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DayItem(dayName=");
            sb.append(this.dayName);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(")");
            return sb.toString();
        }

        public DayItem(@NotNull String str, @NotNull List<Item> list) {
            Intrinsics.checkParameterIsNotNull(str, "dayName");
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.dayName = str;
            this.items = list;
        }

        @NotNull
        public final String getDayName() {
            return this.dayName;
        }

        @NotNull
        public final List<Item> getItems() {
            return this.items;
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
    public final List<DayItem> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<DayItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        updateView();
    }

    @Nullable
    public final Function2<Integer, Integer, Unit> getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(@Nullable Function2<? super Integer, ? super Integer, Unit> function2) {
        this.itemClickListener = function2;
    }

    public final void setHeadeDescription(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.headerDescriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "headerDescriptionTextView");
        textView.setText(str);
    }

    private final void updateView() {
        ((LinearLayout) _$_findCachedViewById(C0010R$id.eventDailyListLayout)).removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = 0;
        for (Object next : this.items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DayItem dayItem = (DayItem) next;
            View inflate = from.inflate(C0013R$layout.item_collaborative_event_status_board, (LinearLayout) _$_findCachedViewById(C0010R$id.eventDailyListLayout), false);
            if (inflate != null) {
                DailyEventStatusView dailyEventStatusView = (DailyEventStatusView) inflate;
                dailyEventStatusView.setDayName(dayItem.getDayName());
                dailyEventStatusView.setItems(dayItem.getItems());
                dailyEventStatusView.setItemClickListener(new CollaborativeEventStatusBoardView$updateView$$inlined$let$lambda$1(i, from, this));
                ((LinearLayout) _$_findCachedViewById(C0010R$id.eventDailyListLayout)).addView(dailyEventStatusView);
                if (i != this.items.size() - 1) {
                    ((LinearLayout) _$_findCachedViewById(C0010R$id.eventDailyListLayout)).addView(from.inflate(C0013R$layout.item_collaborative_event_status_space, (LinearLayout) _$_findCachedViewById(C0010R$id.eventDailyListLayout), false));
                }
                i = i2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.event.DailyEventStatusView");
            }
        }
        requestLayout();
    }

    public CollaborativeEventStatusBoardView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public CollaborativeEventStatusBoardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public CollaborativeEventStatusBoardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.items = CollectionsKt__CollectionsKt.emptyList();
        LayoutInflater.from(context).inflate(C0013R$layout.view_collaborative_event_status_board, this, true);
    }
}
