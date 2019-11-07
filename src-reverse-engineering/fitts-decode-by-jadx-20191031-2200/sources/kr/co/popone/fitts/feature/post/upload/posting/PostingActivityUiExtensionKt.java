package kr.co.popone.fitts.feature.post.upload.posting;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import org.jetbrains.annotations.NotNull;

public final class PostingActivityUiExtensionKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$10 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$7 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$8 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$9 = new int[PostType.values().length];

        static {
            $EnumSwitchMapping$0[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$0[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$0[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$1[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$1[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$1[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$2[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$2[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$2[PostType.BAG.ordinal()] = 3;
            $EnumSwitchMapping$3[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$3[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$3[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$4[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$4[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$4[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$5[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$5[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$5[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$6[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$6[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$6[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$7[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$7[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$7[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$8[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$8[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$8[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$9[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$9[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$9[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$10[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$10[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$10[PostType.BAG.ordinal()] = 3;
        }
    }

    public static final void coverImageInsertButtonText(@NotNull Button button, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(button, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[postType.ordinal()];
        if (i == 1) {
            str = "옷이 가장 잘 보이는 착용 사진을 올려주세요";
        } else if (i == 2) {
            str = "가방이 가장 잘 보이는 착용 사진을 올려주세요";
        } else if (i == 3) {
            str = "신발이 가장 잘 보이는 착용 사진을 올려주세요";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        button.setText(str);
    }

    public static final void postTitleHintText(@NotNull EditText editText, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(editText, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$1[postType.ordinal()];
        if (i == 1) {
            str = "무슨 옷인가요?";
        } else if (i == 2) {
            str = "무슨 가방인가요?";
        } else if (i == 3) {
            str = "무슨 신발인가요?";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        editText.setHint(str);
    }

    public static final void detailImageLebelText(@NotNull TextView textView, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$2[postType.ordinal()];
        if (i == 1 || i == 2) {
            str = "착용 사진 추가…";
        } else if (i == 3) {
            str = "사진 추가…";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    public static final void postImageListHintText(@NotNull TextView textView, @NotNull PostType postType) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$3[postType.ordinal()];
        String str = "메인과 다른 사진 2장 이상";
        if (i == 1) {
            str = "메인과 다른 사진 1장 이상";
        } else if (!(i == 2 || i == 3)) {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    public static final void productDescErrorText(@NotNull TextView textView, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$4[postType.ordinal()];
        if (i == 1) {
            str = "50자 이상";
        } else if (i == 2 || i == 3) {
            str = "100자 이상";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    public static final void postRatingTitleText(@NotNull TextView textView, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$5[postType.ordinal()];
        if (i == 1) {
            str = "옷에 대한 만족도";
        } else if (i == 2) {
            str = "가방에 대한 만족도";
        } else if (i == 3) {
            str = "신발에 대한 만족도";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    public static final void aboutProductTitleText(@NotNull TextView textView, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$6[postType.ordinal()];
        if (i == 1) {
            str = "이 옷에 대해";
        } else if (i == 2) {
            str = "이 가방에 대해";
        } else if (i == 3) {
            str = "이 신발에 대해";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    public static final void productHintText(@NotNull EditText editText, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(editText, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$7[postType.ordinal()];
        if (i == 1) {
            str = "핏감/기장감/촉감/두께감/신축성/디테일에 대해...";
        } else if (i == 2) {
            str = "크기/수납공간/무게감/소재/마감/디테일에 대해...";
        } else if (i == 3) {
            str = "사이즈/발볼/발등/착화감/무게감/디테일에 대해...";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        editText.setHint(str);
    }

    public static final void aboutProductHintText(@NotNull TextView textView, @NotNull PostType postType) {
        String str;
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$8[postType.ordinal()];
        if (i == 1) {
            str = "핏감/기장감/촉감/두께감/신축성/디테일";
        } else if (i == 2) {
            str = "크기/수납공간/무게감/소재/마감/디테일";
        } else if (i == 3) {
            str = "사이즈/발볼/발등/착화감/무게감/디테일";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    public static final void aboutSizeHintText(@NotNull EditText editText, @NotNull PostType postType) {
        Intrinsics.checkParameterIsNotNull(editText, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$9[postType.ordinal()];
        if (i == 1) {
            editText.setHint("Free, S, M, L, 26, 27 …");
        } else if (i == 2) {
            editText.setHint("");
        } else if (i == 3) {
            editText.setHint("240, 37.5, 7 ...");
            editText.setInputType(2);
            editText.setFilters(new LengthFilter[]{new LengthFilter(3)});
        }
    }

    public static final void aboutSizeLayoutVisiblity(@NotNull View view, @NotNull PostType postType) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(postType, "type");
        int i = WhenMappings.$EnumSwitchMapping$10[postType.ordinal()];
        if (i == 1 || i == 2) {
            view.setVisibility(0);
        } else if (i == 3) {
            view.setVisibility(8);
        }
    }

    public static final void setTextColor(@NotNull TextView textView, @NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        textView.setTextColor(ContextCompat.getColor(context, i));
    }
}
