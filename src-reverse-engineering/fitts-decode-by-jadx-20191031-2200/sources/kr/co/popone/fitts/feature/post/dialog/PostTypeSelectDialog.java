package kr.co.popone.fitts.feature.post.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.order.PostableOrderLineItemVariant;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.SimpleOffsetDecorator;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostTypeSelectDialog extends BottomSheetDialog {
    private final double BANNER_IMAGE_RATIO = 2.6810344827586206d;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    @NotNull
    private final PostableProductAdapter postableProductAdapter = new PostableProductAdapter(this.delegate);

    public interface Delegate extends kr.co.popone.fitts.feature.post.dialog.PostableProductAdapter.Delegate {
        void onBannerClicked(@NotNull String str);

        void onDialogDissmiss();

        void onNewPostClicked(@NotNull PostType postType);
    }

    public PostTypeSelectDialog(@NotNull Context context, int i, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(context, i);
        this.delegate = delegate2;
        setContentView((int) C0013R$layout.dialog_select_post_type);
        initView();
    }

    @NotNull
    public final PostableProductAdapter getPostableProductAdapter() {
        return this.postableProductAdapter;
    }

    public final void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(C0010R$id.recyclerPostable);
        recyclerView.setAdapter(this.postableProductAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new SimpleOffsetDecorator(0, 4, 4, 0));
        }
        ((LinearLayout) findViewById(C0010R$id.buttonBags)).setOnClickListener(new PostTypeSelectDialog$initView$2(this));
        ((LinearLayout) findViewById(C0010R$id.buttonClothes)).setOnClickListener(new PostTypeSelectDialog$initView$3(this));
        ((LinearLayout) findViewById(C0010R$id.buttonShoes)).setOnClickListener(new PostTypeSelectDialog$initView$4(this));
        setOnDismissListener(new PostTypeSelectDialog$initView$5(this));
    }

    public final void updatePostable(@NotNull PostableOrderLineItemVariant postableOrderLineItemVariant) {
        Intrinsics.checkParameterIsNotNull(postableOrderLineItemVariant, "postableOrderLineItemVariant");
        PostableProductAdapter postableProductAdapter2 = this.postableProductAdapter;
        postableProductAdapter2.setItems(postableOrderLineItemVariant.getPostableOlivs());
        postableProductAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView = (RecyclerView) findViewById(C0010R$id.recyclerPostable);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerPostable");
        ViewExtensionsKt.visible(recyclerView);
        ImageView imageView = (ImageView) findViewById(C0010R$id.imageBanner);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageBanner");
        ViewExtensionsKt.gone(imageView);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0010R$id.textTitleBanner);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "textTitleBanner");
        ViewExtensionsKt.gone(linearLayout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(C0010R$id.textTitlePosting);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "textTitlePosting");
        ViewExtensionsKt.visible(linearLayout2);
        TextView textView = (TextView) findViewById(C0010R$id.textPostPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textPostPoint");
        StringBuilder sb = new StringBuilder();
        sb.append(IntExtensionsKt.commaString(postableOrderLineItemVariant.getCurrentMaxPoint()));
        sb.append("원 바로 지급!");
        textView.setText(sb.toString());
        TextView textView2 = (TextView) findViewById(C0010R$id.textPostMaximumPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textPostMaximumPoint");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(IntExtensionsKt.commaString(postableOrderLineItemVariant.getAdditionalMaxPoint()));
        sb2.append("만원 ");
        textView2.setText(sb2.toString());
    }

    @NotNull
    public final Object updateBanner(@Nullable Banner banner) {
        Context context = getContext();
        if (banner != null) {
            ImageView imageView = (ImageView) findViewById(C0010R$id.imageBanner);
            LayoutParams layoutParams = imageView.getLayoutParams();
            Resources resources = imageView.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            double dpToPx = (double) (resources.getDisplayMetrics().widthPixels - (ViewExtensionsKt.dpToPx((View) imageView, 24) * 2));
            double d = this.BANNER_IMAGE_RATIO;
            Double.isNaN(dpToPx);
            layoutParams.height = MathKt__MathJVMKt.roundToInt(dpToPx / d);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new PostTypeSelectDialog$updateBanner$$inlined$with$lambda$1(banner, context, this, banner));
            LinearLayout linearLayout = (LinearLayout) findViewById(C0010R$id.textTitleBanner);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "textTitleBanner");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = (RecyclerView) findViewById(C0010R$id.recyclerPostable);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerPostable");
            recyclerView.setVisibility(8);
            ViewTarget into = Glide.with(context).load(banner.getImage().getUrl()).into((ImageView) findViewById(C0010R$id.imageBanner));
            if (into != null) {
                return into;
            }
        }
        updateBannerNotShown();
        return Unit.INSTANCE;
    }

    private final void updateBannerNotShown() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C0010R$id.textTitleBanner);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "textTitleBanner");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(C0010R$id.textTitlePosting);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "textTitlePosting");
        linearLayout2.setVisibility(8);
        View findViewById = findViewById(C0010R$id.lineDivider);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "lineDivider");
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(C0010R$id.imageBanner);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageBanner");
        imageView.setVisibility(8);
    }
}
