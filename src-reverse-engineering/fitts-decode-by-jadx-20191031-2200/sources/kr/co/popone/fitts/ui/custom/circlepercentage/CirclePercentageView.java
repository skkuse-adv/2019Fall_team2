package kr.co.popone.fitts.ui.custom.circlepercentage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.ui.custom.RoundedLinearLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CirclePercentageView extends FrameLayout {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CirclePercentageView.class), "originPosY", "getOriginPosY()F"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy originPosY$delegate = LazyKt__LazyJVMKt.lazy(new CirclePercentageView$originPosY$2(this));

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

    public final float getOriginPosY() {
        Lazy lazy = this.originPosY$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).floatValue();
    }

    public CirclePercentageView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_circle_percentage, this);
        ((RoundedLinearLayout) _$_findCachedViewById(C0010R$id.roundedLinearLayout)).setCornerRadius(1000);
        setPercent(0, 0);
    }

    public CirclePercentageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_circle_percentage, this);
        ((RoundedLinearLayout) _$_findCachedViewById(C0010R$id.roundedLinearLayout)).setCornerRadius(1000);
        setPercent(0, 0);
    }

    public CirclePercentageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(C0013R$layout.view_circle_percentage, this);
        ((RoundedLinearLayout) _$_findCachedViewById(C0010R$id.roundedLinearLayout)).setCornerRadius(1000);
        setPercent(0, 0);
    }

    public final void setPercent(int i, int i2) {
        String str = "roundedLinearLayout";
        String str2 = "imageZeroPoint";
        String str3 = "textSharePercentage";
        String str4 = "textCollectPercentage";
        if (i == 0 && i2 == 0) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textCollectPercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView, str4);
            textView.setVisibility(4);
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textSharePercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
            textView2.setVisibility(4);
            ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.imageZeroPoint);
            Intrinsics.checkExpressionValueIsNotNull(imageView, str2);
            imageView.setVisibility(0);
            RoundedLinearLayout roundedLinearLayout = (RoundedLinearLayout) _$_findCachedViewById(C0010R$id.roundedLinearLayout);
            Intrinsics.checkExpressionValueIsNotNull(roundedLinearLayout, str);
            roundedLinearLayout.setVisibility(4);
            return;
        }
        String str5 = "0%";
        String str6 = "100%";
        String str7 = "graphView";
        if (i == 100 && i2 == 0) {
            float f = (float) 100;
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.graphView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str7);
            float height = f * (((float) _$_findCachedViewById.getHeight()) / 100.0f);
            View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.graphView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str7);
            _$_findCachedViewById2.setY(getOriginPosY() + height);
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textCollectPercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str4);
            textView3.setText(str6);
            TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textSharePercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str3);
            textView4.setText(str5);
        } else if (i == 0 && i2 == 100) {
            View _$_findCachedViewById3 = _$_findCachedViewById(C0010R$id.graphView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, str7);
            _$_findCachedViewById3.setY(getOriginPosY());
            TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.textCollectPercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str4);
            textView5.setText(str5);
            TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.textSharePercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str3);
            textView6.setText(str6);
        } else {
            int i3 = 100 - i2;
            float f2 = (float) i3;
            View _$_findCachedViewById4 = _$_findCachedViewById(C0010R$id.graphView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById4, str7);
            float height2 = f2 * (((float) _$_findCachedViewById4.getHeight()) / 100.0f);
            View _$_findCachedViewById5 = _$_findCachedViewById(C0010R$id.graphView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById5, str7);
            _$_findCachedViewById5.setY(getOriginPosY() + height2);
            TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.textCollectPercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView7, str4);
            StringBuilder sb = new StringBuilder();
            sb.append(i3);
            sb.append('%');
            textView7.setText(sb.toString());
            TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.textSharePercentage);
            Intrinsics.checkExpressionValueIsNotNull(textView8, str3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            sb2.append('%');
            textView8.setText(sb2.toString());
        }
        TextView textView9 = (TextView) _$_findCachedViewById(C0010R$id.textCollectPercentage);
        Intrinsics.checkExpressionValueIsNotNull(textView9, str4);
        textView9.setVisibility(0);
        TextView textView10 = (TextView) _$_findCachedViewById(C0010R$id.textSharePercentage);
        Intrinsics.checkExpressionValueIsNotNull(textView10, str3);
        textView10.setVisibility(0);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C0010R$id.imageZeroPoint);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, str2);
        imageView2.setVisibility(4);
        RoundedLinearLayout roundedLinearLayout2 = (RoundedLinearLayout) _$_findCachedViewById(C0010R$id.roundedLinearLayout);
        Intrinsics.checkExpressionValueIsNotNull(roundedLinearLayout2, str);
        roundedLinearLayout2.setVisibility(0);
    }
}
