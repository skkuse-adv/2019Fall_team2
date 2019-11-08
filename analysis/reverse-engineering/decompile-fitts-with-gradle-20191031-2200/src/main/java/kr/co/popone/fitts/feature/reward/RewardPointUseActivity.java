package kr.co.popone.fitts.feature.reward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RewardPointUseActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final int RESULT_SUCCESS_CODE = 100;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable linkInfoRequest;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public BehaviorSubject<Integer> productPriceSubject;
    /* access modifiers changed from: private */
    public int rewardPoints;
    /* access modifiers changed from: private */
    public Disposable shippingAddressRequest;
    /* access modifiers changed from: private */
    public BehaviorSubject<Integer> shippingFeeSubject;
    /* access modifiers changed from: private */
    public BehaviorSubject<String> shippingZipCodeSubject;
    @NotNull
    public UserAPI userAPI;

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

    public RewardPointUseActivity() {
        Integer valueOf = Integer.valueOf(0);
        BehaviorSubject<Integer> createDefault = BehaviorSubject.createDefault(valueOf);
        String str = "BehaviorSubject.createDefault(0)";
        Intrinsics.checkExpressionValueIsNotNull(createDefault, str);
        this.productPriceSubject = createDefault;
        BehaviorSubject<Integer> createDefault2 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, str);
        this.shippingFeeSubject = createDefault2;
        BehaviorSubject<String> createDefault3 = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault3, "BehaviorSubject.createDefault(\"\")");
        this.shippingZipCodeSubject = createDefault3;
    }

    @NotNull
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
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
    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_reward_point_use);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C0010R$id.toolbar));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText("핏츠 포인트 사용");
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new RewardPointUseActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.shopSearchButton)).setOnClickListener(new RewardPointUseActivity$onCreate$2(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        String str = "productDetailPageLinkEditText";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str2 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str2);
        textChanges.map(RewardPointUseActivity$onCreate$3.INSTANCE).subscribe((Consumer<? super T>) new RewardPointUseActivity$onCreate$4<Object>(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str2);
        textChanges2.subscribe((Consumer<? super T>) new RewardPointUseActivity$onCreate$5<Object>(this));
        ((Button) _$_findCachedViewById(C0010R$id.showUrlLinkButton)).setOnClickListener(new RewardPointUseActivity$onCreate$6(this));
        ((TextView) _$_findCachedViewById(C0010R$id.pasteLinkTextView)).setOnClickListener(new RewardPointUseActivity$onCreate$7(this));
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.shippingMemoEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "shippingMemoEditText");
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str2);
        textChanges3.subscribe((Consumer<? super T>) new RewardPointUseActivity$onCreate$8<Object>(this));
        EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.productPriceEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "productPriceEditText");
        InitialValueObservable textChanges4 = RxTextView.textChanges(editText4);
        Intrinsics.checkExpressionValueIsNotNull(textChanges4, str2);
        textChanges4.subscribe((Consumer<? super T>) new RewardPointUseActivity$onCreate$9<Object>(this));
        EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.shippingFeeEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "shippingFeeEditText");
        InitialValueObservable textChanges5 = RxTextView.textChanges(editText5);
        Intrinsics.checkExpressionValueIsNotNull(textChanges5, str2);
        textChanges5.subscribe((Consumer<? super T>) new RewardPointUseActivity$onCreate$10<Object>(this));
        Observable.combineLatest((ObservableSource<? extends T1>) this.productPriceSubject, (ObservableSource<? extends T2>) this.shippingFeeSubject, (BiFunction<? super T1, ? super T2, ? extends R>) RewardPointUseActivity$onCreate$11.INSTANCE).subscribe((Consumer<? super T>) new RewardPointUseActivity$onCreate$12<Object>(this));
        ((Button) _$_findCachedViewById(C0010R$id.searchAddressButton)).setOnClickListener(new RewardPointUseActivity$onCreate$13(this));
        ((Button) _$_findCachedViewById(C0010R$id.nextButton)).setOnClickListener(new RewardPointUseActivity$onCreate$14(this));
        loadShippingAddress();
        loadUsablePoint();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.linkInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.shippingAddressRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }

    private final void loadShippingAddress() {
        if (this.shippingAddressRequest == null) {
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.shippingAddressRequest = userAPI2.requestShippingAddress().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new RewardPointUseActivity$loadShippingAddress$1<Object,Object>(this));
        }
    }

    private final void loadUsablePoint() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RewardPointUseActivity$loadUsablePoint$1(this), new RewardPointUseActivity$loadUsablePoint$2(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = "result";
        if (i != 100) {
            if (i != 200) {
                if (i != 300) {
                    super.onActivityResult(i, i2, intent);
                } else if (i2 == 1010) {
                    setResult(100);
                    finish();
                    overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
                }
            } else if (intent != null) {
                Result result = (Result) intent.getParcelableExtra(str);
                StringBuilder sb = new StringBuilder();
                sb.append("address search result ");
                sb.append(result);
                Logger.d(sb.toString(), new Object[0]);
                ((EditText) _$_findCachedViewById(C0010R$id.address1EditText)).setText(result.getAddress());
                this.shippingZipCodeSubject.onNext(result.getZoneCode());
            } else {
                Logger.d("address search cancelled", new Object[0]);
            }
        } else if (i2 == 1001 && intent != null) {
            ShopSearchActivity.Result result2 = (ShopSearchActivity.Result) intent.getParcelableExtra(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("shopSearch result ");
            sb2.append(result2);
            Logger.d(sb2.toString(), new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(result2.getUrl());
        } else if (i2 == 1002) {
            Logger.d("shopSearch Direct Input", new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).requestFocus();
        } else {
            Logger.d("shopSearch cancelled", new Object[0]);
        }
    }
}
