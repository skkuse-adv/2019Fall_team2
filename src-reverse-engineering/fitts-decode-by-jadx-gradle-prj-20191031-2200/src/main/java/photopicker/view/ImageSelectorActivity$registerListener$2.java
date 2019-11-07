package photopicker.view;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.orhanobut.logger.Logger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.utils.DataHolderManager;
import org.jetbrains.annotations.NotNull;
import photopicker.adapter.ImageListAdapter;
import photopicker.adapter.ImageListAdapter.OnImageSelectChangedListener;
import photopicker.model.LocalMedia;
import photopicker.view.ImagePreviewActivity.Companion;

public final class ImageSelectorActivity$registerListener$2 implements OnImageSelectChangedListener {
    final /* synthetic */ ImageSelectorActivity this$0;

    ImageSelectorActivity$registerListener$2(ImageSelectorActivity imageSelectorActivity) {
        this.this$0 = imageSelectorActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onShouldStopChangeList(@org.jetbrains.annotations.NotNull photopicker.adapter.ImageListAdapter.ViewHolder r6, @org.jetbrains.annotations.NotNull photopicker.model.LocalMedia r7) {
        /*
            r5 = this;
            java.lang.String r0 = "contentHolder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "image"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            photopicker.view.ImageSelectorActivity r0 = r5.this$0
            java.lang.Integer r0 = r0.selectType
            photopicker.view.ImageSelectorActivity$Companion r1 = photopicker.view.ImageSelectorActivity.Companion
            int r1 = r1.getTYPE_POST_DETAIL()
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001c
            goto L_0x01d9
        L_0x001c:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x01d9
            photopicker.view.ImageSelectorActivity r0 = r5.this$0
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            java.lang.String r1 = "PreferenceManager.getDef…ltSharedPreferences(this)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            photopicker.view.ImageSelectorActivity$Companion r4 = photopicker.view.ImageSelectorActivity.Companion
            java.lang.String r4 = r4.getPREF_SHOWED_DETAIL_IMAGE_GUIDE()
            boolean r0 = r0.getBoolean(r4, r2)
            if (r0 != 0) goto L_0x01d9
            photopicker.view.ImageSelectorActivity r0 = r5.this$0
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            photopicker.view.ImageSelectorActivity$Companion r1 = photopicker.view.ImageSelectorActivity.Companion
            java.lang.String r1 = r1.getPREF_SHOWED_DETAIL_IMAGE_GUIDE()
            android.content.SharedPreferences$Editor r0 = r0.putBoolean(r1, r3)
            r0.apply()
            kr.co.popone.fitts.ui.DialogExtensions r0 = kr.co.popone.fitts.ui.DialogExtensions.INSTANCE
            photopicker.view.ImageSelectorActivity r1 = r5.this$0
            r2 = 2131558554(0x7f0d009a, float:1.8742427E38)
            android.app.Dialog r0 = r0.buildDialog(r1, r2)
            r1 = 2131362077(0x7f0a011d, float:1.8343924E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            photopicker.view.ImageSelectorActivity$registerListener$2$onShouldStopChangeList$1 r2 = new photopicker.view.ImageSelectorActivity$registerListener$2$onShouldStopChangeList$1
            r2.<init>(r5, r6, r7, r0)
            r1.setOnClickListener(r2)
            r6 = 2131362603(0x7f0a032b, float:1.8344991E38)
            android.view.View r6 = r0.findViewById(r6)
            android.widget.Button r6 = (android.widget.Button) r6
            photopicker.view.ImageSelectorActivity$registerListener$2$onShouldStopChangeList$2 r7 = new photopicker.view.ImageSelectorActivity$registerListener$2$onShouldStopChangeList$2
            r7.<init>(r0)
            r6.setOnClickListener(r7)
            r6 = 2131362454(0x7f0a0296, float:1.834469E38)
            android.view.View r6 = r0.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            r1 = 2
            if (r7 != 0) goto L_0x0093
            goto L_0x009f
        L_0x0093:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r3) goto L_0x00a7
            if (r7 == r1) goto L_0x00a3
        L_0x009f:
            r7 = 2131231256(0x7f080218, float:1.8078588E38)
            goto L_0x00aa
        L_0x00a3:
            r7 = 2131231102(0x7f08017e, float:1.8078276E38)
            goto L_0x00aa
        L_0x00a7:
            r7 = 2131231093(0x7f080175, float:1.8078257E38)
        L_0x00aa:
            r6.setImageResource(r7)
            r6 = 2131362814(0x7f0a03fe, float:1.834542E38)
            android.view.View r6 = r0.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x00bf
            goto L_0x00cb
        L_0x00bf:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$1
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r3) goto L_0x00d3
            if (r7 == r1) goto L_0x00cf
        L_0x00cb:
            r7 = 2131231258(0x7f08021a, float:1.8078592E38)
            goto L_0x00d6
        L_0x00cf:
            r7 = 2131231103(0x7f08017f, float:1.8078278E38)
            goto L_0x00d6
        L_0x00d3:
            r7 = 2131231094(0x7f080176, float:1.807826E38)
        L_0x00d6:
            r6.setImageResource(r7)
            r6 = 2131362455(0x7f0a0297, float:1.8344691E38)
            android.view.View r6 = r0.findViewById(r6)
            java.lang.String r7 = "dialog.findViewById<Text…ew>(R.id.leftTopTextView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x00f0
            goto L_0x00f8
        L_0x00f0:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$2
            int r7 = r7.ordinal()
            r7 = r2[r7]
        L_0x00f8:
            java.lang.String r7 = "전신 사진"
            r6.setText(r7)
            r6 = 2131362815(0x7f0a03ff, float:1.8345421E38)
            android.view.View r6 = r0.findViewById(r6)
            java.lang.String r7 = "dialog.findViewById<Text…w>(R.id.rightTopTextView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x0114
            goto L_0x0120
        L_0x0114:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$3
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r3) goto L_0x0126
            if (r7 == r1) goto L_0x0123
        L_0x0120:
            java.lang.String r7 = "정면 사진"
            goto L_0x0128
        L_0x0123:
            java.lang.String r7 = "전신 측면 사진"
            goto L_0x0128
        L_0x0126:
            java.lang.String r7 = "후면 사진"
        L_0x0128:
            r6.setText(r7)
            r6 = 2131362449(0x7f0a0291, float:1.8344679E38)
            android.view.View r6 = r0.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x013d
            goto L_0x0149
        L_0x013d:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$4
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r3) goto L_0x0151
            if (r7 == r1) goto L_0x014d
        L_0x0149:
            r7 = 2131231257(0x7f080219, float:1.807859E38)
            goto L_0x0154
        L_0x014d:
            r7 = 2131231104(0x7f080180, float:1.807828E38)
            goto L_0x0154
        L_0x0151:
            r7 = 2131231095(0x7f080177, float:1.8078261E38)
        L_0x0154:
            r6.setImageResource(r7)
            r6 = 2131362809(0x7f0a03f9, float:1.834541E38)
            android.view.View r6 = r0.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x0169
            goto L_0x0175
        L_0x0169:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$5
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r3) goto L_0x017d
            if (r7 == r1) goto L_0x0179
        L_0x0175:
            r7 = 2131231255(0x7f080217, float:1.8078586E38)
            goto L_0x0180
        L_0x0179:
            r7 = 2131231105(0x7f080181, float:1.8078282E38)
            goto L_0x0180
        L_0x017d:
            r7 = 2131231096(0x7f080178, float:1.8078263E38)
        L_0x0180:
            r6.setImageResource(r7)
            r6 = 2131362450(0x7f0a0292, float:1.834468E38)
            android.view.View r6 = r0.findViewById(r6)
            java.lang.String r7 = "dialog.findViewById<Text…(R.id.leftBottomTextView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x019a
            goto L_0x01a6
        L_0x019a:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$6
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r3) goto L_0x01ac
            if (r7 == r1) goto L_0x01a9
        L_0x01a6:
            java.lang.String r7 = "측/후면 사진"
            goto L_0x01ae
        L_0x01a9:
            java.lang.String r7 = "하반신 사진"
            goto L_0x01ae
        L_0x01ac:
            java.lang.String r7 = "내부 사진"
        L_0x01ae:
            r6.setText(r7)
            r6 = 2131362810(0x7f0a03fa, float:1.8345411E38)
            android.view.View r6 = r0.findViewById(r6)
            java.lang.String r7 = "dialog.findViewById<Text…R.id.rightBottomTextView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            photopicker.view.ImageSelectorActivity r7 = r5.this$0
            kr.co.popone.fitts.feature.post.PostType r7 = r7.postType
            if (r7 != 0) goto L_0x01c8
            goto L_0x01d0
        L_0x01c8:
            int[] r2 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$7
            int r7 = r7.ordinal()
            r7 = r2[r7]
        L_0x01d0:
            java.lang.String r7 = "디테일 사진"
            r6.setText(r7)
            r0.show()
            r2 = 1
        L_0x01d9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: photopicker.view.ImageSelectorActivity$registerListener$2.onShouldStopChangeList(photopicker.adapter.ImageListAdapter$ViewHolder, photopicker.model.LocalMedia):boolean");
    }

    public void onChange(@NotNull List<LocalMedia> list) {
        Intrinsics.checkParameterIsNotNull(list, "selectImages");
        StringBuilder sb = new StringBuilder();
        sb.append("(selectImages: ");
        sb.append(list);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
    }

    public void onPictureClick(@NotNull LocalMedia localMedia, int i) {
        Intrinsics.checkParameterIsNotNull(localMedia, MessengerShareContentUtility.TEMPLATE_MEDIA_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("(media: ");
        sb.append(localMedia);
        sb.append(", position: ");
        sb.append(i);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        DataHolderManager dataHolderManager = this.this$0.getDataHolderManager();
        String extra_preview_list = ImagePreviewActivity.Companion.getEXTRA_PREVIEW_LIST();
        ImageListAdapter access$getImageAdapter$p = this.this$0.imageAdapter;
        if (access$getImageAdapter$p == null) {
            Intrinsics.throwNpe();
        }
        dataHolderManager.putListData(extra_preview_list, access$getImageAdapter$p.getImages());
        DataHolderManager dataHolderManager2 = this.this$0.getDataHolderManager();
        String extra_preview_select_list = ImagePreviewActivity.Companion.getEXTRA_PREVIEW_SELECT_LIST();
        ImageListAdapter access$getImageAdapter$p2 = this.this$0.imageAdapter;
        if (access$getImageAdapter$p2 == null) {
            Intrinsics.throwNpe();
        }
        dataHolderManager2.putListData(extra_preview_select_list, access$getImageAdapter$p2.getSelectedImages());
        Companion companion = ImagePreviewActivity.Companion;
        ImageSelectorActivity imageSelectorActivity = this.this$0;
        ImageListAdapter access$getImageAdapter$p3 = imageSelectorActivity.imageAdapter;
        if (access$getImageAdapter$p3 == null) {
            Intrinsics.throwNpe();
        }
        List images = access$getImageAdapter$p3.getImages();
        ImageListAdapter access$getImageAdapter$p4 = this.this$0.imageAdapter;
        if (access$getImageAdapter$p4 == null) {
            Intrinsics.throwNpe();
        }
        companion.startPreview(imageSelectorActivity, images, access$getImageAdapter$p4.getSelectedImages(), i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0147, code lost:
        if (r1 != 2) goto L_0x0149;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPictureClickDone(@org.jetbrains.annotations.NotNull photopicker.model.LocalMedia r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = "media"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "(media: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", position: "
            r0.append(r1)
            r0.append(r8)
            r8 = 41
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.orhanobut.logger.Logger.d(r8, r1)
            photopicker.view.ImageSelectorActivity r8 = r6.this$0
            java.lang.Integer r8 = r8.selectType
            photopicker.view.ImageSelectorActivity$Companion r1 = photopicker.view.ImageSelectorActivity.Companion
            int r1 = r1.getTYPE_POST_COVER()
            if (r8 != 0) goto L_0x0039
            goto L_0x0158
        L_0x0039:
            int r8 = r8.intValue()
            if (r8 != r1) goto L_0x0158
            photopicker.view.ImageSelectorActivity r8 = r6.this$0
            android.content.SharedPreferences r8 = android.preference.PreferenceManager.getDefaultSharedPreferences(r8)
            java.lang.String r1 = "PreferenceManager.getDef…ltSharedPreferences(this)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
            photopicker.view.ImageSelectorActivity$Companion r2 = photopicker.view.ImageSelectorActivity.Companion
            java.lang.String r2 = r2.getPREF_SHOWED_COVER_IMAGE_GUIDE()
            boolean r8 = r8.getBoolean(r2, r0)
            if (r8 != 0) goto L_0x0158
            photopicker.view.ImageSelectorActivity r8 = r6.this$0
            android.content.SharedPreferences r8 = android.preference.PreferenceManager.getDefaultSharedPreferences(r8)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
            android.content.SharedPreferences$Editor r8 = r8.edit()
            photopicker.view.ImageSelectorActivity$Companion r1 = photopicker.view.ImageSelectorActivity.Companion
            java.lang.String r1 = r1.getPREF_SHOWED_COVER_IMAGE_GUIDE()
            r2 = 1
            android.content.SharedPreferences$Editor r8 = r8.putBoolean(r1, r2)
            r8.apply()
            kr.co.popone.fitts.ui.DialogExtensions r8 = kr.co.popone.fitts.ui.DialogExtensions.INSTANCE
            photopicker.view.ImageSelectorActivity r1 = r6.this$0
            r3 = 2131558556(0x7f0d009c, float:1.8742431E38)
            android.app.Dialog r8 = r8.buildDialog(r1, r3)
            r1 = 2131362077(0x7f0a011d, float:1.8343924E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            photopicker.view.ImageSelectorActivity$registerListener$2$onPictureClickDone$1 r3 = new photopicker.view.ImageSelectorActivity$registerListener$2$onPictureClickDone$1
            r3.<init>(r6, r7, r8)
            r1.setOnClickListener(r3)
            r7 = 2131362603(0x7f0a032b, float:1.8344991E38)
            android.view.View r7 = r8.findViewById(r7)
            android.widget.Button r7 = (android.widget.Button) r7
            photopicker.view.ImageSelectorActivity$registerListener$2$onPictureClickDone$2 r1 = new photopicker.view.ImageSelectorActivity$registerListener$2$onPictureClickDone$2
            r1.<init>(r8)
            r7.setOnClickListener(r1)
            r7 = 2131362451(0x7f0a0293, float:1.8344683E38)
            android.view.View r7 = r8.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            photopicker.view.ImageSelectorActivity r1 = r6.this$0
            kr.co.popone.fitts.feature.post.PostType r1 = r1.postType
            r3 = 2
            if (r1 != 0) goto L_0x00b1
            goto L_0x00bd
        L_0x00b1:
            int[] r4 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$8
            int r1 = r1.ordinal()
            r1 = r4[r1]
            if (r1 == r2) goto L_0x00c5
            if (r1 == r3) goto L_0x00c1
        L_0x00bd:
            r1 = 2131231106(0x7f080182, float:1.8078284E38)
            goto L_0x00c8
        L_0x00c1:
            r1 = 2131231091(0x7f080173, float:1.8078253E38)
            goto L_0x00c8
        L_0x00c5:
            r1 = 2131231100(0x7f08017c, float:1.8078271E38)
        L_0x00c8:
            r7.setImageResource(r1)
            r7 = 2131362453(0x7f0a0295, float:1.8344687E38)
            android.view.View r7 = r8.findViewById(r7)
            java.lang.String r1 = "dialog.findViewById<TextView>(R.id.leftTextView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            android.widget.TextView r7 = (android.widget.TextView) r7
            photopicker.view.ImageSelectorActivity r1 = r6.this$0
            kr.co.popone.fitts.feature.post.PostType r1 = r1.postType
            java.lang.String r4 = "측면 사진"
            if (r1 != 0) goto L_0x00e4
            goto L_0x00f0
        L_0x00e4:
            int[] r5 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$9
            int r1 = r1.ordinal()
            r1 = r5[r1]
            if (r1 == r2) goto L_0x00f6
            if (r1 == r3) goto L_0x00f3
        L_0x00f0:
            java.lang.String r1 = "상의인 경우"
            goto L_0x00f7
        L_0x00f3:
            java.lang.String r1 = "상반신 사진"
            goto L_0x00f7
        L_0x00f6:
            r1 = r4
        L_0x00f7:
            r7.setText(r1)
            r7 = 2131362811(0x7f0a03fb, float:1.8345413E38)
            android.view.View r7 = r8.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            photopicker.view.ImageSelectorActivity r1 = r6.this$0
            kr.co.popone.fitts.feature.post.PostType r1 = r1.postType
            if (r1 != 0) goto L_0x010c
            goto L_0x0118
        L_0x010c:
            int[] r5 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$10
            int r1 = r1.ordinal()
            r1 = r5[r1]
            if (r1 == r2) goto L_0x0120
            if (r1 == r3) goto L_0x011c
        L_0x0118:
            r1 = 2131231097(0x7f080179, float:1.8078265E38)
            goto L_0x0123
        L_0x011c:
            r1 = 2131231092(0x7f080174, float:1.8078255E38)
            goto L_0x0123
        L_0x0120:
            r1 = 2131231101(0x7f08017d, float:1.8078274E38)
        L_0x0123:
            r7.setImageResource(r1)
            r7 = 2131362813(0x7f0a03fd, float:1.8345417E38)
            android.view.View r7 = r8.findViewById(r7)
            java.lang.String r1 = "dialog.findViewById<TextView>(R.id.rightTextView)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            android.widget.TextView r7 = (android.widget.TextView) r7
            photopicker.view.ImageSelectorActivity r1 = r6.this$0
            kr.co.popone.fitts.feature.post.PostType r1 = r1.postType
            if (r1 != 0) goto L_0x013d
            goto L_0x0149
        L_0x013d:
            int[] r5 = photopicker.view.ImageSelectorActivity.WhenMappings.$EnumSwitchMapping$11
            int r1 = r1.ordinal()
            r1 = r5[r1]
            if (r1 == r2) goto L_0x014c
            if (r1 == r3) goto L_0x014e
        L_0x0149:
            java.lang.String r4 = "하의/원피스인 경우"
            goto L_0x014e
        L_0x014c:
            java.lang.String r4 = "정면 사진"
        L_0x014e:
            r7.setText(r4)
            r8.setCanceledOnTouchOutside(r0)
            r8.show()
            return
        L_0x0158:
            photopicker.view.ImageSelectorActivity r8 = r6.this$0
            boolean r8 = r8.enableCrop
            if (r8 == 0) goto L_0x016a
            photopicker.view.ImageSelectorActivity r8 = r6.this$0
            java.lang.String r7 = r7.getPath()
            r8.startCrop(r7)
            goto L_0x0173
        L_0x016a:
            photopicker.view.ImageSelectorActivity r8 = r6.this$0
            java.lang.String r7 = r7.getPath()
            r8.onSelectDone(r7)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: photopicker.view.ImageSelectorActivity$registerListener$2.onPictureClickDone(photopicker.model.LocalMedia, int):void");
    }
}
