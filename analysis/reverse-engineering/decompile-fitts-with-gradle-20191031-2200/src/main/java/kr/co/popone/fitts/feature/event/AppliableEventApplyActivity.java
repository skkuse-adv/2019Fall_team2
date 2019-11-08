package kr.co.popone.fitts.feature.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.Result;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppliableEventApplyActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_NAME = "parameters";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable applyRequest;
    @NotNull
    public EventAPI eventAPI;
    /* access modifiers changed from: private */
    public boolean isCancelling;
    /* access modifiers changed from: private */
    public Disposable linkInfoRequest;
    /* access modifiers changed from: private */
    public Parameters parameters;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> selectedItemSubject;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        private final long eventID;
        @NotNull
        private final List<String> items;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readLong(), parcel.createStringArrayList());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r3v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.feature.event.AppliableEventApplyActivity.Parameters copy$default(kr.co.popone.fitts.feature.event.AppliableEventApplyActivity.Parameters r0, long r1, java.util.List<java.lang.String> r3, int r4, java.lang.Object r5) {
            /*
                r5 = r4 & 1
                if (r5 == 0) goto L_0x0006
                long r1 = r0.eventID
            L_0x0006:
                r4 = r4 & 2
                if (r4 == 0) goto L_0x000c
                java.util.List<java.lang.String> r3 = r0.items
            L_0x000c:
                kr.co.popone.fitts.feature.event.AppliableEventApplyActivity$Parameters r0 = r0.copy(r1, r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.AppliableEventApplyActivity.Parameters.copy$default(kr.co.popone.fitts.feature.event.AppliableEventApplyActivity$Parameters, long, java.util.List, int, java.lang.Object):kr.co.popone.fitts.feature.event.AppliableEventApplyActivity$Parameters");
        }

        public final long component1() {
            return this.eventID;
        }

        @NotNull
        public final List<String> component2() {
            return this.items;
        }

        @NotNull
        public final Parameters copy(long j, @NotNull List<String> list) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            return new Parameters(j, list);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (!(this.eventID == parameters.eventID) || !Intrinsics.areEqual((Object) this.items, (Object) parameters.items)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.eventID;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            List<String> list = this.items;
            return i + (list != null ? list.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(eventID=");
            sb.append(this.eventID);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.eventID);
            parcel.writeStringList(this.items);
        }

        public Parameters(long j, @NotNull List<String> list) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.eventID = j;
            this.items = list;
        }

        public final long getEventID() {
            return this.eventID;
        }

        @NotNull
        public final List<String> getItems() {
            return this.items;
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

    public AppliableEventApplyActivity() {
        BehaviorSubject<String> createDefault = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(\"\")");
        this.selectedItemSubject = createDefault;
    }

    public static final /* synthetic */ Parameters access$getParameters$p(AppliableEventApplyActivity appliableEventApplyActivity) {
        Parameters parameters2 = appliableEventApplyActivity.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameters");
        }
        return parameters2;
    }

    @NotNull
    public final EventAPI getEventAPI$app_productionFittsRelease() {
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        return eventAPI2;
    }

    public final void setEventAPI$app_productionFittsRelease(@NotNull EventAPI eventAPI2) {
        Intrinsics.checkParameterIsNotNull(eventAPI2, "<set-?>");
        this.eventAPI = eventAPI2;
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
        setContentView((int) C0013R$layout.activity_appliable_event_apply);
        String str = "parameters";
        Parcelable parcelableExtra = getIntent().getParcelableExtra(str);
        Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtra(PARAMETER_NAME)");
        this.parameters = (Parameters) parcelableExtra;
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray6));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new AppliableEventApplyActivity$onCreate$1(this));
        Parameters parameters2 = this.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        String str2 = "productNameTextView";
        if (parameters2.getItems().size() == 1) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.productNameTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, str2);
            Parameters parameters3 = this.parameters;
            if (parameters3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            textView.setText((CharSequence) CollectionsKt___CollectionsKt.first(parameters3.getItems()));
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.productMultiNameTextView);
            String str3 = "productMultiNameTextView";
            Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
            textView2.setVisibility(4);
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.productMultiNameTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
            textView3.getLayoutParams().height = 0;
            BehaviorSubject<String> behaviorSubject = this.selectedItemSubject;
            Parameters parameters4 = this.parameters;
            if (parameters4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            behaviorSubject.onNext(CollectionsKt___CollectionsKt.first(parameters4.getItems()));
        } else {
            Parameters parameters5 = this.parameters;
            if (parameters5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            if (parameters5.getItems().size() > 1) {
                TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.productNameTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
                textView4.setVisibility(4);
            } else {
                throw new IllegalAccessException("no items");
            }
        }
        this.selectedItemSubject.subscribe((Consumer<? super T>) new AppliableEventApplyActivity$onCreate$2<Object>(this));
        ((TextView) _$_findCachedViewById(C0010R$id.productMultiNameTextView)).setOnClickListener(new AppliableEventApplyActivity$onCreate$3(this));
        ((Button) _$_findCachedViewById(C0010R$id.shopSearchButton)).setOnClickListener(new AppliableEventApplyActivity$onCreate$4(this));
        ((Button) _$_findCachedViewById(C0010R$id.showUrlLinkButton)).setOnClickListener(new AppliableEventApplyActivity$onCreate$5(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        String str4 = "productDetailPageLinkEditText";
        Intrinsics.checkExpressionValueIsNotNull(editText, str4);
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str5 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str5);
        textChanges.map(AppliableEventApplyActivity$onCreate$6.INSTANCE).subscribe((Consumer<? super T>) new AppliableEventApplyActivity$onCreate$7<Object>(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str4);
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str5);
        textChanges2.subscribe((Consumer<? super T>) new AppliableEventApplyActivity$onCreate$8<Object>(this));
        ((TextView) _$_findCachedViewById(C0010R$id.pasteLinkTextView)).setOnClickListener(new AppliableEventApplyActivity$onCreate$9(this));
        BehaviorSubject<String> behaviorSubject2 = this.selectedItemSubject;
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, str4);
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str5);
        EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.productColorEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "productColorEditText");
        InitialValueObservable textChanges4 = RxTextView.textChanges(editText4);
        Intrinsics.checkExpressionValueIsNotNull(textChanges4, str5);
        EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.productSizeEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "productSizeEditText");
        InitialValueObservable textChanges5 = RxTextView.textChanges(editText5);
        Intrinsics.checkExpressionValueIsNotNull(textChanges5, str5);
        Observable.combineLatest(behaviorSubject2, textChanges3, textChanges4, textChanges5, AppliableEventApplyActivity$onCreate$10.INSTANCE).subscribe((Consumer<? super T>) new AppliableEventApplyActivity$onCreate$11<Object>(this));
        ((Button) _$_findCachedViewById(C0010R$id.eventApplyConfirmButton)).setOnClickListener(new AppliableEventApplyActivity$onCreate$12(this));
    }

    public void onBackPressed() {
        if (!this.isCancelling) {
            this.isCancelling = true;
            DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "정말 응모를 취소하시겠어요?", "작성중인 상품 정보가 사라집니다.", new AppliableEventApplyActivity$onBackPressed$1(this), new AppliableEventApplyActivity$onBackPressed$2(this), null, null, 0, 224, null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.linkInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.applyRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 100) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == 1001 && intent != null) {
            Result result = (Result) intent.getParcelableExtra("result");
            StringBuilder sb = new StringBuilder();
            sb.append("shopSearch result ");
            sb.append(result);
            Logger.d(sb.toString(), new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(result.getUrl());
        } else if (i2 == 1002) {
            Logger.d("shopSearch Direct Input", new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).requestFocus();
        } else {
            Logger.d("shopSearch cancelled", new Object[0]);
        }
    }
}
