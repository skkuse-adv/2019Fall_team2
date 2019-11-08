package kr.co.popone.fitts.viewmodel.search.home;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.model.search.StyleRecommendViewData;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.utils.ListUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class SearchViewModel extends BaseViewModel {
    private final PublishSubject<SearchState> currentSearchState;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    @NotNull
    private final MutableLiveData<List<String>> historyKeywords = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<List<String>> recommendKeywords = new MutableLiveData<>();
    private final SearchHistoryRepository searchHistoryRepository;
    private final SearchRepository searchRepository;
    @NotNull
    private final MutableLiveData<SearchState> searchState = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<List<StyleRecommendViewData>> styleKeywords = new MutableLiveData<>();

    public static abstract class SearchState {

        public static final class After extends SearchState {
            @NotNull
            private final String keyword;

            @NotNull
            public static /* synthetic */ After copy$default(After after, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = after.keyword;
                }
                return after.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.keyword;
            }

            @NotNull
            public final After copy(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
                return new After(str);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.keyword, (java.lang.Object) ((kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.After) r2).keyword) != false) goto L_0x0015;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                /*
                    r1 = this;
                    if (r1 == r2) goto L_0x0015
                    boolean r0 = r2 instanceof kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.After
                    if (r0 == 0) goto L_0x0013
                    kr.co.popone.fitts.viewmodel.search.home.SearchViewModel$SearchState$After r2 = (kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.After) r2
                    java.lang.String r0 = r1.keyword
                    java.lang.String r2 = r2.keyword
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
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.After.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                String str = this.keyword;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("After(keyword=");
                sb.append(this.keyword);
                sb.append(")");
                return sb.toString();
            }

            public After(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
                super(null);
                this.keyword = str;
            }

            @NotNull
            public final String getKeyword() {
                return this.keyword;
            }
        }

        public static final class Before extends SearchState {
            public static final Before INSTANCE = new Before();

            private Before() {
                super(null);
            }
        }

        public static final class Input extends SearchState {
            public static final Input INSTANCE = new Input();

            private Input() {
                super(null);
            }
        }

        private SearchState() {
        }

        public /* synthetic */ SearchState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SearchViewModel(@NotNull EventTracker eventTracker2, @NotNull SearchRepository searchRepository2, @NotNull SearchHistoryRepository searchHistoryRepository2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        Intrinsics.checkParameterIsNotNull(searchHistoryRepository2, "searchHistoryRepository");
        this.eventTracker = eventTracker2;
        this.searchRepository = searchRepository2;
        this.searchHistoryRepository = searchHistoryRepository2;
        PublishSubject<SearchState> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<SearchState>()");
        this.currentSearchState = create;
        loadSearchKeywords();
        requestRecommendSearch();
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.currentSearchState.subscribeOn(Schedulers.io()).distinctUntilChanged().throttleLast(200, TimeUnit.MILLISECONDS).doOnNext(new SearchViewModel$sam$io_reactivex_functions_Consumer$0(new Function1<SearchState, Unit>(this) {
            public final String getName() {
                return "updateSearchKeywordHistory";
            }

            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(SearchViewModel.class);
            }

            public final String getSignature() {
                return "updateSearchKeywordHistory(Lkr/co/popone/fitts/viewmodel/search/home/SearchViewModel$SearchState;)V";
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SearchState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SearchState searchState) {
                Intrinsics.checkParameterIsNotNull(searchState, "p1");
                ((SearchViewModel) this.receiver).updateSearchKeywordHistory(searchState);
            }
        })).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<SearchState>(this) {
            final /* synthetic */ SearchViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(SearchState searchState) {
                this.this$0.getSearchState().setValue(searchState);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "currentSearchState\n     …ue = it\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final MutableLiveData<List<String>> getHistoryKeywords() {
        return this.historyKeywords;
    }

    @NotNull
    public final MutableLiveData<List<String>> getRecommendKeywords() {
        return this.recommendKeywords;
    }

    @NotNull
    public final MutableLiveData<List<StyleRecommendViewData>> getStyleKeywords() {
        return this.styleKeywords;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@NotNull MutableLiveData<NetworkState> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.networkState = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<SearchState> getSearchState() {
        return this.searchState;
    }

    public final void keywordChange(@NotNull Observable<CharSequence> observable) {
        Intrinsics.checkParameterIsNotNull(observable, SearchResultFragment.KEY_KEYWORD);
        observable.map(new SearchViewModel$sam$io_reactivex_functions_Function$0(new SearchViewModel$keywordChange$1(this))).subscribe((Observer<? super T>) this.currentSearchState);
    }

    public final void searchButtonClick(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(charSequence, SearchResultFragment.KEY_KEYWORD);
        Intrinsics.checkParameterIsNotNull(str, "from");
        String obj = charSequence.toString();
        this.currentSearchState.onNext(new After(obj));
        leaveKeywordLog(str, obj);
    }

    /* access modifiers changed from: private */
    public final SearchState charSeqToState(CharSequence charSequence) {
        return charSequence.length() > 0 ? Input.INSTANCE : Before.INSTANCE;
    }

    private final void loadSearchKeywords() {
        SearchHistoryRepository searchHistoryRepository2 = this.searchHistoryRepository;
        searchHistoryRepository2.loadHistory();
        this.historyKeywords.setValue(searchHistoryRepository2.getHistory());
    }

    public final void removeSearchKyeword() {
        SearchHistoryRepository searchHistoryRepository2 = this.searchHistoryRepository;
        searchHistoryRepository2.setHistory(CollectionsKt__CollectionsKt.emptyList());
        searchHistoryRepository2.saveHistory();
        this.historyKeywords.setValue(searchHistoryRepository2.getHistory());
    }

    private final void requestRecommendSearch() {
        this.networkState.setValue(NetworkState.Companion.getLOADING());
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.searchRepository.getRecommendSearchList().subscribe((BiConsumer<? super T, ? super Throwable>) new SearchViewModel$requestRecommendSearch$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "searchRepository.getReco…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void updateSearchKeywordHistory(SearchState searchState2) {
        if (searchState2 instanceof After) {
            String keyword = ((After) searchState2).getKeyword();
            if (keyword.length() > 0) {
                SearchHistoryRepository searchHistoryRepository2 = this.searchHistoryRepository;
                searchHistoryRepository2.setHistory(ListUtilsKt.listUniqueInsert(searchHistoryRepository2.getHistory(), keyword, 10));
                searchHistoryRepository2.saveHistory();
                this.historyKeywords.postValue(searchHistoryRepository2.getHistory());
            }
        }
    }

    private final void leaveKeywordLog(String str, String str2) {
        this.eventTracker.logCustom("Search", new CustomAttributes().put("method", str).put(SearchResultFragment.KEY_KEYWORD, str2));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
