package kr.co.popone.fitts.feature.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.SearchBar.State;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopSearchActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_NAME = "parameters";
    public static final int RESULT_DIRECT_INPUT = 1002;
    @NotNull
    public static final String RESULT_KEY = "result";
    public static final int RESULT_SUCCESS = 1001;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean canLoadMore;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public List<ShopEntry> resultShops = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public Disposable resultShopsDisposable;
    /* access modifiers changed from: private */
    public int resultShopsTotalCount;
    @NotNull
    public SearchAPI searchAPI;
    @NotNull
    public SearchHistoryRepository searchHistoryRepository;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        @Nullable
        private final String confirmMessage;
        @Nullable
        private final Integer copyLinkIcon;
        @Nullable
        private final String linkCopyMessage;
        @Nullable
        private final String linkCopyTitle;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        public Parameters() {
            this(null, null, null, null, 15, null);
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, String str, Integer num, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parameters.confirmMessage;
            }
            if ((i & 2) != 0) {
                num = parameters.copyLinkIcon;
            }
            if ((i & 4) != 0) {
                str2 = parameters.linkCopyTitle;
            }
            if ((i & 8) != 0) {
                str3 = parameters.linkCopyMessage;
            }
            return parameters.copy(str, num, str2, str3);
        }

        @Nullable
        public final String component1() {
            return this.confirmMessage;
        }

        @Nullable
        public final Integer component2() {
            return this.copyLinkIcon;
        }

        @Nullable
        public final String component3() {
            return this.linkCopyTitle;
        }

        @Nullable
        public final String component4() {
            return this.linkCopyMessage;
        }

        @NotNull
        public final Parameters copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
            return new Parameters(str, num, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.linkCopyMessage, (java.lang.Object) r3.linkCopyMessage) != false) goto L_0x0033;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0033
                boolean r0 = r3 instanceof kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters
                if (r0 == 0) goto L_0x0031
                kr.co.popone.fitts.feature.search.ShopSearchActivity$Parameters r3 = (kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters) r3
                java.lang.String r0 = r2.confirmMessage
                java.lang.String r1 = r3.confirmMessage
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0031
                java.lang.Integer r0 = r2.copyLinkIcon
                java.lang.Integer r1 = r3.copyLinkIcon
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = r2.linkCopyTitle
                java.lang.String r1 = r3.linkCopyTitle
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = r2.linkCopyMessage
                java.lang.String r3 = r3.linkCopyMessage
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x0031
                goto L_0x0033
            L_0x0031:
                r3 = 0
                return r3
            L_0x0033:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.confirmMessage;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.copyLinkIcon;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str2 = this.linkCopyTitle;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.linkCopyMessage;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(confirmMessage=");
            sb.append(this.confirmMessage);
            sb.append(", copyLinkIcon=");
            sb.append(this.copyLinkIcon);
            sb.append(", linkCopyTitle=");
            sb.append(this.linkCopyTitle);
            sb.append(", linkCopyMessage=");
            sb.append(this.linkCopyMessage);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            int i2;
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.confirmMessage);
            Integer num = this.copyLinkIcon;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.linkCopyTitle);
            parcel.writeString(this.linkCopyMessage);
        }

        public Parameters(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
            this.confirmMessage = str;
            this.copyLinkIcon = num;
            this.linkCopyTitle = str2;
            this.linkCopyMessage = str3;
        }

        @Nullable
        public final String getConfirmMessage() {
            return this.confirmMessage;
        }

        @Nullable
        public final Integer getCopyLinkIcon() {
            return this.copyLinkIcon;
        }

        @Nullable
        public final String getLinkCopyTitle() {
            return this.linkCopyTitle;
        }

        public /* synthetic */ Parameters(String str, Integer num, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            this(str, num, str2, str3);
        }

        @Nullable
        public final String getLinkCopyMessage() {
            return this.linkCopyMessage;
        }
    }

    public static final class Result implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        @NotNull
        private final String url;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Result(parcel.readString());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        @NotNull
        public static /* synthetic */ Result copy$default(Result result, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.url;
            }
            return result.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @NotNull
        public final Result copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            return new Result(str);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.url, (java.lang.Object) ((kr.co.popone.fitts.feature.search.ShopSearchActivity.Result) r2).url) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.feature.search.ShopSearchActivity.Result
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.feature.search.ShopSearchActivity$Result r2 = (kr.co.popone.fitts.feature.search.ShopSearchActivity.Result) r2
                java.lang.String r0 = r1.url
                java.lang.String r2 = r2.url
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.search.ShopSearchActivity.Result.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.url;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Result(url=");
            sb.append(this.url);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.url);
        }

        public Result(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            this.url = str;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[State.values().length];

        static {
            $EnumSwitchMapping$0[State.BEFORE_INPUT.ordinal()] = 1;
            $EnumSwitchMapping$0[State.INPUT.ordinal()] = 2;
            $EnumSwitchMapping$0[State.AFTER_INPUT.ordinal()] = 3;
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
    public final SearchAPI getSearchAPI$app_productionFittsRelease() {
        SearchAPI searchAPI2 = this.searchAPI;
        if (searchAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAPI");
        }
        return searchAPI2;
    }

    public final void setSearchAPI$app_productionFittsRelease(@NotNull SearchAPI searchAPI2) {
        Intrinsics.checkParameterIsNotNull(searchAPI2, "<set-?>");
        this.searchAPI = searchAPI2;
    }

    @NotNull
    public final SearchHistoryRepository getSearchHistoryRepository$app_productionFittsRelease() {
        SearchHistoryRepository searchHistoryRepository2 = this.searchHistoryRepository;
        if (searchHistoryRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHistoryRepository");
        }
        return searchHistoryRepository2;
    }

    public final void setSearchHistoryRepository$app_productionFittsRelease(@NotNull SearchHistoryRepository searchHistoryRepository2) {
        Intrinsics.checkParameterIsNotNull(searchHistoryRepository2, "<set-?>");
        this.searchHistoryRepository = searchHistoryRepository2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_shop_search);
        Parameters parameters = (Parameters) getIntent().getParcelableExtra("parameters");
        Observable observeOn = ((SearchBar) _$_findCachedViewById(C0010R$id.searchBar)).stateChanges().subscribeOn(Schedulers.io()).distinctUntilChanged().throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "searchBar.stateChanges()…dSchedulers.mainThread())");
        DisposableKt.addTo(SubscribersKt.subscribeBy$default(observeOn, (Function1) null, (Function0) null, (Function1) new ShopSearchActivity$onCreate$1(this), 3, (Object) null), this.disposables);
        ((SearchBar) _$_findCachedViewById(C0010R$id.searchBar)).setCancelListener(new ShopSearchActivity$onCreate$2(this));
        ((SearchHistoryView) _$_findCachedViewById(C0010R$id.searchHistoryView)).setDelegate(new ShopSearchActivity$onCreate$3(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.shopResultView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "shopResultView");
        recyclerView.setAdapter(new ShopResultAdapter(this, new ShopSearchActivity$onCreate$4(this, parameters)));
        ((RecyclerView) _$_findCachedViewById(C0010R$id.shopResultView)).addOnScrollListener(new ShopSearchActivity$onCreate$5(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout)).setOnRefreshListener(new ShopSearchActivity$onCreate$6(this));
        ((TextView) _$_findCachedViewById(C0010R$id.inputDirectLinkButton)).setOnClickListener(new ShopSearchActivity$onCreate$7(this));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.emptyResultLinkPasteDescriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "emptyResultLinkPasteDescriptionTextView");
        textView.setText("포스트작성 페이지의 ");
        SpannableString spannableString = new SpannableString("링크 붙여넣기");
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
        ((TextView) _$_findCachedViewById(C0010R$id.emptyResultLinkPasteDescriptionTextView)).append(spannableString);
        ((TextView) _$_findCachedViewById(C0010R$id.emptyResultLinkPasteDescriptionTextView)).append("를 누르고 붙여넣으면 끝!");
        loadSearchHistory();
        ((SearchBar) _$_findCachedViewById(C0010R$id.searchBar)).changeSearchBarState(State.INPUT);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposables.dispose();
        Disposable disposable = this.resultShopsDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 100) {
            if (intent != null) {
                String str = "result";
                kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result result = (kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result) intent.getParcelableExtra(str);
                Intent intent2 = new Intent();
                intent2.putExtra(str, new Result(result.getUrl()));
                setResult(1001, intent2);
                finish();
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private final void loadSearchHistory() {
        SearchHistoryRepository searchHistoryRepository2 = this.searchHistoryRepository;
        String str = "searchHistoryRepository";
        if (searchHistoryRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchHistoryRepository2.loadHistory();
        SearchHistoryView searchHistoryView = (SearchHistoryView) _$_findCachedViewById(C0010R$id.searchHistoryView);
        SearchHistoryRepository searchHistoryRepository3 = this.searchHistoryRepository;
        if (searchHistoryRepository3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchHistoryView.setItems(searchHistoryRepository3.getHistory());
    }

    /* access modifiers changed from: private */
    public final void searchShop(boolean z) {
        Disposable disposable = this.resultShopsDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        String str = "swipeRefreshLayout";
        if (z) {
            this.resultShops = CollectionsKt__CollectionsKt.emptyList();
            this.resultShopsTotalCount = 0;
            reloadShopResults();
            this.canLoadMore = false;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        }
        if (StringsKt__StringsJVMKt.isBlank(((SearchBar) _$_findCachedViewById(C0010R$id.searchBar)).getText())) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
            return;
        }
        SearchAPI searchAPI2 = this.searchAPI;
        if (searchAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAPI");
        }
        this.resultShopsDisposable = searchAPI2.searchShops(((SearchBar) _$_findCachedViewById(C0010R$id.searchBar)).getText().toString(), true ^ this.resultShops.isEmpty() ? Long.valueOf(((ShopEntry) CollectionsKt___CollectionsKt.last(this.resultShops)).getId()) : null, Integer.valueOf(20)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ShopSearchActivity$searchShop$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void reloadShopResults() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setVisibility(0);
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C0010R$id.emptyResultView);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "emptyResultView");
        scrollView.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.shopResultView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "shopResultView");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void showEmptyResultView() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setVisibility(8);
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C0010R$id.emptyResultView);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "emptyResultView");
        scrollView.setVisibility(0);
    }
}
