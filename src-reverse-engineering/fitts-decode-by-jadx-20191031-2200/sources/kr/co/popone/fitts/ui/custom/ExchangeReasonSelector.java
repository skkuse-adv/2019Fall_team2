package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeReasonSelector extends FrameLayout {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ExchangeReasonSelector.class), "buttons", "getButtons()Ljava/util/List;"))};
    private HashMap _$_findViewCache;
    private final Lazy buttons$delegate = LazyKt__LazyJVMKt.lazy(new ExchangeReasonSelector$buttons$2(this));
    @Nullable
    private Function0<? extends ExchangeReason> reason;
    @NotNull
    private final MutableLiveData<ExchangeReason> reasonLiveData = new MutableLiveData<>();

    public enum ExchangeReason {
        CUSTOMER_REMORSE("customer_remorse"),
        FAULTY_PRODUCT("faulty_product"),
        WRONG_ORDER("wrong_order"),
        SHIPPING_PROBLEM("shipping_problem");
        
        @NotNull
        private final String reason;

        private ExchangeReason(String str) {
            this.reason = str;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }
    }

    private final List<TextView> getButtons() {
        Lazy lazy = this.buttons$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
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

    public ExchangeReasonSelector(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_exchange_selector, this);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonChangeMind)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(0);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonUserMistake)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(1);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonProductProblem)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(2);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonDelay)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(3);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
    }

    public ExchangeReasonSelector(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_exchange_selector, this);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonChangeMind)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(0);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonUserMistake)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(1);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonProductProblem)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(2);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonDelay)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(3);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
    }

    public ExchangeReasonSelector(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_exchange_selector, this);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonChangeMind)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(0);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonUserMistake)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(1);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonProductProblem)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(2);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
        ((TextView) _$_findCachedViewById(C0010R$id.buttonDelay)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExchangeReasonSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.updateClickedPosition(3);
                this.this$0.setReason(AnonymousClass1.INSTANCE);
            }
        });
    }

    @NotNull
    public final MutableLiveData<ExchangeReason> getReasonLiveData() {
        return this.reasonLiveData;
    }

    @Nullable
    public final Function0<ExchangeReason> getReason() {
        return this.reason;
    }

    public final void setReason(@Nullable Function0<? extends ExchangeReason> function0) {
        this.reason = function0;
        MutableLiveData<ExchangeReason> mutableLiveData = this.reasonLiveData;
        Function0<? extends ExchangeReason> function02 = this.reason;
        mutableLiveData.setValue(function02 != null ? (ExchangeReason) function02.invoke() : null);
    }

    @Nullable
    public final String getExchangeReason() {
        Function0<? extends ExchangeReason> function0 = this.reason;
        if (function0 != null) {
            ExchangeReason exchangeReason = (ExchangeReason) function0.invoke();
            if (exchangeReason != null) {
                return exchangeReason.getReason();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void updateClickedPosition(int i) {
        int i2 = 0;
        for (Object next : getButtons()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) next;
            if (i2 == i) {
                textView.setBackgroundResource(C0008R$drawable.background_round_gray4_gray1);
            } else {
                textView.setBackgroundResource(C0008R$drawable.background_round_white_gray4);
            }
            i2 = i3;
        }
    }
}
