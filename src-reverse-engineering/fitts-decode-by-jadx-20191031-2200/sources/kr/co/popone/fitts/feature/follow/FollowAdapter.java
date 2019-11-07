package kr.co.popone.fitts.feature.follow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.orhanobut.logger.Logger;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import org.jetbrains.annotations.NotNull;

public final class FollowAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate {
        @NotNull
        List<User> getFollowUsers();

        int getGetFollowCount();

        void onFollowClicked(@NotNull User user, @NotNull View view);

        void onProfileImageClick(@NotNull User user);

        boolean shouldShowFollowButton(int i);
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final TextView followCount;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            TextView textView = (TextView) view.findViewById(C0010R$id.follow_count);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.follow_count");
            this.followCount = textView;
        }

        @NotNull
        public final TextView getFollowCount() {
            return this.followCount;
        }
    }

    public static final class ItemFollowViewHolder extends ViewHolder {
        @NotNull
        private final View fittieBlueDot;
        @NotNull
        private final TextView fittsId;
        @NotNull
        private final TextView followButton;
        @NotNull
        private final CircleImageView profileImage;
        @NotNull
        private final ViewGroup profileLayout;

        public ItemFollowViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.profileLayout);
            if (findViewById == null) {
                Intrinsics.throwNpe();
            }
            this.profileLayout = (ViewGroup) findViewById;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.profile_image);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.profile_image");
            this.profileImage = circleImageView;
            TextView textView = (TextView) view.findViewById(C0010R$id.profile_id);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.profile_id");
            this.fittsId = textView;
            TextView textView2 = (TextView) view.findViewById(C0010R$id.follow_button);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.follow_button");
            this.followButton = textView2;
            View findViewById2 = view.findViewById(C0010R$id.fittieSuitBlue);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.fittieSuitBlue)");
            this.fittieBlueDot = findViewById2;
        }

        @NotNull
        public final ViewGroup getProfileLayout() {
            return this.profileLayout;
        }

        @NotNull
        public final CircleImageView getProfileImage() {
            return this.profileImage;
        }

        @NotNull
        public final TextView getFittsId() {
            return this.fittsId;
        }

        @NotNull
        public final TextView getFollowButton() {
            return this.followButton;
        }

        @NotNull
        public final View getFittieBlueDot() {
            return this.fittieBlueDot;
        }
    }

    public FollowAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == TYPE_HEADER) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_follow_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…ow_header, parent, false)");
            return new HeaderViewHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_follow, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…em_follow, parent, false)");
        return new ItemFollowViewHolder(inflate2);
    }

    private final User getItem(int i) {
        return (User) this.delegate.getFollowUsers().get(i - 1);
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    public int getItemCount() {
        return this.delegate.getFollowUsers().size() + 1;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        if ((viewHolder instanceof ItemFollowViewHolder) && !list.isEmpty() && (list.get(0) instanceof Boolean)) {
            Object obj = list.get(0);
            if (Intrinsics.areEqual(obj, (Object) Boolean.valueOf(true))) {
                ItemFollowViewHolder itemFollowViewHolder = (ItemFollowViewHolder) viewHolder;
                itemFollowViewHolder.getFollowButton().setText(this.context.getResources().getString(C0016R$string.following));
                itemFollowViewHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.context, C0006R$color.gray4));
                itemFollowViewHolder.getFollowButton().setBackground(ContextCompat.getDrawable(this.context, C0008R$drawable.round_button_following));
            } else if (Intrinsics.areEqual(obj, (Object) Boolean.valueOf(false))) {
                ItemFollowViewHolder itemFollowViewHolder2 = (ItemFollowViewHolder) viewHolder;
                itemFollowViewHolder2.getFollowButton().setText(this.context.getResources().getString(C0016R$string.follow));
                itemFollowViewHolder2.getFollowButton().setTextColor(ContextCompat.getColor(this.context, 17170443));
                itemFollowViewHolder2.getFollowButton().setBackground(ContextCompat.getDrawable(this.context, C0008R$drawable.round_button_follow));
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof HeaderViewHolder) {
            TextView followCount = ((HeaderViewHolder) viewHolder).getFollowCount();
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.delegate.getGetFollowCount()));
            sb.append("명의 핏티");
            followCount.setText(sb.toString());
        } else if (viewHolder instanceof ItemFollowViewHolder) {
            User item = getItem(i);
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…le.image_default_profile)");
            RequestOptions requestOptions = (RequestOptions) error;
            if (Intrinsics.areEqual((Object) item.getStatus(), (Object) "deactivated")) {
                Intrinsics.checkExpressionValueIsNotNull(Glide.with(this.context).load(Integer.valueOf(C0008R$drawable.image_default_profile)).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) ((ItemFollowViewHolder) viewHolder).getProfileImage()), "Glide.with(context).load…into(holder.profileImage)");
            } else {
                ItemFollowViewHolder itemFollowViewHolder = (ItemFollowViewHolder) viewHolder;
                Glide.with(this.context).load(item.getProfileImageUrl()).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) itemFollowViewHolder.getProfileImage());
                itemFollowViewHolder.getProfileLayout().setOnClickListener(new FollowAdapter$onBindViewHolder$1(this, item));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("currentItem ");
            sb2.append(item);
            int i2 = 0;
            Logger.d(sb2.toString(), new Object[0]);
            ItemFollowViewHolder itemFollowViewHolder2 = (ItemFollowViewHolder) viewHolder;
            itemFollowViewHolder2.getFollowButton().setVisibility(this.delegate.shouldShowFollowButton(i - 1) ? 0 : 4);
            itemFollowViewHolder2.getFittsId().setText(item.getFittsID());
            View fittieBlueDot = itemFollowViewHolder2.getFittieBlueDot();
            if (!item.isSuitable()) {
                i2 = 4;
            }
            fittieBlueDot.setVisibility(i2);
            itemFollowViewHolder2.getFollowButton().setOnClickListener(new FollowAdapter$onBindViewHolder$2(this, item));
            boolean isFollowing = item.isFollowing();
            if (isFollowing) {
                itemFollowViewHolder2.getFollowButton().setText(this.context.getResources().getString(C0016R$string.following));
                itemFollowViewHolder2.getFollowButton().setTextColor(ContextCompat.getColor(this.context, C0006R$color.gray4));
                itemFollowViewHolder2.getFollowButton().setBackground(ContextCompat.getDrawable(this.context, C0008R$drawable.round_button_following));
            } else if (!isFollowing) {
                itemFollowViewHolder2.getFollowButton().setText(this.context.getResources().getString(C0016R$string.follow));
                itemFollowViewHolder2.getFollowButton().setTextColor(ContextCompat.getColor(this.context, 17170443));
                itemFollowViewHolder2.getFollowButton().setBackground(ContextCompat.getDrawable(this.context, C0008R$drawable.round_button_follow));
            }
        }
    }
}
