package kr.co.popone.fitts.feature.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BusinessInfoActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    private final double BANNER_IMAGE_RATIO = 1.4229249011857708d;
    private HashMap _$_findViewCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            ContextExtensionKt.activityStart(context, new Intent(context, BusinessInfoActivity.class), ActivityAnimationType.SLIDE_RTOL);
        }
    }

    public static final void start(@NotNull Context context) {
        Companion.start(context);
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_business_info);
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.imageBusinessInfo);
        LayoutParams layoutParams = imageView.getLayoutParams();
        Resources resources = imageView.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        double d = (double) resources.getDisplayMetrics().widthPixels;
        double d2 = this.BANNER_IMAGE_RATIO;
        Double.isNaN(d);
        layoutParams.height = MathKt__MathJVMKt.roundToInt(d / d2);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new BusinessInfoActivity$onCreate$2(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }
}
