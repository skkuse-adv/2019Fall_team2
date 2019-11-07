package kr.co.popone.fitts.feature.alarm;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import de.hdodenhof.circleimageview.CircleImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0009R$font;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm.Type;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AlarmViewHolder extends BaseViewHolder {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    private final FrameLayout alarmFittieProfileFrame;
    private final CircleImageView alarmFittieProfileImageView;
    private final CircleImageView alarmFittsCoverImageView;
    private final TextView alarmMessageTextView;
    private final ImageView alarmProductImageView;
    private final TextView alarmTimeTextView;
    private final Lazy dayBoforeDateFormat$delegate = LazyKt__LazyJVMKt.lazy(AlarmViewHolder$dayBoforeDateFormat$2.INSTANCE);
    @NotNull
    private final Delegate delegate;
    private final Lazy standardDateFormat$delegate = LazyKt__LazyJVMKt.lazy(AlarmViewHolder$standardDateFormat$2.INSTANCE);

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_alarm;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlarmViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_alarm, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…tem_alarm, parent, false)");
            return new AlarmViewHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onAlarmClick(@NotNull String str, @Nullable Type type);

        void onProfileClick(@NotNull User user);
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.POST.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.LIKE.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.COMMENT.ordinal()] = 3;
            $EnumSwitchMapping$0[Type.FOLLOW.ordinal()] = 4;
            $EnumSwitchMapping$0[Type.MENTION.ordinal()] = 5;
            $EnumSwitchMapping$0[Type.POST_INVOICE.ordinal()] = 6;
            $EnumSwitchMapping$0[Type.RECOMMENDER.ordinal()] = 7;
        }
    }

    static {
        Class<AlarmViewHolder> cls = AlarmViewHolder.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "standardDateFormat", "getStandardDateFormat()Ljava/text/SimpleDateFormat;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "dayBoforeDateFormat", "getDayBoforeDateFormat()Ljava/text/SimpleDateFormat;"))};
    }

    private final SimpleDateFormat getDayBoforeDateFormat() {
        Lazy lazy = this.dayBoforeDateFormat$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (SimpleDateFormat) lazy.getValue();
    }

    private final SimpleDateFormat getStandardDateFormat() {
        Lazy lazy = this.standardDateFormat$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (SimpleDateFormat) lazy.getValue();
    }

    public AlarmViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.image_alarm_product);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "itemView.image_alarm_product");
        this.alarmProductImageView = roundImageView;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C0010R$id.profileImageFrame);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "itemView.profileImageFrame");
        this.alarmFittieProfileFrame = frameLayout;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.profile_image);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.profile_image");
        this.alarmFittieProfileImageView = circleImageView;
        CircleImageView circleImageView2 = (CircleImageView) view.findViewById(C0010R$id.profile_fitts);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView2, "itemView.profile_fitts");
        this.alarmFittsCoverImageView = circleImageView2;
        TextView textView = (TextView) view.findViewById(C0010R$id.alarm_message);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.alarm_message");
        this.alarmMessageTextView = textView;
        TextView textView2 = (TextView) view.findViewById(C0010R$id.alarm_time);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.alarm_time");
        this.alarmTimeTextView = textView2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Alarm) {
            updateView((Alarm) t);
        }
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        RequestManager with = Glide.with(view.getContext());
        with.clear((View) this.alarmProductImageView);
        with.clear((View) this.alarmFittieProfileImageView);
    }

    private final void updateView(Alarm alarm) {
        String str;
        if (alarm.getPost() != null) {
            ViewExtensionsKt.visible(this.alarmProductImageView);
        } else {
            ViewExtensionsKt.gone(this.alarmProductImageView);
        }
        ImageView imageView = this.alarmProductImageView;
        Post post = alarm.getPost();
        if (post != null) {
            Image coverImage = post.getCoverImage();
            if (coverImage != null) {
                str = coverImage.getSmall();
                ImageViewExtensionKt.loadImage(imageView, str, (int) C0008R$drawable.shop_sample1);
                if (alarm.getUser() != null || alarm.getType() == Type.FOLLOW) {
                    ViewExtensionsKt.gone(this.alarmFittieProfileFrame);
                    ViewExtensionsKt.visible(this.alarmFittsCoverImageView);
                } else {
                    ImageViewExtensionKt.loadImageAsProfile(this.alarmFittieProfileImageView, alarm.getUser().getProfileImageUrl());
                    ViewExtensionsKt.visible(this.alarmFittieProfileFrame);
                    ViewExtensionsKt.gone(this.alarmFittsCoverImageView);
                    CircleImageView circleImageView = this.alarmFittieProfileImageView;
                    boolean z = true;
                    if (!Intrinsics.areEqual((Object) alarm.getUser().getStatus(), (Object) "deactivated")) {
                        circleImageView.setBackgroundResource(C0008R$drawable.fitts_profile);
                    } else {
                        circleImageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        z = false;
                    }
                    circleImageView.setClickable(z);
                    circleImageView.setOnClickListener(new AlarmViewHolder$updateView$$inlined$with$lambda$1(alarm, this, alarm));
                }
                initAalrmMessage(alarm, alarm.getMessage());
                calculateAlarmTime(alarm.getCreatedAt());
                this.itemView.setOnClickListener(new AlarmViewHolder$updateView$$inlined$with$lambda$2(alarm, this, alarm));
            }
        }
        str = null;
        ImageViewExtensionKt.loadImage(imageView, str, (int) C0008R$drawable.shop_sample1);
        if (alarm.getUser() != null) {
        }
        ViewExtensionsKt.gone(this.alarmFittieProfileFrame);
        ViewExtensionsKt.visible(this.alarmFittsCoverImageView);
        initAalrmMessage(alarm, alarm.getMessage());
        calculateAlarmTime(alarm.getCreatedAt());
        this.itemView.setOnClickListener(new AlarmViewHolder$updateView$$inlined$with$lambda$2(alarm, this, alarm));
    }

    /* JADX WARNING: type inference failed for: r12v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r11v4, types: [android.text.SpannableStringBuilder] */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v11, types: [android.text.SpannableStringBuilder] */
    /* JADX WARNING: type inference failed for: r12v5, types: [android.text.SpannableStringBuilder] */
    /* JADX WARNING: type inference failed for: r11v18, types: [android.text.SpannableStringBuilder] */
    /* JADX WARNING: type inference failed for: r11v22, types: [android.text.SpannableStringBuilder] */
    /* JADX WARNING: type inference failed for: r11v28, types: [android.text.SpannableStringBuilder] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0061, code lost:
        if (r11 != 0) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b6, code lost:
        if (r11 != 0) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e7, code lost:
        if (r11 != 0) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x015e, code lost:
        if (r11 != 0) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0160, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0183, code lost:
        if (r11 != null) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01a6, code lost:
        if (r11 != 0) goto L_0x0160;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initAalrmMessage(kr.co.popone.fitts.model.datamodel.service.alarm.Alarm r11, java.lang.String r12) {
        /*
            r10 = this;
            android.widget.TextView r0 = r10.alarmMessageTextView
            kr.co.popone.fitts.model.datamodel.service.alarm.Alarm$Type r1 = r11.getType()
            if (r1 != 0) goto L_0x000a
            goto L_0x01a9
        L_0x000a:
            int[] r2 = kr.co.popone.fitts.feature.alarm.AlarmViewHolder.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 0
            switch(r1) {
                case 1: goto L_0x0162;
                case 2: goto L_0x0137;
                case 3: goto L_0x00ea;
                case 4: goto L_0x00ba;
                case 5: goto L_0x0071;
                case 6: goto L_0x0065;
                case 7: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x01a9
        L_0x0018:
            kr.co.popone.fitts.model.datamodel.service.alarm.Alarm$Recommend r1 = r11.getRecommend()
            if (r1 == 0) goto L_0x01a9
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r1.getRecommendee()
            if (r1 == 0) goto L_0x01a9
            kr.co.popone.fitts.model.datamodel.service.alarm.Alarm$Reward r11 = r11.getReward()
            if (r11 == 0) goto L_0x002e
            int r2 = r11.getValue()
        L_0x002e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "추천한 친구 "
            r11.append(r3)
            java.lang.String r3 = r1.getFittsID()
            r11.append(r3)
            java.lang.String r3 = "님이 첫 포스트를 작성하여 "
            r11.append(r3)
            java.lang.String r2 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r2)
            r11.append(r2)
            java.lang.String r2 = "원이 적립되었어요❣️"
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            r2 = 7
            java.lang.String r1 = r1.getFittsID()
            int r1 = r1.length()
            android.text.SpannableStringBuilder r11 = r10.mapToSpanableString(r11, r2, r1)
            if (r11 == 0) goto L_0x01a9
            goto L_0x0160
        L_0x0065:
            android.widget.FrameLayout r11 = r10.alarmFittieProfileFrame
            kr.co.popone.fitts.ui.ViewExtensionsKt.gone(r11)
            de.hdodenhof.circleimageview.CircleImageView r11 = r10.alarmFittsCoverImageView
            kr.co.popone.fitts.ui.ViewExtensionsKt.visible(r11)
            goto L_0x01a9
        L_0x0071:
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r11.getUser()
            if (r1 == 0) goto L_0x01a9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = r1.getFittsID()
            r3.append(r1)
            java.lang.String r1 = "님이 회원님을 언급했습니다 :"
            r3.append(r1)
            kr.co.popone.fitts.model.datamodel.service.post.Comment r1 = r11.getComment()
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = r1.getContent()
            goto L_0x0094
        L_0x0093:
            r1 = 0
        L_0x0094:
            r3.append(r1)
            java.lang.String r4 = r3.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = " "
            java.lang.String r6 = " "
            java.lang.String r1 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r4, r5, r6, r7, r8, r9)
            kr.co.popone.fitts.model.datamodel.service.user.User r11 = r11.getUser()
            java.lang.String r11 = r11.getFittsID()
            int r11 = r11.length()
            android.text.SpannableStringBuilder r11 = r10.mapToSpanableString(r1, r2, r11)
            if (r11 == 0) goto L_0x01a9
            goto L_0x0160
        L_0x00ba:
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r11.getUser()
            if (r1 == 0) goto L_0x01a9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            kr.co.popone.fitts.model.datamodel.service.user.User r3 = r11.getUser()
            java.lang.String r3 = r3.getFittsID()
            r1.append(r3)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            kr.co.popone.fitts.model.datamodel.service.user.User r11 = r11.getUser()
            java.lang.String r11 = r11.getFittsID()
            int r11 = r11.length()
            android.text.SpannableStringBuilder r11 = r10.mapToSpanableString(r1, r2, r11)
            if (r11 == 0) goto L_0x01a9
            goto L_0x0160
        L_0x00ea:
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r11.getUser()
            if (r1 == 0) goto L_0x01a9
            kr.co.popone.fitts.model.datamodel.service.post.Comment r1 = r11.getComment()
            if (r1 == 0) goto L_0x01a9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r11.getUser()
            java.lang.String r1 = r1.getFittsID()
            r12.append(r1)
            java.lang.String r1 = "님이 회원님의 포스트에 댓글을 남겼습니다. : "
            r12.append(r1)
            kr.co.popone.fitts.model.datamodel.service.post.Comment r1 = r11.getComment()
            java.lang.String r1 = r1.getContent()
            r12.append(r1)
            java.lang.String r3 = r12.toString()
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r4 = " "
            java.lang.String r5 = " "
            java.lang.String r12 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r3, r4, r5, r6, r7, r8)
            kr.co.popone.fitts.model.datamodel.service.user.User r11 = r11.getUser()
            java.lang.String r11 = r11.getFittsID()
            int r11 = r11.length()
            android.text.SpannableStringBuilder r12 = r10.mapToSpanableString(r12, r2, r11)
            goto L_0x01a9
        L_0x0137:
            kr.co.popone.fitts.model.datamodel.service.user.User r11 = r11.getUser()
            if (r11 == 0) goto L_0x01a9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r11.getFittsID()
            r1.append(r3)
            java.lang.String r3 = "님이 회원님의 포스트를 좋아합니다"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r11 = r11.getFittsID()
            int r11 = r11.length()
            android.text.SpannableStringBuilder r11 = r10.mapToSpanableString(r1, r2, r11)
            if (r11 == 0) goto L_0x01a9
        L_0x0160:
            r12 = r11
            goto L_0x01a9
        L_0x0162:
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r11.getUser()
            if (r1 == 0) goto L_0x01a9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r1.getFittsID()
            r3.append(r4)
            java.lang.String r4 = "님의 새 포스트 : "
            r3.append(r4)
            kr.co.popone.fitts.model.post.PostAPI$Post r11 = r11.getPost()
            if (r11 == 0) goto L_0x0186
            java.lang.String r11 = r11.getTitle()
            if (r11 == 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            java.lang.String r11 = ""
        L_0x0188:
            r3.append(r11)
            java.lang.String r4 = r3.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = " "
            java.lang.String r6 = " "
            java.lang.String r11 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r4, r5, r6, r7, r8, r9)
            java.lang.String r1 = r1.getFittsID()
            int r1 = r1.length()
            android.text.SpannableStringBuilder r11 = r10.mapToSpanableString(r11, r2, r1)
            if (r11 == 0) goto L_0x01a9
            goto L_0x0160
        L_0x01a9:
            r0.setText(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.alarm.AlarmViewHolder.initAalrmMessage(kr.co.popone.fitts.model.datamodel.service.alarm.Alarm, java.lang.String):void");
    }

    private final SpannableStringBuilder mapToSpanableString(String str, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Typeface font = ResourcesCompat.getFont(view.getContext(), C0009R$font.proxima_nova_bold_italic);
        if (font != null) {
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", font), i, i2, 34);
            return spannableStringBuilder;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Typeface");
    }

    @SuppressLint({"SetTextI18n"})
    public final void calculateAlarmTime(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "createdAt");
        Date date = new Date(System.currentTimeMillis());
        Date parse = getStandardDateFormat().parse(str);
        long time = date.getTime();
        Intrinsics.checkExpressionValueIsNotNull(parse, "createAt");
        long time2 = time - parse.getTime();
        if (time2 < 60000) {
            this.alarmTimeTextView.setText("방금 전");
        } else if (time2 < 3600000) {
            TextView textView = this.alarmTimeTextView;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(time2 / 60000));
            sb.append("분 전");
            textView.setText(sb.toString());
        } else if (time2 < 86400000) {
            TextView textView2 = this.alarmTimeTextView;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(time2 / 3600000));
            sb2.append("시간 전");
            textView2.setText(sb2.toString());
        } else if (time2 < 604800000) {
            TextView textView3 = this.alarmTimeTextView;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(time2 / 86400000));
            sb3.append("일 전");
            textView3.setText(sb3.toString());
        } else {
            this.alarmTimeTextView.setText(getDayBoforeDateFormat().format(parse).toString());
        }
    }
}
