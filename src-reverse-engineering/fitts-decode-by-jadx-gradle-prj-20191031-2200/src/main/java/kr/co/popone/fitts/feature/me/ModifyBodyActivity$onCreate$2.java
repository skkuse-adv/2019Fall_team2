package kr.co.popone.fitts.feature.me;

import android.view.View.OnClickListener;

final class ModifyBodyActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$2(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            r1.hideKeyboard()
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            r2 = 2131099811(0x7f0600a3, float:1.7811986E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            r3 = 2131099765(0x7f060075, float:1.7811892E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            r4 = 2131099763(0x7f060073, float:1.7811888E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r4 = r0.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.bodyDescriptionLabel
            android.view.View r4 = r4._$_findCachedViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r5 = "bodyDescriptionLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r4, r2)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r4 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.body_description
            android.view.View r4 = r4._$_findCachedViewById(r6)
            android.widget.EditText r4 = (android.widget.EditText) r4
            java.lang.String r6 = "body_description"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            android.text.Editable r4 = r4.getText()
            java.lang.String r7 = "body_description.text"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r4)
            r7 = 1
            r8 = 0
            if (r4 != 0) goto L_0x007f
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r4 = r0.this$0
            int r9 = kr.co.popone.fitts.C0010R$id.body_description
            android.view.View r4 = r4._$_findCachedViewById(r9)
            android.widget.EditText r4 = (android.widget.EditText) r4
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            android.text.Editable r4 = r4.getText()
            int r4 = r4.length()
            r6 = 15
            if (r4 >= r6) goto L_0x007f
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r4 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.bodyDescriptionLabel
            android.view.View r4 = r4._$_findCachedViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r4, r1)
            r4 = 0
            goto L_0x0090
        L_0x007f:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r4 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.bodyDescriptionLabel
            android.view.View r4 = r4._$_findCachedViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r4, r2)
            r4 = 1
        L_0x0090:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r5 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.shoeSizeInputEditText
            android.view.View r5 = r5._$_findCachedViewById(r6)
            android.widget.EditText r5 = (android.widget.EditText) r5
            java.lang.String r6 = "shoeSizeInputEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.Integer r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5)
            r9 = 100
            java.lang.String r10 = "shoeSizeInputDescription"
            java.lang.String r11 = "shoeSizeInputLabel"
            if (r5 == 0) goto L_0x00eb
            int r12 = r5.intValue()
            if (r12 < r9) goto L_0x00eb
            int r12 = r5.intValue()
            r13 = 400(0x190, float:5.6E-43)
            if (r12 > r13) goto L_0x00eb
            int r5 = r5.intValue()
            int r5 = r5 % 5
            if (r5 == 0) goto L_0x00ca
            goto L_0x00eb
        L_0x00ca:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r5 = r0.this$0
            int r12 = kr.co.popone.fitts.C0010R$id.shoeSizeInputLabel
            android.view.View r5 = r5._$_findCachedViewById(r12)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r11)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r5, r2)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r5 = r0.this$0
            int r11 = kr.co.popone.fitts.C0010R$id.shoeSizeInputDescription
            android.view.View r5 = r5._$_findCachedViewById(r11)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r10)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r5, r3)
            goto L_0x010c
        L_0x00eb:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shoeSizeInputLabel
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r11)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r1)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shoeSizeInputDescription
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r10)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r1)
            r4 = 0
        L_0x010c:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.footDescriptionInputEditText
            android.view.View r3 = r3._$_findCachedViewById(r5)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r5 = "footDescriptionInputEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)
            android.text.Editable r3 = r3.getText()
            java.lang.String r10 = "footDescriptionInputEditText.text"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r10)
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r3)
            java.lang.String r10 = "footDescriptionInputLabel"
            if (r3 != 0) goto L_0x0157
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            int r11 = kr.co.popone.fitts.C0010R$id.footDescriptionInputEditText
            android.view.View r3 = r3._$_findCachedViewById(r11)
            android.widget.EditText r3 = (android.widget.EditText) r3
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)
            android.text.Editable r3 = r3.getText()
            int r3 = r3.length()
            r11 = 8
            if (r3 >= r11) goto L_0x0157
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.footDescriptionInputLabel
            android.view.View r2 = r2._$_findCachedViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r10)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r2, r1)
            r4 = 0
            goto L_0x0167
        L_0x0157:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.footDescriptionInputLabel
            android.view.View r1 = r1._$_findCachedViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r1, r2)
        L_0x0167:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.profile_height
            android.view.View r1 = r1._$_findCachedViewById(r2)
            android.widget.EditText r1 = (android.widget.EditText) r1
            java.lang.String r2 = "profile_height"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0186
            r1 = 1
            goto L_0x0187
        L_0x0186:
            r1 = 0
        L_0x0187:
            if (r1 != 0) goto L_0x02d1
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.profile_height
            android.view.View r1 = r1._$_findCachedViewById(r3)
            android.widget.EditText r1 = (android.widget.EditText) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 >= r9) goto L_0x01a6
            goto L_0x02d1
        L_0x01a6:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.profile_weight
            android.view.View r1 = r1._$_findCachedViewById(r2)
            android.widget.EditText r1 = (android.widget.EditText) r1
            java.lang.String r2 = "profile_weight"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01c4
            goto L_0x01c5
        L_0x01c4:
            r7 = 0
        L_0x01c5:
            if (r7 != 0) goto L_0x02c7
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.profile_weight
            android.view.View r1 = r1._$_findCachedViewById(r3)
            android.widget.EditText r1 = (android.widget.EditText) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            r2 = 10
            if (r1 >= r2) goto L_0x01e6
            goto L_0x02c7
        L_0x01e6:
            if (r4 == 0) goto L_0x02da
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "TestBug::"
            r1.append(r2)
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            kr.co.popone.fitts.feature.me.ModifyBodyActivity$BodyData r3 = r3.getBodyInfo()
            java.lang.String r2 = r2.toJson(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r8]
            com.orhanobut.logger.Logger.d(r1, r2)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.modify_button
            android.view.View r1 = r1._$_findCachedViewById(r2)
            android.widget.Button r1 = (android.widget.Button) r1
            java.lang.String r2 = "modify_button"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setEnabled(r8)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            io.reactivex.disposables.Disposable r1 = r1.setUserInfoRequest
            if (r1 == 0) goto L_0x022a
            r1.dispose()
        L_0x022a:
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r1 = r0.this$0
            kr.co.popone.fitts.model.user.UserAPI r7 = r1.getUserAPI$app_productionFittsRelease()
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r3 = r0.this$0
            kr.co.popone.fitts.feature.me.ModifyBodyActivity$BodyData r3 = r3.getBodyInfo()
            java.lang.String r8 = r2.toJson(r3)
            r9 = 0
            r10 = 0
            r11 = 0
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.topClothingSizeTextView
            android.view.View r2 = r2._$_findCachedViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "topClothingSizeTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r12 = r2.toString()
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.bottomClothingSizeTextView
            android.view.View r2 = r2._$_findCachedViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "bottomClothingSizeTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r13 = r2.toString()
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.shoeSizeInputEditText
            android.view.View r2 = r2._$_findCachedViewById(r3)
            android.widget.EditText r2 = (android.widget.EditText) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            int r3 = kr.co.popone.fitts.C0010R$id.footDescriptionInputEditText
            android.view.View r2 = r2._$_findCachedViewById(r3)
            android.widget.EditText r2 = (android.widget.EditText) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            android.text.Editable r2 = r2.getText()
            java.lang.String r15 = r2.toString()
            r16 = 14
            r17 = 0
            io.reactivex.Single r2 = kr.co.popone.fitts.model.user.UserAPI.DefaultImpls.setUserInfo$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            io.reactivex.Scheduler r3 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r2 = r2.subscribeOn(r3)
            io.reactivex.Scheduler r3 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r2 = r2.observeOn(r3)
            kr.co.popone.fitts.feature.me.ModifyBodyActivity$onCreate$2$1 r3 = new kr.co.popone.fitts.feature.me.ModifyBodyActivity$onCreate$2$1
            r3.<init>(r0)
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r3)
            r1.setUserInfoRequest = r2
            goto L_0x02da
        L_0x02c7:
            kr.co.popone.fitts.utils.Snackbar$Companion r1 = kr.co.popone.fitts.utils.Snackbar.Companion
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            java.lang.String r3 = "몸무게를 10 이상의 값으로 넣어주세요"
            r1.showMessage(r2, r3)
            goto L_0x02da
        L_0x02d1:
            kr.co.popone.fitts.utils.Snackbar$Companion r1 = kr.co.popone.fitts.utils.Snackbar.Companion
            kr.co.popone.fitts.feature.me.ModifyBodyActivity r2 = r0.this$0
            java.lang.String r3 = "키를 100 이상의 값으로 넣어주세요"
            r1.showMessage(r2, r3)
        L_0x02da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.me.ModifyBodyActivity$onCreate$2.onClick(android.view.View):void");
    }
}
