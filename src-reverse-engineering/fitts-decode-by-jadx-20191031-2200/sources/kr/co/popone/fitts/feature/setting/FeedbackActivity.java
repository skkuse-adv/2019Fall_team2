package kr.co.popone.fitts.feature.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FeedbackActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAM_MODAL_KEY = "modal";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable feedbackRequest;
    @NotNull
    public FittsServiceRepository fittsServiceRepository;
    private boolean isModal;

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
    public final FittsServiceRepository getFittsServiceRepository$app_productionFittsRelease() {
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
        }
        return fittsServiceRepository2;
    }

    public final void setFittsServiceRepository$app_productionFittsRelease(@NotNull FittsServiceRepository fittsServiceRepository2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "<set-?>");
        this.fittsServiceRepository = fittsServiceRepository2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_feedback);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setEnabled(false);
        this.isModal = getIntent().getBooleanExtra(PARAM_MODAL_KEY, false);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(this.isModal ? C0008R$drawable.button_cancel : C0008R$drawable.button_back);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new FeedbackActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.sendButton)).setOnClickListener(new FeedbackActivity$onCreate$2(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.feedbackEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "feedbackEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        textChanges.subscribe((Consumer<? super T>) new FeedbackActivity$onCreate$3<Object>(this));
    }

    /* access modifiers changed from: private */
    public final void requestFeedback(String str) {
        if (this.feedbackRequest == null) {
            FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
            if (fittsServiceRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
            }
            this.feedbackRequest = fittsServiceRepository2.postFeedbacks(str).subscribe(new FeedbackActivity$requestFeedback$1(this), new FeedbackActivity$requestFeedback$2(this));
            onFeedbackRequestStart();
        }
    }

    private final void onFeedbackRequestStart() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(true);
        Button button = (Button) _$_findCachedViewById(C0010R$id.sendButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "sendButton");
        button.setEnabled(false);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.feedbackEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "feedbackEditText");
        editText.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void onFeedbackRequestEnd() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        Button button = (Button) _$_findCachedViewById(C0010R$id.sendButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "sendButton");
        button.setEnabled(true);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.feedbackEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "feedbackEditText");
        editText.setEnabled(true);
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, this.isModal ? C0001R$anim.slide_down : C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.feedbackRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void showDialog() {
        DialogExtensions.INSTANCE.showMessageDialog(this, "감사합니다 ♥", "더 나은 서비스를 제공하기위해\n열심히 노력하겠습니다.", new FeedbackActivity$showDialog$1(this), "확인");
    }
}
