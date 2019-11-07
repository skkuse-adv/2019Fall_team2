package kr.co.popone.fitts.feature.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittieSearchResultHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;
    private final Button fittieFollowButton;
    private final TextView fittieIdTextView;
    private final CircleImageView fittieProfileImageView;
    private final View fittieSuitBlue;

    public interface Delegate {
        void onFollowClick(long j, boolean z);

        void onProfileClick(long j);
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.view_search_result_item_fittie;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FittieSearchResultHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_search_result_item_fittie, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FittieSearchResultHolder(inflate, delegate);
        }
    }

    public FittieSearchResultHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.fittieProfileImageView = (CircleImageView) view.findViewById(C0010R$id.iv_fittie_profile);
        this.fittieFollowButton = (Button) view.findViewById(C0010R$id.btn_fittie_follow);
        this.fittieIdTextView = (TextView) view.findViewById(C0010R$id.tv_fittie_id);
        this.fittieSuitBlue = view.findViewById(C0010R$id.view_blue_dot);
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof User) {
            updateView((User) t);
        }
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.fittieProfileImageView);
    }

    private final void updateView(User user) {
        CircleImageView circleImageView = this.fittieProfileImageView;
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "fittieProfileImageView");
        ImageViewExtensionKt.loadImageAsProfile(circleImageView, user.getProfileImageUrl());
        TextView textView = this.fittieIdTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "fittieIdTextView");
        textView.setText(user.getFittsID());
        View view = this.fittieSuitBlue;
        Intrinsics.checkExpressionValueIsNotNull(view, "fittieSuitBlue");
        view.setVisibility(user.isSuitable() ? 0 : 8);
        updateFollowing(user.isFollowing());
        this.fittieProfileImageView.setOnClickListener(new FittieSearchResultHolder$updateView$$inlined$run$lambda$1(user, this));
        this.fittieFollowButton.setOnClickListener(new FittieSearchResultHolder$updateView$$inlined$run$lambda$2(user, this));
    }

    private final void updateFollowing(boolean z) {
        Button button = this.fittieFollowButton;
        button.setText(z ? "팔로잉" : "팔로우");
        button.setBackgroundResource(z ? C0008R$drawable.search_result_fittie_follow_button_on : C0008R$drawable.search_result_fittie_follow_button_off);
        button.setTextColor(ContextCompat.getColor(button.getContext(), z ? C0006R$color.gray4 : 17170443));
    }
}
