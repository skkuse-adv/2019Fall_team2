package kr.co.popone.fitts.feature.common.fittie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.decorator.SimpleOffsetDecorator;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittieRecommendViewHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;
    private final FittieRecommendPostAdapter postAdapter = new FittieRecommendPostAdapter();

    public interface Delegate {
        void onFollowButtonClicked(long j);

        void onUnFollowButtonClicked(long j);
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_recommend_fittie;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FittieRecommendViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recommend_fittie, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FittieRecommendViewHolder(inflate, delegate);
        }
    }

    public void clear() {
    }

    public FittieRecommendViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof RecommendFittie) {
            initView((RecommendFittie) t);
        }
    }

    public final void initView(@NotNull RecommendFittie recommendFittie) {
        Intrinsics.checkParameterIsNotNull(recommendFittie, "recommendFittie");
        View view = this.itemView;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.userProfileImageView);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "userProfileImageView");
        ImageViewExtensionKt.loadImageAsProfile(circleImageView, recommendFittie.getUser().getProfileImageUrl());
        TextView textView = (TextView) view.findViewById(C0010R$id.userNicknameTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "userNicknameTextView");
        textView.setText(recommendFittie.getUser().getFittsID());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.userBodyTypeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "userBodyTypeTextView");
        BodyInfo bodyInfo = recommendFittie.getUser().getBodyInfo();
        textView2.setText(bodyInfo != null ? bodyInfo.toSimpleInfo() : null);
        BodyInfo bodyInfo2 = recommendFittie.getUser().getBodyInfo();
        if (bodyInfo2 != null) {
            ((ImageView) view.findViewById(C0010R$id.userBodyTypeIconImageView)).setImageResource(bodyInfo2.getBodyIconResource());
        }
        TextView textView3 = (TextView) view.findViewById(C0010R$id.followButton);
        updateFollowButton(recommendFittie.getUser());
        textView3.setOnClickListener(new FittieRecommendViewHolder$initView$$inlined$with$lambda$1(recommendFittie, view, this, recommendFittie));
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.userSubRecyclerView);
        recyclerView.setAdapter(this.postAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new SimpleOffsetDecorator(0, 2, 2, 0));
        }
        this.postAdapter.update(recommendFittie.getPosts());
    }

    public final void update(@Nullable RecommendFittie recommendFittie) {
        if (recommendFittie != null) {
            User user = recommendFittie.getUser();
            if (user != null) {
                updateFollowButton(user);
            }
        }
    }

    private final TextView updateFollowButton(User user) {
        TextView textView = (TextView) this.itemView.findViewById(C0010R$id.followButton);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), user.getFollowStateResource()));
        Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(textView.getContext(), user.getFollowStateTextColor()));
        textView.setText(user.getFollowStateText());
        return textView;
    }
}
