package kr.co.popone.fitts.feature.post.notification;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.PostInvoice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostDeleteNotificationDetailActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETERS_KEY = "parameters";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final SimpleDateFormat dateFormat = new SimpleDateFormat("M월 d일", Locale.getDefault());
    @NotNull
    public PostAPI postAPI;
    private long postID;
    /* access modifiers changed from: private */
    public Disposable postInvoiceRequest;
    /* access modifiers changed from: private */
    public final BehaviorSubject<PostInvoice> postInvoiceSubject;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        private final long postID;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readLong());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parameters.postID;
            }
            return parameters.copy(j);
        }

        public final long component1() {
            return this.postID;
        }

        @NotNull
        public final Parameters copy(long j) {
            return new Parameters(j);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (this.postID == ((Parameters) obj).postID) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.postID;
            return (int) (j ^ (j >>> 32));
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(postID=");
            sb.append(this.postID);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.postID);
        }

        public Parameters(long j) {
            this.postID = j;
        }

        public final long getPostID() {
            return this.postID;
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

    public PostDeleteNotificationDetailActivity() {
        BehaviorSubject<PostInvoice> create = BehaviorSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "BehaviorSubject.create<PostAPI.PostInvoice>()");
        this.postInvoiceSubject = create;
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
        setContentView((int) C0013R$layout.activity_post_delete_notification_detail);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C0010R$id.toolbar));
        this.postID = ((Parameters) getIntent().getParcelableExtra("parameters")).getPostID();
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new PostDeleteNotificationDetailActivity$onCreate$1(this));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.mainDescriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "mainDescriptionTextView");
        String str = "";
        textView.setText(str);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.postTitleTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "postTitleTextView");
        textView2.setText(str);
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.deletePostReasonTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "deletePostReasonTextView");
        textView3.setText(str);
        this.postInvoiceSubject.subscribe((Consumer<? super T>) new PostDeleteNotificationDetailActivity$onCreate$2<Object>(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout)).setOnRefreshListener(new PostDeleteNotificationDetailActivity$onCreate$3(this));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        loadDataIfNeeded();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.postInvoiceRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: private */
    public final void loadDataIfNeeded() {
        String str = "swipeRefreshLayout";
        if (this.postInvoiceSubject.getValue() == null && this.postInvoiceRequest == null) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
            PostAPI postAPI2 = this.postAPI;
            if (postAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postAPI");
            }
            this.postInvoiceRequest = postAPI2.requestPostInvoice(this.postID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostDeleteNotificationDetailActivity$loadDataIfNeeded$1<Object,Object>(this));
            return;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
        swipeRefreshLayout2.setRefreshing(false);
    }
}
