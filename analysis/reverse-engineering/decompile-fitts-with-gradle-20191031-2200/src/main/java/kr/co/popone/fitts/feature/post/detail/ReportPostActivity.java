package kr.co.popone.fitts.feature.post.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReportPostActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public Disposable reportPostRequest;
    /* access modifiers changed from: private */
    public String reportReason;

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
    public final PostAPI getPostAPI() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_report_post);
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setOnClickListener(new ReportPostActivity$onCreate$1(this));
        ((RadioButton) _$_findCachedViewById(C0010R$id.option1)).setOnClickListener(new ReportPostActivity$onCreate$2(this));
        ((RadioButton) _$_findCachedViewById(C0010R$id.option2)).setOnClickListener(new ReportPostActivity$onCreate$3(this));
        ((RadioButton) _$_findCachedViewById(C0010R$id.option3)).setOnClickListener(new ReportPostActivity$onCreate$4(this));
        ((RadioButton) _$_findCachedViewById(C0010R$id.option4)).setOnClickListener(new ReportPostActivity$onCreate$5(this));
        ((Button) _$_findCachedViewById(C0010R$id.report_done_button)).setOnClickListener(new ReportPostActivity$onCreate$6(this));
    }

    public void onBackPressed() {
        setResult(0, new Intent());
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.reportPostRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.reportPostRequest = null;
        this.reportReason = null;
        super.onDestroy();
    }
}
