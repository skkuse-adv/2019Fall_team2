package kr.co.popone.fitts.feature.common.fittie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.model.view.FittieFollowViewData;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;

public final class FittieHorizontalFeedViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public interface Delegate {
        void onFollowClick(long j, boolean z);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FittieHorizontalFeedViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_intergrated_search_result_item_fittie, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FittieHorizontalFeedViewHolder(inflate, delegate);
        }
    }

    public FittieHorizontalFeedViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void bindTo(@NotNull FittieFollowViewData fittieFollowViewData, boolean z) {
        Intrinsics.checkParameterIsNotNull(fittieFollowViewData, "fittieFollowViewData");
        View view = this.itemView;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.profileImageView);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "profileImageView");
        ImageViewExtensionKt.loadImageAsProfile(circleImageView, fittieFollowViewData.getProfileCoverImage());
        TextView textView = (TextView) view.findViewById(C0010R$id.nameTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "nameTextView");
        textView.setText(fittieFollowViewData.getFittsId());
        String str = "followButton";
        if (fittieFollowViewData.isFollowing()) {
            Button button = (Button) view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(button, str);
            button.setBackground(ContextCompat.getDrawable(view.getContext(), C0008R$drawable.round_button_following));
            Button button2 = (Button) view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(button2, str);
            button2.setText(view.getContext().getString(C0016R$string.following));
            Button button3 = (Button) view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(button3, str);
            Sdk27PropertiesKt.setTextColor(button3, ContextCompat.getColor(view.getContext(), C0006R$color.gray4));
        } else {
            Button button4 = (Button) view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(button4, str);
            button4.setBackground(ContextCompat.getDrawable(view.getContext(), C0008R$drawable.round_button_follow));
            Button button5 = (Button) view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(button5, str);
            button5.setText(view.getContext().getString(C0016R$string.follow));
            Button button6 = (Button) view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(button6, str);
            Sdk27PropertiesKt.setTextColor(button6, ContextCompat.getColor(view.getContext(), 17170443));
        }
        Button button7 = (Button) view.findViewById(C0010R$id.followButton);
        FittieFollowViewData fittieFollowViewData2 = fittieFollowViewData;
        View view2 = view;
        FittieFollowViewData fittieFollowViewData3 = fittieFollowViewData;
        boolean z2 = z;
        FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$1 fittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$1 = new FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$1(fittieFollowViewData2, view2, this, fittieFollowViewData3, z2);
        button7.setOnClickListener(fittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$1);
        CircleImageView circleImageView2 = (CircleImageView) view.findViewById(C0010R$id.profileImageView);
        FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$2 fittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$2 = new FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$2(fittieFollowViewData2, view2, this, fittieFollowViewData3, z2);
        circleImageView2.setOnClickListener(fittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$2);
        View findViewById = view.findViewById(C0010R$id.lastViewDivider);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "lastViewDivider");
        findViewById.setVisibility(z ? 4 : 0);
    }
}
