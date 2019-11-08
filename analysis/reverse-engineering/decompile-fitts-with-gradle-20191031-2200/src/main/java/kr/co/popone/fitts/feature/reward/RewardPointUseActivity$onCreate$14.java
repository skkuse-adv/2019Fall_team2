package kr.co.popone.fitts.feature.reward;

import android.view.View.OnClickListener;

final class RewardPointUseActivity$onCreate$14 implements OnClickListener {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$14(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            r2 = 1
            r1.element = r2
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            r4 = 2131099765(0x7f060075, float:1.7811892E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r4 = r0.this$0
            r5 = 2131099811(0x7f0600a3, float:1.7811986E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity$onCreate$14$colorWithValidation$1 r5 = new kr.co.popone.fitts.feature.reward.RewardPointUseActivity$onCreate$14$colorWithValidation$1
            r5.<init>(r3, r1, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.productDetailPageLinkEditText
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "productDetailPageLinkEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r7 = r3.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.productLinkAddressLabel
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "productLinkAddressLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r7.length()
            r15 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            if (r4 <= 0) goto L_0x0054
            r4 = 1
            goto L_0x0055
        L_0x0054:
            r4 = 0
        L_0x0055:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r8 = r0.this$0
            int r9 = kr.co.popone.fitts.C0010R$id.productDetailPageLinkEditText
            android.view.View r8 = r8._$_findCachedViewById(r9)
            android.widget.EditText r8 = (android.widget.EditText) r8
            java.lang.Object r4 = r5.invoke(r4, r8)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.productColorEditText
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "productColorEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r8 = r3.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.productSizeEditText
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "productSizeEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r9 = r3.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.productOptionTextView
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "productOptionTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r8.length()
            if (r4 <= 0) goto L_0x00b5
            r4 = 1
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            if (r4 == 0) goto L_0x00c5
            int r4 = r9.length()
            if (r4 <= 0) goto L_0x00c0
            r4 = 1
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            if (r4 == 0) goto L_0x00c5
            r4 = 1
            goto L_0x00c6
        L_0x00c5:
            r4 = 0
        L_0x00c6:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r10 = r0.this$0
            int r11 = kr.co.popone.fitts.C0010R$id.productColorEditText
            android.view.View r10 = r10._$_findCachedViewById(r11)
            android.widget.EditText r10 = (android.widget.EditText) r10
            java.lang.Object r4 = r5.invoke(r4, r10)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            io.reactivex.subjects.BehaviorSubject r3 = r3.productPriceSubject
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r3 = r6
        L_0x00f1:
            java.lang.String r4 = "productPriceSubject.value ?: 0"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r10 = r3.intValue()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            io.reactivex.subjects.BehaviorSubject r3 = r3.shippingFeeSubject
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r3 = r6
        L_0x010a:
            java.lang.String r4 = "shippingFeeSubject.value ?: 0"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r11 = r3.intValue()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.totalPriceTextLabel
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "totalPriceTextLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            if (r10 <= 0) goto L_0x0128
            if (r11 < 0) goto L_0x0128
            r4 = 1
            goto L_0x0129
        L_0x0128:
            r4 = 0
        L_0x0129:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r6 = r0.this$0
            int r12 = kr.co.popone.fitts.C0010R$id.productPriceEditText
            android.view.View r6 = r6._$_findCachedViewById(r12)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.Object r4 = r5.invoke(r4, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shippingPersonEditText
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "shippingPersonEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r12 = r3.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shippingPersonLabel
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "shippingPersonLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r12.length()
            if (r4 <= 0) goto L_0x0172
            r4 = 1
            goto L_0x0173
        L_0x0172:
            r4 = 0
        L_0x0173:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r6 = r0.this$0
            int r13 = kr.co.popone.fitts.C0010R$id.shippingPersonEditText
            android.view.View r6 = r6._$_findCachedViewById(r13)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.Object r4 = r5.invoke(r4, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shippingContactEditText
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "shippingContactEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r13 = r3.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shippingContactLabel
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "shippingContactLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r13.length()
            if (r4 <= 0) goto L_0x01bc
            r4 = 1
            goto L_0x01bd
        L_0x01bc:
            r4 = 0
        L_0x01bd:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r6 = r0.this$0
            int r14 = kr.co.popone.fitts.C0010R$id.shippingContactEditText
            android.view.View r6 = r6._$_findCachedViewById(r14)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.Object r4 = r5.invoke(r4, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            io.reactivex.subjects.BehaviorSubject r3 = r3.shippingZipCodeSubject
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x01e7
            goto L_0x01e9
        L_0x01e7:
            java.lang.String r3 = ""
        L_0x01e9:
            r14 = r3
            java.lang.String r3 = "shippingZipCodeSubject.value ?: \"\""
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r3)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.address1EditText
            android.view.View r3 = r3._$_findCachedViewById(r4)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "address1EditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r4 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.address2EditText
            android.view.View r4 = r4._$_findCachedViewById(r6)
            android.widget.EditText r4 = (android.widget.EditText) r4
            java.lang.String r6 = "address2EditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            android.text.Editable r4 = r4.getText()
            java.lang.String r16 = r4.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r4 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.shippingAddressLabel
            android.view.View r4 = r4._$_findCachedViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = "shippingAddressLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            int r6 = r14.length()
            if (r6 <= 0) goto L_0x0234
            r6 = 1
            goto L_0x0235
        L_0x0234:
            r6 = 0
        L_0x0235:
            if (r6 == 0) goto L_0x024f
            int r6 = r3.length()
            if (r6 <= 0) goto L_0x023f
            r6 = 1
            goto L_0x0240
        L_0x023f:
            r6 = 0
        L_0x0240:
            if (r6 == 0) goto L_0x024f
            int r6 = r16.length()
            if (r6 <= 0) goto L_0x024a
            r6 = 1
            goto L_0x024b
        L_0x024a:
            r6 = 0
        L_0x024b:
            if (r6 == 0) goto L_0x024f
            r6 = 1
            goto L_0x0250
        L_0x024f:
            r6 = 0
        L_0x0250:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r2 = r0.this$0
            int r15 = kr.co.popone.fitts.C0010R$id.address2EditText
            android.view.View r2 = r2._$_findCachedViewById(r15)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.Object r2 = r5.invoke(r6, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r4, r2)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r2 = r0.this$0
            int r4 = kr.co.popone.fitts.C0010R$id.shippingMemoEditText
            android.view.View r2 = r2._$_findCachedViewById(r4)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r4 = "shippingMemoEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r4 = r0.this$0
            int r6 = kr.co.popone.fitts.C0010R$id.shippingMemoLabel
            android.view.View r4 = r4._$_findCachedViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = "shippingMemoLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            int r6 = r2.length()
            r15 = 50
            if (r6 > r15) goto L_0x029b
            r6 = 1
            goto L_0x029c
        L_0x029b:
            r6 = 0
        L_0x029c:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r15 = r0.this$0
            r19 = r2
            int r2 = kr.co.popone.fitts.C0010R$id.shippingMemoEditText
            android.view.View r2 = r15._$_findCachedViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.Object r2 = r5.invoke(r6, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r4, r2)
            boolean r1 = r1.element
            if (r1 != 0) goto L_0x02be
            return
        L_0x02be:
            android.content.Intent r1 = new android.content.Intent
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r2 = r0.this$0
            java.lang.Class<kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity> r4 = kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity.class
            r1.<init>(r2, r4)
            kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity$Parameters r2 = new kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity$Parameters
            r6 = r2
            r4 = 0
            r15 = r3
            r17 = r19
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "confirmParameters "
            r3.append(r5)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.orhanobut.logger.Logger.d(r3, r4)
            java.lang.String r3 = "paremeters"
            r1.putExtra(r3, r2)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r2 = r0.this$0
            r3 = 2130771996(0x7f01001c, float:1.7147098E38)
            r4 = 2130771988(0x7f010014, float:1.7147082E38)
            androidx.core.app.ActivityOptionsCompat r2 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r2, r3, r4)
            java.lang.String r3 = "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            kr.co.popone.fitts.feature.reward.RewardPointUseActivity r3 = r0.this$0
            r4 = 300(0x12c, float:4.2E-43)
            android.os.Bundle r2 = r2.toBundle()
            androidx.core.app.ActivityCompat.startActivityForResult(r3, r1, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.reward.RewardPointUseActivity$onCreate$14.onClick(android.view.View):void");
    }
}
