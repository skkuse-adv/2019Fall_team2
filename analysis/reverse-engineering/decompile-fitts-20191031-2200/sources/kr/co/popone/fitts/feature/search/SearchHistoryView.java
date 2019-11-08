package kr.co.popone.fitts.feature.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHistoryView extends FrameLayout {
    private HashMap _$_findViewCache;
    private ArrayAdapter<String> adapter;
    @Nullable
    private Delegate delegate;

    public interface Delegate {
        void onDeleteClicked();

        void onItemSelected(int i);
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

    @Nullable
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(@Nullable Delegate delegate2) {
        this.delegate = delegate2;
    }

    public SearchHistoryView(@Nullable Context context) {
        super(context);
        initialize(context);
    }

    public SearchHistoryView(@Nullable Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet);
        initialize(context);
    }

    public SearchHistoryView(@Nullable Context context, @NotNull AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet, i);
        initialize(context);
    }

    private final void initialize(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        from.inflate(C0013R$layout.view_search_history, this, true);
        this.adapter = new ArrayAdapter<>(context, C0013R$layout.item_search_history);
        ListView listView = (ListView) _$_findCachedViewById(C0010R$id.listView);
        Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
        ArrayAdapter<String> arrayAdapter = this.adapter;
        if (arrayAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        listView.setAdapter(arrayAdapter);
        ((ListView) _$_findCachedViewById(C0010R$id.listView)).setOnItemClickListener(new SearchHistoryView$initialize$1(this));
        View inflate = from.inflate(C0013R$layout.view_search_history_footer, (ListView) _$_findCachedViewById(C0010R$id.listView), false);
        ((ListView) _$_findCachedViewById(C0010R$id.listView)).addFooterView(inflate, null, false);
        inflate.findViewById(C0010R$id.tv_delete_search_history).setOnClickListener(new SearchHistoryView$initialize$2(this));
    }

    public final void setItems(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        ArrayAdapter<String> arrayAdapter = this.adapter;
        String str = "adapter";
        if (arrayAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        arrayAdapter.clear();
        ArrayAdapter<String> arrayAdapter2 = this.adapter;
        if (arrayAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        arrayAdapter2.addAll(list);
        ((ListView) _$_findCachedViewById(C0010R$id.listView)).invalidate();
    }

    @Nullable
    public final String getKeyword(int i) {
        ArrayAdapter<String> arrayAdapter = this.adapter;
        if (arrayAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return (String) arrayAdapter.getItem(i);
    }
}
