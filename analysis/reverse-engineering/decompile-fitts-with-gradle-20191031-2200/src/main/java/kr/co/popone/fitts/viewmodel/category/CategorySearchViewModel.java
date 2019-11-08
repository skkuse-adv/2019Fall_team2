package kr.co.popone.fitts.viewmodel.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.model.category.SubCategoryViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategorySearchViewModel extends BaseViewModel {
    private final PublishSubject<List<CategoryViewData>> categories;
    @NotNull
    private final MutableLiveData<List<CategoryViewData>> categoriesLiveData;
    private final PublishSubject<Integer> categoryPosition;
    @NotNull
    private final MutableLiveData<Integer> categoryPositionLiveData;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    @Nullable
    private LiveData<NetworkState> networkState;
    @NotNull
    private final MutableLiveData<List<SubCategoryViewData>> subCategoriesLiveData;
    private final PublishSubject<Integer> subCategoryPosition;
    @NotNull
    private final MutableLiveData<Integer> subCategoryPositionLiveData;

    public CategorySearchViewModel(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.eventTracker = eventTracker2;
        PublishSubject<List<CategoryViewData>> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<List<CategoryViewData>>()");
        this.categories = create;
        PublishSubject<Integer> create2 = PublishSubject.create();
        String str = "PublishSubject.create<Int>()";
        Intrinsics.checkExpressionValueIsNotNull(create2, str);
        this.categoryPosition = create2;
        PublishSubject<Integer> create3 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create3, str);
        this.subCategoryPosition = create3;
        this.subCategoriesLiveData = new MutableLiveData<>();
        this.categoriesLiveData = new MutableLiveData<>();
        this.categoryPositionLiveData = new MutableLiveData<>();
        this.subCategoryPositionLiveData = new MutableLiveData<>();
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = Observables.INSTANCE.combineLatest(this.categories, this.categoryPosition).map(AnonymousClass1.INSTANCE).subscribe((Consumer<? super T>) new Consumer<List<? extends SubCategoryViewData>>(this) {
            final /* synthetic */ CategorySearchViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(List<SubCategoryViewData> list) {
                this.this$0.getSubCategoriesLiveData().setValue(list);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observables.combineLates…                        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposables;
        Observable combineLatest = Observables.INSTANCE.combineLatest((Observable<T1>) this.categories, (Observable<T2>) this.categoryPosition, (Observable<T3>) this.subCategoryPosition);
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Integer valueOf = Integer.valueOf(0);
        Disposable subscribe2 = combineLatest.first(new Triple(emptyList, valueOf, valueOf)).subscribe(new Consumer<Triple<? extends List<? extends CategoryViewData>, ? extends Integer, ? extends Integer>>(this) {
            final /* synthetic */ CategorySearchViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Triple<? extends List<CategoryViewData>, Integer, Integer> triple) {
                this.this$0.getCategoriesLiveData().setValue(triple.getFirst());
                this.this$0.getCategoryPositionLiveData().setValue(triple.getSecond());
                this.this$0.getSubCategoryPositionLiveData().setValue(triple.getThird());
            }
        }, AnonymousClass4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "Observables.combineLates…                       })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Nullable
    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable LiveData<NetworkState> liveData) {
        this.networkState = liveData;
    }

    @NotNull
    public final MutableLiveData<List<SubCategoryViewData>> getSubCategoriesLiveData() {
        return this.subCategoriesLiveData;
    }

    @NotNull
    public final MutableLiveData<List<CategoryViewData>> getCategoriesLiveData() {
        return this.categoriesLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> getCategoryPositionLiveData() {
        return this.categoryPositionLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> getSubCategoryPositionLiveData() {
        return this.subCategoryPositionLiveData;
    }

    public final void logTapToSwitchCategoryContent(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "tabName");
        this.eventTracker.customLogTapToSwitchCategoryContent(str);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
