package kr.co.popone.fitts.feature.post.upload.guide;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.utils.UIExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostGuideActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_NAME = "parameters";
    private HashMap _$_findViewCache;
    private PostType postType;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        @NotNull
        private final String postTypeString;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readString());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parameters.postTypeString;
            }
            return parameters.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.postTypeString;
        }

        @NotNull
        public final Parameters copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "postTypeString");
            return new Parameters(str);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.postTypeString, (java.lang.Object) ((kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity.Parameters) r2).postTypeString) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity.Parameters
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity$Parameters r2 = (kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity.Parameters) r2
                java.lang.String r0 = r1.postTypeString
                java.lang.String r2 = r2.postTypeString
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.post.upload.guide.PostGuideActivity.Parameters.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.postTypeString;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(postTypeString=");
            sb.append(this.postTypeString);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.postTypeString);
        }

        public Parameters(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "postTypeString");
            this.postTypeString = str;
        }

        @NotNull
        public final String getPostTypeString() {
            return this.postTypeString;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PostType.values().length];

        static {
            $EnumSwitchMapping$0[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$0[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$0[PostType.BAG.ordinal()] = 3;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_postguide);
        String postTypeString = ((Parameters) getIntent().getParcelableExtra("parameters")).getPostTypeString();
        if (postTypeString != null) {
            String upperCase = postTypeString.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            this.postType = PostType.valueOf(upperCase);
            int i2 = 1125;
            PostType postType2 = this.postType;
            String str = "postType";
            if (postType2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            int i3 = postType2 == PostType.CLOTHES ? 6333 : 5073;
            if (i3 > UIExtensions.INSTANCE.getMaxTexturesSize()) {
                i3 = UIExtensions.INSTANCE.getMaxTexturesSize();
                double maxTexturesSize = (double) UIExtensions.INSTANCE.getMaxTexturesSize();
                PostType postType3 = this.postType;
                if (postType3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                double d = postType3 == PostType.CLOTHES ? 0.17764092846991947d : 0.22176227084565345d;
                Double.isNaN(maxTexturesSize);
                i2 = MathKt__MathJVMKt.roundToInt(maxTexturesSize * d);
            }
            PostType postType4 = this.postType;
            if (postType4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[postType4.ordinal()];
            if (i4 == 1) {
                i = C0008R$drawable.img_guide_clothes;
            } else if (i4 == 2) {
                i = C0008R$drawable.img_guide_shoes;
            } else if (i4 == 3) {
                i = C0008R$drawable.img_guide_bag;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Glide.with((FragmentActivity) this).load(Integer.valueOf(i)).apply(new RequestOptions().override(i2, i3)).into((ImageView) _$_findCachedViewById(C0010R$id.postGuideImageView));
            ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new PostGuideActivity$onCreate$1(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public void onBackPressed() {
        finishWithAnimation();
    }

    /* access modifiers changed from: private */
    public final void finishWithAnimation() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
