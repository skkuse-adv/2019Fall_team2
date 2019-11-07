package kr.co.popone.fitts.feature.post;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostFirstWriteNoticeActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    public FittsSchemeHandler schemeHandler;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
    public final FittsSchemeHandler getSchemeHandler() {
        FittsSchemeHandler fittsSchemeHandler = this.schemeHandler;
        if (fittsSchemeHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemeHandler");
        }
        return fittsSchemeHandler;
    }

    public final void setSchemeHandler(@NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "<set-?>");
        this.schemeHandler = fittsSchemeHandler;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_post_first_write_notice);
        ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView3)).setOnClickListener(new PostFirstWriteNoticeActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.confirmButton)).setOnClickListener(new PostFirstWriteNoticeActivity$onCreate$2(this));
    }

    public void onBackPressed() {
        finishActivity();
    }

    /* access modifiers changed from: private */
    public final void finishActivity() {
        setResult(-1);
        finish();
    }
}
