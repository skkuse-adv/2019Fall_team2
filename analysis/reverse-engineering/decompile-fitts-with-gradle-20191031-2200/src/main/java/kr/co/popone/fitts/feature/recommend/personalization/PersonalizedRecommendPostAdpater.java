package kr.co.popone.fitts.feature.recommend.personalization;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class PersonalizedRecommendPostAdpater extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final int TYPE_HOLDER_BIG = 1;
    /* access modifiers changed from: private */
    public static final int TYPE_HOLDER_NORMAL = 2;
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HOLDER_BIG() {
            return PersonalizedRecommendPostAdpater.TYPE_HOLDER_BIG;
        }

        public final int getTYPE_HOLDER_NORMAL() {
            return PersonalizedRecommendPostAdpater.TYPE_HOLDER_NORMAL;
        }
    }

    public static final class Decoration extends ItemDecoration {
        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
            Intrinsics.checkParameterIsNotNull(rect, "outRect");
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
            Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
            rect.left = ViewExtensionsKt.dpToPx(view, 3);
            rect.right = ViewExtensionsKt.dpToPx(view, 3);
            rect.bottom = ViewExtensionsKt.dpToPx(view, 8);
        }
    }

    public interface Delegate {
        @NotNull
        List<Post> getPostAdapterList();

        void onPostContentClicked(@NotNull Post post, @NotNull View view);
    }

    public static final class RecommandedHolder extends ViewHolder {
        @NotNull
        private final ImageView coverImageView;
        @NotNull
        private final TextView postTitleTextView;
        @NotNull
        private final TextView shopNameTextView;

        public RecommandedHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.coverImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.coverImageView)");
            this.coverImageView = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.postTitleTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.postTitleTextView)");
            this.postTitleTextView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(C0010R$id.shopNameTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.shopNameTextView)");
            this.shopNameTextView = (TextView) findViewById3;
        }

        @NotNull
        public final ImageView getCoverImageView() {
            return this.coverImageView;
        }

        @NotNull
        public final TextView getPostTitleTextView() {
            return this.postTitleTextView;
        }

        @NotNull
        public final TextView getShopNameTextView() {
            return this.shopNameTextView;
        }
    }

    public PersonalizedRecommendPostAdpater(@NotNull Activity activity, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recommended_post, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new RecommandedHolder(inflate);
    }

    public int getItemCount() {
        return this.delegate.getPostAdapterList().size();
    }

    public int getItemViewType(int i) {
        return (i + 1) % 5 == 0 ? TYPE_HOLDER_BIG : TYPE_HOLDER_NORMAL;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r5 != null) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            boolean r0 = r4 instanceof kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.RecommandedHolder
            if (r0 == 0) goto L_0x0062
            kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater$Delegate r0 = r3.delegate
            java.util.List r0 = r0.getPostAdapterList()
            java.lang.Object r5 = r0.get(r5)
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = (kr.co.popone.fitts.model.post.PostAPI.Post) r5
            r0 = r4
            kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater$RecommandedHolder r0 = (kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.RecommandedHolder) r0
            android.view.View r1 = r0.itemView
            kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater$onBindViewHolder$$inlined$let$lambda$1 r2 = new kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater$onBindViewHolder$$inlined$let$lambda$1
            r2.<init>(r0, r5, r3, r4)
            r1.setOnClickListener(r2)
            android.widget.ImageView r4 = r0.getCoverImageView()
            kr.co.popone.fitts.model.datamodel.service.post.Image r1 = r5.getCoverImage()
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = r1.getUrl()
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            kr.co.popone.fitts.ui.ImageViewExtensionKt.loadImageAsProduct(r4, r1)
            android.widget.TextView r4 = r0.getPostTitleTextView()
            java.lang.String r1 = r5.getTitle()
            r4.setText(r1)
            android.widget.TextView r4 = r0.getShopNameTextView()
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r5 = r5.getLinkInfo()
            if (r5 == 0) goto L_0x005d
            kr.co.popone.fitts.model.datamodel.commerce.Product r5 = r5.getProduct()
            if (r5 == 0) goto L_0x005d
            kr.co.popone.fitts.model.datamodel.commerce.Shop r5 = r5.getShop()
            if (r5 == 0) goto L_0x005d
            java.lang.String r5 = r5.getName()
            if (r5 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            java.lang.String r5 = ""
        L_0x005f:
            r4.setText(r5)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }
}
