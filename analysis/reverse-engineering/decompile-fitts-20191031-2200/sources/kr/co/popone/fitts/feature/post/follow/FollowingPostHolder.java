package kr.co.popone.fitts.feature.post.follow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.kakao.message.template.MessageTemplateProtocol;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.FittsCircleImageView;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ImageViewForList;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.UIExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FollowingPostHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FollowingPostHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_list, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FollowingPostHolder(inflate);
        }
    }

    public FollowingPostHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(long j, @Nullable Post post) {
        Post post2 = post;
        View view = this.itemView;
        String str = null;
        if (post2 == null) {
            return null;
        }
        BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
        Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…le.image_default_profile)");
        RequestOptions requestOptions = (RequestOptions) error;
        String str2 = "deactivated";
        if (Intrinsics.areEqual((Object) post.getUser().getStatus(), (Object) str2)) {
            Glide.with(view.getContext()).load(Integer.valueOf(C0008R$drawable.image_default_profile)).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView));
        } else {
            Glide.with(view.getContext()).load(post.getUser().getProfileImageUrl()).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView));
        }
        boolean z = true;
        String str3 = "profileImageView";
        String str4 = "#FFFFFF";
        if (!Intrinsics.areEqual((Object) post.getUser().getStatus(), (Object) str2)) {
            ((FittsCircleImageView) view.findViewById(C0010R$id.profileImageView)).setBackgroundResource(C0008R$drawable.fitts_profile);
            FittsCircleImageView fittsCircleImageView = (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView);
            Intrinsics.checkExpressionValueIsNotNull(fittsCircleImageView, str3);
            fittsCircleImageView.setEnabled(true);
        } else {
            ((FittsCircleImageView) view.findViewById(C0010R$id.profileImageView)).setBackgroundColor(Color.parseColor(str4));
            FittsCircleImageView fittsCircleImageView2 = (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView);
            Intrinsics.checkExpressionValueIsNotNull(fittsCircleImageView2, str3);
            fittsCircleImageView2.setEnabled(false);
        }
        ((FittsCircleImageView) view.findViewById(C0010R$id.profileImageView)).setOnClickListener(FollowingPostHolder$bindTo$1$1$1.INSTANCE);
        TextView textView = (TextView) view.findViewById(C0010R$id.fitts_id);
        Intrinsics.checkExpressionValueIsNotNull(textView, "fitts_id");
        textView.setText(post.getUser().getFittsID());
        View findViewById = view.findViewById(C0010R$id.fittieSuitBlue);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "fittieSuitBlue");
        findViewById.setVisibility(post.getUser().isSuitable() ? 0 : 8);
        boolean isFollowing = post.getUser().isFollowing();
        String str5 = "context";
        String str6 = "follow_button";
        if (isFollowing) {
            TextView textView2 = (TextView) view.findViewById(C0010R$id.follow_button);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str6);
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, str5);
            textView2.setText(context.getResources().getString(C0016R$string.following));
            ((TextView) view.findViewById(C0010R$id.follow_button)).setTextColor(ContextCompat.getColor(view.getContext(), C0006R$color.gray1));
        } else if (!isFollowing) {
            TextView textView3 = (TextView) view.findViewById(C0010R$id.follow_button);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str6);
            Context context2 = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, str5);
            textView3.setText(context2.getResources().getString(C0016R$string.follow));
            ((TextView) view.findViewById(C0010R$id.follow_button)).setTextColor(ContextCompat.getColor(view.getContext(), C0006R$color.point));
        }
        if (post.getCoverImage() != null) {
            BaseRequestOptions error2 = ((RequestOptions) new RequestOptions().placeholder((Drawable) new ColorDrawable(Color.parseColor(post.getCoverImage().getDominantColor())))).error((Drawable) new ColorDrawable(Color.parseColor(str4)));
            Intrinsics.checkExpressionValueIsNotNull(error2, "RequestOptions()\n       …r.parseColor(\"#FFFFFF\")))");
            Glide.with(view.getContext()).load(post.getCoverImage().getThumbnail()).thumbnail(Glide.with(view.getContext()).load(post.getCoverImage().getLqip())).apply((BaseRequestOptions<?>) (RequestOptions) error2).into((ImageView) (ImageViewForList) view.findViewById(C0010R$id.cover));
        }
        Intrinsics.checkExpressionValueIsNotNull(view, "this@with");
        TextView textView4 = (TextView) view.findViewById(C0010R$id.title);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "this@with.title");
        textView4.setText(post.getTitle());
        TextView textView5 = (TextView) view.findViewById(C0010R$id.viewCountTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "viewCountTextView");
        StringBuilder sb = new StringBuilder();
        sb.append("조회 ");
        sb.append(post.getViewCount());
        sb.append(47749);
        textView5.setText(sb.toString());
        String str7 = "shop";
        String str8 = "product";
        if (post.getLinkInfo() != null) {
            LinkInfo linkInfo = post.getLinkInfo();
            if (linkInfo == null) {
                Intrinsics.throwNpe();
            }
            if (linkInfo.getShop() != null) {
                if (VERSION.SDK_INT >= 21) {
                    RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.product);
                    Intrinsics.checkExpressionValueIsNotNull(roundImageView, str8);
                    roundImageView.setClipToOutline(true);
                }
                RoundImageView roundImageView2 = (RoundImageView) view.findViewById(C0010R$id.product);
                Intrinsics.checkExpressionValueIsNotNull(roundImageView2, str8);
                roundImageView2.setVisibility(0);
                TextView textView6 = (TextView) view.findViewById(C0010R$id.shop);
                Intrinsics.checkExpressionValueIsNotNull(textView6, str7);
                textView6.setVisibility(0);
                RoundImageView roundImageView3 = (RoundImageView) view.findViewById(C0010R$id.product);
                Intrinsics.checkExpressionValueIsNotNull(roundImageView3, str8);
                LinkInfo linkInfo2 = post.getLinkInfo();
                if (linkInfo2 != null) {
                    Product product = linkInfo2.getProduct();
                    if (product != null) {
                        str = product.getImageUrl();
                    }
                }
                ImageViewExtensionKt.loadImage((ImageView) roundImageView3, str, (int) C0008R$drawable.shop_sample1);
                LinkInfo linkInfo3 = post.getLinkInfo();
                if (linkInfo3 == null) {
                    Intrinsics.throwNpe();
                }
                Shop shop = linkInfo3.getShop();
                if (shop == null) {
                    Intrinsics.throwNpe();
                }
                if (shop.getName() != null) {
                    TextView textView7 = (TextView) view.findViewById(C0010R$id.shop);
                    Intrinsics.checkExpressionValueIsNotNull(textView7, str7);
                    LinkInfo linkInfo4 = post.getLinkInfo();
                    if (linkInfo4 == null) {
                        Intrinsics.throwNpe();
                    }
                    Shop shop2 = linkInfo4.getShop();
                    if (shop2 == null) {
                        Intrinsics.throwNpe();
                    }
                    String name = shop2.getName();
                    if (name == null) {
                        Intrinsics.throwNpe();
                    }
                    loadShop(textView7, name);
                }
            } else {
                RoundImageView roundImageView4 = (RoundImageView) view.findViewById(C0010R$id.product);
                Intrinsics.checkExpressionValueIsNotNull(roundImageView4, str8);
                roundImageView4.setVisibility(4);
                TextView textView8 = (TextView) view.findViewById(C0010R$id.shop);
                Intrinsics.checkExpressionValueIsNotNull(textView8, str7);
                textView8.setVisibility(8);
            }
        } else {
            RoundImageView roundImageView5 = (RoundImageView) view.findViewById(C0010R$id.product);
            Intrinsics.checkExpressionValueIsNotNull(roundImageView5, str8);
            roundImageView5.setVisibility(4);
            TextView textView9 = (TextView) view.findViewById(C0010R$id.shop);
            Intrinsics.checkExpressionValueIsNotNull(textView9, str7);
            textView9.setVisibility(8);
        }
        TextView textView10 = (TextView) view.findViewById(C0010R$id.create_at);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "create_at");
        loadDate(textView10, post.getCreatedAt());
        boolean isLiked = post.isLiked();
        String str9 = MessageTemplateProtocol.LIKE_COUNT;
        if (isLiked) {
            ((ImageView) view.findViewById(C0010R$id.like_image)).setBackgroundResource(C0008R$drawable.button_home_like);
            ((TextView) view.findViewById(C0010R$id.like_count)).setTextColor(ContextCompat.getColor(view.getContext(), C0006R$color.point));
            TextView textView11 = (TextView) view.findViewById(C0010R$id.like_count);
            TextView textView12 = (TextView) view.findViewById(C0010R$id.like_count);
            Intrinsics.checkExpressionValueIsNotNull(textView12, str9);
            textView11.setTypeface(textView12.getTypeface(), 1);
        } else if (!isLiked) {
            ((ImageView) view.findViewById(C0010R$id.like_image)).setBackgroundResource(C0008R$drawable.button_home_unlike);
            ((TextView) view.findViewById(C0010R$id.like_count)).setTextColor(ContextCompat.getColor(view.getContext(), C0006R$color.gray6));
            TextView textView13 = (TextView) view.findViewById(C0010R$id.like_count);
            Intrinsics.checkExpressionValueIsNotNull(textView13, str9);
            TextView textView14 = (TextView) view.findViewById(C0010R$id.like_count);
            Intrinsics.checkExpressionValueIsNotNull(textView14, str9);
            textView13.setTypeface(Typeface.create(textView14.getTypeface(), 0));
        }
        FollowingPostHolder$bindTo$$inlined$with$lambda$1 followingPostHolder$bindTo$$inlined$with$lambda$1 = new FollowingPostHolder$bindTo$$inlined$with$lambda$1(post, view, this, post, j);
        view.setOnClickListener(followingPostHolder$bindTo$$inlined$with$lambda$1);
        ((LinearLayout) view.findViewById(C0010R$id.like_button)).setOnClickListener(new FollowingPostHolder$bindTo$1$1$3(post2));
        ((TextView) view.findViewById(C0010R$id.follow_button)).setOnClickListener(new FollowingPostHolder$bindTo$1$1$4(post2));
        TextView textView15 = (TextView) view.findViewById(C0010R$id.like_count);
        Intrinsics.checkExpressionValueIsNotNull(textView15, str9);
        UIExtensions uIExtensions = UIExtensions.INSTANCE;
        if (post.getUser().getId() != j) {
            z = false;
        }
        textView15.setText(uIExtensions.likeCountText(z, post.isLiked(), post.getLikesCount()));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.bannerLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "bannerLayout");
        linearLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    public final void loadDate(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(str, "text");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("M월 d일", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(text)");
        long time = date.getTime() - parse.getTime();
        if (time < 60000) {
            textView.setText("방금 전");
        } else if (time < 3600000) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(time / 60000));
            sb.append("분 전");
            textView.setText(sb.toString());
        } else if (time < 86400000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(time / 3600000));
            sb2.append("시간 전");
            textView.setText(sb2.toString());
        } else if (time < 604800000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(time / 86400000));
            sb3.append("일 전");
            textView.setText(sb3.toString());
        } else {
            textView.setText(simpleDateFormat2.format(parse).toString());
        }
    }

    public final void loadShop(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(str, "textshop");
        StringBuilder sb = new StringBuilder();
        sb.append('\'');
        sb.append(str);
        sb.append("'에서 구매");
        textView.setText(sb.toString());
    }
}
