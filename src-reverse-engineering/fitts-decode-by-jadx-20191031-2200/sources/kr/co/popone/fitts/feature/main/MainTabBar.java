package kr.co.popone.fitts.feature.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MainTabBar extends FrameLayout {
    private HashMap _$_findViewCache;
    @Nullable
    private Listener listener;
    private int notificationBadge;
    private int postableBadgeCount;
    @NotNull
    private Tab selectedTab;

    public interface Listener {
        boolean homeTabLongClicked();

        void onTabClicked(@NotNull Tab tab, boolean z);

        void writeButtonClicked();
    }

    public enum Tab {
        Home,
        Store,
        Notification,
        My
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
    public final Tab getSelectedTab() {
        return this.selectedTab;
    }

    public final void setSelectedTab(@NotNull Tab tab) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(tab, "value");
        if (this.selectedTab == tab) {
            z = false;
        } else {
            this.selectedTab = tab;
            updateUI(tab);
            z = true;
        }
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onTabClicked(tab, z);
        }
    }

    public final int getNotificationBadge() {
        return this.notificationBadge;
    }

    public final void setNotificationBadge(int i) {
        if (this.notificationBadge != i) {
            this.notificationBadge = i;
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.notificationNewBadge);
            String str = "notificationNewBadge";
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText(String.valueOf(i));
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.notificationNewBadge);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setVisibility(i != 0 ? 0 : 8);
        }
    }

    public final int getPostableBadgeCount() {
        return this.postableBadgeCount;
    }

    public final void setPostableBadgeCount(int i) {
        if (this.postableBadgeCount != i) {
            this.postableBadgeCount = i;
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.postableBadge);
            String str = "postableBadge";
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText(String.valueOf(i));
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.postableBadge);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setVisibility(i != 0 ? 0 : 8);
        }
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener2) {
        this.listener = listener2;
    }

    public MainTabBar(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public MainTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public MainTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.selectedTab = Tab.Home;
        LayoutInflater.from(context).inflate(C0013R$layout.view_main_tab_bar, this, true);
        updateUI(this.selectedTab);
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.homeTabLayout)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainTabBar this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.setSelectedTab(Tab.Home);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.homeTabLayout)).setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MainTabBar this$0;

            {
                this.this$0 = r1;
            }

            public final boolean onLongClick(View view) {
                Listener listener = this.this$0.getListener();
                if (listener != null) {
                    return listener.homeTabLongClicked();
                }
                return false;
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.recommendationTabLayout)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainTabBar this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.setSelectedTab(Tab.Store);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.notificationTabLayout)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainTabBar this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.setSelectedTab(Tab.Notification);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(C0010R$id.myTabLayout)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainTabBar this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.setSelectedTab(Tab.My);
            }
        });
        ((ImageView) _$_findCachedViewById(C0010R$id.postWriteImageView)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainTabBar this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                Listener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.writeButtonClicked();
                }
            }
        });
    }

    private final void updateUI(Tab tab) {
        int color = ContextCompat.getColor(getContext(), C0006R$color.gray4);
        int color2 = ContextCompat.getColor(getContext(), C0006R$color.gray6);
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.homeTabImageView);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "homeTabImageView");
        boolean z = true;
        imageView.setSelected(tab == Tab.Home);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.homeTabTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "homeTabTextView");
        Sdk27PropertiesKt.setTextColor(textView, tab == Tab.Home ? color2 : color);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C0010R$id.recommendationTabImageView);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "recommendationTabImageView");
        imageView2.setSelected(tab == Tab.Store);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.recommendationTabTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "recommendationTabTextView");
        Sdk27PropertiesKt.setTextColor(textView2, tab == Tab.Store ? color2 : color);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(C0010R$id.notificationTabImageView);
        Intrinsics.checkExpressionValueIsNotNull(imageView3, "notificationTabImageView");
        imageView3.setSelected(tab == Tab.Notification);
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.notificationTabTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "notificationTabTextView");
        Sdk27PropertiesKt.setTextColor(textView3, tab == Tab.Notification ? color2 : color);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(C0010R$id.myTabImageView);
        Intrinsics.checkExpressionValueIsNotNull(imageView4, "myTabImageView");
        if (tab != Tab.My) {
            z = false;
        }
        imageView4.setSelected(z);
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.myTabTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "myTabTextView");
        if (tab == Tab.My) {
            color = color2;
        }
        Sdk27PropertiesKt.setTextColor(textView4, color);
    }
}
