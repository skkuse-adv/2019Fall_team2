package kr.co.popone.fitts.feature.post.upload.guide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.Nullable;

public final class PostFirstWriteGuideActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PostFirstWriteGuideActivity.class), "SCREEN_WIDTH", "getSCREEN_WIDTH()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PostFirstWriteGuideActivity.class), "IMAGE_HEIGHT", "getIMAGE_HEIGHT()I"))};
    /* access modifiers changed from: private */
    public final double IMAGE_RATIO = 1.2361d;
    private final Lazy SCREEN_WIDTH$delegate = LazyKt__LazyJVMKt.lazy(new PostFirstWriteGuideActivity$SCREEN_WIDTH$2(this));
    private HashMap _$_findViewCache;

    /* access modifiers changed from: private */
    public final int getSCREEN_WIDTH() {
        Lazy lazy = this.SCREEN_WIDTH$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
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

    public PostFirstWriteGuideActivity() {
        LazyKt__LazyJVMKt.lazy(new PostFirstWriteGuideActivity$IMAGE_HEIGHT$2(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.dialog_post_first_write_guide);
    }

    public void onBackPressed() {
        setResult(-1);
        finishWithAnimation();
    }

    private final void finishWithAnimation() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.fade_out);
    }
}
