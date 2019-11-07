package kr.co.popone.fitts.feature.post;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostingViolationNoticeActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PostingViolationNoticeActivity.class), "postInvoiceID", "getPostInvoiceID()J"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_ID = "id";
    private HashMap _$_findViewCache;
    @NotNull
    public PostAPI postAPI;
    private final Lazy postInvoiceID$delegate = LazyKt__LazyJVMKt.lazy(new PostingViolationNoticeActivity$postInvoiceID$2(this));
    /* access modifiers changed from: private */
    public Disposable postInvoiceRequest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final long getPostInvoiceID() {
        Lazy lazy = this.postInvoiceID$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).longValue();
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
    public final PostAPI getPostAPI$app_productionFittsRelease() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI$app_productionFittsRelease(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_posting_violation_notice);
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        this.postInvoiceRequest = postAPI2.requestPostInvoice(getPostInvoiceID()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostingViolationNoticeActivity$onCreate$1<Object,Object>(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.cancelButton)).setOnClickListener(new PostingViolationNoticeActivity$onCreate$2(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.bottomPlusFriendLayout)).setOnClickListener(new PostingViolationNoticeActivity$onCreate$3(this));
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.slide_down, C0001R$anim.fade_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.postInvoiceRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
