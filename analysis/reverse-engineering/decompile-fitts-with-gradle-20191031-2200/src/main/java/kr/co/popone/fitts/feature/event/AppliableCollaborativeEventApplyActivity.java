package kr.co.popone.fitts.feature.event;

import android.app.Activity;
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
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppliableCollaborativeEventApplyActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AppliableCollaborativeEventApplyActivity.class), "parameters", "getParameters()Lkr/co/popone/fitts/feature/event/AppliableCollaborativeEventApplyActivity$Parameters;"))};
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
    private final Lazy parameters$delegate = LazyKt__LazyJVMKt.lazy(new AppliableCollaborativeEventApplyActivity$parameters$2(this));

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
        private final String linkUrl;
        @NotNull
        private final Shop shop;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readLong(), parcel.readString(), (Shop) Shop.CREATOR.createFromParcel(parcel));
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, String str, Shop shop2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parameters.eventID;
            }
            if ((i & 2) != 0) {
                str = parameters.linkUrl;
            }
            if ((i & 4) != 0) {
                shop2 = parameters.shop;
            }
            return parameters.copy(j, str, shop2);
        }

        public final long component1() {
            return this.eventID;
        }

        @NotNull
        public final String component2() {
            return this.linkUrl;
        }

        @NotNull
        public final Shop component3() {
            return this.shop;
        }

        @NotNull
        public final Parameters copy(long j, @NotNull String str, @NotNull Shop shop2) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrl");
            Intrinsics.checkParameterIsNotNull(shop2, "shop");
            return new Parameters(j, str, shop2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (!(this.eventID == parameters.eventID) || !Intrinsics.areEqual((Object) this.linkUrl, (Object) parameters.linkUrl) || !Intrinsics.areEqual((Object) this.shop, (Object) parameters.shop)) {
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
            String str = this.linkUrl;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Shop shop2 = this.shop;
            if (shop2 != null) {
                i2 = shop2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(eventID=");
            sb.append(this.eventID);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", shop=");
            sb.append(this.shop);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.eventID);
            parcel.writeString(this.linkUrl);
            this.shop.writeToParcel(parcel, 0);
        }

        public Parameters(long j, @NotNull String str, @NotNull Shop shop2) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrl");
            Intrinsics.checkParameterIsNotNull(shop2, "shop");
            this.eventID = j;
            this.linkUrl = str;
            this.shop = shop2;
        }

        public final long getEventID() {
            return this.eventID;
        }

        @NotNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @NotNull
        public final Shop getShop() {
            return this.shop;
        }
    }

    /* access modifiers changed from: private */
    public final Parameters getParameters() {
        Lazy lazy = this.parameters$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Parameters) lazy.getValue();
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_appliable_collaborative_event_apply);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(ContextCompat.getColor(this, C0006R$color.gray6));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new AppliableCollaborativeEventApplyActivity$onCreate$1(this));
        StringBuilder sb = new StringBuilder();
        sb.append("parameters : ");
        sb.append(getParameters());
        Logger.d(sb.toString(), new Object[0]);
        ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(getParameters().getLinkUrl());
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.shopNameTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "shopNameTextView");
        textView.setText(getParameters().getShop().getName());
        ((Button) _$_findCachedViewById(C0010R$id.showUrlLinkButton)).setOnClickListener(new AppliableCollaborativeEventApplyActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.eventApplyConfirmButton)).setOnClickListener(new AppliableCollaborativeEventApplyActivity$onCreate$3(this));
    }

    public void onBackPressed() {
        if (!this.isCancelling) {
            this.isCancelling = true;
            DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "정말 응모를 취소하시겠어요?", "작성중인 상품 정보가 사라집니다.", new AppliableCollaborativeEventApplyActivity$onBackPressed$1(this), new AppliableCollaborativeEventApplyActivity$onBackPressed$2(this), null, null, 0, 224, null);
        }
    }

    /* access modifiers changed from: private */
    public final void dismissActivity() {
        setResult(0);
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.applyRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
