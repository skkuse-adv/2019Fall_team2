package kr.co.popone.fitts.feature.category;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.category.CategoryPostAdapter.Delegate;
import kr.co.popone.fitts.feature.common.product.ProductFeedAdapter;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI.DefaultImpls;
import kr.co.popone.fitts.paging.category.CategoryFeedListSourceFactory;
import kr.co.popone.fitts.paging.product.ProductFeedListSourceFactory;
import kr.co.popone.fitts.repository.CategoryRepository;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategorySearchFragment extends Fragment implements Delegate, ProductFeedHolder.Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CategorySearchFragment.class), "productDecorator", "getProductDecorator()Lkr/co/popone/fitts/ui/decorator/RecyclerDecorator;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CategorySearchFragment.class), "postDecorator", "getPostDecorator()Lkr/co/popone/fitts/ui/decorator/RecyclerDecorator;"))};
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_POST_TYPE = StringKeyGenerator.Companion.generate(CategorySearchFragment.class, "post_Typoe");
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogAPI actionLogAPI;
    @NotNull
    public CategoryRepository categoryRepository;
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;
    private final Lazy postDecorator$delegate = LazyKt__LazyJVMKt.lazy(CategorySearchFragment$postDecorator$2.INSTANCE);
    /* access modifiers changed from: private */
    public final CategoryPostAdapter postFeedAdapter = new CategoryPostAdapter(this);
    private final Lazy productDecorator$delegate = LazyKt__LazyJVMKt.lazy(CategorySearchFragment$productDecorator$2.INSTANCE);
    /* access modifiers changed from: private */
    public final ProductFeedAdapter productFeedAdapter = new ProductFeedAdapter(this);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CategorySearchFragment newInstance(int i, @Nullable Integer num, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "postType");
            CategorySearchFragment categorySearchFragment = new CategorySearchFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key_category", i);
            bundle.putInt("key_sub_category", num != null ? num.intValue() : -1);
            bundle.putString(CategorySearchFragment.KEY_POST_TYPE, str);
            categorySearchFragment.setArguments(bundle);
            return categorySearchFragment;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[Status.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[CategoryFeedType.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
            $EnumSwitchMapping$1[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$1[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$1[Status.FAILED.ordinal()] = 3;
            $EnumSwitchMapping$2[CategoryFeedType.PRODUCT.ordinal()] = 1;
            $EnumSwitchMapping$2[CategoryFeedType.POST.ordinal()] = 2;
        }
    }

    private final RecyclerDecorator getPostDecorator() {
        Lazy lazy = this.postDecorator$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (RecyclerDecorator) lazy.getValue();
    }

    private final RecyclerDecorator getProductDecorator() {
        Lazy lazy = this.productDecorator$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (RecyclerDecorator) lazy.getValue();
    }

    @NotNull
    public static final CategorySearchFragment newInstance(int i, @Nullable Integer num, @NotNull String str) {
        return Companion.newInstance(i, num, str);
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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final CategoryRepository getCategoryRepository() {
        CategoryRepository categoryRepository2 = this.categoryRepository;
        if (categoryRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryRepository");
        }
        return categoryRepository2;
    }

    public final void setCategoryRepository(@NotNull CategoryRepository categoryRepository2) {
        Intrinsics.checkParameterIsNotNull(categoryRepository2, "<set-?>");
        this.categoryRepository = categoryRepository2;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    @NotNull
    public final ActionLogAPI getActionLogAPI() {
        ActionLogAPI actionLogAPI2 = this.actionLogAPI;
        if (actionLogAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
        }
        return actionLogAPI2;
    }

    public final void setActionLogAPI(@NotNull ActionLogAPI actionLogAPI2) {
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "<set-?>");
        this.actionLogAPI = actionLogAPI2;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_category_search, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        initializeRecyclerView();
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.categorySearchRefresh)).setOnRefreshListener(new CategorySearchFragment$onViewCreated$1(this));
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribe((Consumer<? super T>) new CategorySearchFragment$onViewCreated$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void getPostFeeds() {
        if (isAdded()) {
            Bundle arguments = getArguments();
            Integer num = null;
            Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("key_category")) : null;
            Bundle arguments2 = getArguments();
            Integer valueOf2 = arguments2 != null ? Integer.valueOf(arguments2.getInt("key_sub_category")) : null;
            CategoryRepository categoryRepository2 = this.categoryRepository;
            if (categoryRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryRepository");
            }
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            int intValue = valueOf.intValue();
            if (valueOf2 == null || valueOf2.intValue() != -1) {
                num = valueOf2;
            }
            CategoryFeedListSourceFactory categoryFeedListSourceFactory = new CategoryFeedListSourceFactory(categoryRepository2, intValue, num);
            LiveData build = new LivePagedListBuilder((Factory<Key, Value>) categoryFeedListSourceFactory, getPagedListConfig()).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(fac…agedListConfig()).build()");
            build.observe(new CategorySearchFragment$getPostFeeds$1(this), new CategorySearchFragment$getPostFeeds$2(this));
            Transformations.switchMap(categoryFeedListSourceFactory.getCategoryFeedLiveData(), CategorySearchFragment$getPostFeeds$3.INSTANCE).observe(new CategorySearchFragment$getPostFeeds$4(this), new CategorySearchFragment$getPostFeeds$5(this));
        }
    }

    /* access modifiers changed from: private */
    public final void getProductFeeds() {
        if (isAdded()) {
            Bundle arguments = getArguments();
            Integer num = null;
            Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("key_category")) : null;
            Bundle arguments2 = getArguments();
            Integer valueOf2 = arguments2 != null ? Integer.valueOf(arguments2.getInt("key_sub_category")) : null;
            CategoryRepository categoryRepository2 = this.categoryRepository;
            if (categoryRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryRepository");
            }
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            int intValue = valueOf.intValue();
            if (valueOf2 == null || valueOf2.intValue() != -1) {
                num = valueOf2;
            }
            ProductFeedListSourceFactory productFeedListSourceFactory = new ProductFeedListSourceFactory(categoryRepository2, intValue, num);
            LiveData build = new LivePagedListBuilder((Factory<Key, Value>) productFeedListSourceFactory, getPagedListConfig()).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(pro…agedListConfig()).build()");
            build.observe(new CategorySearchFragment$getProductFeeds$1(this), new CategorySearchFragment$getProductFeeds$2(this));
            Transformations.switchMap(productFeedListSourceFactory.getProductFeedLiveData(), CategorySearchFragment$getProductFeeds$3.INSTANCE).observe(new CategorySearchFragment$getProductFeeds$4(this), new CategorySearchFragment$getProductFeeds$5(this));
        }
    }

    private final Config getPagedListConfig() {
        Config build = new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(30).setPageSize(30).setPrefetchDistance(3).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "PagedList.Config.Builder…                 .build()");
        return build;
    }

    private final void initializeRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new CategorySearchFragment$initializeRecyclerView$$inlined$apply$lambda$1(this));
        recyclerView.setLayoutManager(gridLayoutManager);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(KEY_POST_TYPE, HttpRequest.METHOD_POST) : null;
        if (string == null) {
            Intrinsics.throwNpe();
        }
        updateRecyclerAdapterAndDecorator(CategoryFeedType.valueOf(string));
    }

    /* access modifiers changed from: private */
    public final int getSpanSizeByViewType(int i) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        Adapter adapter = recyclerView.getAdapter();
        int i2 = 3;
        if (adapter instanceof CategoryPostAdapter) {
            if (this.postFeedAdapter.getItemViewType(i) != 2131558709) {
                i2 = 1;
            }
            return i2;
        } else if (adapter instanceof ProductFeedAdapter) {
            if (this.productFeedAdapter.getItemViewType(i) != 2131558709) {
                i2 = 1;
            }
            return i2;
        } else {
            throw new IllegalAccessException();
        }
    }

    /* access modifiers changed from: private */
    public final void updateRecyclerAdapterAndDecorator(CategoryFeedType categoryFeedType) {
        if (isAdded()) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
            if (recyclerView.getItemDecorationCount() > 0) {
                recyclerView.removeItemDecorationAt(0);
            }
            int i = WhenMappings.$EnumSwitchMapping$2[categoryFeedType.ordinal()];
            String str = "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager";
            String str2 = "recyclerView";
            if (i == 1) {
                LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    ((GridLayoutManager) layoutManager).setSpanCount(3);
                    recyclerView.addItemDecoration(getProductDecorator());
                    RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
                    recyclerView2.setAdapter(this.productFeedAdapter);
                    getProductFeeds();
                } else {
                    throw new TypeCastException(str);
                }
            } else if (i == 2) {
                LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                if (layoutManager2 != null) {
                    ((GridLayoutManager) layoutManager2).setSpanCount(3);
                    recyclerView.addItemDecoration(getPostDecorator());
                    RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str2);
                    recyclerView3.setAdapter(this.postFeedAdapter);
                    getPostFeeds();
                } else {
                    throw new TypeCastException(str);
                }
            }
        }
    }

    public void onPostClick(long j) {
        kr.co.popone.fitts.feature.post.detail.PostActivity.Companion.start$default(PostActivity.Companion, getContext(), j, null, 4, null);
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.logCustom("View Post", new CustomAttributes().put("from", "category"));
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("key_sub_category");
            ActionLogAPI actionLogAPI2 = this.actionLogAPI;
            if (actionLogAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
            }
            DefaultImpls.collectActionLog$default(actionLogAPI2, "Post", "Category", null, getActionLogId(i), null, 16, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CategorySearchFragment$onPostClick$1$1(i), CategorySearchFragment$onPostClick$1$2.INSTANCE);
        }
    }

    public void onProductClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(StoreBrowserActivity.Companion, getContext(), str, "category", null, null, 24, null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("key_sub_category");
            ActionLogAPI actionLogAPI2 = this.actionLogAPI;
            if (actionLogAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
            }
            DefaultImpls.collectActionLog$default(actionLogAPI2, "Product", "Category", null, getActionLogId(i), null, 16, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CategorySearchFragment$onProductClicked$1$1(i), CategorySearchFragment$onProductClicked$1$2.INSTANCE);
        }
    }

    private final Long getActionLogId(int i) {
        if (i == -1) {
            return null;
        }
        return Long.valueOf((long) i);
    }

    public void onDestroy() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.disposable.dispose();
        super.onDestroy();
    }
}
