package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;

final class PostViewDataExtensionKt$isAboutSizeValidate$1<T, R> implements Function<T, R> {
    final /* synthetic */ PostViewData $this_isAboutSizeValidate;

    PostViewDataExtensionKt$isAboutSizeValidate$1(PostViewData postViewData) {
        this.$this_isAboutSizeValidate = postViewData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        if (r2 == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r2.equals("shoes") != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r2.equals("SHOES") != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1.$this_isAboutSizeValidate.getAboutSize()) == null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (java.lang.Integer.parseInt(r1.$this_isAboutSizeValidate.getAboutSize()) <= 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (java.lang.Integer.parseInt(r1.$this_isAboutSizeValidate.getAboutSize()) > 300) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.VALID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.INVALID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.VALID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.VALID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.INVALID;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r2.equals("CLOTHES") != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r2.equals("clothes") != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r1.$this_isAboutSizeValidate.getAboutSize().length() != 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        r2 = false;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor apply(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            int r0 = r2.hashCode()
            switch(r0) {
                case 78875336: goto L_0x003e;
                case 109413096: goto L_0x0035;
                case 866569288: goto L_0x0016;
                case 1584551976: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0072
        L_0x000d:
            java.lang.String r0 = "CLOTHES"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0072
            goto L_0x001e
        L_0x0016:
            java.lang.String r0 = "clothes"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0072
        L_0x001e:
            kr.co.popone.fitts.model.post.PostViewData r2 = r1.$this_isAboutSizeValidate
            java.lang.String r2 = r2.getAboutSize()
            int r2 = r2.length()
            if (r2 != 0) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel$ValidationTextColor r2 = kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.INVALID
            goto L_0x0074
        L_0x0032:
            kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel$ValidationTextColor r2 = kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.VALID
            goto L_0x0074
        L_0x0035:
            java.lang.String r0 = "shoes"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0072
            goto L_0x0046
        L_0x003e:
            java.lang.String r0 = "SHOES"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0072
        L_0x0046:
            kr.co.popone.fitts.model.post.PostViewData r2 = r1.$this_isAboutSizeValidate
            java.lang.String r2 = r2.getAboutSize()
            java.lang.Integer r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x006f
            kr.co.popone.fitts.model.post.PostViewData r2 = r1.$this_isAboutSizeValidate
            java.lang.String r2 = r2.getAboutSize()
            int r2 = java.lang.Integer.parseInt(r2)
            if (r2 <= 0) goto L_0x006f
            kr.co.popone.fitts.model.post.PostViewData r2 = r1.$this_isAboutSizeValidate
            java.lang.String r2 = r2.getAboutSize()
            int r2 = java.lang.Integer.parseInt(r2)
            r0 = 300(0x12c, float:4.2E-43)
            if (r2 > r0) goto L_0x006f
            kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel$ValidationTextColor r2 = kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.VALID
            goto L_0x0074
        L_0x006f:
            kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel$ValidationTextColor r2 = kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.INVALID
            goto L_0x0074
        L_0x0072:
            kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel$ValidationTextColor r2 = kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor.VALID
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostViewDataExtensionKt$isAboutSizeValidate$1.apply(java.lang.String):kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel$ValidationTextColor");
    }
}
