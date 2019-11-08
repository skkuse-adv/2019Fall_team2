package kr.co.popone.fitts.ui.custom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

public final class CustomTabLayout$onAttachedToWindow$1 implements OnTabSelectedListener {
    final /* synthetic */ CustomTabLayout this$0;

    public void onTabReselected(@Nullable Tab tab) {
    }

    CustomTabLayout$onAttachedToWindow$1(CustomTabLayout customTabLayout) {
        this.this$0 = customTabLayout;
    }

    public void onTabUnselected(@Nullable Tab tab) {
        if (tab != null) {
            View childAt = this.this$0.getChildAt(0);
            if (childAt != null) {
                View childAt2 = ((ViewGroup) childAt).getChildAt(tab.getPosition());
                if (childAt2 != null) {
                    View childAt3 = ((LinearLayout) childAt2).getChildAt(1);
                    if (childAt3 != null) {
                        TextView textView = (TextView) childAt3;
                        textView.post(new CustomTabLayout$onAttachedToWindow$1$onTabUnselected$1$1$1$1(textView));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public void onTabSelected(@Nullable Tab tab) {
        if (tab != null) {
            View childAt = this.this$0.getChildAt(0);
            if (childAt != null) {
                View childAt2 = ((ViewGroup) childAt).getChildAt(tab.getPosition());
                if (childAt2 != null) {
                    View childAt3 = ((LinearLayout) childAt2).getChildAt(1);
                    if (childAt3 != null) {
                        TextView textView = (TextView) childAt3;
                        textView.post(new CustomTabLayout$onAttachedToWindow$1$onTabSelected$$inlined$let$lambda$1(textView, this));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }
}
