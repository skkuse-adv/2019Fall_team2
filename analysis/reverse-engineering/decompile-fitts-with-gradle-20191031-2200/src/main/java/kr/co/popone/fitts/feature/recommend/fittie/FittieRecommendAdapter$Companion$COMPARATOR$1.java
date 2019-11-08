package kr.co.popone.fitts.feature.recommend.fittie;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendAdapter$Companion$COMPARATOR$1 extends ItemCallback<RecommendFittieInfo> {
    FittieRecommendAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull RecommendFittieInfo recommendFittieInfo, @NotNull RecommendFittieInfo recommendFittieInfo2) {
        Intrinsics.checkParameterIsNotNull(recommendFittieInfo, "oldItem");
        Intrinsics.checkParameterIsNotNull(recommendFittieInfo2, "newItem");
        if (!(recommendFittieInfo instanceof RecommendFittie) || !(recommendFittieInfo2 instanceof RecommendFittie) || ((RecommendFittie) recommendFittieInfo).getUser().getId() != ((RecommendFittie) recommendFittieInfo2).getUser().getId()) {
            return false;
        }
        return true;
    }

    public boolean areContentsTheSame(@NotNull RecommendFittieInfo recommendFittieInfo, @NotNull RecommendFittieInfo recommendFittieInfo2) {
        Intrinsics.checkParameterIsNotNull(recommendFittieInfo, "oldItem");
        Intrinsics.checkParameterIsNotNull(recommendFittieInfo2, "newItem");
        if (!(recommendFittieInfo instanceof RecommendFittie) || !(recommendFittieInfo2 instanceof RecommendFittie) || ((RecommendFittie) recommendFittieInfo).getUser().isFollowing() != ((RecommendFittie) recommendFittieInfo2).getUser().isFollowing()) {
            return false;
        }
        return true;
    }
}
