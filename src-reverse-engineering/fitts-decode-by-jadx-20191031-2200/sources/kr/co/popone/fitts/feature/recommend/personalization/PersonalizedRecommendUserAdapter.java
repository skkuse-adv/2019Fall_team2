package kr.co.popone.fitts.feature.recommend.personalization;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendUserPostAdapter.Decoration;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.BodyType;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class PersonalizedRecommendUserAdapter extends Adapter<ViewHolder> {
    private final Activity activity;
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public interface Delegate {
        @NotNull
        List<User> getUserAdapterList();

        void onFollowClicked(@NotNull User user, @NotNull TextView textView);

        void onPostContentClicked(@NotNull Post post, @NotNull View view);

        void onProfileClicked(@NotNull User user);

        void onUserUiInitialized(long j, @NotNull RecyclerView recyclerView);
    }

    public static final class RecommendUserHolder extends ViewHolder {
        @NotNull
        private final TextView followButton;
        @NotNull
        private final ImageView userBodyTypeIconImageView;
        @NotNull
        private final TextView userBodyTypeTextView;
        @NotNull
        private final TextView userNicknameTextView;
        @NotNull
        private final CircleImageView userProfileImageView;
        @NotNull
        private final RecyclerView userSubRecyclerView;

        public RecommendUserHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.userSubRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.userSubRecyclerView)");
            this.userSubRecyclerView = (RecyclerView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.userNicknameTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.userNicknameTextView)");
            this.userNicknameTextView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(C0010R$id.userBodyTypeTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.userBodyTypeTextView)");
            this.userBodyTypeTextView = (TextView) findViewById3;
            View findViewById4 = view.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.followButton)");
            this.followButton = (TextView) findViewById4;
            View findViewById5 = view.findViewById(C0010R$id.userBodyTypeIconImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.…serBodyTypeIconImageView)");
            this.userBodyTypeIconImageView = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(C0010R$id.userProfileImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.userProfileImageView)");
            this.userProfileImageView = (CircleImageView) findViewById6;
        }

        @NotNull
        public final RecyclerView getUserSubRecyclerView() {
            return this.userSubRecyclerView;
        }

        @NotNull
        public final TextView getUserNicknameTextView() {
            return this.userNicknameTextView;
        }

        @NotNull
        public final TextView getUserBodyTypeTextView() {
            return this.userBodyTypeTextView;
        }

        @NotNull
        public final TextView getFollowButton() {
            return this.followButton;
        }

        @NotNull
        public final ImageView getUserBodyTypeIconImageView() {
            return this.userBodyTypeIconImageView;
        }

        @NotNull
        public final CircleImageView getUserProfileImageView() {
            return this.userProfileImageView;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BodyType.values().length];

        static {
            $EnumSwitchMapping$0[BodyType.TRIANGLE.ordinal()] = 1;
            $EnumSwitchMapping$0[BodyType.INVERTED_TRIANGLE.ordinal()] = 2;
            $EnumSwitchMapping$0[BodyType.RECTANGLE.ordinal()] = 3;
            $EnumSwitchMapping$0[BodyType.HOURGLASS.ordinal()] = 4;
            $EnumSwitchMapping$0[BodyType.NORMAL.ordinal()] = 5;
        }
    }

    public PersonalizedRecommendUserAdapter(@NotNull Activity activity2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.activity = activity2;
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recommended_user, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new RecommendUserHolder(inflate);
    }

    public int getItemCount() {
        return this.delegate.getUserAdapterList().size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        String str;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof RecommendUserHolder) {
            User user = (User) this.delegate.getUserAdapterList().get(i);
            RecommendUserHolder recommendUserHolder = (RecommendUserHolder) viewHolder;
            recommendUserHolder.getUserNicknameTextView().setText(user.getFittsID());
            ImageView userBodyTypeIconImageView = recommendUserHolder.getUserBodyTypeIconImageView();
            BodyInfo bodyInfo = user.getBodyInfo();
            if (bodyInfo == null) {
                Intrinsics.throwNpe();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[bodyInfo.getBodyType().ordinal()];
            if (i2 == 1) {
                userBodyTypeIconImageView.setImageResource(C0008R$drawable.image_profile_triangle);
            } else if (i2 == 2) {
                userBodyTypeIconImageView.setImageResource(C0008R$drawable.image_profile_invert);
            } else if (i2 == 3) {
                userBodyTypeIconImageView.setImageResource(C0008R$drawable.image_profile_rectangle);
            } else if (i2 == 4) {
                userBodyTypeIconImageView.setImageResource(C0008R$drawable.image_profile_hourglass);
            } else if (i2 == 5) {
                userBodyTypeIconImageView.setImageResource(C0008R$drawable.image_profile_regular);
            }
            BodyInfo bodyInfo2 = user.getBodyInfo();
            if (bodyInfo2 != null) {
                TextView userBodyTypeTextView = recommendUserHolder.getUserBodyTypeTextView();
                String top = bodyInfo2.getTop();
                boolean z = false;
                if (!(top == null || StringsKt__StringsJVMKt.isBlank(top))) {
                    String bottom = bodyInfo2.getBottom();
                    if (bottom == null || StringsKt__StringsJVMKt.isBlank(bottom)) {
                        z = true;
                    }
                    if (!z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(bodyInfo2.getHeight());
                        String str2 = " . ";
                        sb.append(str2);
                        sb.append(bodyInfo2.getTop());
                        sb.append(str2);
                        sb.append(bodyInfo2.getBottom());
                        sb.append(' ');
                        str = sb.toString();
                        userBodyTypeTextView.setText(str);
                    }
                }
                str = String.valueOf(bodyInfo2.getHeight());
                userBodyTypeTextView.setText(str);
            }
            boolean isFollowing = user.isFollowing();
            if (isFollowing) {
                recommendUserHolder.getFollowButton().setText(this.activity.getResources().getString(C0016R$string.following));
                recommendUserHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.activity, C0006R$color.gray4));
                recommendUserHolder.getFollowButton().setBackground(ContextCompat.getDrawable(this.activity, C0008R$drawable.round_button_following));
            } else if (!isFollowing) {
                recommendUserHolder.getFollowButton().setText(this.activity.getResources().getString(C0016R$string.follow));
                recommendUserHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.activity, 17170443));
                recommendUserHolder.getFollowButton().setBackground(ContextCompat.getDrawable(this.activity, C0008R$drawable.round_button_follow));
            }
            recommendUserHolder.getFollowButton().setOnClickListener(new PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$1(recommendUserHolder, user, this, viewHolder));
            recommendUserHolder.getUserProfileImageView().setOnClickListener(new PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$2(user, this, viewHolder));
            recommendUserHolder.getUserNicknameTextView().setOnClickListener(new PersonalizedRecommendUserAdapter$onBindViewHolder$$inlined$let$lambda$3(user, this, viewHolder));
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…le.image_default_profile)");
            Glide.with(this.activity).load(user.getProfileImageUrl()).apply((BaseRequestOptions<?>) (RequestOptions) error).into((ImageView) recommendUserHolder.getUserProfileImageView());
            RecyclerView userSubRecyclerView = recommendUserHolder.getUserSubRecyclerView();
            userSubRecyclerView.setLayoutManager(new GridLayoutManager(this.activity, 3));
            if (userSubRecyclerView.getItemDecorationCount() == 0) {
                userSubRecyclerView.addItemDecoration(new Decoration());
            }
            this.delegate.onUserUiInitialized(user.getId(), recommendUserHolder.getUserSubRecyclerView());
        }
    }
}
