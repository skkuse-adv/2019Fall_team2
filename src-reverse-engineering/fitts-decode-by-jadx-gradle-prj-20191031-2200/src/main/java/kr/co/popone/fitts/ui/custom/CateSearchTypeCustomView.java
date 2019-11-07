package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0009R$font;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CateSearchTypeCustomView extends FrameLayout {
    private HashMap _$_findViewCache;
    @NotNull
    private final MutableLiveData<CategoryFeedType> categoryFeedTypeClickLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<CategoryFeedType> categoryFeedTypeLiveData = new MutableLiveData<>();

    public enum CategoryFeedType {
        POST,
        PRODUCT
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[CategoryFeedType.values().length];

        static {
            $EnumSwitchMapping$0[CategoryFeedType.POST.ordinal()] = 1;
            $EnumSwitchMapping$0[CategoryFeedType.PRODUCT.ordinal()] = 2;
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

    public CateSearchTypeCustomView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_category_type_selector, this);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonPostType)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CateSearchTypeCustomView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.getCategoryFeedTypeLiveData().setValue(CategoryFeedType.POST);
                this.this$0.getCategoryFeedTypeClickLiveData().setValue(CategoryFeedType.POST);
                CateSearchTypeCustomView cateSearchTypeCustomView = this.this$0;
                TextView textView = (TextView) cateSearchTypeCustomView._$_findCachedViewById(C0010R$id.buttonPostType);
                Intrinsics.checkExpressionValueIsNotNull(textView, "buttonPostType");
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonProductType);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonProductType");
                cateSearchTypeCustomView.updateSelecedView(textView, textView2);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonProductType)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CateSearchTypeCustomView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.getCategoryFeedTypeLiveData().setValue(CategoryFeedType.PRODUCT);
                this.this$0.getCategoryFeedTypeClickLiveData().setValue(CategoryFeedType.PRODUCT);
                CateSearchTypeCustomView cateSearchTypeCustomView = this.this$0;
                TextView textView = (TextView) cateSearchTypeCustomView._$_findCachedViewById(C0010R$id.buttonProductType);
                Intrinsics.checkExpressionValueIsNotNull(textView, "buttonProductType");
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonPostType);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonPostType");
                cateSearchTypeCustomView.updateSelecedView(textView, textView2);
            }
        });
        this.categoryFeedTypeLiveData.setValue(CategoryFeedType.POST);
    }

    public CateSearchTypeCustomView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_category_type_selector, this);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonPostType)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CateSearchTypeCustomView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.getCategoryFeedTypeLiveData().setValue(CategoryFeedType.POST);
                this.this$0.getCategoryFeedTypeClickLiveData().setValue(CategoryFeedType.POST);
                CateSearchTypeCustomView cateSearchTypeCustomView = this.this$0;
                TextView textView = (TextView) cateSearchTypeCustomView._$_findCachedViewById(C0010R$id.buttonPostType);
                Intrinsics.checkExpressionValueIsNotNull(textView, "buttonPostType");
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonProductType);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonProductType");
                cateSearchTypeCustomView.updateSelecedView(textView, textView2);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonProductType)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CateSearchTypeCustomView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.getCategoryFeedTypeLiveData().setValue(CategoryFeedType.PRODUCT);
                this.this$0.getCategoryFeedTypeClickLiveData().setValue(CategoryFeedType.PRODUCT);
                CateSearchTypeCustomView cateSearchTypeCustomView = this.this$0;
                TextView textView = (TextView) cateSearchTypeCustomView._$_findCachedViewById(C0010R$id.buttonProductType);
                Intrinsics.checkExpressionValueIsNotNull(textView, "buttonProductType");
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonPostType);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonPostType");
                cateSearchTypeCustomView.updateSelecedView(textView, textView2);
            }
        });
        this.categoryFeedTypeLiveData.setValue(CategoryFeedType.POST);
    }

    public CateSearchTypeCustomView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_category_type_selector, this);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonPostType)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CateSearchTypeCustomView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.getCategoryFeedTypeLiveData().setValue(CategoryFeedType.POST);
                this.this$0.getCategoryFeedTypeClickLiveData().setValue(CategoryFeedType.POST);
                CateSearchTypeCustomView cateSearchTypeCustomView = this.this$0;
                TextView textView = (TextView) cateSearchTypeCustomView._$_findCachedViewById(C0010R$id.buttonPostType);
                Intrinsics.checkExpressionValueIsNotNull(textView, "buttonPostType");
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonProductType);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonProductType");
                cateSearchTypeCustomView.updateSelecedView(textView, textView2);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonProductType)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CateSearchTypeCustomView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.getCategoryFeedTypeLiveData().setValue(CategoryFeedType.PRODUCT);
                this.this$0.getCategoryFeedTypeClickLiveData().setValue(CategoryFeedType.PRODUCT);
                CateSearchTypeCustomView cateSearchTypeCustomView = this.this$0;
                TextView textView = (TextView) cateSearchTypeCustomView._$_findCachedViewById(C0010R$id.buttonProductType);
                Intrinsics.checkExpressionValueIsNotNull(textView, "buttonProductType");
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.buttonPostType);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "buttonPostType");
                cateSearchTypeCustomView.updateSelecedView(textView, textView2);
            }
        });
        this.categoryFeedTypeLiveData.setValue(CategoryFeedType.POST);
    }

    @NotNull
    public final MutableLiveData<CategoryFeedType> getCategoryFeedTypeLiveData() {
        return this.categoryFeedTypeLiveData;
    }

    @NotNull
    public final MutableLiveData<CategoryFeedType> getCategoryFeedTypeClickLiveData() {
        return this.categoryFeedTypeClickLiveData;
    }

    /* access modifiers changed from: private */
    public final void updateSelecedView(TextView textView, TextView textView2) {
        Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(textView.getContext(), C0006R$color.gray6));
        textView.setTypeface(ResourcesCompat.getFont(textView.getContext(), C0009R$font.kopubdotum_pro_bold));
        Sdk27PropertiesKt.setTextColor(textView2, ContextCompat.getColor(textView2.getContext(), C0006R$color.gray3));
        textView2.setTypeface(ResourcesCompat.getFont(textView2.getContext(), C0009R$font.kopubdotum_pro_medium));
    }

    public final void setCategoryFeedType(@NotNull CategoryFeedType categoryFeedType) {
        Intrinsics.checkParameterIsNotNull(categoryFeedType, "categoryFeedType");
        int i = WhenMappings.$EnumSwitchMapping$0[categoryFeedType.ordinal()];
        if (i == 1) {
            ((TextView) _$_findCachedViewById(C0010R$id.buttonPostType)).performClick();
        } else if (i == 2) {
            ((TextView) _$_findCachedViewById(C0010R$id.buttonProductType)).performClick();
        }
    }
}
