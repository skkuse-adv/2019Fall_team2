package kr.co.popone.fitts.feature.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.ImageUrlWithRatio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CollaborativeEventImageListView extends LinearLayout {
    private HashMap _$_findViewCache;
    private final OnClickListener _imageClickListener;
    @NotNull
    private List<SingleOrMultiImage> eventImages;
    @Nullable
    private Function2<? super Integer, ? super Boolean, Unit> itemClickListener;

    public static final class SingleOrMultiImage {
        @NotNull
        private final ImageUrlWithRatio image1;
        @Nullable
        private final ImageUrlWithRatio image2;

        @NotNull
        public static /* synthetic */ SingleOrMultiImage copy$default(SingleOrMultiImage singleOrMultiImage, ImageUrlWithRatio imageUrlWithRatio, ImageUrlWithRatio imageUrlWithRatio2, int i, Object obj) {
            if ((i & 1) != 0) {
                imageUrlWithRatio = singleOrMultiImage.image1;
            }
            if ((i & 2) != 0) {
                imageUrlWithRatio2 = singleOrMultiImage.image2;
            }
            return singleOrMultiImage.copy(imageUrlWithRatio, imageUrlWithRatio2);
        }

        @NotNull
        public final ImageUrlWithRatio component1() {
            return this.image1;
        }

        @Nullable
        public final ImageUrlWithRatio component2() {
            return this.image2;
        }

        @NotNull
        public final SingleOrMultiImage copy(@NotNull ImageUrlWithRatio imageUrlWithRatio, @Nullable ImageUrlWithRatio imageUrlWithRatio2) {
            Intrinsics.checkParameterIsNotNull(imageUrlWithRatio, "image1");
            return new SingleOrMultiImage(imageUrlWithRatio, imageUrlWithRatio2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.image2, (java.lang.Object) r3.image2) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.feature.event.CollaborativeEventImageListView.SingleOrMultiImage
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.feature.event.CollaborativeEventImageListView$SingleOrMultiImage r3 = (kr.co.popone.fitts.feature.event.CollaborativeEventImageListView.SingleOrMultiImage) r3
                kr.co.popone.fitts.model.ImageUrlWithRatio r0 = r2.image1
                kr.co.popone.fitts.model.ImageUrlWithRatio r1 = r3.image1
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.ImageUrlWithRatio r0 = r2.image2
                kr.co.popone.fitts.model.ImageUrlWithRatio r3 = r3.image2
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r3 = 0
                return r3
            L_0x001f:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.CollaborativeEventImageListView.SingleOrMultiImage.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            ImageUrlWithRatio imageUrlWithRatio = this.image1;
            int i = 0;
            int hashCode = (imageUrlWithRatio != null ? imageUrlWithRatio.hashCode() : 0) * 31;
            ImageUrlWithRatio imageUrlWithRatio2 = this.image2;
            if (imageUrlWithRatio2 != null) {
                i = imageUrlWithRatio2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SingleOrMultiImage(image1=");
            sb.append(this.image1);
            sb.append(", image2=");
            sb.append(this.image2);
            sb.append(")");
            return sb.toString();
        }

        public SingleOrMultiImage(@NotNull ImageUrlWithRatio imageUrlWithRatio, @Nullable ImageUrlWithRatio imageUrlWithRatio2) {
            Intrinsics.checkParameterIsNotNull(imageUrlWithRatio, "image1");
            this.image1 = imageUrlWithRatio;
            this.image2 = imageUrlWithRatio2;
        }

        public /* synthetic */ SingleOrMultiImage(ImageUrlWithRatio imageUrlWithRatio, ImageUrlWithRatio imageUrlWithRatio2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                imageUrlWithRatio2 = null;
            }
            this(imageUrlWithRatio, imageUrlWithRatio2);
        }

        @NotNull
        public final ImageUrlWithRatio getImage1() {
            return this.image1;
        }

        @Nullable
        public final ImageUrlWithRatio getImage2() {
            return this.image2;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final List<SingleOrMultiImage> getEventImages() {
        return this.eventImages;
    }

    public final void setEventImages(@NotNull List<SingleOrMultiImage> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.eventImages = list;
        updateView();
    }

    public CollaborativeEventImageListView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public CollaborativeEventImageListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public CollaborativeEventImageListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.eventImages = CollectionsKt__CollectionsKt.emptyList();
        this._imageClickListener = new CollaborativeEventImageListView$_imageClickListener$1(this);
    }

    @Nullable
    public final Function2<Integer, Boolean, Unit> getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(@Nullable Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.itemClickListener = function2;
    }

    private final void updateView() {
        removeAllViews();
        int i = 0;
        for (Object next : this.eventImages) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SingleOrMultiImage singleOrMultiImage = (SingleOrMultiImage) next;
            View inflate = LayoutInflater.from(getContext()).inflate(C0013R$layout.item_single_or_multi_image, this, false);
            if (inflate != null) {
                SingleOrMultiImageView singleOrMultiImageView = (SingleOrMultiImageView) inflate;
                singleOrMultiImageView.getImageView1().setOnClickListener(this._imageClickListener);
                singleOrMultiImageView.getImageView1().setExtraData(new Pair(Integer.valueOf(i), Boolean.valueOf(false)));
                Glide.with((View) this).load(singleOrMultiImage.getImage1().getUrl()).into((ImageView) singleOrMultiImageView.getImageView1());
                if (singleOrMultiImage.getImage2() != null) {
                    singleOrMultiImageView.getImageView2().setOnClickListener(this._imageClickListener);
                    singleOrMultiImageView.getImageView2().setExtraData(new Pair(Integer.valueOf(i), Boolean.valueOf(true)));
                    Intrinsics.checkExpressionValueIsNotNull(Glide.with((View) this).load(singleOrMultiImage.getImage2().getUrl()).into((ImageView) singleOrMultiImageView.getImageView2()), "Glide.with(this).load(si…ultiImageView.imageView2)");
                } else {
                    singleOrMultiImageView.getImageView2().setVisibility(8);
                }
                singleOrMultiImageView.setImageRatio(singleOrMultiImage.getImage1().getRatio());
                addView(singleOrMultiImageView);
                i = i2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.event.SingleOrMultiImageView");
            }
        }
    }
}
