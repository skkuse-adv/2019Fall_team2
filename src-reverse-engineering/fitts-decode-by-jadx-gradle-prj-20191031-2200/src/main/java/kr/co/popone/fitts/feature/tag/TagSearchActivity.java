package kr.co.popone.fitts.feature.tag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.kakao.usermgmt.StringSet;
import com.paginate.Paginate;
import com.paginate.Paginate.Callbacks;
import com.paginate.recycler.LoadingListItemCreator;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TagSearchActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogUtil actionLogUtil;
    @Nullable
    private Long base;
    private final RecyclerDecorator decorator = new Builder().decoratorType(DecoratorType.DOUBLE).doubleLeftDecorator(0, 18, 8, 4).doubleRightDecorator(0, 18, 4, 8).build();
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public boolean isLoadingData;
    private boolean isTotalItemLoaded;
    private int limit = 10;
    /* access modifiers changed from: private */
    public Paginate paginate;
    @NotNull
    public PostAPI postAPI;
    @NotNull
    public String tag;
    /* access modifiers changed from: private */
    public ArrayList<Post> tagPostList = new ArrayList<>();
    /* access modifiers changed from: private */
    public Disposable tagPostListRequest;

    private final class CustomLoadingListItemCreator implements LoadingListItemCreator {
        public CustomLoadingListItemCreator() {
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.loading_list_item, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new VH(inflate);
        }

        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
            Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
            VH vh = (VH) viewHolder;
            if (TagSearchActivity.this.isTotalItemLoaded()) {
                vh.getLoadMoreItem().setVisibility(8);
            }
        }
    }

    public static final class VH extends ViewHolder {
        @NotNull
        private ProgressBar loadMoreItem;

        public VH(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.loading_progress);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.loading_progress)");
            this.loadMoreItem = (ProgressBar) findViewById;
        }

        @NotNull
        public final ProgressBar getLoadMoreItem() {
            return this.loadMoreItem;
        }

        public final void setLoadMoreItem(@NotNull ProgressBar progressBar) {
            Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
            this.loadMoreItem = progressBar;
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
    public final String getTag$app_productionFittsRelease() {
        String str = this.tag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(StringSet.tag);
        }
        return str;
    }

    public final void setTag$app_productionFittsRelease(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tag = str;
    }

    @NotNull
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
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

    @NotNull
    public final ActionLogUtil getActionLogUtil$app_productionFittsRelease() {
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        return actionLogUtil2;
    }

    public final void setActionLogUtil$app_productionFittsRelease(@NotNull ActionLogUtil actionLogUtil2) {
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "<set-?>");
        this.actionLogUtil = actionLogUtil2;
    }

    public final boolean isTotalItemLoaded() {
        return this.isTotalItemLoaded;
    }

    public final void setTotalItemLoaded(boolean z) {
        this.isTotalItemLoaded = z;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    @Nullable
    public final Long getBase$app_productionFittsRelease() {
        return this.base;
    }

    public final void setBase$app_productionFittsRelease(@Nullable Long l) {
        this.base = l;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_tag_search);
        Intent intent = getIntent();
        String str = StringSet.tag;
        String stringExtra = intent.getStringExtra(str);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(\"tag\")");
        this.tag = stringExtra;
        ((ImageButton) _$_findCachedViewById(C0010R$id.close_button)).setOnClickListener(new TagSearchActivity$onCreate$1(this));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.tag_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tag_title");
        String str2 = this.tag;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        textView.setText(str2);
        requestLikedPosts();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.tag_post_list);
        recyclerView.setAdapter(new TagSearchPostAdapter(new TagSearchActivity$onCreate$$inlined$run$lambda$1(this)));
        recyclerView.addItemDecoration(this.decorator);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "this");
        initPaginate(recyclerView);
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    public final void requestLikedPosts() {
        this.isLoadingData = true;
        Disposable disposable = this.tagPostListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        String str = this.tag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(StringSet.tag);
        }
        this.tagPostListRequest = postAPI2.getTagPosts(str, this.base, this.limit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new TagSearchActivity$requestLikedPosts$1<Object,Object>(this));
    }

    private final void initPaginate(RecyclerView recyclerView) {
        Paginate paginate2 = this.paginate;
        if (paginate2 != null) {
            if (paginate2 == null) {
                Intrinsics.throwNpe();
            }
            paginate2.unbind();
        }
        this.paginate = Paginate.with(recyclerView, (Callbacks) new TagSearchActivity$initPaginate$callbacks$1(this)).setLoadingTriggerThreshold(0).setLoadingListItemCreator(new CustomLoadingListItemCreator()).build();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.tagPostListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.tagPostListRequest = null;
        this.isTotalItemLoaded = false;
        this.isLoadingData = false;
        this.base = null;
        super.onDestroy();
    }
}
