package kr.co.popone.fitts.feature.recommend.fittie;

import android.view.ViewGroup;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.common.fittie.FittieRecommendViewHolder;
import kr.co.popone.fitts.feature.common.fittie.FittieRecommendViewHolder.Delegate;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.FittieRecommendHeader;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendAdapter extends BasePagedListAdapter<RecommendFittieInfo, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<RecommendFittieInfo> COMPARATOR = new FittieRecommendAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<RecommendFittieInfo> getCOMPARATOR() {
            return FittieRecommendAdapter.COMPARATOR;
        }
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public FittieRecommendAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == FittieRecommendHeaderViewHolder.Companion.getId()) {
            return FittieRecommendHeaderViewHolder.Companion.create(viewGroup);
        }
        if (i == FittieRecommendViewHolder.Companion.getId()) {
            return FittieRecommendViewHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolderWithoutLoading(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof FittieRecommendViewHolder) {
            BaseViewHolder.bind$default((FittieRecommendViewHolder) viewHolder, getItem(i), null, 2, null);
        } else if (viewHolder instanceof FittieRecommendHeaderViewHolder) {
            ((FittieRecommendHeaderViewHolder) viewHolder).bindTo();
        }
    }

    public int getItemViewTypeWithoutLoading(int i) {
        RecommendFittieInfo recommendFittieInfo = (RecommendFittieInfo) getItem(i);
        if (recommendFittieInfo instanceof FittieRecommendHeader) {
            return FittieRecommendHeaderViewHolder.Companion.getId();
        }
        if (recommendFittieInfo instanceof RecommendFittie) {
            return FittieRecommendViewHolder.Companion.getId();
        }
        return EmptyTypeHolder.Companion.getId();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        if (!(!list.isEmpty())) {
            super.onBindViewHolder(viewHolder, i, list);
        } else if (viewHolder instanceof FittieRecommendViewHolder) {
            FittieRecommendViewHolder fittieRecommendViewHolder = (FittieRecommendViewHolder) viewHolder;
            Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
            if (!(firstOrNull instanceof RecommendFittie)) {
                firstOrNull = null;
            }
            fittieRecommendViewHolder.update((RecommendFittie) firstOrNull);
        } else {
            super.onBindViewHolder(viewHolder, i, list);
        }
    }

    public final void updateFittieFollowing(long j, boolean z) {
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(currentList, 10));
            int i = 0;
            for (Object next : currentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                RecommendFittieInfo recommendFittieInfo = (RecommendFittieInfo) next;
                if (recommendFittieInfo instanceof RecommendFittie) {
                    RecommendFittie recommendFittie = (RecommendFittie) recommendFittieInfo;
                    if (j == recommendFittie.getUser().getId()) {
                        recommendFittie.getUser().setFollowing(z);
                        notifyItemChanged(i, recommendFittieInfo);
                    }
                }
                arrayList.add(Unit.INSTANCE);
                i = i2;
            }
        }
    }
}
