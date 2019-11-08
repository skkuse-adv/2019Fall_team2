package kr.co.popone.fitts.feature.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import org.jetbrains.annotations.NotNull;

public final class ProductPostViewHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final CircleImageView imageFittieProfile;
    private final ImageView imagePostCover;
    private final TextView textFittieId;
    private final TextView textPostTitle;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_product_post;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductPostViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_product_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductPostViewHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onPostClick(long j);
    }

    public ProductPostViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.imagePostCover = (ImageView) view.findViewById(C0010R$id.iv_post_cover);
        this.imageFittieProfile = (CircleImageView) view.findViewById(C0010R$id.iv_fittie_profile);
        this.textPostTitle = (TextView) view.findViewById(C0010R$id.tv_post_title);
        this.textFittieId = (TextView) view.findViewById(C0010R$id.tv_fitts_id);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r10 != null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void bind(@org.jetbrains.annotations.Nullable T r9, @org.jetbrains.annotations.Nullable java.lang.Integer r10) {
        /*
            r8 = this;
            boolean r10 = r9 instanceof kr.co.popone.fitts.model.post.PostAPI.Post
            if (r10 == 0) goto L_0x003f
            kr.co.popone.fitts.model.post.PostAPI$Post r9 = (kr.co.popone.fitts.model.post.PostAPI.Post) r9
            long r1 = r9.getId()
            java.lang.String r3 = r9.getTitle()
            kr.co.popone.fitts.model.datamodel.service.user.User r10 = r9.getUser()
            java.lang.String r4 = r10.getFittsID()
            kr.co.popone.fitts.model.datamodel.service.post.Image r10 = r9.getCoverImage()
            if (r10 == 0) goto L_0x0023
            java.lang.String r10 = r10.getUrl()
            if (r10 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            java.lang.String r10 = ""
        L_0x0025:
            r5 = r10
            kr.co.popone.fitts.model.datamodel.service.post.Image r10 = r9.getCoverImage()
            if (r10 == 0) goto L_0x0031
            java.lang.String r10 = r10.getDominantColor()
            goto L_0x0032
        L_0x0031:
            r10 = 0
        L_0x0032:
            r6 = r10
            kr.co.popone.fitts.model.datamodel.service.user.User r9 = r9.getUser()
            java.lang.String r7 = r9.getProfileImageUrl()
            r0 = r8
            r0.updateUi(r1, r3, r4, r5, r6, r7)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.dialog.ProductPostViewHolder.bind(java.lang.Object, java.lang.Integer):void");
    }

    public void clear() {
        View view = this.itemView;
        String str = "itemView";
        Intrinsics.checkExpressionValueIsNotNull(view, str);
        Glide.with(view.getContext()).clear((View) this.imagePostCover);
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, str);
        Glide.with(view2.getContext()).clear((View) this.imageFittieProfile);
    }

    private final void updateUi(long j, String str, String str2, String str3, String str4, String str5) {
        ImageView imageView = this.imagePostCover;
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imagePostCover");
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
        ImageViewExtensionKt.loadImageTopRound(imageView, context, str3, str4);
        CircleImageView circleImageView = this.imageFittieProfile;
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "imageFittieProfile");
        ImageViewExtensionKt.loadImageAsProfile(circleImageView, str5);
        TextView textView = this.textPostTitle;
        Intrinsics.checkExpressionValueIsNotNull(textView, "textPostTitle");
        textView.setText(str);
        TextView textView2 = this.textFittieId;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textFittieId");
        textView2.setText(str2);
        this.itemView.setOnClickListener(new ProductPostViewHolder$updateUi$1(this, j));
    }
}
